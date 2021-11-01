package it.prova.myebay.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "annuncio")
public class Annuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "testoAnnuncio")
	private String testoAnnuncio;
	@Column(name = "prezzo")
	private int prezzo;
	@Column(name = "data")
	private Date data;
	@Column(name = "aperto")
	private boolean aperto;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id")
	private Utente utenteInserimento;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "annuncio_categoria", joinColumns = @JoinColumn(name = "annuncio_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie = new HashSet<Categoria>();
	
	public Annuncio() {
		// TODO Auto-generated constructor stub
	}

	public Annuncio(String testoAnnuncio, int prezzo, Date data, boolean aperto) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.data = data;
		this.aperto = aperto;
	}

	public Annuncio(String testoAnnuncio, int prezzo, Date data, Utente utenteInserimento) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.data = data;
		this.utenteInserimento = utenteInserimento;
	}

	public Annuncio(String testoAnnuncio, int prezzo, Date data) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.data = data;
	}

	public Annuncio(String testoAnnuncio, int prezzo, Date data, boolean aperto, Utente utenteInserimento) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.data = data;
		this.aperto = aperto;
		this.utenteInserimento = utenteInserimento;
	}

	public Annuncio(String testoAnnuncio, int prezzo, Date data, boolean aperto, Utente utenteInserimento,
			Set<Categoria> categorie) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.data = data;
		this.aperto = aperto;
		this.utenteInserimento = utenteInserimento;
		this.categorie = categorie;
	}

	public Annuncio(String testoAnnuncio) {
		super();
		this.testoAnnuncio = testoAnnuncio;
	}

	public Long getId() {
		return id;
	}

	public String getTestoAnnuncio() {
		return testoAnnuncio;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public Date getData() {
		return data;
	}

	public boolean isAperto() {
		return aperto;
	}

	public Utente getUtenteInserimento() {
		return utenteInserimento;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTestoAnnuncio(String testoAnnuncio) {
		this.testoAnnuncio = testoAnnuncio;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setAperto(boolean aperto) {
		this.aperto = aperto;
	}

	public void setUtenteInserimento(Utente utenteInserimento) {
		this.utenteInserimento = utenteInserimento;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}
	
}
