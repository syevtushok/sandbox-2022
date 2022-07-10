package examples.project.json_parser;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ToString
public class JsonParser {
    public static void main(String[] args) {
        String json = "{\"color\":\"red\",\"type\":\"crossover\",\"year\":2015}";
        Car car = JsonInternalParser.parseToObject(json, Car.class);
        JsonParser jsonParser = JsonInternalParser.parseToObject(json, JsonParser.class);
        log.info("car - {}", car);
        log.info("jsonParser - {}", jsonParser);
    }

    static class JsonInternalParser {

        @SneakyThrows
        static <T> T parseToObject(String json, Class<T> object) {
            T genericObject = object.getDeclaredConstructor().newInstance();
            Field[] fields = genericObject.getClass().getFields();

            Map<String, String> mapFieldValue = mapFieldValue(json);

            for (Field field : fields) {
                if (mapFieldValue.containsKey(field.getName())) {
                    String type = field.getType().getName();
                    String value = mapFieldValue.get(field.getName());
                    if (type.equals("java.lang.String")) {
                        field.set(genericObject, value);
                    } else if (type.equals("java.lang.Integer")) {
                        field.set(genericObject, Integer.valueOf(value));
                    }
                }
            }

            return genericObject;
        }

        private static Map<String, String> mapFieldValue(String json) {
            return Arrays.stream(json.split(","))
                    .map(s -> s.replaceAll("[{}\"]", ""))
                    .collect(Collectors.toMap(
                            s -> s.substring(0, s.indexOf(":")).trim(),
                            o -> o.substring(o.indexOf(":") + 1).trim()));
        }
    }
}

@ToString
class Car {
    public String color;
    public String type;
    public Integer year;
}