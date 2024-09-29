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
public class Descifrado {
    
    BigInteger mDescifrado;
    OperacionesMatematicas OM = new OperacionesMatematicas();
    
    public BigInteger Descifrado(BigInteger cipher, BigInteger lambda, BigInteger n, BigInteger mu){
        System.out.println("------------------------------");
        System.out.println("Mensaje cifrado: " + cipher);
        BigInteger subL;
        subL = (cipher.pow(lambda.intValue())).mod(n.pow(2));
        subL = subL.subtract(BigInteger.ONE);
        subL = subL.divide(n);
        mDescifrado = ((subL).multiply(mu)).mod(n);
        System.out.println("Mensaje original: " + mDescifrado);
        System.out.println("------------------------------");
        
        return mDescifrado;
    }
    
}
