/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.programacion.proyecto;

import com.programacion.controller.MainController;
import com.programacion.view.MainView;

/**
 *
 * @author alexr
 */
public class Proyecto {

    public static void main(String[] args) {
        System.out.println("Iniciando");
        MainView view = new MainView();
        MainController controller = new MainController(view);
        view.setVisible(true);
        controller.getInfo();
    }
}
