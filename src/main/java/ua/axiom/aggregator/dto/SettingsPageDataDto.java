package ua.axiom.aggregator.dto;

import ua.axiom.aggregator.model.SiteDescription;
import ua.axiom.aggregator.model.persistance.AuthKeyDescription;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Represent auth keys settings page data
 * contains site description(logo, name, etc) and collection of auth keys descriptions
 */
public class SettingsPageDataDto {
    private static class SiteDescriptionAndKeysDescriptions {

        private final SiteDescription siteDescription;

        private final List<AuthKeyDescriptionDto> keyDescriptions;

        public SiteDescriptionAndKeysDescriptions(SiteDescription siteDescription) {
            this.siteDescription = siteDescription;
            this.keyDescriptions = new ArrayList<>();
        }

        public SiteDescription getSiteDescription() {
            return siteDescription;
        }

        public List<AuthKeyDescriptionDto> getKeyDescriptions() {
            return keyDescriptions;
        }

        public void addKeyDescription(AuthKeyDescriptionDto keyDescription) {
            keyDescriptions.add(keyDescription);
        }
    }

    private final Collection<SiteDescriptionAndKeysDescriptions> keyDefinitions = new ArrayList<>();


    public SettingsPageDataDto(
            Map<String, SiteDescription> siteNameToSiteDescriptions,
            Collection<AuthKeyDescription> keyDescriptions
    ) {
        siteNameToSiteDescriptions.keySet().forEach(siteName -> {
            SiteDescriptionAndKeysDescriptions siteDescriptionAndKeysDescriptions = new SiteDescriptionAndKeysDescriptions(siteNameToSiteDescriptions.get(siteName));
            keyDefinitions.add(siteDescriptionAndKeysDescriptions);

            String lowerCaseSiteName = siteName.toLowerCase();

            keyDescriptions.forEach(keyDescription -> {
                if(keyDescription.getSiteName().equals(lowerCaseSiteName)) {
                    siteDescriptionAndKeysDescriptions.addKeyDescription(new AuthKeyDescriptionDto(keyDescription));
                }
            });

        });
    }

    public Collection<SiteDescriptionAndKeysDescriptions> getKeyDefinitions() {
        return keyDefinitions;
    }
}
