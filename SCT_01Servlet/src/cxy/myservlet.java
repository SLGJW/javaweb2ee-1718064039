package cxy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myservlet
 */
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String title = "表单提交的信息";
        String cxy="学生信息录入";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
            "<html>\n" +
            "<head><title>" + cxy + "</title></head>\n" +
            "<body>\n" +
            "<h1 align=\"center\">" + title + "</h1>\n" +
            "<ul>\n" +
            "  <li><b>学号</b>:"
            +request.getParameter("name")+ "\n" +
            "  <li><b>姓名</b>:"
            + request.getParameter("url")+ "\n" +
             "<li><b>生日</b>:"
            +request.getParameter("bday")+"\n"  );
   	    String[] values = request.getParameterValues("man") ;
	    if(values!=null&&values.length>0) {
	        for(int i= 0 ;i<values.length;i++)
	        	out.println("<li><b>"+"性别 :"+values[i]+"</b>")       ;  
	   }
	    String[] values1 = request.getParameterValues("sp") ;
	    if(values1!=null&&values1.length>0) {
	    	out.println("<li><b>"+"体育爱好:"+"</b>");
	        for(int k= 0 ;k<values1.length;k++)
	            out.println("<b>"+values1[k]+"</b>");
	    }
	    out.println("</ul>");
	    out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}