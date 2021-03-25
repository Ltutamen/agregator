package ua.axiom.aggregator.service.feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.axiom.aggregator.dto.FeedDto;
import ua.axiom.aggregator.dto.FeedEntryDto;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FeedService {
    private static final int DEFAULT_RETURN_ENTRIES_COUNT = 10;
    private static final int ENTRIES_CACHE_MULTIPLIER = 3;

    private final Collection<FeedSourceI> feedSources;

    @Autowired
    public FeedService(Collection<FeedSourceI> feedSources) {
        this.feedSources = new ArrayList<>(feedSources);
    }

    public FeedDto getFeedDto(int page, String username) {
        SortedSet<FeedEntryDto> feedEntryDtos = new TreeSet<>(Comparator.comparing(FeedEntryDto::getTimestamp));


        for(FeedSourceI feedSource : feedSources) {
            Collection<FeedEntryDto> forSiteFeedEntries = feedSource.getEntries(
                    page * DEFAULT_RETURN_ENTRIES_COUNT,
                    DEFAULT_RETURN_ENTRIES_COUNT * ENTRIES_CACHE_MULTIPLIER,
                    username);
            feedEntryDtos.addAll(forSiteFeedEntries);
        }

        List<FeedEntryDto> feedEntriesSortedList = feedEntryDtos.stream()
                .limit(DEFAULT_RETURN_ENTRIES_COUNT)
                .collect(Collectors.toList());

        return new FeedDto(feedEntriesSortedList);

/*        List<FeedEntryDto> feedEntries = Stream.
                iterate(0, p -> p + 1)
                .map(dec -> page * 10 + dec)
                .limit(10)
                .map(number -> new FeedEntryDto(number.toString(), Collections.emptyList()))
                .collect(Collectors.toList());

        return new FeedDto(feedEntries);*/
    }

}
