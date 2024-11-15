# Proyecto de ejemplo de Computación Móvil

Este repositorio contiene el código fuente y la [documentación](docs) del proyecto.

## Uso del proyecto

Este proyecto fue probado usando el SDK de Android version 34 (2024.2.11).

### Con Android Studio

Abra el proyecto en [Android Studio](https://developer.android.com/studio). La version actual fue probada con Android LadyBug (2024.2.1.11). Para generar el proyecto vaya a `Build` > `Generate APK`.

### Desde la linea de comandos

> Nota: Puede usar devcontainers. El proyecto ya tiene una imagen preconfigurada con el SDK de Android y el CLI de GCloud.

Para compilar este proyecto desde la linea de comandos ejecute la tarea de generacion de un APK en [Gradle](https://developer.android.com/build/building-cmdline):

```bash
./gradlew assembleDebug
```

## Pruebas

Puede ejecutar la aplicacion instalando el APK generado en su dispositivo fisico o en un emulador. Tambien es posible ejecutar la aplicacion en el [Test Lab de Firebase usando el cliente de GCloud](https://firebase.google.com/docs/test-lab/android/command-line?authuser=0&hl=en). Asegurese de tener instalado el CLI de GCloud.

Para esto siga los siguientes pasos:

1. Cree un nuevo proyecto en Firebase

1. Inicie su sesion en GCloud desde la linea de comandos:

   ```bash
   gcloud init --console-only
   ```

1. Valide los modelos de Android disponibles para sus pruebas usando el comando

   ```bash
   gcloud firebase test android models list --filter=virtual
   ```

1. Corra sus pruebas con el comando ```gcloud firebase test android run``` pasando los parametros apropiados como el modelo y version de Android a usar. Asegurese de estar en la carpeta donde se genero el APK (`app/builf/outputs/apk/debug`). Por ejemplo:
   
   Pruebas en un dispoitivo fisico de modelo `tokay` y con Android SDK `34` (Android 14)

   ```bash
   gcloud firebase test android run --app app-debug.apk --type robo --device model=tokay,version=34,locale=en,orientation=portrait
   ```

   Pruebas en un dispoitivo fisico de modelo `redfin` y con Android SDK `30` (Android 11)

   ```bash
   gcloud firebase test android run --app app-debug.apk --type robo --device model=redfin,version=30,locale=en,orientation=portrait
   ```

   Pruebas en un dispoitivo virtual de modelo `MediumPhone.arm` y con Android SDK `30` (Android 11) 

   ```bash
   gcloud firebase test android run --app app-debug.apk --type robo --device model=MediumPhone.arm,version=30,locale=en,orientation=portrait
   ```
