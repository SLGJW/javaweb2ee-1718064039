package cxy;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String account=request.getParameter("account");
			String password=request.getParameter("password");
			if(account.equals("caixingyou") && password.equals("1718064039")) {
				 Cookie ck = new Cookie("account", account);
				 Cookie ck1=new Cookie("password",password);
				 ck.setMaxAge(60*60*24);
				 ck1.setMaxAge(60*60*24);
				 response.addCookie(ck);
				 response.addCookie(ck1);
				 response.sendRedirect("Servlet2");
			}else {
				request.getRequestDispatcher("index2.html").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}