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
public class MetodoGaussSeidel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        final GaussSeidel metodo = new GaussSeidel();

        Menu menu = new Menu();
        menu.setTitulo("Gauss-Seidel");


        Menu submenu = new Menu();
        submenu.agregar("Matriz 1", new MenuCallback() {
            public void ejecutar() {

                double[][] matriz = new double[3][4];

                matriz[0][0] = 3;
                matriz[0][1] = -0.2;
                matriz[0][2] = -0.5;
                matriz[0][3] = 8;

                matriz[1][0] = 0.1;
                matriz[1][1] = 7;
                matriz[1][2] = 0.4;
                matriz[1][3] = -19.5;

                matriz[2][0] = 0.4;
                matriz[2][1] = -0.1;
                matriz[2][2] = 10;
                matriz[2][3] = 72.4;


                metodo.evaluar(matriz, 0.01, 100);
            }
        });
        submenu.agregar("Matriz 2", new MenuCallback() {
            public void ejecutar() {

                double[][] matriz = new double[3][4];


                // lo ordene manualmente

                matriz[0][0] = -5;
                matriz[0][1] = 1.4;
                matriz[0][2] = -2.7;
                matriz[0][3] = 94.2;

                matriz[1][0] = 3.3;
                matriz[1][1] = -11;
                matriz[1][2] = 4.4;
                matriz[1][3] = -27.5;

                matriz[2][0] = 0.7;
                matriz[2][1] = -2.5;
                matriz[2][2] = 15;
                matriz[2][3] = -6;


                metodo.evaluar(matriz, 0.01, 100);
            }
        });

        menu.agregar("Ejercicios", submenu);
        menu.agregar("Ingresar Matriz", new MenuCallback() {
            public void ejecutar() {

                metodo.consola();
            }
        });


        menu.mostrar();





    }
}
