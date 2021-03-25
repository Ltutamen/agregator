package ua.axiom.aggregator.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping
public class IndexController {
    private final static String VIEW = "index.html";
    private final static String LOGIN_REDIRECT = "redirect:/login";
    private final static String REGISTER_REDIRECT = "redirect:/register";

    @GetMapping({"/index", "/"})
    public String getIndexView() {

        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        if(authorities.contains("ROLE_USER")) {
            return "redirect:/redirect";
        }

        return VIEW;
    }

}
