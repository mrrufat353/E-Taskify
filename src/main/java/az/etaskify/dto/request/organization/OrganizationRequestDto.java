package az.etaskify.dto.request.organization;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationRequestDto {

    String name;

    String confirmationCode;
}
