package com.meghneelgore.utils.maps


import com.google.common.collect.ImmutableSortedMap
import java.util.*

/**
 * An ImmutableMultiBimap backed by an `ImmutableSortedMap`
 */
class ImmutableTreeMultiBimap<K : Comparable<K>, V>
/**
 * Private construction
 */
private constructor() : BaseImmutableMultiBimap<K, V>() {

    /**
     * Convenience builder for an arbitrary number of key-value pairs.
     *
     * @param <K> Key type
     * @param <V> Value type
    </V></K> */
    class Builder<K : Comparable<K>, V> {
        private var listOfEntries: MutableList<MutableMap.MutableEntry<K, V>> = ArrayList()

        fun put(key: K, value: V): Builder<K, V> {
            listOfEntries.add(AbstractMap.SimpleImmutableEntry(key, value))
            return this
        }

        fun build(): ImmutableTreeMultiBimap<K, V> {
            val map = ImmutableTreeMultiBimap<K, V>()
            val builder = ImmutableSortedMap.Builder<K, V>(Comparator<K> { obj, o -> obj.compareTo(o) })
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
         * Returns an immutable map containing a single entry.
         */
        fun <K : Comparable<K>, V> of(key1: K, value1: V): ImmutableTreeMultiBimap<K, V> {
            val immutableMultiBimap = ImmutableTreeMultiBimap<K, V>()
            immutableMultiBimap.backingMap = ImmutableSortedMap.of(key1, value1)
            immutableMultiBimap.invertedMap = immutableMultiBimap.internalInvert()
            return immutableMultiBimap
        }

        /**
         * Returns an immutable sorted multibimap containing the given entries, sorted by the
         * natural ordering of their keys.
         *
         * @throws IllegalArgumentException if any two keys are equal according to
         * their natural ordering
         */
        fun <K : Comparable<K>, V> of(key1: K, value1: V, key2: K, value2: V): ImmutableTreeMultiBimap<K, V> {
            val immutableMultiBimap = ImmutableTreeMultiBimap<K, V>()
            immutableMultiBimap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2)
            immutableMultiBimap.invertedMap = immutableMultiBimap.internalInvert()
            return immutableMultiBimap
        }

        /**
         * Returns an immutable sorted multibimap containing the given entries, sorted by the
         * natural ordering of their keys.
         *
         * @throws IllegalArgumentException if any two keys are equal according to
         * their natural ordering
         */
        fun <K : Comparable<K>, V> of(key1: K, value1: V,
                                      key2: K, value2: V,
                                      key3: K, value3: V): ImmutableTreeMultiBimap<K, V> {
            val immutableMultiBimap = ImmutableTreeMultiBimap<K, V>()
            immutableMultiBimap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3)
            immutableMultiBimap.invertedMap = immutableMultiBimap.internalInvert()
            return immutableMultiBimap
        }

        /**
         * Returns an immutable sorted multibimap containing the given entries, sorted by the
         * natural ordering of their keys.
         *
         * @throws IllegalArgumentException if any two keys are equal according to
         * their natural ordering
         */
        fun <K : Comparable<K>, V> of(key1: K, value1: V,
                                      key2: K, value2: V,
                                      key3: K, value3: V,
                                      key4: K, value4: V): ImmutableTreeMultiBimap<K, V> {
            val immutableMultiBimap = ImmutableTreeMultiBimap<K, V>()
            immutableMultiBimap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3, key4, value4)
            immutableMultiBimap.invertedMap = immutableMultiBimap.internalInvert()
            return immutableMultiBimap
        }

        /**
         * Returns an immutable sorted multibimap containing the given entries, sorted by the
         * natural ordering of their keys.
         *
         * @throws IllegalArgumentException if any two keys are equal according to
         * their natural ordering
         */
        fun <K : Comparable<K>, V> of(key1: K, value1: V,
                                      key2: K, value2: V,
                                      key3: K, value3: V,
                                      key4: K, value4: V,
                                      key5: K, value5: V): ImmutableTreeMultiBimap<K, V> {
            val immutableMultiBimap = ImmutableTreeMultiBimap<K, V>()
            immutableMultiBimap.backingMap = ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5)
            immutableMultiBimap.invertedMap = immutableMultiBimap.internalInvert()
            return immutableMultiBimap
        }
    }
}
