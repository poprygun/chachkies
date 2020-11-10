package io.microsamples.db.chachkies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChachkiesService {
    private JpaRepository<Chachkie, UUID> chachkieRepository;

    public ChachkiesService(JpaRepository<Chachkie, UUID> chachkieRepository) {
        this.chachkieRepository = chachkieRepository;
    }

    public List<Chachkie> allChachkies() {
        return chachkieRepository.findAll();
    }
}
