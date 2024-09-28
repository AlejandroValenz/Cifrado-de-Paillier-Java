/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paillier;

import java.math.BigInteger;

/**
 *
 * @author Alejandro
 */
public class KeyGeneration {
    BigInteger p = new BigInteger("41");
    BigInteger q = new BigInteger("43");
    BigInteger n = new BigInteger("0");
    BigInteger lambda = new BigInteger("0");
    BigInteger g = new BigInteger("70");
    BigInteger subMu = new BigInteger("0");
    BigInteger mu = new BigInteger("0");
    
    OperacionesMatematicas OM = new OperacionesMatematicas();
    
    public BigInteger calculoN (BigInteger p, BigInteger q){
        //if(OM.maximoComunDivisor(p-1, q-1) == 1)
            n = p.multiply(q);
        //else
          //  System.out.println("Selecciona unos primos distintos");
        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("n: " + n);
        return n;
    }
    
    public BigInteger calculoLambda (BigInteger p, BigInteger q){
        BigInteger gcd = new BigInteger("0");
        gcd = p.gcd(q);
        lambda = (p.multiply(q)).divide(gcd);
        System.out.println("Lambda: " + lambda);
        return lambda;
    }
    
    public BigInteger aleatorioG (){
        //g = (int)(Math.random()*n-2) + 1;
        //g = 70;
        System.out.println("g: " + g);
        return g;
    }
    
    public BigInteger subMu(){
        subMu = g.pow(lambda.intValue());
        subMu = subMu.mod(n.pow(2));
        System.out.println("SubMu: " + subMu);
        
        return subMu.subtract(BigInteger.ONE);
    }
    
    public BigInteger calculoMu (){
        subMu();
        mu = subMu.divide(n);
        mu = mu.mod(n);
        System.out.println("mu: " + mu);
        return mu;
    }
    
    private long gcdExtended(int a, int b, int[] x, int[] y) {
        // Base case
        if (a == 0) {
            x[0] = 0;
            y[0] = 1;
            return b;
        }

        int[] x1 = new int[1], y1 = new int[1]; // Para almacenar los resultados recursivos
        long gcd = gcdExtended(b % a, a, x1, y1);

        // Actualizar x y y usando los resultados de la llamada recursiva
        x[0] = y1[0] - (b / a) * x1[0];
        y[0] = x1[0];

        return gcd;
    }

    // Método para encontrar el inverso multiplicativo
    public long inversoMultiplicativo(int a, int m) {
        int[] x = new int[1], y = new int[1];
        long gcd = gcdExtended(a, m, x, y);

        // Si a y m no son coprimos, no existe el inverso
        if (gcd != 1) {
            throw new IllegalArgumentException("El inverso no existe porque " + a + " y " + m + " no son coprimos.");
        } else {
            // Asegurarse de que el resultado sea positivo
            int res = (x[0] % m + m) % m;
            return res;
        }
    }

}
