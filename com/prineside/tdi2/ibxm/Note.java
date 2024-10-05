/*    */ package com.prineside.tdi2.ibxm;
/*    */ 
/*    */ 
/*    */ public class Note
/*    */ {
/*    */   public int key;
/*    */   public int instrument;
/*    */   
/*    */   public String toString() {
/* 10 */     return new String(toChars(new char[10]));
/*    */   }
/*    */   public int volume; public int effect; public int param;
/*    */   public char[] toChars(char[] paramArrayOfchar) {
/* 14 */     a(this.key, paramArrayOfchar);
/* 15 */     paramArrayOfchar[3] = (this.instrument > 15 && this.instrument < 255) ? "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.instrument >> 4 & 0xF) : '-';
/* 16 */     paramArrayOfchar[4] = (this.instrument > 0 && this.instrument < 255) ? "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.instrument & 0xF) : '-';
/* 17 */     paramArrayOfchar[5] = (this.volume > 15 && this.volume < 255) ? "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.volume >> 4 & 0xF) : '-';
/* 18 */     paramArrayOfchar[6] = (this.volume > 0 && this.volume < 255) ? "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.volume & 0xF) : '-';
/* 19 */     if ((this.effect > 0 || this.param > 0) && this.effect < 36) {
/* 20 */       paramArrayOfchar[7] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.effect);
/* 21 */     } else if (this.effect > 128 && this.effect < 159) {
/* 22 */       paramArrayOfchar[7] = (char)(96 + (this.effect & 0x1F));
/*    */     } else {
/* 24 */       paramArrayOfchar[7] = '-';
/*    */     } 
/* 26 */     paramArrayOfchar[8] = (this.effect > 0 || this.param > 0) ? "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.param >> 4 & 0xF) : '-';
/* 27 */     paramArrayOfchar[9] = (this.effect > 0 || this.param > 0) ? "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.param & 0xF) : '-';
/* 28 */     return paramArrayOfchar;
/*    */   }
/*    */   
/*    */   private static void a(int paramInt, char[] paramArrayOfchar) {
/* 32 */     paramArrayOfchar[0] = (paramInt > 0 && paramInt < 118) ? "A-A#B-C-C#D-D#E-F-F#G-G#".charAt((paramInt + 2) % 12 << 1) : '-';
/* 33 */     paramArrayOfchar[1] = (paramInt > 0 && paramInt < 118) ? "A-A#B-C-C#D-D#E-F-F#G-G#".charAt(((paramInt + 2) % 12 << 1) + 1) : '-';
/* 34 */     paramArrayOfchar[2] = (paramInt > 0 && paramInt < 118) ? (char)(48 + (paramInt + 2) / 12) : '-';
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ibxm\Note.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */