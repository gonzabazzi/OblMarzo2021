package oblmarzo2021;
import java.util.Calendar;

public class Obligatorio implements IObligatorio {

    int cantidadciudades;
    int[][] mapa;
    ListaCiudad lc;
    ListaVuelo lv;
    ListaAerolineas la;

    
    public int getCantidadciudades() {
        return cantidadciudades;
    }
    public void setCantidadciudades(int cantidadciudades) {
        this.cantidadciudades = cantidadciudades;
    }
    public int[][] getMapa() {
        return mapa;
    }
    public void setMapa(int[][] mapa) {
        this.mapa = mapa;
    }
    public ListaCiudad getLc() {
        return lc;
    }
    public void setLc(ListaCiudad lc) {
        this.lc = lc;
    }
    public ListaVuelo getLv() {
        return lv;
    }
    public void setLv(ListaVuelo lv) {
        this.lv = lv;
    }
    public ListaAerolineas getLa() {
        return la;
    }
    public void setLa(ListaAerolineas la) {
        this.la = la;
    }
    
    @Override
    public Retorno crearSistemaReservas(int maxCantidadCiudades) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        this.cantidadciudades = maxCantidadCiudades;
        this.mapa = new int[maxCantidadCiudades][maxCantidadCiudades];
        this.lc = new ListaCiudad(maxCantidadCiudades);
        this.lv = new ListaVuelo();
        this.la=new ListaAerolineas();
        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        this.la = null;
        this.lc = null;
        this.lv = null;

        return ret;
    }

    @Override
    public Retorno registrarCiudad(int NroCiudad, String Ciudad) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if (!this.lc.esLlena()){
            this.getLc().agregarOrdenado(NroCiudad, Ciudad);
            ret.valorString="Se agrego la ciudad "+Ciudad + " corrctamente.";
            ret.resultado=Retorno.Resultado.OK;
        } else {
            ret.valorString="No Se agrego la ciudad "+Ciudad + " por exceder el limite permitido.";
            ret.resultado=Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno eliminarCiudad(int NroCiudad, String Ciudad) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int ciudadbuscada=this.lc.obtenerNroElemento(Ciudad);
        if (ciudadbuscada!=-1){
            this.lc.eliminarelemento(ciudadbuscada);
            ret.resultado=Retorno.Resultado.OK;
        }else{
            ret.valorString ="La " + Ciudad +" no existía previamente";
            ret.resultado=Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno registrarVuelo(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int capacidad, Calendar fechaHoraSalida, int duracion) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);     
        ret.valorString="";
        boolean flag = true;
        int nroCiudadOrigen = this.lc.obtenerNroElemento(ciudadOrigen);        
        int nroCiudadDestino = this.lc.obtenerNroElemento(ciudadDestino);
        int nroaerolinea=this.la.obtenerNroAerolinea(aerolinea);
        
        if(estrellas < 1 || estrellas > 5){
            flag = false;
            ret.valorString+="El nro de estrellas debe ser entre 1 y 5.\n";
        }
        if(capacidad <= 0 || duracion <= 0){
            flag = false;
            ret.valorString+="Capacidad y duración deben ser mayores a 0.\n";
        }
        if(nroCiudadOrigen == -1 || nroCiudadDestino == -1){
            flag = false;
            ret.valorString+="No existe ciudad de destino o cuidad de origen.\n";
        }
        if (nroaerolinea == -1){
            flag = false;
            ret.valorString+="No existe la aerolinea "+ aerolinea+".\n";
        } else {
            NodoAerolinea aerolineabuscada=this.la.obtenerelemento(nroaerolinea);
            if(!aerolineabuscada.getLv().esVacia()){
                if(aerolinea.equals(aerolineabuscada.getLv().obtenerelemento(numero).getAerolinea())){
                    flag = false;
                    ret.valorString+="Ya existe el vuelo "+numero+" en la aerolinea "+aerolinea+".\n";
                }
            } else {
                if (flag){
                    aerolineabuscada.getLv().agregarFinal(numero, aerolinea, ciudadOrigen, ciudadDestino, estrellas, capacidad, fechaHoraSalida, duracion);
                    ret.valorString+="Se agregó el vuelo "+ numero + " de aerolinea "+ aerolinea;
                    ret.resultado=Retorno.Resultado.OK;            
                }
            }
        }
        
        
        return ret;
    }

    @Override
    public Retorno ingresarServicio(String aerolinea, int numero, String servicio) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno borrarServicio(String aerolinea, int numero, String servicio) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno ingresarComentario(String aerolinea, int numero, String comentario, int ranking) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno realizarReserva(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno cancelarReserva(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno listarServicios(int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno listarVuelosAerolinea(String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno listarAerolineasRanking() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno listarComentarios(int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno listarEspera(int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno mostrarDuraciones() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno CargarDistancias(int[][] Mapa, String ciudadOrigen, String Ciudaddestino, int duracion) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int f = this.getLc().obtenerNroElemento(ciudadOrigen);
        int c = this.getLc().obtenerNroElemento(Ciudaddestino);

        Mapa[f][c] = duracion;
        Mapa[c][f] = duracion;
        ret.valorString = "Se cargó el tramo " + ciudadOrigen + " - " + Ciudaddestino + " con duración: " + duracion;
        return ret;
    }

    @Override
    public Retorno BuscarCamino(int[][] Mapa, String origen, String destino) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int filaorigen = this.getLc().obtenerNroElemento(origen);
        int filadestino = this.getLc().obtenerNroElemento(destino);
        int escala = -1;
        int ancho = Mapa[0].length;
        int duracionviaje = Integer.MAX_VALUE;
        if (Mapa[filaorigen][filadestino] != 0) {
            duracionviaje = Mapa[filaorigen][filadestino];
            ret.valorString = "Hay vuelo directo para ir de  " + origen + " a " + destino + " con duración: " + duracionviaje;
        } else {
            for (int i = 0; i < ancho; i++) {
                int tramo1 = Mapa[filaorigen][i];
                int tramo2 = Mapa[filadestino][i];
                if (tramo1 != 0 && tramo2 != 0) {
                    if (tramo1 + tramo2 < duracionviaje) {
                        duracionviaje=tramo1+tramo2;
                        escala=i;
                    }
                }
            }
            ret.valorString="El camino mas corto para el viaje de "+ origen +" a " + destino + " es de duración: " + duracionviaje + " con escala en "+ this.getLc().obtenerelemento(escala).getNombre();
        }

        return ret;
    }

}
