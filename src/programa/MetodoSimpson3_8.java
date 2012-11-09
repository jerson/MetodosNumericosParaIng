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
public class MetodoSimpson3_8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        final Simpson3_8 metodo = new Simpson3_8();

        Menu menu = new Menu();
        menu.setTitulo("Regla de Simpson 3/8");



        Menu submenu = new Menu();
        submenu.agregar("Ejemplo 1 - Internet", new MenuCallback() {
            public void ejecutar() {

                double x0 = 1;
                double x1 = 2;
                double x2 = 3;
                double x3 = 4;
                Funcion funcion = new Funcion("exp(x)*(log(x)/log(exp(1)))");

                metodo.evaluar(funcion, x0, x1, x2, x3);
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
