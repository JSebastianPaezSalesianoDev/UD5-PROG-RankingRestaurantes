# Manual de progamacion

Este manual esta especialmente dirigido para aquellos que conocen y estan interesados en como fue hecho el proyecto y su respectivo codigo.

## Paquetacion
![Paquetacion](/docs/img/paquetacion.png)

Esta paquetacion esta distribuida dentro de la empresa de RipAdbaisor, y dividida en 3 ramas, la auxiliar, la rama donde se manejan las excepciones, la rama de gestion donde se gestionan los metodos y por ultimo la rama donde tendremos la informacion que usaremos de los restaurantes. Tambien tenemos una carpeta docs donde almacenaremos toda la informacion necesaria para la comprension del proyecto por todas las partes involucradas

## Auxiliar

En esta rama comenzaremos con nuestra clase


### **Menu** 

Esta clase bastante simple contendra un unico metodo estatico que nos dejara imprimir el menu mas adelante

![menu](/docs/img/menu.png)

### **Validador String y Double**

Estas dos clases compararan que no se ingrese un String vacio y de ser asi lanzaran la excepcion creada en nuestra clase InputInvalidoException

![validador string](/docs/img/validarString.png)


Mientras que nuestro validador de double, lanzara el throw exception siempre que se ingrese un cero o un caracter no numerico mediante la posibilidad de poderlo parsea, de no poderse lanza throw.

![alt text](/docs/img/validarDouble.png)

## Excepciones

En esta carpeta, tenemos nuestra clase unica InputInvalidoException quien se encargara de encontrar los errores tras no ingresar nada o ingresar un espacio vacio


### **InputInvalidoExcepcion**

![clase Exception](/docs/img/exception.png)

Esta clase heredara de la clase padre Exception, por ello su constructor iniciara el mensaje de alerta con un super

Luego construimos un metodo estatico que recibe un String y revisa que no sea nulo y o vacio, y si lo es, lanza el throw creado anteriormente.

## Gestion

Esta clase se encargara de gestionar los metodos necesarios para que el menu y sus opciones sean posibles

### **Añadir un restaurante**

![alt text](/docs/img/añadirRest.png)

En este metodo que devolvera un objetivo del tipo restaurante, creada variables con la informacion necesaria, y mediante la libreria swing y usando JOptionpane lanzara una box input que nos permitira ingresar los valores y los almacenara en las variables ya mencionadas. luego creada un objeto tipo restaurante con esta informacion. dado que el input solo recibe strings, parsearemos cualquier valor numerico. Al final si no hay ningun problema con las validaciones vistas antes en las clases auxiliares, se creara el objeto y se almacenara en una arraylist mediante el metodo .add dado que un restaurante puede tener diversas cadenas y dominios, no hay validador de no repetir nombres. (no es que me diera pereza hacerlo)

### **Editar la informacion de un restaurante**

![alt text](/docs/img/editarRestaurante1.png)

en este apartado pediremos el nombre del restaurante a editar mediante el JOption. luego con un for each buscaremos comparando el nombre ingresado, con los nombres de los restaurantes en el arraylist mediante equalignorecase y el metodo de acceso de cada restaurante definido en la clase [restaurante](/src/net/ripadbaisor/restaurante/Restaurante.java) y pediremos una opcion al usuario una vez visto las opciones se le ingresara mediante otro input

![alt text](/docs/img/editarRestauranteSwitch.png)

De manera Sencilla y al igual que en añadir restaurante, pediremos segun la opcion de usuario la informacion a modificar, guardandola en una variable, y luego mediante nuestro metodo de acceso setter de la clase restaurante, le ingresaremos su nueva informacion.

### **Mostrar Restaurante**

Mediante un metodo de dudosa procedencia, parecido al metodo para arrays tipo arrow de js sort, el metodo funciona de la siguiente manera: 
ingresaremos el nombre de nuestro arraylist, luego dos parametros que seran objetos tipo restaurante, el tipo de variable, y por ultimo los valores a comparar. de esta manera dejara el arrayList totamente ordenado

![alt text](/docs/img/editarUsUlt.png)

### **Eliminar restaurante**

Pide una opcion al usuario mediante el JOption, con un for i que recorre el arrayList del final hacia delante (de esta manera evitamos problemas cuando se modifiquen las posiciones) el nombre del restaurante ubicado en el indice ingresado sera removido, dejando el espacio vacio y corriendo el resto de objetos del removido hasta el final, un espacio a la derecha

## Restaurante

En esta rama se crearan variables con la informacion necesaria para la creacion de nuestros objetos tipo restaurantes, luego un constructor que los incialize, metodos de acceso para acceder a los mismos, y un override que sobreescriba el espacio en memoria hash y nos permita imprimir mediante un toString la informacion en idioma humano.

![alt text](/docs/img/restaurante1.png)
![alt text](/docs/img/restaurante2.png)


## Clase ejecutable

Esta clase se encargara de llamar todos los metodos y al menu, para dejar elegir al usuario.


Utilizara un booleano que se declara como verdadero, luego creamos un objeto de tipo gestor para llamar nuestros metodos, un bucle while que se repetira siempre que nuestro booleano sea true, cosa que pasara al menos que le indiquemos lo contrario, y finalmente el switch que intercalara entre los diferentes metodos segun la respuesta ingresada por el usuario, en el primer metodo pusimos un try catch como prevencion de errores.

![alt text](/docs/img/ejecutable.png)


eso fue todo bendiciones.