/*    */ package com.vladsch.flexmark.ext.emoji.internal;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmojiShortcuts
/*    */ {
/*    */   public static final String gitHubUrlPrefix = "https://github.githubassets.com/images/icons/emoji/";
/* 17 */   private static final HashMap<String, EmojiReference.Emoji> emojiShortcuts = new HashMap<>();
/* 18 */   private static final HashMap<String, EmojiReference.Emoji> emojiURIs = new HashMap<>();
/* 19 */   private static final HashMap<EmojiReference.Emoji, String> emojiUnicodeChars = new HashMap<>();
/*    */   
/*    */   public static synchronized String getUnicodeChars(EmojiReference.Emoji paramEmoji) {
/* 22 */     if (paramEmoji == null || paramEmoji.unicodeChars == null) {
/* 23 */       return null;
/*    */     }
/*    */     
/*    */     String str;
/* 27 */     if ((str = emojiUnicodeChars.get(paramEmoji)) == null) {
/* 28 */       String[] arrayOfString = paramEmoji.unicodeChars.replace("U+", "").split(" ");
/* 29 */       StringBuilder stringBuilder = new StringBuilder(16); int i; byte b;
/* 30 */       for (i = (arrayOfString = arrayOfString).length, b = 0; b < i; ) { String str1 = arrayOfString[b];
/* 31 */         stringBuilder.appendCodePoint(Integer.parseInt(str1, 16)); b++; }
/*    */       
/* 33 */       str = stringBuilder.toString();
/* 34 */       emojiUnicodeChars.put(paramEmoji, str);
/*    */     } 
/* 36 */     return str;
/*    */   }
/*    */ 
/*    */   
/*    */   public static String extractFileName(String paramString) {
/*    */     int i;
/* 42 */     if ((i = (paramString = (new File(paramString)).getName()).indexOf(".png")) >= 0) {
/* 43 */       paramString = paramString.substring(0, i);
/*    */     }
/* 45 */     return paramString;
/*    */   }
/*    */   
/*    */   public static HashMap<String, EmojiReference.Emoji> getEmojiShortcuts() {
/* 49 */     updateEmojiShortcuts();
/* 50 */     return emojiShortcuts;
/*    */   }
/*    */   
/*    */   public static HashMap<String, EmojiReference.Emoji> getEmojiURIs() {
/* 54 */     updateEmojiShortcuts();
/* 55 */     return emojiURIs;
/*    */   }
/*    */   
/*    */   public static EmojiReference.Emoji getEmojiFromShortcut(String paramString) {
/* 59 */     updateEmojiShortcuts();
/* 60 */     return emojiShortcuts.get(paramString);
/*    */   }
/*    */   
/*    */   public static EmojiReference.Emoji getEmojiFromURI(String paramString) {
/* 64 */     updateEmojiURIs();
/* 65 */     return emojiURIs.get(extractFileName(paramString));
/*    */   }
/*    */   
/*    */   private static synchronized void updateEmojiShortcuts() {
/* 69 */     if (emojiShortcuts.isEmpty()) {
/* 70 */       for (Iterator<EmojiReference.Emoji> iterator = EmojiReference.getEmojiList().iterator(); iterator.hasNext();) {
/* 71 */         if ((emoji = iterator.next()).shortcut != null) {
/* 72 */           emojiShortcuts.put(emoji.shortcut, emoji);
/*    */         }
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   private static synchronized void updateEmojiURIs() {
/* 79 */     if (emojiURIs.isEmpty())
/*    */     {
/* 81 */       for (Iterator<EmojiReference.Emoji> iterator = EmojiReference.getEmojiList().iterator(); iterator.hasNext(); ) {
/* 82 */         EmojiReference.Emoji emoji; if ((emoji = iterator.next()).emojiCheatSheetFile != null) {
/* 83 */           emojiURIs.put(extractFileName(emoji.emojiCheatSheetFile), emoji);
/*    */         }
/* 85 */         if (emoji.githubFile != null) {
/* 86 */           emojiURIs.put(extractFileName(emoji.githubFile), emoji);
/*    */         }
/* 88 */         if (emoji.unicodeSampleFile != null)
/* 89 */           emojiURIs.put(extractFileName(emoji.unicodeSampleFile), emoji); 
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\internal\EmojiShortcuts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */