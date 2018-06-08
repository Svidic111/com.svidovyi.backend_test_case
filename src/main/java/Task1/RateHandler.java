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

    double usdRate = 0;
    double eurRate = 0;
    double gbpRate = 0;

    public double getUsdRate() {
        return usdRate;
    }
    public double getEurRate() {
        return eurRate;
    }
    public double getGbpRate() {
        return gbpRate;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Долар США")) {
            usTrigger = true;
        }
        if (qName.equalsIgnoreCase("Євро")) {
            euTrigger = true;
        }
        if (qName.equalsIgnoreCase("Фунт стерлінгів")) {
            gbTrigger = true;
        }
    }

    @Override
    public void endElement (String uri, String localName, String qName) throws SAXException {
        if (usTrigger) {
            takeUsValue = true;
            usTrigger = false;
        }
        if (euTrigger) {
            takeEuValue = true;
            euTrigger = false;
        }
        if (gbTrigger) {
            takeGbValue = true;
            gbTrigger = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (takeUsValue) {
            this.usdRate = Double.valueOf(new String(ch, start, length));
            takeUsValue = false;
        }
        if (takeEuValue) {
            this.eurRate = Double.valueOf(new String(ch, start, length));
            takeEuValue = false;
        }
        if (takeGbValue) {
            this.gbpRate = Double.valueOf(new String(ch, start, length));
            takeGbValue = false;
        }
    }

}
