package com.programacion.model;

import com.programacion.dto.Data;
import com.programacion.proyecto.Models;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ColaModel implements Models {

  private Queue<Data> cola;

  public ColaModel() {
    cola = new LinkedList<>();
  }

  @Override
  public void agregar(Data data) {
    cola.offer(data);
  }

  @Override
  public void eliminar(Data data) {
//    cola.remove(data);
    cola.poll();
  }

  @Override
  public void modificar(Data data) {
    if (cola.contains(data)) {
      cola.remove(data);
      cola.offer(data);
    } else {
      System.out.println("El elemento no se encuentra en la cola.");
    }
  }

  @Override
  public Data buscar(String codigo) {
    for (Data data : cola) {
      if (data.getCodigo().equals(codigo)) {
        return data;
      }
    }
    return null; // El elemento no se encuentra en la cola
  }

  @Override
  public void listar(JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de listar los elementos

    for (Data data : cola) {
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
    Data siguiente = cola.peek();
    return siguiente;
  }

  @Override
  public void limpiar() {
    cola.clear();
  }

  @Override
  public String getNombre() {
    return "Cola";
  }
}
