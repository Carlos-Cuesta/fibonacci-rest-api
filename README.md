# Fibonacci Demo

### SPANISH
 Esta demostración de Restful API la he realizado con Spring Boot
 
 Calcula el número de Fibonacci de una determinada posición
 
 Los resultados se devuelven en JSON implementando IETF devised RFC 7807 error-handling schema (https://tools.ietf.org/html/rfc7807) 
 
 Para obtener resultados con números grandes se ha utilizado BigInteger para los cálculos
 
 Tiene control de errores en parámetros y sus correspondientes test
 
 Los mensajes de info y error se han redactado en inglés para dar uniformidad a la salida de mensajes, ya que algunos mensajes son resultado de excepciones.
 
 Tiene control de timeout, si la operación de cálculo lleva más de 60 segundos, devuelve un error. 
 
 Esta preparada para funcionar en el puerto `8080`
 
 El path es `/fibonacci/`
 
 El parámetro `position` indica la posición que se desea calcular, debe ser 0 o positivo
 
 URL `protocol://host:8080/fibonacci/{position}`
 
 ### ENGLISH
 This Restful API demo was done with Spring Boot
 
 Calculates the Fibonacci number of a certain position
 
 The results are returned in JSON implementing the IETF devised RFC 7807 error-handling schema (https://tools.ietf.org/html/rfc7807)
 
 To obtain results with large numbers, BigInteger has been used for calculations
 
 It has error control in parameters and their corresponding tests
 
 The info and error messages have been written in English to give uniformity to the output of messages, since some messages are the result of exceptions
 
 Timeout control, if the calculation operation takes more than 60 seconds, it returns an error.
 
 It is ready to work on port `8080`
 
 The URI path is `/fibonacci/`
 
 The `position` parameter indicates the position to be calculated, it must be 0 or positive
 
 URL `protocol://host:8080/fibonacci/{position}`

### Reference Documentation
For further reference, please consider the following sections:

* [Internet Engineering Task Force RFC 7807](https://tools.ietf.org/html/rfc7807)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)
* [Jersey](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-jersey)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#using-boot-devtools)

