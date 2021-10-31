package it.prova.myebay.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "codice")
	private String codice;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
	private Set<Annuncio> articoli = new HashSet<Annuncio>();
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public Categoria(String descrizione) {
		super();
		this.descrizione = descrizione;
	}

	public Categoria(String descrizione, Set<Annuncio> articoli) {
		super();
		this.descrizione = descrizione;
		this.articoli = articoli;
	}

	public Long getId() {
		return id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public Set<Annuncio> getArticoli() {
		return articoli;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setArticoli(Set<Annuncio> articoli) {
		this.articoli = articoli;
	}

	
}
