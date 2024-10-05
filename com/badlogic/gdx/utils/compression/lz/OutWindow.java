/*    */ package com.badlogic.gdx.utils.compression.lz;
/*    */ 
/*    */ import java.io.OutputStream;
/*    */ 
/*    */ 
/*    */ public class OutWindow
/*    */ {
/*    */   byte[] _buffer;
/*    */   int _pos;
/* 10 */   int _windowSize = 0;
/*    */   int _streamPos;
/*    */   OutputStream _stream;
/*    */   
/*    */   public void Create(int paramInt) {
/* 15 */     if (this._buffer == null || this._windowSize != paramInt) this._buffer = new byte[paramInt]; 
/* 16 */     this._windowSize = paramInt;
/* 17 */     this._pos = 0;
/* 18 */     this._streamPos = 0;
/*    */   }
/*    */   
/*    */   public void SetStream(OutputStream paramOutputStream) {
/* 22 */     ReleaseStream();
/* 23 */     this._stream = paramOutputStream;
/*    */   }
/*    */   
/*    */   public void ReleaseStream() {
/* 27 */     Flush();
/* 28 */     this._stream = null;
/*    */   }
/*    */   
/*    */   public void Init(boolean paramBoolean) {
/* 32 */     if (!paramBoolean) {
/* 33 */       this._streamPos = 0;
/* 34 */       this._pos = 0;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void Flush() {
/*    */     int i;
/* 40 */     if ((i = this._pos - this._streamPos) == 0)
/* 41 */       return;  this._stream.write(this._buffer, this._streamPos, i);
/* 42 */     if (this._pos >= this._windowSize) this._pos = 0; 
/* 43 */     this._streamPos = this._pos;
/*    */   }
/*    */ 
/*    */   
/*    */   public void CopyBlock(int paramInt1, int paramInt2) {
/* 48 */     if ((paramInt1 = this._pos - paramInt1 - 1) < 0) paramInt1 += this._windowSize; 
/* 49 */     for (; paramInt2 != 0; paramInt2--) {
/* 50 */       if (paramInt1 >= this._windowSize) paramInt1 = 0; 
/* 51 */       this._buffer[this._pos++] = this._buffer[paramInt1++];
/* 52 */       if (this._pos >= this._windowSize) Flush(); 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void PutByte(byte paramByte) {
/* 57 */     this._buffer[this._pos++] = paramByte;
/* 58 */     if (this._pos >= this._windowSize) Flush();
/*    */   
/*    */   }
/*    */   
/*    */   public byte GetByte(int paramInt) {
/* 63 */     if ((paramInt = this._pos - paramInt - 1) < 0) paramInt += this._windowSize; 
/* 64 */     return this._buffer[paramInt];
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\lz\OutWindow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */