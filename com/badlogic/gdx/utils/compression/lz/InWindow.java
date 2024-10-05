/*     */ package com.badlogic.gdx.utils.compression.lz;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InWindow
/*     */ {
/*     */   public byte[] _bufferBase;
/*     */   InputStream _stream;
/*     */   int _posLimit;
/*     */   boolean _streamEndWasReached;
/*     */   int _pointerToLastSafePosition;
/*     */   public int _bufferOffset;
/*     */   public int _blockSize;
/*     */   public int _pos;
/*     */   int _keepSizeBefore;
/*     */   int _keepSizeAfter;
/*     */   public int _streamPos;
/*     */   
/*     */   public void MoveBlock() {
/*     */     int i;
/*  26 */     if ((i = this._bufferOffset + this._pos - this._keepSizeBefore) > 0) i--;
/*     */     
/*  28 */     int j = this._bufferOffset + this._streamPos - i;
/*     */ 
/*     */     
/*  31 */     for (byte b = 0; b < j; b++)
/*  32 */       this._bufferBase[b] = this._bufferBase[i + b]; 
/*  33 */     this._bufferOffset -= i;
/*     */   }
/*     */   
/*     */   public void ReadBlock() {
/*  37 */     if (this._streamEndWasReached)
/*     */       return;  while (true) {
/*     */       int i;
/*  40 */       if ((i = 0 - this._bufferOffset + this._blockSize - this._streamPos) == 0)
/*     */         return; 
/*  42 */       if ((i = this._stream.read(this._bufferBase, this._bufferOffset + this._streamPos, i)) == -1) {
/*  43 */         this._posLimit = this._streamPos;
/*     */         
/*  45 */         if ((i = this._bufferOffset + this._posLimit) > this._pointerToLastSafePosition) this._posLimit = this._pointerToLastSafePosition - this._bufferOffset;
/*     */         
/*  47 */         this._streamEndWasReached = true;
/*     */         return;
/*     */       } 
/*  50 */       this._streamPos += i;
/*  51 */       if (this._streamPos >= this._pos + this._keepSizeAfter) this._posLimit = this._streamPos - this._keepSizeAfter; 
/*     */     } 
/*     */   }
/*     */   
/*     */   void Free() {
/*  56 */     this._bufferBase = null;
/*     */   }
/*     */   
/*     */   public void Create(int paramInt1, int paramInt2, int paramInt3) {
/*  60 */     this._keepSizeBefore = paramInt1;
/*  61 */     this._keepSizeAfter = paramInt2;
/*  62 */     paramInt1 = paramInt1 + paramInt2 + paramInt3;
/*  63 */     if (this._bufferBase == null || this._blockSize != paramInt1) {
/*  64 */       Free();
/*  65 */       this._blockSize = paramInt1;
/*  66 */       this._bufferBase = new byte[this._blockSize];
/*     */     } 
/*  68 */     this._pointerToLastSafePosition = this._blockSize - paramInt2;
/*     */   }
/*     */   
/*     */   public void SetStream(InputStream paramInputStream) {
/*  72 */     this._stream = paramInputStream;
/*     */   }
/*     */   
/*     */   public void ReleaseStream() {
/*  76 */     this._stream = null;
/*     */   }
/*     */   
/*     */   public void Init() {
/*  80 */     this._bufferOffset = 0;
/*  81 */     this._pos = 0;
/*  82 */     this._streamPos = 0;
/*  83 */     this._streamEndWasReached = false;
/*  84 */     ReadBlock();
/*     */   }
/*     */   
/*     */   public void MovePos() {
/*  88 */     this._pos++;
/*  89 */     if (this._pos > this._posLimit) {
/*     */       int i;
/*  91 */       if ((i = this._bufferOffset + this._pos) > this._pointerToLastSafePosition) MoveBlock(); 
/*  92 */       ReadBlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   public byte GetIndexByte(int paramInt) {
/*  97 */     return this._bufferBase[this._bufferOffset + this._pos + paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public int GetMatchLen(int paramInt1, int paramInt2, int paramInt3) {
/* 102 */     if (this._streamEndWasReached && this._pos + paramInt1 + paramInt3 > this._streamPos) paramInt3 = this._streamPos - this._pos + paramInt1; 
/* 103 */     paramInt2++;
/*     */     
/* 105 */     paramInt1 = this._bufferOffset + this._pos + paramInt1;
/*     */     
/*     */     byte b;
/* 108 */     for (b = 0; b < paramInt3 && this._bufferBase[paramInt1 + b] == this._bufferBase[paramInt1 + b - paramInt2]; b++);
/*     */     
/* 110 */     return b;
/*     */   }
/*     */   
/*     */   public int GetNumAvailableBytes() {
/* 114 */     return this._streamPos - this._pos;
/*     */   }
/*     */   
/*     */   public void ReduceOffsets(int paramInt) {
/* 118 */     this._bufferOffset += paramInt;
/* 119 */     this._posLimit -= paramInt;
/* 120 */     this._pos -= paramInt;
/* 121 */     this._streamPos -= paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\lz\InWindow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */