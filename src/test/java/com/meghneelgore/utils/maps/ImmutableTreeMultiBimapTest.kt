package com.meghneelgore.utils.maps

import com.google.common.collect.ImmutableList
import com.google.common.collect.Multimap
import com.meghneelgore.utils.maps.ImmutableTreeMultiBimap
import com.meghneelgore.utils.maps.ImmutableTreeMultiBimap.Companion.of
import org.junit.Assert
import org.junit.Test

class ImmutableTreeMultiBimapTest {
    @Test
    fun testOnePairInit() {
        val map: ImmutableMultiBimap<String, String> = of("Hello", "World")
        Assert.assertEquals("Map initialized wrongly", "World", map["Hello"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Hello"), map.inverse()["World"])
    }

    @Test
    fun testTwoPairInit() {
        val map: ImmutableMultiBimap<String, String> = of("Hello", "World", "Foo", "Bar")
        Assert.assertEquals("Map initialized wrongly", "World", map["Hello"])
        Assert.assertEquals("Map initialized wrongly", "Bar", map["Foo"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Hello"), map.inverse()["World"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Foo"), map.inverse()["Bar"])
    }

    @Test
    fun testThreePairInit() {
        val map: ImmutableMultiBimap<String, String> = of("Hello", "World", "Foo", "Bar", "Ugly", "Duckling")
        Assert.assertEquals("Map initialized wrongly", "World", map["Hello"])
        Assert.assertEquals("Map initialized wrongly", "Bar", map["Foo"])
        Assert.assertEquals("Map initialized wrongly", "Duckling", map["Ugly"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Hello"), map.inverse()["World"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Foo"), map.inverse()["Bar"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Ugly"), map.inverse()["Duckling"])
    }

    @Test
    fun testFourPairInit() {
        val map: ImmutableMultiBimap<String, String> = of("Hello", "World",
                "Foo", "Bar",
                "Ugly", "Duckling",
                "House", "Boat")
        Assert.assertEquals("Map initialized wrongly", "World", map["Hello"])
        Assert.assertEquals("Map initialized wrongly", "Bar", map["Foo"])
        Assert.assertEquals("Map initialized wrongly", "Duckling", map["Ugly"])
        Assert.assertEquals("Map initialized wrongly", "Boat", map["House"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Hello"), map.inverse()["World"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Foo"), map.inverse()["Bar"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Ugly"), map.inverse()["Duckling"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("House"), map.inverse()["Boat"])
    }

    @Test
    fun testFivePairInit() {
        val map: ImmutableMultiBimap<String, String> = of(
                "Hello", "World",
                "Foo", "Bar",
                "Ugly", "Duckling",
                "House", "Boat",
                "Coffee", "Table"
        )
        Assert.assertEquals("Map initialized wrongly", "World", map["Hello"])
        Assert.assertEquals("Map initialized wrongly", "Bar", map["Foo"])
        Assert.assertEquals("Map initialized wrongly", "Duckling", map["Ugly"])
        Assert.assertEquals("Map initialized wrongly", "Boat", map["House"])
        Assert.assertEquals("Map initialized wrongly", "Table", map["Coffee"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Hello"), map.inverse()["World"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Foo"), map.inverse()["Bar"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Ugly"), map.inverse()["Duckling"])
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Coffee"), map.inverse()["Table"])
    }

    @Test
    fun testInverseForSameValues() {
        val map = of("Hello", 1, "World", 1)
        val mapInverse: Multimap<Int, String> = map.inverse()
        Assert.assertEquals("Wrong number of keys in inverse map", mapInverse.keySet().size.toLong(), 1)
        val list = ImmutableList.of("Hello", "World")
        Assert.assertEquals("Wrong inverse map", list, mapInverse[1])
    }

    @Test
    fun testBuilder() {
        val builder = ImmutableTreeMultiBimap.Builder<String, Int>()
        builder.put("Hello", 1).put("Mello", 1).put("Jello", 2).put("Fellow", 2).put("Callow", 3)
        val map = builder.build()
        val mapInverse: Multimap<Int, String> = map.inverse()
        Assert.assertEquals("Wrong number of keys in inverse map", 3, mapInverse.keySet().size.toLong())
        Assert.assertEquals("Wrong number of values in inverse map", 2, mapInverse[1].size.toLong())
    }
}