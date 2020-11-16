package demo.project.hh.games.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String studio;
	private int release;
	private int metacritic;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "idGenre")
	private Genre genre;
	
	public Game() {}

	public Game(String name, String studio, int release, int metacritic, Genre genre) {
		super();
		this.name = name;
		this.studio = studio;
		this.release = release;
		this.metacritic = metacritic;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public int getRelease() {
		return release;
	}

	public void setRelease(int release) {
		this.release = release;
	}

	public int getMetacritic() {
		return metacritic;
	}

	public void setMetacritic(int metacritic) {
		this.metacritic = metacritic;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		if (this.genre !=null)
		return "Game [id=" + id + ", name=" + name + ", studio=" + studio + ", release=" + release + ", metacritic="
				+ metacritic + ", genre=" + this.getGenre() + "]";
		else
			return "Game [id=" + id + ", name=" + name + ", studio=" + studio + ", release=" + release + ", metacritic="
			+ metacritic + "]";
	}
		
}
