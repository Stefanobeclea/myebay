package it.prova.myebay.web.serlvet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;
import it.prova.myebay.utility.UtilityForm;


@WebServlet("/user/ExecuteSearchAnnuncioUtenteServlet")
public class ExecuteSearchAnnuncioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzoParam = request.getParameter("prezzo");
		String dataInserimentoParam = request.getParameter("data");		
		
		
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			Utente utenteInSessione = (Utente)httpRequest.getSession().getAttribute("userInfo");
			Annuncio example = new Annuncio( testoAnnuncioParam, Integer.parseInt(prezzoParam), 
					UtilityForm.parseDateArrivoFromString(dataInserimentoParam), utenteInSessione);
			
			
			request.setAttribute("annuncio_list_attribute",
					MyServiceFactory.getAnnuncioServiceInstance().findByExample(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/annuncio/searchutente.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/annuncio/listutente.jsp").forward(request, response);
	}

}
