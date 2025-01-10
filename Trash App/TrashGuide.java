import java.awt.*;
import javax.swing.*;

public class TrashGuide {
    public TrashGuide() {
        JFrame frame = new JFrame("Guide");
        frame.setTitle("Trash Segregation Guide");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        JPanel panel = new JPanel(new GridLayout(3,1));
        
        //---text guide for user---//
        JTextArea biodegradableText = new JTextArea("Biodegradable Trash:\n" +
                "- Food scraps\n" +
                "- Yard waste\n" +
                "- Paper products (if not coated with plastic)\n" +
                "- Cardboard\n");
        biodegradableText.setEditable(false);
        biodegradableText.setBackground(Color.LIGHT_GRAY);

        JTextArea nonBiodegradableText = new JTextArea("Non-Biodegradable Trash:\n" +
                "- Plastics not marked with recycling symbol\n" +
                "- Styrofoam\n" +
                "- Broken glass\n" +
                "- Batteries\n");
        nonBiodegradableText.setEditable(false);
        nonBiodegradableText.setBackground(Color.LIGHT_GRAY);

        JTextArea recyclableText = new JTextArea("Recyclable Trash:\n" +
                "- Plastic bottles (marked with recycling symbol)\n" +
                "- Glass bottles and jars\n" +
                "- Paper and cardboard (clean and dry)\n" +
                "- Aluminum cans\n");
        recyclableText.setEditable(false);
        recyclableText.setBackground(Color.LIGHT_GRAY);
        //---END GUIDE---//

        panel.add(new JScrollPane(biodegradableText));
        panel.add(new JScrollPane(nonBiodegradableText));
        panel.add(new JScrollPane(recyclableText));
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
