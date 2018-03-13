package com.meghneelgore.utils.maps;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableTreeMultiBimapTest {

    @Test
    public void testOnePairInit() {
        ImmutableMultiBimap<String, String> map = ImmutableTreeMultiBimap.of("Hello", "World");
        Assert.assertEquals("Map initialized wrongly", "World", map.get("Hello"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Hello"), map.inverse().get("World"));
    }

    @Test
    public void testTwoPairInit() {
        ImmutableMultiBimap<String, String> map = ImmutableTreeMultiBimap.of("Hello", "World", "Foo", "Bar");
        Assert.assertEquals("Map initialized wrongly", "World", map.get("Hello"));
        Assert.assertEquals("Map initialized wrongly", "Bar", map.get("Foo"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Hello"), map.inverse().get("World"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Foo"), map.inverse().get("Bar"));
    }

    @Test
    public void testThreePairInit() {
        ImmutableMultiBimap<String, String> map = ImmutableTreeMultiBimap.of("Hello", "World", "Foo", "Bar", "Ugly", "Duckling");
        Assert.assertEquals("Map initialized wrongly", "World", map.get("Hello"));
        Assert.assertEquals("Map initialized wrongly", "Bar", map.get("Foo"));
        Assert.assertEquals("Map initialized wrongly", "Duckling", map.get("Ugly"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Hello"), map.inverse().get("World"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Foo"), map.inverse().get("Bar"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Ugly"), map.inverse().get("Duckling"));
    }

    @Test
    public void testFourPairInit() {
        ImmutableMultiBimap<String, String> map =
                ImmutableTreeMultiBimap.of
                        ("Hello", "World",
                                "Foo", "Bar",
                                "Ugly", "Duckling",
                                "House", "Boat");
        Assert.assertEquals("Map initialized wrongly", "World", map.get("Hello"));
        Assert.assertEquals("Map initialized wrongly", "Bar", map.get("Foo"));
        Assert.assertEquals("Map initialized wrongly", "Duckling", map.get("Ugly"));
        Assert.assertEquals("Map initialized wrongly", "Boat", map.get("House"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Hello"), map.inverse().get("World"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Foo"), map.inverse().get("Bar"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Ugly"), map.inverse().get("Duckling"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("House"), map.inverse().get("Boat"));
    }

    @Test
    public void testFivePairInit() {
        ImmutableMultiBimap<String, String> map =
                ImmutableTreeMultiBimap.of
                        (
                                "Hello", "World",
                                "Foo", "Bar",
                                "Ugly", "Duckling",
                                "House", "Boat",
                                "Coffee", "Table"
                        );
        Assert.assertEquals("Map initialized wrongly", "World", map.get("Hello"));
        Assert.assertEquals("Map initialized wrongly", "Bar", map.get("Foo"));
        Assert.assertEquals("Map initialized wrongly", "Duckling", map.get("Ugly"));
        Assert.assertEquals("Map initialized wrongly", "Boat", map.get("House"));
        Assert.assertEquals("Map initialized wrongly", "Table", map.get("Coffee"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Hello"), map.inverse().get("World"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Foo"), map.inverse().get("Bar"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Ugly"), map.inverse().get("Duckling"));
        Assert.assertEquals("Map initialized wrongly", ImmutableList.of("Coffee"), map.inverse().get("Table"));
    }
    @Test
    public void testInverseForSameValues() {
        ImmutableTreeMultiBimap<String, Integer> map = ImmutableTreeMultiBimap.of("Hello", 1, "World", 1);
        Multimap<Integer, String> mapInverse = map.inverse();

        Assert.assertEquals("Wrong number of keys in inverse map", mapInverse.keySet().size(), 1);

        ImmutableList<String> list = ImmutableList.of("Hello", "World");

        Assert.assertEquals("Wrong inverse map", list, mapInverse.get(1));
    }

    @Test
    public void testBuilder() {
        ImmutableTreeMultiBimap.Builder<String, Integer> builder = new ImmutableTreeMultiBimap.Builder<>();
        builder.put("Hello", 1).put("Mello", 1).put("Jello", 2).put("Fellow", 2).put("Callow", 3);

        ImmutableTreeMultiBimap<String, Integer> map = builder.build();
        Multimap<Integer, String> mapInverse = map.inverse();
        Assert.assertEquals("Wrong number of keys in inverse map", 3, mapInverse.keySet().size());
        Assert.assertEquals("Wrong number of values in inverse map", 2, mapInverse.get(1).size());
    }
}
