package ro.utcn.sd.assignmentthree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.sd.assignmentthree.converter.UserDtoToUserConverter;
import ro.utcn.sd.assignmentthree.converter.UserToUserDtoConverter;
import ro.utcn.sd.assignmentthree.dto.UserDto;
import ro.utcn.sd.assignmentthree.entity.Role;
import ro.utcn.sd.assignmentthree.entity.User;
import ro.utcn.sd.assignmentthree.repository.RoleRepository;
import ro.utcn.sd.assignmentthree.service.user.UserService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;

@Controller
@RequestMapping(value = "/users")
public class UserCRUDController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute @Valid UserDto userDto, @RequestParam(name = "role") String role) {
        Role newRole = roleRepository.findByRole(role);
        userDto.setRoles(new HashSet<>(Arrays.asList(newRole)));
        userService.create(userDto);
        return "redirect:create?success";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "user-form";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(name = "id") String id, Model model) {
        userService.deleteById(Long.parseLong(id));
        model.addAttribute("deleteMessage", "User was successfully deleted");
        return "redirect:/users";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateForm(Model model) {
        model.addAttribute("user", new User());
        return "user-update-form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("user-update-form");
        User user = userService.findById(Long.parseLong(id));
        UserDto userDto = new UserToUserDtoConverter().apply(user);
        modelAndView.addObject("userDto", userDto);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute UserDto userDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/users");
        User user = new UserDtoToUserConverter().apply(userDto);
        userService.update(user);
        modelAndView.addObject("message", "Success");
        return modelAndView;
    }

}
