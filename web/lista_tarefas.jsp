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
        <jsp:useBean id="hoje" class="java.util.Date"  />
        <jsp:useBean id="todolist" class="com.wander.todo.TodoList"  />

        <style>
            html {
                font-size: 100%;
            }
            th {
                background: blue;
                color: white;
                font-size: 120%;
            }
        </style>
    </head>
    <body>

        <table colspaces ="4" cellpadding="4" rules="all" border="1" width="500">
            <caption>
                <strong>Itens na lista: <c:out value="${todolist.tarefas.size()}"/></strong>

            </caption>
            <thead>
                <tr>
                    <th>Tarefa</th>
                    <th>Ação</th>
                </tr>
            </thead>     
            <tbody>

                <c:set var="tamanhoLista" value="${todolist.tarefas.size()}" /> 

                    <c:choose>
                        <c:when test = "${tamanhoLista ==  0}">
                            <tr>
                                <td colspan="2">
                                    A Lista está vazia.
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>    
                            <c:forEach var="t" items="${todolist.tarefas}" >
                                <tr>
                                    <td>${t}</td>
                                    <td>
                                        <a href="/JavaWEB_Exercicios/todolist?tarefa=${t}&action=DELETE">Remover</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>

                </tbody>
            </table>

        </body>
    </html>