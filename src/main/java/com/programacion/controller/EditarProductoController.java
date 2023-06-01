package com.programacion.controller;

import com.programacion.dto.Data;
import com.programacion.proyecto.Controllers;
import com.programacion.proyecto.Models;
import com.programacion.view.EditarProductoView;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class EditarProductoController implements Controllers {

  private final EditarProductoView view;
  private final Models model;

  public EditarProductoController(
    EditarProductoView editarProductoView,
    Models model
  ) {
    this.view = editarProductoView;
    this.model = model;
    addMouseListener();
  }

  @Override
  public final void addMouseListener() {
    view.jLabelAccion.addMouseListener(this);
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
    if (e.getSource() == view.jLabelAccion) this.editar();
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

  private void editar() {
    System.out.println("Editar");
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
        data.setTipo(view.jTextFieldTipo.getText());
        data.setNombre(view.jTextFieldNombre.getText());
        data.setExistencias(view.jTextFieldExistencia.getText());
        model.modificar(data);
        JOptionPane.showMessageDialog(
          null,
          "Se edito el producto",
          "Exito",
          JOptionPane.INFORMATION_MESSAGE
        );
      }
    }
  }
}
