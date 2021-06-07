package hw_03_1;

public class Toy implements Runnable {
    private final long TIME_TO_OFF_TUMBLER_SWITCH = 500L;

    @Override
    public void run() {
        try {
            while (true) {
                if (TumblerSwitch.isTumblerSwitch()) {
                    Thread.sleep(TIME_TO_OFF_TUMBLER_SWITCH);
                    TumblerSwitch.setTumblerSwitch(false);
                    System.out.println("ВЫКЛ");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
