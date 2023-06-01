package com.programacion.controller;

import com.programacion.dto.Data;
import com.programacion.proyecto.Controllers;
import com.programacion.proyecto.Models;
import com.programacion.view.BuscarProductoView;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class BuscarProductoController implements Controllers {

  private final BuscarProductoView view;
  private final Models model;

  public BuscarProductoController(
    BuscarProductoView buscarProductoView,
    Models model
  ) {
    this.view = buscarProductoView;
    this.model = model;
    addMouseListener();
  }

  @Override
  public final void addMouseListener() {
    view.jLabelBuscar.addMouseListener(this);
  }

  @Override
  public void getInfo() {
    System.out.println("view: " + view.getClass().getName());
    System.out.println("Controller: " + this.getClass().getName());
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getSource() == view.jLabelBuscar) this.buscar();
  }

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  private void buscar() {
    System.out.println("Buscar");
    if (view.jTextFieldCodigo.getText().equals("")) {
      JOptionPane.showMessageDialog(
        null,
        "No hay un codigo para buscar",
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    } else {
      Data data = model.buscar(view.jTextFieldCodigo.getText());
      if (data == null) {
        JOptionPane.showMessageDialog(
          null,
          "No se encontro el producto",
          "Error",
          JOptionPane.ERROR_MESSAGE
        );
        return;
      } else {
        view.jTextFieldTipo.setText(data.getTipo());
        view.jTextFieldNombre.setText(data.getNombre());
        view.jTextFieldExistencia.setText(data.getExistencias());
      }
    }
  }
}
