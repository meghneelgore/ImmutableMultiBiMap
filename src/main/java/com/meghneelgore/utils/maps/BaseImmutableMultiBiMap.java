package com.meghneelgore.utils.maps;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class BaseImmutableMultiBiMap<K, V> implements ImmutableMultiBiMap<K, V> {

    /**
     * The backing map for the multibimap
     */
    protected final Map<K, V> backingMap;

    /**
     * Save the inverted map. We calculate the inversion at build time since this is an immutable map.
     */
    protected Multimap<V, K> invertedMap;

    /**
     * Constructor
     */
    protected BaseImmutableMultiBiMap(Map<K, V> backingMap) {
        this.backingMap = backingMap;
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
    protected Multimap<V, K> internalInvert() {
        if (invertedMap != null) return invertedMap;
        ImmutableMultimap.Builder<V, K> builder = new ImmutableMultimap.Builder<>();
        for (K key : backingMap.keySet()) {
            V value = backingMap.get(key);
            builder.put(value, key);
        }
        return builder.build();
    }


    @Override
    public int size() {
        return backingMap.size();
    }

    @Override
    public boolean isEmpty() {
        return backingMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return backingMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return backingMap.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return backingMap.get(key);
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
        return backingMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return backingMap.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return backingMap.entrySet();
    }
}
