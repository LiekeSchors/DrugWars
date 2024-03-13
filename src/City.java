public class City {
    public static final double DISTANCE_BRONX_GHETTO = 18.06;
    public static final double DISTANCE_BRONX_CENTRAL_PARK = 7.83;
    public static final double DISTANCE_BRONX_MANHATTAN = 10.73;
    public static final double DISTANCE_BRONX_CONEY_ISLAND = 28.65;
    public static final double DISTANCE_BRONX_BROOKLYN = 16.01;
    public static final double DISTANCE_GHETTO_CENTRAL_PARK = 14.04;
    public static final double DISTANCE_GHETTO_MANHATTAN = 12.68;
    public static final double DISTANCE_GHETTO_CONEY_ISLAND = 12.58;
    public static final double DISTANCE_GHETTO_BROOKLYN = 7.52;
    public static final double DISTANCE_CENTRAL_PARK_MANHATTAN = 2.98;
    public static final double DISTANCE_CENTRAL_PARK_CONEY_ISLAND = 22.27;
    public static final double DISTANCE_CENTRAL_PARK_BROOKLYN = 9.34;
    public static final double DISTANCE_MANHATTAN_CONEY_ISLAND = 19.64;
    public static final double DISTANCE_MANHATTAN_BROOKLYN = 6.84;
    public static final double DISTANCE_CONEY_ISLAND_BROOKLYN = 12.94;


    public String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
