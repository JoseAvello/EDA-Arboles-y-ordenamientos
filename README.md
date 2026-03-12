# Stopify 2: Gestión de Música con Árboles y Algoritmos de Ordenamiento 🎵

Este proyecto fue desarrollado para la cátedra de **Estructura de Datos y Algoritmos** (Junio 2024). Consiste en un sistema de gestión de bibliotecas musicales que utiliza estructuras de datos avanzadas para optimizar la búsqueda y organización de grandes volúmenes de canciones.

## 📋 Descripción del Proyecto

El objetivo principal fue transitar de un almacenamiento lineal (Listas Enlazadas) a una estructura jerárquica (**Árboles Binarios de Búsqueda**) para mejorar la eficiencia de las operaciones de consulta. Además, se realizó un estudio comparativo de diversos algoritmos de ordenamiento aplicados sobre datos reales.



## 🛠️ Tecnologías y Conceptos Clave

- **Lenguaje:** Java
- **Estructuras de Datos:** - Árboles Binarios de Búsqueda (BST)
  - Listas Enlazadas (LinkedList)
  - Arreglos Dinámicos
- **Conceptos:** Recursividad, Complejidad Temporal (Big O), Divide y Vencerás, Árboles Balanceados.

## 🚀 Funcionalidades Principales

1. **Construcción de Árboles Balanceados:** Implementación de un algoritmo que transforma un arreglo ordenado en un árbol balanceado para garantizar tiempos de búsqueda $O(\log n)$.
2. **Búsqueda Avanzada:** - Búsqueda por **Nombre** (retorna el ID de la canción).
   - Búsqueda por **Duración** (retorna una lista de IDs con duraciones coincidentes).
3. **Módulo de Ordenamiento:** Capacidad de ordenar la base de datos por múltiples criterios (Nombre y Duración) utilizando 4 algoritmos distintos.

## 📊 Análisis Comparativo de Algoritmos

Se evaluó el rendimiento de los algoritmos con una base de datos de hasta **114,001 registros**.

| Algoritmo | Complejidad | Eficiencia |
| :--- | :--- | :--- |
| **QuickSort** | $O(n \log n)$ | **Excelente:** El más rápido en las pruebas. |
| **MergeSort** | $O(n \log n)$ | **Muy Buena:** Rendimiento consistente. |
| **Insertion Sort** | $O(n^2)$ | **Baja:** Eficiente solo en listas pequeñas. |
| **Bubble Sort** | $O(n^2)$ | **Muy Baja:** Menos eficiente en grandes volúmenes. |

### Resultados de las Pruebas (Tiempo en ns)
* **QuickSort:** ~103,922,100 ns (aprox. 0.1s para 114k registros).
* **Bubble Sort:** ~317,590,141,300 ns (aprox. 5.3 min para 114k registros).



[Image of Sorting algorithms time complexity graph]


## 📁 Estructura del Código

- `BaseDatos.java`: Gestión de la carga inicial de datos.
- `Arbol.java`: Implementación de la lógica del Árbol Binario y búsquedas.
- `Ordenamiento.java`: Implementación de los 4 algoritmos de ordenamiento.

## 🎓 Conclusiones del Laboratorio

A través de este proyecto se demostró empíricamente la importancia de elegir el algoritmo correcto según el volumen de datos. Mientras que para 5,000 registros la diferencia es milimétrica, para 114,000 registros la elección entre un algoritmo $O(n \log n)$ y uno $O(n^2)$ es la diferencia entre una respuesta instantánea y una espera de varios minutos.

---
**Desarrollado por:** José Avello  
**Fecha:** 16 de Junio, 2024  
**Institución:** Universidad Diego Portales
