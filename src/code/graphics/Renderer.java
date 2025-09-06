import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera {
    private Vector3f position;
    private Vector3f rotation;
    private Matrix4f projectionMatrix;

    public Camera(float fov, float aspectRatio, float near, float far) {
        position = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, 0);
        projectionMatrix = new Matrix4f().perspective(fov, aspectRatio, near, far);
    }

    public Matrix4f getViewMatrix() {
        Matrix4f view = new Matrix4f();
        view.rotateX((float)Math.toRadians(rotation.x))
            .rotateY((float)Math.toRadians(rotation.y))
            .translate(-position.x, -position.y, -position.z);
        return view;
    }

    public Matrix4f getProjectionMatrix() {
        return projectionMatrix;
    }

    public void setPosition(Vector3f pos) {
        position.set(pos);
    }

    public void setRotation(Vector3f rot) {
        rotation.set(rot);
    }
}

private Camera camera;

public Renderer(Camera camera) {
    this.camera = camera;
}