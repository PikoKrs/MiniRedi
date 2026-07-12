package com.pikokrs.miniredi.core;

import java.util.Optional;
import java.util.Set;

public interface Cache<K, V> {
    void put(K key, V value);
    void put(K key, V value, long ttlSeconds);
    Optional<V> get(K key);
    boolean containsKey(K key);
    void remove(K key);
    int size();
    void clear();
    Set<K> keys();
}
