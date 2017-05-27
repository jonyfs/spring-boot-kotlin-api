package br.com.jonyfs.springbootkotlinapi.util

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.io.IOException


/**
 * Created by jony on 27/05/17.
 */

class BCryptPasswordDeserializer : JsonDeserializer<String>() {

    @Throws(IOException::class)
    override fun deserialize(jsonParser: JsonParser, deserializationContext: DeserializationContext): String {
        val oc = jsonParser.codec
        val node = oc.readTree<JsonNode>(jsonParser)
        val encoder = BCryptPasswordEncoder()
        val encodedPassword = encoder.encode(node.asText())
        return encodedPassword
    }
}