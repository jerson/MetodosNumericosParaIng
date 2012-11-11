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
public class MetodoRomberg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        final Romberg metodo = new Romberg();

        Menu menu = new Menu();
        menu.setTitulo("Metodo Romberg");


        Menu submenu = new Menu();

        submenu.agregar("Ejemplo 1 - Expo", new MenuCallback() {
            public void ejecutar() {

                double a = 0;
                double b = 1;
                int n = 3;

                Funcion funcion = new Funcion("exp(x^2)");

                metodo.evaluar(funcion, a, b, n);
            }
        });
        submenu.agregar("Ejemplo 2 - Expo", new MenuCallback() {
            public void ejecutar() {

                double a = 1;
                double b = 2;
                int n = 4;

                Funcion funcion = new Funcion("exp(x)*(log(x)/log(exp(1)))");

                metodo.evaluar(funcion, a, b, n);
            }
        });
        submenu.agregar("Ejemplo 3 - Expo", new MenuCallback() {
            public void ejecutar() {

                double a = 1;
                double b = 3;
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
