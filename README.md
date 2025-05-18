
# 💱Conversor de Monedas (Java)

Aplicación de consola en Java que permite convertir valores entre distintas monedas utilizando datos en tiempo real desde la API ExchangeRate-API (https://www.exchangerate-api.com/).




## 💡 Características

- Conversión de monedas entre: Dólar estadounidense (USD), Peso dominicano (DOP), Peso argentino (ARS), Peso colombiano (COP).
- Obtención de tasas de cambio actualizadas desde un servicio web.
- Interfaz simple por consola para seleccionar tipo de conversión y valor.


## 🛠️ Tecnologías utilizadas

**Java 8+**

**Librería Gson:** (https://mvnrepository.com/artifact/com.google.code.gson/gson).

**API de ExchangeRate (versión gratuita)**

## 🗂️ Estructura del proyecto
src/

├── **Principal.java** → Clase principal, contiene el menú y lógica del programa.   
└── **Webservice.java** → Clase que se conecta con la API y retorna los datos en JSON.
## ⚙️ Configuración y ejecución
**1) Clona el repositorio:**
```Bash
git clone https://github.com/Javier835/Challenge-Conversor-de-Moneda.git
```

**2) Asegúrate de tener Java instalado. Puedes verificarlo con:**
```Bash
java -version
```

**3) Agrega la librería Gson a tu proyecto.**
- Si usas IntelliJ IDEA o Eclipse, puedes añadir el ```.jar``` manualmente.
- También puedes descargarla desde: https://repo1.maven.org/maven2/com/google/code/gson/gson/

**4) Compila y ejecuta el proyecto:**
```Bash
javac Webservice.java Principal.java
java Principal
```

## 🧪 ¿Cómo Usar? 🧪
1) Al ejecutar el programa, se mostrará un **menú con las opciones de conversión disponibles.**
2) **Selecciona el tipo de conversión** que deseas realizar (por ejemplo, ```USD a DOP```).
3) **Ingresa el valor** que quieres convertir cuando se te solicite.
4) El sistema te mostrará el **resultado de la conversión** utilizando la tasa de cambio actual.
## 📝 Notas Importantes 📝
- Ten en cuenta que esta aplicación utiliza la **versión gratuita de la API**, la cual puede tener **limitaciones en el número de solicitudes diarias.**
- Si deseas utilizar tu **propia clave de API**, puedes registrarte en https://www.exchangerate-api.com/ y reemplazar la clave predeterminada en el archivo ```Webservice.java.```
## 👨‍💻 Autor 👨‍💻

- [@Javier835 ](https://github.com/Javier835)

