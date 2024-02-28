package az.etaskify.service.organization;

import az.etaskify.dto.request.organization.OrganizationRequestDto;
import az.etaskify.dto.response.organization.OrganizationResponseDto;
import az.etaskify.entity.organization.Organization;
import az.etaskify.errors.ApplicationException;
import az.etaskify.errors.Errors;
import az.etaskify.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    private final ModelMapper modelMapper;

    @Override
    public OrganizationResponseDto create(OrganizationRequestDto requestDto) {
        Optional<Organization> organization = organizationRepository.findByName(requestDto.getName());
        if (organization.isPresent()) {
            throw new ApplicationException(Errors.ORGANIZATION_NOT_FOUND);
        }

        Organization organizationForSave = Organization.builder()
                .name(requestDto.getName())
                .build();

        Organization savedOrg = organizationRepository.save(organizationForSave);
        return modelMapper.map(savedOrg, OrganizationResponseDto.class);
    }

    @Override
    public OrganizationResponseDto findById(Long organizationId) {
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                () -> new ApplicationException(Errors.ORGANIZATION_NOT_FOUND));
        return modelMapper.map(organization, OrganizationResponseDto.class);
    }

    @Override
    public List<OrganizationResponseDto> findAll() {
        return organizationRepository
                .findAll()
                .stream()
                .map(organization -> modelMapper.map(organization, OrganizationResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationResponseDto update(Long organizationId, OrganizationRequestDto requestDto) {
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                () -> new ApplicationException(Errors.ORGANIZATION_NOT_FOUND));

        Organization forUpdate = Organization.builder()
                .id(organization.getId())
                .name(requestDto.getName())
                .build();

        Organization savedOrg = organizationRepository.save(forUpdate);
        return modelMapper.map(savedOrg, OrganizationResponseDto.class);
    }

    @Override
    public OrganizationResponseDto delete(Long organizationId) {
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                () -> new ApplicationException(Errors.ORGANIZATION_NOT_FOUND));
        organizationRepository.delete(organization);
        return modelMapper.map(organization, OrganizationResponseDto.class);
    }
}
