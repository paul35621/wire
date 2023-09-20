/*
 * Copyright (C) 2022 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire

import assertk.assertThat
import assertk.assertions.containsExactlyInAnyOrder
import assertk.assertions.isEqualTo
import com.squareup.wire.schema.Location
import com.squareup.wire.schema.SchemaException
import kotlin.test.Test
import kotlin.test.assertFailsWith
import okio.Path.Companion.toPath

class SchemaBuilderTest {
  @Test fun emptySchema() {
    val exception = assertFailsWith<SchemaException> {
      buildSchema {}
    }
    assertThat(exception.message).isEqualTo("no sources")
  }

  @Test fun runtimeProtosAreLoadedOnTheJvm() {
    val schema = buildSchema {
      add(
        "example1.proto".toPath(),
        """
        |syntax = "proto2";
        |
        |message A {
        |  optional B b = 1;
        |}
        |message B {
        |  optional C c = 1;
        |}
        |message C {
        |}
        |
        """.trimMargin(),
      )
      add(
        "example2.proto".toPath(),
        """
        |syntax = "proto2";
        |
        |message D {
        |}
        |
        """.trimMargin(),
      )
      // We manually add fake runtime protos to please Wire when running on a non-JVM platforms.
      // This isn't required if the code is to run on the JVM only.
      add("google/protobuf/descriptor.proto".toPath(), "")
      add("wire/extensions.proto".toPath(), "")
    }
    assertThat(schema.protoFiles.map { it.location }).containsExactlyInAnyOrder(
      Location.get("/sourcePath", "example1.proto"),
      Location.get("/sourcePath", "example2.proto"),
      Location.get("/sourcePath", "google/protobuf/descriptor.proto"),
      Location.get("/sourcePath", "wire/extensions.proto"),
    )
  }
}