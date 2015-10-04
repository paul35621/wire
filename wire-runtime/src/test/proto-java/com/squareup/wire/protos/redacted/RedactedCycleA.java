// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ../wire-runtime/src/test/proto/redacted_test.proto at 40:1
package com.squareup.wire.protos.redacted;

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

public final class RedactedCycleA extends Message<RedactedCycleA, RedactedCycleA.Builder> {
  public static final ProtoAdapter<RedactedCycleA> ADAPTER = new ProtoAdapter<RedactedCycleA>(FieldEncoding.LENGTH_DELIMITED, RedactedCycleA.class) {
    @Override
    public int encodedSize(RedactedCycleA value) {
      return (value.b != null ? RedactedCycleB.ADAPTER.encodedSize(1, value.b) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, RedactedCycleA value) throws IOException {
      if (value.b != null) RedactedCycleB.ADAPTER.encodeTagged(writer, 1, value.b);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public RedactedCycleA decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.b(RedactedCycleB.ADAPTER.decode(reader)); break;
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
    public RedactedCycleA redact(RedactedCycleA value) {
      Builder builder = value.newBuilder();
      if (builder.b != null) builder.b = RedactedCycleB.ADAPTER.redact(builder.b);
      builder.clearUnknownFields();
      return builder.build();
    }
  };

  private static final long serialVersionUID = 0L;

  public final RedactedCycleB b;

  public RedactedCycleA(RedactedCycleB b) {
    this(b, ByteString.EMPTY);
  }

  public RedactedCycleA(RedactedCycleB b, ByteString unknownFields) {
    super(unknownFields);
    this.b = b;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.b = b;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof RedactedCycleA)) return false;
    RedactedCycleA o = (RedactedCycleA) other;
    return equals(unknownFields(), o.unknownFields())
        && equals(b, o.b);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (b != null ? b.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (b != null) builder.append(", b=").append(b);
    return builder.replace(0, 2, "RedactedCycleA{").append('}').toString();
  }

  public static final class Builder extends com.squareup.wire.Message.Builder<RedactedCycleA, Builder> {
    public RedactedCycleB b;

    public Builder() {
    }

    public Builder b(RedactedCycleB b) {
      this.b = b;
      return this;
    }

    @Override
    public RedactedCycleA build() {
      return new RedactedCycleA(b, buildUnknownFields());
    }
  }
}
