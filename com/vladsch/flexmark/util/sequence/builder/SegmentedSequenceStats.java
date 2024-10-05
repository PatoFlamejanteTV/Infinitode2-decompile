/*     */ package com.vladsch.flexmark.util.sequence.builder;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.MinMaxAvgLong;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public class SegmentedSequenceStats {
/*     */   private ArrayList<StatsEntry> aggregatedStats;
/*     */   
/*     */   public static class StatsEntry implements Comparable<StatsEntry> {
/*     */     int segments;
/*     */     int count;
/*  15 */     final MinMaxAvgLong segStats = new MinMaxAvgLong();
/*  16 */     final MinMaxAvgLong length = new MinMaxAvgLong();
/*  17 */     final MinMaxAvgLong overhead = new MinMaxAvgLong();
/*     */     
/*     */     public StatsEntry(int param1Int) {
/*  20 */       assert param1Int > 0 : "segments: " + param1Int + " < 1";
/*  21 */       this.segments = param1Int;
/*     */     }
/*     */     
/*     */     public void add(int param1Int1, int param1Int2, int param1Int3) {
/*  25 */       this.count++;
/*  26 */       this.segStats.add(param1Int1);
/*  27 */       this.length.add(param1Int2);
/*  28 */       this.overhead.add(param1Int3);
/*     */     }
/*     */     
/*     */     public void add(StatsEntry param1StatsEntry) {
/*  32 */       this.count += param1StatsEntry.count;
/*  33 */       this.segStats.add(param1StatsEntry.segStats);
/*  34 */       this.length.add(param1StatsEntry.length);
/*  35 */       this.overhead.add(param1StatsEntry.overhead);
/*     */     }
/*     */ 
/*     */     
/*     */     public int compareTo(StatsEntry param1StatsEntry) {
/*     */       int i;
/*  41 */       if ((i = Integer.compare(this.segments, param1StatsEntry.segments)) != 0) return i; 
/*  42 */       return Integer.compare(this.count, param1StatsEntry.count);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/*  47 */       if (this == param1Object) return true; 
/*  48 */       if (param1Object == null || getClass() != param1Object.getClass()) return false; 
/*  49 */       return (this.segments == ((StatsEntry)param1Object).segments);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*  54 */       return this.segments;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  59 */   private final HashMap<StatsEntry, StatsEntry> stats = new HashMap<>();
/*     */ 
/*     */   
/*     */   static final ArrayList<Integer> AGGR_STEPS;
/*     */ 
/*     */   
/*     */   public void addStats(int paramInt1, int paramInt2, int paramInt3) {
/*  66 */     StatsEntry statsEntry = new StatsEntry(paramInt1);
/*     */     
/*  68 */     (statsEntry = this.stats.computeIfAbsent(statsEntry, paramStatsEntry -> paramStatsEntry)).add(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   public int getCount(int paramInt) {
/*  72 */     StatsEntry statsEntry = new StatsEntry(paramInt);
/*  73 */     if (this.stats.containsKey(statsEntry)) {
/*  74 */       return ((StatsEntry)this.stats.get(statsEntry)).count;
/*     */     }
/*  76 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStatsText(List<StatsEntry> paramList) {
/*  81 */     StringBuilder stringBuilder = new StringBuilder();
/*  82 */     int i = paramList.size();
/*     */     
/*  84 */     stringBuilder.append(
/*  85 */         String.format("%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%8s", new Object[] {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             "count", "min-seg", "avg-seg", "max-seg", "min-len", "avg-len", "max-len", "min-ovr", "avg-ovr", "max-ovr",
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             "tot-len", "tot-chr", "tot-ovr", "ovr %"
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 101 */           })).append("\n");
/*     */     
/* 103 */     for (i = i; i-- > 0; ) {
/* 104 */       StatsEntry statsEntry = paramList.get(i);
/* 105 */       stringBuilder.append(
/* 106 */           String.format("%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%8.3f", new Object[] { 
/* 107 */               Integer.valueOf(statsEntry.count), 
/* 108 */               Long.valueOf((statsEntry.count == 1) ? statsEntry.segments : statsEntry.segStats.getMin()), 
/* 109 */               Long.valueOf((statsEntry.count == 1) ? statsEntry.segments : statsEntry.segStats.getAvg(statsEntry.count)), 
/* 110 */               Long.valueOf((statsEntry.count == 1) ? statsEntry.segments : statsEntry.segStats.getMax()), 
/* 111 */               Long.valueOf(statsEntry.length.getMin()), 
/* 112 */               Long.valueOf(statsEntry.length.getAvg(statsEntry.count)), 
/* 113 */               Long.valueOf(statsEntry.length.getMax()), 
/* 114 */               Long.valueOf(statsEntry.overhead.getMin()), 
/* 115 */               Long.valueOf(statsEntry.overhead.getAvg(statsEntry.count)), 
/* 116 */               Long.valueOf(statsEntry.overhead.getMax()), 
/* 117 */               Long.valueOf(statsEntry.length.getTotal()), 
/* 118 */               Long.valueOf(statsEntry.length.getTotal() << 1L), 
/* 119 */               Long.valueOf(statsEntry.overhead.getTotal()), 
/* 120 */               Double.valueOf((statsEntry.length.getTotal() == 0L) ? 0.0D : (100.0D * statsEntry.overhead.getTotal() / statsEntry.length.getTotal() / 2.0D))
/*     */             
/* 122 */             })).append("\n");
/*     */     } 
/* 124 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAggregatedStatsText() {
/* 129 */     return getStatsText(getAggregatedStats());
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/* 134 */     (AGGR_STEPS = new ArrayList<>()).add(Integer.valueOf(1));
/* 135 */     AGGR_STEPS.add(Integer.valueOf(2));
/* 136 */     AGGR_STEPS.add(Integer.valueOf(3));
/* 137 */     AGGR_STEPS.add(Integer.valueOf(4));
/* 138 */     AGGR_STEPS.add(Integer.valueOf(5));
/* 139 */     AGGR_STEPS.add(Integer.valueOf(6));
/* 140 */     AGGR_STEPS.add(Integer.valueOf(7));
/* 141 */     AGGR_STEPS.add(Integer.valueOf(8));
/* 142 */     AGGR_STEPS.add(Integer.valueOf(15));
/* 143 */     AGGR_STEPS.add(Integer.valueOf(16));
/* 144 */     AGGR_STEPS.add(Integer.valueOf(256));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     for (int i = 65536; i < 1048576; ) { AGGR_STEPS.add(Integer.valueOf(i)); i += 65536; }
/*     */   
/*     */   }
/* 152 */   static final int MAX_BUCKETS = AGGR_STEPS.size();
/*     */ 
/*     */   
/*     */   public List<StatsEntry> getAggregatedStats() {
/* 156 */     if (this.aggregatedStats == null) {
/* 157 */       List<StatsEntry> list = getStats();
/* 158 */       this.aggregatedStats = new ArrayList<>(MAX_BUCKETS);
/*     */       
/* 160 */       int i = MAX_BUCKETS - 1;
/* 161 */       int j = ((Integer)AGGR_STEPS.get(i)).intValue();
/*     */       
/* 163 */       int k = list.size(); int m;
/* 164 */       for (m = 0; m < MAX_BUCKETS; m++) {
/* 165 */         this.aggregatedStats.add(null);
/*     */       }
/*     */       
/* 168 */       for (m = k; m-- > 0; ) {
/*     */         StatsEntry statsEntry1;
/* 170 */         if ((statsEntry1 = list.get(m)).segments < j) {
/*     */           
/* 172 */           while (i > 0) {
/* 173 */             i--;
/* 174 */             j = ((Integer)AGGR_STEPS.get(i)).intValue();
/* 175 */             if (statsEntry1.segments >= j)
/*     */               break; 
/* 177 */           }  assert i >= 0;
/*     */         } 
/*     */         
/* 180 */         assert statsEntry1.segments >= j;
/*     */         
/*     */         StatsEntry statsEntry2;
/*     */         
/* 184 */         if ((statsEntry2 = this.aggregatedStats.get(i)) == null) {
/* 185 */           statsEntry2 = new StatsEntry(j);
/* 186 */           this.aggregatedStats.set(i, statsEntry2);
/*     */         } 
/*     */         
/* 189 */         statsEntry2.add(statsEntry1);
/*     */       } 
/*     */       
/* 192 */       this.aggregatedStats.removeIf(Objects::isNull);
/*     */     } 
/*     */     
/* 195 */     return this.aggregatedStats;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStatsText() {
/* 200 */     List<StatsEntry> list = getStats();
/* 201 */     return getStatsText(list);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 205 */     this.stats.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<StatsEntry> getStats() {
/*     */     ArrayList<?> arrayList;
/* 212 */     (arrayList = new ArrayList(this.stats.keySet())).sort(StatsEntry::compareTo);
/* 213 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public static SegmentedSequenceStats getInstance() {
/* 218 */     return new SegmentedSequenceStats();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\SegmentedSequenceStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */