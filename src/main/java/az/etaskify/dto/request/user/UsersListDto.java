package az.etaskify.dto.request.user;

import az.etaskify.entity.user.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersListDto {

    List<User> userList = new ArrayList<>();
}
