# 📜 Normativa para Commits en el Proyecto

## 📌 1. Formato del Mensaje de Commit

Cada mensaje de commit debe seguir este formato:

```
Tipo: Breve descripción del cambio (Máx. 72 caracteres)

Descripción detallada del cambio (opcional, máx. 100 caracteres por línea).
Referencia a issue si aplica: #NúmeroDeIssue.
```

### 🔹 Tipos de Commits:
- **new ( )**: Nuevo archivo
- **feat ( )**: Añadir una nueva funcionalidad.
- **fix ( )**: Corregir un error.
- **docs ( )**: Cambios en la documentación.
- **style ( )**: Cambios en el formato, sin afectar el código (espacios, comas, etc.).
- **refactor ( )**: Mejora del código sin cambiar su funcionalidad.
- **test ( )**: Añadir o modificar pruebas.
- **chore ( )**: Cambios en la configuración o herramientas del proyecto.
- **perf ( )**: Mejoras de rendimiento.
- **newTest ( )**: Nuevo test unitario

✅ **Ejemplo de commit correcto:**
```bash
feat (e1): Funcionalidad añadida - setRadius
```

## 📌 2. Ramas y Flujo de Trabajo (Git Flow)

Seguimos la estrategia **Git Flow**, con las siguientes ramas principales:
- `main`: Solo código estable y listo para producción.
- `develop`: Rama principal de desarrollo.

### 🔹 Ramas temporales:
- `feature/nombre-funcionalidad`: Para desarrollar nuevas funciones.
- `bugfix/nombre-error`: Para corregir errores.
- `hotfix/nombre-fix`: Para parches urgentes en producción.

✅ **Ejemplo de creación de una rama de funcionalidad:**
```bash
git checkout -b feature/autenticacion-jwt
```

## 📌 3. Procedimiento para Hacer un Commit
1. **Cambios finalizados, no dejes ningun método a medias**

2. **Asegúrate de estar en la rama correcta** (`develop` o una rama temporal).
3. **Realiza los cambios y agrégalos:**
   ```bash
   git add .
   ```
4. **Escribe un mensaje de commit siguiendo el formato:**
   ```bash
   git commit -m "feat: Implementar validación de tokens JWT"
   ```
5. **Sube los cambios a GitHub:**
   ```bash
   git push origin feature/autenticacion-jwt
   ```

✅ **Ejemplo correcto de un metodo antes de hacer commit:**


```
public void method ( ){
}
```
❌ **Ejemplo incorrecto de un método antes de hacer commit:**
```
public String method (String cadena){
    String cadena2 = cadena + cadena;
}
```

## 📌 4. Hacer Merge y Pull Requests
- Antes de fusionar una rama, asegurarse de actualizarla con `develop`.
- Usar **Pull Requests (PR)** en GitHub para revisar los cambios antes del merge.

✅ **Ejemplo de actualización de rama antes de hacer merge:**
```bash
git checkout develop
git pull origin develop
git checkout feature/autenticacion-jwt
git merge develop
```

---
