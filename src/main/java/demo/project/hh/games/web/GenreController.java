package demo.project.hh.games.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.project.hh.games.domain.Genre;
import demo.project.hh.games.domain.GenreRepository;

@Controller
public class GenreController {

	@Autowired
	private GenreRepository repository;
	
	@RequestMapping(value = "/genrelist")
	public String genreList(Model model) {
		model.addAttribute("genres", repository.findAll());
		return "genrelist";
	}
	
	@RequestMapping(value = "/addg")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}
	
	@RequestMapping(value = "/savegenre", method = RequestMethod.POST)
	public String saveGenre(Genre genre) {
		repository.save(genre);
		return "redirect:genrelist";
	}
	
}
