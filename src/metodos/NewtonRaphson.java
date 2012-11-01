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
public class NewtonRaphson extends Base {

    public double evaluar(Funcion funcion, Funcion derivada, double x0, double e) {
        return this.evaluar(funcion, derivada, x0, e, 100);
    }

    public double evaluar(Funcion funcion, double x0, double e) {
        return this.evaluar(funcion, null, x0, e, 100);
    }

    public double evaluar(Funcion funcion, double x0, double e, int n) {
        return this.evaluar(funcion, null, x0, e, n);
    }

    public double evaluar(Funcion funcion, Funcion derivada, double x0, double e, int n) {

        System.out.println("X0: " + x0);
        System.out.println(" e: " + e);
        System.out.println(" n: " + n);
        System.out.println();

        this.funcion = funcion;
        double f0 = funcion.evaluar(x0);
        double deriv_fxo = 0;
        double previo = x0;

        int i = 1;

        System.out.println(
                this.redondear("N", 5, true)
                + this.redondear("Aprox. la raiz")
                + this.redondear("Error Relativo aprox."));

        System.out.println(
                this.redondear(i + "", 5, true)
                + this.redondear(x0)
                + this.redondear(""));

        while (i < n && Math.abs(f0) > e) {

            i++;
            if (derivada == null) {
                deriv_fxo = this.derivar(x0);
            } else {
                deriv_fxo = derivada.evaluar(x0);
            }


            x0 = x0 - f0 / deriv_fxo;
            f0 = funcion.evaluar(x0);



            System.out.println(
                    this.redondear(i + "", 5, true)
                    + this.redondear(x0)
                    + this.redondear(this.redondear(this.getErrorRelativoAproximado(x0, previo), this.decimales - 1) + "%"));

            previo = x0;
        }

        System.out.println("");
        if (Math.abs(f0) > e) {
            System.out.println("No hay convergencia, no hay solucion");
            return 0;
        } else {

            System.out.println("Solucion Estimada:" + this.redondear(x0));
            System.out.println("Valor de Comprobacion:" + this.redondear(f0));
            return x0;

        }



    }

    public void consola() {
        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        String funcion_derivada = consola.getCadena("Ingresa la Derivada");
        double X0 = consola.getNumero("Ingresa el Valor para X0");
        double error = consola.getNumero("Ingresa la Tolerancia");
        int limite = consola.getEntero("Ingresa el maximo de Iteraciones", 100);

        boolean fraccion = consola.getBoolean("¿Quieres usar Fraccciones?");
        int decimales = consola.getEntero("¿cuantos decimales queres usar para el reporte?", 6);
        int espaciado = consola.getEntero("cuanto espacio necesitas para el reporte", 12);

        this.fraccion = fraccion;
        this.decimales = decimales;
        this.espaciado = espaciado < this.espaciado ? this.espaciado : espaciado;


        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);

        if (funcion_derivada.equals("")) {
            this.evaluar(funcion, X0, error, limite);
        } else {
            Funcion derivada = new Funcion(funcion_derivada);
            this.evaluar(funcion, derivada, X0, error, limite);
        }

    }
}
