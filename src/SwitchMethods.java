/**
 * @author Lieke Schors
 */
public class SwitchMethods {

    public static void basicActions(Player player, int choice) {
        switch (choice) {
            case 1:
                player.buy(player);
                break;
            case 2:
                player.sell();
                break;
            case 3:
                player.travelTo(player);
                break;
            default:
                System.out.println("This is not a performable action.");
        }
    }

    public static void bronxActions(Player player, int choice) {
        switch (choice) {
            case 4:
                player.addMoneyToBankAccount(player);
                break;
            case 5:
                player.drawMoneyFromBankAccount(player);
                break;
            case 6:
                player.loanFromLoanshark(player);
                break;
            case 7:
                player.payLoansharkBack(player);
                break;
            case 8:
                player.saveDrugsInDepot(player);
                break;
            default:
                System.out.println("This is not a performable action.");
        }
    }

}
