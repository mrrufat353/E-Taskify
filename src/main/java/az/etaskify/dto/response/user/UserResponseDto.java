package az.etaskify.dto.response.user;

import az.etaskify.entity.address.Address;
import az.etaskify.entity.phoneNumber.PhoneNumber;
import az.etaskify.entity.task.Task;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    Long id;

    String name;

    String surname;

    List<PhoneNumber> phoneNumbers;

    Address address;

    @Builder.Default
    List<Task> tasks = new ArrayList<>();
}
