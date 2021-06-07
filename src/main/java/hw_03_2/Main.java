package hw_03_2;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) {
        ShopCheckoutCallable shop1Checkout = new ShopCheckoutCallable(new IntegerListCreator().getNumbersList());
        ShopCheckoutCallable shop2Checkout = new ShopCheckoutCallable(new IntegerListCreator().getNumbersList());
        ShopCheckoutCallable shop3Checkout = new ShopCheckoutCallable(new IntegerListCreator().getNumbersList());

        ForkJoinPool pool = new ForkJoinPool();
        List<ShopCheckoutCallable> taskList = List.of(shop1Checkout, shop2Checkout, shop3Checkout);
        List<Future<LongAdder>> future = pool.invokeAll(taskList);
        LongAdder revenueAllShops = sumShopsCheckouts(future);
        printEachStoreSumCheckout(future);
        System.out.printf("Итого: %d руб.", revenueAllShops.longValue());
    }

    private static void printEachStoreSumCheckout(List<Future<LongAdder>> future) {
        AtomicInteger i = new AtomicInteger(1);
        future.forEach(f -> {
            try {
                System.out.printf("В магазин №%d за день в кассу поступило %d руб.\n", i.getAndIncrement(), f.get().longValue());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static LongAdder sumShopsCheckouts(List<Future<LongAdder>> future) {
        LongAdder revenueAllShops = new LongAdder();
        future.stream().parallel().forEach(f -> {
            try {
                revenueAllShops.add(f.get().longValue());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        return revenueAllShops;
    }
}
