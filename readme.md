
Metodos Numericos Para Ing.
===========================
estan implementados los siguientes metodos:

- Biseccion
- BusquedaIncremental
- FalsaPosicion
- Gauss
- Gauss-Jacobi
- Gauss-Jordan
- Gauss-Seidel
- Lagrange
- Neville
- Newton
- NewtonRaphson
- PuntoFijo
- Secante
- Trapecio
- Trapecio Extendida
- Simpson 1/3 
- Simpson 1/3 Extendida
- Simpson 3/8 
- Simpson 3/8 Extendida
- Cuadratura de Gauss
- Romberg
- Euler
- Euler Mejorado

hay varios ejemplos por cada metodo, adicionalmente implemente una funcion para poder ingresar manualmente los datos, todo usa consola y tiene un menu por cada metodo

##Caracteristicas##

- Controla la cantidad de decimales con los que reportas (para el calculo interno se usan todos los posibles)
- Calcula el espaciado automaticamente entre numeros, para mejorar la visualización en el reporte
- Puedes elegir si deseas mostrar decimales o fracciones

##Librerias Requeridas##

- exp4j (para evaluar funciones en cadena) http://www.objecthunter.net/exp4j/index.html 
- commons-math3 (para mostrar las fracciones)  http://commons.apache.org/math/download_math.cgi
	

##Ejemplos##


####1)####
<pre><code>
 Biseccion biseccion= new Biseccion();
 Funcion funcion = new Funcion("x^2-5*x+6");
 biseccion.evaluar(funcion, 1, 2.5, 0.01);
</code>
</pre>
####Salida:####
<pre><code>

Funcion: x^2-5*x+6
Xa: 1.0
Xb: 2.5
 e: 0.01

  N  a           b           c           f(a)        f(b)        f(c)        E           
  1  1.0         1.75        2.5         2.0         0.3125      -0.25       1.75        
  2  1.75        2.125       2.5         0.3125      -0.1094     -0.25       0.375       
  3  1.75        1.9375      2.125       0.3125      0.0664      -0.1094     0.1875      
  4  1.9375      2.0313      2.125       0.0664      -0.0303     -0.1094     0.0938      
  5  1.9375      1.9844      2.0313      0.0664      0.0159      -0.0303     0.0469      
  6  1.9844      2.0078      2.0313      0.0159      -0.0078     -0.0303     0.0234      
  7  1.9844      1.9961      2.0078      0.0159      0.0039      -0.0078     0.0117      
  8  1.9961      2.002       2.0078      0.0039      -0.0019     -0.0078     0.0059      
 
Solucion Estimada:2.0         
Valor de Comprobacion:0.0  
</code> 
</pre>

####2)####
<pre><code>

 Gauss gauss = new Gauss();
 double[][] matriz = new double[3][4];

 matriz[0][0] = 5;
 matriz[0][1] = -8;
 matriz[0][2] = 1;
 matriz[0][3] = -71;

 matriz[1][0] = -2;
 matriz[1][1] = 6;
 matriz[1][2] = -9;
 matriz[1][3] = 134;

 matriz[2][0] = 3;
 matriz[2][1] = -5;
 matriz[2][2] = 2;
 matriz[2][3] = -58;

 gauss.evaluar(matriz, false);
</code>
</pre>
####Salida:####
<pre><code>


--------------------------------------------------
-----------------METODO DE GAUSS------------------
--------------------------------------------------
--------
I=0
--------
alpha= -2.0 / 5.0 = -0.4

A10=A10-alpha*A00 => 0.0 = 0.0 - 5.0 * -0.4
A11=A11-alpha*A01 => 2.8 = 2.8 - -8.0 * -0.4
A12=A12-alpha*A02 => -8.6 = -8.6 - 1.0 * -0.4
A13=A13-alpha*A03 => 105.6 = 105.6 - -71.0 * -0.4

alpha= 3.0 / 5.0 = 0.6

A20=A20-alpha*A00 => 0.0 = 0.0 - 5.0 * 0.6
A21=A21-alpha*A01 => -0.2 = -0.2 - -8.0 * 0.6
A22=A22-alpha*A02 => 1.4 = 1.4 - 1.0 * 0.6
A23=A23-alpha*A03 => -15.4 = -15.4 - -71.0 * 0.6


       0      1      2       3   
 0 [  5.0    -8.0   1.0  | -71.0 ]
 1 [  0.0    2.8    -8.6 | 105.6 ]
 2 [  0.0    -0.2   1.4  | -15.4 ]

--------------------------------------------------


--------
I=1
--------
alpha= -0.2 / 2.8 = -0.0714

A20=A20-alpha*A10 => 0.0 = 0.0 - 0.0 * -0.0714
A21=A21-alpha*A11 => 0.0 = 0.0 - 2.8 * -0.0714
A22=A22-alpha*A12 => 0.7857 = 0.7857 - -8.6 * -0.0714
A23=A23-alpha*A13 => -7.8571 = -7.8571 - 105.6 * -0.0714


        0        1        2         3    
 0 [   5.0      -8.0     1.0   |  -71.0  ]
 1 [   0.0      2.8      -8.6  |  105.6  ]
 2 [   0.0      0.0     0.7857 | -7.8571 ]

--------------------------------------------------


Calculando Xi
X2= (-7.8571) / (0.7857) =-10.0
X1= (105.6) - [(0.0)*(0.0) + (2.8)*(0.0) + (-8.6)*(-10.0)] / (2.8) = 7.0
X0= (-71.0) - [(5.0)*(0.0) + (-8.0)*(7.0) + (1.0)*(-10.0)] / (5.0) = -1.0

Resultados:
X0=-1.0
X1=7.0
X2=-10.0

Comprobandolo:

       0      1      2       3   
 0 [  5.0    -8.0   1.0  | -71.0 ]
 1 [  -2.0   6.0    -9.0 | 134.0 ]
 2 [  3.0    -5.0   2.0  | -58.0 ]

5.0(-1.0)+-8.0(7.0)+1.0(-10.0)=-71.0
-2.0(-1.0)+6.0(7.0)+-9.0(-10.0)=134.0
3.0(-1.0)+-5.0(7.0)+2.0(-10.0)=-58.0
</code>
</pre>



####3)####
<pre><code>
 Neville neville = new Neville();
 double[] x=new double[3];
 double[] y=new double[3];

 double numero = 251;
 x[0]=94;
 x[1]=205;
 x[2]=371;

 y[0]=929;
 y[1]=902;
 y[2]=860;

 neville.evaluar(x,y,numero);

</code>
</pre>

####Salida:####
<pre><code>

--------------------------------------------------
------------Interpolacion de Neville-------------
--------------------------------------------------


  X  [  94.0 | 205.0 | 371.0 ]
 f(x)[ 929.0 | 902.0 | 860.0 ]

x = 251.0

--------
K=1
--------
f[0][1] = 890.8108108108108
f[1][1] = 890.3614457831326
--------
K=2
--------
f[0][2] = 890.5561165532459
------------------------------------------------------------

 i         Xi       |      f(Xi)     |     ?0f(Xi)    |     ?1f(Xi)    |     ?2f(Xi)    
 0 [      94.0      |      929.0     |      929.0     | 890.8108108108 | 890.5561165532 ]
 1 [      205.0     |      902.0     |      902.0     | 890.3614457831 |       0.0      ]
 2 [      371.0     |      860.0     |      860.0     |       0.0      |       0.0      ]

Resultado:
Pnx=890.5561165532
</code>
</pre>