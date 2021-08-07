package hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetWithoutHashTest {
    @Test
    public void testAddElementToHashMap() {
        MyHashSetWithoutHash myHashSetWithoutHash = new MyHashSetWithoutHash();
        printHashMap(myHashSetWithoutHash);
        myHashSetWithoutHash.add(2);
        printHashMap(myHashSetWithoutHash);
        myHashSetWithoutHash.add(3);
        printHashMap(myHashSetWithoutHash);
        myHashSetWithoutHash.add(4);
        printHashMap(myHashSetWithoutHash);
        myHashSetWithoutHash.add(4);
        printHashMap(myHashSetWithoutHash);
        myHashSetWithoutHash.add(2);
        printHashMap(myHashSetWithoutHash);
    }

    private void printHashMap(MyHashSetWithoutHash myHashSetWithoutHash) {
        System.out.println("--------------------");
        MyHashSetWithoutHash temp = myHashSetWithoutHash;
        while(temp.key!= null) {
            System.out.println(temp.key);
            temp=temp.next;
        }
    }

    @Test
    public void testContainsElementHashMap() {
        MyHashSetWithoutHash myHashSetWithoutHash = new MyHashSetWithoutHash();
        assertFalse(myHashSetWithoutHash.contains(2));
        myHashSetWithoutHash.add(2);
        assertTrue(myHashSetWithoutHash.contains(2));
        myHashSetWithoutHash.add(3);
        myHashSetWithoutHash.add(4);

        assertTrue(myHashSetWithoutHash.contains(2));
        assertFalse(myHashSetWithoutHash.contains(5));
    }

    @Test
    public void testRemoveElementFromHashMap() {
        MyHashSetWithoutHash myHashSetWithoutHash = new MyHashSetWithoutHash();
        myHashSetWithoutHash.remove(2);
        myHashSetWithoutHash.add(2);
        myHashSetWithoutHash.remove(2);
        printHashMap(myHashSetWithoutHash);
        myHashSetWithoutHash.add(2);
        myHashSetWithoutHash.add(3);
        myHashSetWithoutHash.add(4);
        printHashMap(myHashSetWithoutHash);

        myHashSetWithoutHash.remove(4);
        printHashMap(myHashSetWithoutHash);

        myHashSetWithoutHash.remove(0);
        printHashMap(myHashSetWithoutHash);

        myHashSetWithoutHash.remove(2);
        printHashMap(myHashSetWithoutHash);

        myHashSetWithoutHash.remove(3);
        printHashMap(myHashSetWithoutHash);

    }

}