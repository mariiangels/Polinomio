/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomio;

/**
 *
 * @author mari1
 */
public class Nodo {

    public int coeficiente;
    public int exponente;
    public Nodo siguiente;

    public Nodo(int coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = null;
    }
}
