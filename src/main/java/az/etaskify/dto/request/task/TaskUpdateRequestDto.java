package az.etaskify.dto.request.task;

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
public class TaskUpdateRequestDto {

    String title;

    String description;

    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    TaskStatus status;
}
