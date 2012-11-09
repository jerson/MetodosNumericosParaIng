package metodos;

import consola.Consola;
import funcion.*;

public class Simpson1_3 extends Base {

    public Simpson1_3() {
        this.espaciado = 0;
        this.decimales = 10;
    }

    public double evaluar(Funcion funcion, double a, double b) {

        double resultado = 0;
        resultado += funcion.evaluar(a);


        double xm = (a + b) / 2;

        resultado += 4 * funcion.evaluar(xm);

        resultado += funcion.evaluar(b);
        resultado *= ((b - a) / 6);
        System.out.println("");
        System.out.println("Resultado:");
        System.out.println("Pnx=" + this.redondear(resultado));




        return resultado;

    }

    public void consola() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Derivada");
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
