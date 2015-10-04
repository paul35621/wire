// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ../wire-runtime/src/test/proto/service_root.proto at 6:1
package com.squareup.wire.protos.roots;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class TheResponse extends Message<TheResponse, TheResponse.Builder> {
  public static final ProtoAdapter<TheResponse> ADAPTER = new ProtoAdapter<TheResponse>(FieldEncoding.LENGTH_DELIMITED, TheResponse.class) {
    @Override
    public int encodedSize(TheResponse value) {
      return value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, TheResponse value) throws IOException {
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public TheResponse decode(ProtoReader reader) throws IOException {
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
    public TheResponse redact(TheResponse value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  };

  private static final long serialVersionUID = 0L;

  public TheResponse() {
    this(ByteString.EMPTY);
  }

  public TheResponse(ByteString unknownFields) {
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
    return other instanceof TheResponse;
  }

  @Override
  public int hashCode() {
    return unknownFields().hashCode();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    return builder.replace(0, 2, "TheResponse{").append('}').toString();
  }

  public static final class Builder extends com.squareup.wire.Message.Builder<TheResponse, Builder> {
    public Builder() {
    }

    @Override
    public TheResponse build() {
      return new TheResponse(buildUnknownFields());
    }
  }
}
