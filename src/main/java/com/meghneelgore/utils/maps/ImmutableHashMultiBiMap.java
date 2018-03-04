package com.meghneelgore.utils.maps;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

/**
 * An {@code ImmutalbeMultiBiMap} backed by a HashMap.
 */

public class ImmutableHashMultiBiMap<K, V> implements ImmutableMultiBiMap<K, V> {

    /**
     * The hashmap backing the multi bimap
     */
    private final HashMap<K, V> hashMap;

    /**
     * Save the inverted map. We calculate the inversion at build time since this is an immutable map.
     */
    private Multimap<V, K> invertedMap;

    /**
     * Protected construction. This is in keeping with the general API adhered to by the Guava classes too.
     */
    protected ImmutableHashMultiBiMap(int numEntries) {
        hashMap = new HashMap<>(numEntries);
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
        immutableMultiBiMap.invertedMap = immutableMultiBiMap.internalInvert();
        return immutableMultiBiMap;
    }


    /**
     * Convenience builder for an arbitrary number of key-value pairs.
     *
     * @param <K> Key type
     * @param <V> Value type
     */
    public static class Builder<K, V> {
        List<Entry<K, V>> listOfEntries;

        public Builder() {
            listOfEntries = new ArrayList<>();
        }

        public Builder<K, V> put(K key, V value) {
            listOfEntries.add(new AbstractMap.SimpleImmutableEntry<>(key, value));
            return this;
        }

        public ImmutableHashMultiBiMap<K, V> build() {
            ImmutableHashMultiBiMap<K, V> map = new ImmutableHashMultiBiMap<>(listOfEntries.size());
            for (Entry<K, V> entry : listOfEntries) {
                map.hashMap.put(entry.getKey(), entry.getValue());
            }
            map.invertedMap = map.internalInvert();
            return map;
        }
    }


    @Override
    public Multimap<V, K> inverse() {
        return invertedMap;
    }

    /**
     * Inverts the multi bimap to give a MultiMap<V, K>
     *
     * @return The inverted map
     */
    private Multimap<V, K> internalInvert() {
        if(invertedMap != null) return invertedMap;
        ImmutableMultimap.Builder<V, K> builder = new ImmutableMultimap.Builder<>();
        for (K key : hashMap.keySet()) {
            V value = hashMap.get(key);
            builder.put(value, key);
        }
        return builder.build();
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
