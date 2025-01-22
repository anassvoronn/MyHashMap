package org.nastya.HashMapTest;

import org.junit.Assert;
import org.junit.Test;
import org.nastya.HashMap.MyHashMap;

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