<%-- 
    Document   : pagina1
    Created on : 19/10/2016, 11:23:53
    Author     : wanderlei
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="hoje" class="java.util.Date" />
        <jsp:useBean id="todolist" class="com.wander.todo.TodoList" />
    </head>
    <body>

        <h1>TAGS JSTL</h1>
        <c:set var="titulo" value="Minha Lista de Tarefas" /><br>
        <c:set var="dataAtual" value="${hoje}" /><br>

        Data de hoje: <fmt:formatDate  value="${dataAtual}" pattern="dd/MM/yyyy" /><br>

        <h2><c:out value="${titulo}" /></h2>

        
        <form name="frmadd" action="/JavaWEB_Exercicios/todolist" method="post">
            <input type="text" name="tarefa" id="tarefa" value="${tarefa}" />
            <input type="submit" value="Add" >
        </form>

        <jsp:include  page="lista_tarefas.jsp"/>
    </body>
</html>
