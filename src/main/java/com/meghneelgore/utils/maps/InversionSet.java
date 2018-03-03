package com.meghneelgore.utils.maps;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Set used to contain inverted values in {@link ImmutableHashMultiBiMap}
 *
 * @param <T> Type of elements in the set.
 */
public class InversionSet<T> implements Set<T> {

    final HashSet<T> hashSet;

    InversionSet() {
        hashSet = new HashSet<>();
    }

    @Override
    public int size() {
        return hashSet.size();
    }

    @Override
    public boolean isEmpty() {
        return hashSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return hashSet.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return hashSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return hashSet.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return hashSet.toArray(a);
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException("Inversion set can't be changed");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Inversion set can't be changed");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return hashSet.containsAll(c);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Inversion set can't be changed");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Inversion set can't be changed");
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        throw new UnsupportedOperationException("Inversion set can't be changed");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Inversion set can't be changed");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Inversion set can't be changed");
    }

    @Override
    public boolean equals(Object obj) {
        return hashSet.equals(obj);
    }

    @Override
    public int hashCode() {
        return hashSet.hashCode();
    }
}
