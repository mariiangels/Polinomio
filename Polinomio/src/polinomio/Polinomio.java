/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package polinomio;

/**
 *
 * @author mariangel
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Polinomio {

    private Nodo cabeza;

    public Polinomio() {
        this.cabeza = null;
    }

    public void agregarTermino(int coeficiente, int exponente) {
        Nodo nuevoNodo = new Nodo(coeficiente, exponente);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else if (exponente > cabeza.exponente) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo anterior = null;
            Nodo actual = cabeza;

            while (actual != null && exponente <= actual.exponente) {
                if (exponente == actual.exponente) {
                    actual.coeficiente += coeficiente;
                    return;
                }

                anterior = actual;
                actual = actual.siguiente;
            }

            nuevoNodo.siguiente = actual;
            if (anterior != null) {
                anterior.siguiente = nuevoNodo;
            }
        }
    }

    public void imprimir() {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.coeficiente != 0) {
                System.out.print(actual.coeficiente + "x^" + actual.exponente);

                if (actual.siguiente != null && actual.siguiente.exponente > 0) {
                    System.out.print(" + ");
                }
            }

            actual = actual.siguiente;
        }

        System.out.println();
    }

    public double evaluar(double x) {
        double resultado = 0.0;
        Nodo actual = cabeza;

        while (actual != null) {
            resultado += actual.coeficiente * Math.pow(x, actual.exponente);
            actual = actual.siguiente;
        }

        return resultado;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese el número de términos del polinomio: ");
        int n = 0;
        try {
            n = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Polinomio polinomio = new Polinomio();

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el coeficiente del término "
                    + (i + 1) + ": ");
            int coeficiente = 0;
            try {
                coeficiente = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print("Ingrese el exponente del término "
                    + (i + 1) + ": ");
            int exponente = 0;
            try {
                exponente = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            polinomio.agregarTermino(coeficiente, exponente);
        }

        System.out.print("Polinomio: ");
        polinomio.imprimir();

        System.out.println("Tabla de valores del polinomio:");
        System.out.println("x | f(x)");
        System.out.println("---------");

        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double valor = polinomio.evaluar(x);
            System.out.printf("%.1f | %.4f\n", x, valor);
        }
    }
}
