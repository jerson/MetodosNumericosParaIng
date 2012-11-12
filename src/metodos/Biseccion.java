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
public class Biseccion extends Base {

    public double evaluar(Funcion funcion, double xa, double xb, double e) {

        System.out.println("Xa: "+xa);
        System.out.println("Xb: "+xb);
        System.out.println(" e: "+e);
        System.out.println();

        this.funcion = funcion;
        double fb = funcion.evaluar(xb);
        double xm = 0;
        double x = 0;
        double f = 0;
        double previo = 0;
        int i = 0;

        System.out.println(
                this.redondear("N", 5, true)
                + this.redondear("a")
                + this.redondear("b")
                + this.redondear("c")
                + this.redondear("f(a)")
                + this.redondear("f(b)")
                + this.redondear("f(c)")
                + this.redondear("E"));


        do {
            i++;
            xm = (xa + xb) / 2;
            double tmpxa, tmpxb;
            tmpxa = xa;
            tmpxb = xb;

            if ((fb * funcion.evaluar(xm)) > 0) {
                xb = xm;
            } else {
                xa = xm;
            }


            System.out.println(
                    this.redondear(i + "", 5, true)
                    + this.redondear(tmpxa)
                    + this.redondear(xm)
                    + this.redondear(tmpxb)
                    + this.redondear(funcion.evaluar(tmpxa))
                    + this.redondear(funcion.evaluar(xm))
                    + this.redondear(funcion.evaluar(tmpxb))
                    + this.redondear(this.getErrorAproximado(xm, previo)));


            previo = xm;
        } while (Math.abs(xb - xa) > Math.abs(e));


        System.out.println(" ");

        x = this.getInterpolacion(xa, xb);

        System.out.println("Solucion Estimada:" + this.redondear(x));
        System.out.println("Valor de Comprobacion:" + this.redondear(funcion.evaluar(x)));

        return x;



    }

    public void consola() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double Xa = consola.getNumero("Ingresa el Valor para Xa");
        double Xb = consola.getNumero("Ingresa el Valor para Xb");
        double error = consola.getNumero("Ingresa la Tolerancia");
        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 6);
        int espaciado = consola.getEntero("cuanto espacio necesitas para el reporte", 12);

        this.fraccion = fraccion;
        this.decimales = decimales;
        this.espaciado = espaciado < this.espaciado ? this.espaciado : espaciado;

        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, Xa, Xb, error);
    }
}
