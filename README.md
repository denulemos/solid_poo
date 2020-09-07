

# SOLID

Este repositorio esta hecho tomando como base el siguiente curso de Udemy => https://www.udemy.com/course/patrones-de-diseno-y-principios-solid/ .

## Origen

Son principios que formaban parte de un libro de "Desarrollo Agil de Software", escrito por "Uncle Bob", un autor de varios libros importantes en técnicas de programación. 

* S -> Single resposibility Principle
* O -> Open/Closed principle
* L -> Liskov Substitution Principle
* I -> Interface Segregation Principle
* D -> Dependency Inversion Principle

## Single Responsibility Principle - Principio de Responsabilidad Unica.

* Variación de Cohesión. Cada clase debería tener una única responsabilidad, y así será mas fácil de mantener. 
* Cohesión -> El grado en que el contenido de un modulo esta relacionado entre si. (Si el modulo tiene 1 sola responsabilidad, la cohesión es alta).
* Mantebilidad y Reusabilidad. 
* "Una clase debería tener 1 sola razón para cambiar".
* En un mismo método mezclamos lógica de negocio y lógica de presentación -> Violación de cohesión. Se deberían crear 2 clases diferentes para cada responsabilidad diferente. 

## Open Closed Principle

* Estamos diseñando un sistema que será modificado en el futuro.. ¿Nuestro diseño puede recibir cambios o ser extendido?. 
* Nuestras entidades (Clases, módulos, etc..) deben ser abiertas para extenderse pero cerradas para ser cambiadas. No se debe modificar el código ya existente en la extensión. 
* Por ejemplo, si tenemos la entidad Pintor, que debe pintar figuras, y cada figura se pinta de manera distinta, nos conviene extender cada figura a una clase figura general, y que la misma tenga un método abstracto que sea "pintar()" para que cada una de las figuras la implemente a su manera en la clase. 

```
interface Figura{
void pinta();
}

-----------------------------

class Cuadrado implements Figura {
  @Override
  public void pinta(){
  //Como pintamos el cuadrado
  }
}

---------------------------------
class Circulo implements Figura {
  @Override
  public void pinta(){
   //Como pintamos el circulo
  }
}
```



## Liskov Substitution Principle 

* `T obj = new T();` y `T obj = new S()`, S seria un subtipo de T. Todas las propiedades que el programa requiere de T, también se deberían cumplir en S.   
* `Integer[] array` y `Object[] arrayObjects` <- Alguno es subtipo del otro? Integer[] es subtipo de Object[], es por eso que a un array de obj podemos asignarle un array de Integers, pero con esto, no podemos meter Strings, ya que el array Integer[] sigue sin aceptar estos tipos de datos. 

```
Date date = new Date();
Timestamp ts = new Timestamp (date.getTime());

System.out.println(date.equals(ts)); //True, Date es igual a Timestamp
System.out.println(ts.equals(date)); //False, Timestamp no es igual que date
```

## Interface Segregation Principle

```
public class Comunicador { //Podemos enviar mensjaes o objetos genericos a otro sistema
public void enviaMensaje(String mensaje){}
public void enviaMensaje(Object object){}
}
```

Pero, al cliente le sale otro requisito, comunicarnos igual pero con niveles de encriptación

```
enum Encriptacion {
//NIVELES DE ENCRIPTACION
NINGUNA, ENCRIPTACION_DEBIL, ENCRIPTACION_FUERTE
}

public class Comunicador {
//el cliente puede fijar el nivel de encriptacion deseado
public void setEncriptacion (Encriptacion encriptacion){}
public void enviaMensaje(String mensaje){}
public void enviaMensaje(Object object){}
}
```

Un día nos damos cuenta de que el cliente esta usando directo la clase, el cliente debe depender de abstracciones.

``` 
public class ComunicadorImplementacion implements Comunicador {}
```

Si viene un cliente nuevo, por ahí, quiere enviar mensajes pero sin encriptación. ¿El cliente debería saber la existencia de la encriptación si no la necesita? **Los clientes no deben ser forzados a depender de métodos que ellos no usan** . La idea es separar la interface original en 2 componentes. 

```
public class Comunicador { //Podemos enviar mensjaes o objetos genericos a otro sistema
public void enviaMensaje(String mensaje){}
public void enviaMensaje(Object object){}
}
```

