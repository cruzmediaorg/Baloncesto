## Proyecto Final Integración Continua

Este informe detalla el desarrollo de un proyecto como parte del curso final de Integración Continua del Máster de Desarrollo Ágil de Software para la Web en la Universidad de Alcalá. El proyecto se centra en la creación de una plataforma web para votar por jugadores de la liga ACB, implementada en Java con Spring. El objetivo principal es establecer un pipeline de Integración y Entrega Continua (CI/CD), donde la aplicación pase por una serie de fases antes de ser desplegada en producción.

### Gestión Ágil del Proyecto:

El proyecto se gestionó utilizando metodologías ágiles, específicamente mediante Github Projects. Durante el desarrollo, se identificaron y abordaron dos requisitos adicionales, los cuales se organizaron como seis tareas bajo un nuevo spring (milestone):

1. Implementación de la funcionalidad para restablecer los votos de los jugadores.
2. Añadir un nuevo botón para visualizar la tabla de votos.
3. Desarrollo de pruebas funcionales para validar la funcionalidad de restablecimiento de votos.
4. Desarrollo de pruebas funcionales para asegurar la adición de un nuevo jugador.
5. Creación de una prueba unitaria para verificar que la actualización de un jugador incrementa correctamente sus votos.

### Desarrollo y Control de Versiones:

Para abordar estas funcionalidades, se crearon dos nuevas ramas en el repositorio de GitHub. Posteriormente, se generaron solicitudes (pull requests) para fusionar estas ramas con la rama principal (main), siguiendo un proceso de revisión.

#### Pipeline de CI/CD:

Se estableció un pipeline de CI/CD utilizando GitHub Actions, compuesto por seis etapas:

• Build & Unit Testing: Compila el código y ejecuta pruebas unitarias.

• Tests Funcionales: Realiza pruebas funcionales después de haber superado la etapa de compilación y pruebas unitarias.

• Quality Assurance (QA): Realiza análisis estático de código, asegurando que la cantidad de errores mayores no exceda el límite establecido (20).

• Deploy-Testing-Stage: Despliega la aplicación en un entorno de pruebas en Azure, para validar cambios antes de pasar a pre-producción.

• Deploy-Pre-Stage: Despliega la aplicación en un entorno de pre-producción para pruebas exhaustivas previas a la producción.

• Deploy-Prod-Stage: Despliegue automático en el entorno de producción en Azure, después de la aprobación manual correspondiente.

### Conclusiones:

El establecimiento de este pipeline de CI/CD ha permitido una integración y entrega continua eficiente y controlada de la aplicación, mejorando la calidad del software y agilizando el proceso de desarrollo.


## Autor

- [@cruzmediaorg](https://www.github.com/cruzmediaorg)



## Demo

- [Entorno de Testing](https://baloncesto-testing.azurewebsites.net/Baloncesto/)
- [Entorno de Preproducción](https://baloncesto-pre.azurewebsites.net/Baloncesto/)
- [Entorno de Producción](https://baloncesto-uah.azurewebsites.net/Baloncesto/)
