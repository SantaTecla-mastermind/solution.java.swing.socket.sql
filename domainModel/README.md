# Master Mind. Solución 1.1. *domainModel*
Universo Santa Tecla 

[USantaTecla@gmail.com](USantaTecla@gmail.com)

version 0.0.1

**Índice**
1. [Requisitos 1. Básica](#id1)
2. [Vista de Lógica/Diseño](#id2)  
    2.1. [Arquitectura](#id2.1)     
    2.2. [Paquete tictactoe](#id2.2)  
3. [Calidad del Software](#id3)  
    3.1. [Rediseño](#id3.1)  
4. [Vista de Desarrollo/Implementación](#id4)
5. [Vista de Despliegue/Física](#id5)
6. [Vista de Procesos](#id6)

## Requisitos 1. *Básica*<a name="id1"></a>

|  |  |
| :------- | :------: | 
| -link: https://en.wikipedia.org/wiki/Tic-tac-toe[*Wiki*]  <br/>* _Funcionalidad: **Básica**_<br/>  * _Interfaz: **Texto**_<br/>  * _Distribución: **Stand Alone**_<br/>  * _Persistencia: **No**_<br/> | ![Texto alternativo](./docs/images/Dibujo.jpg) | 
|  |  |

## Vista de Lógica/Diseño<a name="id2"></a>

- Aplicación del *Modelo del Dominio* mediante Estrategias de *Análisis Formal*, *Análisis Clásico*, *Experto del Dominio*, *Reparto de Responsabilidades*, ...

### Arquitectura<a name="id2.1"></a>
![Texto alternativo](../docs/diagrams/out/__WorkspaceFolder__/domainModel/docs/diagrams/src/arquitectura/arquitectura.svg)

### Paquete _tictactoe_<a name="id2.2"></a>
![Texto alternativo](../docs/diagrams/out/__WorkspaceFolder__/domainModel/docs/diagrams/src/paquetes/tictactoe.svg)

## Calidad del Software<a name="id3"></a>
### Rediseño<a name="id3.1"></a>

- _Nueva interfaz: Gráfica_
    * **Clases Grandes**: los Modelos asumen la responsabilidad y crecen en líneas, métodos, atributos, ... con cada nueva tecnología_#
    * **Alto acoplamiento**: los Modelos con cada nueva tecnología de interfaz (consola, gráficos, web, ...)_#
    * **Baja cohesión**: cada Modelo está gestionando sus atributos y las tecnologías de interfaz_#
    * **Open/Close**: hay que modificar los modelos que estaban funcionando previamente para escoger una tecnología de vista u otra (if's anidados)_#

- _Nuevas funcionalidades: undo/redo, demo, estadísiticas,..._
    * **Clases Grandes**: los Modelos asumen la responsabilidad y crecen en líneas, métodos, atributos, ... con las nuevas funcionalidades_#
    * **Open/Close**: hay que modificar los modelos que estaban funcionando previamente para incorporar nuevas funcionalidades_#

## Vista de Desarrollo/Implementación<a name="id4"></a>
![Texto alternativo](../docs/diagrams/out/__WorkspaceFolder__/domainModel/docs/diagrams/src/vistas/desarrollo_implementacion.svg)

## Vista de Despliegue/Física<a name="id5"></a>
![Texto alternativo](../docs/diagrams/out/__WorkspaceFolder__/domainModel/docs/diagrams/src/vistas/despliegue_fisica.svg)

## Vista de Procesos<a name="id6"></a>

- No hay concurrencia