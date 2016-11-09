package com.wander.restaurante.entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Wanderlei
 */
public class Comanda {
 
   private Long id;
   private static List<ItemConsumo> itensConsumo;
   private String status;
   private Calendar created_at;
   private Calendar updated_at;
   
    public Comanda() {
        
        itensConsumo = new ArrayList<>();
        this.created_at = Calendar.getInstance();
        this.updated_at = Calendar.getInstance();
        this.status = "aberta";
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemConsumo> getItensConsumo() {
        return itensConsumo;
    }

    public Calendar getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Calendar created_at) {
        this.created_at = created_at;
    }

    public Calendar getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Calendar updated_at) {
        this.updated_at = updated_at;
    }

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comanda other = (Comanda) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + "," + 
                            created_at.getTime()     +  "}";
    }
   
   
}
