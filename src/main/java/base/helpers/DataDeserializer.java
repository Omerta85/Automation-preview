package base.helpers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataDeserializer extends JsonDeserializer<LocalDateTime> {

//Цей метод викликається при десеріалізації об'єкта типу LocalDateTime. Він приймає JsonParser та DeserializationContext як параметри та повертає десеріалізований об'єкт LocalDateTime. У цьому методі використовується форматтер дати-часу для парсингу рядка у форматі ISO 8601.
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return LocalDateTime.parse(jsonParser.getText(),dateTimeFormatter);
    }
}
