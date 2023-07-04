// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.kotlin.MessageWithStatus in same_name_enum.proto
import Foundation
import Wire

public struct MessageWithStatus {

    public var unknownFields: Foundation.Data = .init()

    public init() {
    }

    public enum Status : UInt32, CaseIterable, ProtoEnum {

        case A = 1

        public var description: String {
            switch self {
            case .A: return "A"
            }
        }

    }

}

#if swift(>=5.5)
extension MessageWithStatus.Status : Sendable {
}
#endif

#if !WIRE_REMOVE_EQUATABLE
extension MessageWithStatus : Equatable {
}
#endif

#if !WIRE_REMOVE_HASHABLE
extension MessageWithStatus : Hashable {
}
#endif

#if swift(>=5.5)
extension MessageWithStatus : Sendable {
}
#endif

extension MessageWithStatus : ProtoMessage {

    public static func protoMessageTypeURL() -> Swift.String {
        return "type.googleapis.com/squareup.protos.kotlin.MessageWithStatus"
    }

}

extension MessageWithStatus : Proto2Codable {

    public init(from reader: Wire.ProtoReader) throws {
        let token = try reader.beginMessage()
        while let tag = try reader.nextTag(token: token) {
            switch tag {
            default: try reader.readUnknownField(tag: tag)
            }
        }
        self.unknownFields = try reader.endMessage(token: token)

    }

    public func encode(to writer: Wire.ProtoWriter) throws {
        try writer.writeUnknownFields(unknownFields)
    }

}

#if !WIRE_REMOVE_CODABLE
extension MessageWithStatus : Codable {

    public enum CodingKeys : Swift.CodingKey {
    }

}
#endif
