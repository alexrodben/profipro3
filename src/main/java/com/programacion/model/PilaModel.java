package com.programacion.model;

import com.programacion.dto.Data;
import com.programacion.proyecto.Models;
import java.util.Stack;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PilaModel implements Models {

  private Stack<Data> pila;

  public PilaModel() {
    pila = new Stack<>();
  }

  @Override
  public void limpiar() {
    pila.clear();
  }

  @Override
  public void agregar(Data data) {
    pila.push(data);
  }

  @Override
  public void eliminar(Data data) {
    pila.remove(data);
  }

  @Override
  public void modificar(Data data) {
    if (pila.contains(data)) {
      pila.remove(data);
      pila.push(data);
    } else {
      System.out.println("El elemento no se encuentra en la pila.");
    }
  }

  @Override
  public Data buscar(String codigo) {
    for (Data data : pila) {
      if (data.getCodigo().equals(codigo)) {
        return data;
      }
    }
    return null; // El elemento no se encuentra en la pila
  }

  @Override
  public void listar(JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de listar los elementos

    for (Data data : pila) {
      Object[] row = {
        data.getCodigo(),
        data.getNombre(),
        data.getTipo(),
        data.getExistencias(),
      };
      model.addRow(row);
    }
  }

  @Override
  public Data siguiente() {
    if (!pila.isEmpty()) {
      return pila.peek();
    } else {
      return null;
    }
  }

  @Override
  public String getNombre() {
    return "Pila";
  }
}
