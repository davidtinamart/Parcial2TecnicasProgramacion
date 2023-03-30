# Ejercicio 3 (0.5 puntos): 5 minutos.
#### ¿Qué es la visibilidad de una variable o un método? ¿Qué tipos hay? ¿Cuándo debe utilizarse cada tipo?

La visibilidad en programación se refiere a la capacidad de acceder a una variable o método desde diferentes partes del programa. En general, hay cuatro tipos de visibilidad en la programación orientada a objetos: public, private, protected y package-private (también conocido como default).

* Public: Las variables y los métodos públicos pueden ser accedidos desde cualquier parte del
  programa, incluso desde fuera de la clase donde se definen. Este tipo de visibilidad se
  utiliza para elementos que deben ser accesibles para otros objetos del programa.

* Private: Las variables y los métodos privados solo pueden ser accedidos desde dentro de la clase
  donde se definen. Este tipo de visibilidad se utiliza para elementos que solo deben ser utilizados
  dentro de la clase, y no deben ser accesibles desde otras partes del programa.

* Protected: Las variables y los métodos protegidos solo pueden ser accedidos desde dentro de la
  clase donde se definen, y también pueden ser accedidos desde dentro de las clases que heredan de
  esta clase. Este tipo de visibilidad se utiliza para elementos que deben ser accesibles desde
  clases hijas, pero no desde otras partes del programa.

* Package-private (Default): Las variables y los métodos package-private solo pueden ser
  accedidos desde dentro del paquete donde se definen. Este tipo de visibilidad se utiliza
  para elementos que deben ser accesibles solo dentro del paquete.

La elección del tipo de visibilidad depende del diseño de la aplicación y de la necesidad
encapsulación de los elementos. En general, se recomienda utilizar la visibilidad más restrictiva
posible para evitar que los elementos sean accedidos de forma inadecuada y asegurar una mejor
encapsulación del código.