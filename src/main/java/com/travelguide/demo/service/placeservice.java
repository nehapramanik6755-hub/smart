package com.travelguide.demo.service;

import com.travelguide.demo.entity.place;
import com.travelguide.demo.repository.placerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class placeservice {

    @Autowired
    private placerepository placeRepository;

    public List<place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public place getPlaceById(Long id) {
        return placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place not found"));
    }

    public place addPlace(place place) {
        return placeRepository.save(place);
    }

    public place updatePlace(Long id, place place) {
        place existingPlace = getPlaceById(id);

        existingPlace.setName(place.getName());
        existingPlace.setCity(place.getCity());
        existingPlace.setDescription(place.getDescription());
        existingPlace.setEntryFee(place.getEntryFee());

        return placeRepository.save(existingPlace);
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }
}