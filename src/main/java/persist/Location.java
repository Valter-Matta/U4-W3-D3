package persist;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "location")
public class Location {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (nullable = false)

	private String nome;

	@Column (name = "città", nullable = false)
	private String city;

	@OneToMany (mappedBy = "location", cascade = CascadeType.ALL)
	private List<Evento> eventi = new ArrayList<>();

	// Costruttori
	public Location () {
	}

	public Location (String nome, String city) {
		this.nome = nome;
		this.city = city;
	}

	// Getters e Setters
	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public String getNome () {
		return nome;
	}

	public void setNome (String nome) {
		this.nome = nome;
	}

	public String getCitta () {
		return city;
	}

	public void setCitta (String city) {
		this.city = city;
	}

	public List<Evento> getEventi () {
		return eventi;
	}

	public void setEventi (List<Evento> eventi) {
		this.eventi = eventi;
	}

}
