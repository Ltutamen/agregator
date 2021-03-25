package ua.axiom.aggregator.controller.settings;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.axiom.aggregator.service.KeyPersistenceService;
import ua.axiom.aggregator.service.SettingsService;

@Controller
public class RedditSettingsController {
    private KeyPersistenceService keyService;
    private SettingsService settingsService;

    @Autowired
    public RedditSettingsController(KeyPersistenceService keyService) {
        this.keyService = keyService;
    }

    @Value("${secret.reddit.client_id}")
    private String clientId;
    private String state = "11112222";

    @GetMapping("settings/reddit/login")
    protected String redditLogin() {

        return "redirect:http://reddit.com/api/v1/authorize?client_id=" +
        clientId +
        "&response_type=code&state=" +
        state +
        "&redirect_uri=http://localhost:8099/settings/reddit/login/pl&duration=permanent&scope=mysubreddits";
    }


    @RequestMapping("settings/reddit/login/pl")
    protected String redditLoginCodeProcessor(String state, String code) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        keyService.addKey(code, currentPrincipalName, "reddit");

        return "redirect:/settings";

    }


}
