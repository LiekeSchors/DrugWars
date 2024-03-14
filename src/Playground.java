public class Playground {
    public static void main(String[] args) {

        Information.showGameInformation();
        String username = Information.chooseUsername();

        Player player = new Player(username);
        System.out.println("Hello " + username + "! Have fun!\n");

        Information.chooseStartCity(player);


        boolean nextDay = false;

        while (player.getDay() < 30) {
            Player.setDay(player.getDay() + 1);
            player.startOfDay();
            //Preise ändern sich


            while (!nextDay) {
                int choice = Information.nextAction(player);
                if (!player.getCurrentCity().getName().equalsIgnoreCase("Bronx") || choice <= 3) {
                    SwitchMethods.basicActions(player, choice);
                } else {
                    SwitchMethods.bronxActions(player, choice);
                }

                if (choice == 3) {
                    nextDay = true; // Travelling costs one day, so after that, the next day starts
                }

            }
            player.endOfDay();
        }
    }
}