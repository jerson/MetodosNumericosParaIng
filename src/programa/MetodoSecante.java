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
public class MetodoSecante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



        final Secante metodo = new Secante();


        Menu menu = new Menu();
        menu.setTitulo("Secante");

        Menu submenu = new Menu();


        submenu.agregar("(5*(10^6)+887/(x^2))*(x-0.00267)-(518*300)", new MenuCallback() {
            public void ejecutar() {

                double rp = (518 * 300.0) / (5 * Math.pow(10, 6.0));
                Funcion funcion = new Funcion("(5*(10^6)+887/(x^2))*(x-0.00267)-(518*300)");
                metodo.evaluar(funcion, (0.5 * rp), (1.5 * rp), 0.1, 10);


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
