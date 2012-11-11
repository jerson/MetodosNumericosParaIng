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
public class EjerciciosSegundaParte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        final Gauss gauss = new Gauss();
        final GaussJacobi gaussjacobi = new GaussJacobi();
        final GaussJordan gaussjordan = new GaussJordan();
        final GaussSeidel gaussseidel = new GaussSeidel();
        final Lagrange lagrange = new Lagrange();
        final Newton newton = new Newton();
        final Trapecio trapecio = new Trapecio();
        final TrapecioExtendido trapecioextendido = new TrapecioExtendido();
        final Simpson1_3 simpson1_3 = new Simpson1_3();
        final Simpson1_3Extendida simpson1_3extendida = new Simpson1_3Extendida();
        final Simpson3_8 simpson3_8 = new Simpson3_8();
        final Simpson3_8Extendida simpson3_8extendida = new Simpson3_8Extendida();
        
        final Base base = new Base();
        
        Menu menu = new Menu();
        menu.setTitulo("Ejercicios Segunda Parte");
        
        
        Menu submenu = new Menu();
        
        submenu.agregar("Resuelvase el Siguiente conjunto de ecuaciones", new MenuCallback() {
            public void ejecutar() {
                
                double[][] matriz = new double[3][4];
                
                matriz[0][0] = 4;
                matriz[0][1] = -2;
                matriz[0][2] = 1;
                matriz[0][3] = 39;
                
                matriz[1][0] = 1;
                matriz[1][1] = -6;
                matriz[1][2] = 2;
                matriz[1][3] = -28;
                
                matriz[2][0] = 1;
                matriz[2][1] = -3;
                matriz[2][2] = 12;
                matriz[2][3] = -86;

                //System.out.println("a)");
                // gauss.evaluar(base.clonar(matriz), false);

                System.out.println("b)");
                gaussjordan.evaluar(base.clonar(matriz), false);
                
                System.out.println("c)");
                gaussseidel.evaluar(base.clonar(matriz), 0.05, 100);
                
                
            }
        });
        
        submenu.agregar("Resuelvase el Siguiente conjunto de ecuaciones", new MenuCallback() {
            public void ejecutar() {
                
                double[][] matriz = new double[3][4];
                
                matriz[0][0] = 1;
                matriz[0][1] = -3;
                matriz[0][2] = 12;
                matriz[0][3] = 10;
                
                matriz[1][0] = 5;
                matriz[1][1] = -12;
                matriz[1][2] = 2;
                matriz[1][3] = -33;
                
                matriz[2][0] = 1;
                matriz[2][1] = -14;
                matriz[2][2] = 0;
                matriz[2][3] = -103;

                //System.out.println("a)");
                // gauss.evaluar(base.clonar(matriz), false);

                System.out.println("b)");
                gaussjordan.evaluar(base.clonar(matriz), false);
                
                System.out.println("c)");
                gaussseidel.evaluar(base.clonar(matriz), 0.05, 100);
                
                
            }
        });
        menu.agregar("Sistemas de Ecuaciones", submenu);
        
        
        
        Menu submenu2 = new Menu();
        submenu2.agregar("Calculese el Log4 usando interpolacion lineal", new MenuCallback() {
            public void ejecutar() {
                // no entiendo
            }
        });
        
        submenu2.agregar("Ajústese un polinomio de interpolación de Newton de segundo orden para aproximar log 4 usando los datos del problema 1. Calcúlese el error relativo porcentual.", new MenuCallback() {
            public void ejecutar() {
                // no entiendo
            }
        });
        submenu2.agregar("Ajústese un polinomio de interpolación de Newton de tercer orden para calcular log 4 usando los datos del problema 1, además del punto adicional 3 x= 3,5. Calcúlese el error relativo porcentual.", new MenuCallback() {
            public void ejecutar() {
                // no entiendo
            }
        });
        submenu2.agregar("Dado los datos.", new MenuCallback() {
            public void ejecutar() {
                
                double[] x = new double[6];
                double[] y = new double[6];
                
                double numero = 6;
                x[0] = 0;
                x[1] = 0.5;
                x[2] = 1;
                x[3] = 1.5;
                x[4] = 2;
                x[5] = 2.5;
                
                y[0] = 1;
                y[1] = 2119;
                y[2] = 2910;
                y[3] = 3945;
                y[4] = 5720;
                y[5] = 8695;
                
                newton.evaluar(x, y, numero);
                
            }
        });
        submenu2.agregar("Repítanse los problemas 1 al 4 usando polinomios de Lagrange.", new MenuCallback() {
            public void ejecutar() {
                
                double[] x = new double[6];
                double[] y = new double[6];
                
                double numero = 6;
                x[0] = 0;
                x[1] = 0.5;
                x[2] = 1;
                x[3] = 1.5;
                x[4] = 2;
                x[5] = 2.5;
                
                y[0] = 1;
                y[1] = 2119;
                y[2] = 2910;
                y[3] = 3945;
                y[4] = 5720;
                y[5] = 8695;
                
                lagrange.evaluar(x, y, numero);
                
            }
        });
        
        
        menu.agregar("Interpolacion Lineal", submenu2);
        
        
        Menu submenu3 = new Menu();
        submenu3.agregar("Utilice medios analiticos para evaluar", new MenuCallback() {
            public void ejecutar() {
                System.out.println("Esto se hace manualmente");
            }
        });
        
        Menu apartados = new Menu();
        apartados.agregar("Trapecio", new MenuCallback() {
            public void ejecutar() {
                
                System.out.println("a)");
                Funcion funcion = new Funcion("10+2*x-6*x^2+5*x^4");
                trapecio.evaluar(funcion, 0, 10);
                System.out.println("");
                
                System.out.println("b)");
                Funcion funcionb = new Funcion("1-x-4*x+3*x^5");
                trapecio.evaluar(funcionb, -3, 5);
                System.out.println("");
                
                System.out.println("c)");
                Funcion funcionc = new Funcion("8+5*sin(x)");
                trapecio.evaluar(funcionc, 0, Math.PI);
                System.out.println("");
                
            }
        });
        apartados.agregar("Trapecio Extendido", new MenuCallback() {
            public void ejecutar() {
                
                System.out.println("a)");
                Funcion funcion = new Funcion("10+2*x-6*x^2+5*x^4");
                trapecioextendido.evaluar(funcion, 0, 10, 2);
                System.out.println("");
                
                System.out.println("b)");
                Funcion funcionb = new Funcion("1-x-4*x+3*x^5");
                trapecioextendido.evaluar(funcionb, -3, 5, 4);
                System.out.println("");
                
                System.out.println("c)");
                Funcion funcionc = new Funcion("8+5*sin(x)");
                trapecioextendido.evaluar(funcionc, 0, Math.PI, 6);
                System.out.println("");
                
            }
        });
        apartados.agregar("Simpson 1/3", new MenuCallback() {
            public void ejecutar() {
                
                System.out.println("a)");
                Funcion funcion = new Funcion("10+2*x-6*x^2+5*x^4");
                simpson1_3.evaluar(funcion, 0, 10);
                System.out.println("");
                
                System.out.println("b)");
                Funcion funcionb = new Funcion("1-x-4*x+3*x^5");
                simpson1_3.evaluar(funcionb, -3, 5);
                System.out.println("");
                
                System.out.println("c)");
                Funcion funcionc = new Funcion("8+5*sin(x)");
                simpson1_3.evaluar(funcionc, 0, Math.PI);
                System.out.println("");
                
            }
        });
        apartados.agregar("Simpson 1/3 Extendido", new MenuCallback() {
            public void ejecutar() {
                
                System.out.println("a)");
                Funcion funcion = new Funcion("10+2*x-6*x^2+5*x^4");
                simpson1_3extendida.evaluar(funcion, 0, 10, 4);
                System.out.println("");
                
                System.out.println("b)");
                Funcion funcionb = new Funcion("1-x-4*x+3*x^5");
                simpson1_3extendida.evaluar(funcionb, -3, 5, 4);
                System.out.println("");
                
                System.out.println("c)");
                Funcion funcionc = new Funcion("8+5*sin(x)");
                simpson1_3extendida.evaluar(funcionc, 0, Math.PI, 6);
                System.out.println("");
                
            }
        });
        apartados.agregar("Simpson 3/8", new MenuCallback() {
            public void ejecutar() {
                
                System.out.println("a)");
                Funcion funcion = new Funcion("10+2*x-6*x^2+5*x^4");
                simpson3_8.evaluar(funcion, 0, 2, 5, 10);
                System.out.println("");
                
                System.out.println("b)");
                Funcion funcionb = new Funcion("1-x-4*x+3*x^5");
                simpson3_8.evaluar(funcionb, -3, -1, 2, 5);
                System.out.println("");
                
                System.out.println("c)");
                Funcion funcionc = new Funcion("8+5*sin(x)");
                simpson3_8.evaluar(funcionc, 0, 1, 2, Math.PI);
                System.out.println("");
                
            }
        });
        apartados.agregar("Simpson 3/8 Extendido", new MenuCallback() {
            public void ejecutar() {
                
                System.out.println("a)");
                Funcion funcion = new Funcion("10+2*x-6*x^2+5*x^4");
                simpson3_8extendida.evaluar(funcion, 0, 10, 5);
                System.out.println("");
                
                System.out.println("b)");
                Funcion funcionb = new Funcion("1-x-4*x+3*x^5");
                simpson3_8extendida.evaluar(funcionb, -3, 5, 5);
                System.out.println("");
                
                System.out.println("c)");
                Funcion funcionc = new Funcion("8+5*sin(x)");
                simpson3_8extendida.evaluar(funcionc, 0, Math.PI, 5);
                System.out.println("");
                
            }
        });
        
        
        submenu3.agregar("Evalue las integrales del apartado 1", apartados);
        menu.agregar("Integracion numerica", submenu3);
        
        
        Menu submenu4 = new Menu();        
        submenu4.agregar("Techo ondulado", new MenuCallback() {
            public void ejecutar() {
                
                System.out.println("................");
                
                
            }
        });
        submenu4.agregar("Drenar Pantano", new MenuCallback() {
            public void ejecutar() {
                
                System.out.println("................");
                
                
            }
        });
        
        
        
        menu.agregar("Aplicaciones", submenu4);
        
        
        menu.mostrar();
        
        
        
    }
}
