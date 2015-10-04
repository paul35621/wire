// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ../wire-runtime/src/test/proto/one_of.proto at 20:1
package com.squareup.wire.protos.oneof;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class OneOfMessage extends Message<OneOfMessage, OneOfMessage.Builder> {
  public static final ProtoAdapter<OneOfMessage> ADAPTER = new ProtoAdapter<OneOfMessage>(FieldEncoding.LENGTH_DELIMITED, OneOfMessage.class) {
    @Override
    public int encodedSize(OneOfMessage value) {
      return (value.foo != null ? ProtoAdapter.INT32.encodedSize(1, value.foo) : 0)
          + (value.bar != null ? ProtoAdapter.STRING.encodedSize(3, value.bar) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, OneOfMessage value) throws IOException {
      if (value.foo != null) ProtoAdapter.INT32.encodeTagged(writer, 1, value.foo);
      if (value.bar != null) ProtoAdapter.STRING.encodeTagged(writer, 3, value.bar);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public OneOfMessage decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.foo(ProtoAdapter.INT32.decode(reader)); break;
          case 3: builder.bar(ProtoAdapter.STRING.decode(reader)); break;
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
    public OneOfMessage redact(OneOfMessage value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  };

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_FOO = 0;

  public static final String DEFAULT_BAR = "";

  /**
   * What foo.
   */
  public final Integer foo;

  /**
   * Such bar.
   */
  public final String bar;

  public OneOfMessage(Integer foo, String bar) {
    this(foo, bar, ByteString.EMPTY);
  }

  public OneOfMessage(Integer foo, String bar, ByteString unknownFields) {
    super(unknownFields);
    this.foo = foo;
    this.bar = bar;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.foo = foo;
    builder.bar = bar;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof OneOfMessage)) return false;
    OneOfMessage o = (OneOfMessage) other;
    return equals(unknownFields(), o.unknownFields())
        && equals(foo, o.foo)
        && equals(bar, o.bar);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (foo != null ? foo.hashCode() : 0);
      result = result * 37 + (bar != null ? bar.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (foo != null) builder.append(", foo=").append(foo);
    if (bar != null) builder.append(", bar=").append(bar);
    return builder.replace(0, 2, "OneOfMessage{").append('}').toString();
  }

  public static final class Builder extends com.squareup.wire.Message.Builder<OneOfMessage, Builder> {
    public Integer foo;

    public String bar;

    public Builder() {
    }

    /**
     * What foo.
     */
    public Builder foo(Integer foo) {
      this.foo = foo;
      this.bar = null;
      return this;
    }

    /**
     * Such bar.
     */
    public Builder bar(String bar) {
      this.bar = bar;
      this.foo = null;
      return this;
    }

    @Override
    public OneOfMessage build() {
      return new OneOfMessage(foo, bar, buildUnknownFields());
    }
  }
}
