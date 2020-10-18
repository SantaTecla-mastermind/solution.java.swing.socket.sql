# Master Mind. Solución 1.1. *domainModel*
Universo Santa Tecla 

[USantaTecla@gmail.com](mailto:USantaTecla@gmail.com)

version 0.0.1

**Índice**
1. [Requisitos 1. Básica](#id1)
2. [Vista de Lógica/Diseño](#id2)  
    2.1. [Arquitectura](#id2.1)     
    2.2. [Paquete mastermind](#id2.2)  
3. [Calidad del Software](#id3)  
    3.1. [Diseño](#id3.1)  
    3.2. [Rediseño](#id3.2) 
4. [Vista de Desarrollo/Implementación](#id4)
5. [Vista de Despliegue/Física](#id5)
6. [Vista de Procesos](#id6)

## Requisitos 1. *Básica*<a name="id1"></a>

|  |  |
| :------- | :------: | 
| [Wiki](https://en.wikipedia.org/wiki/Mastermind_(board_game)) - [Youtube](https://www.youtube.com/watch?v=2-hTeg2M6GQ)  <br/>* _Funcionalidad: **Básica**_<br/>  * _Interfaz: **Texto**_<br/>  * _Distribución: **Stand Alone**_<br/>  * _Persistencia: **No**_<br/> | ![Texto alternativo](./docs/images/Dibujo.jpg) | 
|  |  |

## Vista de Lógica/Diseño<a name="id2"></a>

- Aplicación del *Modelo del Dominio* mediante Estrategias de *Análisis Formal*, *Análisis Clásico*, *Experto del Dominio*, *Reparto de Responsabilidades*, ...

### Arquitectura<a name="id2.1"></a>
![Texto alternativo](./docs/diagrams/out/arquitectura/arquitectura.svg)

### Paquete _mastermind_<a name="id2.2"></a>
![Texto alternativo](./docs/diagrams/out/paquetes/mastermind.svg)

## Calidad del Software<a name="id3"></a>
### Diseño<a name="id3.1"></a>
- **Método largo**: Método *play* de Mastermind,...
### Rediseño<a name="id3.2"></a>

- _Nueva interfaz: Gráfica_
    * **Clases Grandes**: los Modelos asumen la responsabilidad y crecen en líneas, métodos, atributos, ... con cada nueva tecnología_#
    * **Alto acoplamiento**: los Modelos con cada nueva tecnología de interfaz (consola, gráficos, web, ...)_#
    * **Baja cohesión**: cada Modelo está gestionando sus atributos y las tecnologías de interfaz_#
    * **Open/Close**: hay que modificar los modelos que estaban funcionando previamente para escoger una tecnología de vista u otra (if's anidados)_#

- _Nuevas funcionalidades: undo/redo, demo, estadísiticas,..._
    * **Clases Grandes**: los Modelos asumen la responsabilidad y crecen en líneas, métodos, atributos, ... con las nuevas funcionalidades_#
    * **Open/Close**: hay que modificar los modelos que estaban funcionando previamente para incorporar nuevas funcionalidades_#

## Vista de Desarrollo/Implementación<a name="id4"></a>
![Texto alternativo](./docs/diagrams/out/vistas/desarrollo_implementacion.svg)

## Vista de Despliegue/Física<a name="id5"></a>
![Texto alternativo](./docs/diagrams/out/vistas/despliegue_fisica.svg)

## Vista de Procesos<a name="id6"></a>

- No hay concurrencia