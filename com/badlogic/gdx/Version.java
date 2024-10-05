/*    */ package com.badlogic.gdx;
/*    */ 
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Version
/*    */ {
/*    */   public static final String VERSION = "1.12.1";
/*    */   public static final int MAJOR;
/*    */   public static final int MINOR;
/*    */   public static final int REVISION;
/*    */   
/*    */   static {
/*    */     try {
/*    */       String[] arrayOfString;
/* 40 */       MAJOR = ((arrayOfString = "1.12.1".split("\\.")).length <= 0) ? 0 : Integer.valueOf(arrayOfString[0]).intValue();
/* 41 */       MINOR = (arrayOfString.length < 2) ? 0 : Integer.valueOf(arrayOfString[1]).intValue();
/* 42 */       REVISION = (arrayOfString.length < 3) ? 0 : Integer.valueOf(arrayOfString[2]).intValue(); return;
/* 43 */     } catch (Throwable throwable) {
/*    */       
/* 45 */       throw new GdxRuntimeException("Invalid version 1.12.1", throwable);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static boolean isHigher(int paramInt1, int paramInt2, int paramInt3) {
/* 50 */     return isHigherEqual(paramInt1, paramInt2, paramInt3 + 1);
/*    */   }
/*    */   
/*    */   public static boolean isHigherEqual(int paramInt1, int paramInt2, int paramInt3) {
/* 54 */     if (MAJOR != paramInt1) return (MAJOR > paramInt1); 
/* 55 */     if (MINOR != paramInt2) return (MINOR > paramInt2); 
/* 56 */     return (REVISION >= paramInt3);
/*    */   }
/*    */   
/*    */   public static boolean isLower(int paramInt1, int paramInt2, int paramInt3) {
/* 60 */     return isLowerEqual(paramInt1, paramInt2, paramInt3 - 1);
/*    */   }
/*    */   
/*    */   public static boolean isLowerEqual(int paramInt1, int paramInt2, int paramInt3) {
/* 64 */     if (MAJOR != paramInt1) return (MAJOR < paramInt1); 
/* 65 */     if (MINOR != paramInt2) return (MINOR < paramInt2); 
/* 66 */     return (REVISION <= paramInt3);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\Version.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */