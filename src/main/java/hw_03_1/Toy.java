package hw_03_1;

public class Toy implements Runnable {
    private User user;
    private final long TIME_TO_OFF_TUMBLER_SWITCH = 500L;

    public Toy(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            while (!user.isInterrupted()) {
                if (user.isTumblerSwitch()) {
                    Thread.sleep(TIME_TO_OFF_TUMBLER_SWITCH);
                    user.setTumblerSwitch(false);
                    System.out.println("ВЫКЛ");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
