/*    */ package com.vladsch.flexmark.html.renderer;
/*    */ 
/*    */ 
/*    */ public class LinkStatus
/*    */ {
/*  6 */   public static final LinkStatus UNKNOWN = new LinkStatus("UNKNOWN");
/*  7 */   public static final LinkStatus VALID = new LinkStatus("VALID");
/*  8 */   public static final LinkStatus INVALID = new LinkStatus("INVALID");
/*  9 */   public static final LinkStatus UNCHECKED = new LinkStatus("UNCHECKED");
/* 10 */   public static final LinkStatus NOT_FOUND = new LinkStatus("NOT_FOUND");
/*    */   
/*    */   private final String myName;
/*    */   
/*    */   public LinkStatus(String paramString) {
/* 15 */     this.myName = paramString;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 19 */     return this.myName;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 24 */     if (this == paramObject) return true; 
/* 25 */     if (!(paramObject instanceof LinkStatus)) return false;
/*    */     
/* 27 */     paramObject = paramObject;
/*    */     
/* 29 */     return this.myName.equals(((LinkStatus)paramObject).myName);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 34 */     return this.myName.hashCode();
/*    */   }
/*    */   
/*    */   public boolean isStatus(CharSequence paramCharSequence) {
/* 38 */     return this.myName.equals((paramCharSequence instanceof String) ? paramCharSequence : String.valueOf(paramCharSequence));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\LinkStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */