/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.utils.JsonReader;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public class NormalGame
/*    */   extends Game {
/* 13 */   private static final TLog a = TLog.forClass(NormalGame.class);
/*    */   
/*    */   public NormalGame(ActionResolver paramActionResolver, @Null Runnable paramRunnable) {
/* 16 */     super(paramActionResolver, paramRunnable);
/*    */   }
/*    */ 
/*    */   
/*    */   public void create() {
/* 21 */     super.create();
/*    */     
/*    */     FileHandle fileHandle;
/*    */     
/* 25 */     if ((fileHandle = Gdx.files.local("cache/crash-report.json")).exists()) {
/*    */       
/*    */       try {
/* 28 */         String str = fileHandle.readString("UTF-8");
/*    */         JsonValue jsonValue;
/* 30 */         if ((jsonValue = (new JsonReader()).parse(str)) != null) {
/* 31 */           this.screenManager.goToCrashReportScreen(jsonValue
/* 32 */               .getString("type", ""), jsonValue
/* 33 */               .getString("thread", ""), jsonValue
/* 34 */               .getString("message", ""), jsonValue
/* 35 */               .getString("stacktrace", ""));
/*    */         } else {
/*    */           
/* 38 */           throw new IllegalArgumentException("Invalid crash report file: " + str);
/*    */         } 
/* 40 */       } catch (Exception exception) {
/* 41 */         a.e("failed to handle crash report file", new Object[] { exception });
/* 42 */         this.screenManager.goToLoadingScreen(this.gameSyncLoader);
/*    */ 
/*    */         
/*    */         return;
/*    */       } 
/*    */     } else {
/* 48 */       if (!(fileHandle = Gdx.files.local("cache/space.bin")).exists()) {
/*    */         byte[] arrayOfByte;
/* 50 */         Arrays.fill(arrayOfByte = new byte[1024], (byte)-1);
/* 51 */         for (byte b = 0; b < 32; b++) {
/* 52 */           fileHandle.writeBytes(arrayOfByte, true);
/*    */         }
/*    */       } 
/*    */ 
/*    */       
/* 57 */       a.i("set up sync loader, going to loading screen", new Object[0]);
/* 58 */       this.screenManager.goToLoadingScreen(this.gameSyncLoader);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\NormalGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */