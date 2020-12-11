# Mastermind. Solución 6.2. *mvp.pm.+facade*
Santa Tecla  
[parqueNaturalSantaTecla@gmail.com ](mailto:parqueNaturalSantaTecla@gmail.com )  
version 0.0.1  

**Índice**
1. [Requisitos 2. Gráficos](#requisitos-2-graficos)  
2. [Vista de Lógica/Diseño](#vista-de-lógicadiseño)  
    2.1. [Arquitectura](#arquitectura)  
    2.2. [Paquete mastermind](#paquete-mastermind)  
    2.3. [Paquete mastermind.views](#paquete-mastermind-viewa)  
    2.4. [Paquete mastermind.views.console](#paquete-mastermind-views-console)  
    2.5. [Paquete mastermind.controllers](#paquete-mastermind-controllers)  
    2.6. [Paquete mastermind.models](#paquete-mastermind-models)  
    2.7. [Paquete mastermind.types](#paquete-mastermind-types)  
    2.8. [Paquete mastermind.utils](#paquete-mastermind-utils)  
3. [Calidad del Software](#calidad-del-software)  
    3.1. [Diseño](#diseño)  
    3.2. [Rediseño](#rediseño) 
4. [Vista de Desarrollo/Implementación](#vista-de-desarrolloimplementación)
5. [Vista de Despliegue/Física](#vista-de-desplieguefísica)
6. [Vista de Procesos](#vista-de-procesos)

## Requisitos 2. *Gráficos*<a name="requisitos-2-graficos"></a>

| [Youtube](https://www.youtube.com/watch?v=2-hTeg2M6GQ)  <br/>* _Funcionalidad: **Básica**_<br/>  * _Interfaz: **Gráfica** y **Texto**_<br/>  * _Distribución: **Stand Alone**_<br/>  * _Persistencia: **No**_<br/> | ![Texto alternativo](./docs/images/mastermind.jpg) | 
| :------- | :------: |

## Vista de Lógica/Diseño<a name="vista-de-lógicadiseño"></a>

- Modelo/Vista/Presentador con Presentador del Modelo
    * **Patrón Facade**, para la lógica del conjunto de Controladores y Modelos

### Arquitectura<a name="arquitectura"></a>
![Texto alternativo](./docs/diagrams/out/arquitectura/arquitectura.svg)

### Paquete *mastermind*<a name="paquete-mastermind"></a>
![Texto alternativo](./docs/diagrams/out/paquetes/mastermind.svg)

### Paquete *mastermind.views*<a name="paquete-mastermind-viewa"></a>
![Texto alternativo](./docs/diagrams/out/paquetes/usantatecla.mastermind.views.svg)

### Paquete *mastermind.views.console*<a name="paquete-mastermind-views-console"></a>
![Texto alternativo](./docs/diagrams/out/paquetes/usantatecla.mastermind.console.svg)

### Paquete *mastermind.controllers*<a name="paquete-mastermind-controllers"></a>
![Texto alternativo](./docs/diagrams/out/paquetes/usantatecla.mastermind.controllers.svg)

### Paquete *mastermind.models*<a name="paquete-mastermind-models"></a>
![Texto alternativo](./docs/diagrams/out/paquetes/usantatecla.mastermind.models.svg)

### Paquete *mastermind.types*<a name="paquete-mastermind-types"></a>
![Texto alternativo](./docs/diagrams/out/paquetes/usantatecla.mastermind.types.svg)

### Paquete *utils*<a name="paquete-mastermind-utils"></a>
![Texto alternativo](./docs/diagrams/out/paquetes/usantatecla.utils.svg)

## Calidad del Software<a name="calidad-del-software"></a>
### Diseño<a name="diseño"></a>
- **DRY:**: en las clases de vistas que asume el flujo de control y se repite en mastermind.views.console.ProposalView y mastermind.views.graphics.GameView
### Rediseño<a name="rediseño"></a>
- Nuevas funcionalidades: undo/redo, demo, estadísiticas,…
    * **Alto Acoplamiento:** los Vistas reciben los nuevos controladores por constructor

## Vista de Desarrollo/Implementación<a name="vista-de-desarrolloimplementación"></a>
![Texto alternativo](./docs/diagrams/out/vistas/desarrollo_implementacion.svg)

## Vista de Despliegue/Física<a name="vista-de-desplieguefísica"></a>
![Texto alternativo](./docs/diagrams/out/vistas/despliegue_fisica.svg)

## Vista de Procesos<a name="vista-de-procesos"></a>

- No hay concurrencia