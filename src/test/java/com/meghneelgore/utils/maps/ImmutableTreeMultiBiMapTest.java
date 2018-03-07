package com.meghneelgore.utils.maps;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableTreeMultiBiMapTest {
    @Test
    public void testInverseForSameValues() {
        ImmutableTreeMultiBiMap<String, Integer> map = ImmutableTreeMultiBiMap.of("Hello", 1, "World", 1);
        Multimap<Integer, String> mapInverse = map.inverse();

        Assert.assertEquals("Wrong number of keys in inverse map", mapInverse.keySet().size(), 1);

        ImmutableList<String> list = ImmutableList.of("Hello", "World");

        Assert.assertEquals("Wrong inverse map", list, mapInverse.get(1));
    }

    @Test
    public void testBuilder() {
        ImmutableTreeMultiBiMap.Builder<String, Integer> builder = new ImmutableTreeMultiBiMap.Builder<>();
        builder.put("Hello", 1).put("Mello", 1).put("Jello", 2).put("Fellow", 2).put("Callow", 3);

        ImmutableTreeMultiBiMap<String, Integer> map = builder.build();
        Multimap<Integer, String> mapInverse = map.inverse();
        Assert.assertEquals("Wrong number of keys in inverse map", 3, mapInverse.keySet().size());
        Assert.assertEquals("Wrong number of values in inverse map", 2, mapInverse.get(1).size());
    }
}
