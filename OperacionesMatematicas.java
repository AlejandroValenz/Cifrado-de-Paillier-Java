/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paillier;

/**
 *
 * @author Alejandro
 */
public class OperacionesMatematicas {
    
    public int maximoComunDivisor(int a, int b) {
        int temporal;
        while (b != 0) {
            temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    public int minimoComunMultiplo(int a, int b) {
        return (a * b) / maximoComunDivisor(a, b);
    }
    
}
