package metodos;

import consola.Consola;
import funcion.*;

public class EulerMejorado extends Euler {

    public EulerMejorado() {
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
        double x, h, f1, f2;
        double X[] = new double[n + 1];
        double Y[] = new double[n + 1];
        h = (x1 - x0) / n;

        System.out.println("h : " + h);
        X[0] = x0;
        System.out.println("Y" + 0 + ": " + Y[0]);
        Y[0] = y;
        System.out.println("X" + 0 + ": " + Y[0]);
        System.out.println("---------------------------------");
        for (int i = 0; i < n; i++) {
            X[i + 1] = X[i] + h;
            f1 = funcion.evaluar(X[i], Y[i]);
            double yaux = Y[i] + h * X[i];
            f2 = funcion.evaluar(X[i + 1], yaux);
            Y[i + 1] = Y[i] + (h * ((f1 + f2) / 2));
            System.out.println("X" + (i + 1) + " : " + X[i + 1]);
            System.out.println("Y*" + (i + 1) + " : " + yaux);
            System.out.println("funcion X" + i + "Y" + i + " : " + f1);
            System.out.println("funcion X" + (i + 1) + "Y" + (i + 1) + " : " + f2);
            System.out.println("X" + (i + 1) + " : " + Y[i + 1]);
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

        super.consola();

    }
}
