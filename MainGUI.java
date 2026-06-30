import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainGUI extends JFrame {
    private JTextField vehicleIdField, modelField, brandField, engineCapacityField;
    private JTextField doorsField, loadCapacityField;
    private JCheckBox hasCarrierCheckBox;
    private JComboBox<String> typeCombo;
    private JLabel doorsLabel, carrierLabel, loadCapacityLabel;
    private JButton addVehicleBtn, searchCarBtn, displayAllBtn;
    private JTextArea outputArea;
    private VehicleManager manager;

    public MainGUI() {
        setTitle("Vehicle Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 600);
        setLocationRelativeTo(null);

        manager = new VehicleManager();

        // Main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Row 0: Vehicle ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Vehicle ID:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        vehicleIdField = new JTextField(15);
        mainPanel.add(vehicleIdField, gbc);
        gbc.gridwidth = 1;

        // Row 1: Model
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        modelField = new JTextField(15);
        mainPanel.add(modelField, gbc);

        // Row 2: Brand
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Brand:"), gbc);
        gbc.gridx = 1;
        brandField = new JTextField(15);
        mainPanel.add(brandField, gbc);

        // Row 3: Engine Capacity
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Engine Capacity:"), gbc);
        gbc.gridx = 1;
        engineCapacityField = new JTextField(15);
        mainPanel.add(engineCapacityField, gbc);

        // Row 4: Type
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Type:"), gbc);
        gbc.gridx = 1;
        typeCombo = new JComboBox<>(new String[]{"Motorcycle", "Car", "Van"});
        mainPanel.add(typeCombo, gbc);

        // Row 5: Number of Doors (Car-specific)
        gbc.gridx = 0;
        gbc.gridy = 5;
        doorsLabel = new JLabel("Number of Doors:");
        mainPanel.add(doorsLabel, gbc);
        gbc.gridx = 1;
        doorsField = new JTextField(15);
        mainPanel.add(doorsField, gbc);

        // Row 6: Has Carrier (Motorcycle-specific)
        gbc.gridx = 0;
        gbc.gridy = 6;
        carrierLabel = new JLabel("Has Carrier:");
        mainPanel.add(carrierLabel, gbc);
        gbc.gridx = 1;
        hasCarrierCheckBox = new JCheckBox();
        mainPanel.add(hasCarrierCheckBox, gbc);

        // Row 7: Load Capacity (Van-specific)
        gbc.gridx = 0;
        gbc.gridy = 7;
        loadCapacityLabel = new JLabel("Load Capacity:");
        mainPanel.add(loadCapacityLabel, gbc);
        gbc.gridx = 1;
        loadCapacityField = new JTextField(15);
        mainPanel.add(loadCapacityField, gbc);

        // Row 8: Buttons
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        addVehicleBtn = new JButton("Add Vehicle");
        searchCarBtn = new JButton("Search Car");
        displayAllBtn = new JButton("Display All");
        buttonPanel.add(addVehicleBtn);
        buttonPanel.add(searchCarBtn);
        buttonPanel.add(displayAllBtn);
        mainPanel.add(buttonPanel, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;

        // Row 9: Output Area
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        mainPanel.add(scrollPane, gbc);

        // Add ItemListener to ComboBox for dynamic field visibility
        typeCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = (String) typeCombo.getSelectedItem();
                    updateDynamicFields(selected);
                }
            }
        });

        // Set initial visibility based on default selection
        updateDynamicFields((String) typeCombo.getSelectedItem());

        // Add Vehicle Button ActionListener
        addVehicleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate that no visible text fields are empty
                if (vehicleIdField.getText().trim().isEmpty() ||
                    modelField.getText().trim().isEmpty() ||
                    brandField.getText().trim().isEmpty() ||
                    engineCapacityField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(MainGUI.this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String selectedType = (String) typeCombo.getSelectedItem();

                // Validate dynamic fields based on selected type
                if (selectedType.equals("Car") && doorsField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(MainGUI.this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (selectedType.equals("Van") && loadCapacityField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(MainGUI.this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Parse numeric values with try-catch
                try {
                    String vehicleID = vehicleIdField.getText().trim();
                    String model = modelField.getText().trim();
                    String brand = brandField.getText().trim();
                    double engineCapacity = Double.parseDouble(engineCapacityField.getText().trim());

                    Vehicle newVehicle = null;

                    switch (selectedType) {
                        case "Motorcycle":
                            boolean hasCarrier = hasCarrierCheckBox.isSelected();
                            newVehicle = new Motorcycle(vehicleID, model, brand, engineCapacity, hasCarrier);
                            break;
                        case "Car":
                            int doors = Integer.parseInt(doorsField.getText().trim());
                            newVehicle = new Car(vehicleID, model, brand, engineCapacity, doors);
                            break;
                        case "Van":
                            double loadCapacity = Double.parseDouble(loadCapacityField.getText().trim());
                            newVehicle = new Van(vehicleID, model, brand, engineCapacity, loadCapacity);
                            break;
                    }

                    boolean added = manager.addVehicle(newVehicle);
                    if (!added) {
                        JOptionPane.showMessageDialog(MainGUI.this, "Duplicate model detected!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        clearInputFields();
                        JOptionPane.showMessageDialog(MainGUI.this, "Vehicle added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainGUI.this, "Please enter valid numeric values for Engine Capacity, Number of Doors, and Load Capacity.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Search Car Button ActionListener
        searchCarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String model = JOptionPane.showInputDialog(MainGUI.this, "Enter the model to search:");
                if (model != null && !model.trim().isEmpty()) {
                    Car foundCar = manager.searchCar(model.trim());
                    if (foundCar != null) {
                        outputArea.append(foundCar.displayInfo() + "\n-----------------\n");
                    } else {
                        outputArea.append("No car found with that model\n-----------------\n");
                    }
                }
            }
        });

        // Display All Button ActionListener
        displayAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String allVehicles = manager.displayAllVehicles();
                outputArea.setText("");
                outputArea.setText(allVehicles);
            }
        });

        add(mainPanel);
    }

    private void clearInputFields() {
        vehicleIdField.setText("");
        modelField.setText("");
        brandField.setText("");
        engineCapacityField.setText("");
        doorsField.setText("");
        loadCapacityField.setText("");
        hasCarrierCheckBox.setSelected(false);
    }

    private void updateDynamicFields(String type) {
        switch (type) {
            case "Motorcycle":
                doorsLabel.setVisible(false);
                doorsField.setVisible(false);
                carrierLabel.setVisible(true);
                hasCarrierCheckBox.setVisible(true);
                loadCapacityLabel.setVisible(false);
                loadCapacityField.setVisible(false);
                break;
            case "Car":
                doorsLabel.setVisible(true);
                doorsField.setVisible(true);
                carrierLabel.setVisible(false);
                hasCarrierCheckBox.setVisible(false);
                loadCapacityLabel.setVisible(false);
                loadCapacityField.setVisible(false);
                break;
            case "Van":
                doorsLabel.setVisible(false);
                doorsField.setVisible(false);
                carrierLabel.setVisible(false);
                hasCarrierCheckBox.setVisible(false);
                loadCapacityLabel.setVisible(true);
                loadCapacityField.setVisible(true);
                break;
        }
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
}