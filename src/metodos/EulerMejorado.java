package metodos;

import consola.Consola;
import funcion.*;

public class EulerMejorado extends Euler {

    public EulerMejorado() {
        this.espaciado = 0;
        this.decimales = 5;
    }

    public double evaluar(Funcion funcion, double x0, double x1, double y, int n) {

        double resultado = 0;
        double x, h, f1, f2;
        double X[] = new double[n + 1];
        double Y[] = new double[n + 1];
        h = (x1 - x0) / n;
        System.out.println("valores : \n x0 : " + x0 + ", x1: " + x1 + ", y1: " + y + ", numero de interaccione :" + n);
     
        System.out.println("el valor de h : " + h);
        X[0] = x0;
        System.out.println("Valor de Y" + 0 + ": " + Y[0]);
        Y[0] = y;
        System.out.println("Valor de X" + 0 + ": " + Y[0] + "\n------------------\n");
        for (int i = 0; i < n; i++) {
            X[i + 1] = X[i] + h;
            f1 = funcion.evaluar(X[i], Y[i]);
            double yaux = Y[i] + h * X[i];
            f2 = funcion.evaluar(X[i + 1], yaux);
            Y[i + 1] = Y[i] + (h * ((f1 + f2) / 2));
            System.out.println("el valor de X" + (i + 1) + " : " + X[i + 1]);
            System.out.println("el valor de Y*" + (i + 1) + " : " + yaux);
            System.out.println("el valor de la funcio X" + i + "Y" + i + " : " + f1);
            System.out.println("el valor de la funcio X" + (i + 1) + "Y" + (i + 1) + " : " + f2);
            System.out.println("el valor de X" + (i + 1) + " : " + Y[i + 1] + "\n------------------\n");
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
