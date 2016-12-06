/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import java.util.List;
import model.Task;

/**
 *
 * @author Maria Magdalena Cabrera Coronilla magdacc05@gmail.com
 */
public interface TaskDao {
    void insertarTask(Task task);
    void eliminarTask(int taskId);
    void modificarTask(Task task);
    List<Task> desplegarTask();
    Task elegirTask(int taskId);
    
}
