package com.programacion.proyecto;

import com.programacion.dto.Data;
import javax.swing.JTable;

public interface Models {
  void limpiar();
  void agregar(Data data);
  void eliminar(Data data);
  void modificar(Data data);
  void listar(JTable table);
  String getNombre();
  Data buscar(String codigo);
  Data siguiente();
}
