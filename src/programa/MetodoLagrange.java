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
public class MetodoLagrange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        final Lagrange metodo = new Lagrange();

        Menu menu = new Menu();
        menu.setTitulo("Interpolacion de Lagrange");


        Menu submenu = new Menu();
        submenu.agregar("Ejemplo 1 - PDF", new MenuCallback() {
            public void ejecutar() {

                double[] x=new double[3];
                double[] y=new double[3];

                double numero = 251;
                x[0]=94;
                x[1]=205;
                x[2]=371;

                y[0]=929;
                y[1]=902;
                y[2]=860;

                metodo.evaluar(x,y,numero);
            }
        });
        submenu.agregar("Ejemplo 2 - PDF", new MenuCallback() {
            public void ejecutar() {

                double[] x=new double[4];
                double[] y=new double[4];

                double numero = 50;
                x[0]=30;
                x[1]=40;
                x[2]=55;
                x[3]=70;

                y[0]=0;
                y[1]=1.6;
                y[2]=4.8;
                y[3]=8.9;

                metodo.evaluar(x,y,numero);
            }
        });
        submenu.agregar("Ejemplo 3 - PDF", new MenuCallback() {
            public void ejecutar() {

                double[] x=new double[7];
                double[] y=new double[7];

                double numero = 0.8;
                x[0]=0.1;
                x[1]=0.3;
                x[2]=0.5;
                x[3]=0.7;
                x[4]=0.9;
                x[5]=1.1;
                x[6]=1.3;

                y[0]=0.99750;
                y[1]=0.97763;
                y[2]=0.93847;
                y[3]=0.88120;
                y[4]=0.80752;
                y[5]=0.71962;
                y[6]=0.62009;

                metodo.evaluar(x,y,numero);
            }
        });

        submenu.agregar("Ejemplo 4", new MenuCallback() {
            public void ejecutar() {

                double[] x=new double[4];
                double[] y=new double[4];

                double numero = 0;
                x[0]=5;
                x[1]=-7;
                x[2]=-6;
                x[3]=0;

                y[0]=1;
                y[1]=-23;
                y[2]=-54;
                y[3]=-954;

                metodo.evaluar(x,y,numero);
            }
        });
        submenu.agregar("Ejemplo ", new MenuCallback() {
            public void ejecutar() {

                double[] x=new double[4];
                double[] y=new double[4];

                double numero = 270;
                x[0]=5;
                x[1]=7;
                x[2]=9;
                x[3]=11;

                y[0]=250;
                y[1]=320;
                y[2]=400;
                y[3]=450;

                metodo.evaluar(x,y,numero);
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
