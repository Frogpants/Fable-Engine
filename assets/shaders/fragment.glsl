
#version 330 core

out vec4 fragColor;

uniform vec3 triangleColor;

void main() {
    fragColor = vec4(triangleColor, 1.0);
}