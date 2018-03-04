# ImmutableMultiBiMap

A bimap allows the user to have an inverse view but constrains the user to have unique keys K _and_ values V so that it can 
return an inverted map V -> K

A multimap allows the user to have multiple values for the same key.

The ImmutableMultiBiMap allows the user to have non-unique values V for different keys K and inverts them into a map 
that returns a V \-> Set\<K\> map. 

For example, 

<code>
ImmutableBiMap<String, Integer> bimap = ImmutableBiMap.of("One", 1, "Two", 2);
ImmutableBimap<Integer, String> inverseMap = bimap.inverse();
</code>

Will give you an <code>inverseMap </code> having values

<code>
[ 1 -> "One" ], [ 2 -> "Two"]
</code>

But the <code> ImmutableBiMap </code> throws an exception if you try to instantiate like so

<code>
ImmutableBiMap<String, Integer> bimap = ImmutableBiMap.of("One", 1, "Two", 1);
</code>

Because it has no way to invert the map.

A MultiSet allows the user to have multiple values for the same key. For instance,

<code>
 ImmutableMultimap<String, Integer> multimap = ImmutableMultimap.of("One", 1, "One", 2);

</code>

Will give the user a map like so

<code>
[ "One" -> Collection<Integer>[1, 2]]
</code>

The <code> ImmutableMultiBiMap </code> allows the user to have a non-unique set of vaues as well as inversion by making a Multimap out of the inversion.

Example

<code>

ImmutableHashMultiBiMap.Builder<String, Integer> builder = new ImmutableHashMultiBiMap.Builder<>();
builder.put("Hello", 1);
builder.put("Mello", 1);
builder.put("Jello", 2);
builder.put("Fellow", 2);
builder.put("Callow", 3);

ImmutableHashMultiBiMap<String, Integer> map = builder.build();
Multimap<Integer, String> invertedMap = map.inverse();


invertedMap = [1 -> ["Hello", "Mello"], 2 -> ["Jello", "Fellow"], 3 -> ["Callow"]]        
</code>


