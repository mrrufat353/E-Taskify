package az.etaskify.entity.task;

import az.etaskify.entity.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String description;

    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime createdAt;

    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

}
