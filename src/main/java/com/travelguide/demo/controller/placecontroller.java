package com.travelguide.demo.controller;

import com.travelguide.demo.entity.place;
import com.travelguide.demo.service.placeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
@CrossOrigin(origins = "*")
public class placecontroller {

    @Autowired
    private placeservice placeService;

    // Get all places
    @GetMapping
    public List<place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    // Get place by ID
    @GetMapping("/{id}")
    public place getPlaceById(@PathVariable Long id) {
        return placeService.getPlaceById(id);
    }

    // Add new place
    @PostMapping
    public place addPlace(@RequestBody place place) {
        return placeService.addPlace(place);
    }

    // Update place
    @PutMapping("/{id}")
    public place updatePlace(@PathVariable Long id,
                             @RequestBody place place) {
        return placeService.updatePlace(id, place);
    }

    // Delete place
    @DeleteMapping("/{id}")
    public String deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return "Place deleted successfully";
    }
}