```java
public interface Encriptable {
static enum Encriptacion{
NINGUNA, DEBIL, FUERTE
}
public void setEncriptacion (Encriptacion nivel);
}
```

Y ambas las implementamos así..

 ```java
public class Comunicador { //Podemos enviar mensjaes o objetos genericos a otro sistema
public void setEncriptacion (Encriptacion nivel){}
public void enviaMensaje(String mensaje){}
public void enviaMensaje(Object object){}
}
 ```

## Dependency Inversion Principle

* ¿Inversión? Se apunta a tener una relacion de dependencia inversa a la tradicional (Tarea compleja segregada a tareas menos complejas, se crean módulos que son dependientes de los mas generales).
* Las dependencias deben ser de lo mas especifico a lo mas general. Ambos módulos deben depender de abstracciones, que no deben depender de los detalles, si no que estos deben depender de las abstracciones. Los high level no deberían depender de los low level. 
* Lógica de Negocio -> Api Operaciones Básicas (Y no depender directamente de las operaciones básicas).
  Operaciones básicas -> Api Acceso .
  Acceso.

# Patrones de Diseño

* Estos conceptos nacen de un libro de diseño de Arquitectura, "A pattern Language". Se escribió otro libro luego, pero ya referido a Programación, con ejemplos en C++, con distintos patterns, o soluciones a problemas. 

* Es como una receta. La descripcion de un problema recurrente y su solucion. 

* Estudio de los lenguajes -> Vocabulario, Gramática y Sintaxis (Estructura de las oraciones). 

* **Creational (Factory, Abstract Factory y Singleton)**, **Estructurales (Decorator)** y de **Comportamiento (Strategy)** son los tipos de patterns que se establecieron, con 23 patrones en cada categoría. 

* Supongamos que queremos hacer una maquina de reconocer monedas, ponemos monedas y la maquina reconoce el valor de la misma. Podemos construir un solo componente que identifique los tamaños de todas las monedas de distinto valor, y si no es aceptada, se devuelve. Esto nos daría los siguientes problemas -> 

  * Sera difícil de reusar.
  * Responderá mal a los cambios (Y si cambian las monedas?).

  Entonces en lugar de hacer una maquina que reconozca todas las monedas, hacemos una maquina que reconozca un solo tipo de moneda. Si la rechaza, la pasa a la proxima maquina, y asi sucesivamente, si es rechazada por todas, la moneda es rechazada y devuelta. Esto hace que sea:

  * Mantenible.
  * Reusable.

# Principios Orientación a Objetos

Es un paradigma de programación, un estilo de programación. El clásico es el procedural, una instrucción tras otra, y nada mas, con funciones y datos. en POO nos concentramos mas en pensar en objetos, en vez de pensar en funciones pensamos en interacciones. Nos abstraemos mas. 

* **Objeto** -> Conjunto de métodos y atributos. Su construcción depende del problema a solucionar (Modelado de datos). La definición global de objeto es **Clase**. 

  ```
  class Animal {
  protected edad;
  constructor(edad){
  this.edad = edad;
  }
  envejecer(){
  this.edad += 1;
  }
  
  }
  
  //Ambos son animales pero son independientes entre si
  const perro = new Animal(2);
  const gato = new Animal(3);
  
  ```

## Encapsulación - Encapsulamiento.

* Cada objeto es responsable de su informacion y estado. La unica manera de modificar algo de la misma, es mediante los metodos propios del objeto.
* Los atributos internos del objeto deberian ser inaccesibles. Deberian manejarse mediante getters y setters. 

## Abstracción.

* Debemos pensar en los objetos como cajas negras. No nos interesa como se comportan de forma interna, solo sabemos como interactuar con ellos. 
* Somos libres de cambiar la implementacion.
* Abre las puertas al TDD.

## Herencia

* Reutilizacion. Definimos relaciones jerarquicas entre clases, ciertas cosas pueden ser reutilizadas. Un animal acuatico es un animal pero puede tener otras cosas distintivas. 

```
class AnimalAcuatico extends Animal{
 protected numeroAletas;
 nadar(){}
}
```

## Polimorfismo

* Procesar objetos de distintas maneras. Un animal acuático no se mueve igual que uno terrestre. 
* 



