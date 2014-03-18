package mp_gui_lib;

/**
 *
 * @author J.B.A.J. Berkvens
 */
public enum DialogImage {

    Error,
    Warning,
    Information,
    Question,
    None;

    @Override
    public String toString() {
        String returner = null;
        switch (this) {
            case Error:
                returner = "file:images/Error.png";
                break;
            case Warning:
                returner = "file:images/Warning.png";
                break;
            case Information:
                returner = "file:images/Info.png";
                break;
            case Question:
                returner = "file:images/Question.png";
                break;
            case None:
                returner = "";
                break;
        }
        return returner;
    }
}
