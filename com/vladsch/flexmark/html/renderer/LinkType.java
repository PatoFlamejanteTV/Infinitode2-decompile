/*    */ package com.vladsch.flexmark.html.renderer;
/*    */ 
/*    */ 
/*    */ public class LinkType
/*    */ {
/*  6 */   public static final LinkType LINK = new LinkType("LINK");
/*  7 */   public static final LinkType IMAGE = new LinkType("IMAGE");
/*  8 */   public static final LinkType LINK_REF = new LinkType("LINK_REF");
/*  9 */   public static final LinkType IMAGE_REF = new LinkType("IMAGE_REF");
/*    */   
/*    */   private final String myName;
/*    */   
/*    */   public LinkType(String paramString) {
/* 14 */     this.myName = paramString;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 18 */     return this.myName;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 23 */     return (this == paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 28 */     return super.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\LinkType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */