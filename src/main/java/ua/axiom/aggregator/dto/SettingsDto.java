package ua.axiom.aggregator.dto;

import java.util.Collection;

/**
 * Transfers non-confidential data about present keys
 */
public class SettingsDto {
    public static class KeyInfo {
        private String site;
    }

    private Collection<KeyInfo> keys;

    public SettingsDto(Collection<KeyInfo> keys) {
        this.keys = keys;
    }

    public Collection<KeyInfo> getKeys() {
        return keys;
    }
}
