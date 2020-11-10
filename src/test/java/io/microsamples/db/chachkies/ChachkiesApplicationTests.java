package io.microsamples.db.chachkies;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChachkiesApplicationTests {

	@LocalServerPort
	private int localPort;

	@Test
	public void contextLoads() {
	}

}
