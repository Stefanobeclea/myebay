package it.prova.myebay.dao;

import java.util.List;

import it.prova.myebay.model.Annuncio;

public interface AnnuncioDAO extends IBaseDAO<Annuncio>{
	public List<Annuncio> findByExample(Annuncio example) throws Exception;
}
