package az.etaskify.controller;

import az.etaskify.dto.request.address.AddressRequestDto;
import az.etaskify.dto.response.address.AddressResponseDto;
import az.etaskify.service.address.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/address")
@Slf4j
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressResponseDto> findById(@PathVariable Long addressId) {
        return ResponseEntity.ok(addressService.findById(addressId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AddressResponseDto>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<AddressResponseDto> create(@RequestBody AddressRequestDto dto){
        return ResponseEntity.ok(addressService.create(dto));
    }

    @PutMapping("/update/{addressId}")
    public ResponseEntity<AddressResponseDto> update(@PathVariable Long addressId, @RequestBody AddressRequestDto dto){
        return ResponseEntity.ok(addressService.update(addressId, dto));
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<AddressResponseDto> delete(@PathVariable Long addressId){
        return ResponseEntity.ok(addressService.delete(addressId));
    }
}
