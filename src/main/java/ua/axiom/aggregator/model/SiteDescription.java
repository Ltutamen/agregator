package ua.axiom.aggregator.model;

public class SiteDescription {
    private final String name;
    private final String logoUrl;
    private final String loginUrl;

    public SiteDescription(String name, String logoUrl, String loginUrl) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.loginUrl = loginUrl;
    }

    public String getName() {
        return name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }
}
