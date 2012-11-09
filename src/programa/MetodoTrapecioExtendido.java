package programa;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import consola.*;
import funcion.*;
import metodos.*;
import java.io.*;

/**
 *
 * @author Gerson
 */
public class MetodoTrapecioExtendido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        final TrapecioExtendido metodo = new TrapecioExtendido();

        Menu menu = new Menu();
        menu.setTitulo("Regla del Trapecio Extendido");


        Menu submenu = new Menu();

        submenu.agregar("Ejemplo 1 - PDF", new MenuCallback() {
            public void ejecutar() {

                double a = 2;
                double b = 5;
                int n = 6;

                Funcion funcion = new Funcion("1/(x*(log(x)/log(exp(1))))");

                metodo.evaluar(funcion, a, b, n);
            }
        });
        submenu.agregar("Ejemplo 2 - PDF", new MenuCallback() {
            public void ejecutar() {

                double a = 1;
                double b = 2;
                int n = 4;

                Funcion funcion = new Funcion("exp(x)");

                metodo.evaluar(funcion, a, b, n);
            }
        });
        submenu.agregar("Ejemplo 3 - diapo", new MenuCallback() {
            public void ejecutar() {

                double a = 2;
                double b = 4;
                int n = 4;

                Funcion funcion = new Funcion("exp(x)/x");

                metodo.evaluar(funcion, a, b, n);
            }
        });




        menu.agregar("Ejercicios", submenu);
        menu.agregar("Ingresar Datos", new MenuCallback() {
            public void ejecutar() {

                metodo.consola();
            }
        });


        menu.mostrar();





    }
}
