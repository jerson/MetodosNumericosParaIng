package metodos;

import consola.Consola;
import funcion.*;

public class Euler extends Base {

    public Euler() {
        this.espaciado = 0;
        this.decimales = 5;
    }

    public double evaluar(Funcion funcion, double x0, double x1, double y, int n) {
        //String funcion = "2*x*y";
        //Funcion fun = new Funcion();
        double resultado = 0;
        double f, h;
        double X[] = new double[n + 1];
        double Y[] = new double[n + 1];
        h = (x1 - x0) / n;
        X[0] = x0;
        Y[0] = y;
        for (int i = 0; i < n; i++) {
            f = funcion.evaluar(X[i], Y[i]);
            Y[i + 1] = Y[i] + (h * f);
            X[i + 1] = h * (i + 1);
        }
        
        resultado = Y[n];
        
        this.reportarcoordenadas(X, Y);
        
        
        System.out.println("");
        System.out.println("Resultado:");
        System.out.println(this.redondear(resultado));

        return resultado;
    }

    public void consola() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double a = consola.getNumero("Ingresa el Valor para a");
        double b = consola.getNumero("Ingresa el Valor para b");
        double y = consola.getNumero("Ingresa el Valor para y");
        int n = consola.getEntero("Ingresa el Numero de Niveles", 4);


        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 6);

        this.fraccion = fraccion;
        this.decimales = decimales;

        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, a, b, y, n);

    }
}
