package ua.axiom.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.axiom.aggregator.dto.FeedDto;
import ua.axiom.aggregator.service.feed.FeedService;

import java.security.Principal;

@Controller
public class FeedController {
    protected final FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/feed")
    protected String formGetResponse(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model.addAttribute("role", currentPrincipalName);
        return "feed.html";
    }

    @GetMapping("/feed/page")
    @ResponseBody
    protected FeedDto getFeed(Integer feedpage, Principal principal) {
        String username = principal.getName();

        return feedService.getFeedDto(feedpage, username);

    }


}
