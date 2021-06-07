package hw_03_2;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.LongAdder;

public class ShopCheckoutCallable implements Callable<LongAdder> {
    private List<Integer> shopCheckout;
    private LongAdder revenueShop = new LongAdder();

    public ShopCheckoutCallable(List<Integer> shopCheckout) {
        this.shopCheckout = shopCheckout;
    }

    @Override
    public LongAdder call() {
        this.shopCheckout.stream().parallel().forEach(revenueShop::add);
        return revenueShop;
    }
}
