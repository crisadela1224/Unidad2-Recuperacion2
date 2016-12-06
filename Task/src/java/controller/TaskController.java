/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.TaskDao;
import Dao.TaskDaoImp;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Task;

/**
 *
 * @author user
 */
@WebServlet(name = "TaskController", urlPatterns = {"/TaskController"})
public class TaskController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String LISTAR_TASKS= 
            "/listarTasks.jsp";
    private static final String AGREGAR_O_CAMBIAR = 
            "/tasks.jsp";
    private TaskDao dao;
    
    public TaskController(){
        dao = new TaskDaoImp();
    }
    


    
    
   
    
    
    
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("eliminar")){
            forward = LISTAR_TASKS;
            int taskId = Integer.parseInt(
                    request.getParameter("taskId"));
            dao.eliminarTask(taskId);
            request.setAttribute("tasks", dao.desplegarTask());
        }else if(action.equalsIgnoreCase("modificar")){
            forward= AGREGAR_O_CAMBIAR;
            int taskId = Integer.parseInt(
                    request.getParameter("taskId"));
            Task task=  dao.elegirTask(taskId);
            request.setAttribute("task", task);
            
            
            
        }else if(action.equalsIgnoreCase("insertar")){
            forward= AGREGAR_O_CAMBIAR;
        }else{
            forward=LISTAR_TASKS;
            request.setAttribute("tasks", dao.desplegarTask());
        }
        RequestDispatcher view =
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      Task task = new Task();
      String taskId = (request.getParameter("taskId").trim());
      task.setPeerId(request.getParameter("peerId").trim());
      String type = (request.getParameter("type").trim());
       task.setType(Integer.parseInt(type));
      String status = (request.getParameter("status").trim());
      task.setStatus(Integer.parseInt(status));
      
      
      if(taskId==null || taskId.isEmpty()){
          dao.insertarTask(task);
         
          
      }else{
         task.setTaskId(Integer.parseInt(taskId));
          dao.modificarTask(task);
           
      }
       
      RequestDispatcher view = request.getRequestDispatcher(LISTAR_TASKS);
      request.setAttribute("tasks", dao.desplegarTask());
      view.forward(request, response);
    }


   
    }

