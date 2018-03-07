package com.meghneelgore.utils.maps;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Base class implementing the {@link ImmutableMultiBiMap} interface.
 *
 * @param <K> Type of keys
 * @param <V> Type of values
 */
public abstract class BaseImmutableMultiBiMap<K, V> implements ImmutableMultiBiMap<K, V> {

    /**
     * The backing map for the multibimap
     */
    protected ImmutableMap<K, V> backingMap;

    /**
     * Save the inverted map. We calculate the inversion at build time since this is an immutable map.
     */
    protected ImmutableMultimap<V, K> invertedMap;

    /**
     * Constructor
     */
    protected BaseImmutableMultiBiMap() {

    }

    /**
     * Returns the inverted multimap
     *
     * @return invertedMap, the inverted MultiMap
     */
    @Override
    public Multimap<V, K> inverse() {
        return invertedMap;
    }

    /**
     * Inverts the multibimap to give a MultiMap<V, K>
     *
     * @return The inverted map
     */
    protected ImmutableMultimap<V, K> internalInvert() {
        if (invertedMap != null) return invertedMap;
        ImmutableMultimap.Builder<V, K> builder = new ImmutableMultimap.Builder<>();
        for (K key : backingMap.keySet()) {
            V value = backingMap.get(key);
            builder.put(value, key);
        }
        return builder.build();
    }

    /**
     * Returns the size of the map
     *
     * @return Size of map
     */
    @Override
    public int size() {
        return backingMap.size();
    }

    /**
     * Returns whether the map is empty
     *
     * @return Whether the map is empty
     */
    @Override
    public boolean isEmpty() {
        return backingMap.isEmpty();
    }

    /**
     * Returns whether a key exists in the map
     *
     * @param key Key to search for
     * @return true if key is found
     */
    @Override
    public boolean containsKey(Object key) {
        return backingMap.containsKey(key);
    }

    /**
     * Returns whether a value exists in the map.
     *
     * @param value Value to search for
     * @return true if value is found
     */
    @Override
    public boolean containsValue(Object value) {
        return backingMap.containsValue(value);
    }

    /**
     * Gets the value corresponding to the key
     *
     * @param key Key to search the value with
     * @return Value corresponding to the supplied key
     */
    @Override
    public V get(Object key) {
        return backingMap.get(key);
    }

    /**
     * Returns the set of keys in the map.
     *
     * @return The set of keys in the map
     */
    @Override
    public Set<K> keySet() {
        return backingMap.keySet();
    }

    /**
     * Returns the collection of values in the map
     *
     * @return The collection of values in the map
     */
    @Override
    public Collection<V> values() {
        return backingMap.values();
    }

    /**
     * Returns the set of EntrySets in the map
     *
     * @return The set of EntrySets in the map
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        return backingMap.entrySet();
    }

    /**
     * Clearing an immutable map is impossible
     *
     * @throws UnsupportedOperationException always
     */
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /**
     * Adding values to an immutable map is impossible
     *
     * @param m Map to copy
     * @throws UnsupportedOperationException always
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adding values to an immutable map is impossible
     *
     * @param key   Key to add
     * @param value Value to add
     * @return Added value
     * @throws UnsupportedOperationException always
     */
    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removing values from immutable map is impossible
     *
     * @param key   Key to remove
     * @param value Value to remove
     * @return Value that was removed
     * @throws UnsupportedOperationException always
     */
    @Override
    public boolean remove(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removing values from immutable map is impossible
     *
     * @param key Key to remove
     * @return Value that was removed
     * @throws UnsupportedOperationException always
     */
    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }


}
