package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dao.StudentDao;
import entity.Student;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        String uri=request.getRequestURI();
	        String action=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
	        StudentDao dao=new StudentDao();
	        if(action.equals("list")){
	            try {

	                List<Student> emps = dao.findAll();
	                request.setAttribute("emps", emps);

	                //转发
	                request.getRequestDispatcher("listEmp1.jsp").forward(request, response);
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }else if(action.equals("add")){
	            String name=request.getParameter("name");
	            int snumber=Integer.valueOf(request.getParameter("snumber"));
	            int age=Integer.valueOf(request.getParameter("age"));
	            String ssex=request.getParameter("ssex");
	            Student emp=new Student();
	            emp.setName(name);
	            emp.setSnumber(snumber);
	            emp.setAge(age);
	            emp.setSsex(ssex);
	            try {
	                dao.save(emp);

	                //重定向
	                response.sendRedirect("list.do");
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }else if(action.equals("delete")){
	            int id = Integer.valueOf(request.getParameter("id"));
	            try {
	                dao.delete(id);
	                response.sendRedirect("list.do");
	            } catch (ClassNotFoundException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }else if(action.equals("load")){
	            int id=Integer.valueOf(request.getParameter("id"));

	            try {
	                Student emp = dao.findById(id);
	                request.setAttribute("emp", emp);
	                request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }


	        }else if(action.equals("update")){
	            int id=Integer.valueOf(request.getParameter("id"));
	            String name=request.getParameter("name");
	            int snumber=Integer.valueOf(request.getParameter("snumber"));
	            int age=Integer.valueOf(request.getParameter("age"));
	            String ssex=request.getParameter("ssex");
	            Student emp=new Student(id,name,snumber,age,ssex);
	            try {
	                dao.modify(emp);
	                response.sendRedirect("list.do");
	            } catch (ClassNotFoundException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }else if(action.equals("find")){
	        	response.setContentType("text/html;charset=utf-8");
	    		String name=request.getParameter("name");
	    		try {
	    		    //装载驱动
	    			Class.forName("com.mysql.cj.jdbc.Driver");
	    			//建立连接
	    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","cxy123456");
	    			PreparedStatement pst=con.prepareStatement("select * from t_emp where name=?");
	    			pst.setString(1, name);
	    			
	    			ResultSet rs=pst.executeQuery();
	    			
	    			PrintWriter pw=response.getWriter();
	    			pw.write("<h1 align=\"center\">学生信息</h1>");
	    			pw.write("<table align=\"center\" border=\"1\" cellpadding=\"0\">");
	    			pw.write("<tr>");
	    			pw.write("<th>编号</th>");
	    			pw.write("<th>姓名</th>");
	    			pw.write("<th>学号</th>");
	    			pw.write("<th>年龄</th>");
	    			pw.write("<th>性别</th>");
	    			pw.write("</tr>");
	    			while(rs.next()) {
	    				pw.write("<tr>");
	    				pw.write("<td>"+rs.getString("id")+"</td>");
	    				pw.write("<td>"+rs.getString("name")+"</td>");
	    				pw.write("<td>"+rs.getString("snumber")+"</td>");
	    				pw.write("<td>"+rs.getString("age")+"</td>");
	    				pw.write("<td>"+rs.getString("ssex")+"</td>");
	    				pw.write("</tr>");
	    			}
	    			pw.write("</table>");
	    			pw.write("<p align=\"center\"><a href=\"listEmp1.jsp\">返回首页</a></p>");
	    			//关闭连接
	    			con.close();
	    	}catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
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