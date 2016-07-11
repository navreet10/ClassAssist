package controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import model.Studentca;
import model.Typeassignment;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
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
			HttpSession session = request.getSession();
			System.out.println("in");
			session.setAttribute("average", null);
			session.setAttribute("result", null);
			session.setAttribute("high", null);
			session.setAttribute("low", null);
			session.setAttribute("message", null);
			String studentId = request.getParameter("studentId");
			String type = request.getParameter("typeAssgn");
			String name = request.getParameter("assgnName");
			String date = request.getParameter("date");
			String grade = request.getParameter("grade");
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			Studentca stu = new Studentca();
			Typeassignment typeAssgn = new Typeassignment();
			typeAssgn.setType(type);
			stu.setStudentId(new BigDecimal(studentId));
			stu.setTypeassignment(typeAssgn);
			stu.setGrade(new BigDecimal(grade));
			stu.setAssdate(format.parse(date));
			stu.setAssignmentName(name);
			Dao.insert(stu);
			session.setAttribute("message", "Successful Insert!!");
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		} catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("message", "Something went wrong!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Something went wrong!!");
		}
	}

}
