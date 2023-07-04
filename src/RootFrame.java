import javax.swing.*;

public class RootFrame extends JFrame {
    private JPanel RootFrame;
    private JTextField Result;
    private JButton ConvertButton;
    private JTextField Mount;
    private JComboBox<String> CurrencyIn;
    private JComboBox<String> CurrencyOut;

    public RootFrame() {
        addModels();
        convertValues();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        JFrame frame = new JFrame("Converter");
        frame.setContentPane(new RootFrame().RootFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    public void addModels () {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("PEN");
        model.addElement("USD");
        model.addElement("EUR");
        CurrencyIn.setModel(model);
        CurrencyOut.setModel(model);
    }

    public void convertValues () {
        ConvertButton.addActionListener(e -> {
            if (Mount.getText().trim().equals("")) return;

            double mount = Double.parseDouble(Mount.getText());
            double result = 1;

            String currencyInValue = (String) CurrencyIn.getSelectedItem();
            String currencyOutValue = (String) CurrencyOut.getSelectedItem();

            assert currencyInValue != null;
            if (currencyInValue.equals("PEN")) result = mount / CurrencyRelation.PEN;
            if (currencyInValue.equals("USD")) result = mount / CurrencyRelation.USD;
            if (currencyInValue.equals("EUR")) result = mount / CurrencyRelation.EUR;

            assert currencyOutValue != null;
            if (currencyOutValue.equals("PEN")) result *= CurrencyRelation.PEN;
            if (currencyOutValue.equals("USD")) result *= CurrencyRelation.USD;
            if (currencyOutValue.equals("EUR")) result *= CurrencyRelation.EUR;

            Result.setText(String.valueOf(result));
        });
    }
}
