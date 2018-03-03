package com.meghneelgore.utils.maps;

import java.util.*;

/**
 * A multiple bimap builds on the idea of a multimap and a bimap. The bimap restricts the user to have unique keys
 * as well as values. The ImmutableMultiBiMap has no such restriction, however. This also leads to the inverse() function
 * to return a map from V -> Set<K> because ostensibly, there may be multiple keys that map to the same value.
 * <p>
 * The ImmutableHashMultiBiMap is backed by a HashMap.
 *
 * IMPORTANT
 * THIS MAP IS ONLY INVERTIBLE ONE WAY, I.E. AN INVERTED MAP CAN'T BE INVERTED AGAIN TO GET THE ORIGINAL BACK. IT IS
 * THEREFORE INCUMBENT UPON THE USER TO SAVE ANY ORIGINAL MAP(S) ON THEIR OWN.
 */

public class ImmutableHashMultiBiMap<K, V> implements ImmutableMultiBiMap<K, V> {

    /**
     * The hashmap backing the multi bimap
     */
    private final HashMap<K, V> hashMap;

    /**
     * Whether the map was already inverted
     */
    private boolean inverted;

    /**
     * Protected construction. This is in keeping with the general API adhered to by the Guava classes too.
     */
    protected ImmutableHashMultiBiMap(int numEntries) {
        hashMap = new HashMap<>(numEntries);
        inverted = false;
    }

    /**
     * Convenience method that helps to build an ImmutableHashMultiBiMap with 2 key-value pairs;
     *
     * @param key1   Key 1
     * @param value1 Value 1
     * @param key2   Key 2
     * @param value2 Value 2
     * @return ImmutableMultiBiMap with the above key value pairs
     */
    public static <K, V> ImmutableHashMultiBiMap<K, V> of(K key1, V value1, K key2, V value2) {
        ImmutableHashMultiBiMap<K, V> immutableMultiBiMap = new ImmutableHashMultiBiMap<>(2);
        immutableMultiBiMap.hashMap.put(key1, value1);
        immutableMultiBiMap.hashMap.put(key2, value2);
        return immutableMultiBiMap;
    }


    /**
     * Convenience builder for arbitrary number of key-value pairs
     * @param <K> Key type
     * @param <V> Value type
     */
    public static class Builder<K, V> {
        List<Entry<K, V>> listOfEntries;

        public Builder() {
            listOfEntries = new ArrayList<>();
        }

        public void put(K key, V value){
            listOfEntries.add(new AbstractMap.SimpleImmutableEntry<>(key, value));
        }

        public ImmutableHashMultiBiMap<K, V> build() {
            ImmutableHashMultiBiMap<K, V> map = new ImmutableHashMultiBiMap<>(listOfEntries.size());
            for(Entry<K, V> entry: listOfEntries) {
                map.hashMap.put(entry.getKey(), entry.getValue());
            }
            return map;
        }
    }


    /**
     * Inverts the multi bimap to give a map from V -> InversionSet<K>
     *
     * @return
     */
    @Override
    public ImmutableHashMultiBiMap<V, InversionSet<K>> inverse() {

        Collection<V> valueSet = hashMap.values();

        if(inverted) {
            throw new UnsupportedOperationException("Map is already inverted");
        }

        ImmutableHashMultiBiMap<V, InversionSet<K>> returnedMap = new ImmutableHashMultiBiMap<>(valueSet.size());

        for (K key : hashMap.keySet()) {
            V value = hashMap.get(key);
            InversionSet<K> keySet = returnedMap.get(value);
            if (keySet == null) {
                keySet = new InversionSet<>();
            }
            keySet.hashSet.add(key);
            returnedMap.hashMap.put(value, keySet);
        }
        returnedMap.inverted = !inverted;
        return returnedMap;
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return hashMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return hashMap.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return hashMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException("Immutable map, can't add key-value pairs");
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("Immutable map, can't remove key-value pairs");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("Immutable map, can't add key-value pairs");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Immutable map, can't remove key-value pairs");
    }

    @Override
    public Set<K> keySet() {
        return hashMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return hashMap.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return hashMap.entrySet();
    }
}
