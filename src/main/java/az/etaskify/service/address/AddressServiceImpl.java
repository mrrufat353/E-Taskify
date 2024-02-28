package az.etaskify.service.address;

import az.etaskify.dto.request.address.AddressRequestDto;
import az.etaskify.dto.response.address.AddressResponseDto;
import az.etaskify.entity.address.Address;
import az.etaskify.errors.ApplicationException;
import az.etaskify.errors.Errors;
import az.etaskify.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final ModelMapper modelMapper;

    @Override
    public AddressResponseDto findById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ApplicationException(Errors.ADDRESS_NOT_FOUND));
        return modelMapper.map(address, AddressResponseDto.class);
    }

    @Override
    public AddressResponseDto create(AddressRequestDto dto) {
        Address address = Address.builder()
                .address(dto.getAddress())
                .build();

        Address savedAddress = addressRepository.save(address);
        return modelMapper.map(savedAddress, AddressResponseDto.class);
    }

    @Override
    public List<AddressResponseDto> findAll() {
        return addressRepository
                .findAll()
                .stream()
                .map(address -> modelMapper.map(address, AddressResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponseDto update(Long addressId, AddressRequestDto dto) {
        addressRepository.findById(addressId)
                .orElseThrow(() -> new ApplicationException(Errors.ADDRESS_NOT_FOUND));
        Address addressForUpdate = modelMapper.map(dto, Address.class);
        addressForUpdate.setId(addressId);
        addressForUpdate.setAddress(dto.getAddress());

        return modelMapper.map(addressRepository.save(addressForUpdate), AddressResponseDto.class);
    }

    @Override
    public AddressResponseDto delete(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ApplicationException(Errors.ADDRESS_NOT_FOUND));
        addressRepository.delete(address);
        return modelMapper.map(address, AddressResponseDto.class);
    }
}
