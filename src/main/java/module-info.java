module by.aghanim.anim3u {
    requires javafx.controls;
    requires javafx.fxml;


    opens by.aghanim.anim3u to javafx.fxml;
    exports by.aghanim.anim3u;
    exports by.aghanim.anim3u.controllers;
    opens by.aghanim.anim3u.controllers to javafx.fxml;
}