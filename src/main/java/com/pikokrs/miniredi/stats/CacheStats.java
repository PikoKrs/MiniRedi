package com.pikokrs.miniredi.stats;

import java.util.concurrent.atomic.AtomicLong;

public class CacheStats {
    private final AtomicLong hits = new AtomicLong(0);
    private final AtomicLong misses = new AtomicLong(0);
    private final AtomicLong evictions = new AtomicLong(0);
    private final AtomicLong expired = new AtomicLong(0);

    public void recordHit()       { hits.incrementAndGet(); }
    public void recordMiss()      { misses.incrementAndGet(); }
    public void recordEviction()  { evictions.incrementAndGet(); }
    public void recordExpired()   { expired.incrementAndGet(); }

    public long getHits()       { return hits.get(); }
    public long getMisses()     { return misses.get(); }
    public long getEvictions()  { return evictions.get(); }
    public long getExpired()    { return expired.get(); }

    public double hitRate() {
        long total = hits.get() + misses.get();
        return total == 0 ? 0.0 : (double) hits.get() / total;
    }

    @Override
    public String toString() {
        return String.format("hits=%d, misses=%d, evictions=%d, expired=%d, hitRate=%.2f",
                hits.get(), misses.get(), evictions.get(), expired.get(), hitRate());
    }
}
