package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;

/**
 * Servlet implementation class Average
 */
@WebServlet("/Average")
public class Average extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Average() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("in average");
			HttpSession session = request.getSession();
			String student = request.getParameter("student");
			String type = request.getParameter("type");
			Double result = null;
			session.setAttribute("average", result);
			session.setAttribute("result", result);
			session.setAttribute("high", result);
			session.setAttribute("low", result);
			session.setAttribute("message", null);
			if ((student == null || student.equalsIgnoreCase("")) && (type == null || type.equalsIgnoreCase(""))) {
				request.setAttribute("message", "Insufficient Input!!");
			} else if (student == null || student.equalsIgnoreCase("")) {
				result = Dao.getAverageType(type);
			} else if (type == null || type.equalsIgnoreCase("")) {
				result = Dao.getAverageStudent(student);
			} else {
				result = Dao.getAverageStuType(student,type);
			}
			if (result==null) {
				session.setAttribute("message", "No Records!!");
			}
			session.setAttribute("average", result);
			
		} catch (NullPointerException e) {
			request.setAttribute("message", "Something went wrong!!");
		} catch (Exception e) {
			request.setAttribute("message", "Something went wrong!!");
		}
	}

}
