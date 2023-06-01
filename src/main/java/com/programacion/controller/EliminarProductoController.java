package com.programacion.controller;

import com.programacion.dto.Data;
import com.programacion.proyecto.Controllers;
import com.programacion.proyecto.Models;
import com.programacion.view.EliminarProductoView;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class EliminarProductoController implements Controllers {

  private final EliminarProductoView view;
  private final Models model;

  public EliminarProductoController(
    EliminarProductoView eliminarProductoView,
    Models model
  ) {
    this.view = eliminarProductoView;
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
    if (e.getSource() == view.jLabelAccion) this.eliminar();
  }

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  public void eliminar() {
    System.out.println("Eliminar");
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
        model.eliminar(data);
        this.view.setVisible(false);
        JOptionPane.showMessageDialog(
          null,
          "Se elimino el producto",
          "Exito",
          JOptionPane.INFORMATION_MESSAGE
        );
      }
    }
  }
}
