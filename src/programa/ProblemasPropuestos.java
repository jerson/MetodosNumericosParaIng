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
public class ProblemasPropuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



        final NewtonRaphson newtomraphson = new NewtonRaphson();
        final PuntoFijo puntofijo = new PuntoFijo();
        final FalsaPosicion falsa = new FalsaPosicion();
        final Secante secante = new Secante();


        Menu menu = new Menu();
        menu.setTitulo("Problemas Propuestos");

        menu.agregar("Secante: x^3-3*x^2-4", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("x^3-3*x^2-4");
                secante.evaluar(funcion, 2, 5, 0.01);


            }
        });
        menu.agregar("Newtom raphson: (80*exp(-2*x)+20*exp(-0.5*x))-7.0", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("(80*exp(-2*x)+20*exp(-0.5*x))-7.0");
                Funcion derivada = new Funcion("-160*exp(-2*x)-10*exp(-0.5*x)");

                newtomraphson.evaluar(funcion, derivada, 0, 0.00000001, 100);


            }
        });

        menu.agregar("Falsa Posicion: ((500*exp(-0.0248*x)))-5", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("((500*exp(-0.0248*x)))-5");

                falsa.evaluar(funcion, 150, 200, 0.0001, 20);

            }
        });


        menu.agregar("Punto Fijo: exp(-x-(3.14159/2))-x", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion = new Funcion("exp(-x-(3.14159/2))-x");
                Funcion mejorado = new Funcion("exp(-x-(3.14159/2))");

                puntofijo.evaluar(funcion, mejorado, 0, 0.01, 80);

            }
        });


      
        menu.mostrar();


    }
}
