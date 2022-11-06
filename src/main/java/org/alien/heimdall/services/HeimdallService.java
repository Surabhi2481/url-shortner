package org.alien.heimdall.services;

public interface HeimdallService {
    String createShortUrl(String url);

    String getOriginalUrl(String url);
}
