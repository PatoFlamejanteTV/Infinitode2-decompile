/*    */ package com.vladsch.flexmark.ext.emoji;
/*    */ 
/*    */ public enum EmojiImageType {
/*  4 */   IMAGE_ONLY(false, true),
/*  5 */   UNICODE_FALLBACK_TO_IMAGE(true, true),
/*  6 */   UNICODE_ONLY(true, false);
/*    */   
/*    */   public final boolean isUnicode;
/*    */   
/*    */   public final boolean isImage;
/*    */   
/*    */   EmojiImageType(boolean paramBoolean1, boolean paramBoolean2) {
/* 13 */     this.isUnicode = paramBoolean1;
/* 14 */     this.isImage = paramBoolean2;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\EmojiImageType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */