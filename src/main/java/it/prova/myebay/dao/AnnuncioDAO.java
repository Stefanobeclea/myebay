package it.prova.myebay.dao;

import java.util.List;
import java.util.Optional;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Utente;

public interface AnnuncioDAO extends IBaseDAO<Annuncio>{
	public Optional<Annuncio> findOneEager(Long id) throws Exception;
	
	public List<Annuncio> findByExample(Annuncio example) throws Exception;
	
	public List<Annuncio> findByExampleEager(Annuncio example) throws Exception;
	
	public List<Annuncio> findByUtente(Utente example) throws Exception;
	
}
