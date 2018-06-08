package Task1;

public class Main {
    public static void main(String[] args) {
        Convertor convertor = new Convertor();
        System.out.println(convertor.converteUSD(100.00, "grn"));
        System.out.println(convertor.converteUSD(100.00, "eur"));
        System.out.println(convertor.converteUSD(100.00, "gbp"));
        System.out.println(convertor.converteUSD(100.00, "rrr"));
    }
}
