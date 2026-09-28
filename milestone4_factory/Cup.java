package milestone4_factory;

public abstract class Cup {
    private String region;
    private String style;

    protected Cup(String region, String style) {
        this.region = region;
        this.style = style;
    }

    public String getRegion() {
        return region;
    }

    public String getDescription() {
        return region + " cup: " + style;
    }
}