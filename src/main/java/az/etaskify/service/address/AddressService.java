package az.etaskify.service.address;

import az.etaskify.dto.request.address.AddressRequestDto;
import az.etaskify.dto.response.address.AddressResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    AddressResponseDto findById(Long addressId);

    List<AddressResponseDto> findAll();

    AddressResponseDto update(Long addressId, AddressRequestDto dto);

    AddressResponseDto delete(Long addressId);

    AddressResponseDto create(AddressRequestDto dto);
}
