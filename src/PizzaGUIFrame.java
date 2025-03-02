import javax.swing.*;

public class PizzaGUIFrame extends JFrame {
    JPanel mainPanel;
    JPanel crustPanel;
    JPanel sizePanel;
    JPanel toppingsPanel;

    JLabel titleLabel;
    JLabel buttonLabel;

    JRadioButton thinCrustButton;
    JRadioButton regularCrustButton;
    JRadioButton deepDishCrustButton;

    JComboBox<String> pizzaSizeBox;

    JCheckBox pepperoniBox;
    JCheckBox sausageBox;
    JCheckBox baconBox;
    JCheckBox taterTotsBox;
    JCheckBox pineappleBox;
    JCheckBox chickenBox;

    JButton orderButton;
    JButton clearButton;
    JButton exitButton;

    public PizzaGUIFrame() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        createCrustPanel();
        createSizePanel();
        createToppingsPanel();

        setTitle("Pizza Order");
        setSize(400, 400);

    }

    public void createCrustPanel()
    {
        crustPanel = new JPanel();
        crustPanel.setLayout(new BoxLayout(crustPanel, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Crust");
        crustPanel.add(titleLabel);

        thinCrustButton = new JRadioButton("Thin");
        regularCrustButton = new JRadioButton("Regular");
        deepDishCrustButton = new JRadioButton("Deep Dish");

        ButtonGroup crustGroup = new ButtonGroup();
        crustGroup.add(thinCrustButton);
        crustGroup.add(regularCrustButton);
        crustGroup.add(deepDishCrustButton);

        crustPanel.add(thinCrustButton);
        crustPanel.add(regularCrustButton);
        crustPanel.add(deepDishCrustButton);

        mainPanel.add(crustPanel);
    }

    public void createSizePanel() {
        sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Size");
        sizePanel.add(titleLabel);

        String[] sizes = {"Small", "Medium", "Large"};
        pizzaSizeBox = new JComboBox<String>(sizes);

        sizePanel.add(pizzaSizeBox);

        mainPanel.add(sizePanel);
    }

    public void createToppingsPanel() {
        toppingsPanel = new JPanel();
        toppingsPanel.setLayout(new BoxLayout(toppingsPanel, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Toppings");
        toppingsPanel.add(titleLabel);

        pepperoniBox = new JCheckBox("Pepperoni");
        sausageBox = new JCheckBox("Sausage");
        baconBox = new JCheckBox("Bacon");
        taterTotsBox = new JCheckBox("Tater Tots");
        pineappleBox = new JCheckBox("Pineapple");
        chickenBox = new JCheckBox("Chicken");

        toppingsPanel.add(pepperoniBox);
        toppingsPanel.add(sausageBox);
        toppingsPanel.add(baconBox);
        toppingsPanel.add(taterTotsBox);
        toppingsPanel.add(pineappleBox);
        toppingsPanel.add(chickenBox);

        mainPanel.add(toppingsPanel);
    }

    public 
}
