/*    */ package com.vladsch.flexmark.html.renderer;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.util.AnchorRefTargetBlockPreVisitor;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ 
/*    */ 
/*    */ public interface HtmlIdGenerator
/*    */ {
/* 10 */   public static final HtmlIdGenerator NULL = new HtmlIdGenerator()
/*    */     {
/*    */       public final void generateIds(Document param1Document) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public final void generateIds(Document param1Document, AnchorRefTargetBlockPreVisitor param1AnchorRefTargetBlockPreVisitor) {}
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public final String getId(Node param1Node) {
/* 24 */         return null;
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       public final String getId(CharSequence param1CharSequence) {
/* 30 */         return null;
/*    */       }
/*    */     };
/*    */   
/*    */   void generateIds(Document paramDocument);
/*    */   
/*    */   default void generateIds(Document paramDocument, AnchorRefTargetBlockPreVisitor paramAnchorRefTargetBlockPreVisitor) {
/* 37 */     generateIds(paramDocument);
/*    */   }
/*    */   
/*    */   String getId(Node paramNode);
/*    */   
/*    */   String getId(CharSequence paramCharSequence);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\HtmlIdGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */