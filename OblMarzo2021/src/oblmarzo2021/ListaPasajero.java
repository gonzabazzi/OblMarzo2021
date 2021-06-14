package oblmarzo2021;

public class ListaPasajero implements IListaPasajero {

    NodoPasajero inicio;
    NodoPasajero ultimo;
    int cantidad;
    int maximacantidadciudades;

    public ListaPasajero(int maximacantidadciudades) {
        this.inicio = null;
        this.ultimo = null;
        this.cantidad = 0;
        this.maximacantidadciudades = maximacantidadciudades;
    }

    public NodoPasajero getInicio() {
        return inicio;
    }

    public void setInicio(NodoPasajero inicio) {
        this.inicio = inicio;
    }

    public NodoPasajero getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoPasajero ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean esVacia() {
        return (this.getInicio() == null);
    }

    @Override
    public boolean esLlena() {
        return (this.cantidad == this.maximacantidadciudades);
    }

    @Override
    public void agregarInicio(int dato, String nombre) {
        if (!this.esLlena()) {
            NodoPasajero nuevo = new NodoPasajero(dato, nombre);
            if (this.esVacia()) {
                this.setInicio(nuevo);
                this.setUltimo(nuevo);
            } else {
                nuevo.setSiguiente(this.getInicio());
                this.setInicio(nuevo);

            }
            this.cantidad = this.cantidad + 1;
        }
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (this.getInicio() == this.getUltimo()) {
                this.setInicio(null);
                this.setUltimo(null);
            } else {
                this.setInicio(this.inicio.getSiguiente());
            }

            this.cantidad = this.cantidad - 1;
        } else {
            System.out.println("La lista esta vacia ");
        }

    }

    @Override
    public void mostrar() {
        NodoPasajero aux = this.getInicio();
        while (aux != null) {
            System.out.println(aux.getDato() + " - " + aux.getNombre());
            aux = aux.getSiguiente();
        }
    }

    @Override
    public boolean buscarelemento(int dato) {
        NodoPasajero aux = this.getInicio();
        while (aux != null) {
            if (aux.getDato() == dato) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public NodoPasajero obtenerelemento(int dato) {
        NodoPasajero aux = this.getInicio();
        while (aux != null) {
            if (aux.getDato() == dato) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return aux;
    }

    // retorna el numero de ciudad y si no la encuentra retorna -1
    @Override
    public int obtenerelemento(String nombre) {
        NodoPasajero aux = this.getInicio();
        while (aux != null) {
            if (aux.getNombre() == nombre) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return -1;
    }

    @Override
    public void agregarFinal(int dato, String nombre) {
        if (!this.esLlena()) {
            NodoPasajero nuevo = new NodoPasajero(dato, nombre);
            if (this.esVacia()) {
                this.agregarInicio(dato, nombre);
            } else {
                this.ultimo.setSiguiente(nuevo);
                this.setUltimo(nuevo);
                this.cantidad = this.cantidad + 1;
            }
        }
    }

    @Override
    public int cantidad() {
        return this.cantidad;
    }

    @Override
    public void borrarUltimo() {
        if (!this.esVacia()) {
            if (this.getInicio() == this.getUltimo()) {
                this.setInicio(null);
                this.setUltimo(null);
            } else {
                NodoPasajero aux = this.getInicio();
                while (aux.getSiguiente() != this.getUltimo()) {
                    aux = aux.getSiguiente();
                }

                aux.setSiguiente(null); // aux.siguiente= null
                this.setUltimo(aux);   // this.ultimo=aux
            }
            this.cantidad = this.cantidad - 1;
        }

    }

    @Override
    public void eliminarelemento(int dato) {
        NodoPasajero buscado = this.obtenerelemento(dato);
        NodoPasajero aux = this.getInicio();
        if (buscado != null) {
            if (this.getInicio() == buscado) {
                this.borrarInicio();
            } else {
                if (this.getUltimo() == buscado) {
                    this.borrarUltimo();
                }
                while (aux.getSiguiente() != buscado) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(buscado.getSiguiente());
            }
            this.cantidad = this.cantidad - 1;
        }
    }
// no hay elementos repetidos

    @Override
    public void agregarOrdenado(int dato, String nombre) {
        if (!this.esLlena()) {
            NodoPasajero nuevo = new NodoPasajero(dato, nombre);
            NodoPasajero aux = this.getInicio();

            if (this.esVacia() || dato < this.getInicio().getDato()) {
                this.agregarInicio(dato, nombre);
            } else {
                if (dato > this.getUltimo().getDato()) {
                    this.agregarFinal(dato, nombre);
                } else {

                    while (dato > (aux.getSiguiente().getDato())) {
                        aux = aux.getSiguiente();
                    }
                    nuevo.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(nuevo);
                    this.cantidad = this.cantidad + 1;
                }
            }
        }
    }

    // IMPLEMETACION RECURSIVA  
    @Override
    public void mostrarRec() {
        System.out.println(mostrarRec(this.getInicio(), this.getUltimo()));
    }

    public String mostrarRec(NodoPasajero inicio, NodoPasajero ultimo) {

        if (inicio == ultimo) {
            return inicio.getDato() + " - ";
        }
        return inicio.getDato() + " - " + mostrarRec(inicio.getSiguiente(), ultimo);

    }
}
