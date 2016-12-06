<%-- 
    Document   : ListarUsuario
    Created on : 22/09/2016, 02:24:08 PM
    Author     : user 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar tasks</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Task id</th>
                    <th>Peer id</th>
                    <th>Type</th>
                    <th>Status</th>
                   
                    
                    
                </tr>
            <tbody>
                <c:forEach var="task" items="${tasks}">
                    <tr>
                        <td>${task.taskId}</td>
                        <td>${task.peerId}</td>
                        <td>${task.type}</td>
                        <td>${task.status}</td>
          
                        <td><a href="TaskController?action=modificar&taskId=${task.taskId}">Modificar</a></td>
                         <td><a href="TaskController?action=eliminar&taskId=${task.taskId}">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
            
            
        </table>
        <p>
            <a href="TaskController?action=insertar">New Task</a>
        </p>
    </body>
</html>
