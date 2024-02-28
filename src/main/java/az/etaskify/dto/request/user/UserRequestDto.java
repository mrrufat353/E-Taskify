package az.etaskify.dto.request.user;

import az.etaskify.entity.phoneNumber.PhoneNumber;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

    String name;

    String surname;

    String password;

    String confirmPassword;

    String address;

    Long addressId;

    List<PhoneNumber> phoneNumbers;


}
