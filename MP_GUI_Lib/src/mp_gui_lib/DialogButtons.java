package mp_gui_lib;

import buttons.ButtonNo;
import buttons.ButtonOK;
import buttons.ButtonYes;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author J.B.A.J. Berkvens
 */
public enum DialogButtons {

    None,
    OK,
    YesNo,
    Yes,
    No;

    /**
     *
     * @param superStage is the Stage that will be effected by these buttons.
     *
     * @return a node with the buttons.
     */
    public Node getButtons(Stage superStage) {
        Node returner = new Pane();
        switch (this) {
            case OK:
                returner = new ButtonOK(superStage);
                AnchorPane.setRightAnchor(returner, 10.0);
                break;
            case YesNo:
                Node yesButton = new ButtonYes(superStage);
                Node noButton = new ButtonNo(superStage);
                HBox hBox = new HBox();
                hBox.setSpacing(10);
                hBox.getChildren().add(yesButton);
                hBox.getChildren().add(noButton);
                AnchorPane.setRightAnchor(hBox, 10.0);
                returner = hBox;
                break;
            case Yes:
                returner = new ButtonYes(superStage);
                AnchorPane.setRightAnchor(returner, 10.0);
                break;
            case No:
                returner = new ButtonNo(superStage);
                AnchorPane.setRightAnchor(returner, 10.0);
                break;
        }
        return returner;
    }
}
