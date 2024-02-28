package az.etaskify.dto.response.organization;

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
public class OrganizationGetResponseDto {

    Long id;

    String confirmationCode;

    String name;

    @Builder.Default
    List<User> users = new ArrayList<>();
}
