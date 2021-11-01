package it.prova.myebay.web.serlvet.acquisto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Acquisto;
import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;
import it.prova.myebay.utility.UtilityForm;


@WebServlet("/user/ExecuteSearchAcquistoServlet")
public class ExecuteSearchAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descrizioneParam = request.getParameter("descrizione");
		String prezzoParam = request.getParameter("prezzo");
		String dataInserimentoParam = request.getParameter("data");		
		
		
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			Utente utenteInSessione = (Utente)httpRequest.getSession().getAttribute("userInfo");
			Acquisto example = new Acquisto( descrizioneParam, Integer.parseInt(prezzoParam), 
					UtilityForm.parseDateArrivoFromString(dataInserimentoParam), utenteInSessione);
			
			
			request.setAttribute("acquisto_list_attribute",
					MyServiceFactory.getAcquistoServiceInstance().findByExampleEager(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/acquisto/searchutente.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/acquisto/list.jsp").forward(request, response);
	}

}
