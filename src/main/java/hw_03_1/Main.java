package hw_03_1;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Toy toy = new Toy(user);
        Thread threadUser = new Thread(user);
        Thread threadToy = new Thread(toy);
        threadUser.start();
        threadToy.setDaemon(true);
        threadToy.start();
        try {
            threadUser.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
