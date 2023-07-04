import javax.swing.*;

public class CurrencyModel {
    public DefaultComboBoxModel<String> model;

    public  CurrencyModel () {
        this.model = new DefaultComboBoxModel<>();
        model.addElement("USD"); // Dólar
        model.addElement("PEN"); // Sol peruano
        model.addElement("EUR"); // Euro
        model.addElement("GBP"); // Libra esterlina
        model.addElement("JPY"); // Yen japonés
        model.addElement("KRW"); // Won coreano
    }
}
