import java.util.Scanner;

/**
 * @author Lieke Schors
 */
public class Information {
    private static Scanner sc = new Scanner(System.in);

    public static void showGameInformation() {
        System.out.println("""
                You are a drug dealer in New York City. Your goal is to earn as much money as possible by selling drugs.
                You start with 2000$ of cash and 0$ of depts. You can lend money from the Loanshark, put your money on
                your bankaccount and draw from your bankaccount. The bank and Loanshark are in the Bronx. Your secret
                drug depot is also in the Bronx. If you get a loan, you pay a dept interest, if you save money on 
                your bank account, you'll get a savings interest.
                
                Available drugs: Cocaine, Heroin, Acid, Grass, Speed and Ludes. You can buy and sell these drugs. 
                The price changes if you choose to travel, so sometimes you will lose and sometimes you will gain money from 
                selling. You can carry 100 products at max.
                
                You can travel to Bronx, Ghetto, Central Park, Manhattan, Coney Island, Brooklyn. Travelling costs 
                money and takes a day. You can't travel to the city you are actually at.
                
                During travelling, things can happen:
                - You could get robbed. Than you'll lose all your cash. 
                - You could find drugs.
                You can't choose these actions. They'll just happen while travelling.
                
                After 30 days, the game will end and your gains and depts will be calculated.
                """);
    }

    public static String chooseUsername() {
        System.out.println("Choose a username: ");
        return sc.nextLine();
    }

    public static void chooseStartCity(Player player) {

        boolean cityFound;
        do {
            System.out.println("First, choose a city-part to start from (Bronx, Ghetto, Central Park, Manhattan, Coney Island, Brooklyn): ");
            String city =  sc.nextLine().toLowerCase();
            switch (city) {
                case "bronx":
                    player.setCurrentCity(new Bronx());
                    System.out.println("You'll start in the Bronx.\n");
                    cityFound = true;
                    break;
                case "ghetto":
                    player.setCurrentCity(new City("Ghetto"));
                    System.out.println("You'll start in the Ghetto.\n");
                    cityFound = true;
                    break;
                case "central park":
                    player.setCurrentCity(new City("Central Park"));
                    System.out.println("You'll start in Central Park.\n");
                    cityFound = true;
                    break;
                case "manhattan":
                    player.setCurrentCity(new City("Manhattan."));
                    System.out.println("You'll start in Manhattan.\n");
                    cityFound = true;
                    break;
                case "coney island":
                    player.setCurrentCity(new City("Coney Island"));
                    System.out.println("You'll start in Coney Island.\n");
                    cityFound = true;
                    break;
                case "brooklyn":
                    player.setCurrentCity(new City("Brooklyn"));
                    System.out.println("You'll start in Brooklyn.\n");
                    cityFound = true;
                    break;
                default:
                    System.out.println("You can't choose this city.\n");
                    cityFound = false;
            }
        } while (!cityFound);
    }

    public static int nextAction(Player player) {
        System.out.println();
        System.out.println("What do you want to do?");
        String currentCity = player.getCurrentCity().getName();
        System.out.println("You are in " + currentCity);
        System.out.println("""
                    Your options are:\s
                    1) Buy drugs.
                    2) Sell drugs.
                    3) Travel to another city part.""");

        if (currentCity.equalsIgnoreCase("Bronx")) {
            System.out.println("""
                        4) Save money on bank account.
                        5) Draw money from bank account.
                        6) Loan money from Loanshark.
                        7) Pay Loanshark back.
                        8) Save drugs in drug depot.
                        """);
        }
        System.out.println();

        return sc.nextInt();
    }
}
