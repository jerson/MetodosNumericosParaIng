/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import consola.Menu;
import consola.MenuCallback;
import metodos.*;

/**
 *
 * @author Gerson
 */
public class MetodosNumericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setTitulo("Metodos Numericos");

        menu.agregar("Busqueda Incremental", new MenuCallback() {
            public void ejecutar() {

                BusquedaIncremental metodo = new BusquedaIncremental();
                metodo.consola();
            }
        });
        menu.agregar("Biseccion", new MenuCallback() {
            public void ejecutar() {
                Biseccion metodo = new Biseccion();
                metodo.consola();
            }
        });

        menu.agregar("Falsa Posicion", new MenuCallback() {
            public void ejecutar() {
                FalsaPosicion metodo = new FalsaPosicion();
                metodo.consola();
            }
        });
        menu.agregar("Newton Raphson", new MenuCallback() {
            public void ejecutar() {
                NewtonRaphson metodo = new NewtonRaphson();
                metodo.consola();
            }
        });
        menu.agregar("Punto Fijo", new MenuCallback() {
            public void ejecutar() {
                PuntoFijo metodo = new PuntoFijo();
                metodo.consola();
            }
        });
        menu.agregar("Secante", new MenuCallback() {
            public void ejecutar() {
                Secante metodo = new Secante();
                metodo.consola();
            }
        });
        menu.agregar("Gauss", new MenuCallback() {
            public void ejecutar() {
                Gauss metodo = new Gauss();
                metodo.consola();
            }
        });
        menu.agregar("Gauss-Jordan", new MenuCallback() {
            public void ejecutar() {
                GaussJordan metodo = new GaussJordan();
                metodo.consola();
            }
        });
        menu.agregar("Gauss-Seidel", new MenuCallback() {
            public void ejecutar() {
                GaussSeidel metodo = new GaussSeidel();
                metodo.consola();
            }
        });
        menu.agregar("Gauss-Jacobi", new MenuCallback() {
            public void ejecutar() {
                GaussJacobi metodo = new GaussJacobi();
                metodo.consola();
            }
        });
        menu.agregar("Interpolacion de Lagrange", new MenuCallback() {
            public void ejecutar() {
                Lagrange metodo = new Lagrange();
                metodo.consola();
            }
        });
        menu.agregar("Interpolacion de Newton", new MenuCallback() {
            public void ejecutar() {
                Newton metodo = new Newton();
                metodo.consola();
            }
        });
        menu.agregar("Interpolacion de Neville", new MenuCallback() {
            public void ejecutar() {
                Neville metodo = new Neville();
                metodo.consola();
            }
        });
        
        
        menu.agregar("Regla del Trapecio", new MenuCallback() {
            public void ejecutar() {
                Trapecio metodo = new Trapecio();
                metodo.consola();
            }
        });
        menu.agregar("Regla del Trapecio Extendida", new MenuCallback() {
            public void ejecutar() {
                TrapecioExtendido metodo = new TrapecioExtendido();
                metodo.consola();
            }
        });
        menu.agregar("Regla del Simpson 1/3", new MenuCallback() {
            public void ejecutar() {
                Simpson1_3 metodo = new Simpson1_3();
                metodo.consola();
            }
        });
        menu.agregar("Regla del Simpson 1/3 Extendida", new MenuCallback() {
            public void ejecutar() {
                Simpson1_3Extendida metodo = new Simpson1_3Extendida();
                metodo.consola();
            }
        });
        menu.agregar("Regla del Simpson 3/8", new MenuCallback() {
            public void ejecutar() {
                Simpson3_8 metodo = new Simpson3_8();
                metodo.consola();
            }
        });
        menu.agregar("Regla del Simpson 3/8 Extendida", new MenuCallback() {
            public void ejecutar() {
                Simpson3_8Extendida metodo = new Simpson3_8Extendida();
                metodo.consola();
            }
        });




        menu.mostrar();
    }
}
