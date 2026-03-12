import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LabTres{
    public static class Cancion{
        public int id;
        public String nombre;
        public String artista;
        public double duracion; // en milisegundos
        public Cancion(int id, String nombre , String artista, double duracion){
            this.id = id;
            this.nombre = nombre;
            this.artista = artista;
            this.duracion = duracion;
        }
    }
    public static class BaseDato{
        public LinkedList <Cancion> data = new LinkedList<>();

        public BaseDato(){}

        public void agregarCancion(Cancion e){

            data.add(e);
        }

       
    }

    public static LinkedList <Cancion> ordenarPorNombreBubbleSort(LinkedList <Cancion> x){
        if(x.isEmpty()){

            System.out.println("no existen registros");
            return x;
        }

        else{
        int n = x.size();
        Cancion[] copia = new Cancion[n];
        x.toArray(copia);

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){

                if(copia[i].nombre.compareTo(copia[j].nombre) < 0){

                    Cancion aux = copia[i];
                    copia[i] = copia[j];
                    copia[j] = aux;
                }
            }
        }
        LinkedList <Cancion> ordenado = new LinkedList<>(Arrays.asList(copia));
        return ordenado;
        }     
    }

    public static LinkedList <Cancion> ordenarPorDuracionBubbleSort(LinkedList <Cancion> x){
        if(x.isEmpty()){
            return x;
        }
        else{
            int n = x.size();
            Cancion[] copia = new Cancion[n];

            x.toArray(copia);
    
            for(int i = 0; i < n ; i++){
                for(int j = 0; j < n; j++){
    
                    if(copia[i].duracion < copia[j].duracion){
    
                        Cancion aux = copia[i];
                        copia[i] = copia[j];
                        copia[j] = aux;                      
                    }
                }
            }
  
            LinkedList <Cancion> ordenado = new LinkedList<>(Arrays.asList(copia));  
            return ordenado;
        }
    }

    public static LinkedList <Cancion> ordenarPorNombreInsertionSort(LinkedList <Cancion> x){

        if(x.isEmpty()){
            System.out.println("no existen registros");
            return x;
        }
        else{
            int n = x.size();
            Cancion[] copia = new Cancion[n];
            x.toArray(copia);

            for(int i = 1; i < n; i++){
                Cancion key = copia[i];
                int j = i - 1;
                while (j >= 0 && copia[j].nombre.compareToIgnoreCase(key.nombre) > 0) {
                    copia[ j + 1] = copia[j];
                    j--;              
                }
                copia[j + 1] = key;
            }

            LinkedList <Cancion> ordenado = new LinkedList<>(Arrays.asList(copia));
            return ordenado;
        }
    }

    public static LinkedList <Cancion> ordenarPorDuracionInsertionSort(LinkedList <Cancion> x){

        if(x.isEmpty()){
            System.out.println("no existen registros");
            return x;
        }
        else{
            int n = x.size();
            Cancion[] copia = new Cancion[n];
            x.toArray(copia);

            for(int i = 1; i < n; i++){
                Cancion key = copia[i];
                int j = i - 1;
                while (j >= 0 && copia[j].duracion > key.duracion) {
                    copia[ j + 1] = copia[j];
                    j--;              
                }
                copia[j + 1] = key;
            }

            LinkedList <Cancion> ordenado = new LinkedList<>(Arrays.asList(copia));
            return ordenado;
        }
    }

    public static LinkedList <Cancion> ordenarPorDuracionMergeSort(LinkedList <Cancion> x){
        if(x.isEmpty()){
            System.out.println("no existen registros");
            return x;
        }
        else{

            int n = x.size();
            boolean duracion = false;
            Cancion[] copia = new Cancion[n];
            x.toArray(copia);

           copia = dividir(copia,duracion);
           
            LinkedList <Cancion> ordenado = new LinkedList<>(Arrays.asList(copia));

            return ordenado;
        }

    }

    public static LinkedList <Cancion> ordenarPorNombreMergeSort(LinkedList <Cancion> x){

        if(x.isEmpty()){
            System.out.println("no existen registros");
            return x;
        }
        else{
            int n = x.size();
            boolean Nombre = true;
            Cancion[] copia = new Cancion[n];
            x.toArray(copia);

            copia = dividir(copia, Nombre);

            LinkedList <Cancion> ordenado = new LinkedList<>(Arrays.asList(copia));

            return ordenado;
        }
    }

    public static Cancion[] mezclarDuracion(Cancion[] izq, Cancion[] der){

        Cancion[] mezclado = new Cancion[izq.length + der.length];

        int i = 0, j = 0, contador = 0;
        while (i < izq.length && j < der.length) {
            
            if(izq[i].duracion <= der[j].duracion){
                mezclado[contador] = izq[i];
                i++;
            }
            else{
                mezclado[contador] = der[j];
                j++;
            }

            contador++;
        }

        while (i < izq.length) {

            mezclado[contador] = izq[i];
            i++;
            contador++;
            
        }
        while (j < der.length) {

            mezclado[contador] = der[j];
            j++;
            contador++;
            
        }

        return mezclado;
    }
   
    public static Cancion[] mezclarNombre(Cancion[] izq, Cancion[] der){

        Cancion[] mezclado = new Cancion[izq.length + der.length];

        int i = 0, j = 0, contador = 0;
        while (i < izq.length && j < der.length) {
            
            if(izq[i].nombre.compareToIgnoreCase(der[j].nombre) <= 0){
                mezclado[contador] = izq[i];
                i++;
            }
            else{
                mezclado[contador] = der[j];
                j++;
            }

            contador++;
        }

        while (i < izq.length) {

            mezclado[contador] = izq[i];
            i++;
            contador++;
            
        }
        while (j < der.length) {

            mezclado[contador] = der[j];
            j++;
            contador++;
            
        }

        return mezclado;
    }
   
    public static Cancion[] dividir(Cancion[] A, boolean aux){
        if(A.length == 1){
            return A;
        }

        else{
            int mid = A.length / 2;
            Cancion[] izq = new Cancion[mid];
            Cancion[] der = new Cancion[A.length - mid];

            for(int i = 0; i < mid; i++){
                izq[i] = A[i];
            }

            for(int j = mid; j < A.length; j++){
                der[j - mid] = A[j];
            }

            
            // utilizo el booleano auxiliar para saber si quiere ordenar en base al nombre o la duracion
            if(aux){
                der = dividir(der,aux);
                izq = dividir(izq,aux);
                return mezclarNombre(izq, der);
            }
            else{
                der = dividir(der, aux);
                izq = dividir(izq, aux);
                return mezclarDuracion(izq, der);
            }

            
        }
        
    }
  
    public static void mostrar(LinkedList <Cancion> x){

        for(int i = 0; i < x.size(); i++){

            System.out.println(x.get(i).nombre + " - " + x.get(i).artista + " - " + x.get(i).duracion);
        }
    }

    
    public static LinkedList<Cancion> ordenarPorNombreQuickSort(LinkedList<Cancion> x) {
        if (x.isEmpty()) {
            System.out.println("sin datos");
            return x;
        }
    
        int n = x.size();
        Cancion[] array = new Cancion[n];
        x.toArray(array);
    
        quicksortPorNombre(array, 0, array.length - 1);
        return new LinkedList<>(Arrays.asList(array));
    }
    
    private static void quicksortPorNombre(Cancion[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionPorNombre(array, low, high);
            quicksortPorNombre(array, low, pivotIndex - 1);
            quicksortPorNombre(array, pivotIndex + 1, high);
        }
    }

    private static void swap(Cancion[] array, int lo, int hi) {
        Cancion temp = array[lo];
        array[lo] = array[hi];
        array[hi] = temp;
    }
    
    private static int partitionPorNombre(Cancion[] array, int low, int high) {
        Cancion pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].nombre.compareToIgnoreCase(pivot.nombre) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
    



    public static LinkedList<Cancion> ordenarPorDuracionQuickSort(LinkedList<Cancion> x) {
        if (x.isEmpty()) {
            System.out.println("sin datos");
            return x;
        }
    
        int n = x.size();
        Cancion[] array = new Cancion[n];
        x.toArray(array);
    
        quicksortPorDuracion(array, 0, array.length - 1);
        return new LinkedList<>(Arrays.asList(array));
    }
    
    private static void quicksortPorDuracion(Cancion[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionPorDuracion(array, low, high);
            quicksortPorDuracion(array, low, pivotIndex - 1);
            quicksortPorDuracion(array, pivotIndex + 1, high);
        }
    }
    
    private static int partitionPorDuracion(Cancion[] array, int low, int high) {
        Cancion pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].duracion < pivot.duracion) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
    

























