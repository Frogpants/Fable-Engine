
Shader shader = new Shader("/shaders/vertex.glsl", "/shaders/fragment.glsl");

shader.bind();
shader.setUniform("projection", camera.getProjectionMatrix());
shader.setUniform("view", camera.getViewMatrix());
shader.setUniform("model", entity.getTransform().getMatrix());
shader.setUniform("triangleColor", new Vector3f(1, 0, 0));

mesh.bind();
GL11.glDrawElements(GL11.GL_TRIANGLES, mesh.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
mesh.unbind();

shader.unbind();
