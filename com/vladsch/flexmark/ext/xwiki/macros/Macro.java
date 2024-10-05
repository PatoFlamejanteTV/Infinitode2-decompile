/*     */ package com.vladsch.flexmark.ext.xwiki.macros;
/*     */ 
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Macro
/*     */   extends Node
/*     */ {
/*  15 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  16 */   protected BasedSequence name = BasedSequence.NULL;
/*  17 */   protected BasedSequence attributeText = BasedSequence.NULL;
/*  18 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  24 */     return new BasedSequence[] { this.openingMarker, this.name, this.attributeText, this.closingMarker };
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  29 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "open");
/*  30 */     segmentSpanChars(paramStringBuilder, this.name, "name");
/*  31 */     segmentSpanChars(paramStringBuilder, this.attributeText, "attributes");
/*  32 */     segmentSpanChars(paramStringBuilder, this.closingMarker, "close");
/*  33 */     if (isClosedTag()) paramStringBuilder.append(" isClosed"); 
/*  34 */     if (isBlockMacro()) paramStringBuilder.append(" isBlockMacro"); 
/*  35 */     segmentSpanChars(paramStringBuilder, getMacroContentChars(), "macroContent");
/*     */   }
/*     */ 
/*     */   
/*     */   public Macro() {}
/*     */   
/*     */   public Macro(BasedSequence paramBasedSequence) {
/*  42 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public Macro(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/*  46 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/*  47 */     this.openingMarker = paramBasedSequence1;
/*  48 */     this.name = paramBasedSequence2;
/*  49 */     this.closingMarker = paramBasedSequence3;
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  53 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  57 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getName() {
/*  61 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(BasedSequence paramBasedSequence) {
/*  65 */     this.name = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/*  69 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/*  73 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getAttributeText() {
/*  77 */     return this.attributeText;
/*     */   }
/*     */   
/*     */   public void setAttributeText(BasedSequence paramBasedSequence) {
/*  81 */     this.attributeText = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public boolean isBlockMacro() {
/*     */     Node node;
/*  86 */     if (node = getParent() instanceof MacroBlock && node.getFirstChild() == this) return true;  return false;
/*     */   }
/*     */   
/*     */   public Map<String, String> getAttributes() {
/*  90 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*  91 */     Node node = getFirstChild();
/*  92 */     while (node != null) {
/*  93 */       if (node instanceof MacroAttribute) {
/*  94 */         MacroAttribute macroAttribute = (MacroAttribute)node;
/*  95 */         linkedHashMap.put(macroAttribute.getAttribute().toString(), macroAttribute.getValue().toString());
/*     */       } 
/*  97 */       node = node.getNext();
/*     */     } 
/*  99 */     return (Map)linkedHashMap;
/*     */   }
/*     */   
/*     */   public BasedSequence getMacroContentChars() {
/* 103 */     Node node = getLastChild();
/* 104 */     int j = getClosingMarker().getEndOffset();
/* 105 */     int i = (node == null || node instanceof MacroAttribute) ? getEndOffset() : node.getStartOffset();
/* 106 */     return isClosedTag() ? BasedSequence.NULL : getChars().baseSubSequence(j, i);
/*     */   }
/*     */   
/*     */   public boolean isClosedTag() {
/* 110 */     return (getClosingMarker().length() > 2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\Macro.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */