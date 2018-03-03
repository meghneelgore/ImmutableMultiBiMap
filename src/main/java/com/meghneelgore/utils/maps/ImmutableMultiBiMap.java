package com.meghneelgore.utils.maps;

import java.util.Map;


/**
 * A multiple bimap builds on the idea of a multimap and a bimap. The bimap restricts the user to have unique keys
 * as well as values. The ImmutableMultiBiMap has no such restriction, however. This also leads to the inverse() function
 * to return a map from V -> Set<K> because ostensibly, there may be multiple keys that map to the same value. It also
 * restricts the inverse() function to be one-way; making it impossible to invert and already-inverted
 * ImmutableMultiBiMap
 */
public interface ImmutableMultiBiMap<K, V> extends Map<K, V> {

    /**
     * Returns the inverse of the map.
     *
     * @return ImmutableMultiBiMap from V -> Set<K>
     */
    ImmutableMultiBiMap<V, InversionSet<K>> inverse();
}
