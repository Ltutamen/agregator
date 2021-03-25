package ua.axiom.aggregator.service.feed;

import ua.axiom.aggregator.dto.FeedEntryDto;

import java.util.Collection;

public interface FeedSourceI {

    Collection<FeedEntryDto> getEntries(int from, int count, String forUsername);
}
