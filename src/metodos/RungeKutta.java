package metodos;

import consola.Consola;
import funcion.*;

/**
 * <p> El metodo Runge-Kutta es un algoritmo que aproxima soluciones de
 * ecuaciones diferenciales de primer orden. Se parte de un punto conocido de la
 * solucion de la ecuacion (x0,y0). Luego Runge-Kutta calcula de manera
 * iterativa los proximos puntos, donde la variable x tiene un incremento h.
 * </p> <p> Runge-Kutta puede ser calculado con distintos ordenes. Mientras
 * mayor es el orden, mas se aproximaran las soluciones a la solucion real. En
 * esta implementacion se utiliza el orden mas utilizado, Runge-Kutta de orden
 * 4. </p> <p>
 *
 * Los puntos solucion de la ecuacion estan dados por:
 *
 * </p> <b> y(x+h) = y(x) + (1/6) * (F1+2*F2+2*F3+F4) </b>
 *
 * <p> Donde: </p>
 *
 * F1 = h * f(x,y) <br> <br> F2 = h * f(x+(1/2)*h, y+(1/2)*F1) <br> <br> F3 = h
 * * f(x+(1/2)*h, y+(1/2)*F2) <br> <br> F4 = h * f(x+h, y+F3) <br> <p> Se puede
 * observar que el valor y(x+h) se calcula usando el valor anterior y(x) y
 * sumandole el incremento h multiplicado por una pendiente estimada. La
 * pendiente (F1+2*F2+2*F3+F4) es un promedio ponderado de pendientes: - F1 es
 * la pendiente al principio del intervalo <br> - F2 es la pendiente en el punto
 * medio del intervalo <br> - F3 es otra vez la pendiente del punto medio, pero
 * ahora usando F2 para determinar el valor de y <br> - F4 es la pendiente al
 * final del <br> intervalo, con el valor de y determinado por F3 </p> El error
 * por paso es del orden de O(h5), mientras que el error total acumulado tiene
 * el orden O(h4).
 */
public class RungeKutta extends Base {

    public RungeKutta() {
        this.espaciado = 0;
        this.decimales = 5;
    }

    /**
     * El metodo orden4 encuentra la solucion de la ecuacion diferencial en un
     * punto.
     *
     * @param funcion funcion de la ecuacion diferencial
     * @param x0 valor en x anterior
     * @param y0 valor en y anterior
     * @param h incremento
     * @return valor de la ecuacion en el punto (y(x+h))
     */
    public double orden4(Funcion funcion, double x0, double y0, double h) {
        double F1 = funcion.evaluar(x0, y0);
        double F2 = funcion.evaluar(x0 + 0.5 * h, y0 + 0.5 * h * F1);
        double F3 = funcion.evaluar(x0 + 0.5 * h, y0 + 0.5 * h * F2);
        double F4 = funcion.evaluar(x0 + h, y0 + h * F3);
        //System.out.println(+F1);
        //System.out.println(+F2);
        //System.out.println(+F3);
        //System.out.println(+F4);

        System.out.println("" + this.redondear(y0) + " + (" + this.redondear(h) + " * (" + this.redondear(F1) + " + 2 * (" + this.redondear(F2) + " + " + this.redondear(F3) + ") + " + this.redondear(F4) + ")) / 6 = " + this.redondear(y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6));
        return y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6.0;
    }

    /**
     * El metodo evaluar guarda en una tabla los puntos solucion de la
     * ecuacion.
     *
     * @param funcion funcion de la ecuacion diferencial
     * @param x0 valor x inicial
     * @param y0 valor y inicial
     * @param xn valor x final
     * @param n cantidad de iteraciones
     * @return tabla con los valores de la funcion
     */
    public double[] evaluar(Funcion funcion, double x0, double y0, double xn, int n) {

        System.out.println("x0: " + x0);
        System.out.println("y0: " + y0);
        System.out.println("xn: " + xn);
        System.out.println(" n: " + n);
        System.out.println();

        double[] Y = new double[n + 1];
        double[] X = new double[n + 1];

        this.inicializar(X, x0);
        double h = (xn - x0) / n;
        Y[0] = y0;
        for (int i = 0; i < n; i++) {
            System.out.println("I=" + i);
            y0 = this.orden4(funcion, x0, y0, h);
            x0 += h;            x0 += h;

            X[i + 1] = x0;
            Y[i + 1] = y0;
        }

        System.out.println("");
        System.out.println("Resultado:");
        this.reportarcoordenadas(X, Y);



        return Y;
    }

    public void consola() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double x0 = consola.getNumero("Ingresa el Valor inicial de X");
        double y0 = consola.getNumero("Ingresa el Valor inicial de Y");
        double xn = consola.getNumero("Ingresa el Valor final de X");
        int n = consola.getEntero("Ingresa el Numero de Iteraciones", 4);


        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 6);

        this.fraccion = fraccion;
        this.decimales = decimales;

        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, x0, y0, xn, n);

    }
}
