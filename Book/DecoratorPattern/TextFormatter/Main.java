import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Main {

    public static void main(String[] args) {

        Text message = new PlainText("Hello World");
        message = new BoldText(message);
        message = new ItalicText(message);
        message = new UnderlineText(message);

        System.out.println(message.render());

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setVisible(true);

        JLabel label = new JLabel("<html>" + message.render() + "</html>");
        label.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(label);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }
    
}
