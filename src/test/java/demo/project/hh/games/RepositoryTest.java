package demo.project.hh.games;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import demo.project.hh.games.domain.Game;
import demo.project.hh.games.domain.GameRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {

	
	@Autowired
	private GameRepository gRepository;
	
	@Test
	public void findByNameShouldReturnGame() {
		List<Game> games = gRepository.findByName("Minecraft");
		
		assertThat(games).hasSize(1);
		assertThat(games.get(0).getStudio()).isEqualTo("Mojang");
	}
	
	@Test
	public void createNewGame() {
		Game game = new Game("asd", "asd", 2020, 100, null);
		gRepository.save(game);
		assertThat(game.getId()).isNotNull();
	}
	
}
