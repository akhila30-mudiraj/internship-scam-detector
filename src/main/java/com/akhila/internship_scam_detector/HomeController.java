package com.akhila.internship_scam_detector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private ScamDetectionService scamDetectionService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("internshipRequest", new InternshipRequest());
        return "index";
    }

    @PostMapping("/check")
    public String analyze(
            @ModelAttribute InternshipRequest internshipRequest,
            Model model) {

        DetectionResult result =
                scamDetectionService.analyze(internshipRequest);

        model.addAttribute("company",
                internshipRequest.getCompanyName());

        model.addAttribute("status",
                result.getStatus());

        model.addAttribute("score",
                result.getScore());

        return "result";
    }
}