## Master Mind. Solucion 3.2. dv.withoutFactoryMethod
Santa Tecla  
[parqueNaturalSantaTecla@gmail.com ](mailto:parqueNaturalSantaTecla@gmail.com )
version 0.0.1  
**Índice** 
1. [Requisitos 1. Básica](#requisitos-1-básica)  
2. [Vista de Lógica/Diseño](#vista-de-lógicadiseño)  
2.1. [Arquitectura](#arquitectura)  
2.2. [Paquete usantatecla.mastermind](#paquete-usantateclamastermind)  
2.3. [Paquete usantatecla.mastermind.views](#paquete-usantateclamastermindviews)  
2.4. [Paquete usantatecla.mastermind.views.console](#paquete-usantateclamastermindviewsconsole)  
2.5. [Paquete usantatecla.mastermind.views.graphics](#paquete-usantateclamastermindviewsgraphics)  
2.6. [Paquete usantatecla.mastermind.models](#paquete-usantateclamastermindmodels)  
2.7. [Paquete usantatecla.mastermind.types](#paquete-usantateclamastermindtypes)   
2.8. [Paquete usantatecla.utils](#paquete-usantateclautils)  
3. [Calidad del Software](#calidad-del-software)  
3.1. [Diseño](#diseño)  
3.2. [Rediseño](#rediseño)  
4. [Vista de Desarrollo/Implementación](#vista-de-desarrolloimplementación)
5. [Vista de Despliegue/Física](#vista-de-desplieguefísica)
6. [Vista de Procesos](#vista-de-procesos)

# Requisitos 1. Básica

| [Youtube](https://www.youtube.com/watch?v=2-hTeg2M6GQ) <br/> * _Funcionalidad: **Básica**_ <br/> * _Interfaz: **Texto**_ <br/> * _Distribución: **Standalone**_ <br/> * _Persistencia: **No**_  | ![Mastermind](docs/images/mastermind.jpg) |  
| :------- | :------: |

# Vista de Lógica/Diseño
  - Arquitectura Documento/Vista mediante **Patrón de Vista Separada**

## Arquitectura

![Arquitectura](./docs/diagrams/out/arquitectura/arquitectura.svg)

### Paquete *usantatecla.mastermind*

![Paquete_usantatecla.mastermind](./docs/diagrams/out/paquetes/usantatecla.mastermind.svg)

### Paquete *usantatecla.mastermind.views*

![Paquete_usantatecla.mastermind.views](./docs/diagrams/out/paquetes/usantatecla.mastermind.views.svg)

### Paquete *usantatecla.mastermind.views.console*

![Paquete_usantatecla.mastermind.views.console](./docs/diagrams/out/paquetes/usantatecla.mastermind.views.console.svg)

### Paquete *usantatecla.mastermind.views.graphics*

![Paquete_usantatecla.mastermind.views](./docs/diagrams/out/paquetes/usantatecla.mastermind.views.graphics.svg)

### Paquete *usantatecla.mastermind.models*

![Paquete_usantatecla.mastermind.models](./docs/diagrams/out/paquetes/usantatecla.mastermind.models.svg)  

### Paquete *usantatecla.mastermind.types*

![Paquete_Usantatecla.mastermind.types](./docs/diagrams/out/paquetes/usantatecla.mastermind.types.svg)

### Paquete *usantatecla.utils*

![Paquete_usantatecla.utils](./docs/diagrams/out/paquetes/usantatecla.utils.svg)

# Calidad del Software

## Diseño

  - ***DRY**: clases principales*

## Rediseño

  - *Nuevas funcionalidades: undo/redo, demo, estadísiticas,…​*
    
      - ***Clases Grandes**: los Modelos asumen la responsabilidad y
        crecen en líneas, métodos, atributos, …​ con las nuevas
        funcionalidades*
    
      - ***Open/Close**: hay que modificar los modelos que estaban
        funcionando previamente para incorporar nuevas funcionalidades*

# Vista de Desarrollo/Implementación

![Desarrollo_Implementación](./docs/diagrams/out/vistas/desarrollo_implementacion.svg)

# Vista de Despliegue/Física

![Despliegue_Física](./docs/diagrams/out/vistas/despliegue_fisica.svg)

# Vista de Procesos
  - No hay concurrencia
