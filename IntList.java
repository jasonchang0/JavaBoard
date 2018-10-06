package JavaBoard;

public class IntList {
    private int head;
    private IntList tail;

    public IntList(int head, IntList tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean equals(Object obj) {
        IntList obj_copy = (IntList) obj;
        if (this.tail == null || obj_copy.tail == null) {
            return (this.head == obj_copy.head) && (this.tail == null) && (obj_copy.tail == null);
        }

        return (this.head == obj_copy.head) && this.tail.equals(obj_copy.tail);
    }

    @Override
    public int hashCode() {
        if (this.tail == null) {
            return this.head;
        }

        return this.head + this.tail.hashCode();
    }

    public void insertHead(int val) {
        this.tail = new IntList(this.head, this.tail);
        this.head = val;
    }

    public void insertTail(int val) {
        this.tail.tail = new IntList(0, null);
        this.tail.tail.insertHead(val);
    }

    public IntList len_copy(IntList L, int start, int len) {
        if (start == 0) {
            IntList result = new IntList(L.head, len_copy(L.tail, start, len - 1));
            return result;
        }

        return len_copy(L.tail, start - 1, len);

    }
}
