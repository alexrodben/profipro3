package com.programacion.controller;

import com.programacion.proyecto.Controllers;
import com.programacion.view.BuscarProductoView;
import java.awt.event.MouseEvent;

public class BuscarProductoController implements Controllers {

  private final BuscarProductoView view;
  private final int type;

  public BuscarProductoController(
    BuscarProductoView buscarProductoView,
    int type
  ) {
    this.view = buscarProductoView;
    this.type = type;
    addMouseListener();
  }

  @Override
  public final void addMouseListener() {
    view.jLabelBuscar.addMouseListener(this);
    view.jTextFieldCodigo.addMouseListener(this);
    view.jTextFieldNombre.addMouseListener(this);
    view.jTextFieldExistencia.addMouseListener(this);
    view.jTextFieldTipo.addMouseListener(this);
  }

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
}
