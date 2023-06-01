package com.programacion.controller;

import com.programacion.proyecto.Controllers;
import com.programacion.proyecto.Models;
import com.programacion.view.ListaProductoView;
import java.awt.event.MouseEvent;

public class ListaProductoController implements Controllers {

  private final ListaProductoView view;
  private final Models model;

  public ListaProductoController(
    ListaProductoView listaProductoView,
    Models model
  ) {
    this.view = listaProductoView;
    this.model = model;
    addMouseListener();
    showDataTable();
  }

  @Override
  public final void addMouseListener() {}

  @Override
  public void getInfo() {
    System.out.println("view: " + view.getClass().getName());
    System.out.println("Controller: " + this.getClass().getName());
  }

  @Override
  public void mouseClicked(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  private void showDataTable() {
    model.listar(view.jTableDatos);
  }
}
