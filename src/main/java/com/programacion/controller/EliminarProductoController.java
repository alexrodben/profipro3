package com.programacion.controller;

import com.programacion.proyecto.Controllers;
import com.programacion.view.EliminarProductoView;
import java.awt.event.MouseEvent;

public class EliminarProductoController implements Controllers {

  private final EliminarProductoView view;
  private final int type;

  public EliminarProductoController(
    EliminarProductoView eliminarProductoView,
    int type
  ) {
    this.view = eliminarProductoView;
    this.type = type;
    System.out.println(this.type);

    addMouseListener();
  }

  @Override
  public final void addMouseListener() {
    view.jLabelAccion.addMouseListener(this);
    view.jTextFieldCodigo.addMouseListener(this);
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
