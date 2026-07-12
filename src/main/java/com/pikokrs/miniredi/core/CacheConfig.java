package com.pikokrs.miniredi.core;

import com.pikokrs.miniredi.eviction.EvictionPolicy;

public class CacheConfig {
    private final int maxSize;
    private final long defaultTtlSeconds;
    private final EvictionPolicy evictionPolicy;
    private final long cleanupIntervalSeconds;
    private CacheConfig(Builder b) {
        this.maxSize = b.maxSize;
        this.defaultTtlSeconds = b.defaultTtlSeconds;
        this.evictionPolicy = b.evictionPolicy;
        this.cleanupIntervalSeconds = b.cleanupIntervalSeconds;
    }

    public int getMaxSize()              { return maxSize; }
    public long getDefaultTtlSeconds()   { return defaultTtlSeconds; }
    public EvictionPolicy getEvictionPolicy() { return evictionPolicy; }
    public long getCleanupIntervalSeconds()   { return cleanupIntervalSeconds; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private int maxSize = 1000;
        private long defaultTtlSeconds = 0;
        private EvictionPolicy evictionPolicy = EvictionPolicy.LRU;
        private long cleanupIntervalSeconds = 5;

        public Builder maxSize(int v)         { maxSize = v; return this; }
        public Builder defaultTtl(long v)     { defaultTtlSeconds = v; return this; }
        public Builder eviction(EvictionPolicy p) { evictionPolicy = p; return this; }
        public Builder cleanupInterval(long v){ cleanupIntervalSeconds = v; return this; }
        public CacheConfig build()            { return new CacheConfig(this); }
    }
}