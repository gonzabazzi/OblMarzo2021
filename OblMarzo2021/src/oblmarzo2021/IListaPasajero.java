
package oblmarzo2021;

public interface IListaPasajero {
  public boolean esVacia();
  public boolean esLlena();
  public void agregarFinal(int dato, String nombre);
  public void borrarUltimo(); 
  public void agregarInicio(int dato,String nombre);
  public void borrarInicio();     
  public int cantidad();    
  public void mostrar();  
  public boolean buscarelemento(int dato);
  public NodoPasajero obtenerelemento(int dato);
  public int obtenerelemento(String nombre);
  public void eliminarelemento(int dato); 
  public void agregarOrdenado(int dato, String nombre);
  public void mostrarRec();
}
