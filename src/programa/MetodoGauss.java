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
public class MetodoGauss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        final Gauss metodo = new Gauss();

        Menu menu = new Menu();
        menu.setTitulo("Gauss");


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

                matriz[0][0] = 5;
                matriz[0][1] = -8;
                matriz[0][2] = 1;
                matriz[0][3] = -71;

                matriz[1][0] = -2;
                matriz[1][1] = 6;
                matriz[1][2] = -9;
                matriz[1][3] = 134;

                matriz[2][0] = 3;
                matriz[2][1] = -5;
                matriz[2][2] = 2;
                matriz[2][3] = -58;

                metodo.evaluar(matriz, false);
            }
        });

        submenu.agregar("Matriz 3", new MenuCallback() {
            public void ejecutar() {

                double[][] matriz = new double[4][5];

                matriz[0][0] = 3;
                matriz[0][1] = -1;
                matriz[0][2] = 0;
                matriz[0][3] = 6;
                matriz[0][4] = 2.3;

                matriz[1][0] = 4;
                matriz[1][1] = 2;
                matriz[1][2] = -1;
                matriz[1][3] = -5;
                matriz[1][4] = 6.9;

                matriz[2][0] = -5;
                matriz[2][1] = 1;
                matriz[2][2] = -3;
                matriz[2][3] = 0;
                matriz[2][4] = -16.8;

                matriz[3][0] = 0;
                matriz[3][1] = 10;
                matriz[3][2] = -4;
                matriz[3][3] = 7;
                matriz[3][4] = -36;

                metodo.evaluar(matriz, false);
            }
        });

        submenu.agregar("Matriz 4 - pivoteo", new MenuCallback() {
            public void ejecutar() {

                double[][] matriz = new double[3][4];

                matriz[0][0] = 1;
                matriz[0][1] = -2;
                matriz[0][2] = 0.5;
                matriz[0][3] = -5;

                matriz[1][0] = -2;
                matriz[1][1] = 5;
                matriz[1][2] = -1.5;
                matriz[1][3] = 0;

                matriz[2][0] = -0.2;
                matriz[2][1] = 1.75;
                matriz[2][2] = -1;
                matriz[2][3] = 10;


                metodo.evaluar(matriz, false);
            }
        });

        submenu.agregar("Matriz 5 - pivoteo", new MenuCallback() {
            public void ejecutar() {

                double[][] matriz = new double[3][4];

                matriz[0][0] = 0.4;
                matriz[0][1] = -1.5;
                matriz[0][2] = 0.75;
                matriz[0][3] = -20;

                matriz[1][0] = -0.5;
                matriz[1][1] = -15;
                matriz[1][2] = 10;
                matriz[1][3] = -10;

                matriz[2][0] = -10;
                matriz[2][1] = -9;
                matriz[2][2] = 2.5;
                matriz[2][3] = 30;


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
