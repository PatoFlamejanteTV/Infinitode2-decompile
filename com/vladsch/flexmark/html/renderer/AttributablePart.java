/*    */ package com.vladsch.flexmark.html.renderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttributablePart
/*    */ {
/*  9 */   public static final AttributablePart NODE = new AttributablePart("NODE");
/* 10 */   public static final AttributablePart NODE_POSITION = new AttributablePart("NODE_POSITION");
/* 11 */   public static final AttributablePart LINK = new AttributablePart("LINK");
/* 12 */   public static final AttributablePart ID = new AttributablePart("ID");
/*    */   
/*    */   private final String myName;
/*    */   
/*    */   public AttributablePart(String paramString) {
/* 17 */     this.myName = paramString;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 21 */     return this.myName;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 26 */     return (this == paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 31 */     return super.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\AttributablePart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */