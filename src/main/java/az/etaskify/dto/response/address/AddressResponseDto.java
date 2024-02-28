package az.etaskify.dto.response.address;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponseDto {

    Long id;

    String address;
}
