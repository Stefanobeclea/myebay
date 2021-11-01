package it.prova.myebay.web.serlvet.annuncio;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/PrepareSearchAnnuncioUtenteServlet")
public class PrepareSearchAnnuncioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/annuncio/searchutente.jsp").forward(request, response);
	}

}
