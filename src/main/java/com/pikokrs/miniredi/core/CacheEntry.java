package com.pikokrs.miniredi.core;

import java.time.Instant;

public record CacheEntry<V>(
        V value,
        Instant createdAt,
        Instant lastAccessedAt,
        long accessCount,
        Instant expireAt
) {
    public static <V> CacheEntry<V> of (V value){
        Instant now = Instant.now();
        return new CacheEntry<>(value, now, now, 0, null);
    }
    public static <V> CacheEntry<V> of (V value, long ttlSeconds){
        Instant now = Instant.now();
        return new CacheEntry<>(value, now, now, 0, now.plusSeconds(ttlSeconds));
    }
    public boolean isExpired(){
        return expireAt != null && Instant.now().isAfter(expireAt);
    }
    public CacheEntry<V> touch(){
        return new CacheEntry<>(value, createdAt, Instant.now(), accessCount+1, expireAt);
    }
}
