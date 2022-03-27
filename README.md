# TrabajoFinalM4SWD
## Información previa

	
### Pruebas unitarias
src/test/java/com/devops/dxc/devops/model/UtilTest.java
### Pruebas de integración
src/test/java/postman/Dxc.postman_collection.json
### Pruebas funcionales
src/test/java/selenium/AppTest.java 

## Limpiar proyecto
```console
mvn clean
```

## Compilar
```console
mvn compile
```

## Pruebas unitarias
```console
mvn -Dtest=UtilTest test
```

## Ejecutar aplicación
```console
nohup bash mvn spring-boot:run &
```

## Pruebas de integración
se debe tener instalado newman
```console
newman run src/test/java/postman/Dxc.postman_collection.json
```

## Pruebas funcionales
Descargar drivers desde https://chromedriver.chromium.org/downloads y dejar en la carpeta drivers/
```console
mvn -Dtest=AppTest test
```
