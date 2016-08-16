package com.test.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class SessionDemo1
 */
public class SessionDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo2() {
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
//		System.out.println("username: " + request.getSession().getAttribute("username"));
		
		String parameter = request.getParameter("change");
		if (StringUtils.isNotBlank(parameter)) {
			request.getSession().setAttribute("username", parameter);
//			System.out.println("change username: " + parameter);
		}
		
		String clear = request.getParameter("clear");
		if (StringUtils.isNotBlank(clear)) {
			request.getSession().invalidate();
//			System.out.println("change username clear ");
		}
		
		response.getWriter().append("demo2 current session:" + parameter);
	}

}
