
public class Component {
    float x, y, z;
    float rotX, rotY, rotZ;
    float scaleX, scaleY, scaleZ;

    public Component() {
        x = 0;
        y = 0;
        z = 0;
        rotX = 0;
        rotY = 0;
        rotZ = 0;
        scaleX = 1;
        scaleY = 1;
        scaleZ = 1;
    }

    public void setPosition(float x = 0, float y = 0, float z = 0) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setRotation(float rotX = 0, float rotY = 0, float rotZ = 0) {
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
    }

    public void setScale(float scaleX = 1, float scaleY = 1, float scaleZ = 1) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
    }

    public float[] getPosition() {
        return new float[]{x, y, z};
    }

    public float[] getRotation() {
        return new float[]{rotX, rotY, rotZ};
    }

    public float[] getScale() {
        return new float[]{scaleX, scaleY, scaleZ};
    } 

    public void addComponent(Component component) {
        // adds physics, rendering, etc. components
    }
}