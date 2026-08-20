import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorView {

    private ArrayList<String> buttons;
    private JFrame frame;
    private JPanel masterPanel;
    private JPanel buttonPanel;
    private JPanel calcScreen;
    private JTextField calcDefault;
    private JButton calcButtons;

    public CalculatorView() {
        //set sizing
        frame = new JFrame("CalculatorGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout(10, 10));

        buttons = new ArrayList<>();
        createButtons();

        masterPanel = new JPanel(new GridLayout(2, 1));

        //button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create screen panel
        calcScreen = new JPanel();
        calcScreen.setLayout(new GridLayout(1, 1));

        //set default value for calc screen which is 0
        calcDefault = new JTextField();
        calcDefault.setText("0");
        calcDefault.setVisible(true);
        calcDefault.setFont(new Font("Times New Roman", Font.BOLD, 50));

        //add to calc main screen
        calcScreen.add(calcDefault);

        //iterate through the list of buttons and add them to button panel
        for (String list : buttons) {
            calcButtons = new JButton(list);
            calcButtons.setFont(new Font("Times New Roman", Font.BOLD, 20));
            buttonPanel.add(calcButtons);
        }

        masterPanel.add(calcScreen);
        masterPanel.add(buttonPanel);
        frame.add(masterPanel);
        frame.setVisible(true);

    }


    //create the list of buttons on basic calc
    public void createButtons() {
        buttons.add("delete");
        buttons.add("C");
        buttons.add("%");
        buttons.add("/");
        buttons.add("7");
        buttons.add("8");
        buttons.add("9");
        buttons.add("*");
        buttons.add("4");
        buttons.add("5");
        buttons.add("6");
        buttons.add("-");
        buttons.add("1");
        buttons.add("2");
        buttons.add("3");
        buttons.add("+");
        buttons.add("+/-");
        buttons.add("0");
        buttons.add(".");
        buttons.add("=");
    }

    public void buttonActionListener(ActionListener listenForButton) {
        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addActionListener(listenForButton);
            }
        }
    }

    public void setCalcScreen(String num) {
        calcDefault.setText(num);

    }

    public String getCalcScreen() {
        return calcDefault.getText();
    }
}



