
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
// import borderlayout
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class GUI {

    public GUI(){
        JButton button1 = new JButton("Add Movie");
        JButton button2 = new JButton("Add Series");
        JButton button3 = new JButton("Search Movie");
        JFrame frame = new JFrame("Movie and Series Database");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Welcome to the Movie and Series Database!");
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(label);





        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new GUI();
        
    }
    
}
