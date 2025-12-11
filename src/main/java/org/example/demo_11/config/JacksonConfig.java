package org.example.demo_11.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // استراتيجية التسمية - camelCase (لتطابق JSON)
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);

        // السماح بحقول غير معروفة (ignore unknown fields)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // السماح بحقول فارغة
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // السماح بقيم null
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, true);

        return mapper;
    }
}