package org.bbdev.spring.http.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.bbdev.spring.database.entity.Role;
import org.bbdev.spring.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;


@Controller
@SessionAttributes({"user"})
@RequestMapping("/api/v1")
public class GreetingController {
    @ModelAttribute("roles")
    public List<Role> roles(){
        return Arrays.asList(Role.values());
    }

    @GetMapping("/hello")
    public String hello(Model model,
                        HttpServletRequest request,
                        @ModelAttribute("userReadDto") UserReadDto userReadDto) {
//        request.getSession().getAttribute("user");
        model.addAttribute("user", userReadDto);
        return "greeting/hello";
    }

    @GetMapping("/bye")
    public String bye(UserReadDto user, Model model) {
        return "greeting/bye";
    }

    @GetMapping("/hello{id}")
    public String hello2(ModelAndView modelAndView, HttpServletRequest request,
                              @RequestParam("age") Integer age,
                              @RequestHeader("accept") String accept,
                              @CookieValue("JSESSIONID") String JSESSIONID,
                              @PathVariable("id") Integer id) {
        String ageParamValue = request.getParameter("age");
        String acceptHeader = request.getHeader("accept");
        Cookie[] cookies = request.getCookies();

        return "greeting/hello";
    }

}