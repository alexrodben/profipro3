/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.controller;

import com.programacion.arboles.ArbolBinarioGrafico;
import com.programacion.proyecto.Controllers;
import com.programacion.view.CrudMainView;
import com.programacion.view.HanoiView;
import com.programacion.view.MainView;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/**
 *
 * @author alexr
 */
public class MainController implements Controllers {

  private final MainView view;

  public MainController(MainView mainView) {
    view = mainView;
    addMouseListener();
  }

  @Override
  public void getInfo() {
    System.out.println("view: " + view.getClass().getName());
    System.out.println("Controller: " + this.getClass().getName());
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (view.jLabelCrud == e.getSource()) {
      System.out.println("Crud");
      CrudMainView crudMainView = new CrudMainView();
      CrudMainController crudMainController = new CrudMainController(
          crudMainView);
      crudMainView.setVisible(true);
      crudMainController.getInfo();
    }
    if (view.jLabelTorresHanoi == e.getSource()) {
      System.out.println("Torres de Hanoi");
      HanoiView hanoiMainView = new HanoiView();
      HanoiController hanoiMainController = new HanoiController(hanoiMainView);
      hanoiMainView.setVisible(true);
      hanoiMainController.getInfo();
    }
    if (view.jLabelArbolBinario == e.getSource()) {
      System.out.println("Arbol Binario");
      JFrame frame = new ArbolBinarioGrafico();
      frame.setSize(400, 400);
      frame.setVisible(true);
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public final void addMouseListener() {
    view.jLabelCrud.addMouseListener(this);
    view.jLabelTorresHanoi.addMouseListener(this);
    view.jLabelArbolBinario.addMouseListener(this);
  }
}
