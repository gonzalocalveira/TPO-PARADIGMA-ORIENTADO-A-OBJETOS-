## Purpose
Short, actionable guidance for AI coding agents working on this Java Swing project.

## Big-picture architecture
- Java Swing single-process desktop app. Entry point: `Principal.main()` (calls `vista.FormAcceso`).
- Logical layers (folder = package):
  - `vista/` — UI forms (Swing). Example: `FormAcceso` (uses `ControladorUsuario`).
  - `controlador/` — controllers that mediate UI ↔ model. Example: `ControladorUsuario`.
  - `modelo/` — domain and persistence helpers. Example: `GestionUsuario`, `Usuario`, `Cliente`, `ManejoDeArchivos`.
  - `testeo/` — simple manual tests (e.g., `TesteCliente`).

## Data flow & integration points
- Authentication flow: `FormAcceso` -> `ControladorUsuario.autenticarUsuario` -> `GestionUsuario.buscarUsuario`.
- Persistence: plain text file at `src/datos/usuario.txt`. Each user line is `nombre,clave` (CSV-like, no header).
- Validation: `GestionUsuario.validarCorreo` and `validarContrasenia` are used before writes.

## Files to inspect for context/examples
- `vista/FormAcceso.java` — UI → controller calls (mouse listeners call `validarCredenciales` / `registrarUsuario`).
- `controlador/ControladorUsuario.java` — small facade; return strings with success/error messages used by UI.
- `modelo/GestionUsuario.java` — file-based read/write; shows validation rules and file path (`rutaArchivo="src/datos/"`).
- `modelo/ManejoDeArchivos.java` — incomplete helper; mirror patterns in `GestionUsuario` if extending persistence.

## Project-specific conventions & gotchas
- Project uses packages matching directories under `src/` (no build system assumptions). Keep packages consistent.
- Data file path is relative and hard-coded to `src/datos/usuario.txt` — running from a different working directory can break I/O. Prefer running `Principal` from project root or adjust paths.
- Validation quirk: `GestionUsuario.guardarEnArchivo` calls `validarCorreo(usuario) && validarCorreo(usuario)` (duplicate call) — likely meant to call `validarContrasenia` for the second check. Search/replace carefully when fixing.
- Error handling: many methods swallow exceptions and return false or error strings. When changing behavior, preserve the string responses used by the UI (e.g., `"ACCESO CONCEDIDO"`, `"El usuario fue almacenado con exito"`) or update UI accordingly.

## Build / run / test workflows (Windows PowerShell examples)
Note: this is a plain Java project (no Maven/Gradle detected). Use javac/java from the project root.

Compile all .java files into `out` and run `Principal`:
```powershell
javac -d out src\**\*.java
java -cp out Principal
```

Quick run of test class:
```powershell
javac -d out src\**\*.java
java -cp out testeo.TesteCliente
```

If using an IDE (IntelliJ/Eclipse): open the `src` folder as a Java project and run `Principal` or `TesteCliente` main methods.

## Editing guidance for AI agents
- Preserve the simple MVC separation: UI logic stays in `vista`, orchestration in `controlador`, domain and persistence in `modelo`.
- When changing `GestionUsuario` file I/O, update only the minimal behavior and keep the `src/datos/usuario.txt` format stable unless migrating; include migration steps and tests.
- Avoid editing generated `.form` files (GUI builder artifacts) directly — edit the companion `.java` unless you know the GUI builder used.

## Examples to reference in PRs
- To fix the password validation bug: replace the duplicate `validarCorreo` call in `GestionUsuario.guardarEnArchivo` with `validarContrasenia` and add a unit test in `testeo/` asserting that short passwords are rejected.
- When adding new user features, update both the controller return strings and the UI `lblMensaje` handling to keep UX unchanged.

## Commit & PR message hints for AI
- Keep messages short and specific, e.g. `Fix: use validarContrasenia in guardarEnArchivo (prevent weak passwords)` or `Feat: add unit test for Usuario validation`.

---
If anything here looks incomplete or you'd like more specifics (e.g., exact javac flags, a sample unit test, or mapping of all model classes), tell me which areas to expand.
