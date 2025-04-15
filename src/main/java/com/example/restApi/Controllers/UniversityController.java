package com.example.restApi.Controllers;

import com.example.restApi.DTO.GiveUniDTO;
import com.example.restApi.Sevices.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uni")
public class UniversityController {
    private UniversityService universityService;
    @Autowired
    public void setUniversityService(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/{id}")
    public GiveUniDTO getAllAboutUni(@PathVariable Long id){
        return universityService.getAllAboutUniById(id);
    }
    @GetMapping("/all")
    public List<GiveUniDTO> getAll(){
        return universityService.getAll();
    }
    @GetMapping("/giveUniversityByName")
    public GiveUniDTO getAll(@RequestParam("name") String name){
        return universityService.giveUniversityByUniversity(name);
    }
}
