package examples.json.jackson;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@JsonIgnoreProperties(ignoreUnknown = true)
public class JacksonExample {
    public static void main(String[] args) {
        objectToJson();
        jsonToObject(Car.class);
    }

    @SneakyThrows
    private static <T> void jsonToObject(Class<T> carClass) {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\", \"year\" : \"2015\" }";
        T t = new ObjectMapper().readValue(json, carClass);
        log.info("car - {}", t);
    }

    @SneakyThrows
    private static void objectToJson() {
        Car car = new Car("red", "crossover", 2015);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("target/car.json"), car);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Car {

    public String color;
    public String type;
    public Integer year;
}