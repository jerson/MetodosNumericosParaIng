package metodos;

import consola.Consola;
import funcion.*;
import org.apache.commons.math3.fraction.*;

public class GaussSeidel extends Gauss {

    public double[][] evaluar(double[][] matriz, double error, int limite) {

        System.out.println("e: " + error);
        System.out.println("n: " + limite);
        System.out.println();

        boolean ok = false;
        double[][] matriz_original = this.clonar(matriz);
        int n = matriz.length;

        double[] Xa = new double[n];
        double[] Xp = new double[n];
        Xp = this.inicializar(Xp);
        Xa = this.inicializar(Xa);



        System.out.println("--------------------------------------------------");
        System.out.println("-----------------METODO DE GAUSS-SEIDEL-----------");
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

                System.out.println("X" + i + "=(M" + i + "" + n + "-s)/A" + i + "" + i + " = (" + this.redondear(matriz[i][n]) + "-" + this.redondear(s) + ")/" + this.redondear(matriz[i][i]) + "=" + this.redondear((matriz[i][n] - s) / matriz[i][i]));
                Xa[i] = (matriz[i][n] - s) / matriz[i][i];

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

    public double[][] criterioConvergencia(double[][] matriz) {

        int n = matriz.length;

        double[] num_mayor = new double[n];
        double[] pos_mayor = new double[n];
        double[] sum_mayor = new double[n];
        double[] aux = new double[n];
        /*
        for (int i = 0; i<n; i++){

        for (int j = 0; j<n; j++){


        if(Math.abs(matriz[i][j])>Math.abs(num_mayor[i])){
        num_mayor[i]=matriz[i][j];
        //	sum_mayor[i]-=matriz[i][j];
        pos_mayor[i]=j;
        }else{

        //	sum_mayor[i]+=matriz[i][j];
        }
        }
        }*/

        /*

        for (int j = 0; j<=n; j++){
        aux[j]=matriz[(int) pos_mayor[j]];
        }

        for (int j = 0; j<=n; j++){
        matriz[fila]=aux[j];
        }

         */


        return matriz;

    }

    public double[] actualizarX(double[] Xa, double[] Xp) {
        int n = Xa.length;
        for (int i = 0; i < n; i++) {
            Xp[i] = Xa[i];
        }

        return Xp;

    }

    public boolean verificarTolerancia(double[] Xa, double[] Xp, double error) {

        int n = Xa.length;
        int correcto = 0;
        double tmp = 0;

        System.out.print("Errores:");



        System.out.print("[");
        for (int i = 0; i < n; i++) {
            tmp = (Math.abs(Xa[i] - Xp[i])) / Math.abs(Xa[i]);
            System.out.print(this.redondear(this.redondear(tmp * 100) + "%", this.decimales + 4, false) + (i < (n - 1) ? ", " : ""));

            /* 	System.out.println("");
            System.out.println(tmp+"<="+error);
            System.out.println("");*/
            if (Math.abs(tmp) <= Math.abs(error)) {
                correcto++;

            }


        }
        System.out.println("]");

        //System.out.println(correcto+"=="+n);
        if (correcto == n) {
            return true;
        } else {
            return false;
        }


    }

    public double[] inicializar(double[] n) {
        return this.inicializar(n, 0);
    }

    public double[] inicializar(double[] n, double defecto) {

        for (int i = 0; i < n.length; i++) {
            n[i] = defecto;
        }
        return n;
    }

    public void consola() {

        Consola consola = new Consola();


        int cantidad = consola.getEntero("Ingresa el Numero de Ecuaciones", 3);
        double[][] matriz = consola.getMatriz(cantidad + 1, cantidad);


        double error = consola.getNumero("Ingresa la Tolerancia");
        int limite = consola.getEntero("Ingresa el maximo de Iteraciones", 100);

        boolean fraccion = consola.getBoolean("¿Quieres usar Fraccciones?");
        int decimales = consola.getEntero("¿cuantos decimales queres usar para el reporte?", 4);

        consola.limpiarPantalla();

        this.espaciado = 0;
        this.fraccion = fraccion;
        this.decimales = decimales;
        this.evaluar(matriz, error, limite);

    }
}
