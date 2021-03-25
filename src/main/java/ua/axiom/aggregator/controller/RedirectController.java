package ua.axiom.aggregator.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RedirectController {
    private final Map<String, String> roleToUrlMap = new HashMap<>();

    @RequestMapping("/redirect")
    public String redirectController() {
        Object object = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        return "redirect:/feed";
    }
}
