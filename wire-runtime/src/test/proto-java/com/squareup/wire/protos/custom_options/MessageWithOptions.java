// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ../wire-runtime/src/test/proto/custom_options.proto at 84:1
package com.squareup.wire.protos.custom_options;

import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.protos.foreign.ForeignMessage;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.Arrays;
import okio.ByteString;

public final class MessageWithOptions extends Message<MessageWithOptions, MessageWithOptions.Builder> {
  public static final ProtoAdapter<MessageWithOptions> ADAPTER = new ProtoAdapter<MessageWithOptions>(FieldEncoding.LENGTH_DELIMITED, MessageWithOptions.class) {
    @Override
    public int encodedSize(MessageWithOptions value) {
      return value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, MessageWithOptions value) throws IOException {
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public MessageWithOptions decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public MessageWithOptions redact(MessageWithOptions value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  };

  private static final long serialVersionUID = 0L;

  public static final MessageOptions MESSAGE_OPTIONS = new MessageOptions.Builder()
      .my_message_option_one(new FooBar.Builder()
          .foo(1234)
          .bar("5678")
          .baz(new FooBar.Nested.Builder()
              .value(FooBar.FooBarBazEnum.BAZ)
              .build())
          .qux(-1L)
          .fred(Arrays.asList(
              123.0f,
              321.0f))
          .daisy(456.0d)
          .build())
      .my_message_option_two(91011.0f)
      .my_message_option_three(new FooBar.Builder()
          .foo(11)
          .bar("22")
          .baz(new FooBar.Nested.Builder()
              .value(FooBar.FooBarBazEnum.BAR)
              .build())
          .fred(Arrays.asList(
              444.0f,
              555.0f))
          .nested(Arrays.asList(
              new FooBar.Builder()
                  .foo(33)
                  .fred(Arrays.asList(
                      100.0f,
                      200.0f))
                  .build()))
          .build())
      .my_message_option_four(FooBar.FooBarBazEnum.FOO)
      .foreign_message_option(new ForeignMessage.Builder()
          .i(9876)
          .build())
      .my_message_option_five(new FooBar.Builder()
          .ext(FooBar.FooBarBazEnum.BAZ)
          .rep(Arrays.asList(
              FooBar.FooBarBazEnum.FOO,
              FooBar.FooBarBazEnum.BAZ))
          .build())
      .my_message_option_six(new FooBar.Builder()
          .rep(Arrays.asList(
              FooBar.FooBarBazEnum.FOO,
              FooBar.FooBarBazEnum.BAR))
          .nested(Arrays.asList(
              new FooBar.Builder()
                  .foo(44)
                  .ext(FooBar.FooBarBazEnum.BAR)
                  .build(),
              new FooBar.Builder()
                  .foo(55)
                  .build()))
          .build())
      .build();

  public MessageWithOptions() {
    this(ByteString.EMPTY);
  }

  public MessageWithOptions(ByteString unknownFields) {
    super(unknownFields);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof MessageWithOptions;
  }

  @Override
  public int hashCode() {
    return unknownFields().hashCode();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    return builder.replace(0, 2, "MessageWithOptions{").append('}').toString();
  }

  public static final class Builder extends com.squareup.wire.Message.Builder<MessageWithOptions, Builder> {
    public Builder() {
    }

    @Override
    public MessageWithOptions build() {
      return new MessageWithOptions(buildUnknownFields());
    }
  }
}
