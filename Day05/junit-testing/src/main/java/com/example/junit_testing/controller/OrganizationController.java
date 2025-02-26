package com.example.junit_testing.controller;

import com.example.junit_testing.dto.OrganizationDto;
import com.example.junit_testing.entity.Organization;
import com.example.junit_testing.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping()
    public List<Organization> getAllOrganizationDetails(){
        return organizationService.getAllOrganizationDetails();
    }

    @GetMapping("/id/{id}")
    public Organization getOrganizationById(@PathVariable Long id){
        return organizationService.getOrganizationDetailsById(id);
    }

    @PostMapping()
    public Organization addOrganization(@RequestBody OrganizationDto organizationDto){
        return organizationService.addOrganization(organizationDto);
    }

    @PutMapping()
    public Organization updateExistingOrganization(@RequestBody Organization organization){
        return organizationService.updateOrganizationDetails(organization);
    }

    @DeleteMapping("/{id}")
    public String deleteOrganization(@PathVariable Long id) throws Exception{
        return organizationService.deleteOrganization(id);

    }
}
