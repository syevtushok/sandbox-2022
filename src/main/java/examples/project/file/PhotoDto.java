package examples.project.file;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhotoDto {
    List<Photo> photos;
}
