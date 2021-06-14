
package oblmarzo2021;
// estructura FiFo
public interface ICola {
   public void Encolar(Object dato);  // Encolar, agregar al final 
   public void desencolar() ;  // desencolar, sacar un elemento del inicio
   public boolean esVacia();
   public boolean esllena(); 
   public int  cantelementos() ;  // cantidad de elementos
   public Object  frente();   //Mostrar el frente de la cola    
}
