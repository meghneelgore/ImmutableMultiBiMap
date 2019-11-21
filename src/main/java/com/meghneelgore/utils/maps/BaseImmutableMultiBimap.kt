package com.meghneelgore.utils.maps

import com.google.common.collect.ImmutableMultimap

/**
 * Base class implementing the [ImmutableMultiBimap] interface.
 *
 * @param <K> Type of keys
 * @param <V> Type of values
 */
abstract class BaseImmutableMultiBimap<K, V>
/**
 * Constructor
 */
protected constructor() : ImmutableMultiBimap<K, V> {

    override val entries: Set<Map.Entry<K, V>>
        get() = backingMap.entries

    override val size: Int
        get() = backingMap.size

    override val values: Collection<V>
        get() = backingMap.values

    override fun containsKey(key: K): Boolean {
        return backingMap.containsKey(key)
    }

    override fun containsValue(value: V): Boolean {
        return backingMap.containsValue(value)
    }

    override fun get(key: K): V? {
        return backingMap[key]
    }

    override val keys: Set<K>
        get() = backingMap.keys
    /**
     * The backing map for the multibimap
     */
    protected lateinit var backingMap: Map<K, V>
    /**
     * Save the inverted map. We calculate the inversion at build time since this is an immutable map.
     */
    protected lateinit var invertedMap: ImmutableMultimap<V, K>

    /**
     * Returns the inverted multimap
     *
     * @return invertedMap, the inverted MultiMap
     */
    override fun inverse(): ImmutableMultimap<V, K> {
        return invertedMap
    }

    /**
     * Inverts the multibimap to give a MultiMap<V></V>, K>
     *
     * @return The inverted map
     */
    protected fun internalInvert(): ImmutableMultimap<V, K> {
        val builder = ImmutableMultimap.Builder<V, K>()
        for (key in backingMap.keys) {
            val value = backingMap[key]
            builder.put(value!!, key)
        }
        return builder.build()
    }

    /**
     * Returns whether the map is empty
     *
     * @return Whether the map is empty
     */
    override fun isEmpty(): Boolean {
        return backingMap.isEmpty()
    }
}