/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.controller;

import com.programacion.model.NodoHanoi;
import com.programacion.model.PilaHanoi;
import com.programacion.proyecto.Controllers;
import com.programacion.view.AgregarProductoView;
import com.programacion.view.BuscarProductoView;
import com.programacion.view.EditarProductoView;
import com.programacion.view.EliminarProductoView;
import com.programacion.view.HanoiView;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexr
 */
public class HanoiController implements Controllers {

  private final HanoiView view;
  private int contNumMovimientos = 0;
  private PilaHanoi pilaTorreA;
  private PilaHanoi pilaTorreB;
  private PilaHanoi pilaTorreC;
  private DefaultTableModel modelTableModelTorreA;
  private DefaultTableModel modelTableModelTorreB;
  private DefaultTableModel modelTableModelTorreC;
  private int objetivo = 0;
  private double numMovimientos = 0;
  private boolean isResuelto = false;

  public HanoiController(HanoiView view) {
    this.view = view;
    addMouseListener();
  }

  @Override
  public final void addMouseListener() {
    view.jButtonIniciar.addMouseListener(this);
    view.jButtonResolver.addMouseListener(this);
    view.jButtonReiniciar.addMouseListener(this);

    modelTableModelTorreA = (DefaultTableModel) view.jTableTorreA.getModel();
    modelTableModelTorreA.setRowCount(10);

    modelTableModelTorreB = (DefaultTableModel) view.jTableTorreB.getModel();
    modelTableModelTorreB.setRowCount(10);

    modelTableModelTorreC = (DefaultTableModel) view.jTableTorreC.getModel();
    modelTableModelTorreC.setRowCount(10);

    DefaultTableCellRenderer centerRendererA = new DefaultTableCellRenderer();
    centerRendererA.setHorizontalAlignment(SwingConstants.CENTER);
    view.jTableTorreA
      .getColumnModel()
      .getColumn(0)
      .setCellRenderer(centerRendererA);

    DefaultTableCellRenderer centerRendererB = new DefaultTableCellRenderer();
    centerRendererB.setHorizontalAlignment(SwingConstants.CENTER);
    view.jTableTorreB
      .getColumnModel()
      .getColumn(0)
      .setCellRenderer(centerRendererB);

    DefaultTableCellRenderer centerRendererC = new DefaultTableCellRenderer();
    centerRendererC.setHorizontalAlignment(SwingConstants.CENTER);
    view.jTableTorreC
      .getColumnModel()
      .getColumn(0)
      .setCellRenderer(centerRendererC);
  }

  @Override
  public void getInfo() {
    System.out.println("view: " + view.getClass().getName());
    System.out.println("Controller: " + this.getClass().getName());
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (view.jButtonIniciar == e.getSource()) {
      this.iniciar();
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

  private void iniciar() {
    try {
      pilaTorreA = new PilaHanoi();
      pilaTorreB = new PilaHanoi();
      pilaTorreC = new PilaHanoi();
      limpiarTablas();

      objetivo =
        Integer.parseInt(view.jComboBoxDiscos.getSelectedItem().toString());
      numMovimientos = Math.pow(2, objetivo) - 1;
      view.jLabelMovimientos.setText(String.valueOf(contNumMovimientos));
      view.jLabelMinMov.setText(
        String.valueOf(String.format("%.0f", numMovimientos))
      );

      for (int i = objetivo; i > 0; i--) {
        NodoHanoi plataform = new NodoHanoi();
        String disco = "";

        for (int j = i; j > 0; j--) {
          disco += "#";
        }
        plataform.setDato(disco);
        pilaTorreA.push(plataform);
      }

      presentarCantMovimientos();
      presentarTorres();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
        null,
        "Error al iniciar el juego: " + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  private void limpiarTablas() {
    contNumMovimientos = 0;
    numMovimientos = 0;
  }

  private void presentarCantMovimientos() {
    contNumMovimientos++;
    view.jLabelMovimientos.setText(String.valueOf(contNumMovimientos));
  }

  private void presentarTorres() {}
}
