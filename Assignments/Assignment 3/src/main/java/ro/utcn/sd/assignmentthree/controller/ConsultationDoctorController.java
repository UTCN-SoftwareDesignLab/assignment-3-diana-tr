package ro.utcn.sd.assignmentthree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.sd.assignmentthree.converter.ConsultationDtoToConsultationConverter;
import ro.utcn.sd.assignmentthree.converter.ConsultationToConsultationDtoConverter;
import ro.utcn.sd.assignmentthree.dto.ConsultationDto;
import ro.utcn.sd.assignmentthree.entity.Consultation;
import ro.utcn.sd.assignmentthree.service.consultation.ConsultationService;
import ro.utcn.sd.assignmentthree.service.patient.PatientService;
import ro.utcn.sd.assignmentthree.service.user.UserService;

@Controller
@RequestMapping("/doctor")
public class ConsultationDoctorController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String doctor(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=user.getUsername();
        ro.utcn.sd.assignmentthree.entity.User user1=userService.findByUsername(username);
        Long userId=user1.getId();
        model.addAttribute("userId", userId);
        model.addAttribute("consultations",consultationService.getAllByDoctorId(userId));
        System.out.println(userId);
        return "doctor";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateForm(Model model) {
        model.addAttribute("consultation", new Consultation());
        return "consultation-doctor-update-form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editConsultation(@RequestParam(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("consultation-doctor-update-form");
        Consultation consultation = consultationService.findById(Long.parseLong(id));
        ConsultationDto consultationDto = new ConsultationToConsultationDtoConverter().apply(consultation);
        modelAndView.addObject("consultationDto", consultationDto);
        modelAndView.addObject("patients", patientService.getAll());
        modelAndView.addObject("doctors", userService.getAllByRole("ROLE_DOCTOR"));
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute ConsultationDto consultationDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/doctor");
        Consultation consultation = new ConsultationDtoToConsultationConverter().apply(consultationDto);
        consultationService.update(consultation);
        modelAndView.addObject("message", "Success");
        return modelAndView;
    }

}
