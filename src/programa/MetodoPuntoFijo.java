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
public class MetodoPuntoFijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



        final PuntoFijo metodo = new PuntoFijo();


        Menu menu = new Menu();
        menu.setTitulo("Punto Fijo");

        Menu submenu = new Menu();


        submenu.agregar("x^2+x-2", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("x^2+x-2");
                Funcion mejorado = new Funcion("(-2/(x+1))");
                metodo.evaluar(funcion, mejorado, 2, 0.01, 20);


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
