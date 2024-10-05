/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.StringUtil;
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
/*     */ 
/*     */ 
/*     */ public class DocumentType
/*     */   extends LeafNode
/*     */ {
/*     */   public static final String PUBLIC_KEY = "PUBLIC";
/*     */   public static final String SYSTEM_KEY = "SYSTEM";
/*     */   private static final String NAME = "name";
/*     */   private static final String PUB_SYS_KEY = "pubSysKey";
/*     */   private static final String PUBLIC_ID = "publicId";
/*     */   private static final String SYSTEM_ID = "systemId";
/*     */   
/*     */   public DocumentType(String paramString1, String paramString2, String paramString3) {
/*  29 */     Validate.notNull(paramString1);
/*  30 */     Validate.notNull(paramString2);
/*  31 */     Validate.notNull(paramString3);
/*  32 */     attr("name", paramString1);
/*  33 */     attr("publicId", paramString2);
/*  34 */     attr("systemId", paramString3);
/*  35 */     updatePubSyskey();
/*     */   }
/*     */   
/*     */   public void setPubSysKey(String paramString) {
/*  39 */     if (paramString != null)
/*  40 */       attr("pubSysKey", paramString); 
/*     */   }
/*     */   
/*     */   private void updatePubSyskey() {
/*  44 */     if (has("publicId")) {
/*  45 */       attr("pubSysKey", "PUBLIC"); return;
/*  46 */     }  if (has("systemId")) {
/*  47 */       attr("pubSysKey", "SYSTEM");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String name() {
/*  55 */     return attr("name");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String publicId() {
/*  63 */     return attr("publicId");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String systemId() {
/*  71 */     return attr("systemId");
/*     */   }
/*     */ 
/*     */   
/*     */   public String nodeName() {
/*  76 */     return "#doctype";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void outerHtmlHead(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {
/*  82 */     if (this.siblingIndex > 0 && paramOutputSettings.prettyPrint()) {
/*  83 */       paramAppendable.append('\n');
/*     */     }
/*  85 */     if (paramOutputSettings.syntax() == Document.OutputSettings.Syntax.html && !has("publicId") && !has("systemId")) {
/*     */       
/*  87 */       paramAppendable.append("<!doctype");
/*     */     } else {
/*  89 */       paramAppendable.append("<!DOCTYPE");
/*     */     } 
/*  91 */     if (has("name"))
/*  92 */       paramAppendable.append(" ").append(attr("name")); 
/*  93 */     if (has("pubSysKey"))
/*  94 */       paramAppendable.append(" ").append(attr("pubSysKey")); 
/*  95 */     if (has("publicId"))
/*  96 */       paramAppendable.append(" \"").append(attr("publicId")).append('"'); 
/*  97 */     if (has("systemId"))
/*  98 */       paramAppendable.append(" \"").append(attr("systemId")).append('"'); 
/*  99 */     paramAppendable.append('>');
/*     */   }
/*     */ 
/*     */   
/*     */   void outerHtmlTail(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {}
/*     */ 
/*     */   
/*     */   private boolean has(String paramString) {
/* 107 */     return !StringUtil.isBlank(attr(paramString));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\DocumentType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */