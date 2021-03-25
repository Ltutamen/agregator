package ua.axiom.aggregator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.axiom.aggregator.dto.UserDataDto;

@Controller
public class HeaderController {

    @ResponseBody
    @GetMapping("api/userheaderdata")
    public UserDataDto getUserData() {

        return new UserDataDto("LoremIpsumUser");
    }
}
