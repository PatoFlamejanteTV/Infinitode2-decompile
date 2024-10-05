/*    */ package com.vladsch.flexmark.ext.emoji;
/*    */ 
/*    */ public enum EmojiShortcutType {
/*  4 */   EMOJI_CHEAT_SHEET(true, false),
/*  5 */   GITHUB(false, true),
/*  6 */   ANY_EMOJI_CHEAT_SHEET_PREFERRED(true, true),
/*  7 */   ANY_GITHUB_PREFERRED(true, true);
/*    */   
/*    */   public final boolean isEmojiCheatSheet;
/*    */   
/*    */   public final boolean isGitHub;
/*    */   
/*    */   EmojiShortcutType(boolean paramBoolean1, boolean paramBoolean2) {
/* 14 */     this.isEmojiCheatSheet = paramBoolean1;
/* 15 */     this.isGitHub = paramBoolean2;
/*    */   }
/*    */   
/*    */   public final String getPreferred(String paramString1, String paramString2) {
/* 19 */     switch (this) {
/*    */       case EMOJI_CHEAT_SHEET:
/* 21 */         return paramString1;
/*    */       case GITHUB:
/* 23 */         return paramString2;
/*    */       case ANY_EMOJI_CHEAT_SHEET_PREFERRED:
/* 25 */         return (paramString1 != null) ? paramString1 : paramString2;
/*    */       case ANY_GITHUB_PREFERRED:
/* 27 */         return (paramString2 != null) ? paramString2 : paramString1;
/*    */     } 
/* 29 */     assert false : "Missing Case Statement";
/* 30 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\EmojiShortcutType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */