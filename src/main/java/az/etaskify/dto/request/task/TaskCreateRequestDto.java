package az.etaskify.dto.request.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskCreateRequestDto {

    String title;

    String description;

    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime createdAt;

    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime deadline;
}
