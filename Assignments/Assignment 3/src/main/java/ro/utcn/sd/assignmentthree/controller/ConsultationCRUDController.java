package ro.utcn.sd.assignmentthree.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(name = "id") String id, Model model) {
        consultationService.delete(Long.parseLong(id));
        model.addAttribute("deleteMessage", "Consultation was successfully deleted");
        return "redirect:/consultations";
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateForm(Model model) {
        model.addAttribute("consultation", new Consultation());
        return "consultation-update-form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editConsultation(@RequestParam(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("consultation-update-form");
        Consultation consultation = consultationService.findById(Long.parseLong(id));
        ConsultationDto consultationDto = new ConsultationToConsultationDtoConverter().apply(consultation);
        modelAndView.addObject("consultationDto", consultationDto);
        modelAndView.addObject("patients", patientService.getAll());
        modelAndView.addObject("doctors", userService.getAllByRole("ROLE_DOCTOR"));
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute ConsultationDto consultationDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/consultations");
        Consultation consultation = new ConsultationDtoToConsultationConverter().apply(consultationDto);
        consultationService.update(consultation);
        modelAndView.addObject("message", "Success");
        return modelAndView;
    }


}
