package ua.axiom.aggregator.service.feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.axiom.aggregator.dto.FeedEntryDto;
import ua.axiom.aggregator.repository.AuthKeysRepository;

import java.util.Collection;

@Service
public class RedditFeedService implements FeedSourceI {
    private final AuthKeysRepository keysRepository;
    private final RestTemplate restTemplate;


    @Autowired
    public RedditFeedService(
            AuthKeysRepository keysRepository,
            RestTemplate restTemplate
    ) {
        this.keysRepository = keysRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Collection<FeedEntryDto> getEntries(int from, int count, String forUsername) {


        return null;
    }
}
