/*    */ package com.vladsch.flexmark.ext.attributes;
/*    */ 
/*    */ public enum AttributeImplicitName {
/*  4 */   AS_IS,
/*  5 */   IMPLICIT_PREFERRED,
/*  6 */   EXPLICIT_PREFERRED;
/*    */ 
/*    */   
/*    */   public final boolean isNoChange() {
/* 10 */     return (this == AS_IS);
/*    */   }
/*    */   
/*    */   public final boolean isImplicit() {
/* 14 */     return (this == IMPLICIT_PREFERRED);
/*    */   }
/*    */   
/*    */   public final boolean isExplicit() {
/* 18 */     return (this == EXPLICIT_PREFERRED);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\AttributeImplicitName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */