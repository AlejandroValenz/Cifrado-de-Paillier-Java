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
public class OperacionesMatematicas {
    
    public BigInteger gcdExtended(BigInteger a, BigInteger b, BigInteger [] x, BigInteger[] y) {
        // Base case
        if (a.intValue() == 0) {
            x[0] = BigInteger.ZERO;
            y[0] = BigInteger.ONE;
            return b;
        }

        BigInteger[] x1 = new BigInteger[1], y1 = new BigInteger[1]; // Para almacenar los resultados recursivos
        BigInteger gcd = gcdExtended(b.mod(a), a, x1, y1);

        // Actualizar x y y usando los resultados de la llamada recursiva
        
        x[0] = y1[0].subtract(b.divide(a).multiply(x1[0]));
        y[0] = x1[0];

        return gcd;
    }

    // Método para encontrar el inverso multiplicativo
    public BigInteger inversoMultiplicativo(BigInteger a, BigInteger m) {
        BigInteger[] x = new BigInteger[1], y = new BigInteger[1];
        BigInteger gcd = gcdExtended(a, m, x, y);

        // Si a y m no son coprimos, no existe el inverso
        if (!gcd.equals(BigInteger.ONE)) {
            throw new IllegalArgumentException("El inverso no existe porque " + a + " y " + m + " no son coprimos.");
        } else {
            // Asegurarse de que el resultado sea positivo
            
            BigInteger res;
            res = ((x[0].mod(m)).add(m)).mod(m);
            return res;
        }
    }
    
    public BigInteger subMu(BigInteger g, BigInteger lambda, BigInteger n){
        BigInteger subMu;
        subMu = g.pow(lambda.intValue());
        subMu = subMu.mod(n.pow(2));
        //System.out.println("SubMu: " + subMu);
        
        return subMu.subtract(BigInteger.ONE);
    }
    
    public BigInteger calculoMu (BigInteger subMu, BigInteger n){
        BigInteger mu;
        mu = subMu.divide(n);
        mu = mu.mod(n);
        mu = inversoMultiplicativo(mu, n);
        System.out.println("mu: " + mu);
        return mu;
    }
    
}
