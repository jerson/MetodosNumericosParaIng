package metodos;

import consola.Consola;
import funcion.*;

public class Euler extends Base {

    public Euler() {
        this.espaciado = 0;
        this.decimales = 5;
    }

    public double evaluar(Funcion funcion, double x0, double x1, double y, int n) {

        System.out.println("x0: " + x0);
        System.out.println("x1: " + x1);
        System.out.println(" y: " + y);
        System.out.println(" n: " + n);
        System.out.println();

        double resultado = 0;
        double f, h;
        double X[] = new double[n + 1];
        double Y[] = new double[n + 1];
        h = (x1 - x0) / n;

        System.out.println("h: " + h);
        X[0] = x0;
        System.out.println("Y" + 0 + ": " + Y[0]);
        Y[0] = y;
        System.out.println("X" + 0 + ": " + Y[0]);
        System.out.println("---------------------------------");
        for (int i = 0; i < n; i++) {
            f = funcion.evaluar(X[i], Y[i]);
            System.out.println("f x" + (i) + "y" + (i) + " : " + f);
            Y[i + 1] = Y[i] + (h * f);
            System.out.println("Y" + (i + 1) + ": " + Y[i + 1]);
            X[i + 1] = X[i] + h;
            System.out.println("X" + (i + 1) + ": " + X[i + 1]);
            System.out.println("---------------------------------");
        }
        resultado = Y[n];

        this.reportarcoordenadas(X, Y);


        System.out.println("");
        System.out.println("Resultado:");
        System.out.println(this.redondear(resultado));

        return resultado;
    }

    public void consola() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double a = consola.getNumero("Ingresa el Valor para a");
        double b = consola.getNumero("Ingresa el Valor para b");
        double y = consola.getNumero("Ingresa el Valor para y");
        int n = consola.getEntero("Ingresa el Numero de Iteraciones", 4);


        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 6);

        this.fraccion = fraccion;
        this.decimales = decimales;

        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, a, b, y, n);

    }
}
