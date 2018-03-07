package com.meghneelgore.utils.maps;


import com.google.common.collect.ImmutableSortedMap;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * An ImmutableMultiBimap backed by an {@code ImmutableSortedMap}
 */
public class ImmutableTreeMultiBimap<K extends Comparable<K>, V> extends BaseImmutableMultiBimap<K, V> {

    protected ImmutableTreeMultiBimap() {

    }

    /**
     * Returns an immutable map containing a single entry.
     */
    public static <K extends Comparable<K>, V> ImmutableTreeMultiBimap<K, V> of(K key1, V value1) {
        ImmutableTreeMultiBimap<K, V> immutableMultiBimap = new ImmutableTreeMultiBimap<>();
        immutableMultiBimap.backingMap = ImmutableSortedMap.of(key1, value1);
        immutableMultiBimap.invertedMap = immutableMultiBimap.internalInvert();
        return immutableMultiBimap;
    }

    /**
     * Returns an immutable sorted multibimap containing the given entries, sorted by the
     * natural ordering of their keys.
     *
     * @throws IllegalArgumentException if any two keys are equal according to
     *                                  their natural ordering
     */
    public static <K extends Comparable<K>, V> ImmutableTreeMultiBimap<K, V> of(K key1, V value1, K key2, V value2) {
        ImmutableTreeMultiBimap<K, V> immutableMultiBimap = new ImmutableTreeMultiBimap<>();
        immutableMultiBimap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2);
        immutableMultiBimap.invertedMap = immutableMultiBimap.internalInvert();
        return immutableMultiBimap;
    }

    /**
     * Returns an immutable sorted multibimap containing the given entries, sorted by the
     * natural ordering of their keys.
     *
     * @throws IllegalArgumentException if any two keys are equal according to
     *                                  their natural ordering
     */
    public static <K extends Comparable<K>, V> ImmutableTreeMultiBimap<K, V> of(K key1, V value1,
                                                                                K key2, V value2,
                                                                                K key3, V value3) {
        ImmutableTreeMultiBimap<K, V> immutableMultiBimap = new ImmutableTreeMultiBimap<>();
        immutableMultiBimap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3);
        immutableMultiBimap.invertedMap = immutableMultiBimap.internalInvert();
        return immutableMultiBimap;
    }

    /**
     * Returns an immutable sorted multibimap containing the given entries, sorted by the
     * natural ordering of their keys.
     *
     * @throws IllegalArgumentException if any two keys are equal according to
     *                                  their natural ordering
     */
    public static <K extends Comparable<K>, V> ImmutableTreeMultiBimap<K, V> of(K key1, V value1,
                                                                                K key2, V value2,
                                                                                K key3, V value3,
                                                                                K key4, V value4) {
        ImmutableTreeMultiBimap<K, V> immutableMultiBimap = new ImmutableTreeMultiBimap<>();
        immutableMultiBimap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
        immutableMultiBimap.invertedMap = immutableMultiBimap.internalInvert();
        return immutableMultiBimap;
    }

    /**
     * Returns an immutable sorted multibimap containing the given entries, sorted by the
     * natural ordering of their keys.
     *
     * @throws IllegalArgumentException if any two keys are equal according to
     *                                  their natural ordering
     */
    public static <K extends Comparable<K>, V> ImmutableTreeMultiBimap<K, V> of(K key1, V value1,
                                                                                K key2, V value2,
                                                                                K key3, V value3,
                                                                                K key4, V value4,
                                                                                K key5, V value5) {
        ImmutableTreeMultiBimap<K, V> immutableMultiBimap = new ImmutableTreeMultiBimap<>();
        immutableMultiBimap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
        immutableMultiBimap.invertedMap = immutableMultiBimap.internalInvert();
        return immutableMultiBimap;
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

        public ImmutableTreeMultiBimap<K, V> build() {
            ImmutableTreeMultiBimap<K, V> map = new ImmutableTreeMultiBimap<>();
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
