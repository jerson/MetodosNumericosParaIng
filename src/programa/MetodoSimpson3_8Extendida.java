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
public class MetodoSimpson3_8Extendida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        final Simpson3_8Extendida metodo = new Simpson3_8Extendida();

        Menu menu = new Menu();
        menu.setTitulo("Regla de Simpson 3/8 Extendida");



        Menu submenu = new Menu();
        submenu.agregar("Ejemplo 1 - PDF", new MenuCallback() {
            public void ejecutar() {

                double a = 1;
                double b = 4;
                int n = 8;
                Funcion funcion = new Funcion("(log(x)/log(exp(1)))/x");

                metodo.evaluar(funcion, a, b, n);
            }
        });
        submenu.agregar("Ejemplo 2 - Internet", new MenuCallback() {
            public void ejecutar() {

                double a = 8;
                double b = 30;
                int n = 6;
                Funcion funcion = new Funcion("2000*(log((140000/(140000-2100*x)))/log(exp(1)))-9.8*x");

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
