package metodos;

import consola.Consola;
import funcion.*;

public class Simpson3_8 extends Base {

    public Simpson3_8() {
        this.espaciado = 0;
        this.decimales = 10;
    }

    public double evaluar(Funcion funcion, double x0, double x1, double x2, double x3) {

        double resultado = 0;
        resultado += funcion.evaluar(x0);

        double partes = 0;

        partes += 3 * funcion.evaluar(x1);
        partes += 3 * funcion.evaluar(x2);


        resultado += partes;

        resultado += funcion.evaluar(x3);
        resultado /= 8;
        resultado *= (x3 - x0);
        System.out.println("");
        System.out.println("Resultado:");
        System.out.println( this.redondear(resultado));




        return resultado;

    }

    public void consola() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double x0 = consola.getNumero("Ingresa el Valor para X0");
        double x1 = consola.getNumero("Ingresa el Valor para X1");
        double x2 = consola.getNumero("Ingresa el Valor para X2");
        double x3 = consola.getNumero("Ingresa el Valor para X3");


        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 6);

        this.fraccion = fraccion;
        this.decimales = decimales;

        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, x0, x1, x2, x3);

    }
}
