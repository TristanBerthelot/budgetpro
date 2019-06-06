package com.budgetpro.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.budgetpro.beans.Profil;
import com.budgetpro.forms.DonneesFormulaire;

@WebServlet("/express/")
public class BudgetExpress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BudgetExpress() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Profil test = new Profil("Jean", "test@test", "blablabla");
		request.setAttribute("test", test);
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/budgetexpress.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonneesFormulaire form = new DonneesFormulaire(request);
		try {
			request.setAttribute("loyer", form.getCategorie("loyer"));
			request.setAttribute("nourriture", form.getCategorie("nourriture"));
			request.setAttribute("abonnements", form.getCategorie("abonnements"));
			request.setAttribute("charges", form.getCategorie("charges"));
			request.setAttribute("sorties", form.getCategorie("sorties"));
			request.setAttribute("divers", form.getCategorie("divers"));
			request.setAttribute("epargne", form.getCategorie("epargne"));
			request.setAttribute("message", form.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/budgetexpress.jsp").forward(request, response);
	}

}
