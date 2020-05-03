<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>表单信息</title>
</head>
<body align="center" bgcolor="#EBEBEB">
<h1>学生信息录入</h1>
<br />
<br />
<br />
<%
// 解决中文乱码的问题
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
%>
<h3>学号：<%=request.getParameter("name")%></h3>
<h3>姓名：<%=request.getParameter("url")%></h3>
<h3>生日：<%=request.getParameter("bday")%></h3>
<h3>性别：<%=request.getParameter("man")%></h3>
<%
String[] values1 = request.getParameterValues("sp") ;
if(values1!=null&&values1.length>0) {
	out.println("<h3>"+"体育爱好："+"</h3>");
    for(int k= 0 ;k<values1.length;k++)
        out.println("<b>"+values1[k]+"</b>");
}
%>

</body>
</html>