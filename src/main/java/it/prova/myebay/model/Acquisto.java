package it.prova.myebay.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acquisto")
public class Acquisto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "prezzo")
	private int prezzo;
	@Column(name = "data")
	private Date data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id")
	private Utente utenteAcquirente;
	
	public Acquisto() {
		// TODO Auto-generated constructor stub
	}

	public Acquisto(String descrizione, int prezzo, Date data, Utente utenteAcquirente) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.data = data;
		this.utenteAcquirente = utenteAcquirente;
	}

	public Acquisto(String descrizione) {
		super();
		this.descrizione = descrizione;
	}

	public Acquisto(String descrizione, int prezzo, Date data) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public Date getData() {
		return data;
	}

	public Utente getUtenteAcquirente() {
		return utenteAcquirente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setUtenteAcquirente(Utente utenteAcquirente) {
		this.utenteAcquirente = utenteAcquirente;
	}
	
}
