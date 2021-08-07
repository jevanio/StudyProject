package hashmap;

public class MyHashMap {

    // hashFunction: y = key%cap
    Integer[] keys;
    Integer[] values;
    int cap = 10;
    int count = 0;

    public MyHashMap() {
        keys = new Integer[cap];
        values = new Integer[cap];
    }

    public void put(int key, int value) {
        // Use hash function to get position
        int pos = hashFunction(key);

        // increase cap & rehash if position is already used
        while (keys[pos] != null && keys[pos] != key) {
            reHash();
            pos = hashFunction(key);
        }

        if (keys[pos] == null) {
            keys[pos] = key;
            count++;
        }
        values[pos] = value;
    }

    public int get(int key) {
        int pos = hashFunction(key);
        if (keys[pos] != null && keys[pos] == key) {
            return values[pos];
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        int pos = hashFunction(key);
        if (keys[pos] != null && keys[pos] == key) {
            keys[pos] = null;
            count--;
        }
    }

    private int hashFunction(int key) {
        return key % cap;
    }

    private void reHash() {
        Integer[] oldKeys = keys;
        Integer[] oldValues = values;
        cap = 2 * cap;
        keys = new Integer[cap];
        values = new Integer[cap];
        for (int i = 0; i < oldKeys.length; i++) {
            Integer oldKey = oldKeys[i];
            Integer oldValue = oldValues[i];
            if (oldKey != null && oldValue != null) {
                int pos = hashFunction(oldKey);
                keys[pos] = oldKey;
                values[pos] = oldValue;
            }
        }
    }

    public void printContent() {
        System.out.println("-------------------------------");
        System.out.println("MyHashSetV2 values");
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                System.out.println("[" + keys[i] + "," + values[i] + "]");
            }
        }
        System.out.println("Number of elements: " + size());
    }

    public int size() {
        return count;
    }
}
