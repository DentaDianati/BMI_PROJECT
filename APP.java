
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class APP {

    public static void main(String[] args) {

        JFrame frame = new JFrame("BMI APP");

        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel(" MOHAMMADMAHDI DIANATI");
        JLabel label2 = new JLabel("     40322016");

        JButton button = new JButton("START");
    
        JPanel panel2 = new JPanel(new GridBagLayout());

        JLabel label_2 = new JLabel(" Height(m):");
        JTextField textField_2 = new JTextField(15);

        JLabel label2_2 = new JLabel(" Weight(kg):");
        JTextField textField2_2 = new JTextField(15);

        JButton button_2 = new JButton("Calculate BMI");

        JLabel label3_2 = new JLabel("BMI: ");

        button_2.addActionListener(e -> {
            if (textField_2.getText().trim().isEmpty()) {
                label3_2.setText("First value is required");
            }else if (textField2_2.getText().trim().isEmpty()) {
                label3_2.setText("Sec value is required");
            } else {
                float BMI = (float) Integer.parseInt(textField2_2.getText()) / (Float.parseFloat(textField_2.getText()) * Float.parseFloat(textField_2.getText()));
                label3_2.setText("BMI:" + String.valueOf(BMI));
            }
        });

        

        
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel2.add(label_2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel2.add(textField_2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel2.add(label2_2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel2.add(textField2_2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel2.add(button_2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel2.add(label3_2, gbc);





        panel.add(label,BorderLayout.WEST);
        panel.add(label2,BorderLayout.CENTER);

        panel.add(button,BorderLayout.SOUTH);

        button.addActionListener(
                new SwitchPanelListener(frame, panel, panel2)
        );


        frame.add(panel);

        frame.setSize(400, 250);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}

class SwitchPanelListener implements ActionListener {

    private JFrame frame;
    private JPanel currentPanel;
    private JPanel nextPanel;

    public SwitchPanelListener(JFrame frame, JPanel currentPanel, JPanel nextPanel) {
        this.frame = frame;
        this.currentPanel = currentPanel;
        this.nextPanel = nextPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.remove(currentPanel);
        frame.add(nextPanel);

        frame.revalidate();
        frame.repaint();
        
    }
}