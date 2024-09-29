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
public class Cifrado {
    
    BigInteger mCifrado;
    
    public BigInteger Cifrado(BigInteger m, BigInteger g, BigInteger n, BigInteger r){
        System.out.println("------------------------------");
        System.out.println("Mensaje a cifrar: " + m);
        mCifrado = ((g.pow(m.intValue())).multiply(r.pow(n.intValue()))).mod(n.pow(2));
        System.out.println("Mensaje cifrado: " + mCifrado);
        System.out.println("------------------------------");
        return mCifrado;
    }
    
}
