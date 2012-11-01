/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import consola.Consola;
import funcion.*;
import org.apache.commons.math3.fraction.*;

/**
 *
 * @author Gerson
 */
public class Gauss extends Base {

    public Gauss() {
        this.espaciado = 0;
    }

    public double[][] evaluar(double[][] matriz, boolean pivoteo_parcial) {


        this.reportarmatriz(matriz);

        int n = matriz.length;
        double[] x = new double[n];
        double[][] matriz_original = this.clonar(matriz);
        double cte = 0;
        double suma = 0;

        System.out.println("--------------------------------------------------");
        System.out.println("-----------------METODO DE GAUSS------------------");
        System.out.println("--------------------------------------------------");


        for (int i = 0; i < n - 1; i++) {
            if (pivoteo_parcial) {
                matriz = this.pivoteoParcial(matriz, i);
            }

            System.out.println("--------");
            System.out.println("I=" + i);
            System.out.println("--------");

            for (int j = i + 1; j < n; j++) {
                cte = matriz[j][i] / matriz[i][i];
                System.out.println("alpha= " + this.redondear(matriz[j][i]) + " / " + this.redondear(matriz[i][i]) + " = " + this.redondear(cte));
                System.out.println("");
                for (int k = 0; k <= n; k++) {

                    matriz[j][k] = matriz[j][k] - matriz[i][k] * cte;
                    System.out.print("A" + j + "" + k + "=A" + j + "" + k + "-alpha*A" + i + "" + k + " => ");
                    System.out.println(this.redondear(matriz[j][k]) + " = " + this.redondear(matriz[j][k]) + " - " + this.redondear(matriz[i][k]) + " * " + this.redondear(cte));
                }

                System.out.println("");
            }


            this.reportarmatriz(matriz);

            System.out.println("--------------------------------------------------");
            System.out.println("");
            System.out.println("");
        }

        if (matriz[n - 1][n - 1] == 0) {
            System.out.println("No se puede seguir con el metodo ya que el coeficiente de la incognita Xn es 0");
            return matriz;
        } else {


            System.out.println("Calculando Xi");
            x[n - 1] = matriz[n - 1][n] / matriz[n - 1][n - 1];

            System.out.println("X" + (n - 1) + "= (" + this.redondear(matriz[n - 1][n]) + ") / (" + this.redondear(matriz[n - 1][n - 1]) + ") =" + this.redondear(x[n - 1]));


            for (int i = (n - 2); i >= 0; i--) {
                suma = 0;
                String cadena_suma = "";
                for (int j = 0; j < n; j++) {
                    suma += matriz[i][j] * x[j];
                    cadena_suma += "(" + this.redondear(matriz[i][j]) + ")*(" + this.redondear(x[j]) + ")";

                    if ((n - 1) == j) {
                    } else {
                        cadena_suma += " + ";
                    }
                }

                x[i] = (matriz[i][n] - suma) / matriz[i][i];



                System.out.println("X" + i + "= (" + this.redondear(matriz[i][n]) + ") - [" + cadena_suma + "] / (" + this.redondear(matriz[i][i]) + ") = " + this.redondear(x[i]));
            }


            this.comprobar(x,matriz_original);
        }

        return matriz;
    }

	public void comprobar(double[] x, double[][] matriz_original){


            System.out.println("");
            System.out.println("Resultados:");
            int n = matriz_original.length;
            for (int i = 0; i < n; i++) {

                System.out.println("X" + i + "=" + this.redondear(x[i]));
            }


            System.out.println("");
            System.out.println("Comprobandolo:");


            this.reportarmatriz(matriz_original);
            for (int i = 0; i < n; i++) {
                double resultado = 0;
                for (int j = 0; j < n; j++) {

                    resultado += matriz_original[i][j] * x[j];
                    System.out.print(this.redondear(matriz_original[i][j]) + "(" + this.redondear(x[j]) + ")");
                    if ((n - 1) == j) {
                    } else {
                        System.out.print("+");
                    }
                }


                System.out.println("=" + this.redondear(resultado));
            }

	}
    public double[][] pivoteoParcial(double[][] matriz, int fila) {
        double mayor = 0;
        int fila_mayor = 0;
        int n = matriz.length;
        double[] aux = new double[n + 1];

        for (int i = 0; i < n; i++) {

            if (Math.abs(matriz[i][fila]) > mayor) {
                mayor = Math.abs(matriz[i][fila]);
                fila_mayor = i;
            }

        }

        for (int j = 0; j <= n; j++) {
            aux[j] = matriz[fila][j];
        }

        for (int j = 0; j <= n; j++) {
            matriz[fila][j] = matriz[fila_mayor][j];
        }

        for (int j = 0; j <= n; j++) {
            matriz[fila_mayor][j] = aux[j];
        }




        return matriz;
    }

    public void consola() {

        Consola consola = new Consola();


        int cantidad = consola.getEntero("Ingresa el Numero de Ecuaciones",3);
        double[][] matriz = consola.getMatriz(cantidad + 1, cantidad);

        boolean pivoteo = consola.getBoolean("Quieres usar Pivoteo Parcial?");
        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 4);

        consola.limpiarPantalla();

        this.espaciado = 0;
        this.fraccion = fraccion;
        this.decimales = decimales;
        this.evaluar(matriz, pivoteo);

    }
}
