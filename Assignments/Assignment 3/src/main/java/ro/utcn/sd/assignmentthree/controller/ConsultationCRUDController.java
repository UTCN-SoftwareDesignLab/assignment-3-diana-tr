package ro.utcn.sd.assignmentthree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.utcn.sd.assignmentthree.dto.ConsultationDto;
import ro.utcn.sd.assignmentthree.service.consultation.ConsultationService;
import ro.utcn.sd.assignmentthree.service.patient.PatientService;
import ro.utcn.sd.assignmentthree.service.user.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/consultations")
public class ConsultationCRUDController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("consultations", consultationService.getAll());
        return "consultations";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute @Valid ConsultationDto consultationDto) {
        consultationService.create(consultationDto);
        return "redirect:create?success";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("consultation", new ConsultationDto());
        model.addAttribute("patients", patientService.getAll());
        model.addAttribute("doctors", userService.getAllByRole("ROLE_DOCTOR"));
        return "consultation-form";
    }


}
