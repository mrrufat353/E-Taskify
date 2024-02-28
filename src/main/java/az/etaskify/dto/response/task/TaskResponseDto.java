package az.etaskify.dto.response.task;

import az.etaskify.entity.task.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponseDto {

    Long id;

    String title;

    String description;

    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime createdAt;

    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    TaskStatus status;
}
