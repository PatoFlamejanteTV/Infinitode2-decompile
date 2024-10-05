/*     */ package com.vladsch.flexmark.util.format;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.tree.BasedOffsetTracker;
/*     */ import com.vladsch.flexmark.util.sequence.builder.tree.OffsetInfo;
/*     */ import com.vladsch.flexmark.util.sequence.builder.tree.SegmentOffsetTree;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ public class TrackedOffsetList implements List<TrackedOffset> {
/*  14 */   public static TrackedOffsetList EMPTY_LIST = new TrackedOffsetList(BasedSequence.NULL, Collections.emptyList()); private final BasedSequence myBaseSeq; private final List<TrackedOffset> myTrackedOffsets;
/*     */   private final BasedOffsetTracker myBasedOffsetTracker;
/*     */   
/*     */   public static TrackedOffsetList create(BasedSequence paramBasedSequence, List<TrackedOffset> paramList) {
/*  18 */     return (paramList instanceof TrackedOffsetList) ? (TrackedOffsetList)paramList : new TrackedOffsetList(paramBasedSequence, paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TrackedOffsetList create(BasedSequence paramBasedSequence, int[] paramArrayOfint) {
/*  23 */     ArrayList<TrackedOffset> arrayList = new ArrayList(paramArrayOfint.length); int i; byte b;
/*  24 */     for (i = (paramArrayOfint = paramArrayOfint).length, b = 0; b < i; ) { int j = paramArrayOfint[b];
/*  25 */       arrayList.add(TrackedOffset.track(j)); b++; }
/*     */     
/*  27 */     return new TrackedOffsetList(paramBasedSequence, arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TrackedOffsetList(BasedSequence paramBasedSequence, List<TrackedOffset> paramList) {
/*  35 */     this.myBaseSeq = paramBasedSequence;
/*  36 */     this.myTrackedOffsets = new ArrayList<>(paramList);
/*  37 */     this.myTrackedOffsets.sort(Comparator.comparing(TrackedOffset::getOffset));
/*  38 */     paramList = new ArrayList<>(paramList.size());
/*  39 */     for (TrackedOffset trackedOffset : this.myTrackedOffsets) {
/*  40 */       paramList.add(Seg.segOf(trackedOffset.getOffset(), trackedOffset.getOffset() + 1));
/*     */     }
/*  42 */     SegmentOffsetTree segmentOffsetTree = SegmentOffsetTree.build(paramList, "");
/*  43 */     this.myBasedOffsetTracker = BasedOffsetTracker.create(paramBasedSequence, segmentOffsetTree);
/*  44 */     assert this.myBasedOffsetTracker.size() == this.myTrackedOffsets.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public TrackedOffsetList getUnresolvedOffsets() {
/*  49 */     ArrayList<TrackedOffset> arrayList = new ArrayList();
/*     */     
/*  51 */     for (Iterator<TrackedOffset> iterator = this.myTrackedOffsets.iterator(); iterator.hasNext();) {
/*  52 */       if (!(trackedOffset = iterator.next()).isResolved()) arrayList.add(trackedOffset); 
/*     */     } 
/*  54 */     return arrayList.isEmpty() ? EMPTY_LIST : new TrackedOffsetList(this.myBaseSeq, arrayList);
/*     */   }
/*     */   
/*     */   public boolean haveUnresolved() {
/*  58 */     for (Iterator<TrackedOffset> iterator = this.myTrackedOffsets.iterator(); iterator.hasNext();) {
/*  59 */       if (!(trackedOffset = iterator.next()).isResolved()) return true; 
/*     */     } 
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence getBaseSeq() {
/*  66 */     return this.myBaseSeq;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<TrackedOffset> getTrackedOffsets() {
/*  71 */     return this.myTrackedOffsets;
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedOffsetTracker getBasedOffsetTracker() {
/*  76 */     return this.myBasedOffsetTracker;
/*     */   }
/*     */ 
/*     */   
/*     */   public TrackedOffsetList getTrackedOffsets(int paramInt1, int paramInt2) {
/*  81 */     OffsetInfo offsetInfo1 = this.myBasedOffsetTracker.getOffsetInfo(paramInt1, (paramInt1 == paramInt2));
/*  82 */     OffsetInfo offsetInfo2 = this.myBasedOffsetTracker.getOffsetInfo(paramInt2, true);
/*  83 */     int i = offsetInfo1.pos;
/*  84 */     int j = offsetInfo2.pos;
/*     */     
/*  86 */     if (i < 0 && j >= 0) {
/*  87 */       i = 0;
/*  88 */       j++;
/*  89 */     } else if (i >= 0 && j >= 0) {
/*  90 */       j++;
/*     */     } else {
/*  92 */       return EMPTY_LIST;
/*     */     } 
/*     */     
/*  95 */     j = Math.min(this.myBasedOffsetTracker.size(), j);
/*     */     
/*  97 */     if (i >= j) return EMPTY_LIST;
/*     */ 
/*     */     
/* 100 */     if (((TrackedOffset)this.myTrackedOffsets.get(i)).getOffset() < paramInt1) i++; 
/* 101 */     if (((TrackedOffset)this.myTrackedOffsets.get(j - 1)).getOffset() > paramInt2) j--;
/*     */     
/* 103 */     if (i >= j) return EMPTY_LIST;
/*     */ 
/*     */     
/* 106 */     return new TrackedOffsetList(this.myBaseSeq, this.myTrackedOffsets.subList(i, j));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(TrackedOffset paramTrackedOffset) {
/* 113 */     throw new IllegalStateException("Not supported. Immutable list.");
/* 114 */   } public TrackedOffset set(int paramInt, TrackedOffset paramTrackedOffset) { throw new IllegalStateException("Not supported. Immutable list."); }
/* 115 */   public void add(int paramInt, TrackedOffset paramTrackedOffset) { throw new IllegalStateException("Not supported. Immutable list."); }
/* 116 */   public TrackedOffset remove(int paramInt) { throw new IllegalStateException("Not supported. Immutable list."); }
/* 117 */   public boolean addAll(Collection<? extends TrackedOffset> paramCollection) { throw new IllegalStateException("Not supported. Immutable list."); }
/* 118 */   public boolean addAll(int paramInt, Collection<? extends TrackedOffset> paramCollection) { throw new IllegalStateException("Not supported. Immutable list."); }
/* 119 */   public boolean removeAll(Collection<?> paramCollection) { throw new IllegalStateException("Not supported. Immutable list."); }
/* 120 */   public boolean retainAll(Collection<?> paramCollection) { throw new IllegalStateException("Not supported. Immutable list."); }
/* 121 */   public void replaceAll(UnaryOperator<TrackedOffset> paramUnaryOperator) { throw new IllegalStateException("Not supported. Immutable list."); }
/* 122 */   public void sort(Comparator<? super TrackedOffset> paramComparator) { throw new IllegalStateException("Not supported. Immutable list."); }
/* 123 */   public void clear() { throw new IllegalStateException("Not supported. Immutable list."); } public boolean remove(Object paramObject) {
/* 124 */     throw new IllegalStateException("Not supported. Immutable list.");
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 129 */     return this.myTrackedOffsets.size();
/*     */   }
/*     */   public boolean isEmpty() {
/* 132 */     return this.myTrackedOffsets.isEmpty();
/*     */   }
/*     */   public boolean contains(Object paramObject) {
/* 135 */     return this.myTrackedOffsets.contains(paramObject);
/*     */   }
/*     */   
/*     */   public Iterator<TrackedOffset> iterator() {
/* 139 */     return this.myTrackedOffsets.iterator();
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/* 143 */     return this.myTrackedOffsets.toArray();
/*     */   }
/*     */   
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 147 */     return this.myTrackedOffsets.toArray(paramArrayOfT);
/*     */   }
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 150 */     return this.myTrackedOffsets.containsAll(paramCollection);
/*     */   }
/*     */   public boolean equals(Object paramObject) {
/* 153 */     return this.myTrackedOffsets.equals(paramObject);
/*     */   }
/*     */   public int hashCode() {
/* 156 */     return this.myTrackedOffsets.hashCode();
/*     */   }
/*     */   public TrackedOffset get(int paramInt) {
/* 159 */     return this.myTrackedOffsets.get(paramInt);
/*     */   }
/*     */   public int indexOf(Object paramObject) {
/* 162 */     return this.myTrackedOffsets.indexOf(paramObject);
/*     */   }
/*     */   public int lastIndexOf(Object paramObject) {
/* 165 */     return this.myTrackedOffsets.lastIndexOf(paramObject);
/*     */   }
/*     */   
/*     */   public ListIterator<TrackedOffset> listIterator() {
/* 169 */     return this.myTrackedOffsets.listIterator();
/*     */   }
/*     */   
/*     */   public ListIterator<TrackedOffset> listIterator(int paramInt) {
/* 173 */     return this.myTrackedOffsets.listIterator(paramInt);
/*     */   }
/*     */   
/*     */   public List<TrackedOffset> subList(int paramInt1, int paramInt2) {
/* 177 */     return this.myTrackedOffsets.subList(paramInt1, paramInt2);
/*     */   }
/*     */   public Spliterator<TrackedOffset> spliterator() {
/* 180 */     return this.myTrackedOffsets.spliterator();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TrackedOffsetList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */