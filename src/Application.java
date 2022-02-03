import java.awt.*;

public class Application {
    public static void main(String[] args) {
        Window window = new Window("Renaming App");
        window.pack();
        window.setMinimumSize(new Dimension(300,window.getSize().height));
        window.setMaximumSize(new Dimension(700,window.getSize().height));
        window.setVisible(true);
    }
}
