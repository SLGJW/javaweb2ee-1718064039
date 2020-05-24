<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
</head>
<body align="center">
<h1 align="center">录入学生</h1>
    <form action="add.do">
        姓名:<input type="text" name="name"/><br/>
        学号:<input type="text" name="snumber"/><br/>
        年龄:<input type="text" name="age"/><br/>
        性别:<input type="text" name="ssex"/><br/>
        <input type="submit" value="增加"/>
    </form>
</body>
</html>