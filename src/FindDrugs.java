import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Lieke Schors
 */
public class FindDrugs extends Event {

    @Override
    public void process(Player player) {
        Drugs newDrug = Drugs.randomDrugs();
        player.addDrugs(newDrug);
    }
}
