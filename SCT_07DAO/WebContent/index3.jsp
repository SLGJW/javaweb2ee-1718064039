<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,entity.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息页面</title>
</head>
<body>
    <table align="center" border="1" cellpadding="0">
        <h1 align="center">学生信息</h1>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>学号</td>
            <td>年龄</td>
            <td>性别</td>
            <td>操作</td>
        </tr>
        <%
        	StudentDao dao=new StudentDao();
        List<Student> emps=dao.findAll();
        for(int i=0;i<emps.size();i++){
          	Student emp=emps.get(i);
         %>
        <tr>
            <td><%=emp.getId() %></td>
            <td><%=emp.getName() %></td>
            <td><%=emp.getSnumber() %></td>
            <td><%=emp.getAge() %></td>
            <td><%=emp.getSsex() %></td>
            <td>
               <a href="delete.do?id=<%=emp.getId() %>" onclick="return confirm('是否确认删除<%=emp.getName() %>信息')">删除</a>
                &nbsp;<a href="load.do?id=<%=emp.getId()%>">修改</a>
            </td>
        </tr>
        <%} %>
    </table>
    <p align="center">
        <input type="button" value="录入学生" onclick="location='addEmp.jsp'"/>
        <input type="button" value="查找" onclick="location='find.jsp'"/>
    </p>
</body>
</html>