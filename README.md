# Prueba Complemento 360
Ricardo Avendaño Casas

Para ejecutar el proyecto se deben realizar los siguientes pasos
1. descargar fuente de github: git clone https://github.com/ricardoavendano/complemento.git
2. ir al directorio donde se encuentra el fuente y crear jar: mvn clean install (se crea la carpeta target)
3. ir al directorio donde se encuentra el fuente y dirigirse a la carpeta target; por linea de comandos ejecutar jar: java -jar complemento-0.0.1-SNAPSHOT.jar
4. La aplicacion ya se encuentra desplegada localmente en la url (http://localhost:8080)
5. Ingreso a la BD H2
	url: http://localhost:8080/complemento/h2-console/login.jsp
	JDBC URL: jdbc:h2:mem:complemento
	User name: complemento
	Password: complemento
	
	Tablas: BRAND, PRICES
7. Uso de Swagger
	http://localhost:8080/complemento/swagger-ui.html#/
	

	- Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		- curl --location --request GET 'http://localhost:8080/complemento/checkPrices?applicationDate=2020-06-14-10.00.00&productId=35455&brandId=1'

	- Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		- curl --location --request GET 'http://localhost:8080/complemento/checkPrices?applicationDate=2020-06-14-16.00.00&productId=35455&brandId=1'

	- Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		- curl --location --request GET 'http://localhost:8080/complemento/checkPrices?applicationDate=2020-06-14-21.00.00&productId=35455&brandId=1'

	- Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
		- curl --location --request GET 'http://localhost:8080/complemento/checkPrices?applicationDate=2020-06-15-10.00.00&productId=35455&brandId=1'

	- Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
		- curl --location --request GET 'http://localhost:8080/complemento/checkPrices?applicationDate=2020-06-16-21.00.00&productId=35455&brandId=1'

	- Test 6: 204 No content cuando no existe información con los parametros ingresados
		- curl --location --request GET 'http://localhost:8080/complemento/checkPrices?applicationDate=2010-06-16-21.00.00&productId=35455&brandId=1'

	- Test 7: 400 Bad request cuando el/los valores de los parametros tienen formato invalido
		- curl --location --request GET 'http://localhost:8080/complemento/checkPrices?applicationDate=2010-06-16-21.00&productId=35455&brandId=1'

