/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Wanderlei
 */
@Entity
@Table(name="comandas")
public class Comanda {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(name="produto_id")
   @OneToMany(mappedBy = "produtos",targetEntity = Produto.class)
   private Produto produto;
   
   private float qtde;
   private Date created_at;
   private Date updated_at;
   
}
