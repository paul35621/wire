// Code generated by Wire protocol buffer compiler, do not edit.
// Source: ModelEvaluation in resursive_map.proto
import Foundation
import Wire

/**
 * Copyright 2020 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public struct ModelEvaluation {

    public var name: String?
    public var score: Double?
    public var models: [String : ModelEvaluation]
    public var unknownFields: Data = .init()

    public init(
        name: String? = nil,
        score: Double? = nil,
        models: [String : ModelEvaluation] = [:]
    ) {
        self.name = name
        self.score = score
        self.models = models
    }

}

extension ModelEvaluation : Equatable {
}

extension ModelEvaluation : Hashable {
}

extension ModelEvaluation : Proto2Codable {
    public init(from reader: ProtoReader) throws {
        var name: String? = nil
        var score: Double? = nil
        var models: [String : ModelEvaluation] = [:]

        let token = try reader.beginMessage()
        while let tag = try reader.nextTag(token: token) {
            switch tag {
            case 1: name = try reader.decode(String.self)
            case 2: score = try reader.decode(Double.self)
            case 3: try reader.decode(into: &models)
            default: try reader.readUnknownField(tag: tag)
            }
        }
        self.unknownFields = try reader.endMessage(token: token)

        self.name = name
        self.score = score
        self.models = try ModelEvaluation.checkIfMissing(models, "models")
    }

    public func encode(to writer: ProtoWriter) throws {
        try writer.encode(tag: 1, value: self.name)
        try writer.encode(tag: 2, value: self.score)
        try writer.encode(tag: 3, value: self.models)
        try writer.writeUnknownFields(unknownFields)
    }
}

extension ModelEvaluation : Codable {
    public enum CodingKeys : String, CodingKey {

        case name
        case score
        case models

    }
}
