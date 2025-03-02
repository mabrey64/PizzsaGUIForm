import javax.swing.*;

public class PizzaGUIFrame extends JFrame {
    JPanel mainPanel;
    JPanel crustPanel;
    JPanel sizePanel;
    JPanel toppingsPanel;
    JPanel buttonPanel;
    JPanel totalPanel;

    JLabel titleLabel;

    JTextArea totalArea;

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

    public int crustPrice;
    public int sizePrice;
    public int toppingsPrice;
    public int total;
    public double tax = .07;

    public PizzaGUIFrame() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        createCrustPanel();
        createSizePanel();
        createToppingsPanel();
        createButtonPanel();

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

    public void createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        orderButton = new JButton("Order");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        orderButton.addActionListener(e -> calculateTotal());
        clearButton.addActionListener(e -> {
            thinCrustButton.setSelected(false);
            regularCrustButton.setSelected(false);
            deepDishCrustButton.setSelected(false);
            pizzaSizeBox.setSelectedIndex(0);
            pepperoniBox.setSelected(false);
            sausageBox.setSelected(false);
            baconBox.setSelected(false);
            taterTotsBox.setSelected(false);
            pineappleBox.setSelected(false);
            chickenBox.setSelected(false);
        });
        exitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(orderButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel);
    }

    public int calculateCrustPrice() {
        if (thinCrustButton.isSelected()) {
            crustPrice = 5;
        } else if (regularCrustButton.isSelected()) {
            crustPrice = 7;
        } else if (deepDishCrustButton.isSelected()) {
            crustPrice = 9;
        }

        return crustPrice;
    }

    public int calculateSizePrice() {
        if (pizzaSizeBox.getSelectedIndex() == 0) {
            sizePrice = 8;
        } else if (pizzaSizeBox.getSelectedIndex() == 1) {
            sizePrice = 12;
        } else if (pizzaSizeBox.getSelectedIndex() == 2) {
            sizePrice = 16;
        } else if (pizzaSizeBox.getSelectedIndex() == 3) {
            sizePrice = 20;
        }

        return sizePrice;
    }

    public int calculateToppingsPrice() {
        toppingsPrice = 0;

        if (pepperoniBox.isSelected()) {
            toppingsPrice += 1;
        }
        if (sausageBox.isSelected()) {
            toppingsPrice += 1;
        }
        if (baconBox.isSelected()) {
            toppingsPrice += 1;
        }
        if (taterTotsBox.isSelected()) {
            toppingsPrice += 1;
        }
        if (pineappleBox.isSelected()) {
            toppingsPrice += 1;
        }
        if (chickenBox.isSelected()) {
            toppingsPrice += 1;
        }

        return toppingsPrice;
    }

    // Calculate the price of the pizza
    public int calculateTotal()
    {

    }

    public returnTotal()
    {
        
    }
}
