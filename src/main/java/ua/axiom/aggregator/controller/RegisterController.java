package ua.axiom.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.axiom.aggregator.dto.RegisterFormDto;
import ua.axiom.aggregator.model.exception.NotUniqueUsernameOrEmailException;
import ua.axiom.aggregator.service.RegisterService;

import javax.validation.Valid;

@Controller
@RequestMapping
public class RegisterController {
    private final static String REGISTER_VIEW = "register.html";

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    private String formGetResponse() {
        return REGISTER_VIEW;
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    private String registerHandling(
            @Valid RegisterFormDto registerFormDto,
            BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            return REGISTER_VIEW + "?error=invalidinput";
        }

        registerService.register(registerFormDto);

        return "redirect:/redirect";
    }

    @ExceptionHandler(NotUniqueUsernameOrEmailException.class)
    private String registerExceptionHandler(NotUniqueUsernameOrEmailException ex) {
/*        model.addAttribute("register_exception", true);
        model.addAttribute("err_msg_desc", "exception-msg.non-unique_credentials");*/

        return REGISTER_VIEW + "?error=userexists";
    }
}
