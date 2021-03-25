package ua.axiom.aggregator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PostLoginHandleController {
    @PostMapping
    protected void redditPostLoginHandle(
            @RequestParam(required = false) String error,
            @RequestParam String code,
            @RequestParam String state) {
        if(error != null) {
            System.out.println(error);
        }



    }
}
