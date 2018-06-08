package Task1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ExchangeRate {
    public static final String URL_SOURCE = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange";

    private double usdRate;
    private double eurRate;
    private double gbpRate;

    public void setCurrentRate() {
        try {
            URL urlObject = new URL(URL_SOURCE);

            InputStream in = urlObject.openStream();

            XMLReader xr = XMLReaderFactory.createXMLReader();

            RateHandler rateHandler = new RateHandler();

            xr.setContentHandler(rateHandler);

            InputSource inSource = new InputSource(in);

            xr.parse(inSource);

            usdRate = rateHandler.getUsRate();
            eurRate = rateHandler.getEuRate();
            gbpRate = rateHandler.getGbRate();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        }

    }

    public double getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(double d) {
        usdRate = d;
    }

    public double getEurRate() {
        return eurRate;
    }

    public void setEurRate(double d) {
        eurRate = d;
    }

    public double getGbpRate() {
        return gbpRate;
    }

    public void setGbpRate(double d) {
        gbpRate = d;
    }

}
