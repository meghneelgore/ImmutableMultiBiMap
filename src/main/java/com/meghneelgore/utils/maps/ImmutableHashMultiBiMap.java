package com.meghneelgore.utils.maps;

import com.google.common.collect.ImmutableMap;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * An {@code ImmutableMultiBiMap} backed by a HashMap.
 */

public class ImmutableHashMultiBiMap<K, V> extends BaseImmutableMultiBiMap<K, V> {

    /**
     * Protected construction. This is in keeping with the general API adhered to by the Guava classes too.
     */
    protected ImmutableHashMultiBiMap() {

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
        ImmutableHashMultiBiMap<K, V> immutableMultiBiMap = new ImmutableHashMultiBiMap<>();
        immutableMultiBiMap.backingMap = ImmutableMap.of(key1, value1, key2, value2);
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
            ImmutableHashMultiBiMap<K, V> map = new ImmutableHashMultiBiMap<>();
            ImmutableMap.Builder<K, V> builder = new ImmutableMap.Builder<>();
            for (Entry<K, V> entry : listOfEntries) {
                builder.put(entry.getKey(), entry.getValue());
            }
            map.backingMap = builder.build();
            map.invertedMap = map.internalInvert();
            return map;
        }
    }
}
