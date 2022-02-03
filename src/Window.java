import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Frame of the File Renaming Application
 */

public class Window extends JFrame implements ActionListener {

    RenameScript rs;

    JLabel labFolder = new JLabel("Folder:");
    JTextField folderLocation = new JTextField();
    JLabel labName = new JLabel("Name:");
    JTextField commonName = new JTextField();
    JLabel labExt = new JLabel("Extension:");
    JTextField extension = new JTextField();
    JButton doIt = new JButton("Do The Thing");
    JButton undo = new JButton("Go Back");
    JLabel progress = new JLabel("Waiting");

    public Window(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4,2, 20, 10));

        doIt.addActionListener(this);

        add(labFolder);
        add(folderLocation);
        add(labName);
        add(commonName);
        add(labExt);
        add(extension);
        add(doIt);
        add(progress);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == doIt) {
            progress.setText("Working...");
            rs = new RenameScript(folderLocation.getText(), commonName.getText(), extension.getText());
            progress.setText("Done");
        }
    }
}
