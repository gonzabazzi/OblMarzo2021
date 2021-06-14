
package oblmarzo2021;

public interface IListaCiudad {
  public boolean esVacia();
  public boolean esLlena();
  public void agregarFinal(int dato, String nombre);  // se agrega nombre 
  public void borrarUltimo(); 
  public void agregarInicio(int dato,String nombre);   // se agraga nombre
  public void borrarInicio();     
  public int cantidad();    
  public void mostrar();  
  public boolean buscarelemento(int dato);
  public NodoCiudad obtenerelemento(int dato);
  public int obtenerNroElemento(String nombre);   // agregado para recibir nombre de ciudad y retornar su numero de ciudad
  public void eliminarelemento(int dato); 
  public void agregarOrdenado(int dato, String nombre); // se agrega nombre
  public void mostrarRec();
}
