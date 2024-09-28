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
        KeyGeneration KG = new KeyGeneration();
        KG.calculoN(p, q);
        KG.calculoLambda(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE));
        KG.aleatorioG();
        KG.calculoMu();
    }
    
}
