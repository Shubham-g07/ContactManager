package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.note;
import com.helper.FactoryProvider;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// for getting note id from the request as note is a parameter and we've parsed
			// it into integer.
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());

			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			// after this session has a delete function and in that function we have to pass
			// the object
			// first create the object to pass it in delete

			note n = (note) session.get(note.class, noteId);
			session.delete(n);
			tx.commit();
			session.close();

			response.sendRedirect("all_notes.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
