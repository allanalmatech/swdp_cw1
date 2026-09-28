package milestone1_strategy;

public class NoDiscount implements PricingStrategy {
    public double calculateTotal(double subtotal) {
        return subtotal;
    }
}