/*    */ package com.vladsch.flexmark.ext.emoji.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.emoji.Emoji;
/*    */ import com.vladsch.flexmark.ext.emoji.EmojiImageType;
/*    */ import com.vladsch.flexmark.ext.emoji.EmojiShortcutType;
/*    */ 
/*    */ public class EmojiResolvedShortcut {
/*    */   public final EmojiReference.Emoji emoji;
/*    */   public final String emojiText;
/*    */   public final boolean isUnicode;
/*    */   public final String alt;
/*    */   
/*    */   public EmojiResolvedShortcut(EmojiReference.Emoji paramEmoji, String paramString1, boolean paramBoolean, String paramString2) {
/* 14 */     this.emoji = paramEmoji;
/* 15 */     this.emojiText = paramString1;
/* 16 */     this.isUnicode = paramBoolean;
/* 17 */     this.alt = paramString2;
/*    */   }
/*    */   
/*    */   public static EmojiResolvedShortcut getEmojiText(Emoji paramEmoji, EmojiShortcutType paramEmojiShortcutType, EmojiImageType paramEmojiImageType, String paramString) {
/* 21 */     return getEmojiText(paramEmoji.getText().toString(), paramEmojiShortcutType, paramEmojiImageType, paramString);
/*    */   }
/*    */   
/*    */   public static EmojiResolvedShortcut getEmojiText(String paramString1, EmojiShortcutType paramEmojiShortcutType, EmojiImageType paramEmojiImageType, String paramString2) {
/* 25 */     EmojiReference.Emoji emoji = EmojiShortcuts.getEmojiFromShortcut(paramString1);
/* 26 */     String str1 = null;
/* 27 */     boolean bool = false;
/* 28 */     String str2 = null;
/*    */     
/* 30 */     if (emoji != null) {
/* 31 */       String str3 = null;
/* 32 */       String str4 = null;
/* 33 */       if (paramEmojiImageType.isUnicode && emoji.unicodeChars != null) {
/* 34 */         str3 = EmojiShortcuts.getUnicodeChars(emoji);
/*    */       }
/*    */       
/* 37 */       if (paramEmojiImageType.isImage) {
/* 38 */         String str; paramEmojiImageType = null;
/* 39 */         str4 = null;
/* 40 */         if (paramEmojiShortcutType.isGitHub && emoji.githubFile != null) {
/* 41 */           str = "https://github.githubassets.com/images/icons/emoji/" + emoji.githubFile;
/*    */         }
/*    */         
/* 44 */         if (paramEmojiShortcutType.isEmojiCheatSheet && emoji.emojiCheatSheetFile != null) {
/* 45 */           str4 = paramString2 + emoji.emojiCheatSheetFile;
/*    */         }
/*    */         
/* 48 */         str4 = paramEmojiShortcutType.getPreferred(str4, str);
/*    */       } 
/*    */       
/* 51 */       if (str4 != null || str3 != null) {
/* 52 */         if (str3 != null) {
/* 53 */           str1 = str3;
/* 54 */           bool = true;
/*    */         } else {
/* 56 */           str1 = str4;
/*    */         } 
/*    */ 
/*    */         
/* 60 */         str2 = "emoji " + emoji.category + ":" + emoji.shortcut;
/*    */       } 
/*    */     } 
/*    */     
/* 64 */     return new EmojiResolvedShortcut(emoji, str1, bool, str2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\internal\EmojiResolvedShortcut.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */