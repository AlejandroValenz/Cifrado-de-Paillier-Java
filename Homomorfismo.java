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
public class Homomorfismo {
    
    BigInteger productoDeMensajesCifrados;
    BigInteger cifradoDeProdcutoMensajesPlanos;
    Cifrado cipher = new Cifrado();
    
    public boolean Homomorfismo(BigInteger c1, BigInteger c2, BigInteger n, BigInteger m1, BigInteger m2, BigInteger r1, BigInteger r2, BigInteger g){
        
        productoDeMensajesCifrados = (c1.multiply(c2)).mod(n.pow(2));
        System.out.println("Producto de textos cifrados: " + productoDeMensajesCifrados);
        
        cifradoDeProdcutoMensajesPlanos = (g.pow((m1.add(m2).intValue()))).mod(n.pow(2));
        cifradoDeProdcutoMensajesPlanos = (cifradoDeProdcutoMensajesPlanos.multiply(r1.pow(n.intValue()))).mod(n.pow(2));
        cifradoDeProdcutoMensajesPlanos = (cifradoDeProdcutoMensajesPlanos.multiply(r2.pow(n.intValue()))).mod(n.pow(2));
        System.out.println("Cifrado de suma de textos: " + cifradoDeProdcutoMensajesPlanos);
        
        return productoDeMensajesCifrados.equals(cifradoDeProdcutoMensajesPlanos);
    }
}
