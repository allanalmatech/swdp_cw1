package milestone4_factory;

public abstract class Beans {
    private String region;
    private String blend;

    protected Beans(String region, String blend) {
        this.region = region;
        this.blend = blend;
    }

    public String getRegion() {
        return region;
    }

    public String getDescription() {
        return region + " beans: " + blend;
    }
}