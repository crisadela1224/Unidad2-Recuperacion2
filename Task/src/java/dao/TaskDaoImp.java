/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;




import model.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Util;

/**
 *
 * @author user
 */
public class TaskDaoImp implements TaskDao {
    private Connection connection;
    
    public TaskDaoImp(){
        connection = Util.getConnection();
    
}

    @Override
    public void insertarTask(Task task) {
try{
            String query = "INSERT INTO tasks(peer_id,type,status)"
                    +" VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,task.getPeerId());
            ps.setInt(2,task.getType());
            ps.setInt(3,task.getStatus());

            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        } 
    }

    @Override
    public void eliminarTask(int taskId) {
try{
            String query = "DELETE FROM tasks WHERE task_id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, taskId);
            ps.executeUpdate();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificarTask(Task task) {
try{
            String query = "UPDATE tasks SET peer_id =? "
                    + ",type =?"
                    + ",status =?"                   
                    +" WHERE   task_id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,task.getPeerId());
            ps.setInt(2,task.getType());
            ps.setInt(3,task.getStatus());
 
            ps.setInt(4, task.getTaskId());
            
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Task>desplegarTask() {
     List<Task> tasks = new ArrayList<Task>();
        try{
        Statement statement = connection.createStatement();
         ResultSet rs= statement.executeQuery("SELECT * FROM tasks");
         while(rs.next()){
             Task task = new Task(
                     rs.getInt("task_id"),
                     rs.getString("peer_id"),
                     rs.getInt("type"),
                     rs.getInt("status"));
                    
             
             tasks.add(task);
             
         
         }
         rs.close();
         statement.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return tasks;
    }
    

    @Override
    public Task elegirTask(int taskId) {
   Task task = null;
        
        try{
            String query = "SELECT * FROM tasks WHERE task_id= ?";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            statement.setInt(1, taskId);
             ResultSet rs= statement.executeQuery();
         if(rs.next()){
             
               task = new Task(
                rs.getInt("task_id"),
                        rs.getString("peer_id"),
                        rs.getInt("type"),
                        rs.getInt("status"));
         }
         rs.close();
         statement.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return task;
    }
    
    }
    
   
