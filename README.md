# TodoList

Proyecto todolist para el manejo de pruebas unitarias y de integracion 

## Comenzando 🚀

Git : 
https://github.com/AndresPalacio/todolist-reviewapp.git



### Pre-requisitos 📋

Docker 
Java
IDE


## Ejecutando las pruebas ⚙️

gradle build 

### Analisis del proyecto 🔩

Comandos docker 

```

docker-compose up 

borrar con datos del volumen 

docker-compose down -v 

En caso de error

docker volume prune 


```

Autenticacion de en base de datos docker-compose 

```
docker exec -it <container-name> bash

mongo -u <your username> -p <your password> --authenticationDatabase <your database name>

OR

Este proyecto:

mongo -u <your username> --authenticationDatabase <your database name>

```


Explicacion Mockito: 

Las pruebas realizadas es bajo el patron AAA 

    * Arrange(Organizar/Inicializar) : inicializa los objetos y establece los valores de los datos que vamos a utilizar en el test que lo contiene 

    *Act(Actuar): realiza la llamada al metodo a probar con los parametros preparados para tal fin 

    *Assert(Confirmar/Comprobar): comprueba que el metodo de pruebas ejecutado se comporta tal y como teniamos previsto que lo hiciera


    Nota: Como todos los patrones no requiere que sean de obligado cumplimiento a la hora de escribir 


    Beneficio: 
    El beneficio de utilizar este patron es la organizacion de los test hace que cualquier desarrollador pueda entenderlos rapidamente

    
Un aspecto muy a tener en cuenta del patrón AAA es que una vez realizada la parte de Arrange o inicialización, no deberíamos poder «tocar» los objetos inicializados.

Si hacemos esto por alguna razón, es posible que nuestro Test debiera estar refactorizado en más de un Test.
Mucho código de inicialización es posiblemente un code smell sobre el que requiere prestar atención.
o sea que necesite refactorizar




Test unitario : es la prueba de un componente para probar el correcto funcionamiento de una unidad de codigo (Un metodo)

Nota: cuando un metodo interactua con otros metodos se realiza una prueba de integracion y ademas una prueba unitaria del codigo del metodo creando 

La prueba de un componente debe ser simple


Test de integracion: es la prueba de un componente que interactua con uno o mas componentes, las pruebas de estos pueden ser 

* Pruebas de metodos que interactua con otros, es una llamada simple y verificacion del correcto funcionamiento 

* Pruebas de integracion con componentes externos como base de datos o colasMQ 
Un ejemplo seria:

Pruebas de integracion mediante : base de datos embebidas o testcontainer para una correcta interaccio la base de datos




### Arquitectura y  pruebas de estilo de codificación ⌨️

_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```

## Despliegue 📦

_Agrega notas adicionales sobre como hacer deploy_

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Spring] - El framework web usado
* [Gradle] - Manejador de dependencias
* [Mockito]- Pruebas


## Wiki 📖



## Autores ✒️

* **Jeisson Palacio / jeapalac**


## Licencia 📄

Este proyecto está bajo la Licencia (Tu Licencia) - mira el archivo [LICENSE.md](LICENSE.md) para detalles

## Aprendizaje 🎁

* Devco 📢

