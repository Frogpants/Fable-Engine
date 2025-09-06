
Window window = new Window(1280, 720, "My Engine");
window.init();

while (!window.shouldClose()) {
    window.clear();

    // TODO: update ECS, physics, render entities

    window.update();
}

window.cleanup();