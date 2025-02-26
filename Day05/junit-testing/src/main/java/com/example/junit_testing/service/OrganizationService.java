package com.example.junit_testing.service;

import com.example.junit_testing.dto.OrganizationDto;
import com.example.junit_testing.entity.Organization;
import com.example.junit_testing.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public List<Organization> getAllOrganizationDetails() {
        return organizationRepository.findAll();
    }

    public Organization getOrganizationDetailsById(Long id) {
        return organizationRepository.findById(id).orElseThrow(() -> new NullPointerException("there is no records"));
    }

    public Organization addOrganization(OrganizationDto organizationDto) {
        Organization organization = Organization.builder()
                .name(organizationDto.getName())
                .location(organizationDto.getLocation())
                .numberOfEmployees(organizationDto.getNumberOfEmployees())
                .build();
        return organizationRepository.save(organization);
    }

    public Organization updateOrganizationDetails(Organization organization) {
        Organization existingOrganization = organizationRepository.findById(organization.getId()).orElse(null);
        if (existingOrganization == null){
            throw new NullPointerException("there is no records in the given id");
        }else{
            existingOrganization.setName(organization.getName());
            existingOrganization.setLocation(organization.getLocation());
            existingOrganization.setNumberOfEmployees(organization.getNumberOfEmployees());
            return organizationRepository.save(existingOrganization);
        }
    }

    public String deleteOrganization(Long id) throws NoSuchFieldException {
        boolean isExist = organizationRepository.existsById(id);
        if(isExist){
            organizationRepository.deleteById(id);
            return "deleted successfully";
        }else{
            throw new NoSuchFieldException("there is no records given id");
        }

    }
}
