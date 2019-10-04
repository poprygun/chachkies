package io.microsamples.db.chachkies;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@GraphQLApi
public class ChachkiesService {
    private JpaRepository<Chachkie, UUID> chachkieRepository;

    public ChachkiesService(JpaRepository<Chachkie, UUID> chachkieRepository) {
        this.chachkieRepository = chachkieRepository;
    }

    @GraphQLQuery
    public List<Chachkie> allChachkies() {
        return chachkieRepository.findAll();
    }
}
