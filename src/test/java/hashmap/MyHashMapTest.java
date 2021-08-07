package hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHashMapTest {

    @Test
    void testFirstTestCase() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(24,31);
        myHashMap.put(58,35);
        myHashMap.put(59,88);
        myHashMap.remove(54);
        assertEquals(-1,myHashMap.get(62));
        myHashMap.put(2,22);
        myHashMap.put(44,70);
        assertEquals(myHashMap.get(24),31);
        myHashMap.printContent();
    }

    @Test
    void testSecondTestCase() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(504,155);
        myHashMap.remove(89);
        assertEquals(-1, myHashMap.get(334));
        myHashMap.put(570,521);
        myHashMap.remove(504);
        myHashMap.remove(504);
        myHashMap.put(507,661);
        myHashMap.put(175,641);
        assertEquals(-1,myHashMap.get(504));
        assertEquals(-1,myHashMap.get(672));

        myHashMap.printContent();
    }
}