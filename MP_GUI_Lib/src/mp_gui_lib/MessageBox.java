package mp_gui_lib;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author J.B.A.J. Berkvens
 */
public class MessageBox {

    //<editor-fold defaultstate="collapsed" desc="Show (Default)">
    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     */
    public static void show(String message) {
        show(message, "MP-Message");
    }

    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     * @param title   is the title of the message.
     */
    public static void show(String message, String title) {
        show(message, title, DialogImage.Information);
    }

    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     * @param title   is the title of the message.
     * @param image   is the dialog image that will be displayed on the left.
     */
    public static void show(String message, String title, DialogImage image) {
        BorderPane borderPane = new BorderPane();

        Label labelMessage = new Label(message);
        borderPane.setCenter(labelMessage);

        if (image != DialogImage.None) {
            StackPane stackPane = new StackPane();
            ImageView imageView = new ImageView(image.toString());
            stackPane.getChildren().add(imageView);
            borderPane.setLeft(stackPane);
        }

        Scene scene = new Scene(borderPane, 300, 100);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Show Error">
    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     */
    public static void showError(String message) {
        showError(message, "MP-Message");
    }

    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     * @param title   is the title of the message.
     */
    public static void showError(String message, String title) {
        show(message, title, DialogImage.Error);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Show Warning">
    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     */
    public static void showWarning(String message) {
        showWarning(message, "MP-Message");
    }

    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     * @param title   is the title of the message.
     */
    public static void showWarning(String message, String title) {
        show(message, title, DialogImage.Warning);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Show Information">
    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     */
    public static void showInformation(String message) {
        showInformation(message, "MP-Message");
    }

    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     * @param title   is the title of the message.
     */
    public static void showInformation(String message, String title) {
        show(message, title, DialogImage.Information);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Show Question">
    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     */
    public static void showQuestion(String message) {
        showQuestion(message, "MP-Message");
    }

    /**
     * This operation shows a MessageBox.
     *
     * @param message is the message you want to show.
     * @param title   is the title of the message.
     */
    public static void showQuestion(String message, String title) {
        show(message, title, DialogImage.Question);
    }
    //</editor-fold>

}
