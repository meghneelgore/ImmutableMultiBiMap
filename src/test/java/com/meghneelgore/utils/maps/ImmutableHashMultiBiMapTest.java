package com.meghneelgore.utils.maps;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ImmutableHashMultiBiMapTest {

    @Test
    public void testInverseForSameValues() {
        ImmutableHashMultiBiMap<String, Integer> map = ImmutableHashMultiBiMap.of("Hello", 1, "World", 1);

        ImmutableHashMultiBiMap mapInverse = map.inverse();

        Assert.assertEquals("Wrong number of keys in inverse map", mapInverse.keySet().size(), 1);
        InversionSet<String> inverseValues = new InversionSet<>();
        inverseValues.hashSet.add("Hello");
        inverseValues.hashSet.add("World");
        Assert.assertEquals("Wrong inverse map", mapInverse.get(1), inverseValues);

    }

    @Test
    public void testBuilder() {
        ImmutableHashMultiBiMap.Builder<String, Integer> builder = new ImmutableHashMultiBiMap.Builder<>();
        builder.put("Hello", 1);
        builder.put("Mello", 1);
        builder.put("Jello", 2);
        builder.put("Fellow", 2);
        builder.put("Callow", 3);

        ImmutableHashMultiBiMap<String, Integer> map = builder.build();

        ImmutableHashMultiBiMap mapInverse = map.inverse();
        Assert.assertEquals("Wrong number of keys in inverse map", 3, mapInverse.keySet().size());
        Assert.assertEquals("Wrong number of values in inverse map", 2, ((Set)mapInverse.get(1)).size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDoubleInversion() {
        ImmutableHashMultiBiMap.Builder<String, Integer> builder = new ImmutableHashMultiBiMap.Builder<>();
        builder.put("Hello", 1);
        builder.build().inverse().inverse();
    }
}
