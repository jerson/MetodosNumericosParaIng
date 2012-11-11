package metodos;

import consola.Consola;
import funcion.*;

public class Trapecio extends Base {

    public Trapecio() {
        this.espaciado = 0;
        this.decimales = 10;
    }

    public double evaluar(Funcion funcion, double a, double b) {


       // System.out.println("((b - a) / 2) * (f(a) + f(b))");
       
        double resultado = ((b - a) / 2) * (funcion.evaluar(a) + funcion.evaluar(b));
        //System.out.println("(("+this.redondear(b) +" - "+this.redondear(a)+") / 2) * ("+this.redondear(funcion.evaluar(a))+" + "+this.redondear(funcion.evaluar(b))+") = "+this.redondear(resultado));
       


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


        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 6);

        this.fraccion = fraccion;
        this.decimales = decimales;

        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, a, b);

    }
}
