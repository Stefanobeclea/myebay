package it.prova.myebay.web.serlvet.annuncio;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.service.MyServiceFactory;
import it.prova.myebay.utility.UtilityForm;


@WebServlet("/ExecuteSearchsAnnuncioServlet")
public class ExecuteSearchsAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzoParam = request.getParameter("prezzo");
		String dataInserimentoParam = request.getParameter("dataInserimento");

		Annuncio example = new Annuncio( testoAnnuncioParam, Integer.parseInt(prezzoParam), 
				UtilityForm.parseDateArrivoFromString(dataInserimentoParam));

		try {
			request.setAttribute("annuncio_list_attribute",
					MyServiceFactory.getAnnuncioServiceInstance().findByExample(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/annuncio/search.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/annuncio/list.jsp").forward(request, response);
	}

}
