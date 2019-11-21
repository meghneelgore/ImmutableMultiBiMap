package com.meghneelgore.utils.maps

import com.google.common.collect.ImmutableMap
import java.util.*

/**
 * An `ImmutableMultiBimap` backed by a HashMap.
 */

class ImmutableHashMultiBimap<K, V> : BaseImmutableMultiBimap<K, V>() {
    /**
     * Convenience builder for an arbitrary number of key-value pairs.
     *
     * @param <K> Key type
     * @param <V> Value type
    </V></K> */
    class Builder<K, V> {
        private var listOfEntries: MutableList<MutableMap.MutableEntry<K, V>> = ArrayList()

        fun put(key: K, value: V): Builder<K, V> {
            listOfEntries.add(AbstractMap.SimpleImmutableEntry(key, value))
            return this
        }

        fun build(): ImmutableHashMultiBimap<K, V> {
            val map = ImmutableHashMultiBimap<K, V>()
            val builder = ImmutableMap.Builder<K, V>()
            for (entry in listOfEntries) {
                builder.put(entry.key, entry.value)
            }
            map.backingMap = builder.build()
            map.invertedMap = map.internalInvert()
            return map
        }
    }


    companion object {

        /**
         * Returns an immutable multibimap containing a single entry.
         */
        fun <K, V> of(key1: K, value1: V): ImmutableHashMultiBimap<K, V> {
            val map = ImmutableHashMultiBimap<K, V>()
            map.backingMap = ImmutableMap.of(key1, value1)
            map.invertedMap = map.internalInvert()
            return map
        }

        /**
         * Returns an immutable map containing the given entries, in order.
         *
         * @throws IllegalArgumentException if duplicate keys are provided
         */
        fun <K, V> of(key1: K, value1: V, key2: K, value2: V): ImmutableHashMultiBimap<K, V> {
            val map = ImmutableHashMultiBimap<K, V>()
            map.backingMap = ImmutableMap.of(key1, value1, key2, value2)
            map.invertedMap = map.internalInvert()
            return map
        }

        /**
         * Returns an immutable map containing the given entries, in order.
         *
         * @throws IllegalArgumentException if duplicate keys are provided
         */
        fun <K, V> of(key1: K, value1: V, key2: K, value2: V, key3: K, value3: V): ImmutableHashMultiBimap<K, V> {
            val map = ImmutableHashMultiBimap<K, V>()
            map.backingMap = ImmutableMap.of(key1, value1, key2, value2, key3, value3)
            map.invertedMap = map.internalInvert()
            return map
        }

        /**
         * Returns an immutable map containing the given entries, in order.
         *
         * @throws IllegalArgumentException if duplicate keys are provided
         */
        fun <K, V> of(key1: K, value1: V, key2: K, value2: V, key3: K, value3: V, key4: K, value4: V): ImmutableHashMultiBimap<K, V> {
            val map = ImmutableHashMultiBimap<K, V>()
            map.backingMap = ImmutableMap.of(key1, value1, key2, value2, key3, value3, key4, value4)
            map.invertedMap = map.internalInvert()
            return map
        }

        /**
         * Returns an immutable map containing the given entries, in order.
         *
         * @throws IllegalArgumentException if duplicate keys are provided
         */
        fun <K, V> of(key1: K, value1: V, key2: K, value2: V, key3: K, value3: V, key4: K, value4: V, key5: K, value5: V): ImmutableHashMultiBimap<K, V> {
            val map = ImmutableHashMultiBimap<K, V>()
            map.backingMap = ImmutableMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5)
            map.invertedMap = map.internalInvert()
            return map
        }
    }
}






