/*    */ package com.vladsch.flexmark.util.html.ui;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class HtmlStylerBase<T>
/*    */   implements HtmlStyler<T>
/*    */ {
/*    */   public T getStyleable(Object paramObject) {
/* 26 */     return (T)paramObject;
/*    */   }
/*    */   
/*    */   public abstract String getStyle(T paramT);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\htm\\ui\HtmlStylerBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */