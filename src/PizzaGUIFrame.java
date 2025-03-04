import javax.swing.*;
import java.awt.*;

/**
 * This class creates a GUI for a pizza order form.
 * The user can select the size, crust, and toppings for their pizza.
 * The user can also calculate the total price of the pizza.
 * The user can also clear the form and exit the program.
 */
public class PizzaGUIFrame extends JFrame {
    // Declare all the components
    JPanel mainPanel;
    JPanel crustPanel;
    JPanel sizePanel;
    JPanel toppingsPanel;
    JPanel buttonPanel;
    JPanel totalPanel;

    JLabel titleLabel;

    JTextArea receiptArea;

    JRadioButton thinCrustButton;
    JRadioButton regularCrustButton;
    JRadioButton deepDishCrustButton;

    JComboBox<String> pizzaSizeBox;
    ButtonGroup crustGroup;

    JCheckBox pepperoniBox;
    JCheckBox sausageBox;
    JCheckBox baconBox;
    JCheckBox taterTotsBox;
    JCheckBox pineappleBox;
    JCheckBox chickenBox;

    JButton orderButton;
    JButton clearButton;
    JButton exitButton;

    // Declare variables to store the prices
    public int crustPrice;
    public int sizePrice;
    public int toppingsPrice;
    public double total;
    public double tax = .07;

    /**
     * Constructor for the PizzaGUIFrame class.
     * This constructor creates the GUI for the pizza order form.
     * It creates the size, crust, toppings, and button panels.
     * GridBagLayout is used to layout the components in the frame, which is a new component that I learned about while working on this project.
     */
    public PizzaGUIFrame() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // Create a new GridBagConstraints object to layout the components
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);

        createCrustPanel();
        createSizePanel();
        createToppingsPanel();
        createButtonPanel();
        createTotalPanel();

        // Then each panel gets a GridBagConstraints object to layout the components, which are then added to the mainPanel
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        mainPanel.add(sizePanel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        mainPanel.add(crustPanel, c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        mainPanel.add(toppingsPanel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.weightx = 1;
        c.weighty = 0.1;
        mainPanel.add(totalPanel, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.weightx = 1;
        c.weighty = 1;
        mainPanel.add(buttonPanel, c);

        setTitle("Pizza Order");
        setSize(800, 600);
        add(mainPanel);
        setVisible(true);
    }


    /**
     * This method creates the size panel for the pizza order form.
     * It creates a title label, a combo box for the pizza size, and adds them to the size panel.
     */
    public void createSizePanel() {
        sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Size");
        sizePanel.add(titleLabel);

        String[] sizes = {"Small", "Medium", "Large"};
        pizzaSizeBox = new JComboBox<String>(sizes);

        pizzaSizeBox.setPreferredSize(new Dimension(100, 20));
        pizzaSizeBox.setMaximumSize(new Dimension(200, 40));

        sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));
        sizePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sizePanel.add(pizzaSizeBox);

        mainPanel.add(sizePanel);
    }

    /**
     * This method creates the crust panel for the pizza order form.
     * It creates a title label, radio buttons for the crust options, and adds them to the crust panel.
     */
    public void createCrustPanel()
    {
        crustPanel = new JPanel();
        crustPanel.setLayout(new BoxLayout(crustPanel, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Crust");
        crustPanel.add(titleLabel);

        thinCrustButton = new JRadioButton("Thin");
        regularCrustButton = new JRadioButton("Regular");
        deepDishCrustButton = new JRadioButton("Deep Dish");

        crustGroup = new ButtonGroup();
        crustGroup.add(thinCrustButton);
        crustGroup.add(regularCrustButton);
        crustGroup.add(deepDishCrustButton);

        crustPanel.add(thinCrustButton);
        crustPanel.add(regularCrustButton);
        crustPanel.add(deepDishCrustButton);

        crustPanel.setBorder(BorderFactory.createTitledBorder("Crust"));
        crustPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel.add(crustPanel);
    }

    /**
     * This method creates the toppings panel for the pizza order form.
     * It creates a title label, check boxes for the toppings options, and adds them to the toppings panel.
     */
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

        toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));
        toppingsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        mainPanel.add(toppingsPanel);
    }

    /**
     * This method creates the button panel for the pizza order form.
     * It creates buttons for ordering, clearing the form, and exiting the program.
     * Rigid areas are added to space out the buttons.
     */
    public void createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        orderButton = new JButton("Order");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        orderButton.addActionListener(e -> displayTotal());
        clearButton.addActionListener(e -> {
            crustGroup.clearSelection();
            pizzaSizeBox.setSelectedIndex(0);
            pepperoniBox.setSelected(false);
            sausageBox.setSelected(false);
            baconBox.setSelected(false);
            taterTotsBox.setSelected(false);
            pineappleBox.setSelected(false);
            chickenBox.setSelected(false);
            mainPanel.remove(totalPanel);
            mainPanel.revalidate();
            mainPanel.repaint();
        });
        exitButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(null, "Would you like to exit the program?", "Exit", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        buttonPanel.add(orderButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(150, 0)));
        buttonPanel.add(clearButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(150, 0)));
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel);
    }

    /**
     * This method creates the total panel for the pizza order form.
     * It creates a text area for the receipt and adds it to the total panel.
     */
    private void createTotalPanel()
    {
        totalPanel = new JPanel();
        totalPanel.setBorder(BorderFactory.createTitledBorder("Total"));
        totalPanel.setLayout(new BorderLayout());
    }

    /**
     * This method calculates the price of the crust based on the selected radio button.
     * It returns the price of the crust.
     */
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

    /**
     * This method calculates the price of the size based on the selected combo box item.
     * It returns the price of the size.
     */
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

    /**
     * This method calculates the price of the toppings based on the selected check boxes.
     * It returns the price of the toppings.
     */
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
    public void calculateTotal()
    {
        total = calculateCrustPrice() + calculateSizePrice() + calculateToppingsPrice();
        total = (double) (total + (total * tax));
    }

    /**
     * This method displays the total price of the pizza in a text area.
     * It calculates the total price of the pizza and displays it in the text area.
     */
    public void displayTotal()
    {
        calculateTotal();
        receiptArea = new JTextArea();
        StringBuilder receipt = new StringBuilder();

        double crustPrice = calculateCrustPrice();
        double sizePrice = calculateSizePrice();
        double toppingsPrice = calculateToppingsPrice();
        double subTotal = crustPrice + sizePrice + toppingsPrice;
        double taxAmount = subTotal * tax;
        double total = subTotal + taxAmount;

        receipt.append("=====================================\n");
        receipt.append(String.format("%-20s %10s\n", "Size", "$" + String.format("%.2f", sizePrice)));
        receipt.append(String.format("%-20s %10s\n", "Crust", "$" + String.format("%.2f", crustPrice)));
        receipt.append(String.format("%-20s %10s\n", "Toppings", "$" + String.format("%.2f", toppingsPrice)));
        receipt.append("\n");
        receipt.append(String.format("%-20s %10s\n", "Sub-total", "$" + String.format("%.2f", subTotal)));
        receipt.append(String.format("%-20s %10s\n", "Tax", "$" + String.format("%.2f", taxAmount)));
        receipt.append("-------------------------------------\n");
        receipt.append(String.format("%-20s %10s\n", "Total", "$" + String.format("%.2f", total)));
        receipt.append("=====================================\n");

        receiptArea.setText(receipt.toString());
        receiptArea.setEditable(false);

        totalPanel.removeAll();
        totalPanel.add(new JScrollPane(receiptArea), BorderLayout.CENTER);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        mainPanel.add(totalPanel, c);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
