<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaBean信息封装</title>
</head>
<body align="center" bgcolor="#EBEBEB">
<h1>学生信息封装</h1>
<jsp:useBean id="loginBean" class="cxy5.loginBean"/>
<jsp:setProperty property="number" name="loginBean" param="user_number"/>
<jsp:setProperty property="name" name="loginBean" param="user_name"/>
<jsp:setProperty property="ssex" name="loginBean" param="user_ssex"/>
<jsp:setProperty property="age" name="loginBean" param="user_age"/>
<jsp:setProperty property="bday" name="loginBean" param="user_bday"/> 
<jsp:setProperty property="address" name="loginBean" param="user_address"/> 
        
学号： <jsp:getProperty property="number" name="loginBean"/><br />
姓名：<jsp:getProperty property="name" name="loginBean"/><br />
年龄： <jsp:getProperty property="age" name="loginBean"/><br />
出生年月： <jsp:getProperty property="bday" name="loginBean"/><br />
家庭住址： <jsp:getProperty property="address" name="loginBean"/><br />   
性别：<jsp:getProperty property="ssex" name="loginBean"/><br />     
    </body>
</html>