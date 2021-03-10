package com.prometheous.coding;

import java.util.Collection;

public class ImmutableCollectionImpl<E> implements ImmutableCollection<E> {
    private final Collection<E> immutableCollection;

    public <S> void find(S e) {

    }

    public ImmutableCollectionImpl(Collection<E> collection) {
        this.immutableCollection = collection;
    }
    public ImmutableCollection<E> add(E e) throws Exception {
        ImmutableCollectionImpl<E> newCollection = new ImmutableCollectionImpl(immutableCollection);
        newCollection.getCollection().add(e);
        return newCollection;
    }

    public ImmutableCollection<E> remove(E e) throws Exception {
        ImmutableCollectionImpl<E> newCollection = new ImmutableCollectionImpl(immutableCollection);
        newCollection.getCollection().remove(e);
        return newCollection;
    }

    public Collection<E> getCollection() {
        return this.immutableCollection;
    }

    public int size() {
        return immutableCollection.size();
    }
}
