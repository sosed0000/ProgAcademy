public class BitcoinConverter {
    private double currencyBtcUsd;

    public BitcoinConverter(Double currencyBtcUsd) {
        this.currencyBtcUsd = currencyBtcUsd;
    }

    public Double houMuchBtcCanBuy (double usdAmount) {
        if(currencyBtcUsd <= 0) {
            System.out.println("Currency must be greater than 0");
            return null;
        }
        if (usdAmount <= 0) {
            System.out.println("USD amount must be greater than 0");
            return 0.0;
        }
        return usdAmount / currencyBtcUsd;
    }
}
