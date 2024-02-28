package az.etaskify.entity.organization;

import az.etaskify.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE)
    List<User> userList = new ArrayList<>();
}
