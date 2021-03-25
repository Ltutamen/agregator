package ua.axiom.aggregator.dto;

import java.util.ArrayList;
import java.util.List;

public class FeedDto {
    protected List<FeedEntryDto> feedEntries;

    public FeedDto(List<FeedEntryDto> feedEntries) {
        this.feedEntries = new ArrayList<>(feedEntries);
    }

    public List<FeedEntryDto> getFeedEntries() {
        return feedEntries;
    }
}
