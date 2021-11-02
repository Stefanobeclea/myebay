package it.prova.myebay.web.serlvet.acquisto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import it.prova.myebay.model.Acquisto;
import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteListAcquistoServlet
 */
@WebServlet("/user/ExecuteListAcquistoServlet")
public class ExecuteListAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// se nell'url della request è presente SUCCESS significa che devo mandare un
			// messaggio di avvenuta operazione in pagina
			String operationResult = request.getParameter("operationResult");
			if (StringUtils.isNotBlank(operationResult) && operationResult.equalsIgnoreCase("SUCCESS"))
				request.setAttribute("successMessage", "Operazione effettuata con successo");
			if (StringUtils.isNotBlank(operationResult) && operationResult.equalsIgnoreCase("ERROR"))
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			if (StringUtils.isNotBlank(operationResult) && operationResult.equalsIgnoreCase("NOT_FOUND"))
				request.setAttribute("errorMessage", "Elemento non trovato.");

			HttpServletRequest httpRequest = (HttpServletRequest) request;
			Utente utenteInSessione = (Utente)httpRequest.getSession().getAttribute("userInfo");
			Acquisto example = new Acquisto(utenteInSessione);
			request.setAttribute("acquisto_list_attribute",
					MyServiceFactory.getAcquistoServiceInstance().findByExampleEager(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/acquisto/list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
