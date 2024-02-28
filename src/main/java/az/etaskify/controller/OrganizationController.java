package az.etaskify.controller;

import az.etaskify.dto.request.organization.OrganizationRequestDto;
import az.etaskify.dto.response.organization.OrganizationGetResponseDto;
import az.etaskify.dto.response.organization.OrganizationResponseDto;
import az.etaskify.service.organization.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping("/create")
    public ResponseEntity<OrganizationResponseDto> create(@RequestBody OrganizationRequestDto requestDto){
        return  ResponseEntity.ok(organizationService.create(requestDto));
    }

    @GetMapping("/{organizationId}")
    public ResponseEntity<OrganizationResponseDto> findById(@PathVariable Long organizationId){
        return ResponseEntity.ok(organizationService.findById(organizationId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<OrganizationResponseDto>> findAll(){
        return ResponseEntity.ok(organizationService.findAll());
    }

    @PutMapping("/{organizationId}/put")
    public ResponseEntity<OrganizationResponseDto> update(@PathVariable Long organizationId,
                                                             @RequestBody OrganizationRequestDto requestDto){
        return ResponseEntity.ok(organizationService.update(organizationId, requestDto));
    }

    @DeleteMapping("/{organizationId}")
    public ResponseEntity<OrganizationResponseDto> delete(@PathVariable Long organizationId){
        return ResponseEntity.ok(organizationService.delete(organizationId));
    }
}
