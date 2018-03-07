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
     * Protected construction.
     */
    protected ImmutableHashMultiBiMap() {

    }

    /**
     * Returns an immutable multibimap containing a single entry.
     */
    public static <K, V> ImmutableHashMultiBiMap<K, V> of(K key1, V value1) {
        ImmutableHashMultiBiMap<K, V> map = new ImmutableHashMultiBiMap<>();
        map.backingMap = ImmutableMap.of(key1, value1);
        map.invertedMap = map.internalInvert();
        return map;
    }

    /**
     * Returns an immutable map containing the given entries, in order.
     *
     * @throws IllegalArgumentException if duplicate keys are provided
     */
    public static <K, V> ImmutableHashMultiBiMap<K, V> of(K key1, V value1, K key2, V value2) {
        ImmutableHashMultiBiMap<K, V> map = new ImmutableHashMultiBiMap<>();
        map.backingMap = ImmutableMap.of(key1, value1, key2, value2);
        map.invertedMap = map.internalInvert();
        return map;
    }

    /**
     * Returns an immutable map containing the given entries, in order.
     *
     * @throws IllegalArgumentException if duplicate keys are provided
     */
    public static <K, V> ImmutableHashMultiBiMap<K, V> of(K key1, V value1, K key2, V value2, K key3, V value3) {
        ImmutableHashMultiBiMap<K, V> map = new ImmutableHashMultiBiMap<>();
        map.backingMap = ImmutableMap.of(key1, value1, key2, value2, key3, value3);
        map.invertedMap = map.internalInvert();
        return map;
    }

    /**
     * Returns an immutable map containing the given entries, in order.
     *
     * @throws IllegalArgumentException if duplicate keys are provided
     */
    public static <K, V> ImmutableHashMultiBiMap<K, V> of(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        ImmutableHashMultiBiMap<K, V> map = new ImmutableHashMultiBiMap<>();
        map.backingMap = ImmutableMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
        map.invertedMap = map.internalInvert();
        return map;
    }

    /**
     * Returns an immutable map containing the given entries, in order.
     *
     * @throws IllegalArgumentException if duplicate keys are provided
     */
    public static <K, V> ImmutableHashMultiBiMap<K, V> of(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5, V value5) {
        ImmutableHashMultiBiMap<K, V> map = new ImmutableHashMultiBiMap<>();
        map.backingMap = ImmutableMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
        map.invertedMap = map.internalInvert();
        return map;
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
