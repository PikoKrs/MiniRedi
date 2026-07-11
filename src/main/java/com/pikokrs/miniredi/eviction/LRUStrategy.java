package com.pikokrs.miniredi.eviction;

import com.pikokrs.miniredi.core.CacheEntry;
import java.util.Comparator;
import java.util.Map;

public class LRUStrategy<K, V> implements EvictionStrategy<K, V> {
    @Override
    public K findVictim(Map<K, CacheEntry<V>> entries) {
        return entries.entrySet().stream()
                .min(Map.Entry.comparingByValue(
                        Comparator.comparing(CacheEntry::lastAccessedAt)))
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
