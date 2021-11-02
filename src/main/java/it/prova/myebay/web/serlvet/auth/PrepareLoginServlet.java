package it.prova.myebay.web.serlvet.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

@WebServlet("/PrepareLoginServlet")
public class PrepareLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAnnuncioParam = request.getParameter("idAnnuncio");
		
		if (!NumberUtils.isCreatable(idAnnuncioParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.(id)");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}
		
		request.setAttribute("idAnnuncio", idAnnuncioParam);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

}
