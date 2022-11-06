package org.alien.heimdall.services.impl;

import com.google.common.hash.Hashing;
import org.alien.heimdall.entity.HeimdallEntity;
import org.alien.heimdall.repos.HeimdallRepo;
import org.alien.heimdall.services.HeimdallService;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class HeimdallServiceImpl implements HeimdallService {

    @Autowired
    private HeimdallRepo heimdallRepo;

    @Override
    public String createShortUrl(String url) {
        HeimdallEntity heimdallEntity = generateShortUrl(url);
        heimdallEntity = heimdallRepo.save(heimdallEntity);
        return heimdallEntity.getShortUrl();
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        HeimdallEntity heimdallEntity = heimdallRepo.findByShortUrl(shortUrl);
        return heimdallEntity.getShortUrl();
    }

    private HeimdallEntity generateShortUrl(String url) {
        HeimdallEntity heimdallEntity = new HeimdallEntity();
        heimdallEntity.setLongUrl(url);
        UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});
        String id = null;
        if (urlValidator.isValid(url)) {
            id = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
        }
        heimdallEntity.setShortUrl(id);
        heimdallEntity.setCreatedAt(new Date());
        return heimdallEntity;
    }

}
