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
public class MetodoNewtonRaphson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final NewtonRaphson metodo = new NewtonRaphson();



        Menu menu = new Menu();
        menu.setTitulo("Newton Rapshon");

        Menu submenu = new Menu();


        submenu.agregar("Aproximar la primera raiz para: x^2-5*x+6", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("x^2-5*x+6");
                metodo.evaluar(funcion, 1.5, 0.01, 50);


            }
        });
        submenu.agregar("Aproximar la primera raiz negativa para: x^3+3*(x^2)-1", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("x^3+3*(x^2)-1");
                metodo.evaluar(funcion, -2.5, 0.0001, 50);

            }
        });
        submenu.agregar("Aproximar la primera raiz positiva para: 7*(x^4)+3*(x^2)-(3.14159265)", new MenuCallback() {
            public void ejecutar() {


                Funcion funcion = new Funcion("7*(x^4)+3*(x^2)-(3.14159265)");
                metodo.evaluar(funcion, 0, 0.001, 50);

            }
        });
        submenu.agregar("Aproximar la primera raiz positiva para: 7*(x^4)+3*(x^2)-(3.14159265)", new MenuCallback() {
            public void ejecutar() {


                Funcion funcion = new Funcion("7*(x^4)+3*(x^2)-(3.14159265)");
                metodo.evaluar(funcion, 0, 0.001, 50);

            }
        });
        submenu.agregar("Modificar el programa del ejercicio 2 agregando la aproximacion de la raiz por el metodo de la Biseccion: x^3+3*(x^2)-1", new MenuCallback() {
            public void ejecutar() {


                Funcion funcion = new Funcion("x^3+3*(x^2)-1");

                Biseccion biseccion = new Biseccion();
                biseccion.evaluar(funcion, -2.5, -3.5, 0.0001);

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
