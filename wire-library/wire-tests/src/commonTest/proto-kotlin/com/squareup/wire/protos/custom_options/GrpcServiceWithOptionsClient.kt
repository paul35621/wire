// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.custom_options.ServiceWithOptions in custom_options.proto
package com.squareup.wire.protos.custom_options

import com.squareup.wire.GrpcCall
import com.squareup.wire.GrpcClient
import com.squareup.wire.GrpcMethod

public class GrpcServiceWithOptionsClient(
  private val client: GrpcClient,
) : ServiceWithOptionsClient {
  public override fun MethodWithOptions(): GrpcCall<FooBar, FooBar> = client.newCall(GrpcMethod(
      path = "/squareup.protos.custom_options.ServiceWithOptions/MethodWithOptions",
      requestAdapter = FooBar.ADAPTER,
      responseAdapter = FooBar.ADAPTER
  ))
}
