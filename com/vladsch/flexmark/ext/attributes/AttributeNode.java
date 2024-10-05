/*     */ package com.vladsch.flexmark.ext.attributes;
/*     */ 
/*     */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AttributeNode
/*     */   extends Node
/*     */   implements DoNotDecorate
/*     */ {
/*  14 */   protected BasedSequence name = BasedSequence.NULL;
/*  15 */   protected BasedSequence attributeSeparator = BasedSequence.NULL;
/*  16 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  17 */   protected BasedSequence value = BasedSequence.NULL;
/*  18 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  24 */     return new BasedSequence[] { this.name, this.attributeSeparator, this.openingMarker, this.value, this.closingMarker };
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  29 */     segmentSpanChars(paramStringBuilder, this.name, "name");
/*  30 */     segmentSpanChars(paramStringBuilder, this.attributeSeparator, "sep");
/*  31 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.value, this.closingMarker, "value");
/*  32 */     if (isImplicitName()) paramStringBuilder.append(" isImplicit"); 
/*  33 */     if (isClass()) paramStringBuilder.append(" isClass"); 
/*  34 */     if (isId()) paramStringBuilder.append(" isId");
/*     */   
/*     */   }
/*     */   
/*     */   public AttributeNode() {}
/*     */   
/*     */   public AttributeNode(BasedSequence paramBasedSequence) {
/*  41 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public AttributeNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5) {
/*  45 */     super(spanningChars(new BasedSequence[] { paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5 }));
/*  46 */     this.name = (paramBasedSequence1 != null) ? paramBasedSequence1 : BasedSequence.NULL;
/*  47 */     this.attributeSeparator = (paramBasedSequence2 != null) ? paramBasedSequence2 : BasedSequence.NULL;
/*  48 */     this.openingMarker = (paramBasedSequence3 != null) ? paramBasedSequence3 : BasedSequence.NULL;
/*  49 */     this.value = (paramBasedSequence4 != null) ? paramBasedSequence4 : BasedSequence.NULL;
/*  50 */     this.closingMarker = (paramBasedSequence5 != null) ? paramBasedSequence5 : BasedSequence.NULL;
/*     */   }
/*     */   
/*     */   public static boolean isImplicitName(CharSequence paramCharSequence) {
/*  54 */     return (paramCharSequence.length() > 0 && (paramCharSequence.charAt(0) == '.' || paramCharSequence.charAt(0) == '#'));
/*     */   }
/*     */   
/*     */   public boolean isImplicitName() {
/*  58 */     return (this.value.isNotNull() && this.attributeSeparator.isNull() && this.name.isNotNull());
/*     */   }
/*     */   
/*     */   public boolean isClass() {
/*  62 */     return ((isImplicitName() && this.name.equals(".")) || (!isImplicitName() && this.name.equals("class")));
/*     */   }
/*     */   
/*     */   public boolean isId() {
/*  66 */     return ((isImplicitName() && this.name.equals("#")) || (!isImplicitName() && this.name.equals("id")));
/*     */   }
/*     */   
/*     */   public BasedSequence getName() {
/*  70 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(BasedSequence paramBasedSequence) {
/*  74 */     this.name = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getAttributeSeparator() {
/*  78 */     return this.attributeSeparator;
/*     */   }
/*     */   
/*     */   public void setAttributeSeparator(BasedSequence paramBasedSequence) {
/*  82 */     this.attributeSeparator = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getValue() {
/*  86 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(BasedSequence paramBasedSequence) {
/*  90 */     this.value = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  94 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  98 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/* 102 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 106 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\AttributeNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */