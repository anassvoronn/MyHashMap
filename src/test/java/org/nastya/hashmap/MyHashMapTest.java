package org.nastya.hashmap;

import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest {
    @Test
    public void testConstructor() {
        MyHashMap map = new MyHashMap();
        Assert.assertEquals(0, map.size());
        Assert.assertTrue(map.isEmpty());
    }

    @Test
    public void testPut() {
        MyHashMap map = new MyHashMap();
        map.put("Паша", 12);
        map.put("Даша", "13");
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void testPut_addedDuplications() {
        MyHashMap map = new MyHashMap();
        String pasha = "Паша";
        map.put(pasha, 12);
        map.put(pasha, 12);
        map.put(pasha, 12);
        map.put(pasha, 12);
        map.put(pasha, 12);
        map.put(pasha, 13);
        Assert.assertEquals(1, map.size());
        Assert.assertEquals(13, map.get(pasha));
    }

    @Test
    public void testPut_addedDuplicationsNulls() {
        MyHashMap map = new MyHashMap();
        map.put(null, 12);
        map.put(null, 12);
        map.put(null, 12);
        Assert.assertEquals(1, map.size());
        Assert.assertEquals(12, map.get(null));
    }

    @Test
    public void testRemove_addedDuplicationsAndRemoved() {
        MyHashMap map = new MyHashMap();
        String pasha = "Паша";
        map.put(pasha, 12);
        map.put(pasha, 12);
        map.put(pasha, 12);
        map.put(pasha, 12);
        map.put(pasha, 12);
        map.remove(pasha);
        Assert.assertEquals(0, map.size());
        Assert.assertNull(map.get(pasha));
    }

    @Test
    public void testContainsKey() {
        MyHashMap map = new MyHashMap();
        map.put("Cat", "Black");
        Assert.assertTrue(map.containsKey("Cat"));
        Assert.assertFalse(map.containsKey("Dog"));
    }

    @Test
    public void testUpdateValue() {
        MyHashMap map = new MyHashMap();
        map.put("Настя", "21");
        Object oldValue = map.put("Настя", "22");
        Assert.assertEquals("21", oldValue);
        Assert.assertEquals("22", map.get("Настя"));
    }
}