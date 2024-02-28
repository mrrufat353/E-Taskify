package az.etaskify.controller;

import az.etaskify.dto.request.user.UserCreateRequestDto;
import az.etaskify.dto.request.user.UserRequestDto;
import az.etaskify.dto.response.user.UserCreateResponseDto;
import az.etaskify.dto.response.user.UserResponseDto;
import az.etaskify.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/new")
    public ResponseEntity<UserCreateResponseDto> create(@RequestBody UserCreateRequestDto dto) {
        return ResponseEntity.ok(userService.create(dto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> get(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.get(userId));
    }

//    @GetMapping("/getOrganization")
//    public ResponseEntity<Organization> getOrganization(String token) {
//        return ResponseEntity.ok(userService.getOrganizationFromToken(token));
//    }

    @GetMapping("/{organizationId}")
    public ResponseEntity<List<UserResponseDto>> findAll(@PathVariable Long organizationId) {
        return ResponseEntity.ok(userService.findAll(organizationId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long userId,
                                                  @RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.update(userId, dto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserResponseDto> delete(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.delete(userId));
    }
}
