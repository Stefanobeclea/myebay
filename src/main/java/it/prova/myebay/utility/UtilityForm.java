package it.prova.myebay.utility;

import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.myebay.model.Acquisto;
import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Categoria;
import it.prova.myebay.model.Utente;



public class UtilityForm {

	public static Annuncio createAnnuncioFromParams(String testoAnnuncioInputParam, String prezzoInputParam,
			 String dataStringParam, String utenteIdStringInserimentoParam) {

		Annuncio result = new Annuncio(testoAnnuncioInputParam);
		if (NumberUtils.isCreatable(prezzoInputParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputParam));
		}
		result.setData(parseDateArrivoFromString(dataStringParam));
		if (NumberUtils.isCreatable(utenteIdStringInserimentoParam)) {
			result.setUtenteInserimento(new Utente(Long.parseLong(utenteIdStringInserimentoParam)));
		}
		return result;
	}

	public static boolean validateAnnuncioBean(Annuncio annuncioToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(annuncioToBeValidated.getTestoAnnuncio())
				|| annuncioToBeValidated.getPrezzo() < 0
				|| annuncioToBeValidated.getUtenteInserimento() == null
				|| annuncioToBeValidated.getUtenteInserimento().getId() == null 
				|| annuncioToBeValidated.getUtenteInserimento().getId() < 1
				|| annuncioToBeValidated.getData() == null) {
			return false;
		}
		return true;
	}
	
	public static Acquisto createAcquistoFromParams(String descrizioneInputParam, String prezzoInputParam,
			 String dataStringParam, String utenteIdStringParam) {

		Acquisto result = new Acquisto(descrizioneInputParam);
		if (NumberUtils.isCreatable(prezzoInputParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputParam));
		}
		result.setData(parseDateArrivoFromString(dataStringParam));
		if (NumberUtils.isCreatable(utenteIdStringParam)) {
			result.setUtenteAcquirente(new Utente(Long.parseLong(utenteIdStringParam)));
		}
		return result;
	}

	public static boolean validateAcquistoBean(Acquisto acquistoToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(acquistoToBeValidated.getDescrizione())
				|| acquistoToBeValidated.getPrezzo() < 1
				|| acquistoToBeValidated.getData() == null
				|| acquistoToBeValidated.getUtenteAcquirente() == null
				|| acquistoToBeValidated.getUtenteAcquirente().getId() == null 
				|| acquistoToBeValidated.getUtenteAcquirente().getId() < 1) {
			return false;
		}
		return true;
	}
	
	public static Categoria createCategoriaFromParams(String descrizioneInputParam, String codiceInputParam) {

		Categoria result = new Categoria(descrizioneInputParam, codiceInputParam);
		return result;
	}

	public static boolean validateCategoriaBean(Categoria categoriaToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(categoriaToBeValidated.getDescrizione())
				|| StringUtils.isBlank(categoriaToBeValidated.getCodice())) {
			return false;
		}
		return true;
	}
	
	public static boolean validateUtenteBean(Utente utenteToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(utenteToBeValidated.getNome())
				|| StringUtils.isBlank(utenteToBeValidated.getCognome())
				|| StringUtils.isBlank(utenteToBeValidated.getUsername())
				|| StringUtils.isBlank(utenteToBeValidated.getPassword())
				|| utenteToBeValidated.getCreditoResiduo() < 0
				|| utenteToBeValidated.getStato() == null
				|| utenteToBeValidated.getDateCreated() == null)
				{
			return false;
		}
		return true;
	}

	public static Date parseDateArrivoFromString(String dataStringParam) {
		if (StringUtils.isBlank(dataStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataStringParam);
		} catch (ParseException e) {
			return null;
		}
	}
}
