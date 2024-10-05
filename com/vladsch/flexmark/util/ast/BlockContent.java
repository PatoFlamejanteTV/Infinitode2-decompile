/*     */ package com.vladsch.flexmark.util.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SegmentedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockContent
/*     */ {
/*  12 */   private final ArrayList<BasedSequence> lines = new ArrayList<>();
/*  13 */   private final ArrayList<Integer> lineIndents = new ArrayList<>();
/*     */   
/*     */   public BasedSequence getLine(int paramInt) {
/*  16 */     return this.lines.get(paramInt);
/*     */   }
/*     */   
/*     */   public BasedSequence getSpanningChars() {
/*  20 */     return (this.lines.size() > 0) ? ((BasedSequence)this.lines.get(0)).baseSubSequence(((BasedSequence)this.lines.get(0)).getStartOffset(), ((BasedSequence)this.lines.get(this.lines.size() - 1)).getEndOffset()) : BasedSequence.NULL;
/*     */   }
/*     */   
/*     */   public List<BasedSequence> getLines() {
/*  24 */     return this.lines;
/*     */   }
/*     */   
/*     */   public List<Integer> getLineIndents() {
/*  28 */     return this.lineIndents;
/*     */   }
/*     */   
/*     */   public int getLineCount() {
/*  32 */     return this.lines.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContent() {}
/*     */ 
/*     */   
/*     */   public BlockContent(BlockContent paramBlockContent, int paramInt1, int paramInt2) {
/*  40 */     assert paramBlockContent.lines.size() == paramBlockContent.lineIndents.size() : "lines and eols should be of the same size";
/*     */     
/*  42 */     if (paramBlockContent.lines.size() > 0 && paramInt1 < paramInt2) {
/*  43 */       this.lines.addAll(paramBlockContent.lines.subList(paramInt1, paramInt2));
/*  44 */       this.lineIndents.addAll(paramBlockContent.lineIndents.subList(paramInt1, paramInt2));
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getStartOffset() {
/*  49 */     return (this.lines.size() > 0) ? ((BasedSequence)this.lines.get(0)).getStartOffset() : -1;
/*     */   }
/*     */   
/*     */   public int getEndOffset() {
/*  53 */     return (this.lines.size() > 0) ? ((BasedSequence)this.lines.get(this.lines.size() - 1)).getEndOffset() : -1;
/*     */   }
/*     */   
/*     */   public int getLineIndent() {
/*  57 */     return (this.lines.size() > 0) ? ((Integer)this.lineIndents.get(0)).intValue() : 0;
/*     */   }
/*     */   
/*     */   public int getSourceLength() {
/*  61 */     return (this.lines.size() > 0) ? (((BasedSequence)this.lines.get(this.lines.size() - 1)).getEndOffset() - ((BasedSequence)this.lines.get(0)).getStartOffset()) : -1;
/*     */   }
/*     */   
/*     */   public void add(BasedSequence paramBasedSequence, int paramInt) {
/*  65 */     this.lines.add(paramBasedSequence);
/*  66 */     this.lineIndents.add(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public void addAll(List<BasedSequence> paramList, List<Integer> paramList1) {
/*  70 */     assert paramList.size() == paramList1.size() : "lines and lineIndents should be of the same size";
/*  71 */     this.lines.addAll(paramList);
/*  72 */     this.lineIndents.addAll(paramList1);
/*     */   }
/*     */   
/*     */   public boolean hasSingleLine() {
/*  76 */     return (this.lines.size() == 1);
/*     */   }
/*     */   
/*     */   public BasedSequence getContents() {
/*  80 */     if (this.lines.size() == 0) return BasedSequence.NULL; 
/*  81 */     return getContents(0, this.lines.size());
/*     */   }
/*     */   
/*     */   public BlockContent subContents(int paramInt1, int paramInt2) {
/*  85 */     return new BlockContent(this, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public BasedSequence getContents(int paramInt1, int paramInt2) {
/*  89 */     if (this.lines.size() == 0) return BasedSequence.NULL;
/*     */     
/*  91 */     if (paramInt1 < 0) {
/*  92 */       throw new IndexOutOfBoundsException("startLine must be at least 0");
/*     */     }
/*  94 */     if (paramInt2 < 0) {
/*  95 */       throw new IndexOutOfBoundsException("endLine must be at least 0");
/*     */     }
/*  97 */     if (paramInt2 < paramInt1) {
/*  98 */       throw new IndexOutOfBoundsException("endLine must not be less than startLine");
/*     */     }
/* 100 */     if (paramInt2 > this.lines.size()) {
/* 101 */       throw new IndexOutOfBoundsException("endLine must not be greater than line cardinality");
/*     */     }
/*     */     
/* 104 */     return SegmentedSequence.create(this.lines.get(0), this.lines.subList(paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   public String getString() {
/* 108 */     if (this.lines.size() == 0) return "";
/*     */     
/* 110 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 112 */     for (BasedSequence basedSequence : this.lines) {
/* 113 */       stringBuilder.append((CharSequence)basedSequence.trimEOL());
/* 114 */       stringBuilder.append('\n');
/*     */     } 
/*     */     
/* 117 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\BlockContent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */