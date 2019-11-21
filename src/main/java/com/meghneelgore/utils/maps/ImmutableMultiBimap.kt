package com.meghneelgore.utils.maps

import com.google.common.collect.ImmutableMultimap


/**
 * A multiple bimap builds on the idea of a multimap and a bimap. The bimap restricts the user to have unique keys
 * as well as values. The ImmutableMultiBimap has no such restriction, however. This also leads to the inverse() function
 * to return a `MultiMap<V, K>` because ostensibly, there may be multiple keys that map to the same value.
 *
 *
 * It also restricts the inverse() function to be one-way, so ImmutableMultiBimap.inverse().inverse() can't be
 * performed.
 */
interface ImmutableMultiBimap<K, V> : Map<K, V> {

    /**
     * Returns the inverse of the map.
     *
     * @return `ImmutableMultiMap<V, K>`
     */
    fun inverse(): ImmutableMultimap<V, K>
}
