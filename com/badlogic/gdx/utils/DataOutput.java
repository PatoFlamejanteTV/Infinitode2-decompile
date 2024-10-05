/*    */ package com.badlogic.gdx.utils;
/*    */ 
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.OutputStream;
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
/*    */ public class DataOutput
/*    */   extends DataOutputStream
/*    */ {
/*    */   public DataOutput(OutputStream paramOutputStream) {
/* 27 */     super(paramOutputStream);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int writeInt(int paramInt, boolean paramBoolean) {
/* 34 */     if (!paramBoolean) paramInt = paramInt << 1 ^ paramInt >> 31; 
/* 35 */     if (paramInt >>> 7 == 0) {
/* 36 */       write((byte)paramInt);
/* 37 */       return 1;
/*    */     } 
/* 39 */     write((byte)(paramInt & 0x7F | 0x80));
/* 40 */     if (paramInt >>> 14 == 0) {
/* 41 */       write((byte)(paramInt >>> 7));
/* 42 */       return 2;
/*    */     } 
/* 44 */     write((byte)(paramInt >>> 7 | 0x80));
/* 45 */     if (paramInt >>> 21 == 0) {
/* 46 */       write((byte)(paramInt >>> 14));
/* 47 */       return 3;
/*    */     } 
/* 49 */     write((byte)(paramInt >>> 14 | 0x80));
/* 50 */     if (paramInt >>> 28 == 0) {
/* 51 */       write((byte)(paramInt >>> 21));
/* 52 */       return 4;
/*    */     } 
/* 54 */     write((byte)(paramInt >>> 21 | 0x80));
/* 55 */     write((byte)(paramInt >>> 28));
/* 56 */     return 5;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void writeString(@Null String paramString) {
/* 62 */     if (paramString == null) {
/* 63 */       write(0);
/*    */       return;
/*    */     } 
/*    */     int i;
/* 67 */     if ((i = paramString.length()) == 0) {
/* 68 */       writeByte(1);
/*    */       return;
/*    */     } 
/* 71 */     writeInt(i + 1, true);
/*    */     
/* 73 */     byte b = 0; char c;
/* 74 */     for (; b < i && (
/*    */       
/* 76 */       c = paramString.charAt(b)) <= ''; b++) {
/* 77 */       write((byte)c);
/*    */     }
/* 79 */     if (b < i) writeString_slow(paramString, i, b); 
/*    */   }
/*    */   
/*    */   private void writeString_slow(String paramString, int paramInt1, int paramInt2) {
/* 83 */     for (; paramInt2 < paramInt1; paramInt2++) {
/*    */       char c;
/* 85 */       if ((c = paramString.charAt(paramInt2)) <= '') {
/* 86 */         write((byte)c);
/* 87 */       } else if (c > '߿') {
/* 88 */         write((byte)(0xE0 | c >> 12 & 0xF));
/* 89 */         write((byte)(0x80 | c >> 6 & 0x3F));
/* 90 */         write((byte)(0x80 | c & 0x3F));
/*    */       } else {
/* 92 */         write((byte)(0xC0 | c >> 6 & 0x1F));
/* 93 */         write((byte)(0x80 | c & 0x3F));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\DataOutput.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */