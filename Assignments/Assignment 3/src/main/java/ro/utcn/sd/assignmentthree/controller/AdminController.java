package ro.utcn.sd.assignmentthree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.utcn.sd.assignmentthree.dto.UserDto;


@Controller
@RequestMapping("/admin")
public class AdminController {


    @RequestMapping()
    public String admin() {
        return "admin";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(@ModelAttribute UserDto userDto) {
        return "redirect:/users";
    }

}
