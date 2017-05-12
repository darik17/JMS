/**
 * Created by admin on 12.05.2017. 123
 */
public class MainClass {
    public static void main(String[] args) {
        new Thread(() -> {
            MyMessageConsumer myMessageConsumer = new MyMessageConsumer();
            myMessageConsumer.receivedMessage();
        }).start();
        new Thread(() -> {
            MyMessageProvider myMessageProvider = new MyMessageProvider();
            myMessageProvider.sendMessage("Hello :)");
        }).start();
    }
}
