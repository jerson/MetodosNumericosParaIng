package metodos;

import consola.Consola;
import funcion.*;

public class Lagrange extends Base {

    public Lagrange() {
        this.espaciado = 0;
        this.decimales = 10;
    }

    public double evaluar(double[] xi, double[] fxi, double x) {

        int n = xi.length;




        double[] Lxi = new double[n];
        double Pnx = 0;




        System.out.println("--------------------------------------------------");
        System.out.println("------------Interpolacion de Lagrange-------------");
        System.out.println("--------------------------------------------------");
        
        this.reportarcoordenadas(xi, fxi);

        System.out.println("X = "+x);
        System.out.println("");

        System.out.println("Y(x)=[");
        for (int i = 0; i < n; i++) {

            System.out.print(this.redondear(fxi[i]));
            System.out.print(" * ");
            Lxi[i] = this.Lagrangeix(x, i, xi, n);

            Pnx = Pnx + Lxi[i] * fxi[i];

            System.out.println("");

        }

        System.out.println("]");
        System.out.println("");
        System.out.println("Resultado:");
        System.out.println("Pnx=" + this.redondear(Pnx));

        return Pnx;

    }

    public double Lagrangeix(double x, int i, double[] xi, int n) {

        double Prod;

        Prod = 1;

        for (int j = 0; j < n; j++) {

            if (i != j) {
              
                System.out.print("((x-" + this.redondear(xi[j]) + ")/(" + this.redondear(xi[i]) + " - " + this.redondear(xi[j]) + "))");
                Prod = Prod * ((x - xi[j]) / (xi[i] - xi[j]));

                if (j == (n - 1)) {

                    System.out.print(" + ");
                }

            }

           


        }

        return Prod;
    }
    
    public void consola() {

        Consola consola = new Consola();


        int cantidad = consola.getEntero("Ingresa la Cantidad", 3);
        double[][] coordenadas = consola.getCoordenadas(cantidad);

        double numero = consola.getNumero("Ingresa el Valor de X");

        consola.limpiarPantalla();

        this.evaluar(coordenadas[0], coordenadas[1], numero);

    }
}
