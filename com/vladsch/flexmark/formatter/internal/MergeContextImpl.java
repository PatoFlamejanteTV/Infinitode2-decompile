/*    */ package com.vladsch.flexmark.formatter.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.formatter.MergeContext;
/*    */ import com.vladsch.flexmark.formatter.MergeContextConsumer;
/*    */ import com.vladsch.flexmark.formatter.TranslationContext;
/*    */ import com.vladsch.flexmark.formatter.TranslationHandler;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ public class MergeContextImpl
/*    */   implements MergeContext
/*    */ {
/*    */   private Document[] myDocuments;
/*    */   private TranslationHandler[] myTranslationHandlers;
/*    */   private final HashMap<TranslationContext, Document> myTranslationHandlerDocumentMap;
/*    */   
/*    */   public MergeContextImpl(Document[] paramArrayOfDocument, TranslationHandler[] paramArrayOfTranslationHandler) {
/* 19 */     assert paramArrayOfDocument.length == paramArrayOfTranslationHandler.length;
/*    */     
/* 21 */     this.myDocuments = paramArrayOfDocument;
/* 22 */     this.myTranslationHandlers = paramArrayOfTranslationHandler;
/* 23 */     this.myTranslationHandlerDocumentMap = new HashMap<>();
/* 24 */     updateDocumentMap(); TranslationHandler[] arrayOfTranslationHandler; int i; byte b;
/* 25 */     for (i = (arrayOfTranslationHandler = this.myTranslationHandlers).length, b = 0; b < i; b++) {
/* 26 */       TranslationHandler translationHandler; (translationHandler = arrayOfTranslationHandler[b]).setMergeContext(this);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void updateDocumentMap() {
/* 31 */     int i = this.myDocuments.length;
/* 32 */     for (byte b = 0; b < i; b++) {
/* 33 */       this.myTranslationHandlerDocumentMap.put(this.myTranslationHandlers[b], this.myDocuments[b]);
/*    */     }
/*    */   }
/*    */   
/*    */   public Document[] getDocuments() {
/* 38 */     return this.myDocuments;
/*    */   }
/*    */   
/*    */   public void setDocuments(Document[] paramArrayOfDocument) {
/* 42 */     assert paramArrayOfDocument.length == this.myTranslationHandlers.length;
/*    */     
/* 44 */     this.myDocuments = paramArrayOfDocument;
/* 45 */     updateDocumentMap();
/*    */   }
/*    */   
/*    */   public TranslationHandler[] getTranslationHandlers() {
/* 49 */     return this.myTranslationHandlers;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Document getDocument(TranslationContext paramTranslationContext) {
/* 55 */     return this.myTranslationHandlerDocumentMap.get(paramTranslationContext);
/*    */   }
/*    */ 
/*    */   
/*    */   public void forEachPrecedingDocument(Document paramDocument, MergeContextConsumer paramMergeContextConsumer) {
/* 60 */     int i = this.myDocuments.length;
/* 61 */     for (byte b = 0; b < i && 
/* 62 */       this.myDocuments[b] != paramDocument; b++)
/* 63 */       paramMergeContextConsumer.accept((TranslationContext)this.myTranslationHandlers[b], this.myDocuments[b], b); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\internal\MergeContextImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */