/**
 * @author Lieke Schors
 */
public class RandomGameEvents {
    private RandomGameEvents() {
    }

    static Event next() {
        double random = Math.random();
        if (random < 0.5) {
            return new FindDrugs();
        } else {
            return new Robbing();
        }
    }
}
