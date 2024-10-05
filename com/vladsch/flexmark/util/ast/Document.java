/*     */ package com.vladsch.flexmark.util.ast;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.data.DataSet;
/*     */ import com.vladsch.flexmark.util.data.DataValueFactory;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSet;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*     */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ public class Document extends Block implements MutableDataHolder {
/*  15 */   public static final Document NULL = new Document(null, BasedSequence.NULL);
/*     */   
/*     */   private final MutableDataSet dataSet;
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  21 */     return EMPTY_SEGMENTS;
/*     */   }
/*     */   
/*     */   public Document(DataHolder paramDataHolder, BasedSequence paramBasedSequence) {
/*  25 */     super(paramBasedSequence);
/*  26 */     this.dataSet = new MutableDataSet(paramDataHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableDataHolder clear() {
/*  31 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> MutableDataHolder set(DataKey<T> paramDataKey, T paramT) {
/*  36 */     return (MutableDataHolder)this.dataSet.set(paramDataKey, paramT);
/*     */   }
/*     */   
/*     */   public <T> MutableDataHolder set(NullableDataKey<T> paramNullableDataKey, T paramT) {
/*  40 */     return (MutableDataHolder)this.dataSet.set(paramNullableDataKey, paramT);
/*     */   }
/*     */   
/*     */   public MutableDataSet setFrom(MutableDataSetter paramMutableDataSetter) {
/*  44 */     return this.dataSet.setFrom(paramMutableDataSetter);
/*     */   }
/*     */   
/*     */   public MutableDataSet setAll(DataHolder paramDataHolder) {
/*  48 */     return this.dataSet.setAll(paramDataHolder);
/*     */   } public static MutableDataSet merge(DataHolder... paramVarArgs) {
/*  50 */     return MutableDataSet.merge(paramVarArgs);
/*     */   }
/*     */   
/*     */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/*  54 */     return this.dataSet.setIn(paramMutableDataHolder);
/*     */   }
/*     */   
/*     */   public MutableDataSet remove(DataKeyBase<?> paramDataKeyBase) {
/*  58 */     return this.dataSet.remove(paramDataKeyBase);
/*     */   }
/*     */   
/*     */   public Object getOrCompute(DataKeyBase<?> paramDataKeyBase, DataValueFactory<?> paramDataValueFactory) {
/*  62 */     return this.dataSet.getOrCompute(paramDataKeyBase, paramDataValueFactory);
/*     */   }
/*     */   
/*     */   public MutableDataSet toMutable() {
/*  66 */     return this.dataSet.toMutable();
/*     */   }
/*     */   
/*     */   public DataSet toImmutable() {
/*  70 */     return this.dataSet.toImmutable();
/*     */   }
/*     */   
/*     */   public MutableDataSet toDataSet() {
/*  74 */     return this.dataSet.toDataSet();
/*     */   }
/*     */   public static DataHolder aggregateActions(DataHolder paramDataHolder1, DataHolder paramDataHolder2) {
/*  77 */     return DataSet.aggregateActions(paramDataHolder1, paramDataHolder2);
/*     */   }
/*     */   public DataHolder aggregate() {
/*  80 */     return this.dataSet.aggregate();
/*     */   }
/*     */   public static DataHolder aggregate(DataHolder paramDataHolder1, DataHolder paramDataHolder2) {
/*  83 */     return DataSet.aggregate(paramDataHolder1, paramDataHolder2);
/*     */   }
/*     */   
/*     */   public Map<? extends DataKeyBase<?>, Object> getAll() {
/*  87 */     return this.dataSet.getAll();
/*     */   }
/*     */   
/*     */   public Collection<? extends DataKeyBase<?>> getKeys() {
/*  91 */     return this.dataSet.getKeys();
/*     */   }
/*     */   public boolean contains(DataKeyBase<?> paramDataKeyBase) {
/*  94 */     return this.dataSet.contains(paramDataKeyBase);
/*     */   }
/*     */   
/*     */   public int getLineCount() {
/*  98 */     if (this.lineSegments == BasedSequence.EMPTY_LIST) {
/*     */       char c;
/* 100 */       return (((c = getChars().lastChar()) == '\n' || c == '\r') ? 0 : 1) + getLineNumber(getChars().length());
/*     */     } 
/* 102 */     return this.lineSegments.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLineNumber(int paramInt) {
/* 116 */     if (this.lineSegments == BasedSequence.EMPTY_LIST) {
/*     */       BasedSequence basedSequence;
/*     */       
/* 119 */       if ((basedSequence = getChars().baseSubSequence(0, Utils.maxLimit(paramInt + 1, new int[] { getChars().length() }))).isEmpty()) return 0; 
/* 120 */       byte b1 = 0;
/* 121 */       int j = basedSequence.endOfLineAnyEOL(0);
/* 122 */       int k = basedSequence.length();
/* 123 */       while (j < k) {
/* 124 */         int m = basedSequence.eolStartLength(j);
/* 125 */         m = j + m;
/* 126 */         if (paramInt >= m) b1++; 
/* 127 */         int n = j;
/* 128 */         j = basedSequence.endOfLineAnyEOL(m);
/* 129 */         assert j > n;
/*     */       } 
/*     */       
/* 132 */       return b1;
/*     */     } 
/* 134 */     int i = this.lineSegments.size();
/* 135 */     for (byte b = 0; b < i; b++) {
/* 136 */       if (paramInt < ((BasedSequence)this.lineSegments.get(b)).getEndOffset()) {
/* 137 */         return b;
/*     */       }
/*     */     } 
/* 140 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\Document.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */