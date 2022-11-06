package org.alien.heimdall.entity;


import lombok.*;

import java.util.Date;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "urlShortener")
public class HeimdallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "longUrl")
    private String longUrl;

    @Column(name = "shortUrl")
    private String shortUrl;

    @Column(name = "createdAt")
    private Date createdAt;
}
