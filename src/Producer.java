public class Producer implements Runnable {

    CycBuffer buf;

    public Producer() {
        buf = new CycBuffer();
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            buf.PutData();
            System.out.println(buf.getBuffer()[buf.getTail()]);
            buf.setBufferValAtIndex(buf.getTail(), i);
            buf.setTail((buf.getTail() + 1) % buf.getBuffer().length);
        }

    }
}
