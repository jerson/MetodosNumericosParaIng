package metodos;

import consola.Consola;
import funcion.*;

public class Neville extends Newton {

    public Neville() {
        this.espaciado = 0;
        this.decimales = 10;
    }

    public double evaluar(double[] xi, double[] fxi, double x) {

        int n = xi.length - 1;
       
        double[][] f = new double[n+1][n+1];
        double resultado = 0;


        for (int i = 0; i < f.length; i++) {
            f[i][0] = fxi[i];
        }


        System.out.println("--------------------------------------------------");
        System.out.println("------------Interpolacion de Neville-------------");
        System.out.println("--------------------------------------------------");

        this.reportarcoordenadas(xi, fxi);

        System.out.println("x = " + x);
        System.out.println("");

        for (int k = 1; k <= n; k++) {

            System.out.println("--------");
            System.out.println("K=" + k);
            System.out.println("--------");
            
            for (int i = 0; i < ((n+1) - k); i++) {

                System.out.println("f["+i+"]["+k+"] = "+(((x - xi[i + k]) * f[i][k - 1] - (x-xi[i]) * f[i+1][k-1]) / (xi[i]-xi[i+k])));
                f[i][k] = ((x - xi[i + k]) * f[i][k - 1] - (x-xi[i]) * f[i+1][k-1]) / (xi[i]-xi[i+k]);

            }
            

        }

      
        

        System.out.println("------------------------------------------------------------");
        
        
        this.reportarmatriz(f,xi,fxi);
        System.out.println("Resultado:");
        System.out.println("Pnx=" + this.redondear(f[0][n]));




        return resultado;

    }

    public void consola() {

        super.consola();

    }
}
