/*
 */
package edu.hdsb.gwss.ryanp.unit5.dataStructures.HashTable;

/**
 */
public class HashTableTester {

    /**
     * Hash Table Tester
     */
    public static void main(String[] args) {

        int[] valuesAdded = new int[100];
        int nextSpot = 0;
        for (int i = 0; i < valuesAdded.length; i++) {
            valuesAdded[i] = -1;
        }

        HashTable ht = new HashTable(20);

        // EMPTY
        assert (ht.size() == 0);
        assert (ht.isEmpty());
        assert (ht.capacity() == 23);
        assert (ht.loadFactor() == 0.0);

        // HASH
        assert (ht.hash(0) == 0);
        assert (ht.hash(1) == 1);
        assert (ht.hash(ht.capacity()) == 0);
        assert (ht.hash(ht.capacity() - 1) == ht.capacity() - 1);
//
//        // PUT
        ht.put(0, new Student(0, "A", "B"));
        valuesAdded[nextSpot] = 0;
        nextSpot++;
        assert (!ht.isEmpty());
        assert (ht.size() == 1);
        assert (ht.containsKey(0));
        Student s = ht.get(0);
        assert (s.getKey() == 0);
        System.out.println(ht.size());
        System.out.println(ht.capacity());
        System.out.println(ht.loadFactor());
        assert (ht.loadFactor() == (1.0 / (double) ht.capacity()));

        // PUT; SAME HASH VALUE
        ht.put(ht.capacity(), new Student(ht.capacity(), "A", "B"));
        valuesAdded[nextSpot] = ht.capacity();
        nextSpot++;
        assert (!ht.isEmpty());
        assert (ht.size() == 2);
        assert (ht.containsKey(ht.capacity()));
        s = ht.get(ht.capacity());
        assert (s.getKey() == ht.capacity());
        assert (ht.loadFactor() == (2.0 / (double) ht.capacity()));

        // FILL WITH RANDOM NUMBERS TILL LOAD FACTOR REACHED
        int size = 2;
        for (; size < 17; size++) {
            int value = (int) (Math.random() * 100);
            ht.put(value, new Student(value, "A", "B"));
            valuesAdded[nextSpot] = value;
            nextSpot++;
            assert (ht.size() == size + 1);
            assert (ht.containsKey(value));
            s = ht.get(value);
            assert (s.getKey() == value);
            System.out.println("Load Factor: " + ht.loadFactor());
        }

        // BEFORE RESIZE: 17/23 == Load Factor > 0.74
        assert (ht.size() == 17);
        assert (ht.loadFactor() < 0.75);
        System.out.println(ht.loadFactor());
        assert (ht.capacity() == 23);
//
        // BEFORE RESIZE: 18/23 --> New Size: 18 / 0.25
        System.out.println("RESIZED");
        ht.put(666, new Student(666, "A", "B"));
        valuesAdded[nextSpot] = 666;
        nextSpot++;
        System.out.println(ht.capacity());
        assert (ht.capacity() == 73);
        
        //FIX
        assert (ht.loadFactor() < 0.25);

        // MAKE SURE RESIZE WORKED; ALL VALUES ADDED CORRECTLY
        nextSpot = 0;
        int value;
        while (valuesAdded[nextSpot] > -1) {
            value = valuesAdded[nextSpot];
            assert (ht.containsKey(value));
            s = ht.get(value);
            assert (s.getKey() == value);
            nextSpot++;
        }

        // MAKE EMPTY
        ht.makeEmpty();
        // EMPTY
        assert (ht.size() == 0);
        assert (ht.isEmpty());
        assert (ht.capacity() == 73);
        assert (ht.loadFactor() == 0.0);

    }

}
