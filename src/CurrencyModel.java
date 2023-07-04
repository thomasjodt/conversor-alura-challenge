import javax.swing.*;

public class CurrencyModel {
    private DefaultComboBoxModel<String> model;

    public  CurrencyModel () {
        this.model = new DefaultComboBoxModel<>();
        model.addElement("PEN"); // Sol peruano
        model.addElement("USD"); // Dólar
        model.addElement("EUR"); // Euro
        model.addElement("GBP"); // Libra esterlina
        model.addElement("JPY"); // Yen japonés
        model.addElement("KRW"); // Won coreano
    }

    public ComboBoxModel getModel () {
        return this.model;
    }
}
