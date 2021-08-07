package hashmap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {

    @Test
    void testContains() {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(3);
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(4);
        myHashSet.printContent();

        assertTrue(myHashSet.contains(1));
        assertTrue(myHashSet.contains(3));
        assertTrue(myHashSet.contains(2));
        assertTrue(myHashSet.contains(4));
        assertFalse(myHashSet.contains(20));

        myHashSet.remove(10);
        assertFalse(myHashSet.contains(10));
        System.out.println("Number of elements: " + myHashSet.size());

    }

    @Test
    public void testRehash() {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(3);
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(4);
        myHashSet.printContent();

        myHashSet.add(11);
        myHashSet.printContent();

        int[] n = {1,2,3};
        for(int i:n) {
            System.out.println(i);
        }
    }
}