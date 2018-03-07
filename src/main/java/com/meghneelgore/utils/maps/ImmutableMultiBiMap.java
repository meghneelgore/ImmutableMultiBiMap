package com.meghneelgore.utils.maps;

import com.google.common.collect.ImmutableMultimap;

import java.util.Map;


/**
 * A multiple bimap builds on the idea of a multimap and a bimap. The bimap restricts the user to have unique keys
 * as well as values. The ImmutableMultiBiMap has no such restriction, however. This also leads to the inverse() function
 * to return a {@code MultiMap<V, K>} because ostensibly, there may be multiple keys that map to the same value.
 * <p>
 * It also restricts the inverse() function to be one-way, so the ImmutableMultiBiMap.inverse().inverse() can't be
 * performed.
 */
public interface ImmutableMultiBiMap<K, V> extends Map<K, V> {

    /**
     * Returns the inverse of the map.
     *
     * @return {@code ImmutableMultiMap<V, K>}
     */
    ImmutableMultimap<V, K> inverse();
}
