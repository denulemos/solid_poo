# Patrones de Diseño ❤️

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

# Patrones Creacionales ❤️

## Abstract Factory Pattern

Nos ayuda cuando queremos crear colecciones de clases pero sin especificar el tipo de clase a usar.
Supongamos que necesitamos una aplicacion que necesita el acceso a una base de datos relacional. Queremos organizar bien las consultas, tenemos la clase `RepositorioAlumnosRelacional` hecha especificamente para consultar a los Alumnos, y nada mas, sin especificar la tecnologia.

```java
public interface RepositorioAlumnos {
 public List<String> listaAlumnos();
}
```

```java
public class RepositorioAlumnosRelacional implements RepositorioAlumnos {
@Override 
public List<String> listaAlumnos(){
return Arrays.asList("Alumno Relacional");
}

}
```

Si queremos acceder a los datos...

`RepositorioAlumnos repositorioAlumnos = new RepositorioAlumnosRelacional();`

Pero, supongamos que el cliente luego quiere usar una base de datos no relacional, esto hace que nuestra implementacion actual no sirva. Tendriamos que hacer un `RepositorioAlumnosNoSQL`. Necesitariamos que nuestra aplicacion, dependiendo de donde se ejecute, use la implementacion relacional o la no relacional.

Para estos casos, este patron de diseño nos sirve. Nos propone **una interface para crear familias de objetos relacionados o dependientes (los repositorios) sin especificar su clase concreta**.

```java
public interface AbstractFactory{
  RepositorioAlumnos createRepositorioAlumnos();
}
```

Usamos la interfaces como retorno. Y ahi, hacemos 2 factory, una relacional y otra no relacional. Por ejemplo, la relacional quedaria..

```java
public class FactoryRelacional implements AbstractFactory{
@Override 
public RepositorioAlumnos createRepositorioAlumnos(){
return new RepositorioAlumnosRelacional();
}
}
```

* Simplificamos el codigo.
* Mas posibilidad de extension del sistema.

## Patron Builder

Necesitamos una clase Persona con nombre, edad, ambos deben ser obligatorios. Creamos un constructor con ambas propiedades:

```java
private String nombre;
private int edad;

public Persona(String nombre, int edad){
this.nombre = nombre;
this.edad = edad;
}
```

Tambien necesitamos el municipio, pero esta propiedad es **opcional**. Entonces, lo primero que nos surge, es hacer 2 constructores distintos:

```java
private String nombre;
private int edad;
private String municipio;

public Persona(String nombre, int edad){
this.nombre = nombre;
this.edad = edad;
}

public Persona(String nombre, int edad, String municipio){
this.nombre = nombre;
this.edad = edad;
this.municipio = municipio;
}
```

Tambien agregamos que si es menor de edad, es obligatorio donde estudia, de lo contrario, el trabajo. Para esto tendriamos que crear demasiados constructores.
La idea es que, para la construccion de objetos complejos, separemos al constructor de su representacion (la clase persona). Debemos crear una nueva clase cuya unica responsabilidad sea la de crear Personas.

* El constructor debe ser private.
* Vamos a crear el Persona.Builder, solo desde ahi podemos crear a una persona de la siguiente manera:

```java
Persona madre = new Persona.Builder("Maria").setMunicipio("Ciudad").setMayor(45, "Amazon").build();

Persona hijo = new Persona.Builder("Pepe").setMenor(4, "Colegio X").build();
```

El nombre es obligatorio, el municipio es opcional (Puede tener o no el setMunicipio()) y los metodos especificos por persona (setMenor o setMayor).
El builder seria el siguiente:

```java
public static class Builder {

private Persona persona;

public Builder (String nombre) {
persona = new Persona();
persona.nombre = nombre;
}
}
```

## Recoleccion de Basura 👀️

* Es la tecnica por la cual el entorno de objetos destruye de forma automatica, desvinculado la memoria usada para ello, los objetos que no tienen ninguna referencia a ellos. El programador no se preocupa por la liberacion de memoria.
* Esto no existe en C++ ni en Object Pascal.

# Inyección de Dependencias en Java ❤️

## Qué es una dependencia?

* Cuando A usa cualquier metodo de B, podemos decir que B es una dependencia de A.

  ```java
  class ClassA {

    ClassB classB = new ClassB(); //A crea una instancia de B

    int tenPercent() {
      return classB.calculate() * 0.1d; //Reutiliza un metodo de B
    }
  }
  ```

  Esto nos da un problema. Si necesitamos reemplazar B con C, hay que recompilar A porque no tenemos manera de cambiar esa dependencia, ya que esta codificado dentro de A.

## Principio de Inyección de Dependencias

* Es el poder inyectar las dependencias cuando sea necesario en lugar de inicializarlas en la clase A.
* Para esto nos conviene **Inyectar desde el constructor** de la siguiente forma:

```java
class ClassA {

  ClassB classB;

  /* Constructor Injection */
  ClassA(ClassB injected) { 
    classB = injected;
  }

  int tenPercent() {
    return classB.calculate() * 0.1d;
  }
}
```

Sigue habiendo una fuerte dependencia, pero ahora se puede inyectar desde afuera usando un constructor

```java
class Main {
  public static void main(String... args) {
    /* Notice that we are creating ClassB fisrt */
    ClassB classB = new ImprovedClassB();

    /* Constructor Injection */
    ClassA classA = new ClassA(classB);

    System.out.println("Ten Percent: " + classA.tenPercent());
  }
}
```

Esto hace que:

* La funcionalidad se mantenga intacta a diferencia de si hacemos la inyeccion por Setter.
* Se elimina la inicializacion en A.
* Podemos inyectar una subclase especializada en A.
* El compilador nos pedira las dependencias necesarias al compilar.
