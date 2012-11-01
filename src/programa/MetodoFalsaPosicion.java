package programa;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import consola.Consola;
import consola.Menu;
import consola.MenuCallback;
import funcion.*;
import metodos.*;
import java.io.*;

/**
 *
 * @author Gerson
 */
public class MetodoFalsaPosicion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



        final FalsaPosicion metodo = new FalsaPosicion();



        Menu menu = new Menu();
        menu.setTitulo("Falsa Posicion");

        Menu submenu = new Menu();


        submenu.agregar("Aproximar la primera raiz positiva para: x^2-5*x+6", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("x^2-5*x+6");
                metodo.evaluar(funcion, 1, 2.5, 0.01, 6);

            }
        });
        submenu.agregar("Aproximar la raiz negativa para: x^2+x-2", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("x^2+x-2");
                metodo.evaluar(funcion, -1.5, -2.5, 0.01, 50);

            }
        });
        submenu.agregar("Aproximar la primera raiz positiva para: x^2-6", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("x^2-6");
                metodo.evaluar(funcion, 2, 3, 0.001, 50);

            }
        });
        submenu.agregar("Aproximar las raices para: x^3-7*(x^2)+14*x-6", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("x^3-7*(x^2)+14*x-6");
                System.out.println("Raiz 1:");
                metodo.evaluar(funcion, 0, 1, 0.0005, 50);
                System.out.println("");
                System.out.println("Raiz 2:");
                metodo.evaluar(funcion, 2.5, 3.2, 0.0005, 50);
                System.out.println("");
                System.out.println("Raiz 3:");
                metodo.evaluar(funcion, 3.2, 3.8, 0.0005, 50);

            }
        });





        menu.agregar("Ejercicios", submenu);
        menu.agregar("Ingresar Funcion", new MenuCallback() {
            public void ejecutar() {

                metodo.consola();

            }
        });
        menu.mostrar();


    }
}
