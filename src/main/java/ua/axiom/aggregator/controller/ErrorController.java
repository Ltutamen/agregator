package ua.axiom.aggregator.controller;

import org.springframework.web.bind.annotation.*;

@RestController("/error")
public class ErrorController {
    @RequestMapping
    @ResponseBody
    protected String getError() {
        return "error, lol";
    }
}
