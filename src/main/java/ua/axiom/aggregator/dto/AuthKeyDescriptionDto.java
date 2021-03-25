package ua.axiom.aggregator.dto;

import ua.axiom.aggregator.model.persistance.AuthKeyDescription;

/**
 * Dto for auth key description, so it can be serialized
 */
public class AuthKeyDescriptionDto {
    private long id;

    public AuthKeyDescriptionDto(AuthKeyDescription keyDescription) {
        this.id = keyDescription.getId();
    }

    public long getId() {
        return id;
    }
}
