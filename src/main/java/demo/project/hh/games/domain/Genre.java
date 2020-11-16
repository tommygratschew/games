package demo.project.hh.games.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Genre {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long idGenre;
		private String name;
		
		@JsonBackReference
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
		private List<Game> games;
		
		public Genre() {}

		public Genre(String name) {
			super();
			this.name = name;
		}

		public long getIdGenre() {
			return idGenre;
		}

		public void setIdGenre(long idGenre) {
			this.idGenre = idGenre;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Game> getGames() {
			return games;
		}

		public void setGames(List<Game> games) {
			this.games = games;
		}

		@Override
		public String toString() {
			return "Genre [idGenre=" + idGenre + ", name=" + name + "]";
		}
			
}
