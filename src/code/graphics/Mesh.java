

public class ModelImporter {
    public static Mesh importModel(String filePath) throws Exception {
        if (filePath.endsWith(".obj")) {
            return new OBJLoader().load(filePath);
        } else if (filePath.endsWith(".gltf") || filePath.endsWith(".glb")) {
            return new GLTFLoader().load(filePath);
        } else if (filePath.endsWith(".stl")) {
            return new STLLoader().load(filePath);
        } else {
            throw new IllegalArgumentException("Unsupported model format: " + filePath);
        }
    }
}