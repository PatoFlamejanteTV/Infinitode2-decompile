/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import java.io.OutputStream;
/*    */ 
/*    */ 
/*    */ public class MultiOutputStream
/*    */   extends OutputStream
/*    */ {
/*    */   private OutputStream[] a;
/*    */   
/*    */   public MultiOutputStream(OutputStream... paramVarArgs) {
/* 12 */     this.a = paramVarArgs;
/*    */   }
/*    */   @IgnoreMethodOverloadLuaDefWarning
/*    */   public void write(int paramInt) {
/*    */     OutputStream[] arrayOfOutputStream;
/*    */     int i;
/*    */     byte b;
/* 19 */     for (i = (arrayOfOutputStream = this.a).length, b = 0; b < i; b++) {
/* 20 */       OutputStream outputStream; (outputStream = arrayOfOutputStream[b]).write(paramInt);
/*    */     } 
/*    */   } @IgnoreMethodOverloadLuaDefWarning
/*    */   public void write(byte[] paramArrayOfbyte) {
/*    */     OutputStream[] arrayOfOutputStream;
/*    */     int i;
/*    */     byte b;
/* 27 */     for (i = (arrayOfOutputStream = this.a).length, b = 0; b < i; b++) {
/* 28 */       OutputStream outputStream; (outputStream = arrayOfOutputStream[b]).write(paramArrayOfbyte);
/*    */     } 
/*    */   } @IgnoreMethodOverloadLuaDefWarning
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*    */     OutputStream[] arrayOfOutputStream;
/*    */     int i;
/*    */     byte b;
/* 35 */     for (i = (arrayOfOutputStream = this.a).length, b = 0; b < i; b++) {
/* 36 */       OutputStream outputStream; (outputStream = arrayOfOutputStream[b]).write(paramArrayOfbyte, paramInt1, paramInt2);
/*    */     } 
/*    */   } public void flush() {
/*    */     OutputStream[] arrayOfOutputStream;
/*    */     int i;
/*    */     byte b;
/* 42 */     for (i = (arrayOfOutputStream = this.a).length, b = 0; b < i; b++) {
/* 43 */       OutputStream outputStream; (outputStream = arrayOfOutputStream[b]).flush();
/*    */     } 
/*    */   } public void close() {
/*    */     OutputStream[] arrayOfOutputStream;
/*    */     int i;
/*    */     byte b;
/* 49 */     for (i = (arrayOfOutputStream = this.a).length, b = 0; b < i; b++) {
/* 50 */       OutputStream outputStream; (outputStream = arrayOfOutputStream[b]).close();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\MultiOutputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */