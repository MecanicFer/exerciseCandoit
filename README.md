# exerciseCandoit
# Proyecto de Ejemplo con Spring Boot

Este proyecto de ejemplo utiliza Spring Boot y otras tecnologías para crear una aplicación web. Incluye funcionalidades como registro de usuarios, autenticación, gestión de roles y 
obtención de datos meteorológicos de un servicio externo.

## Configuración del Proyecto

### Requisitos
Asegúrate de tener instalado lo siguiente:
- Java Development Kit (JDK)
- Apache Maven
- Un IDE de Java (SpringBoot)

### Pasos para Configurar el Proyecto

1. Clona el repositorio desde GitHub: [Enlace al repositorio](https://github.com/ejemplo/proyecto-spring-boot.git).
2. Abre el proyecto en tu IDE de Java.
3. Verifica que tengas configurado el JDK adecuado y Maven.
4. Realiza una actualización de dependencias Maven para descargar las bibliotecas necesarias.

## Descripción del Proyecto

El proyecto está estructurado en varios paquetes y clases que realizan diferentes funcionalidades. A continuación, se proporciona una descripción de las partes clave del proyecto.

### Configuración de Seguridad

El proyecto utiliza Spring Security para la autenticación y autorización de usuarios. La configuración de seguridad se encuentra en la clase `SecurityConfiguration`.

```java
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

#### Roles de Usuario

El proyecto define roles de usuario, como "ROLE_USER," que se asignan a los usuarios por defecto. Si deseas agregar un rol de administrador ("ROLE_ADMIN"), puedes hacerlo
directamente en la base de datos con las siguientes instrucciones:

1. Abre tu base de datos MySQL y ejecuta las siguientes consultas SQL:

   ```sql
   -- Asegúrate de que el rol "ROLE_ADMIN" aún no exista
   SELECT * FROM rol;
   
   -- Si el rol "ROLE_ADMIN" no existe, agrégalo con el siguiente comando
   INSERT INTO rol (nombre) VALUES ('ROLE_ADMIN');
Luego, verifica que el nuevo rol "ROLE_ADMIN" se haya creado correctamente:

sql
Copy code
SELECT * FROM rol;
Ahora puedes asignar el rol "ROLE_ADMIN" a los usuarios que desees.

Recuerda que estas instrucciones son específicas para una base de datos MySQL. Asegúrate de que las consultas se ajusten a tu entorno de base de datos.

...
Controladores
Los controladores manejan las solicitudes web y renderizan las vistas. Aquí tienes algunos ejemplos de controladores en el proyecto:

RegisterUserController.java: Controlador para la página de registro de usuarios.
VistasController.java: Controlador para la administración de usuarios y contactos.
WeatherController.java: Controlador para mostrar datos de clima.

...
Entidades y Repositorios
El proyecto incluye entidades como User y WeatherData que representan datos en la base de datos. Los repositorios, como UserRepository y WeatherDataRepository, permiten acceder
y gestionar estos datos.

...
Servicios
Los servicios, como UserRegisterService y WeatherService, implementan la lógica de negocio y se utilizan en los controladores.

...
Configuración Adicional
El proyecto también incluye configuraciones adicionales, como la configuración de RestTemplate en RestTemplateConfig y constantes en ViewConstant.

...
Servicio de Usuarios y Autenticación
El servicio de usuarios y autenticación es una parte esencial de este proyecto. Se encarga de la creación de usuarios, la autenticación y la gestión de roles.

...
CustomUserDetailsService.java
La clase CustomUserDetailsService implementa la interfaz UserDetailsService de Spring Security y se utiliza para cargar los detalles del usuario durante el proceso de autenticación.
Esta clase recupera al usuario por su nombre de usuario y mapea sus roles como autoridades.

...
java
Copy code
@Service
public class CustomUserDetailsService implements UserDetailsService {

...
UserRegisterService.java y UserRegisterServiceImpl.java
La interfaz UserRegisterService define las operaciones para el servicio de registro y gestión de usuarios, como guardar, listar, eliminar y actualizar usuarios.
La implementación de esta interfaz se encuentra en la clase UserRegisterServiceImpl.

java
Copy code
public interface UserRegisterService {
    public User save(UserRegister userRegister);
    public List<User> listarUsuarios();
    public void eliminarUsuarioPorId(Long id);
    public User obtenerUsuarioPorId(Long id);
    public User actualizarUsuario(User user);
}

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

...
Servicio de Clima
El servicio de clima permite obtener datos meteorológicos de un servicio externo y actualizarlos periódicamente en la base de datos del proyecto.

WeatherService.java
La clase WeatherService es un servicio que utiliza RestTemplate para realizar solicitudes a un servicio externo que proporciona datos meteorológicos.
Los datos se actualizan cada 5 minutos y se almacenan en la base de datos.

java
Copy code
@Service
public class WeatherService {

...
Conclusion
Este proyecto de ejemplo ilustra cómo utilizar Spring Boot para desarrollar una aplicación web con funcionalidades clave, como autenticación de usuarios, registro, gestión de roles
y obtención de datos de un servicio externo. 
