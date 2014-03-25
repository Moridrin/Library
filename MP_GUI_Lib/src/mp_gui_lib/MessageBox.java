//<editor-fold defaultstate="collapsed" desc="Jibberish">
package mp_gui_lib;

import interfaces.SuperClass;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//</editor-fold>

/**
 *
 * @author J.B.A.J. Berkvens
 */
public class MessageBox implements SuperClass {

    private static Stage primaryStage;

    //<editor-fold defaultstate="collapsed" desc="Show">
    /**
     * This operation shows a MessageBox.
     *
     * @param message       is the message you want to show.
     * @param title         is the title of the message.
     * @param dialogImage   is the dialog image that will be displayed on the left.
     * @param dialogButtons are the buttons in the dialog.
     */
    public static void show(String message, String title, DialogImage dialogImage, DialogButtons dialogButtons) {
        BorderPane borderPane = new BorderPane();
        Label labelMessage = new Label(message);

        borderPane.setCenter(labelMessage);
        borderPane.setPadding(new Insets(10));

        if (dialogImage != DialogImage.None) {
            StackPane stackPane = new StackPane();
            ImageView imageView = dialogImage.getImage();
            stackPane.getChildren().add(imageView);
            borderPane.setLeft(stackPane);
        }
        Node buttons = dialogButtons.getButtons(primaryStage);
        BorderPane bPbBorderPane = new BorderPane();
        bPbBorderPane.setRight(buttons);
        borderPane.setBottom(bPbBorderPane);

        Scene scene = new Scene(borderPane, 400, 100);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();
    }
    //</editor-fold>

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
     * @param message     is the message you want to show.
     * @param title       is the title of the message.
     * @param dialogImage is the image that will be shown on the left.
     */
    public static void show(String message, String title, DialogImage dialogImage) {
        show(message, title, dialogImage, dialogImage.getDefaultButtons());
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

    //<editor-fold defaultstate="collapsed" desc="Preform Action">
    @Override
    public void preformAction(String action, Object[] args) {
        switch (action) {
            case "closeMessage":
                primaryStage.close();
                break;
        }
    }
    //</editor-fold>

    public static void close() {
        primaryStage.close();
    }
}
