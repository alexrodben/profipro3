/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.controller;

import com.programacion.proyecto.Controllers;
import com.programacion.view.AgregarProductoView;
import com.programacion.view.BuscarProductoView;
import com.programacion.view.CrudView;
import com.programacion.view.EditarProductoView;
import com.programacion.view.EliminarProductoView;
import java.awt.event.MouseEvent;

/**
 *
 * @author alexr
 */
public class CrudController implements Controllers {

  private final CrudView view;
  private final int type;

  public static int COLA = 1;
  public static int PILA = 2;
  public static int LISTA = 3;

  public CrudController(CrudView view, int type) {
    this.view = view;
    this.type = type;
    addMouseListener();
  }

  @Override
  public final void addMouseListener() {
    view.jLabelAgregar.addMouseListener(this);
    view.jLabelEliminar.addMouseListener(this);
    view.jLabelBuscar.addMouseListener(this);
    view.jLabelEditar.addMouseListener(this);
    view.jLabelListar.addMouseListener(this);
  }

  @Override
  public void getInfo() {
    System.out.println("view: " + view.getClass().getName());
    System.out.println("Controller: " + this.getClass().getName());
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (view.jLabelAgregar == e.getSource()) {
      System.out.println("Agregar");
      AgregarProductoView agregarProductoView = new AgregarProductoView();
      AgregarProductoController agregarProductoController = new AgregarProductoController(
        agregarProductoView,
        type
      );
      agregarProductoView.setVisible(true);
      agregarProductoController.getInfo();
    }
    if (view.jLabelEliminar == e.getSource()) {
      System.out.println("Eliminar");
      EliminarProductoView eliminarProductoView = new EliminarProductoView();
      EliminarProductoController eliminarProductoController = new EliminarProductoController(
        eliminarProductoView,
        type
      );
      eliminarProductoView.setVisible(true);
      eliminarProductoController.getInfo();
    }
    if (view.jLabelBuscar == e.getSource()) {
      System.out.println("Buscar");
      BuscarProductoView buscarProductoView = new BuscarProductoView();
      BuscarProductoController buscarProductoController = new BuscarProductoController(
        buscarProductoView,
        type
      );
      buscarProductoView.setVisible(true);
      buscarProductoController.getInfo();
    }
    if (view.jLabelEditar == e.getSource()) {
      System.out.println("Editar");
      EditarProductoView editarProductoView = new EditarProductoView();
      EditarProductoController editarProductoController = new EditarProductoController(
        editarProductoView,
        type
      );
      editarProductoView.setVisible(true);
      editarProductoController.getInfo();
    }
    if (view.jLabelListar == e.getSource()) {
      System.out.println("Listar");
      /*
      ListarProductoView listarProductoView = new ListarProductoView();
      ListarProductoController listarProductoController = new ListarProductoController(
        listarProductoView,
        type
      );
      listarProductoView.setVisible(true);
      listarProductoController.getInfo();
*/
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}
}
