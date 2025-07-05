package gr.qualco.demo.countrystats.controller;

import gr.qualco.demo.countrystats.dto.region.response.GetRegionsResponse;
import gr.qualco.demo.countrystats.service.region.RegionServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("regions")
public class RegionController {

    private final RegionServiceInterface regionService;

    public RegionController(RegionServiceInterface regionServiceInterface) {
        this.regionService = regionServiceInterface;
    }

    @GetMapping
    public ResponseEntity<GetRegionsResponse> getRegions() {
        GetRegionsResponse response = regionService.getRegions();

        return ResponseEntity.ok(response);
    }
}
