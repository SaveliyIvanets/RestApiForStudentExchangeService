package com.example.restApi.Controllers;

import com.example.restApi.DTO.GiveUniDTO;
import com.example.restApi.Sevices.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uni")
public class UniversityController {
    private UniversityService universityService;
    @Autowired
    public void setUniversityService(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/getAllAboutUni")
    public GiveUniDTO getAllAboutUni(@RequestParam String uniName){
        return universityService.getAllAboutUniByName(uniName);
    }
}
