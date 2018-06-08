package Task1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RateHandler  extends DefaultHandler {

    private boolean usTrigger;
    private boolean takeUsValue;

    private boolean euTrigger;
    private boolean takeEuValue;

    private boolean gbTrigger;
    private boolean takeGbValue;

    private double usRate;
    private double euRate;
    private double gbRate;

    public double getUsRate() {
        return usRate;
    }
    public double getEuRate() {
        return euRate;
    }
    public double getGbRate() {
        return gbRate;
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        if (!str.startsWith("<") && str.equalsIgnoreCase("Долар США")) {
            usTrigger = true;
            return;
        }
        if (usTrigger == true && takeUsValue != true) {
            takeUsValue = true;
            return;
        }
        if (usTrigger == true && takeUsValue == true) {
            usRate = Double.valueOf(str);
            usTrigger = false;
            takeUsValue = false;
        }

        if (!str.startsWith("<") && str.equalsIgnoreCase("Євро")) {
            euTrigger = true;
            return;
        }
        if (euTrigger == true && takeEuValue != true) {
            takeEuValue = true;
            return;
        }
        if (euTrigger == true && takeEuValue == true) {
            euRate = Double.valueOf(str);
            euTrigger = false;
            takeEuValue = false;
        }

        if (!str.startsWith("<") && str.equalsIgnoreCase("Фунт стерлінгів")) {
            gbTrigger = true;
            return;
        }
        if (gbTrigger == true && takeGbValue != true) {
            takeGbValue = true;
            return;
        }
        if (gbTrigger == true && takeGbValue == true) {
            gbRate = Double.valueOf(str);
            gbTrigger = false;
            takeGbValue = false;
        }
    }

}
