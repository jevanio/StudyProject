package hashmap;

import org.junit.jupiter.api.Test;

import java.util.List;

class ImprovedMyHashSetWithoutHashTest {

    @Test
    public void testAddElementToHashMap() {
        ImprovedMyHashMap myHashSet = new ImprovedMyHashMap();
        myHashSet.add(2);
        printHashMap(myHashSet);
        myHashSet.add(3);
        printHashMap(myHashSet);
        myHashSet.add(4);
        printHashMap(myHashSet);
        myHashSet.add(4);
        printHashMap(myHashSet);
        myHashSet.add(2);
        printHashMap(myHashSet);
    }

    private void printHashMap(ImprovedMyHashMap myHashSet) {
        System.out.println("--------------------");
        List<Integer>[] container = myHashSet.container;
        for (List<Integer> c : container) {
            if (c != null) {
                System.out.println(c);
            }

        }
    }


}