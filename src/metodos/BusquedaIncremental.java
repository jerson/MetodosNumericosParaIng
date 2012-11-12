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
public class BusquedaIncremental extends Base {

    public double evaluar(Funcion funcion, double x0, double h) {
        return this.evaluar(funcion, x0, h, 100);
    }

    public double evaluar(Funcion funcion, double x0, double h, int n) {

        System.out.println("X0: "+x0);
        System.out.println(" h: "+h);
        System.out.println(" n: "+n);
        System.out.println();

        this.funcion = funcion;
        double f0 = funcion.evaluar(x0);
        int i = 0;
        double P = 0;
        double fx;
        double x = 0;
        double f;


        System.out.println(
                this.redondear("N", 5, true)
                + this.redondear("Xi")
                + this.redondear("f(Xi)")
                + this.redondear("f0 * f(Xi)"));

        do {

            i++;
            x = x0 + (i * h);
            fx = funcion.evaluar(x);

            P = f0 * fx;

            System.out.println(
                    this.redondear(i + "", 5, true)
                    + this.redondear(x)
                    + this.redondear(fx)
                    + this.redondear(P));

        } while (i <= n && P > 0);


        System.out.println("");
        if (P > 0) {
            System.out.println("Solucion no Encontrada");
            return 0;
        } else {
            x = this.getInterpolacion(x, h);


            System.out.println("Solucion Estimada:" + this.redondear(x));
            System.out.println("Valor de Comprobacion:" + this.redondear(funcion.evaluar(x)));
            return x;
        }
    }

    @Override
    protected double getInterpolacion(double x, double h) {

        double interpolacion = 0;
        double fx = funcion.evaluar(x);
        double fxh = funcion.evaluar(x - h);

        interpolacion = x - ((h) * (fx)) / (fx - fxh);
        return interpolacion;


    }

    public void consola() {
        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double X0 = consola.getNumero("Ingresa el Valor para X0");
        double incremento = consola.getNumero("Ingresa el Valor del incremento");
        int limite = consola.getEntero("Ingresa el maximo de Iteraciones", 100);
        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 6);
        int espaciado = consola.getEntero("cuanto espacio necesitas para el reporte", 12);

        this.fraccion = fraccion;
        this.decimales = decimales;
        this.espaciado = espaciado < this.espaciado ? this.espaciado : espaciado;

        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, X0, incremento, limite);
    }
}
