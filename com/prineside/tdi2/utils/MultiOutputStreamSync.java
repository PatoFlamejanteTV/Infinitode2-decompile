/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import java.io.OutputStream;
/*    */ 
/*    */ public class MultiOutputStreamSync
/*    */   extends OutputStream
/*    */ {
/*    */   private OutputStream[] a;
/*  9 */   public final Object synchronizer = new Object();
/*    */ 
/*    */   
/*    */   public MultiOutputStreamSync(OutputStream... paramVarArgs) {
/* 13 */     this.a = paramVarArgs;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @IgnoreMethodOverloadLuaDefWarning
/*    */   public void write(int paramInt) {
/* 20 */     synchronized (this.synchronizer) {
/* 21 */       OutputStream[] arrayOfOutputStream; int i; byte b; for (i = (arrayOfOutputStream = this.a).length, b = 0; b < i; b++) {
/* 22 */         OutputStream outputStream; (outputStream = arrayOfOutputStream[b]).write(paramInt);
/*    */       } 
/*    */       return;
/*    */     } 
/*    */   }
/*    */   
/*    */   @IgnoreMethodOverloadLuaDefWarning
/*    */   public void write(byte[] paramArrayOfbyte) {
/* 30 */     synchronized (this.synchronizer) {
/* 31 */       OutputStream[] arrayOfOutputStream; int i; byte b; for (i = (arrayOfOutputStream = this.a).length, b = 0; b < i; b++) {
/* 32 */         OutputStream outputStream; (outputStream = arrayOfOutputStream[b]).write(paramArrayOfbyte);
/*    */       } 
/*    */       return;
/*    */     } 
/*    */   }
/*    */   
/*    */   @IgnoreMethodOverloadLuaDefWarning
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 40 */     synchronized (this.synchronizer) {
/* 41 */       OutputStream[] arrayOfOutputStream; int i; byte b; for (i = (arrayOfOutputStream = this.a).length, b = 0; b < i; b++) {
/* 42 */         OutputStream outputStream; (outputStream = arrayOfOutputStream[b]).write(paramArrayOfbyte, paramInt1, paramInt2);
/*    */       } 
/*    */       return;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void flush() {
/* 49 */     synchronized (this.synchronizer) {
/* 50 */       OutputStream[] arrayOfOutputStream; int i; byte b; for (i = (arrayOfOutputStream = this.a).length, b = 0; b < i; b++) {
/* 51 */         OutputStream outputStream; (outputStream = arrayOfOutputStream[b]).flush();
/*    */       } 
/*    */       return;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void close() {
/* 58 */     synchronized (this.synchronizer) {
/* 59 */       OutputStream[] arrayOfOutputStream; int i; byte b; for (i = (arrayOfOutputStream = this.a).length, b = 0; b < i; b++) {
/* 60 */         OutputStream outputStream; (outputStream = arrayOfOutputStream[b]).close();
/*    */       } 
/*    */       return;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\MultiOutputStreamSync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */