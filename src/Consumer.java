public class Consumer implements Runnable {

    CycBuffer buf;

    public Consumer() {
        buf = new CycBuffer();
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            buf.GetData();
            System.out.println(buf.getBuffer()[buf.getHead()]);
            buf.setBufferValAtIndex(buf.getHead(), -1);
            buf.setHead((buf.getHead() + 1) % buf.getBuffer().length);
        }

    }


}
