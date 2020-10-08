# Fibonacci Demo

### SPANISH
 Esta demostración de Restful API la he realizado con Spring Boot
 
 Calcula el número de Fibonacci de una determinada posición
 
 Los resultados se devuelven en JSON implementando IETF devised RFC 7807 error-handling schema (https://tools.ietf.org/html/rfc7807) 
 
 Para obtener resultados con números grandes se ha utilizado BigInteger para los cálculos
 
 Tiene control de errores en parámetros y sus correspondientes test
 
 Los mensajes de info y error se han redactado en inglés para dar uniformidad a la salida de mensajes, ya que algunos mensajes son resultado de excepciones
 
 Esta preparada para funcionar en el puerto `8080`
 
 El path es `/fibonacci/`
 
 El parámetro _`position`_ indica la posición que se desea calcular, debe ser 0 o positivo
 
 URL _`proto://host:8080/fibonacci/{position}`_

### ENGLISH
 This demo...

### Reference Documentation
For further reference, please consider the following sections:

* [Internet Engineering Task Force](https://tools.ietf.org/html/rfc7807)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)
* [Jersey](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-jersey)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#using-boot-devtools)

