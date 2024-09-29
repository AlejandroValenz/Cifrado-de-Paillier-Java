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
public class Paillier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigInteger p = new BigInteger("41");
        BigInteger q = new BigInteger("43");
        BigInteger m1 = new BigInteger("560");
        BigInteger m2 = new BigInteger("100");
        BigInteger g;
        BigInteger n;
        BigInteger r1 = new BigInteger("39");
        BigInteger r2 = new BigInteger("693");
        BigInteger lambda;
        BigInteger mu;
        BigInteger c1;
        BigInteger c2;
        BigInteger d1;
        BigInteger d2;
        boolean isHomomorphic;
        
        KeyGeneration KG = new KeyGeneration();
        n = KG.calculoN(p, q);
        lambda = KG.calculoLambda(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE));
        g = KG.aleatorioG();
        mu = KG.calculoMu();
        
        Cifrado cipher = new Cifrado();
        c1 = cipher.Cifrado(m1, g, n, r1);
        c2 = cipher.Cifrado(m2, g, n, r2);
        
        Descifrado decrypt = new Descifrado();
        d1 = decrypt.Descifrado(c1, lambda, n, mu);
        d2 = decrypt.Descifrado(c2, lambda, n, mu);
        
        Homomorfismo homomorphic = new Homomorfismo();
        isHomomorphic = homomorphic.Homomorfismo(c1, c2, n, m1, m2, r1, r2, g);
        System.out.println("Homomorfico: " + isHomomorphic);
        
    }
    
}
