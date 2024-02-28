package az.etaskify.service.user;

import az.etaskify.dto.request.user.UserCreateRequestDto;
import az.etaskify.dto.request.user.UserRequestDto;
import az.etaskify.dto.response.user.UserCreateResponseDto;
import az.etaskify.dto.response.user.UserResponseDto;
import az.etaskify.entity.address.Address;
import az.etaskify.entity.authority.Authority;
import az.etaskify.entity.authority.UserAuthority;
import az.etaskify.entity.user.User;
import az.etaskify.errors.ApplicationException;
import az.etaskify.errors.Errors;
import az.etaskify.repository.AddressRepository;
import az.etaskify.repository.AuthorRepository;
import az.etaskify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AuthorRepository authorRepository;

    private final AddressRepository addressRepository;

    private final ModelMapper modelMapper;


    @Override
    public UserCreateResponseDto create(UserCreateRequestDto dto) {
        Optional<User> user = userRepository.findUserByEmail(dto.getEmail());

        if (user.isPresent()) {
            throw new ApplicationException(Errors.USER_EXISTS);
        }

        Authority userAuth = authorRepository.findByAuthority(UserAuthority.USER).orElseThrow(() ->
                new ApplicationException(Errors.AUTHORITY_NOT_FOUND));

        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new ApplicationException(Errors.PASSWORD_DID_NOT_MATCH);
        }

        User userForSave = User.builder()
                .authorities(List.of(userAuth))
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
        userRepository.save(userForSave);


        return UserCreateResponseDto.builder()
                .message(String.format("User registered successfully : &s", userForSave.getEmail()))
                .build();

    }

    @Override
    public UserResponseDto update(Long userId, UserRequestDto dto) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ApplicationException(Errors.USER_NOT_FOUND));

        Optional<Address> address = addressRepository.findById(dto.getAddressId());

        User userForUpdate = modelMapper.map(dto, User.class);
        userForUpdate.setPassword(dto.getPassword());
        userForUpdate.setId(userId);

        if (address.isPresent()) {
            userForUpdate.getAddress().setId(address.get().getId());
            userForUpdate.getAddress().setAddress(dto.getAddress());
        }

        userForUpdate.getAddress().setAddress(dto.getAddress());
        dto.getPhoneNumbers().forEach(phoneNumber ->
                userForUpdate.getPhoneNumbers().add(phoneNumber));
        dto.getPhoneNumbers().forEach(phoneNumber -> phoneNumber.setUser(user));

        User savedUser = userRepository.save(userForUpdate);
        return modelMapper.map(savedUser, UserResponseDto.class);

    }

    @Override
    public UserResponseDto delete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ApplicationException(Errors.USER_NOT_FOUND));
        userRepository.deleteById(userId);
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public UserResponseDto get(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ApplicationException(Errors.USER_NOT_FOUND));
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public List<UserResponseDto> findAll(Long organizationId) {
        List<User> userList = userRepository.findAllUsers(organizationId);
        List<UserResponseDto> responseDtos = new ArrayList<>();
        userList.forEach((user -> responseDtos.add(modelMapper.map(user, UserResponseDto.class))));
        return responseDtos;
    }
}