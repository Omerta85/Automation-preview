package base.pojos.updateUser;

import base.helpers.DataDeserializer;
import base.pojos.createUser.CreateUserRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateUserResponse extends CreateUserRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = DataDeserializer.class)
    private LocalDateTime updatedAt;
}
