// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toUnmodifiable
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = FunctionDefinition.Builder::class)
@NoAutoDetect
class FunctionDefinition
private constructor(
    private val description: JsonField<String>,
    private val name: JsonField<String>,
    private val parameters: JsonField<FunctionParameters>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /**
     * A description of what the function does, used by the model to choose when and how to call the
     * function.
     */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /**
     * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and
     * dashes, with a maximum length of 64.
     */
    fun name(): String = name.getRequired("name")

    /**
     * The parameters the functions accepts, described as a JSON Schema object. See the
     * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and the
     * [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for documentation
     * about the format.
     *
     * Omitting `parameters` defines a function with an empty parameter list.
     */
    fun parameters(): Optional<FunctionParameters> =
        Optional.ofNullable(parameters.getNullable("parameters"))

    /**
     * A description of what the function does, used by the model to choose when and how to call the
     * function.
     */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /**
     * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and
     * dashes, with a maximum length of 64.
     */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /**
     * The parameters the functions accepts, described as a JSON Schema object. See the
     * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and the
     * [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for documentation
     * about the format.
     *
     * Omitting `parameters` defines a function with an empty parameter list.
     */
    @JsonProperty("parameters") @ExcludeMissing fun _parameters() = parameters

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): FunctionDefinition = apply {
        if (!validated) {
            description()
            name()
            parameters().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FunctionDefinition &&
            this.description == other.description &&
            this.name == other.name &&
            this.parameters == other.parameters &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    description,
                    name,
                    parameters,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "FunctionDefinition{description=$description, name=$name, parameters=$parameters, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var description: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var parameters: JsonField<FunctionParameters> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(functionDefinition: FunctionDefinition) = apply {
            this.description = functionDefinition.description
            this.name = functionDefinition.name
            this.parameters = functionDefinition.parameters
            additionalProperties(functionDefinition.additionalProperties)
        }

        /**
         * A description of what the function does, used by the model to choose when and how to call
         * the function.
         */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * A description of what the function does, used by the model to choose when and how to call
         * the function.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /**
         * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and
         * dashes, with a maximum length of 64.
         */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and
         * dashes, with a maximum length of 64.
         */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * The parameters the functions accepts, described as a JSON Schema object. See the
         * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and the
         * [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for
         * documentation about the format.
         *
         * Omitting `parameters` defines a function with an empty parameter list.
         */
        fun parameters(parameters: FunctionParameters) = parameters(JsonField.of(parameters))

        /**
         * The parameters the functions accepts, described as a JSON Schema object. See the
         * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and the
         * [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for
         * documentation about the format.
         *
         * Omitting `parameters` defines a function with an empty parameter list.
         */
        @JsonProperty("parameters")
        @ExcludeMissing
        fun parameters(parameters: JsonField<FunctionParameters>) = apply {
            this.parameters = parameters
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): FunctionDefinition =
            FunctionDefinition(
                description,
                name,
                parameters,
                additionalProperties.toUnmodifiable(),
            )
    }
}
