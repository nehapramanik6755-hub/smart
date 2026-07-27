package com.travelguide.demo.service;

import com.travelguide.demo.entity.Guide;
import com.travelguide.demo.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideService {

    @Autowired
    private GuideRepository guideRepository;

    public List<Guide> getAllGuides() {
        return guideRepository.findAll();
    }

    public Guide getGuideById(Long id) {
        return guideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guide not found"));
    }

    public Guide addGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    public Guide updateGuide(Long id, Guide guide) {
        Guide existingGuide = getGuideById(id);

        existingGuide.setName(guide.getName());
        existingGuide.setCity(guide.getCity());
        existingGuide.setLanguage(guide.getLanguage());
        existingGuide.setPricePerDay(guide.getPricePerDay());

        return guideRepository.save(existingGuide);
    }

    public void deleteGuide(Long id) {
        guideRepository.deleteById(id);
    }
}
