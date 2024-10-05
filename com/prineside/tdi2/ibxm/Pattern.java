/*    */ package com.prineside.tdi2.ibxm;
/*    */ 
/*    */ public class Pattern {
/*    */   public int numRows;
/*    */   public byte[] data;
/*    */   
/*    */   public Pattern(Pattern paramPattern) {
/*  8 */     this.numRows = paramPattern.numRows;
/*  9 */     this.data = new byte[paramPattern.data.length];
/* 10 */     System.arraycopy(paramPattern.data, 0, this.data, 0, this.data.length);
/*    */   }
/*    */   
/*    */   public Pattern(int paramInt1, int paramInt2) {
/* 14 */     this.numRows = paramInt2;
/* 15 */     this.data = new byte[paramInt1 * paramInt2 * 5];
/*    */   }
/*    */   
/*    */   public Note getNote(int paramInt, Note paramNote) {
/* 19 */     paramInt *= 5;
/* 20 */     paramNote.key = this.data[paramInt] & 0xFF;
/* 21 */     paramNote.instrument = this.data[paramInt + 1] & 0xFF;
/* 22 */     paramNote.volume = this.data[paramInt + 2] & 0xFF;
/* 23 */     paramNote.effect = this.data[paramInt + 3] & 0xFF;
/* 24 */     paramNote.param = this.data[paramInt + 4] & 0xFF;
/* 25 */     return paramNote;
/*    */   }
/*    */   
/*    */   public void toStringBuffer(StringBuffer paramStringBuffer) {
/* 29 */     Note note = new Note();
/* 30 */     char[] arrayOfChar = new char[10];
/* 31 */     int i = this.data.length / this.numRows * 5;
/* 32 */     for (byte b = 0; b < this.numRows; b++) {
/* 33 */       for (byte b1 = 0; b1 < i; b1++) {
/* 34 */         getNote(i * b + b1, note);
/* 35 */         note.toChars(arrayOfChar);
/* 36 */         paramStringBuffer.append(arrayOfChar);
/* 37 */         paramStringBuffer.append(' ');
/*    */       } 
/* 39 */       paramStringBuffer.append('\n');
/*    */     } 
/*    */   }
/*    */   
/*    */   public String toString() {
/* 44 */     int i = this.data.length / this.numRows * 5;
/* 45 */     StringBuffer stringBuffer = new StringBuffer(this.numRows * i * 11 + this.numRows);
/* 46 */     toStringBuffer(stringBuffer);
/* 47 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ibxm\Pattern.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */