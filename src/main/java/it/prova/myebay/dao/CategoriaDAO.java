package it.prova.myebay.dao;


import it.prova.myebay.model.Categoria; 


public interface CategoriaDAO extends IBaseDAO<Categoria>{
	public Categoria findByDescrizione(String descrizioneInput) throws Exception;
	
}
