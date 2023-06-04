/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.controller;

import com.programacion.model.ColaModel;
import com.programacion.model.ListaModel;
import com.programacion.model.PilaModel;
import com.programacion.model.HashModel;
import com.programacion.proyecto.Controllers;
import com.programacion.proyecto.Models;
import com.programacion.view.CrudMainView;
import com.programacion.view.CrudView;
import java.awt.event.MouseEvent;

/**
 *
 * @author alexr
 */
public class CrudMainController implements Controllers {

  private final CrudMainView view;
  private final Models lista;
  private final Models pila;
  private final Models cola;
  private final Models hash;

  public CrudMainController(CrudMainView mainView) {
    view = mainView;
    lista = new ListaModel();
    pila = new PilaModel();
    cola = new ColaModel();
    hash = new HashModel();
    addMouseListener();
  }

  @Override
  public final void addMouseListener() {
    view.jLabelCola.addMouseListener(this);
    view.jLabelPila.addMouseListener(this);
    view.jLabelLista.addMouseListener(this);
    view.jLabelHash.addMouseListener(this);
  }

  @Override
  public void getInfo() {
    System.out.println("view: " + view.getClass().getName());
    System.out.println("Controller: " + this.getClass().getName());
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (view.jLabelCola == e.getSource()) {
      System.out.println("Colas");
      CrudView crudView = new CrudView();
      CrudController crudController = new CrudController(crudView, cola);
      crudView.setVisible(true);
      crudController.getInfo();
    }
    if (view.jLabelPila == e.getSource()) {
      System.out.println("Pilas");
      CrudView crudView = new CrudView();
      CrudController crudController = new CrudController(crudView, pila);
      crudView.setVisible(true);
      crudController.getInfo();
    }
    if (view.jLabelLista == e.getSource()) {
      System.out.println("Listas");
      CrudView crudView = new CrudView();
      CrudController crudController = new CrudController(crudView, lista);
      crudView.setVisible(true);
      crudController.getInfo();
    }
    if (view.jLabelHash == e.getSource()) {
      System.out.println("Hash");
      CrudView crudView = new CrudView();
      CrudController crudController = new CrudController(crudView, hash);
      crudView.setVisible(true);
      crudController.getInfo();
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}
}
