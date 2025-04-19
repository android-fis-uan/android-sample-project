[![Android CI](https://github.com/android-fis-uan/android-sample-project/actions/workflows/android.yml/badge.svg)](https://github.com/android-fis-uan/android-sample-project/actions/workflows/android.yml)

# Proyecto de ejemplo de Computación Móvil

Este repositorio contiene el código fuente y la [documentación](docs) del proyecto.

## Uso del proyecto

Este proyecto fue probado usando el SDK de Android version 35 (2024.2.11).

### Con Android Studio

Abra el proyecto en [Android Studio](https://developer.android.com/studio). La version actual fue probada con Android Studio Meerkat | 2024.3.1. Para generar el proyecto vaya a `Build` > `Build APKs`.

### Desde la linea de comandos

> Nota: Puede usar `devcontainers`. El proyecto ya tiene una imagen pre-configurada con el SDK de Android y el CLI de GCloud.

Para compilar este proyecto desde la linea de comandos ejecute la tarea de generación de un APK en [Gradle](https://developer.android.com/build/building-cmdline):

```bash
./gradlew assembleDebug
```

## Pruebas

Puede ejecutar la aplicación instalando el APK generado en su dispositivo físico o en un emulador. También es posible ejecutar la aplicación en el [Test Lab de Firebase usando el cliente de GCloud](https://firebase.google.com/docs/test-lab/android/command-line?authuser=0&hl=en). Asegúrese de tener instalado el CLI de GCloud.

Para esto siga los siguientes pasos:

1. Cree un nuevo proyecto en Firebase

1. Inicie su sesión en GCloud desde la linea de comandos:

   ```bash
   gcloud init --console-only
   ```

1. Valide los modelos de Android disponibles para sus pruebas usando el comando

   ```bash
   gcloud firebase test android models list --filter=virtual
   ```

1. Corra sus pruebas con el comando ```gcloud firebase test android run``` pasando los parámetros apropiados como el modelo y version de Android a usar. Asegúrese de estar en la carpeta donde se genero el APK (`app/builf/outputs/apk/debug`). Por ejemplo:
   
   Pruebas en un dispositivo físico de modelo `tokay` y con Android SDK `34` (Android 14)

   ```bash
   gcloud firebase test android run --app app-debug.apk --type robo --device model=tokay,version=34,locale=en,orientation=portrait
   ```

   Pruebas en un dispositivo físico de modelo `redfin` y con Android SDK `30` (Android 11)

   ```bash
   gcloud firebase test android run --app app-debug.apk --type robo --device model=redfin,version=30,locale=en,orientation=portrait
   ```

   Pruebas en un dispositivo virtual de modelo `MediumPhone.arm` y con Android SDK `30` (Android 11) 

   ```bash
   gcloud firebase test android run --app app-debug.apk --type robo --device model=MediumPhone.arm,version=30,locale=en,orientation=portrait
   ```

## Uso de Github Actions

El proyecto esta configurado con Github Actions para compilar y probar de forma automática el proyecto con Firebase Test Lab, en cada push a la rama principal.
