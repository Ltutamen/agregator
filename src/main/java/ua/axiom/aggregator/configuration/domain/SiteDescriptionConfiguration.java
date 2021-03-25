package ua.axiom.aggregator.configuration.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.axiom.aggregator.model.SiteDescription;

@Configuration
public class SiteDescriptionConfiguration {

    @Bean
    protected SiteDescription redditSiteDescription() {
        return new SiteDescription("Reddit", "https://upload.wikimedia.org/wikipedia/commons/b/b4/Reddit_logo.svg", "settings/reddit/login");
    }

    @Bean
    protected SiteDescription tumblerSiteDescription() {
        return new SiteDescription("Tumblr", "https://upload.wikimedia.org/wikipedia/commons/2/2c/Tumblr_Logo.svg", "settings/tumblr/login");
    }
}
