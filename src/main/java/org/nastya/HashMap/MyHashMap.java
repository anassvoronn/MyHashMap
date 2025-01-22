package org.nastya.HashMap;

import java.util.*;

public class MyHashMap implements Map<String, Object> {
    public static final int DEFAULT_CAPACITY = 16;
    private int size;
    private LinkedList<Entry>[] table;

    public MyHashMap() {
        size = 0;
        table = new LinkedList[DEFAULT_CAPACITY];
    }

    public MyHashMap(int capacity) {
        table = new LinkedList[capacity];
    }

    public static class Entry {
        String key;
        Object value;

        Entry(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getIndex(Object key) {
        return key.hashCode() % table.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object get(Object key) {
        int index = getIndex(key);
        if (table[index] == null) {
            return null;
        }
        for (var entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = getIndex(key);
        if (table[index] == null) {
            return false;
        }
        for (var entry : table[index]) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object put(String key, Object value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (var entry : table[index]) {
            if (entry.key.equals(key)) {
                Object oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        table[index].add(new Entry(key, value));
        size++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Object> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<String, Object>> entrySet() {
        return null;
    }
}
