package examples.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HttpClientExample {

    @SneakyThrows
    public static void main(String[] args) {
        HttpRequest.Builder firstBuilder = HttpRequest.newBuilder(new URI("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=10&api_key=DEMO_KEY"));
        HttpRequest.Builder secondBuilder = HttpRequest.newBuilder().uri(new URI("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=10&api_key=DEMO_KEY"));
        HttpRequest httpRequest = getExample();
        getPostExample();

        HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

    }

    @SneakyThrows
    private static void getPostExample() {
        byte[] sampleData = "Sample request body".getBytes();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofByteArray(sampleData))
                .build();
    }

    @SneakyThrows
    private static HttpRequest getExample() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .version(HttpClient.Version.HTTP_2)
                .headers("key1", "value1")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .build();
        log.info(request);
        return request;
    }
}
