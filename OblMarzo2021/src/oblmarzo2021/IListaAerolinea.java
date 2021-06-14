
package oblmarzo2021;

public interface IListaAerolinea {
  public boolean esVacia();
  public void agregarFinal(int dato,String Aerolinea); 
  public void borrarUltimo(); 
  public void agregarInicio(int dato,String Aerolinea);   
  public void borrarInicio();     
  public int cantidad();    
  public void mostrar();  
  public boolean buscarelemento(int dato);
  public NodoAerolinea obtenerelemento(int dato);
  public int obtenerNroAerolinea(String Aerolinea);
  public void eliminarelemento(int dato); 
  public void agregarOrdenado(int dato,String Aerolinea);
  public void mostrarRec();
}
