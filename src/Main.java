public class Main {


    public static void main(String[] args) {
        CycBuffer cycBuffer = new CycBuffer(20);

        Thread consumer = new Thread(new Consumer());
        Thread producer = new Thread(new Producer());
        producer.start();
        consumer.start();


        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println("sleep 500 millis");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        try {
            consumer.join();
            producer.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
