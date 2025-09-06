package src.engine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.joml.Vector3f;
import imgui.ImGui;

import src.code.window.Window;
import src.code.ui.UIManager;
import src.code.renderer.Renderer;
import src.code.renderer.Camera;

public class Engine {

    private Window editorWindow;
    private Window gameWindow;
    private UIManager uiManager;
    private Renderer renderer;
    private Camera camera;

    private boolean editorMode = true;

    public void init() {
        editorWindow = new Window(1280, 720, "Editor");
        editorWindow.init();

        gameWindow = new Window(1280, 720, "Game");
        gameWindow.init();

        camera = new Camera(70.0f, 1280f / 720f, 0.1f, 1000f);
        camera.setPosition(new Vector3f(0, 0, 3));

        renderer = new Renderer();

        uiManager = new UIManager(editorWindow.getWindowHandle());
        uiManager.init();
    }

    public void run() {
        while (!editorWindow.shouldClose() && !gameWindow.shouldClose()) {

            if (GLFW.glfwGetKey(editorWindow.getWindowHandle(), GLFW.GLFW_KEY_TAB) == GLFW.GLFW_PRESS) {
                editorMode = !editorMode;
            }

            if (editorMode) {
                renderEditorWindow();
            } else {
                renderGameWindow();
            }
        }

        cleanup();
    }

    private void renderEditorWindow() {
        GLFW.glfwMakeContextCurrent(editorWindow.getWindowHandle());
        GL.createCapabilities();

        editorWindow.clear();

        renderer.renderScene(camera);

        uiManager.startFrame();

        ImGui.begin("Camera Controls");
        float[] camPos = camera.getPositionArray();
        if (ImGui.sliderFloat3("Position", camPos, -100, 100)) {
            camera.setPosition(camPos);
        }
        ImGui.end();

        uiManager.render();

        editorWindow.update();
    }

    private void renderGameWindow() {
        GLFW.glfwMakeContextCurrent(gameWindow.getWindowHandle());
        GL.createCapabilities();

        gameWindow.clear();

        renderer.renderScene(camera);

        gameWindow.update();
    }

    private void cleanup() {
        uiManager.cleanup();

        editorWindow.cleanup();
        gameWindow.cleanup();

        renderer.cleanup();
    }

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.init();
        engine.run();
    }
}