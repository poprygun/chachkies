package io.microsamples.db.chachkies;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Data
@ToString
public class Chachkie {
    @Id
    private String id;
    private String name;
    private Instant createdAt;
}
