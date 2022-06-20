// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.kotlin.MessageWithStatus in same_name_enum.proto
package com.squareup.wire.protos.kotlin

import com.squareup.wire.EnumAdapter
import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.WireEnum
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import okio.ByteString

public class MessageWithStatus(
  unknownFields: ByteString = ByteString.EMPTY,
) : Message<MessageWithStatus, MessageWithStatus.Builder>(ADAPTER, unknownFields) {
  public override fun newBuilder(): Builder {
    val builder = Builder()
    builder.addUnknownFields(unknownFields)
    return builder
  }

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is MessageWithStatus) return false
    if (unknownFields != other.unknownFields) return false
    return true
  }

  public override fun hashCode(): Int = unknownFields.hashCode()

  public override fun toString(): String = "MessageWithStatus{}"

  public fun copy(unknownFields: ByteString = this.unknownFields): MessageWithStatus =
      MessageWithStatus(unknownFields)

  public class Builder : Message.Builder<MessageWithStatus, Builder>() {
    public override fun build(): MessageWithStatus = MessageWithStatus(
      unknownFields = buildUnknownFields()
    )
  }

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<MessageWithStatus> = object : ProtoAdapter<MessageWithStatus>(
      FieldEncoding.LENGTH_DELIMITED, 
      MessageWithStatus::class, 
      "type.googleapis.com/squareup.protos.kotlin.MessageWithStatus", 
      PROTO_2, 
      null, 
      "same_name_enum.proto"
    ) {
      public override fun encodedSize(`value`: MessageWithStatus): Int {
        var size = value.unknownFields.size
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: MessageWithStatus): Unit {
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: MessageWithStatus): Unit {
        writer.writeBytes(value.unknownFields)
      }

      public override fun decode(reader: ProtoReader): MessageWithStatus {
        val unknownFields = reader.forEachTag(reader::readUnknownField)
        return MessageWithStatus(
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: MessageWithStatus): MessageWithStatus = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }

  public enum class Status(
    public override val `value`: Int,
  ) : WireEnum {
    A(1),
    ;

    public companion object {
      @JvmField
      public val ADAPTER: ProtoAdapter<Status> = object : EnumAdapter<Status>(
        Status::class, 
        PROTO_2, 
        null
      ) {
        public override fun fromValue(`value`: Int): Status? = Status.fromValue(value)
      }

      @JvmStatic
      public fun fromValue(`value`: Int): Status? = when (value) {
        1 -> A
        else -> null
      }
    }
  }
}
