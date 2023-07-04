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
        CurrencyIn.setModel(new CurrencyModel().getModel());
        CurrencyOut.setModel(new CurrencyModel().getModel());
    }

    public void convertValues () {
        ConvertButton.addActionListener(e -> {
            if (Mount.getText().trim().equals("")) {
                System.out.println("No puede estar vacío");
                return;
            }

            double mount = Double.parseDouble(Mount.getText());
            double result = 1;

            String currencyInValue = (String) CurrencyIn.getSelectedItem();
            String currencyOutValue = (String) CurrencyOut.getSelectedItem();

            assert currencyInValue != null;
            switch (currencyInValue) {
                case "PEN" -> mount /= CurrencyRelation.PEN;
                case "USD" -> mount /= CurrencyRelation.USD;
                case "EUR" -> mount /= CurrencyRelation.EUR;
                case "GBP" -> mount /= CurrencyRelation.GBP;
                case "JPY" -> mount /= CurrencyRelation.JPY;
                case "KRW" -> mount /= CurrencyRelation.KRW;
            }

            assert currencyOutValue != null;
            switch (currencyOutValue) {
                case "PEN" -> result = mount * CurrencyRelation.PEN;
                case "USD" -> result = mount * CurrencyRelation.USD;
                case "EUR" -> result = mount * CurrencyRelation.EUR;
                case "GBP" -> result = mount * CurrencyRelation.GBP;
                case "JPY" -> result = mount * CurrencyRelation.JPY;
                case "KRW" -> result = mount * CurrencyRelation.KRW;
            }

            Result.setText(String.valueOf(result));
            Mount.setText("");
        });
    }
}
