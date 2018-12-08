public class CycBuffer {


    private static int[] buffer;

    private static int head = 0;
    private static int tail = 0;

    public static void setBufferValAtIndex(int index, int value) {
        if (index > buffer.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        buffer[index] = value;
    }

    public static int[] getBuffer() {
        return buffer;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public CycBuffer() {
    }

    public CycBuffer(int bufferSize) {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("buffer size must be bigger that zero");
        }
        buffer = new int[bufferSize];

    }

    public void GetData() {
        while (tail == head) {
            try {
                Thread.sleep(500);
                //simulate latency
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void PutData() {
        while ((this.tail + 1) % buffer.length == head) {
            try {
                Thread.sleep(1000);
                //simulate latency
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
