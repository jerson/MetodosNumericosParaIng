package metodos;

import consola.Consola;
import funcion.*;
import org.apache.commons.math3.fraction.*;

public class GaussJordan extends Gauss {

    public double[][] evaluar(double[][] matriz, boolean pivoteo_parcial) {

        double[][] matriz_original = this.clonar(matriz);
       	matriz = super.evaluar(matriz,pivoteo_parcial);


        int n = matriz.length;
        double alpha = 0;
        double[] x = new double[n];

        System.out.println("--------------------------------------------------");
        System.out.println("-----------------METODO DE GAUSS-JORDAN-----------");
        System.out.println("--------------------------------------------------");


        System.out.println("MATRIZ INICIAL:");
        this.reportarmatriz(matriz);
        System.out.println("");

        for (int k = 1; k < n; k++) {
            if (pivoteo_parcial) {
                matriz = this.pivoteoParcial(matriz, k);

            }

            System.out.println("---------------");
            System.out.println("I=" + k);
            System.out.println("---------------");

            for (int i = 0; i < n; i++) {

                if (i != k && matriz[i][k] != 0) {

                    alpha = matriz[i][k] / matriz[k][k];
                    System.out.println("alpha= " + this.redondear(matriz[i][k]) + " / " + this.redondear(matriz[k][k]) + " = " + this.redondear(alpha));
                    for (int j = k; j <= n; j++) {
                        System.out.println("A" + i + "" + j + "=A" + i + "" + j + "-alpha*A" + k + "" + j + " => " + this.redondear(matriz[i][j] - alpha * matriz[k][j]) + " = " + this.redondear(matriz[i][j]) + " - " + this.redondear(alpha) + " * " + this.redondear(matriz[k][j]) + "");
                        matriz[i][j] = matriz[i][j] - alpha * matriz[k][j];

                    }


                    this.reportarmatriz(matriz);
                }



            }

        }

        System.out.println("");
        System.out.println("Dividiendo sobre el PIVOT");

        for (int i = 0; i < n; i++) {
            matriz[i][n] = matriz[i][n] / matriz[i][i];
            x[i] = matriz[i][n];
            matriz[i][i] = 1;


        }

        this.reportarmatriz(matriz);


        this.comprobar(x,matriz_original);

        return matriz;
    }

     public void consola() {

        super.consola();

    }
}
