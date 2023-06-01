/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.controller;

import com.programacion.model.NodoHanoi;
import com.programacion.model.PilaHanoi;
import com.programacion.proyecto.Controllers;
import com.programacion.view.HanoiView;
import java.awt.Color;
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

  private int contadorNumeroMovimientos = 0;
  private double numeroMinimoMovimientos = 0;
  private int objetivo = 0;

  private PilaHanoi pilaTorreA;
  private PilaHanoi pilaTorreB;
  private PilaHanoi pilaTorreC;

  private DefaultTableModel modelTableModelTorreA;
  private DefaultTableModel modelTableModelTorreB;
  private DefaultTableModel modelTableModelTorreC;

  private boolean stop = false;

  public HanoiController(HanoiView view) {
    this.view = view;
    addMouseListener();
    dataTables();
  }

  @Override
  public final void addMouseListener() {
    view.jLabelIniciar.addMouseListener(this);
    view.jLabelResolver.addMouseListener(this);
    view.jLabelReiniciar.addMouseListener(this);

    view.jLabelAB.addMouseListener(this);
    view.jLabelAC.addMouseListener(this);

    view.jLabelBA.addMouseListener(this);
    view.jLabelBC.addMouseListener(this);

    view.jLabelCA.addMouseListener(this);
    view.jLabelCB.addMouseListener(this);
  }

  @Override
  public void getInfo() {
    System.out.println("view: " + view.getClass().getName());
    System.out.println("Controller: " + this.getClass().getName());
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (view.jLabelIniciar == e.getSource()) this.iniciar();
    if (view.jLabelReiniciar == e.getSource()) this.reiniciar();
    if (view.jLabelResolver == e.getSource()) this.resolver();
    if (view.jLabelAB == e.getSource()) this.moverDeAB();
    if (view.jLabelAC == e.getSource()) this.moverDeAC();
    if (view.jLabelBA == e.getSource()) this.moverDeBA();
    if (view.jLabelBC == e.getSource()) this.moverDeBC();
    if (view.jLabelCA == e.getSource()) this.moverDeCA();
    if (view.jLabelCB == e.getSource()) this.moverDeCB();
  }

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

  private void dataTables() {
    modelTableModelTorreA = (DefaultTableModel) view.jTableTorreA.getModel();
    modelTableModelTorreA.setRowCount(10);

    modelTableModelTorreB = (DefaultTableModel) view.jTableTorreB.getModel();
    modelTableModelTorreB.setRowCount(10);

    modelTableModelTorreC = (DefaultTableModel) view.jTableTorreC.getModel();
    modelTableModelTorreC.setRowCount(10);

    DefaultTableCellRenderer centerRendererA = new DefaultTableCellRenderer();
    centerRendererA.setHorizontalAlignment(SwingConstants.CENTER);
    view.jTableTorreA.setShowHorizontalLines(false);
    view.jTableTorreA.setRowHeight(19);
    view.jTableTorreA
      .getColumnModel()
      .getColumn(0)
      .setCellRenderer(centerRendererA);

    DefaultTableCellRenderer centerRendererB = new DefaultTableCellRenderer();
    centerRendererB.setHorizontalAlignment(SwingConstants.CENTER);
    view.jTableTorreB.setShowHorizontalLines(false);
    view.jTableTorreB.setRowHeight(19);
    view.jTableTorreB
      .getColumnModel()
      .getColumn(0)
      .setCellRenderer(centerRendererB);

    DefaultTableCellRenderer centerRendererC = new DefaultTableCellRenderer();
    centerRendererC.setHorizontalAlignment(SwingConstants.CENTER);
    view.jTableTorreC.setShowHorizontalLines(false);
    view.jTableTorreC.setRowHeight(19);
    view.jTableTorreC
      .getColumnModel()
      .getColumn(0)
      .setCellRenderer(centerRendererC);
  }

  private void limpiar() {
    numeroMinimoMovimientos = 0;
    contadorNumeroMovimientos = 0;
    view.jLabelNumeroMovimientos.setText("0");
    view.jLabelMinimoMovimientos.setText("0");
    view.jComboBoxDiscos.setSelectedItem(String.valueOf(objetivo));
    dataTables();
  }

  private void presentarCantidadMovimientos() {
    contadorNumeroMovimientos++;
    view.jLabelNumeroMovimientos.setText(
      String.valueOf(contadorNumeroMovimientos)
    );
    if (contadorNumeroMovimientos > numeroMinimoMovimientos) {
      view.jLabelNumeroMovimientos.setForeground(Color.RED);
    } else {
      view.jLabelNumeroMovimientos.setForeground(Color.BLACK);
    }
  }

  private void reiniciar() {
    try {
      if (!view.jLabelMinimoMovimientos.getText().equals("")) {
        limpiar();
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Error al reiniciar el juego: " + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  private void iniciar() {
    try {
      contadorNumeroMovimientos = 0;

      pilaTorreA = new PilaHanoi();
      pilaTorreB = new PilaHanoi();
      pilaTorreC = new PilaHanoi();

      objetivo =
        Integer.parseInt(view.jComboBoxDiscos.getSelectedItem().toString());
      numeroMinimoMovimientos = Math.pow(2, objetivo) - 1;
      view.jLabelNumeroMovimientos.setText(
        String.valueOf(contadorNumeroMovimientos)
      );
      view.jLabelMinimoMovimientos.setText(
        String.valueOf(String.format("%.0f", numeroMinimoMovimientos))
      );

      for (int x = objetivo; x >= 1; x--) {
        NodoHanoi plataforma = new NodoHanoi();
        String disco = "";
        for (int y = x; y > 0; y--) {
          disco += "#";
        }
        plataforma.setDato(disco);
        pilaTorreA.push(plataforma);
      }

      presentarTorreA();
      presentarTorreB();
      presentarTorreC();
    } catch (NumberFormatException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Error al iniciar el juego: " + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  private void presentarTorreA() {
    ((DefaultTableModel) view.jTableTorreA.getModel()).setRowCount(0);
    modelTableModelTorreA.setRowCount(10);
    NodoHanoi k;
    int rowDisco = (10 - pilaTorreA.getContNodo());
    if (pilaTorreA.getContNodo() > 0) {
      for (k = pilaTorreA.getCabeza(); k.getAbajo() != null; k = k.getAbajo()) {
        String[] vectorNomral = { k.getDato() };
        modelTableModelTorreA.insertRow(rowDisco, vectorNomral);
        rowDisco++;
      }

      if (k.getAbajo() == null) {
        String[] vectorNomral = { k.getDato() };
        modelTableModelTorreA.insertRow(rowDisco, vectorNomral);
      }
    }

    view.jTableTorreA.setModel(modelTableModelTorreA);
    modelTableModelTorreA.setRowCount(10);
  }

  private void presentarTorreB() {
    ((DefaultTableModel) view.jTableTorreB.getModel()).setRowCount(0);
    modelTableModelTorreB.setRowCount(10);
    NodoHanoi k;
    int rowDisco = (10 - pilaTorreB.getContNodo());
    if (pilaTorreB.getContNodo() > 0) {
      for (k = pilaTorreB.getCabeza(); k.getAbajo() != null; k = k.getAbajo()) {
        String[] vectorNomral = { k.getDato() };
        modelTableModelTorreB.insertRow(rowDisco, vectorNomral);
        rowDisco++;
      }

      if (k.getAbajo() == null) {
        String[] vectorNomral = { k.getDato() };
        modelTableModelTorreB.insertRow(rowDisco, vectorNomral);
      }
    }
    view.jTableTorreB.setModel(modelTableModelTorreB);
    modelTableModelTorreB.setRowCount(10);
  }

  private void presentarTorreC() {
    ((DefaultTableModel) view.jTableTorreC.getModel()).setRowCount(0);
    modelTableModelTorreC.setRowCount(10);
    NodoHanoi k;
    int rowDisco = (10 - pilaTorreC.getContNodo());
    if (pilaTorreC.getContNodo() > 0) {
      for (k = pilaTorreC.getCabeza(); k.getAbajo() != null; k = k.getAbajo()) {
        String[] vectorNomral = { k.getDato() };
        modelTableModelTorreC.insertRow(rowDisco, vectorNomral);
        rowDisco++;
      }

      if (k.getAbajo() == null) {
        String[] vectorNomral = { k.getDato() };
        modelTableModelTorreC.insertRow(rowDisco, vectorNomral);
      }
    }
    modelTableModelTorreC.setRowCount(10);
    view.jTableTorreC.setModel(modelTableModelTorreC);
  }

  //Moviemientos de A
  private void moverDeAB() {
    System.out.println("Mover de A a B");
    try {
      if (pilaTorreA.getContNodo() > 0) {
        NodoHanoi plataforma = new NodoHanoi();
        plataforma.setDato(pilaTorreA.peek());
        if (pilaTorreB.getContNodo() > 0) {
          if (plataforma.getDato().compareTo(pilaTorreB.peek()) > 0) {
            return;
          }
        }
        pilaTorreA.pop();
        pilaTorreB.push(plataforma);
        presentarTorreA();
        presentarTorreB();
        presentarCantidadMovimientos();
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Error al reiniciar el juego: " + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  private void moverDeAC() {
    System.out.println("Mover de A a C");
    try {
      if (pilaTorreA.getContNodo() > 0) {
        NodoHanoi plataforma = new NodoHanoi();
        plataforma.setDato(pilaTorreA.peek());
        if (pilaTorreC.getContNodo() > 0) {
          if (plataforma.getDato().compareTo(pilaTorreC.peek()) > 0) {
            return;
          }
        }
        pilaTorreA.pop();
        pilaTorreC.push(plataforma);
        presentarTorreA();
        presentarTorreC();
        presentarCantidadMovimientos();
        if (
          pilaTorreC.getContNodo() == objetivo &&
          contadorNumeroMovimientos == numeroMinimoMovimientos
        ) {
          JOptionPane.showMessageDialog(
            null,
            "Felicidades, has ganado el juego \n" +
            "con el minimo de movimientos posibles\n" +
            "intenta con otro nivel de dificultad",
            "Felicitaciones ganaste",
            JOptionPane.INFORMATION_MESSAGE
          );
        } else if (
          pilaTorreC.getContNodo() == objetivo &&
          contadorNumeroMovimientos != numeroMinimoMovimientos
        ) {
          JOptionPane.showMessageDialog(
            null,
            "Felicidades, has ganado el juego \n" +
            "intenta superar el minimo de movimientos posibles",
            "Felicitaciones ganaste",
            JOptionPane.INFORMATION_MESSAGE
          );
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Error al reiniciar el juego: " + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  //Moviemientos de B
  private void moverDeBA() {
    System.out.println("Mover de B a A");
    try {
      if (pilaTorreB.getContNodo() > 0) {
        NodoHanoi plataforma = new NodoHanoi();
        plataforma.setDato(pilaTorreB.peek());
        if (pilaTorreA.getContNodo() > 0) {
          if (plataforma.getDato().compareTo(pilaTorreA.peek()) > 0) {
            return;
          }
        }
        pilaTorreB.pop();
        pilaTorreA.push(plataforma);
        presentarTorreB();
        presentarTorreA();
        presentarCantidadMovimientos();
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Error al reiniciar el juego: " + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  private void moverDeBC() {
    System.out.println("Mover de B a C");
    try {
      if (pilaTorreB.getContNodo() > 0) {
        NodoHanoi plataforma = new NodoHanoi();
        plataforma.setDato(pilaTorreB.peek());
        if (pilaTorreC.getContNodo() > 0) {
          if (plataforma.getDato().compareTo(pilaTorreC.peek()) > 0) {
            return;
          }
        }
        pilaTorreB.pop();
        pilaTorreC.push(plataforma);
        presentarTorreB();
        presentarTorreC();
        presentarCantidadMovimientos();
        if (
          pilaTorreC.getContNodo() == objetivo &&
          contadorNumeroMovimientos == numeroMinimoMovimientos
        ) {
          JOptionPane.showMessageDialog(
            null,
            "Felicidades, has ganado el juego \n" +
            "con el minimo de movimientos posibles\n" +
            "intenta con otro nivel de dificultad",
            "Felicitaciones ganaste",
            JOptionPane.INFORMATION_MESSAGE
          );
        } else if (
          pilaTorreC.getContNodo() == objetivo &&
          contadorNumeroMovimientos != numeroMinimoMovimientos
        ) {
          JOptionPane.showMessageDialog(
            null,
            "Felicidades, has ganado el juego \n" +
            "intenta superar el minimo de movimientos posibles",
            "Felicitaciones ganaste",
            JOptionPane.INFORMATION_MESSAGE
          );
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Error al reiniciar el juego: " + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  //Moviemientos de A
  private void moverDeCA() {
    System.out.println("Mover de C a A");
    try {
      if (pilaTorreC.getContNodo() > 0) {
        NodoHanoi plataforma = new NodoHanoi();
        plataforma.setDato(pilaTorreC.peek());
        if (pilaTorreA.getContNodo() > 0) {
          if (plataforma.getDato().compareTo(pilaTorreA.peek()) > 0) {
            return;
          }
        }
        pilaTorreC.pop();
        pilaTorreA.push(plataforma);
        presentarTorreC();
        presentarTorreA();
        presentarCantidadMovimientos();
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Error al reiniciar el juego: " + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  private void moverDeCB() {
    System.out.println("Mover de A a C");
    try {
      if (pilaTorreC.getContNodo() > 0) {
        NodoHanoi plataforma = new NodoHanoi();
        plataforma.setDato(pilaTorreC.peek());
        if (pilaTorreB.getContNodo() > 0) {
          if (plataforma.getDato().compareTo(pilaTorreB.peek()) > 0) {
            return;
          }
        }
        pilaTorreC.pop();
        pilaTorreB.push(plataforma);
        presentarTorreC();
        presentarTorreB();
        presentarCantidadMovimientos();
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Error al reiniciar el juego: " + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  private void moverPlataforma(PilaHanoi origen, PilaHanoi destino) {
    if (stop == false) {
      NodoHanoi plataforma = new NodoHanoi();
      plataforma.setDato(origen.peek());
      origen.pop();
      destino.push(plataforma);

      presentarTorreA();
      presentarTorreB();
      presentarTorreC();
      presentarCantidadMovimientos();

      JOptionPane pane = new JOptionPane(
        "Paso #" +
        view.jLabelNumeroMovimientos.getText() +
        "\n\n ¿desea continuar?",
        JOptionPane.QUESTION_MESSAGE,
        JOptionPane.YES_NO_OPTION
      );
      JDialog dialog = pane.createDialog("Numero de pasos");
      dialog.setLocation(600, 400);
      dialog.setVisible(true);

      int selectedOption = ((Integer) pane.getValue()).intValue();
      if (selectedOption == JOptionPane.NO_OPTION) {
        stop = true;
      }
    }
  }

  //

  private void resolverHanoiRecursivo(
    int n,
    PilaHanoi origen,
    PilaHanoi auxiliar,
    PilaHanoi destino
  ) {
    if (n == 1) {
      moverPlataforma(origen, destino);
    } else {
      resolverHanoiRecursivo(n - 1, origen, destino, auxiliar);
      moverPlataforma(origen, destino);
      resolverHanoiRecursivo(n - 1, auxiliar, origen, destino);
    }
  }

  private void resolver() {
    if (
      !view.jLabelMinimoMovimientos.getText().equals("") &&
      pilaTorreC.getContNodo() != objetivo
    ) {
      reiniciar();
      stop = false;
      resolverHanoiRecursivo(objetivo, pilaTorreA, pilaTorreB, pilaTorreC);
    }
  }
}
