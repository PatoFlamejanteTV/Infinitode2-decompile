/*    */ package com.vladsch.flexmark.util.format.options;
/*    */ 
/*    */ public enum HeadingStyle
/*    */ {
/*  5 */   AS_IS,
/*  6 */   ATX_PREFERRED,
/*  7 */   SETEXT_PREFERRED;
/*    */ 
/*    */   
/*    */   public final boolean isNoChange() {
/* 11 */     return (this == AS_IS);
/*    */   }
/*    */   
/*    */   public final boolean isNoChange(boolean paramBoolean, int paramInt) {
/* 15 */     return (this == AS_IS || (this == SETEXT_PREFERRED && (paramBoolean || paramInt > 2)) || (this == ATX_PREFERRED && !paramBoolean));
/*    */   }
/*    */   
/*    */   public final boolean isAtx() {
/* 19 */     return (this == ATX_PREFERRED);
/*    */   }
/*    */   
/*    */   public final boolean isSetext() {
/* 23 */     return (this == SETEXT_PREFERRED);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\options\HeadingStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */