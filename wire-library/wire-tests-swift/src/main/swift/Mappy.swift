// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.squareup.wire.protos.kotlin.map.Mappy in map.proto
import Foundation
import Wire

public struct Mappy {

    public var things: [String : Thing]
    public var unknownFields: Data = .init()

    public init(things: [String : Thing] = [:]) {
        self.things = things
    }

}

extension Mappy : Equatable {
}

extension Mappy : Hashable {
}

extension Mappy : Proto2Codable {
    public init(from reader: ProtoReader) throws {
        var things: [String : Thing] = [:]

        let token = try reader.beginMessage()
        while let tag = try reader.nextTag(token: token) {
            switch tag {
            case 1: try reader.decode(into: &things)
            default: try reader.readUnknownField(tag: tag)
            }
        }
        self.unknownFields = try reader.endMessage(token: token)

        self.things = try Mappy.checkIfMissing(things, "things")
    }

    public func encode(to writer: ProtoWriter) throws {
        try writer.encode(tag: 1, value: self.things)
        try writer.writeUnknownFields(unknownFields)
    }
}

extension Mappy : Codable {
    public enum CodingKeys : String, CodingKey {

        case things

    }
}
