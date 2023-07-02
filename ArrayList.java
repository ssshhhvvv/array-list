import java.util.Arrays;

public class ArrayList {
    private Object[] array;
    private int capacity;
    private int size;

    public ArrayList() {
        capacity = 10;
        array = new Object[capacity];
    }

    public ArrayList(int initialCapacity) {
        capacity = initialCapacity;
        array = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return array[index];
    }

    public void add(Object element) {
        if (size == capacity) grow();
        array[size++] = element;
    }

    public void add(int index, Object element) {
        if (size == capacity) grow();
        for (int i = size++ - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
    }

    public void remove(int index) {
        removeInIndex(index);
    }

    public boolean remove(Object element) {
        boolean isElement = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                isElement = true;
                removeInIndex(i);
                break;
            }
        }
        return isElement;
    }

    public void set(int index, Object element) {
        array[index] = element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        System.out.println(toString());
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, capacity);
    }

    public void trimToSize() {
        capacity = size;
        array = Arrays.copyOf(array, capacity);
    }

    public void clear() {
        size = 0;
        capacity = 10;
        array = new Object[capacity];
    }

    @Override
    public String toString() {
        String string = "[";
        for (int i = 0; i < size; i++) {
            string += array[i].toString() + ", ";
        }
        string = string.length() > 1 ? string.substring(0, string.length() - 2).concat("]") : string.concat("]");
        return string;
    }

    private void grow() {
        capacity = (int) (capacity * 1.5 + 1);
        array = Arrays.copyOf(array, capacity);
    }

    private void removeInIndex(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size-- - 1] = null;
    }
}