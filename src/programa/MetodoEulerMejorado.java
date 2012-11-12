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
public class MetodoEulerMejorado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        final EulerMejorado metodo = new EulerMejorado();

        Menu menu = new Menu();
        menu.setTitulo("Metodo de Euler");


        Menu submenu = new Menu();

        submenu.agregar("Ejemplo 1", new MenuCallback() {
            public void ejecutar() {

                double a = 0;
                double b = 0.5;
                double y = 1;
                int n = 5;

                Funcion funcion = new Funcion("2*x*y");

                metodo.evaluar(funcion, a, b, y, n);
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
