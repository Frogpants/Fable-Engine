# Dynamic Java Game Engine

A custom Java-based game engine built with **LWJGL** and **Dear ImGui**, supporting both **2D and 3D rendering**, real-time editing, and dynamic scene management.

---

## Features

- **3D Rendering**: Supports rendering 3D meshes, basic lighting, and materials.
- **2D Rendering**: Lightweight 2D primitives and textures.
- **Editor Mode**: Full ImGui-based interface for live editing:
  - Camera controls
  - Entity transform manipulation
  - Material and shader editing
- **Game Mode**: Separate window to run the game without editor UI.
- **Dynamic Object Import**: Import common model formats such as OBJ, glTF, and STL.
- **Flexible Camera System**: Adjustable position, rotation, and projection.
- **Shader Support**: Load and compile custom GLSL shaders for advanced rendering.
- **Dual Window Support**: Simultaneously run Editor and Game windows with synchronized scenes.

---

## Installation

1. **Clone the repository:**

```bash
git clone https://github.com/Frogpants/game-engine.git
cd game-engine
````

2. **Build with Gradle:**

```bash
./gradlew build
```

3. **Run the engine:**

```bash
./gradlew run
```

> Make sure you have **Java 17+** installed and your IDE or system PATH points to it.

---

## Project Structure

```
assets/
 ├─ models/             # 3D model files (OBJ, STL, glTF, etc.)
 └─ shaders/            # GLSL shader files
      ├─ fragment.glsl
      └─ vertex.glsl

libs/                   # External libraries or JARs

src/
 └─ code/
      ├─ core/          # Engine core classes
      │    ├─ Engine.java
      │    └─ Window.java
      │
      ├─ ecs/           # Entity Component System classes
      │    ├─ Component.java
      │    ├─ Entity.java
      │    └─ System.java
      │
      ├─ graphics/      # Rendering and graphics
      │    ├─ Mesh.java
      │    ├─ Renderer.java
      │    └─ Shader.java
      │
      ├─ input/         # Input handling
      │    └─ InputManager.java
      │
      ├─ physics/       # Physics-related classes (currently empty)
      │
      └─ ui/            # UI system
           └─ Manager.java

 └─ Main.java           # Entry point
```

---

## Usage

* **Editor Mode**: Default mode, allows live editing of the scene.
* **Game Mode**: Press `TAB` to switch to the game view window without editor UI.
* **Camera Controls**: Use the ImGui sliders to move the camera.
* **Object Importing**: Place OBJ, glTF, or STL files in the `assets/models/` folder and use the importer to load them into the scene.

---

## Dependencies

* [LWJGL 3](https://www.lwjgl.org/) – OpenGL, GLFW, OpenAL
* [Dear ImGui](https://github.com/ocornut/imgui) – Immediate mode GUI
* [JOML](https://github.com/JOML-CI/JOML) – Java OpenGL Math Library
* Java 17 or higher

---

## License

This project is licensed under the **GNU LESSER GENERAL PUBLIC LICENSE**. See [LICENSE](LICENSE) for details. This license is subject to change in the future.

---

## Notes

* This engine is in **active development** and primarily intended for easy and dynamic game creation and removing limits most game engines have.
* Advanced features like physics, lighting, and optimization are currently being worked on.