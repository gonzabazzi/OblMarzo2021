
package oblmarzo2021;

public class ListaAerolineas implements IListaAerolinea {
    NodoAerolinea inicio;
    NodoAerolinea ultimo;
    int cantidad;

    public ListaAerolineas() {
        this.inicio = null;
        this.ultimo=null;
        this.cantidad=0;
    }

    public NodoAerolinea getInicio() {
        return inicio;
    }

    public void setInicio(NodoAerolinea inicio) {
        this.inicio = inicio;
    }

    public NodoAerolinea getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoAerolinea ultimo) {
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
        return (this.getInicio()==null);        
    }

    @Override
    public void agregarInicio(int dato,String Aerolinea) {
        NodoAerolinea nuevo=new NodoAerolinea(dato,Aerolinea); 
        if (this.esVacia()){
            this.setInicio(nuevo);
            this.setUltimo(nuevo);
        }else
        {
            nuevo.setSiguiente(this.getInicio());
            this.setInicio(nuevo);  
        
        }
          this.cantidad=this.cantidad+1;
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            if (this.getInicio()==this.getUltimo()){
                this.setInicio(null);
                this.setUltimo(null);
            }else{                      
                 this.setInicio(this.inicio.getSiguiente());     
            } 
            
             this.cantidad=this.cantidad-1;
        }
        else
            System.out.println("La lista esta vacia ");

    }

    @Override
    public void mostrar() {
         NodoAerolinea aux=this.getInicio();        
         while (aux!=null){
            System.out.println(aux.getDato()+ " - "+ aux.getAerolinea()+ "\n");
            aux=aux.getSiguiente();
         }
    }

    @Override
    public boolean buscarelemento(int dato) {
        NodoAerolinea aux=this.getInicio();
        while (aux!=null){
            if (aux.getDato()==dato){
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;
    }

    @Override
    public NodoAerolinea obtenerelemento(int dato) {
        NodoAerolinea aux=this.getInicio();
        while (aux!=null){
            if (aux.getDato()==dato){
                return aux;
            }
            aux=aux.getSiguiente();
        }
        return aux;
    }
   
    @Override
    public int obtenerNroAerolinea(String Aerolinea) {
        NodoAerolinea aux=this.getInicio();
        while (aux!=null){
            if (aux.getAerolinea().equals(Aerolinea)){
                return aux.getDato();
            }
            aux=aux.getSiguiente();
        }
        return -1;
    }
    
    
    @Override
    public void agregarFinal(int dato,String Aerolinea) {
           NodoAerolinea nuevo = new NodoAerolinea(dato,Aerolinea);
           if (this.esVacia()){
               this.agregarInicio(dato,Aerolinea);
           }else{
               this.ultimo.setSiguiente(nuevo);
               this.setUltimo(nuevo);  
               this.cantidad=this.cantidad+1;  
           }
            
    }       
             
//    @Override
//    public void agregarFinal(int dato) {
//           NodoAerolinea nuevo = new NodoAerolinea(dato);
//           NodoAerolinea aux=this.getInicio();
//           
//           if (this.esVacia()){
//               this.agregarInicio(dato);
//           }else{
//               while(aux.getSiguiente()!=null){
//                    aux=aux.getSiguiente();
//               }
//               aux.setSiguiente(nuevo);
//           }
//           

//    }

//    @Override
//    public int cantidad() {
//        NodoAerolinea aux=this.getInicio();
//        int cantidad=0;
//        while (aux!=null){
//           cantidad=cantidad +1;
//           aux=aux.getSiguiente();
//        
//        }
//        return cantidad;
//
//    }
     @Override
   public int cantidad() { 
       return this.cantidad; 
   }  

    @Override
    public void borrarUltimo() {
        if (!this.esVacia()){
            if (this.getInicio()==this.getUltimo()){
                this.setInicio(null);
                this.setUltimo(null);
            }else{
                NodoAerolinea aux=this.getInicio();
                while (aux.getSiguiente()!=this.getUltimo()){
                      aux=aux.getSiguiente();
                }
                
                aux.setSiguiente(null); // aux.siguiente= null
                this.setUltimo(aux);   // this.ultimo=aux
            }
         this.cantidad=this.cantidad-1;
        }
          
    }

    @Override
    public void eliminarelemento(int dato) {
        NodoAerolinea buscado= this.obtenerelemento(dato);
        NodoAerolinea aux=this.getInicio();
        if (buscado!=null){
            if (this.getInicio()==buscado){
                this.borrarInicio();               
            }else{
                if (this.getUltimo()==buscado){
                    this.borrarUltimo();
                }
                while (aux.getSiguiente()!=buscado){
                    aux=aux.getSiguiente();
                }
                aux.setSiguiente(buscado.getSiguiente());
            }
            this.cantidad=this.cantidad-1;                
        }           
    }
// no hay elementos repetidos
    @Override
    public void agregarOrdenado(int dato,String Aerolinea) {
        NodoAerolinea nuevo= new NodoAerolinea(dato,Aerolinea);
        NodoAerolinea aux=this.getInicio();        
   
        if (this.esVacia()|| dato<this.getInicio().getDato()){
            this.agregarInicio(dato,Aerolinea);
        }else{ 
            if (dato > this.getUltimo().getDato()){
                this.agregarFinal(dato,Aerolinea);
            }else{
            
            while (dato > (aux.getSiguiente().getDato())){
                aux=aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            }
        }

    }

  // IMPLEMETACION RECURSIVA  

    @Override
    public void mostrarRec() {
      System.out.println(mostrarRec(this.getInicio(),this.getUltimo()));
    }

    public String mostrarRec(NodoAerolinea inicio, NodoAerolinea ultimo) {     
           
       
            if (inicio==ultimo)       
              return inicio.getDato()+ " - ";
             return  inicio.getDato() + " - "+ mostrarRec(inicio.getSiguiente(),ultimo);
        
          
    

}
}
