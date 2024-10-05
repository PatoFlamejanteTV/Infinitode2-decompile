/*    */ package com.vladsch.flexmark.ext.emoji.internal;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class EmojiReference
/*    */ {
/*    */   public static final String githubUrl = "https://github.githubassets.com/images/icons/emoji/";
/*    */   
/*    */   public static class Emoji
/*    */   {
/*    */     public final String shortcut;
/*    */     public final String category;
/*    */     public final String emojiCheatSheetFile;
/*    */     
/*    */     public Emoji(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6, String param1String7) {
/* 22 */       this.shortcut = param1String1;
/* 23 */       this.category = param1String2;
/* 24 */       this.emojiCheatSheetFile = param1String3;
/* 25 */       this.githubFile = param1String4;
/* 26 */       this.unicodeChars = param1String5;
/* 27 */       this.unicodeSampleFile = param1String6;
/* 28 */       this.unicodeCldr = param1String7;
/*    */     }
/*    */     public final String githubFile;
/*    */     public final String unicodeChars;
/*    */     public final String unicodeSampleFile;
/*    */     public final String unicodeCldr; }
/* 34 */   private static ArrayList<Emoji> emojiList = null;
/*    */   
/*    */   public static List<Emoji> getEmojiList() {
/* 37 */     if (emojiList == null) {
/*    */       
/* 39 */       emojiList = new ArrayList<>(3000);
/*    */ 
/*    */       
/*    */       InputStream inputStream;
/*    */       
/* 44 */       if ((inputStream = EmojiReference.class.getResourceAsStream("/EmojiReference.txt")) == null) {
/* 45 */         throw new IllegalStateException("Could not load /EmojiReference.txt classpath resource");
/*    */       }
/*    */       
/* 48 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
/*    */ 
/*    */       
/*    */       try {
/* 52 */         bufferedReader.readLine(); String str;
/* 53 */         while ((str = bufferedReader.readLine()) != null) {
/* 54 */           String[] arrayOfString = str.split("\t");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/*    */           try {
/* 64 */             Emoji emoji = new Emoji((arrayOfString[0].charAt(0) == ' ') ? null : arrayOfString[0], (arrayOfString[1].charAt(0) == ' ') ? null : arrayOfString[1], (arrayOfString[2].charAt(0) == ' ') ? null : arrayOfString[2], (arrayOfString[3].charAt(0) == ' ') ? null : arrayOfString[3], (arrayOfString[4].charAt(0) == ' ') ? null : arrayOfString[4], (arrayOfString[5].charAt(0) == ' ') ? null : arrayOfString[5], (arrayOfString[6].charAt(0) == ' ') ? null : arrayOfString[6]);
/*    */             
/* 66 */             emojiList.add(emoji);
/*    */ 
/*    */ 
/*    */ 
/*    */           
/*    */           }
/* 72 */           catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*    */             
/* 74 */             throw new IllegalStateException("Error processing EmojiReference.txt", arrayIndexOutOfBoundsException);
/*    */           } 
/*    */         } 
/* 77 */       } catch (IOException iOException) {
/*    */         
/* 79 */         throw new IllegalStateException("Error processing EmojiReference.txt", iOException);
/*    */       } 
/*    */     } 
/*    */     
/* 83 */     return emojiList;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\internal\EmojiReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */