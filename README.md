# ImmutableMultiBimap

A bimap allows the user to have an inverse view but constrains the user to have unique keys K _and_ values V so that it can 
return an inverted map V -> K

A multimap allows the user to have multiple values for the same key.

The ImmutableMultiBimap allows the user to have non-unique values V for different keys K and inverts them into a map 
that returns a V \-> Set\<K\> map. 

For example,

`ImmutableBiMap<String, Integer> bimap = ImmutableBiMap.of("One", 1, "Two", 2);
ImmutableBimap<Integer, String> inverseMap = bimap.inverse();
`

Will give you an <code>inverseMap </code> having values

`
[ 1 -> "One" ], [ 2 -> "Two"]
`

But the `ImmutableBiMap` throws an exception if you try to instantiate like so

`
ImmutableBiMap<String, Integer> bimap = ImmutableBiMap.of("One", 1, "Two", 1);
`

Because it has no way to invert the map.

A `MultiSet` allows the user to have multiple values for the same key. For instance,

`
 ImmutableMultimap<String, Integer> multimap = ImmutableMultimap.of("One", 1, "One", 2);
`

Will give the user a map like so

`[ "One" -> Collection<Integer>[1, 2]]`

The `ImmutableMultiBimap` allows the user to have a non-unique set of vaues as well as inversion by making a Multimap out of the inversion.

`ImmutableHashMultiBimap<String, Integer> map = ImmutableHashMultiBimap.of("Hello", 1, "World", 1);
 Multimap<Integer, String> mapInverse = map.inverse();`
 
 Will give 
 
 `mapInverse = [1 -> ["Hello", "World"]]`
      


