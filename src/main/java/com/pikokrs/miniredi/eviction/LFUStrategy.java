package com.pikokrs.miniredi.eviction;

import com.pikokrs.miniredi.core.CacheEntry;
import java.util.Comparator;
import java.util.Map;

public class LFUStrategy<K, V> implements EvictionStrategy<K, V> {
    @Override
    public K findVictim(Map<K, CacheEntry<V>> entries) {
        return entries.entrySet().stream()
                .min(Map.Entry.<K, CacheEntry<V>>comparingByValue(
                        Comparator.comparingLong((CacheEntry<V> e) -> e.accessCount())
                                .thenComparing(CacheEntry::lastAccessedAt)))
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
