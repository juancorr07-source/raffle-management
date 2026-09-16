# raffle-management
Solución al problema de diseño e implementación del manejo de una rifa usando programación orientada a objetos.

# Nombre del proyecto
Manejo de las ventas de una rifa.

## Autor
Juan José Correa

## Descripción

Este conjunto de clases se realizaron con el fin de poder manejar las ventas de una rifa tomando en cuenta el comprador, vendedor, y si la boleta comprada ya fue pagada o está pendiente de pago.

Este pequeño proyecto contiene en total 7 clases, 5 de ellas públicas y 2 de ellas enumeraciones:

### Enumeraciones

PayState: define las 2 constantes de pago: PAID, que indica que la boleta ha sido pagada y PENDING que indica que la boleta aún no ha sido pagada.

PayMethod: indica las dos constantes del método de pago entre CASH que es efectivo y TRANSFER como transferencia bancaria que viene acompañada de una referencia.

### Clases principales

Person: es la clase que recibe un nombre de tipo String para definir el nombre del comprador y el vendedor de cada boleta.

Number: es la clase que representa cualquiera de los números de la rifa, independientemente si ya fueron vendidos o no.

Sale: es la clase que representa la venta de cada boleta junto el vendedor, comprador, número vendido y si ya fue pagada. Tambíen permite revisar si alguna boleta ya ha sido pagada con isPaid() y registrar una venta con registerPayment(). También ayuda a revisar quien vendió o compró cierto número, y también el vendedor que más boletas ha vendido.

Payment: es la clase que nos ayuda a registrar los pagos, ya sean en efectivo o una transferencia que venga acompañada de una referencia, y también revisar los pagos que estén pendientes.

Raffle: es la clase principal que maneja toda la rifa. Es la clase que contiene el arreglo con los 100 números por vender lo cual prepara la memoria para registrar las ventas.
Es la clase que permite revisar si la venta de un número es válida verificando si está disponible o ya fue vendido.
Procesa pagos que estén pendientes y marca los que ya están pagados con su medio de pago correspondiente.
Permite consultar información como los números vendidos, los números disponibles, los vendedores, compradores, etc.
También es la clase que genera listas y estadística, filtrando información para obtener números disponibles, los compradores con pagos pendientes, la cantidad total de boletas vendidas, el total de ventas realizadas por un vendedor, etc.

Main: es la clase donde se realiza el ensayo de todas las clases. Se registran ventas pagadas, pendientes de pago y un pago por trasnferencia con su referencia, también se intenta vender un número ya vendido.
Se consulta las ventas ya realizadas con sus respectivos datos y se muestran las estadísticas respecto a las ventas hechas, los números vendidos y la cantidad de números disponibles. 

## Diagrama de clases

El diagrama se encuentra en `docs/class-diagram.png`.

## Compilación

```bash
javac -d out src/*.java
```

## Ejecución

```bash
java -cp out NombreDeLaClase
```
## Problemas y deficiencias de la app
