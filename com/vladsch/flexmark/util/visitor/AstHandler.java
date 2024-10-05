/*    */ package com.vladsch.flexmark.util.visitor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AstHandler<N, A extends AstAction<? super N>>
/*    */ {
/*    */   private final Class<? extends N> aClass;
/*    */   private final A adapter;
/*    */   
/*    */   public AstHandler(Class<? extends N> paramClass, A paramA) {
/* 16 */     this.aClass = paramClass;
/* 17 */     this.adapter = paramA;
/*    */   }
/*    */   
/*    */   public Class<? extends N> getNodeType() {
/* 21 */     return this.aClass;
/*    */   }
/*    */   
/*    */   public A getAdapter() {
/* 25 */     return this.adapter;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 30 */     if (this == paramObject) return true; 
/* 31 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*    */     
/* 33 */     paramObject = paramObject;
/*    */     
/* 35 */     if (this.aClass != ((AstHandler)paramObject).aClass) return false; 
/* 36 */     return (this.adapter == ((AstHandler)paramObject).adapter);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 41 */     int i = this.aClass.hashCode();
/*    */     
/* 43 */     return i = i * 31 + this.adapter.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\visitor\AstHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */