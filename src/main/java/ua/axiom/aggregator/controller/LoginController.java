package ua.axiom.aggregator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import ua.axiom.aggregator.model.exception.WrongCredentialsException;

@Controller
@ControllerAdvice
public class LoginController {
    private final static String VIEW_NAME = "login.html";

    @GetMapping("/login")
    public String formGetResponse() {
        return VIEW_NAME;
    }

    @ExceptionHandler(WrongCredentialsException.class)
    public String exception() {
        System.err.println("err in class " + this.getClass());
        return "error";
    }

}
