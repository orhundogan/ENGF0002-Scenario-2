import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Question3Frame implements ActionListener {

    JFrame frame = new JFrame();

    JLabel questionLabel = new JLabel("A ∧ (B ∨ C)", SwingConstants.CENTER);

    JButton exitButton = new JButton("Exit");
    JButton checkButton = new JButton("Check");

    JPanel panel = new Q3Graphics();

    JTextField answer11 = new JTextField();
    JTextField answer12 = new JTextField();
    JTextField answer21 = new JTextField();
    JTextField answer22 = new JTextField();
    JTextField answer31 = new JTextField();
    JTextField answer32 = new JTextField();
    JTextField answer41 = new JTextField();
    JTextField answer42 = new JTextField();
    JTextField answer51 = new JTextField();
    JTextField answer52 = new JTextField();
    JTextField answer61 = new JTextField();
    JTextField answer62 = new JTextField();
    JTextField answer71 = new JTextField();
    JTextField answer72 = new JTextField();
    JTextField answer81 = new JTextField();
    JTextField answer82 = new JTextField();

    Question3Frame(){
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
        panel.add(answer51);
        panel.add(answer52);
        panel.add(answer61);
        panel.add(answer62);
        panel.add(answer71);
        panel.add(answer72);
        panel.add(answer81);
        panel.add(answer82);

        answer11.setBounds(230, 35, 80, 20);
        answer11.setHorizontalAlignment(JTextField.CENTER);
        answer12.setBounds(310, 35, 90, 20);
        answer12.setHorizontalAlignment(JTextField.CENTER);
        answer21.setBounds(230, 65, 80, 20);
        answer21.setHorizontalAlignment(JTextField.CENTER);
        answer22.setBounds(310, 65, 90, 20);
        answer22.setHorizontalAlignment(JTextField.CENTER);
        answer31.setBounds(230, 95, 80, 20);
        answer31.setHorizontalAlignment(JTextField.CENTER);
        answer32.setBounds(310, 95, 90, 20);
        answer32.setHorizontalAlignment(JTextField.CENTER);
        answer41.setBounds(230, 125, 80, 20);
        answer41.setHorizontalAlignment(JTextField.CENTER);
        answer42.setBounds(310, 125, 90, 20);
        answer42.setHorizontalAlignment(JTextField.CENTER);
        answer51.setBounds(230, 155, 80, 20);
        answer51.setHorizontalAlignment(JTextField.CENTER);
        answer52.setBounds(310, 155, 90, 20);
        answer52.setHorizontalAlignment(JTextField.CENTER);
        answer61.setBounds(230, 185, 80, 20);
        answer61.setHorizontalAlignment(JTextField.CENTER);
        answer62.setBounds(310, 185, 90, 20);
        answer62.setHorizontalAlignment(JTextField.CENTER);
        answer71.setBounds(230, 215, 80, 20);
        answer71.setHorizontalAlignment(JTextField.CENTER);
        answer72.setBounds(310, 215, 90, 20);
        answer72.setHorizontalAlignment(JTextField.CENTER);
        answer81.setBounds(230, 245, 80, 20);
        answer81.setHorizontalAlignment(JTextField.CENTER);
        answer82.setBounds(310, 245, 90, 20);
        answer82.setHorizontalAlignment(JTextField.CENTER);


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
            checkCells(answer11, "0", panel);
            checkCells(answer12, "0", panel);
            checkCells(answer21, "1", panel);
            checkCells(answer22, "0", panel);
            checkCells(answer31, "1", panel);
            checkCells(answer32, "0", panel);
            checkCells(answer41, "1", panel);
            checkCells(answer42, "0", panel);
            checkCells(answer51, "0", panel);
            checkCells(answer52, "0", panel);
            checkCells(answer61, "1", panel);
            checkCells(answer62, "1", panel);
            checkCells(answer71, "1", panel);
            checkCells(answer72, "1", panel);
            checkCells(answer81, "1", panel);
            checkCells(answer82, "1", panel);
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
