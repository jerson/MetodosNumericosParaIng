package metodos;

import consola.Consola;
import funcion.*;

public class Euler extends Base {
    
    public Euler() {
        this.espaciado = 0;
        this.decimales = 10;
    }
    
     public double evaluar(Funcion funcion, double a, double b, int n) {
        
        double resultado = 0;
        
     
        
        
        return resultado;
        
    }
    
    private double trapecioExtendido(Funcion funcion, double a, double b, double n) {
        
        double resultado = 0;
        resultado += funcion.evaluar(a);
        String centro = "";
        
        double h = (b - a) / n;
        double partes = 0;
        for (int i = 1; i < n; i++) {
            
            partes += funcion.evaluar(a + i * h);
            centro += this.redondear(funcion.evaluar(a + i * h)) + (i != (n - 1) ? " + " : "");
        }
        if (centro.equals("")) {
            centro = "0";
        }
        
        resultado += (2 * partes);
        
        resultado += funcion.evaluar(b);
        resultado *= ((b - a) / (2 * n));
        
        
        System.out.println("((" + b + " - " + a + ") / " + (2 * n) + ") * (" + this.redondear(funcion.evaluar(a)) + " + 2(" + centro + ") + " + this.redondear(funcion.evaluar(b)) + "  ) = " + this.redondear(resultado));
        
        
        
        
        return resultado;
        
    }
    
    public void consola() {
        
        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double a = consola.getNumero("Ingresa el Valor para a");
        double b = consola.getNumero("Ingresa el Valor para b");
        int n = consola.getEntero("Ingresa el Numero de Niveles", 4);
        
        
        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");
        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 6);
        
        this.fraccion = fraccion;
        this.decimales = decimales;
        
        consola.limpiarPantalla();
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, a, b, n);
        
    }
}
