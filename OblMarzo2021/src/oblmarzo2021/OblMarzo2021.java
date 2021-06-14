package oblmarzo2021;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OblMarzo2021 {

    public static void main(String[] args) throws ParseException {
        Prueba p = new Prueba();
        
        // Pasamos por parámetro el máximo de ciudades a crear 
        Obligatorio o = new Obligatorio();

        juegodeprueba(p, o);

    }

    public static void juegodeprueba(Prueba p, Obligatorio o) throws ParseException {
        
        p.ver(o.crearSistemaReservas(6).resultado, Retorno.Resultado.OK, "Se creó el sistema de reservas.");
        //Registrar ciudades
        p.ver(o.registrarCiudad(0, "MVD").resultado, Retorno.Resultado.OK, "Se registró MVD");
        p.ver(o.registrarCiudad(1, "SCL").resultado, Retorno.Resultado.OK, "Se registró SCL");
        p.ver(o.registrarCiudad(2, "LIM").resultado, Retorno.Resultado.OK, "Se registró LIM");
        p.ver(o.registrarCiudad(3, "GRU").resultado, Retorno.Resultado.OK, "Se registró GRU");
        p.ver(o.registrarCiudad(4, "PTY").resultado, Retorno.Resultado.OK, "Se registró PTY");
        p.ver(o.registrarCiudad(5, "JFK").resultado, Retorno.Resultado.OK, "Se registró JFK");
        p.ver(o.registrarCiudad(6, "MAD").resultado, Retorno.Resultado.ERROR, "No es posible registrar MAD: excede límite.");

        System.out.println("Listado de ciudades ingresadas");
        o.getLc().mostrar();
        
        //eliminar ciudades
        p.ver(o.eliminarCiudad(6, "MAD").resultado, Retorno.Resultado.ERROR, "Se intenta eliminar la ciudad MAD que no existe");
        p.ver(o.eliminarCiudad(0, "MVD").resultado, Retorno.Resultado.OK, "Se eliminaa la ciudad MVD");
        System.out.println("Listado de ciudades ingresadas luego de eliminar MAD y MVD");
        o.getLc().mostrar();

        //Agregamos la ciudad MVD que fue eliminada
        p.ver(o.registrarCiudad(0, "MVD").resultado, Retorno.Resultado.OK, "Se registro MVD");
        System.out.println("Listado de ciudades luego de registrar MVD nuevamente");
        o.getLc().mostrar(); 
   
        //Registro aerolineas
        o.getLa().agregarFinal(1, "AA");
        o.getLa().agregarFinal(2, "LATAM");
        o.getLa().agregarFinal(3, "COPA");
        o.getLa().agregarFinal(4, "GOL");
        o.getLa().agregarFinal(5, "AVIANCA");
        System.out.println ("Listado de aerolineas");
        o.getLa().mostrar();

        // Agrego vuelos
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        cal.setTime(sdf.parse("Mon Mar 15 14:00:00 GMT 2021"));
        
        p.ver(o.registrarVuelo(1, "LATAM", "MVD", "SCL", 1, 175, cal, 10).resultado, Retorno.Resultado.OK, "Se registró vuelo 1 de LATAM");
        p.ver(o.registrarVuelo(2, "GOL", "MVD", "GRU", 3, 200, cal, 15).resultado, Retorno.Resultado.OK, o.registrarVuelo(2, "GOL", "MVD", "GRU", 3, 200, cal, 15).valorString);
        p.ver(o.registrarVuelo(3, "IBERIA", "MVD", "MAD", 5, 220, cal, 50).resultado, Retorno.Resultado.ERROR, o.registrarVuelo(3, "IBERIA", "MVD", "MAD", 5, 220, cal, 50).valorString);
        p.ver(o.registrarVuelo(4, "AVIANCA", "LIM", "JFK", 2, 220, cal, 40).resultado, Retorno.Resultado.OK, o.registrarVuelo(4, "AVIANCA", "LIM", "JFK", 2, 220, cal, 40).valorString);
        p.ver(o.registrarVuelo(5, "AlasU", "MVD", "ASD", 4, 250, cal, 10).resultado, Retorno.Resultado.ERROR, o.registrarVuelo(5, "AlasU", "MVD", "ASD", 4, 250, cal, 10).valorString);
        p.ver(o.registrarVuelo(1, "LATAM", "MVD", "SCL", 1, 175, cal, 10).resultado, Retorno.Resultado.ERROR, o.registrarVuelo(1, "LATAM", "MVD", "SCL", 1, 175, cal, 10).valorString);


        // listamos los vuelos general
        System.out.println("Listado de vuelos general");
        o.getLv().mostrar();
        
        // listado de vuelos de una aerolinea en particular
        o.la.obtenerelemento(1).getLv().mostrar();
        o.la.obtenerelemento(2).getLv().mostrar();
        o.la.obtenerelemento(3).getLv().mostrar();
        o.la.obtenerelemento(4).getLv().mostrar();
        o.la.obtenerelemento(5).getLv().mostrar();
        

        // Agregamos pasasajeros
        NodoVuelo vuelo = o.getLv().obtenerelemento(2);
        if (vuelo != null) {
            vuelo.getLp().agregarFinal(1, "Juan");
            vuelo.getLp().agregarFinal(2, "Pedro");
            vuelo.getLp().agregarFinal(3, "Ana");
            vuelo.getLp().agregarFinal(4, "Maria");
            //vuelo.getLp().agregarFinal(5, "Pepe");
            FuncionesAuxiliares.agregarpasajeroaunvuelo(vuelo, 5, "Pepe");

            //vuelo.getLp().agregarFinal(1, "Andres"); 
            FuncionesAuxiliares.agregarpasajeroaunvuelo(vuelo, 6, "Andres");  // este debe quedar en cola de espera 
        }
//        System.out.println ("PASAJEROS DEL VUELO 2");
//         vuelo.getLp().mostrar();
        
//        NodoVuelo vuelo1 = o.getLv().obtenerelemento(2);
//        NodoVuelo vuelo2 = o.getLv().obtenerelemento(3);
//        
//        
//        if (vuelo1!=null && vuelo2!=null){            
//           FuncionesAuxiliares.cambiarpasajerosdevuelo(vuelo1, vuelo2);
//        }
//     
//        System.out.println ("PASAJEROS DEL VUELO 2");
//        vuelo = o.getLv().obtenerelemento(2); 
//        if ( vuelo.getLp()==null){System.out.println("vuelo vacio");};
//        
//        
//        System.out.println ("PASAJEROS DEL VUELO 3"); 
//        vuelo2.getLp().mostrar();
//          System.out.println("El pasajero " + vuelo.getColaespera().frente()+ "  esta esperando se libere un cupo");
//          
          
        // Cargamos el mapa en la matriz de distancias
        p.ver(o.CargarDistancias(o.getMapa(), "MVD", "SCL", 10).resultado, Retorno.Resultado.OK, o.CargarDistancias(o.getMapa(), "MVD", "SCL", 10).valorString);
        p.ver(o.CargarDistancias(o.getMapa(), "MVD", "GRU", 15).resultado, Retorno.Resultado.OK, o.CargarDistancias(o.getMapa(), "MVD", "GRU", 15).valorString);
        p.ver(o.CargarDistancias(o.getMapa(), "MVD", "LIM", 25).resultado, Retorno.Resultado.OK, o.CargarDistancias(o.getMapa(), "MVD", "LIM", 25).valorString);
        p.ver(o.CargarDistancias(o.getMapa(), "MVD", "PTY", 30).resultado, Retorno.Resultado.OK, o.CargarDistancias(o.getMapa(), "MVD", "PTY", 30).valorString);
        p.ver(o.CargarDistancias(o.getMapa(), "SCL", "LIM", 20).resultado, Retorno.Resultado.OK, o.CargarDistancias(o.getMapa(), "SCL", "LIM", 20).valorString);
        p.ver(o.CargarDistancias(o.getMapa(), "LIM", "JFK", 40).resultado, Retorno.Resultado.OK, o.CargarDistancias(o.getMapa(), "LIM", "JFK", 40).valorString);
        p.ver(o.CargarDistancias(o.getMapa(), "GRU", "JFK", 45).resultado, Retorno.Resultado.OK, o.CargarDistancias(o.getMapa(), "GRU", "JFK", 45).valorString);
        p.ver(o.CargarDistancias(o.getMapa(), "PTY", "JFK", 25).resultado, Retorno.Resultado.OK, o.CargarDistancias(o.getMapa(), "PTY", "JFK", 25).valorString);



        System.out.println(FuncionesAuxiliares.mostrarmatriz(o.getMapa()));
        
        System.out.println(o.BuscarCamino(o.getMapa(), "MVD", "GRU").valorString);
        System.out.println(o.BuscarCamino(o.getMapa(), "LIM", "PTY").valorString);
        System.out.println(o.BuscarCamino(o.getMapa(), "MVD", "SCL").valorString);
        System.out.println(o.BuscarCamino(o.getMapa(), "SCL", "GRU").valorString);
        
      
        p.imprimirResultadosPrueba();
    }

}
