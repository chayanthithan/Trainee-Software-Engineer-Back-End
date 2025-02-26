package com.example.junit_testing.service;

import com.example.junit_testing.dto.OrganizationDto;
import com.example.junit_testing.entity.Organization;
import com.example.junit_testing.repository.OrganizationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrganizationServiceTest {

    @Mock
    private OrganizationRepository organizationRepository;

    @InjectMocks
    private OrganizationService organizationService;

    private OrganizationDto organizationDto;
    private Organization organization;

    @Test
    void getAllOrganizationDetails() {
        Organization organization = Organization.builder()
                .name("codelantic")
                .location("jaffna")
                .numberOfEmployees(10)
                .build();
        when(organizationRepository.findAll()).thenReturn(List.of(organization));
        List<Organization> organizations = organizationService.getAllOrganizationDetails();
        assertNotNull(organizations);
        assertEquals("codelantic",organizations.get(0).getName());
        verify(organizationRepository,times(1)).findAll();
    }

    @Test
    void getOrganizationDetailsById_Success() {
        organization = Organization.builder()
                .name("codelantic")
                .location("jaffna")
                .numberOfEmployees(10)
                .build();

        when(organizationRepository.findById(1L)).thenReturn(Optional.ofNullable(organization));
        Organization orgResponse = organizationService.getOrganizationDetailsById(1L);
        assertNotNull(orgResponse);
        assertEquals("codelantic",orgResponse.getName());
        verify(organizationRepository,times(1)).findById(1L);
    }

    @Test
    void getOrganizationDetailsById_NotFound(){
        Organization organization1;
        when(organizationRepository.findById(2L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(NullPointerException.class, () -> organizationService.getOrganizationDetailsById(2L));
        assertEquals("there is no records",exception.getMessage());
        verify(organizationRepository,times(1)).findById(2L);
    }

    @Test
    void addOrganization() {

        Organization organization = Organization.builder()
                .name("codelantic")
                .location("jaffna")
                .numberOfEmployees(10)
                .build();
        organizationDto = OrganizationDto.builder()
                .name("codelantic")
                .location("jaffna")
                .numberOfEmployees(10)
                .build();
        when(organizationRepository.save(organization)).thenReturn(organization);
        Organization organization1  = organizationService.addOrganization(organizationDto);

        assertNotNull(organization1);
        assertEquals("codelantic",organization1.getName());
        verify(organizationRepository,times(1)).save(organization);
    }


    @Test
    void updateOrganizationDetails() {
        Organization organization = Organization.builder()
                .id(1L)
                .name("codelantic")
                .location("jaffna")
                .numberOfEmployees(10)
                .build();
        when(organizationRepository.findById(organization.getId())).thenReturn(Optional.of(organization));
        when(organizationRepository.save(organization)).thenReturn(organization);

        Organization organization1 = organizationService.updateOrganizationDetails(organization);
        assertNotNull(organization1);
    }

    @Test
    void deleteOrganization() throws NoSuchFieldException {
        Organization organization = Organization.builder()
                .id(1L)
                .name("codelantic")
                .location("jaffna")
                .numberOfEmployees(10)
                .build();
        when(organizationRepository.existsById(organization.getId())).thenReturn(true);
       String response = organizationService.deleteOrganization(organization.getId());

    }
}