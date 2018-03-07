package com.meghneelgore.utils.maps;


import com.google.common.collect.ImmutableSortedMap;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * An ImmutableMultiBiMap backed by an {@code ImmutableSortedMap}
 */
public class ImmutableTreeMultiBiMap<K extends Comparable<K>, V> extends BaseImmutableMultiBiMap<K, V> {

    protected ImmutableTreeMultiBiMap() {

    }

    /**
     * Returns an immutable map containing a single entry.
     */
    public static <K extends Comparable<K>, V> ImmutableTreeMultiBiMap<K, V> of(K key1, V value1) {
        ImmutableTreeMultiBiMap<K, V> immutableMultiBiMap = new ImmutableTreeMultiBiMap<>();
        immutableMultiBiMap.backingMap = ImmutableSortedMap.of(key1, value1);
        immutableMultiBiMap.invertedMap = immutableMultiBiMap.internalInvert();
        return immutableMultiBiMap;
    }

    /**
     * Returns an immutable sorted multibimap containing the given entries, sorted by the
     * natural ordering of their keys.
     *
     * @throws IllegalArgumentException if any two keys are equal according to
     *                                  their natural ordering
     */
    public static <K extends Comparable<K>, V> ImmutableTreeMultiBiMap<K, V> of(K key1, V value1, K key2, V value2) {
        ImmutableTreeMultiBiMap<K, V> immutableMultiBiMap = new ImmutableTreeMultiBiMap<>();
        immutableMultiBiMap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2);
        immutableMultiBiMap.invertedMap = immutableMultiBiMap.internalInvert();
        return immutableMultiBiMap;
    }

    /**
     * Returns an immutable sorted multibimap containing the given entries, sorted by the
     * natural ordering of their keys.
     *
     * @throws IllegalArgumentException if any two keys are equal according to
     *                                  their natural ordering
     */
    public static <K extends Comparable<K>, V> ImmutableTreeMultiBiMap<K, V> of(K key1, V value1,
                                                                                K key2, V value2,
                                                                                K key3, V value3) {
        ImmutableTreeMultiBiMap<K, V> immutableMultiBiMap = new ImmutableTreeMultiBiMap<>();
        immutableMultiBiMap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3);
        immutableMultiBiMap.invertedMap = immutableMultiBiMap.internalInvert();
        return immutableMultiBiMap;
    }

    /**
     * Returns an immutable sorted multibimap containing the given entries, sorted by the
     * natural ordering of their keys.
     *
     * @throws IllegalArgumentException if any two keys are equal according to
     *                                  their natural ordering
     */
    public static <K extends Comparable<K>, V> ImmutableTreeMultiBiMap<K, V> of(K key1, V value1,
                                                                                K key2, V value2,
                                                                                K key3, V value3,
                                                                                K key4, V value4) {
        ImmutableTreeMultiBiMap<K, V> immutableMultiBiMap = new ImmutableTreeMultiBiMap<>();
        immutableMultiBiMap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
        immutableMultiBiMap.invertedMap = immutableMultiBiMap.internalInvert();
        return immutableMultiBiMap;
    }

    /**
     * Returns an immutable sorted multibimap containing the given entries, sorted by the
     * natural ordering of their keys.
     *
     * @throws IllegalArgumentException if any two keys are equal according to
     *                                  their natural ordering
     */
    public static <K extends Comparable<K>, V> ImmutableTreeMultiBiMap<K, V> of(K key1, V value1,
                                                                                K key2, V value2,
                                                                                K key3, V value3,
                                                                                K key4, V value4,
                                                                                K key5, V value5) {
        ImmutableTreeMultiBiMap<K, V> immutableMultiBiMap = new ImmutableTreeMultiBiMap<>();
        immutableMultiBiMap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
        immutableMultiBiMap.invertedMap = immutableMultiBiMap.internalInvert();
        return immutableMultiBiMap;
    }


    /**
     * Convenience builder for an arbitrary number of key-value pairs.
     *
     * @param <K> Key type
     * @param <V> Value type
     */
    public static class Builder<K extends Comparable<K>, V> {
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
            ImmutableSortedMap.Builder<K, V> builder = new ImmutableSortedMap.Builder<>(Comparable::compareTo);
            for (Entry<K, V> entry : listOfEntries) {
                builder.put(entry.getKey(), entry.getValue());
            }
            map.backingMap = builder.build();
            map.invertedMap = map.internalInvert();
            return map;
        }
    }
}
