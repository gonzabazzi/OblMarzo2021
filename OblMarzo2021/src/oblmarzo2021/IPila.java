
package oblmarzo2021;
// PILA ES UNA ESTRUCTURA LIFO
public interface IPila {
 public void apilar(Object dato); // agrega al inicio
 public void desapilar(); // elimina al inicio
 public boolean esVacia();
 public boolean esllena();
 public Object cima();
 public int elementos();
   
}
