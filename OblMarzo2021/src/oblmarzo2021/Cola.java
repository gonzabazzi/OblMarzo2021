
package oblmarzo2021;

public class Cola implements ICola {
    int maximo;         // el maximo que aceptado en la cola
    int cantelementos; //la cantidad de elementos que tiene la pila 
    NodoCola primero;
    NodoCola ultimo;

    public Cola(int maximo ) {
        if (maximo==0)
           this.maximo = Integer.MAX_VALUE;
        else
           this.setMaximo(maximo);
        
        this.cantelementos = 0;
        this.primero = null;
        this.ultimo = null;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getCantelementos() {
        return cantelementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }

    public NodoCola getPrimero() {
        return primero;
    }

    public void setPrimero(NodoCola primero) {
        this.primero = primero;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public void Encolar(Object dato) {
        NodoCola nuevo = new NodoCola(dato);
        if (!this.esllena()){
            if (this.esVacia()){
                this.setPrimero(nuevo);
                this.setUltimo(nuevo);
            }else{
                this.ultimo.setSiguiente(nuevo);
                this.setUltimo(nuevo);
            
            }
             this.cantelementos=this.cantelementos+1;       
        }
    }

    @Override
    public void desencolar() {
        if (!this.esVacia()){
            if (this.cantelementos==1){
                this.setPrimero(null);
                this.setUltimo(null);                
            }
            else{
                this.setPrimero(this.getPrimero().getSiguiente());                            
            }
            this.cantelementos=this.cantelementos-1;
        
        }
    }

    @Override
    public boolean esVacia() {
        return this.getCantelementos()==0;
    }

    @Override
    public boolean esllena() {
//        if (this.getMaximo()==0)
//            return false;
        return this.getCantelementos()==this.getMaximo();
    }

    @Override
    public int cantelementos() {
        return this.getCantelementos();
    }

    @Override
    public Object frente() {
        if (!this.esVacia())
            return this.getPrimero().getDato();
        else
            return null;

    }


}
