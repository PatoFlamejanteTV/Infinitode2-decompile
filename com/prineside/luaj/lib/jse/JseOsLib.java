/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.prineside.luaj.lib.OsLib;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class JseOsLib
/*     */   extends OsLib
/*     */ {
/*     */   public static final int EXEC_IOEXCEPTION = 1;
/*     */   public static final int EXEC_INTERRUPTED = -2;
/*     */   public static final int EXEC_ERROR = -3;
/*     */   
/*     */   protected final String c(String paramString) {
/*     */     String str;
/*  89 */     return ((str = System.getenv(paramString)) != null) ? str : System.getProperty(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void f() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void g() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String i() {
/*     */     try {
/*     */       File file;
/* 127 */       return (file = File.createTempFile(".luaj", "tmp")).getAbsolutePath();
/* 128 */     } catch (IOException iOException) {
/* 129 */       return super.i();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JseOsLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */