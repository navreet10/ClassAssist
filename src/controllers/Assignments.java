package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import model.Studentca;

/**
 * Servlet implementation class Assignments
 */
@WebServlet("/Assignments")
public class Assignments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assignments() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("in assgns");
			HttpSession session = request.getSession();
			String student = request.getParameter("student");
			String type = request.getParameter("type");
			List<Studentca> result = null;
			session.setAttribute("average", null);
			session.setAttribute("result", null);
			session.setAttribute("high", null);
			session.setAttribute("low", null);
			session.setAttribute("message", null);
			if ((student == null || student.equalsIgnoreCase("")) && (type == null || type.equalsIgnoreCase(""))) {

				result = Dao.getAllAssigns();
			} else if (student == null || student.equalsIgnoreCase("")) {
				result = Dao.getTypeAssigns(type);
			} else if (type == null || type.equalsIgnoreCase("")) {
				result = Dao.getStudentAssigns(student);
			} else {
				result = Dao.getStudentTypeAssigns(student,type);
			}
			if (result == null ||result.size()==0) {
				session.setAttribute("message", "No Records!!");
			}
			session.setAttribute("result", result);
			
		} catch (NullPointerException e) {
			request.setAttribute("message", "Something went wrong!!");
		} catch (Exception e) {
			request.setAttribute("message", "Something went wrong!!");
		}
	}

}
