//<editor-fold defaultstate="collapsed" desc="Jibberish">
package buttons;

//</editor-fold>
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mp_gui_lib.MessageBox;

/**
 * In this class you can find all properties and operations for ButtonYes. //CHECK
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/03/18
 */
public class ButtonYes extends Button {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    Stage superStage;
  //</editor-fold>
    
  //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * This is the constructor for ButtonYes.
     */
    public ButtonYes(Stage superStage) {
        super("Yes");
        this.superStage = superStage;
        setAction();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Set Action">
    private void setAction() {
        super.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MessageBox.close();
            }
        });
    }
    //</editor-fold>
    //</editor-fold>

}
