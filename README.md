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
