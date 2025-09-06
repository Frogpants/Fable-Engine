
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.flag.ImGuiConfigFlags;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;

public class UIManager {
    private final long windowHandle;
    private final ImGuiImplGlfw imGuiGlfw = new ImGuiImplGlfw();
    private final ImGuiImplGl3 imGuiGl3 = new ImGuiImplGl3();

    public UIManager(long windowHandle) {
        this.windowHandle = windowHandle;
    }

    public void init() {
        ImGui.createContext();
        ImGuiIO io = ImGui.getIO();
        io.addConfigFlags(ImGuiConfigFlags.DockingEnable);
        io.addConfigFlags(ImGuiConfigFlags.ViewportsEnable);

        imGuiGlfw.init(windowHandle, true);
        imGuiGl3.init("#version 330 core");
    }

    public void startFrame() {
        imGuiGlfw.newFrame();
        ImGui.newFrame();
    }

    public void render() {
        ImGui.render();
        imGuiGl3.renderDrawData(ImGui.getDrawData());
    }

    public void cleanup() {
        imGuiGl3.dispose();
        imGuiGlfw.dispose();
        ImGui.destroyContext();
    }
}
