
package oblmarzo2021;

import java.util.Calendar;

public interface IObligatorio {
  Retorno crearSistemaReservas(int maxCantidadCiudades);  
  Retorno destruirSistemaReservas();
  Retorno registrarCiudad( int NroCiudad, String Ciudad);
  Retorno eliminarCiudad(int NroCiudad, String Ciudad);
  Retorno registrarVuelo(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int capacidad, Calendar fechaHoraSalida, int duracion); 
  Retorno ingresarServicio(String aerolinea, int numero, String servicio); 
  Retorno borrarServicio(String aerolinea, int numero, String servicio); 
  Retorno  ingresarComentario(String aerolinea, int numero, String comentario, int ranking); 
  Retorno realizarReserva(int cliente, int numero, String aerolinea); 
  Retorno cancelarReserva(int cliente, int numero, String aerolinea); 
  Retorno listarServicios(int numero, String aerolinea); 
  Retorno listarVuelosAerolinea(String aerolinea);
  Retorno listarAerolineasRanking();
  Retorno listarComentarios(int numero, String aerolinea);
  Retorno listarEspera(int numero, String aerolinea);
  Retorno mostrarDuraciones();
  Retorno CargarDistancias(int[][] Mapa, String ciudadOrigen, String Ciudaddestino, int duracion);
  Retorno  BuscarCamino ( int [][] Mapa, String origen, String destino);
  
}
