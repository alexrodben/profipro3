/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.controller;

import com.programacion.proyecto.Controllers;
import com.programacion.view.CrudMainView;
import com.programacion.view.CrudView;
import java.awt.event.MouseEvent;

/**
 *
 * @author alexr
 */
public class CrudMainController implements Controllers {

  private final CrudMainView view;

  public CrudMainController(CrudMainView mainView) {
    view = mainView;
    addMouseListener();
  }

  @Override
  public final void addMouseListener() {
    view.jLabelCola.addMouseListener(this);
    view.jLabelPila.addMouseListener(this);
    view.jLabelLista.addMouseListener(this);
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
      CrudController crudController = new CrudController(
        crudView,
        CrudController.COLA
      );
      crudView.setVisible(true);
      crudController.getInfo();
    }
    if (view.jLabelPila == e.getSource()) {
      System.out.println("Pilas");
      CrudView crudView = new CrudView();
      CrudController crudController = new CrudController(
        crudView,
        CrudController.PILA
      );
      crudView.setVisible(true);
      crudController.getInfo();
    }
    if (view.jLabelLista == e.getSource()) {
      System.out.println("Listas");
      CrudView crudView = new CrudView();
      CrudController crudController = new CrudController(
        crudView,
        CrudController.LISTA
      );
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
