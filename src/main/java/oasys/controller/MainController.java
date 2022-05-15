package oasys.controller;

import oasys.controller.login.LogInController;
import oasys.view.BuildGUI;
import org.jetbrains.annotations.NotNull;

public class MainController {
    public MainController(@NotNull BuildGUI buildGUI) {
        new LogInController(buildGUI);
    }
}
