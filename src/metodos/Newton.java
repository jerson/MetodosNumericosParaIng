package metodos;

import consola.Consola;
import funcion.*;

public class Newton extends Lagrange {

    public Newton() {
        this.espaciado = 0;
        this.decimales = 10;
    }

   
    public double evaluar(double[] xi, double[] fxi, double x) {

        int n = xi.length - 1;
        double[][] T = new double[n][n];
        double resultado = 0;





        System.out.println("--------------------------------------------------");
        System.out.println("------------Interpolacion de Newton-------------");
        System.out.println("--------------------------------------------------");

        this.reportarcoordenadas(xi, fxi);

        System.out.println("X = " + x);
        System.out.println("");

        for (int i = 0; i < n; i++) {

            T[i][0] = (fxi[i + 1] - fxi[i]) / (xi[i + 1] - xi[i]);

        }

        for (int j = 1; j < n; j++) {

            for (int i = j; i < n; i++) {

                T[i][j] = (T[i][j - 1] - T[i - 1][j - 1]) / (xi[i + 1] - xi[i - 1]);

            }

        }



        System.out.println("Y(x)=[");
        System.out.print(this.redondear(fxi[0]));
        resultado += fxi[0];
        System.out.print(" + ");
        System.out.println("");
        for (int i = 0; i < T[0].length; i++) {

            double parte = 1;
            parte *= T[i][i];

            System.out.print(this.redondear(T[i][i]));
            System.out.print(" * ");

            for (int j = 0; j <= i; j++) {

                System.out.print("( x - " + xi[j] + " )");
                parte *= (x - xi[j]);
            }

            if (i != (n - 1)) {

                System.out.print(" + ");
            }
            System.out.println("");


            resultado += parte;

        }

        System.out.println("]");
        System.out.println("");
        this.reportarmatriz(T);
        System.out.println("Resultado:");
        System.out.println("Pnx=" + this.redondear(resultado));




        return resultado;

    }

    public void consola() {

        super.consola();

    }
}