/* 

    public static Arbol arbolArregloOrdenado(Cancion[] arreglo){

        if(arreglo.length == 0){
            System.out.println("sin registros");
            return null;
        }

        Arbol arbol = balancear(arreglo, 0, arreglo.length - 1);
        return arbol;

    }

    public static Arbol balancear(Cancion[] arreglo, int lo, int hi){

        if(lo < hi){

            int mid = (lo + hi) / 2;
            Arbol arbol = new Arbol(arreglo[mid]);
            arbol.left = balancear(arreglo, lo, hi - 1);
            arbol.right = balancear(arreglo, mid + 1, hi);

            return arbol;

        }
        else{
            return null;
        }
    }

    public Arbol ArbolArregloDesordenado(Cancion[] arreglo){
        if(arreglo.length == 0){
            System.out.println("no existen registros");
            return null;
        }

        Arbol arbol = new Arbol(arreglo[0]);
        for(int i = 1; i < arreglo.length; i++){

            arbol.insertar(arreglo[i]);
        }
       return arbol;
    }


    */




















    public static class Arbol{
        Cancion root;
        Arbol left;
        Arbol right;

        public Arbol(Cancion root){
            this.root = root;
            this.left = null;
            this.right = null;
        } 

        public void insertar(Cancion song){

            if(song.nombre.compareToIgnoreCase(root.nombre) < 0){
                if(this.left == null){
                    this.left = new Arbol(song);
                }
                else{
                    this.left.insertar(song);
                }
            }
            else if (song.nombre.compareToIgnoreCase(root.nombre) > 0){

                if(this.right == null){
                    this.right = new Arbol(song);
                }
                else{
                    this.right.insertar(song);
                }

            }
        } 

        public int buscarNombre(String nombre){

            if(this.root.nombre.equalsIgnoreCase(nombre)){
            
                return root.id;
            }
            else if(nombre.compareToIgnoreCase(this.root.nombre) < 0){
                if(this.left != null){
                 return this.left.buscarNombre(nombre);
                }
                
            }
            else{

                if(this.right != null){
                 return this.right.buscarNombre(nombre);
                }        
            }

            return -1;
        }

        public LinkedList <Integer>  buscarDuracion(double duracion){
            LinkedList <Integer> identificadores = new LinkedList<>();

            if(this.root.duracion == duracion){
                identificadores.add(root.id);
            }
            if (this.left != null) {
                LinkedList <Integer> leftResult = this.left.buscarDuracion(duracion);
                if(!leftResult.isEmpty()){
                    for(int i = 0; i < leftResult.size();i++){
                        identificadores.add(leftResult.get(i));
                    }
                }
              
            }
            if (this.right != null) {
                LinkedList <Integer> rightResult = this.right.buscarDuracion(duracion);
                if(!rightResult.isEmpty()){
                    for(int i = 0; i < rightResult.size();i++){
                        identificadores.add(rightResult.get(i));
                    }
                }
               
            }
            return identificadores;
        
    }
}



    public static Arbol arbolArregloOrdenado(Cancion[] arreglo) {
        if (arreglo.length == 0) {
            System.out.println("sin registros");
            return null;
        }
        Arbol arbol = balancear(arreglo, 0, arreglo.length - 1);
        return arbol;
    }
    
    private static Arbol balancear(Cancion[] arreglo, int lo, int hi) {
        if (lo <= hi) {
            int mid = (lo + hi) / 2;
            Arbol arbol = new Arbol(arreglo[mid]);
            arbol.left = balancear(arreglo, lo, mid - 1);
            arbol.right = balancear(arreglo, mid + 1, hi);
            return arbol;
        }
        return null;
    }
    
    public static Arbol arbolArregloDesordenado(Cancion[] arreglo) {
        if (arreglo.length == 0) {
            System.out.println("no existen registros");
            return null;
        }
        Arbol arbol = new Arbol(arreglo[0]);
        for (int i = 1; i < arreglo.length; i++) {
            arbol.insertar(arreglo[i]);
        }
        return arbol;
    }
    

    public static void preOrder(Arbol x){
        if(x == null){
            return;
        }

        System.out.println(x.root.nombre);
        preOrder(x.left);
        preOrder(x.right);
    }

   
    public static void main(String[] args){
        BaseDato uno = new BaseDato();


        
            String ruta = "C:\\Users\\ASUS GAMER\\Downloads\\cinco.csv";
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                boolean first = true;
                while ((line = br.readLine()) != null) {
                    if (first) {
                        first = false;
                        continue;
                    }
                    String[] data = line.split("\\|");
                    String nombre = data[0];
                    String artista = data[1];
                    double duracion = Double.parseDouble(data[2]);
    
                    Cancion aux = new Cancion(0, nombre, artista, duracion);
                    uno.agregarCancion(aux);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        
            Cancion[] n = new Cancion[uno.data.size()];
            uno.data.toArray(n);
            Arbol ordenado = arbolArregloDesordenado(n);

            System.out.println(ordenado.buscarNombre("SOS"));
          
    /* 
        //prueba pequeña
        Cancion one = new Cancion(1, "a", "f", 8000);
        Cancion dos = new Cancion(2, "b", "f", 16000);
        Cancion tres = new Cancion(3, "c", "b", 1100);
        Cancion cuatro = new Cancion(4, "d", "b", 1100);
        Cancion cinco = new Cancion(5, "e", "b", 100);
        Cancion seis = new Cancion(6, "f", "b", 10);

        uno.agregarCancion(one);
        uno.agregarCancion(dos);
        uno.agregarCancion(tres);
        uno.agregarCancion(cuatro);
        uno.agregarCancion(cinco);
        uno.agregarCancion(seis);

    */ 

        //contador en nanosegundos de la guia
    /*  long start , finish ;
        start = System . nanoTime ();
        LinkedList <Cancion> or = ordenarPorDuracionQuickSort(uno.data);
        finish = System . nanoTime ();
        System .out. println (" MergeSort time: " + ( finish - start ) + " ns.");
    */    


    
       
    /*  
        //contador en milisegundos 
        long startTime = System.currentTimeMillis();
        LinkedList <Cancion> or = ordenarPorDuracionQuickSort(uno.data);
        long endTime = System.currentTimeMillis();
        long tiempoDeEjecucion = endTime - startTime;
    */
        
    }

}
