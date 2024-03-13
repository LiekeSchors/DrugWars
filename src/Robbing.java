/**
 * @author Lieke Schors
 */
public class Robbing extends Event {
    @Override
    public void process(Player player) {
        player.setCash(0);
    }
}
