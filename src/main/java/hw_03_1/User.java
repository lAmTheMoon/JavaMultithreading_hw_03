package hw_03_1;

public class User extends Thread {
    private final long TIME_TO_ON_TUMBLER_SWITCH = 1000L;
    private final int COUNT_TO_ON_TUMBLER_SWITCH = 10;

    @Override
    public void run() {
        try {
            for (int i = 0; i < COUNT_TO_ON_TUMBLER_SWITCH; i++) {
                Thread.sleep(TIME_TO_ON_TUMBLER_SWITCH);
                TumblerSwitch.setTumblerSwitch(true);
                System.out.println("ВКЛ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
