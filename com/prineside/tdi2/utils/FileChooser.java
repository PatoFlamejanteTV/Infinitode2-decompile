/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public interface FileChooser {
/*    */   void choose(Configuration paramConfiguration, Callback paramCallback);
/*    */   
/*    */   boolean intentSupported(FileChooseIntent paramFileChooseIntent);
/*    */   
/*    */   public enum FileChooseIntent {
/* 12 */     OPEN,
/* 13 */     SAVE;
/*    */   }
/*    */   
/*    */   public static class Configuration {
/*    */     public FileHandle directory;
/*    */     public String title;
/* 19 */     public FileChooser.FileChooseIntent intent = FileChooser.FileChooseIntent.OPEN;
/*    */     
/*    */     public static Pattern mimePattern(String param1String) {
/* 22 */       return Pattern.compile(param1String.replaceAll("/", "\\\\/").replace("*", ".*"));
/*    */     }
/*    */   }
/*    */   
/*    */   public static interface Callback {
/*    */     void onFileChoose(FileHandle param1FileHandle);
/*    */     
/*    */     void onCancel();
/*    */     
/*    */     void onError(Exception param1Exception);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\FileChooser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */