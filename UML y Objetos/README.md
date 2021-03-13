# UML (Unified Modeling Language) 🚀️

Un poco de historia...

## Historia de la Orientacion a objetos

### Evolucion del analisis de sistemas

La evolucion de los paradigmas empezo con la aparicion de los lenguajes de programacion con soporte para los paradigmas, luego con las recomendaciones de las mejores practicas de diseño y luego con la aparicion de los metodos de elaboraciones de abstracciones por tecnicas y herramientas de analisis.

Hubieron 3 corrientes:

* **Orientacion a procesos** , solo se veia como se debia comportar un sistema, sin darle mucho interes a como se almacenarian los datos. Este pensamiento aun existe, pero con la aparicion de las bases de datos fue muriendo de a poco.
* **Orientacion a Objetos**, inicio en el 69 con el lenguaje Smalltalk, y hoy en dia comanda casi todo
* **Orientacion a datos**, nacio con la aparicion del **modelo relacional**.

La evolucion se llevo a cabo de la siguiente manera:

* **1986** Recomendaciones de diseño por Booch
* **1988** Modelado orientado a las caracteristicas de los objetos, por Shlaer y Mellor
* **1990** Surgen muchos métodos más de autores provenientes de las bases de datos relacionales
* **1994** Se imponen los métodos orientados al comportamiento de los objetos y en el mismo año se empieza a gestar UML

### El lenguaje UML

#### Unificacion

* 1994, Booch manifiesta la necesidad de unificar criterios
* Rumbaugh se le une a Booch
* Ambos hacen la version 0.8 del Unified Method
* 1995, Jacobson se une y nace el UML

#### Estandarizacion

* Sale la version 0.9 de UML
* 1996, se hacen modificaciones en base a aportes de personas
* Sale la version 1.1 con ayuda de empresas. Se presenta al OMG
* 1997, OMG adopta a UML 1.1 como estandar

#### Objetivos del UML

* Dar a un lenguaje visual de modelado facil
* Separar el modelado de los lenguajes
* Dar a raices formales, mejores practicas y estandares mundiales

### Método vs Lenguaje de Modelado

#### Método

* Es una descripcion de pasos en orden con su tecnica y herramientas
* Tecnicas, herramientas y tareas que solucionan un problema

#### Lenguaje de modelado

* Conjunto de señales que dan a entender algo
* Posee elementos y reglas sintacticas
* Expresa ideas mediante modelos

#### Modelo de Analisis y diseño

* Modelo: Cuerpo de informacion recabado sobre un sistema para estudiarlo
* Se necesita al modelo cuando no se puede estudiar al sistema por si mismo por complejidad, tamaño, etc

# Concepto de Objetos 🚀️

## Clase y Objeto

Una clase es una plantilla de una coleccion de objetos parecidos, con nombre, atributo y metodos.

Los objetos son instancias de una clase especifica, heredan sus atributos y las operaciones para manipular estos atributos.

Por ejemplo la clase Persona con los atributos Nombre, Apellido, y los metodos Trabajar(), Comer(), etc..

## Clasificacion

* Los sustantivos se vuelven clases, los verbos metodos y los adjetivos identificados son atributos
* Las clases se agrupan por funcionalidad creando jerarquias
* Se identifican tambien la relacion entre clases.
* Se debe lograr una estructura clara, y una buena separacion de responsabilidades.
* Se deben tener claros los patrones jerarquicos entre clases y flujo de los mensajes.

## Encapsulamiento y Ocultamiento de Info

### Privada

Info que necesita el objeto para operar. No es util para nadie más

### Publica

Es info que necesita el resto de objetos para interactuar con mi objeto

### Protegida

La info que necesitan las clases heredadas

## Retencion de estado

La informacion de un objeto se mantiene en el mismo estado hasta que este sea alterado por las operaciones que fueron hechas para tal fin.

## Herencia

Una subclase hereda los atributos y operaciones de la superclase

## Polimorfismo

Una clase puede comportarse de distinta manera dependiendo de como recibe las cosas.

### Sobrecarga

Se modifica la firma del metodo pero el comportamiento es el mismo

### Sobreescritura

Es la misma firma pero el comportamiento es otro

## Generalizacion

Es un caso particular de herencia que consiste en la relacion entre una clase general y sus clases hijas. Por ejemplo, la clase general Animal y las clases especificas Gato, Perro..
