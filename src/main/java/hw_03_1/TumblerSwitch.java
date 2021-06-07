package hw_03_1;

public class TumblerSwitch {
    private static volatile boolean tumblerSwitch = false;

    public static boolean isTumblerSwitch() {
        return tumblerSwitch;
    }

    public static void setTumblerSwitch(boolean tumblerSwitch) {
        TumblerSwitch.tumblerSwitch = tumblerSwitch;
    }
}
