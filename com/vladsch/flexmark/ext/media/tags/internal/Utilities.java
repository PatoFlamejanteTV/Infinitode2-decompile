/*    */ package com.vladsch.flexmark.ext.media.tags.internal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Utilities
/*    */ {
/*    */   static String resolveAudioType(String paramString) {
/*  9 */     if ((null = paramString.lastIndexOf(".")) == -1) return null;
/*    */ 
/*    */     
/* 12 */     switch (paramString = paramString.substring(null + 1, paramString.length())) {
/*    */       case "opus":
/* 14 */         return "audio/ogg; codecs=opus";
/*    */       case "weba":
/* 16 */         return "audio/webm";
/*    */       case "webm":
/* 18 */         return "audio/webm; codecs=opus";
/*    */       case "ogg":
/* 20 */         return "audio/ogg";
/*    */       case "mp3":
/* 22 */         return "audio/mpeg";
/*    */       case "wav":
/* 24 */         return "audio/wav";
/*    */       case "flac":
/* 26 */         return "audio/flac";
/*    */     } 
/* 28 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static String resolveVideoType(String paramString) {
/* 34 */     if ((null = paramString.lastIndexOf(".")) == -1) return null;
/*    */ 
/*    */     
/* 37 */     switch (paramString = paramString.substring(null + 1, paramString.length())) {
/*    */       case "mp4":
/* 39 */         return "video/mp4";
/*    */       case "webm":
/* 41 */         return "video/webm";
/*    */       case "ogv":
/* 43 */         return "video/ogg";
/*    */       case "3gp":
/* 45 */         return "video/3gp";
/*    */     } 
/* 47 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\media\tags\internal\Utilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */