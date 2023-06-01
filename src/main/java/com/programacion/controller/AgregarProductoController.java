package com.programacion.controller;

import com.programacion.dto.Data;
import com.programacion.proyecto.Controllers;
import com.programacion.proyecto.Models;
import com.programacion.view.AgregarProductoView;
import java.awt.event.MouseEvent;

public class AgregarProductoController implements Controllers {

  private final AgregarProductoView view;
  private final Models model;

  public AgregarProductoController(
    AgregarProductoView agregarProductoView,
    Models model
  ) {
    this.view = agregarProductoView;
    this.model = model;
    addMouseListener();
  }

  @Override
  public final void addMouseListener() {
    view.jLabelAccion.addMouseListener(this);
  }

  @Override
  public void getInfo() {
    System.out.println("view: " + view.getClass().getName());
    System.out.println("Controller: " + this.getClass().getName());
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getSource() == view.jLabelAccion) this.agregar();
  }

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  private void agregar() {
    System.out.println("Agregando producto");
    Data data = new Data();
    data.setTipo(view.jTextFieldTipo.getText());
    data.setCodigo(view.jTextFieldCodigo.getText());
    data.setNombre(view.jTextFieldNombre.getText());
    data.setExistencias(view.jTextFieldExistencia.getText());
    model.agregar(data);
    view.setVisible(false);
  }
}
