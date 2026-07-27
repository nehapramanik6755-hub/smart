
package com.travelguide.demo.controller;

import com.travelguide.demo.entity.Guide;
import com.travelguide.demo.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
@CrossOrigin(origins = "*")
public class GuideController {

    @Autowired
    private GuideService guideService;

    @GetMapping
    public List<Guide> getAllGuides() {
        return guideService.getAllGuides();
    }

    @GetMapping("/{id}")
    public Guide getGuideById(@PathVariable Long id) {
        return guideService.getGuideById(id);
    }

    @PostMapping
    public Guide addGuide(@RequestBody Guide guide) {
        return guideService.addGuide(guide);
    }

    @PutMapping("/{id}")
    public Guide updateGuide(@PathVariable Long id, @RequestBody Guide guide) {
        return guideService.updateGuide(id, guide);
    }

    @DeleteMapping("/{id}")
    public String deleteGuide(@PathVariable Long id) {
        guideService.deleteGuide(id);
        return "Guide deleted successfully";
    }
}