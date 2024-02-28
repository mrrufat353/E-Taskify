package az.etaskify.service.organization;

import az.etaskify.dto.request.organization.OrganizationRequestDto;
import az.etaskify.dto.response.organization.OrganizationGetResponseDto;
import az.etaskify.dto.response.organization.OrganizationResponseDto;

import java.util.List;

public interface OrganizationService {

    OrganizationResponseDto create(OrganizationRequestDto requestDto);

    OrganizationResponseDto findById(Long organizationId);

    List<OrganizationResponseDto> findAll();

    OrganizationResponseDto update(Long organizationId, OrganizationRequestDto requestDto);

    OrganizationResponseDto delete(Long organizationId);
}
