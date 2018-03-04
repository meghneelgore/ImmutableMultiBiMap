package com.meghneelgore.utils.maps;


import com.google.common.collect.*;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.multi.MultiMenuBarUI;
import java.util.HashSet;
import java.util.Set;

public class ImmutableHashMultiBiMapTest {

    @Test
    public void testInverseForSameValues() {
        ImmutableHashMultiBiMap<String, Integer> map = ImmutableHashMultiBiMap.of("Hello", 1, "World", 1);

        Multimap<Integer, String> mapInverse = map.inverse();

        Assert.assertEquals("Wrong number of keys in inverse map", mapInverse.keySet().size(), 1);

        ImmutableList<String> list = ImmutableList.of("Hello", "World");

        Assert.assertEquals("Wrong inverse map", list, mapInverse.get(1));
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

        //ImmutableHashMultiBiMap mapInverse = map.inverse();
        //Assert.assertEquals("Wrong number of keys in inverse map", 3, mapInverse.keySet().size());
        //Assert.assertEquals("Wrong number of values in inverse map", 2, ((Set)mapInverse.get(1)).size());
    }

}
