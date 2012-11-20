/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import consola.Consola;
import funcion.*;

/**
 *
 * @author Gerson
 */
public class PuntoFijo extends Base {

    public double evaluar(Funcion funcion, Funcion mejorado, double x0, double e) {
        return this.evaluar(funcion, mejorado, x0, e, 100);
    }

    public double evaluar(Funcion funcion, Funcion mejorado, double x0, double e, int n) {

        System.out.println("X0: " + x0);
        System.out.println(" e: " + e);
        System.out.println(" n: " + n);
        System.out.println();

        this.funcion = funcion;
        double xm = 0;
        double q = 0;
        int i = 0;


        System.out.println(
                this.redondear("N", 5, true)
                + this.redondear("X0")
                + this.redondear("X Mejorado"));

        do {
            i++;
            xm = mejorado.evaluar(x0);

            System.out.println(
                    this.redondear(i + "", 5, true)
                    + this.redondear(x0)
                    + this.redondear(xm));

            q = Math.abs(xm - x0);
            x0 = xm;



        } while (i < n && q > e);


        if (q > e) {
            System.out.println("No hay Convergencia");
            return 0;
        } else {

            System.out.println("");

            System.out.println("Solucion Encontrada:" + this.redondear(xm));
            System.out.println("Valor de Comprobacion:" + this.redondear(funcion.evaluar(xm)));

            return xm;
        }




    }

    public void consola() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        String funcion_mejorado = consola.getCadena("Ingresa la Funcion Mejorada");
        double X0 = consola.getNumero("Ingresa el Valor para X0");
        double error = consola.getNumero("Ingresa la Tolerancia");
        int limite = consola.getEntero("Ingresa el maximo de Iteraciones", 100);

        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("Cuantos decimales queres usar para el reporte?", 6);
        int espaciado = consola.getEntero("cuanto espacio necesitas para el reporte", 12);

        this.fraccion = fraccion;
        this.decimales = decimales;
        this.espaciado = espaciado < this.espaciado ? this.espaciado : espaciado;


        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);
        Funcion mejorado = new Funcion(funcion_mejorado);


        this.evaluar(funcion, mejorado, X0, error, limite);
    }
}
