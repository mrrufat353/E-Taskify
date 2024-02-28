package az.etaskify.service.user;

import az.etaskify.dto.request.user.UserCreateRequestDto;
import az.etaskify.dto.request.user.UserRequestDto;
import az.etaskify.dto.response.user.UserCreateResponseDto;
import az.etaskify.dto.response.user.UserResponseDto;
import az.etaskify.entity.organization.Organization;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface UserService {
    UserCreateResponseDto create(UserCreateRequestDto dto);

//    Organization getOrganizationFromToken(String token);

    UserResponseDto get(Long userId);

    List<UserResponseDto> findAll(Long organizationId);

    UserResponseDto update(Long userId, UserRequestDto dto);

    UserResponseDto delete(Long userId);
}
