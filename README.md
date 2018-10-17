# Capacitacion Rest Data
En esta nueva capacitación vamos a trabajar con dos librerias del framework spring boot, *spring-web* y *spring-data*. Con ellos vamos a crear una API de turnos. Además vamos a ver la herramienta **postman** y los beneficios que nos tanto a la hora de desarrollar como probar nuestro trabajo sobre la API.
## Narrativa
*Se debe desarrollar una API rest para administrar los turnos de distintos profesionales que trabajan en varias clinicas de la provincia. 
De cada profesional se conoce el número de matricula (único para cada profesional), el dni, nombre, apellido, edad, especialidad y los turnos que tiene en cada clinica. De las clinicas se conoce el CUIT y la razon social. De los pacientes se debe registrar el nombre, apellido, numero de documento, nacionalidad, email y telefono.*

*De los turnos de cada profesional es necesario saber el dia del turno, el profesional que es el que prestará servicios en ese turno, la clinica en la que va a atender y el paciente.*

*Se debe tener en cuenta que un profesional puede prestar servicios en distintas clinicas, pero no en dos clinicas el mismo dia a la misma hora. Cada profesional dispone un numero finito de turnos para asignar en mañana o tarde. Es decir un profesional puede trabajar en la mañana en la clinica X y dispone de 4 turnos y el mismo profesional puede trabajar en la clinica Y de tarde y dispone 3 turnos.*

## Clase 1: Web API - Arquitectura de tres niveles
En esta clase se iniciara con el desarrollo de la interfaz rest. Asi como tambien la implementación de la arquietectura de tres niveles.

  ---------------------        ------------------------      ------------------------
  |   Interfaz Rest   |  <-->  | Servicios de Negocio | <--> | Repositorio de Datos |
  ---------------------        ------------------------      ------------------------

Cada uno de los niveles tiene sus responsabilidad. La interfaz rest es la encargada de manejar los request que llegan al servlet y la respuesta que va a dar en todos los casos posibles de error y en caso de exito. La capa de servicios de negocios, concentra toda la lógica de negocio, en otras palabras, podemos decir que todos los casos de uso llevados a coódigo se debe concetrar en esta capa. El repositorio de datos es el encargado de mantener los datos del negocio, brindando todos los métodos que necesita la capa superior (Servicios de negocio) en relacion a los datos, por ejemplo, si en un punto de la lógica de negocio es importante almacenar los datos de una persona, entonces el repositorio debe disponer de un método para realizar esta funcionalidad. Algo importante es que se debe respetar el acceso entre las distintas capas. 

### Ejercicios
1. Se debe desarrollar la interfaz rest para el ABM de la entidad Clinica (sin persistencia).
1. Se debe desarrollar la interfaz rest para el el ABM de la entidad Profesional (sin persistencia).
1. Se debe desarrollar la interfaz rest para el el ABM de la entidad Paciente (sin persistencia).
1. ¿Que es un Servlet?¿Cual es su ciclo de vida?¿Que beneficio nos brinda la vinculacion de una ruta web a un metodo en java?
1. ¿Que es un contenedor de servlets?¿Cuales son los contenedores de servlets mas usados?
1. ¿Que beneficio nos brinda spring boot web con respecto a otro framework? ¿Por que no necesitamos deployar nuestra aplicacion en un application server o en un contenedor de servlets?

#### Respuestas

* Servlet: 
Un Servlet es un objeto de java que pertenece a una clase que extiende de javax.servlet.http.HttpServlet, este nos permite crear aplicaciones web dinámicas, lo que quiere decir que podemos realizar consultas.
Son pequeños programas (applets) escritos en Java que admiten peticiones a través del protocolo HTTP. Los servlets reciben peticiones desde un navegador web, las procesan y devuelven una respuesta al navegador, normalmente en HTML. Para realizar esto pueden utilizar las herramientas del lenguaje Java.

* Contenedor de Servlets: 
Un contenedor de Servlet es un programa capaz de recibir peticiones de páginas web y redireccionar estas peticiones a un objeto Servlet en específico.
Uno de los más populares es Apache Tomcat.
Cómo funcionan los contenedores de Servlets
El Browser pide una página al servidor HTTP que es un contenedor de Servlets
El contenedor de Servlets delega la petición a un Servlet en particular elegido de entre los Servlets que contiene.
El Servlet, que es una objeto java, se encarga de generar el texto de la página web que se entrega al contenedor.
El contenedor devuelve la página web al Browser que la solicitó.

