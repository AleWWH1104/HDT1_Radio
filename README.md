# HDT1_Radio
intruc

Iris Ayala- 23965 
Gabriel Bran - 23590 
David Dominguez - 23712 
Jonathan Diaz - 23837 
Anggie Quezada - 23643

Iris Ayala- aya23965@uvg.edu.gt
Gabriel Bran - bra23590@uvg.edu.gt
David Dominguez - dom23712@uvg.edu.gt
Jonathan Diaz - dia23837@uvg.edu.gt
Anggie Quezada - que23643@uvg.edu.gt

## Descripción

El programa implementa una clase en Java llamada `Radio` que modela un dispositivo de radio con diversas funcionalidades. La clase `Radio` representa un dispositivo de radio capaz de sintonizar estaciones en las bandas AM y FM, ajustar el volumen, guardar estaciones favoritas en botones predefinidos, y realizar aproximaciones de frecuencia según la banda seleccionada.

## Funcionalidades Principales

1. **Encendido y Apagado:**
   - La radio puede ser encendida o apagada mediante los métodos `getEncendido()` y `setEncendido(boolean encendido)` respectivamente.

2. **Selección de Banda y Estación:**
   - La radio permite ajustar la banda (AM o FM) y la estación actual mediante los métodos `getBanda()`, `getEstacion()`, y `setEstacionBanda(double frecuencia, int banda)`.

3. **Control de Volumen:**
   - El volumen de la radio se puede consultar mediante `getVolumen()`. Se puede ajustar usando `setVolumen(int volumen)`, con límites de 0 a 100. Además, hay métodos `volUp()` y `volDown()` para incrementar y decrementar el volumen, respectivamente.

4. **Guardado de Estaciones Favoritas:**
   - Las estaciones pueden ser guardadas en botones predefinidos mediante `guardarEstacion(double estacion, int banda, int boton)`. Se proporciona también `recuperarEstacion(int posicion)` para recuperar las estaciones guardadas en un botón específico.

5. **Aproximación de Frecuencia:**
   - La clase proporciona un método `aproximarNumero(double numero, int condicion)` para aproximar una frecuencia a la más cercana según la banda (AM o FM).

6. **Visualización de Estaciones Favoritas:**
   - `mostrarEmisorasGuardadas()` imprime las estaciones guardadas en cada botón, proporcionando una visión rápida de las emisoras favoritas almacenadas.

