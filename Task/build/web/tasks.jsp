<%-- 
    Document   : Usuario
    Created on : 22/09/2016, 02:24:34 PM
    Author     : user 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task</title>
    </head> 
    <body>
        <form action="TaskController" method="post">
            <fieldset>
                <legend>Formulario de Task</legend>
                <div>
                 <label>Id de task:</label>
                <input type="text" name="taskId"
                       value="${task.taskId}"
                       readonly="readonly"
                       placeholder="Task Id"
                       />
                </div>
                       
                       <div>
                <label>Peer id:</label>
                <input type="text" name="peerId"
                                value="${task.peerId}"
                       placeholder="Peer Id"
                       />
                
                       </div>
                       
                       <div>
                 <label>Type:</label>
                <input type="text" name="type"
                       value="${task.type}"
                       placeholder="Type"
                       />
                
                       </div>
                       <div>
                 <label>Status:</label>
                <input type="text" name="status"
                       value="${task.status}"
                       placeholder="Status"
                       />
                
                       </div>
                       
                
                       
                  
                           <input type="submit" value="Guardar" />
                           
                       
            </fieldset>
            
        </form>
    </body>
</html>
