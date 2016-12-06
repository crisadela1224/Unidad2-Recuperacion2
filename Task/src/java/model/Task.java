/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Task {
   private int taskId;
    private String peerId;
    private int type;
    private int status;



    public Task(int taskId, String peerId,  int type, int status) {
        this.taskId = taskId;
        this.peerId = peerId;
        this.type=type;
        this.status = status;
       
    }
    
    public Task(){
        this(0,"", 0, 0);
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" + "taskId=" + taskId + ", peerId=" + peerId + ", type=" + type + ", status=" + status + '}';
    }

}
