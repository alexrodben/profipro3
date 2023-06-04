package com.programacion.model;

import com.programacion.dto.Data;
import com.programacion.proyecto.Models;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;

public class HashModel implements Models {

  private Map<String, Data> hashTable;

  public HashModel() {
    hashTable = new HashMap<>();
  }

  @Override
  public void limpiar() {
    hashTable.clear();
  }

  @Override
  public void agregar(Data data) {
    hashTable.put(data.getCodigo(), data);
  }

  @Override
  public void eliminar(Data data) {
    hashTable.remove(data.getCodigo());
  }

  @Override
  public void modificar(Data data) {
    hashTable.put(data.getCodigo(), data);
  }

  @Override
  public Data buscar(String codigo) {
    return hashTable.get(codigo);
  }

  @Override
  public void listar(JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de listar los elementos

    for (Data data : hashTable.values()) {
      Object[] row = {
          data.getCodigo(),
          data.getNombre(),
          data.getTipo(),
          data.getExistencias()
      };
      model.addRow(row);
    }
  }

  @Override
  public Data siguiente() {
    if (!hashTable.isEmpty()) {
      return hashTable.values().iterator().next();
    } else {
      return null;
    }
  }

  @Override
  public String getNombre() {
    return "Tablas hash";
  }
}
