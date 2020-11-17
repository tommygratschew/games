package demo.project.hh.games;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import demo.project.hh.games.web.GameController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GamesApplicationTests {
	
	@Autowired
	private GameController gameController;

	@Test
	void contextLoads() throws Exception {
		assertThat(gameController).isNotNull();
	}

}
