package metodos;

import consola.Consola;
import funcion.*;

public class CuadraturaGauss extends Base {
    
    public CuadraturaGauss() {
        this.espaciado = 0;
        this.decimales = 10;
    }
    
    public double evaluar(Funcion funcion, double a, double b, int n) {
        
        double resultado = 0;
        
     
        
        
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
