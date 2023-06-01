package com.programacion.model;

import com.programacion.dto.Data;
import com.programacion.proyecto.Models;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaModel implements Models {

  private Nodo head;
  private Nodo tail;

  public ListaModel() {
    head = null;
    tail = null;
  }

  private class Nodo {

    private Data data;
    private Nodo prev;
    private Nodo next;

    public Nodo(Data data) {
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }

  @Override
  public void limpiar() {
    head = null;
    tail = null;
  }

  @Override
  public void agregar(Data data) {
    Nodo nuevoNodo = new Nodo(data);

    if (head == null) {
      head = nuevoNodo;
      tail = nuevoNodo;
    } else {
      tail.next = nuevoNodo;
      nuevoNodo.prev = tail;
      tail = nuevoNodo;
    }
  }

  @Override
  public void eliminar(Data data) {
    Nodo actual = head;

    while (actual != null) {
      if (actual.data.equals(data)) {
        if (actual == head) {
          head = actual.next;
          if (head != null) {
            head.prev = null;
          }
        } else if (actual == tail) {
          tail = actual.prev;
          tail.next = null;
        } else {
          actual.prev.next = actual.next;
          actual.next.prev = actual.prev;
        }
        break;
      }
      actual = actual.next;
    }
  }

  @Override
  public void modificar(Data data) {
    Nodo actual = head;

    while (actual != null) {
      if (actual.data.equals(data)) {
        actual.data = data;
        break;
      }
      actual = actual.next;
    }
  }

  @Override
  public Data buscar(String codigo) {
    Nodo actual = head;

    while (actual != null) {
      if (actual.data.getCodigo().equals(codigo)) {
        return actual.data;
      }
      actual = actual.next;
    }

    return null; // El elemento no se encuentra en la lista
  }

  @Override
  public void listar(JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de listar los elementos

    Nodo actual = head;

    while (actual != null) {
      Object[] row = {
        actual.data.getCodigo(),
        actual.data.getNombre(),
        actual.data.getTipo(),
        actual.data.getExistencias(),
      };
      model.addRow(row);
      actual = actual.next;
    }
  }

  @Override
  public Data siguiente() {
    if (head != null) {
      return head.data;
    } else {
      return null;
    }
  }

  @Override
  public String getNombre() {
    return "Lista doblemente enlazada";
  }
}
