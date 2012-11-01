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
public class MetodoGaussJordan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


           final GaussJordan metodo = new GaussJordan();

        Menu menu = new Menu();
        menu.setTitulo("Gauss-Jordan");


        Menu submenu = new Menu();
        submenu.agregar("Matriz 1 - Clase", new MenuCallback() {
            public void ejecutar() {

                double[][] matriz = new double[3][4];

                matriz[0][0] = 2;
                matriz[0][1] = 1;
                matriz[0][2] = -3;
                matriz[0][3] = -1;

                matriz[1][0] = -1;
                matriz[1][1] = 3;
                matriz[1][2] = 2;
                matriz[1][3] = 12;

                matriz[2][0] = 3;
                matriz[2][1] = 1;
                matriz[2][2] = -3;
                matriz[2][3] = 0;

                metodo.evaluar(matriz, false);
            }
        });
        submenu.agregar("Matriz 2", new MenuCallback() {
            public void ejecutar() {

                double[][] matriz = new double[3][4];

                matriz[0][0] = 3;
                matriz[0][1] = -0.1;
                matriz[0][2] = -0.2;
                matriz[0][3] = 7.85;

                matriz[1][0] = 0.1;
                matriz[1][1] = 7;
                matriz[1][2] = -0.3;
                matriz[1][3] = -19.3;

                matriz[2][0] = 0.3;
                matriz[2][1] = -0.2;
                matriz[2][2] = 10;
                matriz[2][3] = 71.4;

                metodo.evaluar(matriz, true);
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
