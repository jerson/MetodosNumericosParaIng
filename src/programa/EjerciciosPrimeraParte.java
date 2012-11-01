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
public class EjerciciosPrimeraParte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



        final NewtonRaphson newtomraphson = new NewtonRaphson();
        final PuntoFijo puntofijo = new PuntoFijo();
        final Biseccion biseccion = new Biseccion();

        Menu menu = new Menu();
        menu.setTitulo("Ejercicios Primera Parte");




        menu.agregar("Encontrar la Raiz de la siguiente ecuacion utilizando el metodo de newtom raphson: x^2-3*x+2-exp(x)", new MenuCallback() {
            public void ejecutar() {
                Funcion funcion = new Funcion("x^2-3*x+2-exp(x)");
                Funcion derivada = new Funcion("2*x-3-exp(x)");
                newtomraphson.evaluar(funcion, derivada, 0, 0.0001, 100);

            }
        });

        menu.agregar("Encontrar la raiz de ls siguiente ecuacion utilizando metodo de aproximaciones sucesivas: x^3+4*(x^2)-10", new MenuCallback() {
            public void ejecutar() {
                Funcion funcion = new Funcion("x^3+4*(x^2)-10");
                Funcion mejorada = new Funcion("((10-(x^3))/4)^(1/2)");

                puntofijo.evaluar(funcion, mejorada, 1, 0.0001, 100);

            }
        });

        menu.agregar("Encontrar la raiz de ls siguiente ecuacion utilizando metodo de Biseccion: x-(2^(-x))", new MenuCallback() {
            public void ejecutar() {
                Funcion funcion = new Funcion("x-(2^(-x))");
                biseccion.evaluar(funcion, 0, 1, 0.0001);

            }
        });

        menu.agregar("Caso 1: Resolver Usando el programa de computadora correspondiente", new MenuCallback() {
            public void ejecutar() {
                Funcion funcion = new Funcion("(1+3.592/(x^2))*(x-0.04267)-(0.082054*300)");
                Funcion derivada = new Funcion("1-3.592/(x^2)+(2*3.592*0.04267)/(x^3)");

                newtomraphson.evaluar(funcion, derivada, 1, 0.0001);

            }
        });

        menu.agregar("Caso 2: Resolver Usando el programa de computadora correspondiente", new MenuCallback() {
            public void ejecutar() {
                Funcion funcion = new Funcion("((((1+x)^10)-1)/(x*((1+x)^10)))-5");
                System.out.println("");

                System.out.println("Biseccion:");
                biseccion.evaluar(funcion, 0.1, 0.2, 0.0001);
                System.out.println("");
                System.out.println("Newtom Raphson:");
                newtomraphson.evaluar(funcion, 0.1, 0.0001, 100);

            }
        });

        menu.mostrar();



    }
}
