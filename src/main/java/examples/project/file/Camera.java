package examples.project.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Camera {
    private String id;
    private String name;
    @JsonProperty("rover_id")
    private String roverId;
    @JsonProperty("full_name")
    private String fullName;
}
