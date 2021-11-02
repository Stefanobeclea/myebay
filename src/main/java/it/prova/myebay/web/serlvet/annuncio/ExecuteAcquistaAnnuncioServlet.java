package it.prova.myebay.web.serlvet.annuncio;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.myebay.exceptions.ElementNotFoundException;
import it.prova.myebay.exceptions.InsufficientFundsException;
import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;


@WebServlet("/user/ExecuteAcquistaAnnuncioServlet")
public class ExecuteAcquistaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("idAnnuncio");
		
		if (!NumberUtils.isCreatable(idParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore. (id)");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
			try {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				
				MyServiceFactory.getAnnuncioServiceInstance().acquista(idParam, (Utente)httpRequest.getSession().getAttribute("userInfo"));				
				
			} catch (ElementNotFoundException e) {
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
				request.getRequestDispatcher("/home").forward(request, response);
				return;
			}catch (InsufficientFundsException e) {
				request.setAttribute("errorMessage", "Attenzione, credito residuo insufficiente.");
				request.getRequestDispatcher("/annuncio/acquista.jsp").forward(request, response);
				return;
			} catch (Exception e) {
				// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
				e.printStackTrace();
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
				request.getRequestDispatcher("/home").forward(request, response);
				return;
			}

			response.sendRedirect("ExecuteListAcquistoServlet?operationResult=SUCCESS");
		}
	}
