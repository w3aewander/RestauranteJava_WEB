/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.todo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author wanderlei
 */
@ManagedBean(name="todo")
@ViewScoped
public class TodoList implements Serializable{

    private String tarefa;
    private static List<String> tarefas = new ArrayList<>();

    public TodoList (){
        tarefa=null;
    }
    public List<String> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<String> tarefas) {
        TodoList.tarefas = tarefas;
    }
    
    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
        
    public void add(){
        tarefas.add(tarefa);
        tarefa=null;
        
    }
    
    public void remove(){
        tarefas.remove(tarefa);
        tarefa=null;
    }
    public void edit(String t){
        tarefa = tarefas.get(tarefas.indexOf(t));
    }
}
