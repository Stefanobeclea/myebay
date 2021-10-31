package it.prova.myebay.dao;

import java.util.List;  
import java.util.Optional;

import it.prova.myebay.model.Ruolo;
import it.prova.myebay.model.Utente;


public interface UtenteDAO extends IBaseDAO<Utente> {
	
	public List<Utente> findAllByRuolo(Ruolo ruoloInput);
	public Optional<Utente> findByUsernameAndPassword(String username,String password);
	public Optional<Utente> login(String username,String password);
	public List<Utente> findByExample(Utente example) throws Exception;
	

}
