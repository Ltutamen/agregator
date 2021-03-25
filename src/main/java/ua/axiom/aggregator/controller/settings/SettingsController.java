package ua.axiom.aggregator.controller.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.axiom.aggregator.dto.SettingsPageDataDto;
import ua.axiom.aggregator.model.SiteDescription;
import ua.axiom.aggregator.service.KeyPersistenceService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SettingsController {
    private static final String VIEW_NAME = "settings.html";

    private Map<String, SiteDescription> siteNamesAndDescriptionMap = new HashMap<>();

    private final KeyPersistenceService keyService;

    @Autowired
    public SettingsController(
            KeyPersistenceService keyService,
            Collection<SiteDescription> siteDescriptions
    ) {
        this.keyService = keyService;

        siteDescriptions.forEach(sd -> siteNamesAndDescriptionMap.put(sd.getName(), sd));
    }

    @RequestMapping("/settings")
    protected String getMappingView() {
        return VIEW_NAME;
    }

    @GetMapping(value = "/settings/pagedata", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    protected SettingsPageDataDto getPageDatForUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return new SettingsPageDataDto(siteNamesAndDescriptionMap, keyService.getKeyDescriptionsForUsername(currentPrincipalName));
    }

    /**
     * Delete one of the keys
     */
    @PostMapping("/settings")
    protected void deleteKey(String body, String path) {
        System.out.println("delete with id:" + body);
    }



}
