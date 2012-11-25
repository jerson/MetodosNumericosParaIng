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
public class MetodoCuadraturaGauss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        final CuadraturaGauss metodo = new CuadraturaGauss();

        Menu menu = new Menu();
        menu.setTitulo("Metodo de Cuadratura de Gauss");


        Menu submenu = new Menu();

        submenu.agregar("Ejemplo 1", new MenuCallback() {
            public void ejecutar() {

                double a = 1;
                double b = 5;
               
                int n = 2;

                Funcion funcion = new Funcion("x^3+2*x^2");

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
