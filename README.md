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

_Comandos docker 

```

docker-compose up 

borrar con datos del volumen 

docker-compose down -v 

En caso de error

docker volume prune 


```

_Autenticacion de en base de datos docker-compose 

```
docker exec -it <container-name> bash

mongo -u <your username> -p <your password> --authenticationDatabase <your database name>

OR

Este proyecto:

mongo -u <your username> --authenticationDatabase <your database name>

```




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

