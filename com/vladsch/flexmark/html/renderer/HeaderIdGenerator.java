/*     */ package com.vladsch.flexmark.html.renderer;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.AnchorRefTarget;
/*     */ import com.vladsch.flexmark.ast.util.AnchorRefTargetBlockPreVisitor;
/*     */ import com.vladsch.flexmark.ast.util.AnchorRefTargetBlockVisitor;
/*     */ import com.vladsch.flexmark.html.Disposable;
/*     */ import com.vladsch.flexmark.html.HtmlRenderer;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ public class HeaderIdGenerator
/*     */   implements Disposable, HtmlIdGenerator
/*     */ {
/*  17 */   HashMap<String, Integer> headerBaseIds = new HashMap<>();
/*     */   boolean resolveDupes;
/*     */   String toDashChars;
/*     */   String nonDashChars;
/*     */   boolean noDupedDashes;
/*     */   boolean nonAsciiToLowercase;
/*     */   
/*     */   public HeaderIdGenerator() {
/*  25 */     this(null);
/*     */   }
/*     */   
/*     */   public HeaderIdGenerator(DataHolder paramDataHolder) {
/*  29 */     this.resolveDupes = ((Boolean)HtmlRenderer.HEADER_ID_GENERATOR_RESOLVE_DUPES.get(paramDataHolder)).booleanValue();
/*  30 */     this.toDashChars = (String)HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS.get(paramDataHolder);
/*  31 */     this.nonDashChars = (String)HtmlRenderer.HEADER_ID_GENERATOR_NON_DASH_CHARS.get(paramDataHolder);
/*  32 */     this.noDupedDashes = ((Boolean)HtmlRenderer.HEADER_ID_GENERATOR_NO_DUPED_DASHES.get(paramDataHolder)).booleanValue();
/*  33 */     this.nonAsciiToLowercase = ((Boolean)HtmlRenderer.HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*  38 */     this.headerBaseIds = null;
/*     */   }
/*     */   
/*     */   public boolean isResolveDupes() {
/*  42 */     return this.resolveDupes;
/*     */   }
/*     */   
/*     */   public void setResolveDupes(boolean paramBoolean) {
/*  46 */     this.resolveDupes = paramBoolean;
/*     */   }
/*     */   
/*     */   public String getToDashChars() {
/*  50 */     return this.toDashChars;
/*     */   }
/*     */   
/*     */   public void setToDashChars(String paramString) {
/*  54 */     this.toDashChars = paramString;
/*     */   }
/*     */   
/*     */   public String getNonDashChars() {
/*  58 */     return this.nonDashChars;
/*     */   }
/*     */   
/*     */   public void setNonDashChars(String paramString) {
/*  62 */     this.nonDashChars = paramString;
/*     */   }
/*     */   
/*     */   public boolean isNoDupedDashes() {
/*  66 */     return this.noDupedDashes;
/*     */   }
/*     */   
/*     */   public void setNoDupedDashes(boolean paramBoolean) {
/*  70 */     this.noDupedDashes = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isNonAsciiToLowercase() {
/*  74 */     return this.nonAsciiToLowercase;
/*     */   }
/*     */   
/*     */   public void setNonAsciiToLowercase(boolean paramBoolean) {
/*  78 */     this.nonAsciiToLowercase = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateIds(Document paramDocument) {
/*  83 */     generateIds(paramDocument, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateIds(Document paramDocument, final AnchorRefTargetBlockPreVisitor preVisitor) {
/*  88 */     this.headerBaseIds.clear();
/*     */     
/*  90 */     this.resolveDupes = ((Boolean)HtmlRenderer.HEADER_ID_GENERATOR_RESOLVE_DUPES.get((DataHolder)paramDocument)).booleanValue();
/*  91 */     this.toDashChars = (String)HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS.get((DataHolder)paramDocument);
/*  92 */     this.nonDashChars = (String)HtmlRenderer.HEADER_ID_GENERATOR_NON_DASH_CHARS.get((DataHolder)paramDocument);
/*  93 */     this.noDupedDashes = ((Boolean)HtmlRenderer.HEADER_ID_GENERATOR_NO_DUPED_DASHES.get((DataHolder)paramDocument)).booleanValue();
/*  94 */     this.nonAsciiToLowercase = ((Boolean)HtmlRenderer.HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE.get((DataHolder)paramDocument)).booleanValue();
/*     */     
/*  96 */     (new AnchorRefTargetBlockVisitor()
/*     */       {
/*     */         protected boolean preVisit(Node param1Node) {
/*  99 */           return (preVisitor == null || preVisitor.preVisit(param1Node, this));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void visit(AnchorRefTarget param1AnchorRefTarget) {
/* 105 */           String str = param1AnchorRefTarget.getAnchorRefText();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 110 */           if (param1AnchorRefTarget.getAnchorRefId().isEmpty() && (str = HeaderIdGenerator.this.generateId(str)) != null) {
/* 111 */             param1AnchorRefTarget.setAnchorRefId(str);
/*     */           
/*     */           }
/*     */         }
/* 115 */       }).visit((Node)paramDocument);
/*     */   }
/*     */   
/*     */   String generateId(String paramString) {
/* 119 */     if (!paramString.isEmpty()) {
/* 120 */       paramString = generateId(paramString, this.toDashChars, this.nonDashChars, this.noDupedDashes, this.nonAsciiToLowercase);
/*     */       
/* 122 */       if (this.resolveDupes) {
/* 123 */         if (this.headerBaseIds.containsKey(paramString)) {
/* 124 */           int i = ((Integer)this.headerBaseIds.get(paramString)).intValue();
/*     */           
/* 126 */           i++;
/* 127 */           this.headerBaseIds.put(paramString, Integer.valueOf(i));
/* 128 */           paramString = paramString + "-" + i;
/*     */         } else {
/* 130 */           this.headerBaseIds.put(paramString, Integer.valueOf(0));
/*     */         } 
/*     */       }
/*     */       
/* 134 */       return paramString;
/*     */     } 
/* 136 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId(Node paramNode) {
/* 142 */     return (paramNode instanceof AnchorRefTarget) ? ((AnchorRefTarget)paramNode).getAnchorRefId() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId(CharSequence paramCharSequence) {
/* 148 */     return generateId(paramCharSequence.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public static String generateId(CharSequence paramCharSequence, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 153 */     return generateId(paramCharSequence, paramString, null, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String generateId(CharSequence paramCharSequence, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
/* 158 */     int i = paramCharSequence.length();
/* 159 */     StringBuilder stringBuilder = new StringBuilder(i);
/* 160 */     if (paramString1 == null) paramString1 = (String)HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS.get(null); 
/* 161 */     if (paramString2 == null) paramString2 = (String)HtmlRenderer.HEADER_ID_GENERATOR_NON_DASH_CHARS.get(null);
/*     */     
/* 163 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/* 165 */       if (isAlphabetic(c = paramCharSequence.charAt(b)))
/* 166 */       { if (!paramBoolean2 && (c < 'A' || c > 'Z')) {
/* 167 */           stringBuilder.append(c);
/*     */         } else {
/* 169 */           stringBuilder.append(Character.toLowerCase(c));
/*     */         }  }
/* 171 */       else if (Character.isDigit(c)) { stringBuilder.append(c); }
/* 172 */       else if (paramString2.indexOf(c) != -1) { stringBuilder.append(c); }
/* 173 */       else if (paramString1.indexOf(c) != -1 && (!paramBoolean1 || (c == '-' && stringBuilder
/* 174 */         .length() == 0) || (stringBuilder
/* 175 */         .length() != 0 && stringBuilder.charAt(stringBuilder.length() - 1) != '-')))
/* 176 */       { stringBuilder.append('-'); }
/*     */     
/* 178 */     }  return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static boolean isAlphabetic(char paramChar) {
/* 182 */     if ((1086 >> 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 187 */       Character.getType(paramChar) & 0x1) != 0) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements HeaderIdGeneratorFactory {
/*     */     public HeaderIdGenerator create(LinkResolverContext param1LinkResolverContext) {
/* 194 */       return new HeaderIdGenerator();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public HeaderIdGenerator create() {
/* 200 */       return new HeaderIdGenerator();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\HeaderIdGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */