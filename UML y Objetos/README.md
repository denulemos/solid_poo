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
* Son funciones que reciben argumentos de entrada y pueden devolver una sola cosa, o ninguna (En Phyton, o en Golang, se pueden devolver varias). Los metodos tienen una **firma**, es como defino al metodo, en conjunto con sus parametros.

```java
public int Metodo(int parametro, int parametro2)
```


#### Lenguaje de modelado

* Conjunto de señales que dan a entender algo
* Posee elementos y reglas sintacticas
* Expresa ideas mediante modelos

#### Modelo de Analisis y diseño

* Modelo: Cuerpo de informacion recabado sobre un sistema para estudiarlo
* Se necesita al modelo cuando no se puede estudiar al sistema por si mismo por complejidad, tamaño, etc

# Concepto de Objetos 🚀️

Es un paradigma de programación, un estilo de programación. El clásico es el procedural, una instrucción tras otra, y nada mas, con funciones y datos. en POO nos concentramos mas en pensar en objetos, en vez de pensar en funciones pensamos en interacciones. Nos abstraemos mas.

* **Proceso de Abtraccion** : La idea es buscar objetos de la vida real, y reconocer sus responsabilidades y caracteristicas, es el clasificarlos.
* **Responsabilidad del Objeto ¿Que sabe hacer?**: Una vez descubierto el objeto, debemos reconocer que puede o que deberia hacer el mismo. Estas responsabilidades/habilidades terminaran siendo **metodos**.

```* **Visibilidad** : Esto es valido para los metodos, no se recomienda para los atributos (Se recomienda tenerlos de manera privada para cumplir con el **encapsulamiento**).

## Clase y Objeto

Una clase es una plantilla de una coleccion de objetos parecidos, con nombre, atributo y metodos.

#### Objeto

Conjunto de métodos y atributos. Su construcción depende del problema a solucionar (Modelado de datos). La definición global de objeto es **Clase**.

```java
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

Los objetos son instancias de una clase especifica, heredan sus atributos y las operaciones para manipular estos atributos.

Por ejemplo la clase Persona con los atributos Nombre, Apellido, y los metodos Trabajar(), Comer(), etc..

## Clasificacion

* Los sustantivos se vuelven clases, los verbos metodos y los adjetivos identificados son atributos
* Las clases se agrupan por funcionalidad creando jerarquias
* Se identifican tambien la relacion entre clases.
* Se debe lograr una estructura clara, y una buena separacion de responsabilidades.
* Se deben tener claros los patrones jerarquicos entre clases y flujo de los mensajes.

## Encapsulamiento y Ocultamiento de Info 👀️ 

* Cada objeto es responsable de su informacion y estado. La unica manera de modificar algo de la misma, es mediante los metodos propios del objeto.
* Los atributos internos del objeto deberian ser inaccesibles. Deberian manejarse mediante getters y setters.

#### Privada

Info que necesita el objeto para operar. No es util para nadie más

#### Publica

Es info que necesita el resto de objetos para interactuar con mi objeto

#### Protegida

La info que necesitan las clases heredadas

## Abstracción. 👀️

* Debemos pensar en los objetos como cajas negras. No nos interesa como se comportan de forma interna, solo sabemos como interactuar con ellos.
* Somos libres de cambiar la implementacion.
* Abre las puertas al TDD.

## Retencion de estado

La informacion de un objeto se mantiene en el mismo estado hasta que este sea alterado por las operaciones que fueron hechas para tal fin.

## Herencia 👀️

* Permite construir una clase (subclase) a partir de otra clase (superclase), la subclase, entonces, heredara todos los atributos y metodos de la superclase.
* Si dos clases son subclases de la misma superclase, ambas clases estan en una misma **jerarquia** en el **Arbol de herencia**.
* Un animal acuatico es un animal pero puede tener otras cosas distintivas.

```java
class AnimalAcuatico extends Animal{
 protected numeroAletas;
 nadar(){}
}
```
* **Herencia Simple** -> Una clase solo puede tener una sola superclase directa. (Caso Java), pero, se pueden tener muchas superclases indirectas, todo esto, hasta llegar a la clase `Object`, la clase base de donde heredan todas las clases.
* **Herencia multiple** -> Esto se puede hacer desde Phyton, se puede heredar de varias clases, pero, esto da a un problema, ya que si esas super clases comparten los mismos atributos y/o metodos, la subclase solo podra heredar de una de ellas.

#### Generalizacion y Especializacion.

Las clases mas altas en el arbol de herencias, son las clases mas **genericas**, y las clases mas bajas en la misma, son clases mas **especializadas**.

* Cuando se sube en el arbol de herencia, se llama **Generalizacion**
* Cuando se baja, se llama **Especializacion**

#### Sintaxis

* Definir una subclase -> `class Subclase extends SuperClase`
* SIEMPRE hay un extends en todas las clases. Por default es -> `class SubClase extends Object`, apunta a la raiz jerarquica de todas las clases.

#### Miembros heredados

* Se le dice **miembros** a todos los elementos que son heredados, como los metodos y atributos de la Super clase.

La subclase hereda:

* Metodos
* Atributos
* NO hereda al constructor.
* NO puede acceder a los miembros **private**, solo puede acceder directamente a los miembros **public y protected**. Si estan ambos en el mismo paquete, tambien tiene acceso a los miembros **default**.
* Esto se hace ya que, si la subclase pudiera acceder a los miembros privados de la superclase, creariamos subclases para acceder facilmente, y esto violaria el **principio de encapsulamiento**, solo se puede acceder a los mismos mediante los `Getter` y `Setter` publicos de la superclase.

#### Acceso a los atributos

Por ejemplo, tenemos la siguiente superclase:

```java
public class Superclase {
public String atributoPublic = "atributoPublic";
String atributoDefault = "atributoDefault";
protected String atributoProtected = "atributoProtected";
private String atributoPrivate = "atributoPrivate";

}
```
La subclase debera tener la siguiente estructura:

```java
public class Subclase extends Superclase {
public String atributoPrueba;

   public Subclase() {

     // Acceso permitido. 

       atributoPrueba = atributoPublic;

       atributoPrueba = atributoDefault;

       atributoPrueba = atributoProtected;

       // Acceso no permitido. Se produce un error de compilación:

       // Variable atributoPrivate in Superclase not accessible from Subclase

       atributoPrueba = atributoPrivate;

   }

}
```
#### Acceso a los metodos

Tendriamos la siguiente SuperClase:

```java
public class Superclase {

   public void metodoPublic() {...}

   void metodoDefault() {...}

   protected void metodoProtected() {...}

   private void metodoPrivate() {...}

}
```
La subclase deberia tener esta estructura:

```java
public class Subclase extends Superclase {

   public void pruebaDeAccesoAMetodos() {

       // Acceso permitido.

       metodoPublic();

       metodoDefault();

       metodoProtected();

       // Acceso no permitido. Se produce un error de compilación:

       // No method matching metodoPrivate() found in Subclase

       metodoPrivate();

   }

}
```
#### ¿Y si tengo atributos con el mismo nombre entre sub y super?

Si la subclase posee un atributo con el mismo nombre de un atributo de la superclase, esta, quedara oculta para la subclase, es decir, la subclase solo podra acceder a su propio atributo.
Podra acceder a ese mismo atributo de la superclase mediante `super`.

Por ejemplo, tenemos la siguiente superclase:

```java
public class ClaseA {

   protected int x = 1;

   public int getX() { return x; }

   public int get10X () { return 10 * x; }

}
```
Creamos una subclase que declare una variable con el mismo nombre, pero con distinto valor, y los mismos metodos.

```java
public class ClaseB extends ClaseA {

   private int x = 5;

   @Override

   public int getX() { return x; }

   public int getSuperX() { return super.x; }

}
```
Entonces, al momento de llamar a estos atributos y metodos desde el main..

```java
public class Test {

   public static void main(String [] args) {

       ClaseB objetoClaseB = new ClaseB();

       // Accede al atributo x declarado en ClaseB (devuelve 5)

       System.out.println(objetoClaseB.getX());

       // Accede al atributo x declarado en ClaseA al usar super (devuelve 1)

       System.out.println(objetoClaseB.getSuperX());

       // Accede al atributo x de la ClaseA sin usar super (devuelve 10)

       System.out.println(objetoClaseB.get10X());

   }

}
```
#### Redefinicion y Sobrecarga

Redefinir un metodo es volver a escribirlo con la misma firma en la subclase, pisando a la superclase.
**En java, la firma del metodo NO incluye al tipo de dato que devuelve**

* **Sobrecarga** -> Definir un metodo con la misma firma pero con distinta cantidad de
  parametros de entrada. Un ejemplo, son los constructores por defecto y con parametros.
