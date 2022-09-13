import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        String input;
        Double currency;
        Double usdAmount;

        while (true) {
            System.out.println("Input \"q\" anytime to quit!");
            System.out.println("------------------------------");

            //Getting BTC price
            System.out.println("What is Bitcoin price today?");
            while (true) {
                input = readLine();
                if (isQuit(input)) {
                    quit();
                    return;
                }
                currency = readPositiveDouble(input);
                if (currency == null) continue;
                else break;
            }

            //Getting USD amount
            System.out.println("How much $ do you have?");
            while (true) {
                input = readLine();
                if (isQuit(input)) {
                    quit();
                    return;
                }
                usdAmount = readPositiveDouble(input);
                if (usdAmount == null) continue;
                else break;
            }

            BitcoinConverter converter = new BitcoinConverter(currency);
            System.out.printf("You can buy %f BTC \n", converter.houMuchBtcCanBuy(usdAmount));
            System.out.println("------------------------------");

            System.out.print("Please input \"q\" to quit or \"c\" to continue: ");
            input = readLine();
            if (isQuit(input)) {
                quit();
                return;
            }
            System.out.println("\n\n");
        }

    }

    //Console reading
    public static String readLine() {
//System.in не должен быть закрыт (освободиться сам при окончании работы программы)! Иначе следующую строку не считать!
        String input;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            input = reader.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return input;
    }

    //Actions before closing the program
    public static void quit() {
        System.out.println("------------------------------");
        System.out.println("Good bye!");
    }

    //Parsing Double
    public static Double readPositiveDouble(String input) {

        try {
            Double d = Double.parseDouble(input);
            if (d <= 0) throw new NumberFormatException();
            return d;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a positive number greater than 0!");
            return null;
        }
    }


    //Keywords to quit
    public static boolean isQuit(String input) {
        return (input.contains("q") || input.contains("Q"));
    }

}

