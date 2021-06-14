
package oblmarzo2021;

public class Pila implements IPila{
    int maximo;         // el maximo aceptado en la pila
    int cantelementos; //la cantidad de elementos que tiene la pila 
    NodoPila primero;

    public Pila(int maximo) {
        if (this.maximo==0)
            maximo= Integer.MAX_VALUE; 
        else
            this.maximo = maximo;
        this.cantelementos = 0;
        this.primero = null;
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

    public NodoPila getPrimero() {
        return primero;
    }

    public void setPrimero(NodoPila primero) {
        this.primero = primero;
    }

    @Override
    public void apilar(Object dato) {
        NodoPila nuevo = new NodoPila(dato);
        if (!this.esllena()){
            nuevo.setSiguiente(this.getPrimero());
            this.setPrimero(nuevo); 
            this.cantelementos=this.cantelementos+1;
        }

    }

    @Override
    public void desapilar() {
        if (!this.esVacia()){
            this.setPrimero(this.getPrimero().getSiguiente());        
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
    public Object cima() {
        if (!this.esVacia())
           return this.getPrimero().getDato();
        else
            return null;
    }

    @Override
    public int elementos() {
        return this.getCantelementos();
    }

 
}
