package com.pikokrs.miniredi.eviction;

import com.pikokrs.miniredi.core.CacheEntry;
import java.util.Map;

@FunctionalInterface
public interface EvictionStrategy<K, V> {
    K findVictim(Map<K, CacheEntry<V>> entries);
}
