package milestone1_strategy;

public class HappyHourPricing implements PricingStrategy {
    private double rate;
    private double minimumSpend;

    public HappyHourPricing(double rate, double minimumSpend) {
        this.rate = rate;
        this.minimumSpend = minimumSpend;
    }

    public double calculateTotal(double subtotal) {
        if (subtotal < minimumSpend) {
            return subtotal; // happy hour only kicks in above the minimum order.
        }
        return subtotal - subtotal * rate;
    }
}