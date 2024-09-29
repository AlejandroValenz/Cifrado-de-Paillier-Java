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
    BigInteger g = new BigInteger("0");
    BigInteger submu = new BigInteger("0");
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
        g = BigInteger.valueOf(70);
        System.out.println("g: " + g);
        this.g = g;
        return g;
    }
    
    public BigInteger calculoMu (){
        mu = OM.calculoMu(OM.subMu(g, lambda, n), n);
        return mu;
    }
    
    public void LlavesGeneradas (BigInteger n, BigInteger g, BigInteger lambda, BigInteger mu){
        System.out.println("Llave publica: (" + g + ", " + n + ")");
        System.out.println("Llave privada: (" + lambda + ", " + mu + ", " + n + ")");
    }

}
