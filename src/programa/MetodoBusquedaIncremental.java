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
public class MetodoBusquedaIncremental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      
        final BusquedaIncremental metodo = new BusquedaIncremental();



        Menu menu = new Menu();
        menu.setTitulo("Busqueda Incremental");

        Menu submenu = new Menu();


        submenu.agregar("(x^4)-4*(x^3)+6*(x^2)-(3*0.75)", new MenuCallback() {
            public void ejecutar() {
                Funcion funcion = new Funcion("(x^4)-4*(x^3)+6*(x^2)-(3*0.75)");
                metodo.evaluar(funcion, 1, -0.05, 100);

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
