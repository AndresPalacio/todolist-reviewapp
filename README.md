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

* Cuando un componente interactua con otros y se desea hacer pruebas unitarias mas fieles a probar el codigo del metodo y no la integracion con otros metodos se utilizan objetos falsos test doubles

Se clasifican en : 


```

– Dummy: Son objetos que se envían, pero nunca se utilizan en el test.
Por ejemplo, imaginemos que tenemos un objeto de la clase GestorDeTareas, que gestiona objetos Tarea, que necesita una lista de parámetros Tarea para funcionar. Si en el test solo queremos comprobar que uno de sus métodos me devuelva el número de Tareas que contiene ese gestor de tareas, podemos utilizar dummies para rellenar el gestor de tareas. Muchas veces los dummies se rellenan con valores NULL.
– Stub: Es un objeto en el que configuras que cuando llames a un método devuelva un valor determinado. Por ejemplo, si tienes un objeto con un método que suma dos números, un stub sería un objeto que independientemente de los valores que le pases al método suma, devuelva 5.
– Spy: Estos objetos guardan las acciones que se hacen sobre ellos. Hace una especie de seguimiento sobre qué métodos se han llamado y con qué parámetros.
Cuando para que un test sea un éxito no es suficiente ver el estado de los objetos disponibles, podemos usar un spy y comprobar cosas como cuántas veces se ha llamado a un método, qué valores han devuelto, etc.
– Mock: Muy similar a un spy, pero no solo guardan las acciones que se hacen sobre ellos, también es necesario configurar qué comportamiento esperas cuando alguien llame a alguno de sus métodos.
– Fake: Es un objeto que implementado completamente y que funciona, como un objeto normal sin ser simulado, pero se diferencia en que está falseando algo para hacer alguna cosa más fácil de probar. Un ejemplo de esto podría ser un objeto que utiliza una base de datos en memoria en lugar de acceder a consultar la base de datos de producción.


```
Pero los mas utilizados podrian ser los Spy y mock


Spy

Se puede utilizar para simular parcialmente un objeto, esto es util cuando se desea burlar parcialmente el comportamiento de una clase, un ejemplo comun es un servicio que hace el llamado una base de datos y realiza otra operacion de otro servicio, en este caso se burlaria la conexion a la base de datos pero no el llamado al otro servicio


En otro caso el @Mock nos permite indicarle que metodos se comportaran de una manera al ser llamados 
en otro componente esto lo logramos mediante el metodo 

Un Spy es como un Mock. La diferencia es que, si queremos, puede funcionar como un objeto real y llamará a las implementaciones de los métodos reales. Tambien tenemos la opción podemos simular la funcionalidad de cualquier método, como con el Mock.

```

@Test
public void whenITryToCutWaterThenFalse()
{
   Knife knife = spy( Knife.class );
   doReturn( false ).when( knife ).cut( "water" );

   assertEquals( knife.cut("water", false);
}

```

Otro ejemplo


```
when().thenReturn();
```



Ejemplos: 

```
public class GreetingsServiceTest {
    @Mock
    private UserServiceImpl userService; // this class will be mocked
    @Spy
    private AppServiceImpl appService; // this class WON'T be mocked
    @InjectMocks
    private GreetingsService greetingsService = new GreetingsService(userService, appService);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

	// en este caso se mockearia el resultado de cuando se llame ese metodo 
	// los servicios getFirstName y getLastName de acceso a datos 
	// cuando se llamen retornaria John y Doe
	// pero por contrario al aplicar Spy cuando se haga un llamado al metodo
	// devolvera correctamente la llamada al servicio 

    @Test
    public void testGetGreetings_morning() throws Exception {
        // specify mocked behavior
        when(userService.getFirstName(99)).thenReturn("John");
        when(userService.getLastName(99)).thenReturn("Doe");
        // invoke method under test
        String greetings = greetingsService.getGreetings(99, LocalTime.of(0, 45));
        Assert.assertEquals("Failed to get greetings!", "Good Morning, John Doe! Welcome to The Amazing Application.", greetings);
    }

    @Test
    public void testGetGreetings_afternoon() throws Exception {
        // specify mocked behavior
        when(userService.getFirstName(11)).thenReturn("Jane");
        when(userService.getLastName(11)).thenReturn("Doe");
        // invoke method under test
        String greetings = greetingsService.getGreetings(11, LocalTime.of(13, 15));
        Assert.assertEquals("Failed to get greetings!", "Good Afternoon, Jane Doe! Welcome to The Amazing Application.", greetings);
    }
}

Otro ejemplo seria 
@Spy
private ArrayList spyArrayList;
 
@Test
public void spyTest() {
    spyArrayList.add("Object 1");
    spyArrayList.add("Object 2");
    spyArrayList.add("Object 3");
 
    assertEquals(3, spyArrayList.size());
 
    when(spyArrayList.size()).thenReturn(20);
    assertEquals(20, spyArrayList.size());
}


```
Explicacion del metodo anterior :Donde podemos usar los metodos de ArrayList  sin embargo al final queremos generar un mock para cuando devuelva el tamaño, podriamos seguir utilizando el metodo get y demas 


Nota: Spy mantendra los objetos originales y solo remplazara algunos metodos que deseemos cambiar, a esto se le conoce como partial mocking coon el when de igual manera


Mockito: 

Razon por usar mockito, como ya habia dicho antes un test unitario debe probar un un componente aislado de nuestra aplicacion, los errores o efectos secundarios de otro componentes deben ser elimados 
para aislar esos componentes de nuestras pruebas es mediante el uso de test doubles 


esto nos asegura que las pruebas se ejecuten solo para  un componente
asegurando que no tendran ningun efecto secundario de otra clase cuando sea llamado


Definiciones necesarias:
@RunWith(MockitoJUnitRunner.class) : Se utiliza para definir que se utilizará el Runner de Mockito para ejecutar nuestras pruebas.

@InjectMocks <--- este sera la clase que contiene el metodo a probar y se desea inyectar mocks con unas respuestas al llamado de sus metodos

@Mock <-- seran las clases que se llamaran dentro de ese metodo a probar y se desea crear un mock o por asi decirlo una simulacion de un metodo


public class CalculatorServiceTest {
    @InjectMocks
    private CalculatorServiceImpl calculatorService;
 
    @Mock
    private DataService dataService;
 
    @Test
    public void testCalculateAvg_simpleInput() {
        when(dataService.getListOfNumbers()).thenReturn(new int[] { 1, 2, 3, 4, 5 });
        assertEquals(3.0, calculatorService.calculateAverage(), .01);
    }

}

when(dataService.getListOfNumbers()).thenReturn(new int[] { 1, 2, 3, 4, 5 }) : Define que cuando se ejecute el método getListOfNumbers se devolverá el resultado new int[] { 1, 2, 3, 4, 5 }.


Ahora la llamada a un metodo y la assercion solo hace una prueba de integracion pero si se deseea hacer una prueba
unitaria fiel sin tener dependencia de otros componentes solo de ese metodo se necesita mocks


Diferencia entre mock y spy

Básicamente, la diferencia es que con Mock es obligatorio simular los comportamientos de los métodos. Los Mocks son muy usados cuando se programa haciendo TDD (Test Driven Development o Desarrollo basado en tests), ya que no requieren de que haya ninguna funcionalidad implementada. Sin embargo, Spy, aunque puede simular el comportamiento de los métodos al igual que Mock, también nos da la oportunidad de llamar a la implementación real de los métodos del objeto. Es usado cuando nos interesa mantener la consistencia de los métodos ya implementados con la nueva parte que estemos desarrollando y realizando TDD.




Verify

Al hacer una prueba unitaria, hace algunas afirmaciones para verificar la igualdad entre el resultado esperado y el resultado real 
cuando se utiliza objetos simulados en la prueba unitaria, es posible que necesite verificar en mockito que el  objeto simulado se ha realizado metodos especificos

Ejemplo


```
String addString = "nuevo";
        mockList.add(addString);
        
        //verifica que el metodo add fue llamado con el argumento 'nuevo'

        verify(mockList).add(addString);

```

