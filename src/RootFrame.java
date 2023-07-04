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
        CurrencyIn.setModel(new CurrencyModel().model);
        CurrencyOut.setModel(new CurrencyModel().model);
    }

    public void convertValues () {
        ConvertButton.addActionListener(e -> { // Action Listener con Lambda

            // Cláusula de guarda para impedir seguir con la lógica si no hay una cantidad esfecificada.
            if (Mount.getText().trim().equals("")) {
                System.out.println("No puede estar vacío");
                return;
            }

            // Cláusula para impedir que el programa continue si hay carácteres alfabéticos.
            if (Mount.getText().trim().matches("[a-zA-Z]+")) {
                System.out.println("Solo se admiten números");
                Mount.setText("");
                return;
            }

            // variables para monto y resultado
            double mount = Double.parseDouble(Mount.getText());
            double result = 1;

            // variables para los valores de conversión de divisas
            int currencyInValue = CurrencyIn.getSelectedIndex();
            int currencyOutValue = CurrencyOut.getSelectedIndex();

            // Condicionales para cada tipo de divisas
            // TODO: Mejorar lógica para escribir menos código y hacer el código más mantenible.
            if (currencyInValue == 0) {
                switch (currencyOutValue) {
                    case 0 -> result = mount;
                    case 1 -> result = mount * 3.6242;
                    case 2 -> result = mount * 0.919;
                    case 3 -> result = mount * 0.7866;
                    case 4 -> result = mount * 144.47;
                    case 5 -> result = mount * 1294.81;
                }
            }

            if (currencyInValue == 1) {
                switch (currencyOutValue) {
                    case 0 -> result = mount * 0.2755;
                    case 1 -> result = mount;
                    case 2 -> result = mount * 0.2532;
                    case 3 -> result = mount * 0.2167;
                    case 4 -> result = mount * 39.8002;
                    case 5 -> result = mount * 356.8614;
                }
            }

            if (currencyInValue == 2) {
                switch (currencyOutValue) {
                    case 0 -> result = mount * 1.088;
                    case 1 -> result = mount * 3.9492;
                    case 2 -> result = mount;
                    case 3 -> result = mount * 0.8559;
                    case 4 -> result = mount * 157.18;
                    case 5 -> result = mount * 1408.75;
                }
            }

            if (currencyInValue == 3) {
                switch (currencyOutValue) {
                    case 0 -> result = mount * 1.2712;
                    case 1 -> result = mount * 4.6142;
                    case 2 -> result = mount * 1.1684;
                    case 3 -> result = mount;
                    case 4 -> result = mount * 183.65;
                    case 5 -> result = mount * 1646.6321;
                }
            }

            if (currencyInValue == 4) {
                switch (currencyOutValue) {
                    case 0 -> result = mount * 0.0069;
                    case 1 -> result = mount * 0.0251;
                    case 2 -> result = mount * 0.0064;
                    case 3 -> result = mount * 0.0054;
                    case 4 -> result = mount;
                    case 5 -> result = mount * 8.9663;
                }
            }

            if (currencyInValue == 5) {
                switch (currencyOutValue) {
                    case 0 -> result = mount * 0.0008;
                    case 1 -> result = mount * 0.0028;
                    case 2 -> result = mount * 0.0007;
                    case 3 -> result = mount * 0.0006;
                    case 4 -> result = mount * 0.1115;
                    case 5 -> result = mount;
                }
            }

            Result.setText(String.valueOf(result));
        });
    }
}