* **@Override** -> Es una anotacion que no se compilará, si no que le indica al compilador que un metodo heredado esta siendo sobreescrito.

## Polimorfismo 👀️

Una clase puede comportarse de distinta manera dependiendo de como recibe las cosas.

* El polimorfismo es la principal aplicacion de la Herencia, es el principal motivo de las clases Abtractas.
* Tambien conocido como **Ligadura Tardia / Late Binding**, esta ligadura se produce en tiempo de ejecucion.
* "Mismo mensaje, distinta implementacion"
* Consiste en implementar/reemplazar el metodo de una clase con otro metodo con la misma firma pero escrito en otra clase.
* Procesar objetos de distintas maneras. Un animal acuático no se mueve igual que uno terrestre.

#### ¿Qué necesito?

* Que las clases implicadas tengan declaradas de forma directa o indirecta, un metodo con la **misma firma**
* Que la variable que guarde el objeto sea de la clase de **mayor jerarquia** entre todas (La que muchos objetos tengan en común)
* Que no sea un metodo de clase (`static`)
* Que no sea privado, porque no se puede heredar
* Que no haya sido declarado `final` ya que no podrá ser definido
* Los objetos que se usan de forma poliformica deben **saber responder al mensaje que se les envia**

#### Upcasting

```java
Perro fido; //Fido es una subclase de mascota
Mascota a;
fido = new Perro("Fido", "Bull Dog"); //Declaramos un nuevo perro
a = fido; //Asignamos a la variable mascota a Fido, un perro
```
Con esto, solo podremos acceder a los atributos y metodos de la clase asociada, por ejemplo:

* `a.getNombre()` y `fido.getNombre()` -> Devolveran fido.
* `a.getRaza()` -> NO es valido, ya que `getRaza` no forma parte de la clase animal.
* `fido.getRaza()` -> SI es valido, ya que `getRaza` si forma parte de la clase perro.

#### Downcasting

```java
Perro fido;
Mascota a;
Perro mismoFido;

fido = new Perro("Fido", "Bull Dog");
a= fido;
mismoFido = (Perro) a;
```
* Puede suceder un error cuando la clase a la que pertenece el objeto no coincide con el puntero, para eso, usamos el  `instanceOf()`
  ```java
  if (a instanceof Perro){ //Si a es una instancia de Perro
  mismoFido = (Perro) a;
  }
  ```

#### Ejemplos de uso

El dueño de una veterinaria tiene lugar para alojar hasta 5 mascotas que ofrece a quienes quieran adoptarlos. Hay Perros y Gatos. Cuando alguien viene a elegir una mascota, le pide a cada uno que haga un saludo como sabe hacerlo.

* Metodos constructores del metodo `saludar()`

**Clase Mascota**

```java
public abstract class Mascota {
protected String nombre;

Mascota (String nom){
nombre = nom;
}

public abstract void saludar();

public String getNombre(){
return nombre;
}

}
```
**Clase Perro**

```java
public class Perro extends Mascota{
private String raza;

Perro(String nom, String raza){
super(nom);
this.raza = raza;
}

public void saludar(){
System.out.println("Wof");

}

public String getRaza(){
return raza;
}

}
```
**Clase Gato**

```java
public class Gato extends Mascota {
 Gato(String nom){
super(nom);
}

public void saludar(){
System.out.println("Miau");

}
}
```
* Metodo `darBienvenida()` que le pida a cada mascota que salude

```java
public class Veterinaria {
Mascota[] mascotas = new Mascota[5];

Veterinaria(){
mascotas[0] = new Perro... (Creamos a todas las mascotas en la lista)
}

public void darBienvenida(){
for (Mascota mac : mascotas){
mac.saludar();
}
}

}
```
* Metodo `mostrarRazas()` que muestre las razas de los perros.

```java
public void mostrarRazas(){
Perro p;
for (Mascota mac : mascotas){
if (mac instanceof Perro){
System.out.println(mac.getRaza());
}
}

}
```
#### Sobrecarga

Se modifica la firma del metodo pero el comportamiento es el mismo

#### Sobreescritura

Es la misma firma pero el comportamiento es otro

## Generalizacion

Es un caso particular de herencia que consiste en la relacion entre una clase general y sus clases hijas. Por ejemplo, la clase general Animal y las clases especificas Gato, Perro..
