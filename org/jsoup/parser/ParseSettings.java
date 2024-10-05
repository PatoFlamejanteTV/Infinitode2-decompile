/*    */ package org.jsoup.parser;
/*    */ 
/*    */ import org.jsoup.internal.Normalizer;
/*    */ import org.jsoup.nodes.Attributes;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParseSettings
/*    */ {
/* 22 */   public static final ParseSettings htmlDefault = new ParseSettings(false, false);
/* 23 */   public static final ParseSettings preserveCase = new ParseSettings(true, true);
/*    */ 
/*    */   
/*    */   private final boolean preserveTagCase;
/*    */ 
/*    */   
/*    */   private final boolean preserveAttributeCase;
/*    */ 
/*    */   
/*    */   public boolean preserveTagCase() {
/* 33 */     return this.preserveTagCase;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean preserveAttributeCase() {
/* 40 */     return this.preserveAttributeCase;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ParseSettings(boolean paramBoolean1, boolean paramBoolean2) {
/* 49 */     this.preserveTagCase = paramBoolean1;
/* 50 */     this.preserveAttributeCase = paramBoolean2;
/*    */   }
/*    */   
/*    */   ParseSettings(ParseSettings paramParseSettings) {
/* 54 */     this(paramParseSettings.preserveTagCase, paramParseSettings.preserveAttributeCase);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String normalizeTag(String paramString) {
/* 61 */     paramString = paramString.trim();
/* 62 */     if (!this.preserveTagCase)
/* 63 */       paramString = Normalizer.lowerCase(paramString); 
/* 64 */     return paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String normalizeAttribute(String paramString) {
/* 71 */     paramString = paramString.trim();
/* 72 */     if (!this.preserveAttributeCase)
/* 73 */       paramString = Normalizer.lowerCase(paramString); 
/* 74 */     return paramString;
/*    */   }
/*    */   
/*    */   Attributes normalizeAttributes(Attributes paramAttributes) {
/* 78 */     if (paramAttributes != null && !this.preserveAttributeCase) {
/* 79 */       paramAttributes.normalize();
/*    */     }
/* 81 */     return paramAttributes;
/*    */   }
/*    */ 
/*    */   
/*    */   static String normalName(String paramString) {
/* 86 */     return Normalizer.lowerCase(paramString.trim());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\ParseSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */