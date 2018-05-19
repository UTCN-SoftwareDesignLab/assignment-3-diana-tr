package ro.utcn.sd.assignmentthree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.sd.assignmentthree.converter.PatientDtoToPatientConverter;
import ro.utcn.sd.assignmentthree.converter.PatientToPatientDtoConverter;
import ro.utcn.sd.assignmentthree.dto.PatientDto;
import ro.utcn.sd.assignmentthree.entity.Patient;
import ro.utcn.sd.assignmentthree.service.patient.PatientService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/patients")
public class PatientCRUDController {
    @Autowired
    private PatientService patientService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("patients", patientService.getAll());
        return "patients";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute @Valid PatientDto patientDto) {
        patientService.create(patientDto);
        return "redirect:create?success";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("patient", new PatientDto());
        return "patient-form";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(name = "id") String id, Model model) {
        patientService.delete(Long.parseLong(id));
        model.addAttribute("deleteMessage", "Patient was successfully deleted");
        return "redirect:/patients";
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-update-form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editBook(@RequestParam(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("patient-update-form");
        Patient patient = patientService.findById(Long.parseLong(id));
        PatientDto patientDto = new PatientToPatientDtoConverter().apply(patient);
        modelAndView.addObject("patientDto", patientDto);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute PatientDto patientDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/patients");
        Patient patient = new PatientDtoToPatientConverter().apply(patientDto);
        patientService.update(patient);
        modelAndView.addObject("message", "Success");
        return modelAndView;
    }

}
