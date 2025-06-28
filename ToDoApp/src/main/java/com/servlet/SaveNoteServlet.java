package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.note;
import com.helper.FactoryProvider;

@WebServlet("/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveNoteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String title = request.getParameter("title");
			String description = request.getParameter("description");

			note n = new note(title, description, new Date());

			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();

			s.save(n);

			tx.commit();

			s.close();

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			request.getRequestDispatcher("/navbar.jsp").include(request, response);
			out.println("<h1 style='text-align:center;'>The note is added</h1>");
			out.println("<br>\n");
			out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View all notes</a></h1>");
			request.getRequestDispatcher("/footer.jsp").include(request, response);
			out.println("</body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
