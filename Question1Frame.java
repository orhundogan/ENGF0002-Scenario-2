import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Question1Frame implements ActionListener {

    JFrame frame = new JFrame();

    JLabel questionLabel = new JLabel("A ∨ ¬B", SwingConstants.CENTER);

    JButton exitButton = new JButton("Exit");
    JButton checkButton = new JButton("Check");

    JPanel panel = new Q1Graphics();

    JTextField answer11 = new JTextField();
    JTextField answer12 = new JTextField();
    JTextField answer21 = new JTextField();
    JTextField answer22 = new JTextField();
    JTextField answer31 = new JTextField();
    JTextField answer32 = new JTextField();
    JTextField answer41 = new JTextField();
    JTextField answer42 = new JTextField();


    Question1Frame(){

        questionLabel.setFont(new Font("Monoscaped", Font.BOLD, 20));
        questionLabel.setForeground(Color.BLACK);
        questionLabel.setBounds(0,15,420,35);

        exitButton.setFocusable(false);
        exitButton.setBounds(55, 350, 100, 40);
        exitButton.addActionListener(this);

        checkButton.setFocusable(false);
        checkButton.setBounds(265, 350, 100, 40);
        checkButton.addActionListener(this);

        panel.setBounds(0, 60, 420, 330);
        panel.setLayout(null);
        panel.setBackground(new Color(0xFFCC99));
        panel.add(answer11);
        panel.add(answer12);
        panel.add(answer21);
        panel.add(answer22);
        panel.add(answer31);
        panel.add(answer32);
        panel.add(answer41);
        panel.add(answer42);

        answer11.setBounds(190, 71, 85, 20);
        answer11.setHorizontalAlignment(JTextField.CENTER);
        answer12.setBounds(275, 71, 125, 20);
        answer12.setHorizontalAlignment(JTextField.CENTER);
        answer21.setBounds(190, 125, 85, 20);
        answer21.setHorizontalAlignment(JTextField.CENTER);
        answer22.setBounds(275, 125, 125, 20);
        answer22.setHorizontalAlignment(JTextField.CENTER);
        answer31.setBounds(190, 179, 85, 20);
        answer31.setHorizontalAlignment(JTextField.CENTER);
        answer32.setBounds(275, 179, 125, 20);
        answer32.setHorizontalAlignment(JTextField.CENTER);
        answer41.setBounds(190, 233, 85, 20);
        answer41.setHorizontalAlignment(JTextField.CENTER);
        answer42.setBounds(275, 233, 125, 20);
        answer42.setHorizontalAlignment(JTextField.CENTER);

        frame.add(questionLabel);
        frame.add(exitButton);
        frame.add(checkButton);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0xFFCC99));
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);  // Opens the frame at the middle of screen
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == checkButton){
            checkCells(answer11, "1", panel);
            checkCells(answer12, "1", panel);
            checkCells(answer21, "0", panel);
            checkCells(answer22, "0", panel);
            checkCells(answer31, "1", panel);
            checkCells(answer32, "1", panel);
            checkCells(answer41, "0", panel);
            checkCells(answer42, "1", panel);
            checkButton.setEnabled(false);
        }

        if(e.getSource() == exitButton){
            frame.dispose();
            ExampleQuestionsFrame exampleQuestionsFrame = new ExampleQuestionsFrame();
        }

    }

    private void checkCells(JTextField textField, String correctAnswer, JPanel panel){
        String answer = textField.getText().replaceAll("\\s+","").toUpperCase();
        textField.setText("");
        textField.setVisible(false);
        JLabel label = new JLabel("", SwingConstants.CENTER);
        panel.add(label);
        label.setText(correctAnswer);
        label.setBounds(textField.getX(), textField.getY(), textField.getWidth(), textField.getHeight());
        if(answer.equals(correctAnswer)){
            label.setForeground(new Color(0x00b300));
        } else{
            label.setForeground(Color.RED);
        }
    }
}
