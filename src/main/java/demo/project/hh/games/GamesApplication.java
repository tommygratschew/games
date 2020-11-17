package demo.project.hh.games;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.project.hh.games.domain.Game;
import demo.project.hh.games.domain.GameRepository;
import demo.project.hh.games.domain.Genre;
import demo.project.hh.games.domain.GenreRepository;
import demo.project.hh.games.domain.User;
import demo.project.hh.games.domain.UserRepository;

@SpringBootApplication
public class GamesApplication {
	private static final Logger log = LoggerFactory.getLogger(GamesApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GamesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(GameRepository repository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			
			grepository.save(new Genre("MMORPG"));
			grepository.save(new Genre("FPS"));
			grepository.save(new Genre("TBS"));
			grepository.save(new Genre("Sandbox"));
			grepository.save(new Genre("Simulation"));
			
			repository.save(new Game("Minecraft", "Mojang", 2009, 93, grepository.findByName("Sandbox").get(0)));
			repository.save(new Game("Counter-Strike: Global Offensive", "Valve", 2012, 83, grepository.findByName("FPS").get(0)));
			repository.save(new Game("Old School Runescape", "Jagex", 2013, 87, grepository.findByName("MMORPG").get(0)));
			repository.save(new Game("Sid Meier's Civilization V", "Firaxis", 2010, 90, grepository.findByName("TBS").get(0)));
			repository.save(new Game("ARMA 2", "Bohemia Interactive", 2009, 77, grepository.findByName("Simulation").get(0)));
			
			User user1 = new User("user", "$2a$10$GH/93SFB9Nrxu1V07QyGjuCY8rrz17ZIxJ2631e7KM5hHDFVKWmwO", "USER");
			User user2 = new User("admin", "$2a$10$n0KoYGbmyAwak6CcMxluL.torTqYCcDcH3hrgOAv0b4bCQoOkVNpm", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all games");
			for (Game game : repository.findAll()) {
				log.info(game.toString());
			}
		};
	}

}
