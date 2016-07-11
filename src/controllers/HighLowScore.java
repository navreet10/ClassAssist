package controllers;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;

/**
 * Servlet implementation class HighLowScore
 */
@WebServlet("/HighLowScore")
public class HighLowScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HighLowScore() {
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
			System.out.println("in High low");
			HttpSession session = request.getSession();
			//String student = request.getParameter("student");
			String type = request.getParameter("type");
			BigDecimal high = null;
			BigDecimal low = null;
			session.setAttribute("average", null);
			session.setAttribute("result", null);
			session.setAttribute("high", null);
			session.setAttribute("low", null);
			session.setAttribute("message", null);
			if (type == null || type.equalsIgnoreCase("")) {
				request.setAttribute("message", "No Type defined!!");
			} else {
				high = Dao.getHigh(type);
				low = Dao.getLow(type);
			}
			if (high==null || low==null) {
				session.setAttribute("message", "No Records!!");
			}
			session.setAttribute("high", high);
			session.setAttribute("low", low);
		} catch (NullPointerException e) {
			request.setAttribute("message", "Something went wrong!!");
		} catch (Exception e) {
			request.setAttribute("message", "Something went wrong!!");
		}
	}

}
