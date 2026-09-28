package milestone4_factory;

public abstract class Milk {
    private String region;
    private String style;

    protected Milk(String region, String style) {
        this.region = region;
        this.style = style;
    }

    public String getRegion() {
        return region;
    }

    public String getDescription() {
        return region + " milk: " + style;
    }
}