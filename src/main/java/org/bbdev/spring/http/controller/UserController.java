package org.bbdev.spring.http.controller;

import lombok.RequiredArgsConstructor;
import org.bbdev.spring.database.entity.Role;
import org.bbdev.spring.dto.UserCreateEditDto;
import org.bbdev.spring.service.CompanyService;
import org.bbdev.spring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.bbdev.spring.database.entity.QUser.user;

@Controller
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        return userService.findById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    model.addAttribute("roles", Role.values());
                    model.addAttribute("companies", companyService.findAll());
                    return "user/user";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute("user") UserCreateEditDto user) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("companies", companyService.findAll());
        return "user/registration";
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@ModelAttribute UserCreateEditDto user, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("user", user);
        if(true){
            return "redirect:/users/registration";
        }
        return "redirect:/users" + userService.create(user).getId();
    }

//    @PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, @ModelAttribute UserCreateEditDto user){
        return userService.update(id, user)
                .map(it -> "redirect:/users/{id}")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        userService.update(id, user);
    }

//    @DeleteMapping{"/{id}"}
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        if (!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/users";
    }
}
