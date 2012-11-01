package metodos;

import consola.Consola;
import funcion.*;

public class GaussJacobi extends GaussSeidel {

	   public double[][] evaluar(double[][] matriz, double error, int limite) {

        System.out.println("e: " + error);
        System.out.println("n: " + limite);
        System.out.println();

        boolean ok = false;
        double[][] matriz_original = this.clonar(matriz);
        int n = matriz.length;

        double[] Xa = new double[n];
        double[] Xp = new double[n];
        double[] Xt = new double[n];
        Xp = this.inicializar(Xp);
        Xa = this.inicializar(Xa);
        Xt = this.inicializar(Xt);



        System.out.println("--------------------------------------------------");
        System.out.println("-----------------METODO DE GAUSS-JACOBI-----------");
        System.out.println("--------------------------------------------------");

        //	this.criterioConvergencia(matriz);
        this.reportarmatriz(matriz);
        for (int k = 0; k < limite; k++) {

            System.out.println("--------");
            System.out.println("I=" + k);
            System.out.println("--------");

            for (int i = 0; i < n; i++) {


                double s = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        s = s + matriz[i][j] * Xa[j];
                    }
                }

                System.out.println("Xt" + i + "=(M" + i + "" + n + "-s)/A" + i + "" + i + " = (" + this.redondear(matriz[i][n]) + "-" + this.redondear(s) + ")/" + this.redondear(matriz[i][i]) + "=" + this.redondear((matriz[i][n] - s) / matriz[i][i]));
                Xt[i] = (matriz[i][n] - s) / matriz[i][i];

            }



            Xa = this.actualizarX(Xt, Xa);
            System.out.println("");

            System.out.print("Resultados Xa:");
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                System.out.print(this.redondear(Xa[i], this.decimales + 4, false) + (i < (n - 1) ? ", " : ""));
            }
            System.out.println("]");


            System.out.print("Resultados Xp:");
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                System.out.print(this.redondear(Xp[i], this.decimales + 4, false) + (i < (n - 1) ? ", " : ""));
            }
            System.out.println("]");


            //	if(k>0){

            ok = verificarTolerancia(Xa, Xp, error);

            if (ok) {
                break;
            }


            Xp = this.actualizarX(Xa, Xp);


            System.out.println("");
            System.out.println("-----------------------------------");
            System.out.println("");

            //	}





        }




        if (!ok) {
            System.out.println("No se Encontro la Solucion");
        } else {

            this.comprobar(Xa, matriz_original);
        }


        return matriz;
    }


/*
    public double[][] evaluar(double[][] matriz, double error, int limite) {

        System.out.println("e: " + error);
        System.out.println("n: " + limite);
        System.out.println();

        boolean ok = false;
        double[][] matriz_original = this.clonar(matriz);
        int n = matriz.length;
        double s = 0;
        int c = 0;
        double[] Xa = new double[n];
        double[] Xp = new double[n];
        double[] Xt = new double[n];
        Xa = this.inicializar(Xa);
        Xp = this.inicializar(Xp);
        //Xt = this.inicializar(Xt);

        System.out.println("--------------------------------------------------");
        System.out.println("-----------------METODO DE GAUSS-JACOBI-----------");
        System.out.println("--------------------------------------------------");


        for (int k = 0; k < limite; k++) {

            System.out.println("--------");
            System.out.println("I=" + k);
            System.out.println("--------");

            for (int i = 0; i < n; i++) {


                Xa[i] = matriz[i][n - 1];

                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        Xa[i] = Xa[i] - matriz[i][j] * Xp[j];
                    }
                }

                Xa[i] = Xa[i] / matriz[i][i];




            }
            System.out.println("");

            System.out.print("Resultados Xa:");
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                System.out.print(this.redondear(Xa[i], this.decimales + 4, false) + (i < (n - 1) ? ", " : ""));
            }
            System.out.println("]");


            System.out.print("Resultados Xp:");
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                System.out.print(this.redondear(Xp[i], this.decimales + 4, false) + (i < (n - 1) ? ", " : ""));
            }
            System.out.println("]");




            //	if(k>0){

            ok = verificarTolerancia(Xa, Xp, error);

            if (ok) {
                break;
            }

            Xp = actualizarX(Xa, Xp);
            //	}
        }

        if (!ok) {
            System.out.println("No se Encontro la Solucion");
        } else {

            this.comprobar(Xa, matriz_original);
        }


        return matriz;
    }
*/
    public void consola() {

        super.consola();

    }
}
