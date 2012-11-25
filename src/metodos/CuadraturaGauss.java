package metodos;

import consola.Consola;
import funcion.*;
import java.util.ArrayList;

public class CuadraturaGauss extends Base {

    public CuadraturaGauss() {
        this.espaciado = 0;
        this.decimales = 10;
    }

    public double evaluar(Funcion funcion, double a, double b, int n) {

        double resultado = 0;

        double x1[] = {0};
        double x2[] = {-0.57735026, 0.57735026};
        double x3[] = {-0.7745966, 0, 0.7745966};
        double x4[] = {-0.861136311, -0.33998104, 0.33998104, 0.861136311};
        double x5[] = {-0.90617984, -0.53846931, 0, 0.53846931, 0.90617984};
        ArrayList<double[]> x = new ArrayList<>();
        x.add(x1);
        x.add(x2);
        x.add(x3);
        x.add(x4);
        x.add(x5);
        double w1[] = {2};
        double w2[] = {1, 1};
        double w3[] = {0.55555, 0.88888, 0.55555};
        double w4[] = {0.3478548451, 0.6521451549, 0.6521451549, 0.3478548451};
        double w5[] = {0.23692688509, 0.4786286705, 0.56888888, 0.4786286705, 0.23692688509};
        ArrayList<double[]> w = new ArrayList<>();
        w.add(w1);
        w.add(w2);
        w.add(w3);
        w.add(w4);
        w.add(w5);

        for (int i = 0; i < n; i++) {
            resultado += w.get(n)[i] * funcion.evaluar(x.get(n)[i] * (b - a) / 2 + (b + a) / 2);
        }
        resultado *= (b - a) / 2;


        System.out.println("");
        System.out.println("Resultado:");
        System.out.println(this.redondear(resultado));
        
        return resultado;

    }

    public void consola() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double a = consola.getNumero("Ingresa el Intervalo 1");
        double b = consola.getNumero("Ingresa el Intervalo 2");
        int n = consola.getEntero("Ingresa el Numero de Puntos", 4);


        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 6);

        this.fraccion = fraccion;
        this.decimales = decimales;

        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, a, b, n);

    }
}
