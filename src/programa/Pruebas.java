package programa;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import consola.Menu;
import consola.MenuCallback;
import funcion.*;
import metodos.*;
import java.io.*;

/**
 *
 * @author Gerson
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



        Menu menu = new Menu();
        menu.setTitulo("Menu demo");

        menu.agregar("Opcion1", new MenuCallback() {
            public void ejecutar() {
                System.out.println("1 test");
            }
        });
        menu.agregar("Opcion2", new MenuCallback() {
            public void ejecutar() {
                System.out.println("2 test");
            }
        });

        Menu submenu = new Menu();
        submenu.agregar("Sub1", new MenuCallback() {
            public void ejecutar() {
                System.out.println("1 subtest");
            }
        });
        submenu.agregar("Sub2", new MenuCallback() {
            public void ejecutar() {
                System.out.println("2 subtest");
            }
        });
        submenu.agregar("Sub3", new MenuCallback() {
            public void ejecutar() {
                System.out.println("3 subtest");
            }
        });

        menu.agregar("Opcion3", submenu);
        menu.agregar("Opcion4", new MenuCallback() {
            public void ejecutar() {
                System.out.println("4 test");
            }
        });
        menu.agregar("Opcion5", new MenuCallback() {
            public void ejecutar() {
                System.out.println("5 test");
            }
        });

        menu.mostrar();

/*
        BusquedaIncremental incremental = new BusquedaIncremental();

        Funcion funcion1 = new Funcion() {
            public double evaluar(double x) {
                double resultado = 0;
                resultado = Math.pow(x, 4) - (4 * Math.pow(x, 3)) + (6 * Math.pow(x, 2)) - (3 * 0.75);
                return resultado;
            }
        };

        incremental.evaluar(funcion1, 5, -0.05, 100);
        */

    }
}
