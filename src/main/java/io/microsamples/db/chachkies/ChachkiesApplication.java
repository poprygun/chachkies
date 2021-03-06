package io.microsamples.db.chachkies;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class ChachkiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChachkiesApplication.class, args);
    }

}

@Component
@Slf4j
class ChachkiesLoader implements ApplicationListener<ApplicationStartedEvent> {

    private JpaRepository<Chachkie, UUID> chachkieRepository;

    private EasyRandom easyRandom;

    public ChachkiesLoader(JpaRepository<Chachkie, UUID> chachkieRepository) {
        EasyRandomParameters parameters = new EasyRandomParameters();
        easyRandom = new EasyRandom(parameters);
        this.chachkieRepository = chachkieRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info("Total --> {} rows", chachkieRepository.count());
        final List<Chachkie> chachkies = chachkieRepository.saveAll(easyRandom.objects(Chachkie.class, 13)::iterator);
        chachkies.stream().forEach(c -> log.info("Saved {}", c));
    }
}

@Component
@AllArgsConstructor
class Query implements GraphQLQueryResolver {
    private ChachkiesService chachkiesService;

    public List<Chachkie> getAllChachkies() {
        return chachkiesService.allChachkies();
    }
}

@Repository
interface ChachkieRepository extends JpaRepository<Chachkie, UUID> {

}