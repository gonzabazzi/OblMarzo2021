
package oblmarzo2021;

public class FuncionesAuxiliares {
    
   public static String mostrarmatriz(int[][] m) {
        String ret="";
       
        int filas= m.length;
        int columnas=m[0].length;
        for (int i=0; i<filas;i++){
           for (int j=0;j<columnas;j++){
              ret=ret+ m[i][j]+ " - ";
           }
              ret=ret+"\n";
        }             
        return ret;
    }    
    
    
    
 public static void agregarpasajeroaunvuelo(NodoVuelo vuelo ,int nropasajero, String pasajero){
     if (!vuelo.getLp().esLlena()){
         vuelo.getLp().agregarFinal(nropasajero, pasajero);
         System.out.println("El pasajero "+ pasajero + " fue agregado al vuelo " + vuelo.getDato()+ " \n");
     }
     else{
         vuelo.getColaespera().Encolar(pasajero);
         System.out.println("El pasajero "+ pasajero + " Quedo en cola de espera \n");
     }
 }
 
public static void cambiarpasajerosdevuelo(NodoVuelo vuelo1, NodoVuelo vuelo2){
    // faltan validaciones, cupo v1 menor o igual al cupo del vuelo2
    
    if (vuelo1.getCupo()<=vuelo2.getCupo()){
        vuelo2.setLp(vuelo1.getLp());
        vuelo1.setLp(null);
    }

} 
    
    
}
