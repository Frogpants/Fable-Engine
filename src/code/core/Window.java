
package src.code.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {
    private long windowHandle;
    private int width;
    private int height;
    private String title;

    private boolean resized;

    // Constructor
    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.resized = false;
    }

    // Initialize the window and OpenGL context
    public void init() {
        // Set up an error callback
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure GLFW
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE); // window hidden until ready
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        // Create the window
        windowHandle = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        if (windowHandle == 0) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Set up resize callback
        GLFW.glfwSetFramebufferSizeCallback(windowHandle, (window, w, h) -> {
            this.width = w;
            this.height = h;
            this.setResized(true);
        });

        // Center the window
        long primaryMonitor = GLFW.glfwGetPrimaryMonitor();
        GLFW.glfwSetWindowPos(
                windowHandle,
                (GLFW.glfwGetVideoMode(primaryMonitor).width() - width) / 2,
                (GLFW.glfwGetVideoMode(primaryMonitor).height() - height) / 2
        );

        // Make OpenGL context current
        GLFW.glfwMakeContextCurrent(windowHandle);

        // Enable v-sync
        GLFW.glfwSwapInterval(1);

        // Show the window
        GLFW.glfwShowWindow(windowHandle);

        // Initialize OpenGL bindings
        GL.createCapabilities();

        // Set default OpenGL state
        GL11.glClearColor(0f, 0f, 0f, 0f);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    // Clear the window
    public void clear() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    // Swap buffers and poll events
    public void update() {
        GLFW.glfwSwapBuffers(windowHandle);
        GLFW.glfwPollEvents();
    }

    // Check if window should close
    public boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(windowHandle);
    }

    // Close and free resources
    public void cleanup() {
        GLFW.glfwDestroyWindow(windowHandle);
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    // Getters and setters
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public long getWindowHandle() { return windowHandle; }

    public boolean isResized() { return resized; }
    public void setResized(boolean resized) { this.resized = resized; }
}
