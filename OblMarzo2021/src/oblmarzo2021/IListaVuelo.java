
package oblmarzo2021;
import java.util.Calendar;

public interface IListaVuelo {
  public boolean esVacia();
  public void agregarFinal(int dato, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int cupo, Calendar fechaHoraSalida, int duracion); 
  public void borrarUltimo(); 
  public void agregarInicio(int dato, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int cupo, Calendar fechaHoraSalida, int duracion);   
  public void borrarInicio();     
  public int cantidad();    
  public void mostrar();  
  public boolean buscarelemento(int dato);
  public NodoVuelo obtenerelemento(int dato); 
  public void eliminarelemento(int dato); 
  public void agregarOrdenado(int dato, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int cupo, Calendar fechaHoraSalida, int duracion);
  public void mostrardelultimoalprimero();
  public void mostrardelprimeroalultimo();
  public void mostrarRec();   
}

