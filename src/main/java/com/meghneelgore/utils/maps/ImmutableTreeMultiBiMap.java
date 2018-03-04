package com.meghneelgore.utils.maps;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * A {@code TreeMap} backed ImmutableMultiBiMap
 */
public class ImmutableTreeMultiBiMap<K, V> extends BaseImmutableMultiBiMap<K, V> {

    /**
     * Protected construction. This is in keeping with the general API adhered to by the Guava classes too.
     */
    protected ImmutableTreeMultiBiMap() {
        super(new TreeMap<>());
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
    public static <K, V> ImmutableTreeMultiBiMap<K, V> of(K key1, V value1, K key2, V value2) {
        ImmutableTreeMultiBiMap<K, V> immutableMultiBiMap = new ImmutableTreeMultiBiMap<>();
        immutableMultiBiMap.backingMap.put(key1, value1);
        immutableMultiBiMap.backingMap.put(key2, value2);
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

        public ImmutableTreeMultiBiMap<K, V> build() {
            ImmutableTreeMultiBiMap<K, V> map = new ImmutableTreeMultiBiMap<>();
            for (Entry<K, V> entry : listOfEntries) {
                map.backingMap.put(entry.getKey(), entry.getValue());
            }
            map.invertedMap = map.internalInvert();
            return map;
        }
    }
}
