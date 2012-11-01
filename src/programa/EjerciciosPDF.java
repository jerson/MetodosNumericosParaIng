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
public class EjerciciosPDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {




        final NewtonRaphson newtomraphson = new NewtonRaphson();
        final PuntoFijo puntofijo = new PuntoFijo();
        final Biseccion biseccion = new Biseccion();
        final FalsaPosicion falsa = new FalsaPosicion();
        final Secante secante = new Secante();
        final BusquedaIncremental incremental = new BusquedaIncremental();


        Menu menu = new Menu();
        menu.setTitulo("Ejercicios PDF");


        Menu submenu = new Menu();
        submenu.agregar("(x^4)-4*(x^3)+6*(x^2)-(3*0.75)", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion1 = new Funcion("(x^4)-4*(x^3)+6*(x^2)-(3*0.75)");
                incremental.evaluar(funcion1, 1, -0.05, 100);

            }
        });


        menu.agregar("Busqueda Incremental", submenu);


        Menu submenu2 = new Menu();
        submenu2.agregar("(((2+0.4*x^2)/2.4)^3.5-1)/(0.7*x^2*(-0.383))-((1-x^2)^(-1/2)+(x^2*(-0.383)/2)/(1+(1+x^2)^(-1/2))^(-1))", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion2 = new Funcion("(((2+0.4*x^2)/2.4)^3.5-1)/(0.7*x^2*(-0.383))-((1-x^2)^(-1/2)+(x^2*(-0.383)/2)/(1+(1+x^2)^(-1/2))^(-1))");
                biseccion.evaluar(funcion2, 0.18, 0.98, 0.01);

            }
        });
        submenu2.agregar("exp(x)-2", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion3 = new Funcion("exp(x)-2");
                biseccion.evaluar(funcion3, 0, 2, 0.01);

            }
        });
        submenu2.agregar("-19(x-0.5)*(x-1)+exp(x)-exp(-2*x)", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion4 = new Funcion("-19(x-0.5)*(x-1)+exp(x)-exp(-2*x)");
                biseccion.evaluar(funcion4, -10, 10, 0.0001);

            }
        });
        submenu2.agregar("5*x^4-3*x^3+2*x^2-6*x", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion5 = new Funcion("5*x^4-3*x^3+2*x^2-6*x");
                biseccion.evaluar(funcion5, 1, 1.2, 0.0001);

            }
        });
        submenu2.agregar("5*x^4-3*x^3+2*x^2-6*x", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion6 = new Funcion("5*x^4-3*x^3+2*x^2-6*x");
                incremental.evaluar(funcion6, 1, 0.01, 100);

            }
        });

        menu.agregar("Biseccion", submenu2);




        Menu submenu3 = new Menu();

        submenu3.agregar("(((2+0.4*x^2)/2.4)^3.5-1)/(0.7*x^2*(-0.383))-((1-x^2)^(-1/2)+(x^2*(-0.383)/2)/(1+(1+x^2)^(-1/2))^(-1))", new MenuCallback() {
            public void ejecutar() {
                Funcion funcion7 = new Funcion("(((2+0.4*x^2)/2.4)^3.5-1)/(0.7*x^2*(-0.383))-((1-x^2)^(-1/2)+(x^2*(-0.383)/2)/(1+(1+x^2)^(-1/2))^(-1))");
                falsa.evaluar(funcion7, 0.18, 0.98, 0.01, 9);
            }
        });
        submenu3.agregar("(((2+0.4*x^2)/2.4)^3.5-1)/(0.7*x^2*(-0.383))-((1-x^2)^(-1/2)+(x^2*(-0.383)/2)/(1+(1+x^2)^(-1/2))^(-1))", new MenuCallback() {
            public void ejecutar() {
                Funcion funcion7 = new Funcion("(((2+0.4*x^2)/2.4)^3.5-1)/(0.7*x^2*(-0.383))-((1-x^2)^(-1/2)+(x^2*(-0.383)/2)/(1+(1+x^2)^(-1/2))^(-1))");
                falsa.evaluar(funcion7, 0.18, 0.98, 0.01, 50);
            }
        });
        submenu3.agregar("(x^4)-4*(x^3)+6*(x^2)-(3*0.75)", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion8 = new Funcion("(x^4)-4*(x^3)+6*(x^2)-(3*0.75)");
                falsa.evaluar(funcion8, 0.7, 0.95, 0.001, 50);
            }
        });

        menu.agregar("Falsa Posicion", submenu3);


        Menu submenu4 = new Menu();

        submenu4.agregar("exp(-x)-(log(x)/log(exp(1)))", new MenuCallback() {
            public void ejecutar() {
                Funcion funcion9 = new Funcion("exp(-x)-(log(x)/log(exp(1)))");
                Funcion derivada9 = new Funcion("(-exp(-x))-(1/x)");

                newtomraphson.evaluar(funcion9, derivada9, 1, 0.01, 9);
            }
        });
        submenu4.agregar("atan(x)+x-1", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion10 = new Funcion("atan(x)+x-1");
                Funcion derivada10 = new Funcion("(1/(1+x^2))+1");

                newtomraphson.evaluar(funcion10, derivada10, 0, 0.01, 9);
            }
        });
        submenu4.agregar("x^2-26", new MenuCallback() {
            public void ejecutar() {
                Funcion funcion111 = new Funcion("x^2-26");
                Funcion derivada111 = new Funcion("2x");

                newtomraphson.evaluar(funcion111, 5, 0.001, 100);

            }
        });
        submenu4.agregar("(x^4)-4*(x^3)+6*(x^2)-(3*0.75)", new MenuCallback() {
            public void ejecutar() {

                System.out.println("FALTA SABER QUE ES a");
                Funcion funcion11 = new Funcion("(x^4)-4*(x^3)+6*(x^2)-(3*0.75)");

                newtomraphson.evaluar(funcion11, 0.8, 0.001, 100);
            }
        });
        submenu4.agregar("tan(x)-0.5*x", new MenuCallback() {
            public void ejecutar() {


                Funcion funcion12 = new Funcion("tan(x)-0.5*x");

                newtomraphson.evaluar(funcion12, 4, 0.001, 100);
            }
        });



        menu.agregar("Newton Raphson", submenu4);


        Menu submenu5 = new Menu();

        submenu5.agregar("(5*(10^6)+887/(x^2))*(x-0.00267)-(518*300)", new MenuCallback() {
            public void ejecutar() {
                double rp = (518 * 300.0) / (5 * Math.pow(10, 6.0));
                Funcion funcion13 = new Funcion("(5*(10^6)+887/(x^2))*(x-0.00267)-(518*300)");
                secante.evaluar(funcion13, (0.5 * rp), (1.5 * rp), 0.1, 10);
            }
        });

        menu.agregar("Secante", submenu5);


        Menu submenu6 = new Menu();

        submenu6.agregar("(x^4)-4*(x^3)+6*(x^2)-(3*0.75)", new MenuCallback() {
            public void ejecutar() {

                Funcion funcion14 = new Funcion("(x^4)-4*(x^3)+6*(x^2)-(3*0.75)");
                Funcion mejorado14 = new Funcion("((3*(0.75)+4*(x^3)-(x^4))/6)^(1/2)");

                puntofijo.evaluar(funcion14, mejorado14, 0.75, 0.00001, 20);
            }
        });

        menu.agregar("Punto Fijo", submenu6);

        menu.mostrar();


    }
}
