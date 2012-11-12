package metodos;

import consola.Consola;
import funcion.*;

public class Romberg extends Base {
    
    public Romberg() {
        this.espaciado = 0;
        this.decimales = 10;
    }
    
    public double evaluar(Funcion funcion, double a, double b, int n) {
        
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        System.out.println("n: "+n);
        System.out.println();
        
        double resultado = 0;
        
        double[][] matriz = new double[n][n];
        
        System.out.println("1) Aplicar la regla del trapecio extendido");
        System.out.println("");
        for (int i = 0; i < n; i++) {
            matriz[i][0] = this.trapecioExtendido(funcion, a, b, (Math.pow(2, i)));
        }
        
        System.out.println("");
        System.out.println("1.1) la matriz quedaria asi");
        this.reportarmatriz(matriz);
        
        
        
        System.out.println("");
        System.out.println("2) Aplicar las formulas de Romberg en cada nivel siguiente");
        System.out.println("");
        for (int k = 1; k < n; k++) {
            
            for (int j = 0; j < (n - k); j++) {
                
                double potencia = Math.pow(4.0, k);
                
                double mayor = (potencia / (potencia - 1)) * matriz[j + 1][k - 1];
                double menor = (1 / (potencia - 1)) * matriz[j][k - 1];
                
                System.out.println("Mayor[" + (j + 1) + "][" + (k - 1) + "]=(" + potencia + " / (" + (potencia - 1) + ")) * " + this.redondear(matriz[j + 1][k - 1]) + " = " + this.redondear(mayor));
                System.out.println("Menor[" + j + "][" + (k - 1) + "]=(" + 1 + " / (" + (potencia - 1) + ")) * " + this.redondear(matriz[j][k - 1]) + " = " + this.redondear(menor));
                System.out.println("");
                System.out.println("matriz[" + j + "][" + k + "]=" + this.redondear(mayor) + " - " + this.redondear(menor) + " = " + this.redondear(mayor - menor));
                System.out.println("--------------------------------------------");
                matriz[j][k] = mayor - menor;
                
            }
            
        }
        System.out.println("");
        System.out.println("2.1) la matriz quedaria asi");
        this.reportarmatriz(matriz);
        
        System.out.println("3) El resultado es el ultimo elemento de la primera fila: matriz[0][" + (n - 1) + "]");
        resultado = matriz[0][n - 1];
        System.out.println("");
        System.out.println("Resultado:");
        System.out.println(this.redondear(resultado));
        
        
        
        
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
