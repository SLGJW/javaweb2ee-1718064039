<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,entity.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息</title>
</head>
<body>
<h1 align="center">修改学生信息</h1>
    <%
    	Student emp=(Student)request.getAttribute("emp");
    %>
    <form action="update.do?id=<%=emp.getId()%>" method="post">
        <table  align="center" border="1px">
            <tr>
                <td>编号</td>
                <td>
                    <input type="text" name="id" value="<%=emp.getId()%>"/>
                </td>

            </tr>
            <tr>
                <td>姓名</td>
                <td>
                    <input type="text" name="name" value="<%=emp.getName()%>"/>
                </td>

            </tr>
            <tr>
                <td>学号</td>
                <td>
                    <input type="text" name="snumber" value="<%=emp.getSnumber()%>"/>
                </td>

            </tr>
            <tr>
                <td>年龄</td>
                <td>
                    <input type="text" name="age" value="<%=emp.getAge()%>"/>
                </td>

            </tr>
               <tr>
                <td>性别</td>
                <td>
                    <input type="text" name="ssex" value="<%=emp.getSsex()%>"/>
                </td>

            </tr>
        </table>
        <p align="center">
            <input type="submit" value="修改"/>
        </p>

    </form>
</body>
</html>