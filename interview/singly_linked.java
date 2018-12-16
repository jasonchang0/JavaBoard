package interview;

public class singly_linked<T> {
    private singly_linked<T> next;
    private T data;
    private singly_linked<T> head;
    private singly_linked<T> tail;

    public singly_linked(T val, singly_linked<T> elem) {
        this.data = val;
        this.next = elem;
        this.head = this;
        this.tail = this;
    }

    public void setNext(singly_linked<T> next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public singly_linked<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public boolean equals(Object obj) {
        singly_linked<T> linked_obj = ((singly_linked) obj);
        return this.getData() == linked_obj.getData() && this.getNext().equals(linked_obj.getNext());
    }

    public void insert(int index, T item) {
        singly_linked<T> current = this;

        while (index > 0) {
            if (current.getNext() == null) {
                current.setNext(new singly_linked<>(item, current.getNext()));
                this.tail = current.getNext();
                return;
            }

            current = current.getNext();
            index -= 1;
        }

//        singly_linked<T> temp = current.getNext();
        singly_linked<T> temp = new singly_linked<>(current.getData(), current.getNext());
        current.setData(item);
        current.setNext(temp);

        if (index == 0) {
            this.head = current;
        }

    }

    public void delete(int index) {
        singly_linked<T> current = this;

        if (index == 0) {
            this.head = this.getNext();
            this.setData(this.getNext().getData());
            this.setNext(this.getNext().getNext());
        }

        while (index > 1) {
            if (current.getNext().getNext() == null) {
                current.setNext(null);
                this.tail = current;
            }

            current = current.getNext();
            index -= 1;
        }

        current.setNext(current.getNext().getNext());
    }

    public T MthToLast(int m) {
        singly_linked<T> current = this;
        singly_linked<T> m_behind = this.head;
        int n = 0;
        while (n < m) {
            current = current.getNext();
        }

        while (current.getNext() != null) {
            current = current.getNext();
            m_behind = m_behind.getNext();
        }

        return m_behind.getData();

    }

    public static void main (String[] args) {
        singly_linked<Integer> lst = new singly_linked<>(3, new singly_linked<>(2, new singly_linked<>(5, null)));
        lst.insert(3, 7);
        lst.delete(2);

        System.out.println(lst.hasNext());

        while(lst.hasNext()) {
            System.out.println(lst.getData());
            lst = lst.getNext();
        }
        System.out.println(lst.getData());

    }
}
