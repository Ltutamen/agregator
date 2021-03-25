package ua.axiom.aggregator.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FeedEntryDto {
    protected String text;
    protected List<String> mediaLinks;
    protected Integer timestamp;

    public FeedEntryDto(String text, Collection<String> mediaLinks) {
        this.text = text;
        this.mediaLinks = new ArrayList<>(mediaLinks);
    }

    public String getText() {
        return text;
    }

    public List<String> getMediaLinks() {
        return mediaLinks;
    }

    public Integer getTimestamp() {
        return timestamp;
    }
}
