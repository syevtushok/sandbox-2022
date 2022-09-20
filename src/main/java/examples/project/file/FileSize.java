package examples.project.file;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class FileSize {
    @SneakyThrows
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest
                .newBuilder(new URI("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=10&api_key=DEMO_KEY"))
                .setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 10; SM-A205U) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.71 Mobile Safari/537.36.")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        PhotoDto photoDto = objectMapper.readValue(response.body(), PhotoDto.class);
        int maxSize = 0;

        Photo maxPhoto = photoDto.getPhotos().get(0);
        for (Photo photo : photoDto.getPhotos()) {
            String imgSrc = photo.getImgSrc().replace("http", "https").replace(".jpl", "");
            HttpRequest imgRequest = HttpRequest.newBuilder(new URI(imgSrc)).build();
            HttpResponse<byte[]> send = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofByteArray());
            int available = IOUtils.length(send.body());
            if (maxSize < available) {
                maxSize = available;
                maxPhoto = photo;
            }
        }
        System.out.println(photoDto);
        System.out.println(maxSize);
        System.out.println(maxPhoto);
    }
}
