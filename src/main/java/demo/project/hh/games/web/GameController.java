package demo.project.hh.games.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.project.hh.games.domain.Game;
import demo.project.hh.games.domain.GameRepository;
import demo.project.hh.games.domain.GenreRepository;

@Controller
public class GameController {
	
	@Autowired
	private GameRepository repository;
	
	@Autowired
	private GenreRepository grepository;
	
	// Login
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	// Listing
	@RequestMapping(value= {"/", "/gamelist"})
	public String gameList(Model model) {
		model.addAttribute("games", repository.findAll());
		return "gamelist";
	}
	
	//REST
	@RequestMapping(value="/games", method = RequestMethod.GET)
	public @ResponseBody List<Game> gameListRest() {
		return (List<Game>) repository.findAll();
	}
	
	@RequestMapping(value="/game/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Game> findGameRest(@PathVariable("id") Long GameId) {
		return repository.findById(GameId);
	}
	
	@RequestMapping(value="games", method = RequestMethod.POST)
	public @ResponseBody Game saveGameRest(@RequestBody Game game) {
		return repository.save(game);
	}
	
	@RequestMapping(value = "/add")
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("genres", grepository.findAll());
		return "addgame";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Game game) {
		repository.save(game);
		return "redirect:gamelist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("id") Long gameId, Model model) {
		repository.deleteById(gameId);
		return "redirect:../gamelist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/update/{id}")
	public String updateGame(@PathVariable("id") Long gameId, Model model) {
		 model.addAttribute("game", repository.findById(gameId));
		 model.addAttribute("genres", grepository.findAll());
		 return "updategame";
	}
}
