package org.alien.heimdall.repos;

import org.alien.heimdall.entity.HeimdallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeimdallRepo extends JpaRepository<HeimdallEntity, Long>{
    @Query(nativeQuery = true, value = "select *" + "from urlShortener" + "where shortUrl = :shortUrl")
    HeimdallEntity findByShortUrl(@Param("shortUrl") String shortUrl);
}
