package ro.utcn.sd.assignmentthree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.utcn.sd.assignmentthree.dto.PatientDto;

@Controller
@RequestMapping(value = "/secretary")
public class SecretaryController {

    @RequestMapping
    public String secretary() {
        return "secretary";
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String patients(@ModelAttribute PatientDto patientDto) {
        return "redirect:/patients";
    }

    @RequestMapping("/consultations")
    public String consultations() {
        return "redirect:/consultations";
    }
}