Verificar que un metodo es llamado un numero de veces con un parametro
String addString = "nuevo test";
        mockList.add(addString);
        mockList.add(addString);
        mockList.add(addString);
 

        verify(mockList, times(3)).add(addString);

verifica que el metodo add fue llamado tres veces con el argumento nuevo test 

### Pruebas Spring boot  ⌨️

 * "spring-boot-starter-test" contiene: 

JUnit — La librería de testing unitario básica en todos los proyectos java.
Spring Test & Spring Boot Test —Algunas utilidades para testing de aplicaciones de Spring
AssertJ — Librería para Asserts
Hamcrest — Librería para crear matchers entre objetos
Mockito — Framework para crear objetos simulados para pruebas
JSONassert — Librería para realizar asserts sobre Json
JsonPath — XPath para JSON.


El uso de la anotacion @SpringBootTest
Le indica a spring boot que configure un contexto completo de la aplicacion spring boot

Nota: cuando se utiliza SpringbootTest

Cuando una clase tiene la anotacion @Autowired debe ser probada usando la anotacion @SpringBootTest debido a que se necesita levantar el contexto para la ejecucion de la prueba.

Ejemplo

```
@Service
public class RegistrarUsuario {

  @Autowired
  private UserRepository userRepository;

  public User registerUser(User user) {
    return userRepository.save(user);
  }

}

```
De esta manera spring permite inyectar 

Esta Inyeccion se puede hacer mediante constructor 

```
@Service
public class RegisterUsuario {

  private final UserRepository userRepository;

  public RegisterUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User registerUser(User user) {
    return userRepository.save(user);
  }

}

```

Esto es inyeccion mediante constructor que permite pasar una instancia de UserRepository en la prueba unitaria y crear una instancia de ese tipo, como un test double y pasarla por constructor

Nota: spring utilizara este constructor para crear las instancias, al crear el contexto de la aplicacion
 
```
En spring 5: se necesita agregar al constructor el @Autowired para spring encontrar el cosntructor
```

Es final porque el contenido del campo inyectado 


Por lo anterior es recomendado usar @RequiredArgsConstructor de lombok esta anotacion permite
que el constructor se genere automaticamente



## Test de integracion



## Despliegue 📦

_Agrega notas adicionales sobre como hacer deploy_

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Spring] - El framework web usado
* [Gradle] - Manejador de dependencias
* [Mockito]- Pruebas


* Dependencias

Pruebas con mockito
```
dependencies{
  compileOnly('org.projectlombok:lombok')
  testCompile('org.springframework.boot:spring-boot-starter-test')
  testCompile 'org.junit.jupiter:junit-jupiter-engine:5.2.0'
  testCompile('org.mockito:mockito-junit-jupiter:2.23.0')
}

```


# Pruebas unitarias sin mockito 

Se desea realizar una prueba a un servicio que contiene logica de negocio

```
class RegisterUseCaseTest {

  private UserRepository userRepository = ...;

  private RegisterUseCase registerUseCase;

  @BeforeEach
  void initUseCase() {
    registerUseCase = new RegisterUseCase(userRepository);
  }

  @Test
  void savedUserHasRegistrationDate() {
    User user = new User("zaphod", "zaphod@mail.com");
    User savedUser = registerUseCase.registerUser(user);
    assertThat(savedUser.getRegistrationDate()).isNotNull();
  }

}
```
Se debe inicializar el objeto a probar y debido a que la inyeccion de dependencias necesita el objeto pasado por constructor creamos una instancia y la agregamos 

 * Esta prueba unitaria depende de una base de datos para su ejecucion por lo que es necesario mockear el llamado a la base de datos  por su clara depencia con userRepository

## Wiki 📖



## Autores ✒️

* **Jeisson Palacio / jeapalac**


## Licencia 📄

Este proyecto está bajo la Licencia (Tu Licencia) - mira el archivo [LICENSE.md](LICENSE.md) para detalles

## Aprendizaje 🎁

* Devco 📢



