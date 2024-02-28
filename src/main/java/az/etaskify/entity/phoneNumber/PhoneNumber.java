package az.etaskify.entity.phoneNumber;

import az.etaskify.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String number;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    User user;
}