* Contenedores de servlets mas usados:
Existen muchos contenedores de Servlets como Apache Tomcat, Jboss, Oracle Glassfish Server ,etc.

* Ciclo de vida de un servlets: 
Los servlets no tienen el método main() como los programas Java, sino que se invocan unos métodos cuando se reciben peticiones. A esta metodología se le llama ciclo de vida de un servlet y viene dado por tres métodos: init, service, destroy:

Cada servlet tiene el mismo ciclo de vida:

- Un servidor carga e inicializa el servlet.
- El servlet maneja cero o más peticiones de cliente.
- El servidor elimina el servlet.

INICIALIZACIÓN: Una única llamada al método “init” por parte del servlet. Incluso se pueden recoger unos parámetros concretos con “getInitParameter” de “ServletConfig” inicialales y que operarán a lo largo de toda la vida del servlet.
SERVICIO: una llamada a service() por cada invocación al servlet para procesar las peticiones de los clientes web.
DESTRUCCIÓN: Cuando todas las llamadas desde el cliente cesen o un temporizador del servidor así lo indique o el propio administrador así lo decida se destruye el servlet. Se usa el método “destroy” para eliminar al servlet y para “recoger sus restos” (garbage collection).

* Beneficio nos brinda spring boot web con respecto a otro framework: 

- El principal beneficio es que este framework, nos brinda todo, es decir el código dependiente del entorno está dentro de este framework.
Si un objeto sólo conoce a sus dependencias mediante su interfaz (no por su implementación), podremos cambiar la implementación de esa dependencia como consideremos necesario sin que el objeto sea consciente de esos cambios y, por tanto, sin que le afecten.
El framework Spring se compone de varios módulos, todos ellos giran entorno a Spring Container, el cual se encarga de crear los objetos, conectarlos entre si, configurarlos y además controla los ciclos de vida de cada objeto mediante el patrón de Inyección de Dependencias ( Dependency Injection ó DI ). 
- Otro beneficio es que nuestro código Java puede ser más limpio, elegante y reutilizable. Elegante y reutilizable ya que la filosofía de Spring nos guía a programar orientado a interfaces, de modo que toda nuestra aplicación sea altamente modular y posea bajo acoplamiento. 
Spring se acopla a tu aplicación sin obligarte a modificar tu código para utilizar las funcionalidades y beneficios que ofrece. 
Para usar Spring no es imprescindible implementar un interfaz propio de Spring o heredar de una clase propia (puede que para utilizar cierta funcionalidad avanzada sí sea necesario, pero para un uso habitual no); lo que significa que Spring estará ahí pero tus clases serán Java puro y duro. 
Como mucho, tus clases tendrán anotaciones propias de Spring, pero no dejan de ser anotaciones por lo que tu clase será reutilizable en cualquier momento, sin cambios. 
Esta característica con otros frameworks es impensable, ya que para poder utilizar dicho framework habrás tenido que implementar un interfaz propio del framework y a la vez implementar los métodos establecidos en dicho interfaz; métodos que fuera de ese framework no tienen ningún sentido ni utilidad.
- Y como ya se dijo la inyección de dependencias, esto nos permite solucionar de forma sencilla y elegante cómo proporcionar a un objeto cliente acceso a un objeto que da un servicio que este necesita. Por ejemplo, que un objeto de la capa de presentación se pueda comunicar con uno de negocio. En Spring las dependencias se pueden definir con anotaciones.

* Por que no necesitamos deployar nuestra aplicacion en un application server o en un contenedor de servlets

Cuando creamos una aplicación con Spring boot, usualemente se utiliza Tomcat embebido para el despliegue, al empaquetarlo como jar, Spring va a autoconfigurarnos algunos aspectos de la aplicación para sólo tener que centrarnos en el desarrollo, a diferencia del empaquetado como war, donde deberemos encargarnos nosotros mismos.
Otra ventaja es que, de esta forma, evitamos el problema de tener que mantener sincronización entre las versiones de la aplicación y la configuración del servidor.
