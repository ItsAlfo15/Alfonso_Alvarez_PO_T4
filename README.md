# FERNANSHOP

# Práctica Obligatoria Tema 4

![Captura de pantalla 2025-01-07 182103](https://github.com/user-attachments/assets/d44b300e-9a26-4e14-845a-66a63b4d48c3)

## Por Alfonso Álvarez Ocaña

## Índice
- 1.- Introducción
- 1.1. Nuevos Cambios e Implementaciones.
- 1.2.- Diagrama UML
- 2.- Pre-requisitos
- 3.- Instalación
- 4.- Descarga del programa
- 5.- Ejecución del programa
- 6.- Menú principal
- 6.1.- Registro
- 6.2.- Inicio de sesión 
- 7.- Funcionalidad del programa
- 7.1.- Menú de cliente.
- 7.2.- Menú de Administrador.
- 7.3.- Menú de trabajador.
  
   
### 1. Introducción

<p>Este programa se basa en una tienda online en la que hay tres apartados diferentes, (Cliente, Administrador, Trabajador), el primero es el cliente que es el que puede realizar pedidos, una vez realizado un pedido pasamos al administrador que es el que asigna ese pedido a un trabajador, el trabajador una vez recibido el pedido puede cambiar el estado de este, así como poner un comentario y cambiar la fecha de entrega estimada del pedido. Tanto el cliente como el trabajador pueden consultar y cambiar sus datos personales, asi como ver sus pedidos, el administador si lo desea tambien puede cambiar los datos de un pedido, asi como dar de alta a un nuevo trabajador, siempre y cuando haya suficiente espacio como para asignar uno nuevo, tamnien puede consultar información de todos los pedidos realizados, todos los clientes regisytrados y todos los trabajadores dados de alta.</p>

1.1.- Nuevos Cambios e Implementaciones.

- Ahora el código del pedido no se genera con un contador, sino que ahora se genera aleatoriamente entre un número del 1 al 100.000, este código nunca se repite
- Ahora un usuario no podrá registrarse con un correo ya existente y todas las peticiones de datos en el registro están validadas.
- Ahora una vez que el usuario se registra deberá validar su correo electrónico con un token que se le enviará al correo. Este token se generará de forma aleatoria con una longitud de 8 carácteres compuestos de números y letras mayúsculas.
- Si un usuario quiere cambiar su correo electrónico deberá validarlo nuevamente, en caso de que el token introducido sea incorrecto no se realizará el cambio de correo.
- Se ha introducido un sistema de control de excepciones para que el programa no colapse en tiempo de ejecución.
- Se han añadidio nuevas funciones y algunos métodos al main, también se han añadido nuevos métodos en las clases para realizar los cambios anterioes.
- Cuendo un cliente realiza un nuevo pedido y se asigne a un trabajador, el trabajador recibirá un mensaje a telegram y un correo electrónico en el que se detallarán los datos del pedido asignado.
- Cuando un pedido sea modificado bien por el Administrador o por el trabajador, el cliente asociado a ese pedido recibirá un correo electrónico indicando que su pedido ha sido modificado y mostrándoselo al cliente.
- También se han añadido atributos faltantes como fechaPedidoEstimada en la clase Pedido.
  
1.2.- Diagrama UML (Actualizado)

![Alvarez_Ocaña_Alfonso_UML_PO_T3 drawio](https://github.com/user-attachments/assets/674d68d9-1997-4a07-9570-c11ef0823a9a)

### 2. Pre-requisitos
Para poder ejecutar el programa primero se deberá tener instalada la última versión del JDK, accediendo al siguiente enlace.
<p>https://www.oracle.com/cis/java/technologies/downloads/#java23</p>

<p>Se deberá elegir la opción compatible con tu dispoditivo.</p>

![image](https://github.com/user-attachments/assets/6a0e97e5-86ab-4ac6-bcd3-eb17208792f2)

### 3. Instalación
Una vez elegida la opción compatible, la descarga comenzará automaticamente, cuando se descargue, al instalarlo se deberá verificar que la ruta de instalación sea (C:\Program Files\Java) y luego continuar con los pasos que te indique el instalador.

### 4. Descarga del programa
- Para descargar el programa, accederemos al enlace proporcionado.
Para descargar el programa deberemos clicar en el menú verde que pone "Code".

![image"](https://github.com/user-attachments/assets/a3d06996-b2e0-42dd-8be8-0d5a028276d3)

Una vez abierto el menú clicaremos en la opción que pone "Download ZIP".

![image](https://github.com/user-attachments/assets/d25ac8cc-7052-4ecd-a2c3-36a4134bd207)

### 5. Ejecución del programa

Cuando se descargue, tendremos que extraer el archivo ZIP.main, una vez extraido, deberemos extraer el archivo principal, para abrir el programa, haremos doble click, en el arciho .bat.

Cuando lo abramos, saldrá una opción de Windows Defender parecida a la de la siguiente imagen.

![Captura_de_pantalla_2024-11-14_164315](https://github.com/user-attachments/assets/b7977510-d4ad-4690-af3e-84dfc4774b05)

Esto sucede ya que Windows detecta el archivo como malicioso y no permite abrirlo por seguridad.

Pulsaremos en la opción que dice "Más infromación" y clicaremos en la opción que aparecerá después que dice "Ejecutar de todas formas".

![Captura_de_pantalla_2024-11-14_164325](https://github.com/user-attachments/assets/d061ed19-a7cc-4ef6-9895-edc4ea957c8e)

### 6. Menú Principal.

## 6.1 Registro.

Una vez ejecutado el programa, aparecerá el menú de la siguiente imagen.

![Captura de pantalla 2025-01-07 195848](https://github.com/user-attachments/assets/f8f42ffc-f4fb-4723-94f0-4485c4acdf21)

En este menú se pueden realizar dos opciones, iniciar sesión como cliente, trabajador o administrador y registrarse como cliente.

Para iniciar sesión como cliente primero tendremos que registrarnos seleccionando la segunda opción.

Una vez seleccionada entraremos en el menú de registro que nos pedirá nuestros datos personales.

![Captura de pantalla 2025-01-07 200330](https://github.com/user-attachments/assets/98ecc5d9-061f-4ebe-a9ca-83430214781c)

## 6.2 Inicio de sesión.

### - Cliente

Una vez completado el registro, el programa nos devolverá al menú principal en el que ya podremos iniciar sesión como cliente.

![Captura de pantalla 2025-01-07 200513](https://github.com/user-attachments/assets/ae398182-04cd-4c5e-a9b4-9bf5d0bebf89)

Una vez iniciada la sesión el programa nos llevará al menú del cliente en el que podremos elegir entre varias opciones.

![Captura de pantalla 2025-01-07 200525](https://github.com/user-attachments/assets/0172f498-df5c-443f-8f58-ddff0dddb508)

Esto apartado lo veremos más adelante.

### - Administrador

Para iniciar sesión como Administrador debemos introducir el siguiente correo con su respectiva contraseña: 

### Correo: admin@gmail.com
### Contraseña: 12345

![Captura de pantalla 2025-01-07 190409](https://github.com/user-attachments/assets/f4e279ba-f798-4507-bae3-69f3fd40e73e)

Una vez introducidos esos datos el programa nos llevará al menú de Administrador que veremos más adelante.

### Trabajador

Para iniciar sesión como trabajador primero deberemos acceder al menú de Administrador.

![Captura de pantalla 2025-01-07 201441](https://github.com/user-attachments/assets/cdb4a521-5df6-4596-ab10-bcaa55dbdb08)

Seleccionaremos la opción 3 (Dar de alta un trabajador) para poder registrar a nuestro primer trabajador

Una vez seleccionada introduciremos los datos que el programa nos pide a continuación

![Captura de pantalla 2025-01-07 201621](https://github.com/user-attachments/assets/6245b937-dba2-4a9e-a122-90c469e03a98)

Para iniciar sesión como trabajadpor antes debemos cerrar sesión como Administrador seleccionando la opción 7 del menú.

Ahora sí introduciendo los datos del nuevo trabajador podremos iniciar sesión

![Captura de pantalla 2025-01-07 201900](https://github.com/user-attachments/assets/48a25c0d-5183-44f5-a2ce-71e3714cf388)

Una vez iniciada la sesión el programa nos llevará al menú del trabajador.

![Captura de pantalla 2025-01-07 201908](https://github.com/user-attachments/assets/855107b6-60f3-470a-99fe-7c2aa6820c26)

## 7 Funcionalidad del programa

## 7.1 Menú de cliente.

![Captura de pantalla 2025-01-07 211800](https://github.com/user-attachments/assets/1f4ad6fb-70f9-4af0-8124-7f4ceaf8734e)

### 1.- Consultar el catálogo de productos.

Esta opción nos permitirá ver el catálogo de productos, asi como la cantidad de cada uno.

![Captura de pantalla 2025-01-07 202403](https://github.com/user-attachments/assets/eab27174-28d8-4b1c-8170-ab42b42fae27)

### 2.- Realizar un pedido.

En este caso el programa nos mostrará este menú.

![Captura de pantalla 2025-01-07 202451](https://github.com/user-attachments/assets/ba8716b3-012b-4e3b-bcb3-2ec78673eccd)

Para hacer un pedido solo basta con elegir el número asociado a un producto e introducir la cantidad de elementos que queremos añadir a nuestro pedido

![Captura de pantalla 2025-01-07 202630](https://github.com/user-attachments/assets/c1304816-8a34-4448-9482-a2a882de5a03)

El programa nos preguntará si queremos añadir otro producto a nuestro pedido, en este caso el pedido puede ser de hasta 3 preoductos.

![Captura de pantalla 2025-01-07 202744](https://github.com/user-attachments/assets/84821393-42a4-46b9-8133-79f7d5be85b1)

Una vez terminado el pedido el programa nos devuelve al menú de cliente.

### 3.- Ver mis pedidos realizados.

En este apartado podemos ver el registro de pedidos que hemos realizado

![Captura de pantalla 2025-01-07 202855](https://github.com/user-attachments/assets/69d00b95-6467-49c3-8be7-9cfdf55dee78)

### 4.- Ver mis datos personales.

Esta opción nos perimte ver nuestros datos personales.

![Captura de pantalla 2025-01-07 203007](https://github.com/user-attachments/assets/8ee25bd1-58dd-41a8-bda7-ce99093a45a6)

### 5.- Modificar mis datos personales.

Esta opción nos permitirá cambiar nuestros datos personales, para ello prinmero nos pedirá nuestra contraseña.

![Captura de pantalla 2025-01-07 203127](https://github.com/user-attachments/assets/6992ed00-ff28-4973-8295-ffac35128061)

Una vez dentro nos saldrá un menú para seleccionar que apartado queremos cambiar.

![Captura de pantalla 2025-01-07 203203](https://github.com/user-attachments/assets/2c22dd1b-8704-498a-b58a-553082f15c42)

![Captura de pantalla 2025-01-07 203325](https://github.com/user-attachments/assets/caee5379-d73d-4361-a6fd-73e0c3e08e64)

Una vez cambiados los datos personales podemos volver a acceder a la opcion 4 para ver los nuevos cambios.

![Captura de pantalla 2025-01-07 203425](https://github.com/user-attachments/assets/52c742db-8b27-4ce7-a0e9-4d08e917f602)

### 6.- Cerrar sesión 

Esta opción nos permitirá cerrar sesión, volviendo así al menú principal.

## 7.2.- Menú de administrador

![Captura de pantalla 2025-01-07 203712](https://github.com/user-attachments/assets/0fea89f1-aba1-447b-9fb5-5294ee77ff12)

### 1.- Asignar un pedido a un trabajador

Este apartado nos permitirá asignar un pedido al trabajador que queramos, simepre y cuando este trabajador tenga espacio para mas pedidos.

El programa nos mostrará los pedidos y nos pedirá que introduzcamos el codigo asociado a dicho pedido

![Captura de pantalla 2025-01-07 204110](https://github.com/user-attachments/assets/54392bfe-a87d-4d39-a256-490ba785ebe1)

Luego nos pedirá que seleccionemos a un trabajador al que asignarle el pedido.

![Captura de pantalla 2025-01-07 204208](https://github.com/user-attachments/assets/04024e16-85dc-47a2-bf98-db81ceea5b51)

### 2.- Modificar el estado de un pedido

Esta opción nos permitirá modificar tanto el estado, como la fecha, como el comentario.

El programa nos mostrará los pedidos disponibles y nos pedirá el codigo correspondiente.

![Captura de pantalla 2025-01-07 204418](https://github.com/user-attachments/assets/0834eaeb-0384-4eff-80e0-fcae8d4d7872)

Luego aparecerá un menú que nos pedirá que nuevo estado queremos que tenga el pedido.

![Captura de pantalla 2025-01-07 204521](https://github.com/user-attachments/assets/5718f28b-2c93-4460-b0a8-42d5da33f2e0)

También nos preguntará si queremos añadir un comentario al pedido.

![Captura de pantalla 2025-01-07 204619](https://github.com/user-attachments/assets/2d8aa5ff-d0a9-4c17-a35f-242784756231)

Por últimno nos preguntará si queremos cambiar la fecha del pedido. Esto tambien repercutirá en la fecha de entrega estimada.

![Captura de pantalla 2025-01-07 204746](https://github.com/user-attachments/assets/c34c1cf0-3f20-4cbc-a386-ab869d58b8f4)

### 3.- Dar de alta a un trabajador.

Como esta opción ya se ha explicado anteriormente pasaremos a la siguiente.

### 4.- Ver todos los pedidos.

Este apartado nos mnostrará todos los pedidos que se han realizado.

![Captura de pantalla 2025-01-07 204935](https://github.com/user-attachments/assets/93f419a7-98bc-4990-8fb8-26ea656d6cdd)

### 5.- Ver todos los clientes.

Este apartado nos mostrará todos los clientes registrados.

![Captura de pantalla 2025-01-07 205026](https://github.com/user-attachments/assets/5c8fd935-5360-4ef2-9eee-b4fdad7ff839)

### 6.- Ver todos los trabajadores

Este apartado mostrará todos los trabajadores que se han dado de alta. Así como los pedidos que tienen asignados.

![Captura de pantalla 2025-01-07 205138](https://github.com/user-attachments/assets/2fa093e8-c8e1-40e6-9b02-5192e5d34bfc)

### 7.- Cerrar sesión

Este apartado nos permitirá cerrar sesión para volver al menú principal

## 7.3.- Menú de trabajador.

![Captura de pantalla 2025-01-07 205352](https://github.com/user-attachments/assets/7aee95d9-037c-4faa-b8c6-3e59864ecdd4)

### 1.- Consultar los pedidos que tengo asignados.

Esta opción permitirá al trabajador ver los pedidos que el Administrador le ha asignado.

![Captura de pantalla 2025-01-07 205513](https://github.com/user-attachments/assets/e3fd11c8-1a85-4cf7-aec9-b8bd309a135a)

### 2.- Modificar el estado de un pedido.

Esta opción es similar a la del Administrador.

Se mostrarán los pedidos asignados y se pedirá el código para identificar el pedido.

![Captura de pantalla 2025-01-07 210910](https://github.com/user-attachments/assets/e0da2263-11b3-4026-a9ba-1e490d8798de)

Nos pedirá que seleccionemos el nuevo estado, nos preguntará si queremos añadir un comentario y nos preguntará si queremos cambiar la fecha del pedido.

![Captura de pantalla 2025-01-07 211212](https://github.com/user-attachments/assets/5ace6dd8-fcdd-409e-b5d4-dd0a29f1ee98)

Si volvemos a consultar los pedidos, podremos ver los cambios realizados.

![Captura de pantalla 2025-01-07 211324](https://github.com/user-attachments/assets/2b59a184-bd49-4e09-bc78-52a766eb50b1)

### 3.- Consultar el catálogo de productos.

Esta opción permitirá al trabajador ver el catálogo de productos.

![Captura de pantalla 2025-01-07 205704](https://github.com/user-attachments/assets/a303589b-9ca1-400d-ad4c-93617d932220)

### 4.- Modificar un producto del catálogo.

Este apartado permitirá al trabajador recargar el stock de un producto.

Aparecerá un menú de selección de producto

![Captura de pantalla 2025-01-07 205819](https://github.com/user-attachments/assets/1a558b66-551a-4bf0-969c-a4d58f5869d9)

Una vez seleccionado un producto nos pedirá que introduzcamos una cantidad

![Captura de pantalla 2025-01-07 205944](https://github.com/user-attachments/assets/100b9821-ae8d-45cd-a9c3-d30e7ec3d7fc)

Si accedemos al catálogo de productos podremnos ver com el stock se ha llenado

![Captura de pantalla 2025-01-07 210115](https://github.com/user-attachments/assets/f0c41e4b-79e4-4c21-9de4-64414d68eedd)

### 5.- Ver mi perfil

Este apartado es similar al del cliente en el que el trabajador podrá acceder a sus datos personales.

![Captura de pantalla 2025-01-07 210248](https://github.com/user-attachments/assets/1562f4fd-d811-4650-bf97-5c3571305026)

### 6.- Modificar mis datos personales.

Este apartado nos pedirá la contraseña.

![Captura de pantalla 2025-01-07 210433](https://github.com/user-attachments/assets/d111e65c-8e8c-4eda-a1d7-f9535a834221)

Una vez una vez introducida aparecerá el menú de selección

![Captura de pantalla 2025-01-07 210533](https://github.com/user-attachments/assets/6b1cdb23-6eea-4e74-92a6-f81020630b86)

Si volvemos a accecer al perfil del trabajador veremos que sus datos han cambiado.

![Captura de pantalla 2025-01-07 210609](https://github.com/user-attachments/assets/3abfaf29-91ae-4a99-a531-844174b3179c)

### 7.- Cerrar sesión

Este apartado nos permitirá cerrar sesión para volver al menú principal.

Aqui finalizaría el programa.

Muchas gracias.
