/*      */ package com.badlogic.gdx.utils.compression.lzma;
/*      */ 
/*      */ import com.badlogic.gdx.utils.compression.ICodeProgress;
/*      */ import com.badlogic.gdx.utils.compression.lz.BinTree;
/*      */ import com.badlogic.gdx.utils.compression.rangecoder.BitTreeEncoder;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Encoder
/*      */ {
/*      */   public static final int EMatchFinderTypeBT2 = 0;
/*      */   public static final int EMatchFinderTypeBT4 = 1;
/*      */   static final int kIfinityPrice = 268435455;
/*   30 */   static byte[] g_FastPos = new byte[2048];
/*      */ 
/*      */   
/*      */   static {
/*   34 */     byte b1 = 2;
/*   35 */     g_FastPos[0] = 0;
/*   36 */     g_FastPos[1] = 1;
/*   37 */     for (byte b2 = 2; b2 < 22; b2++) {
/*   38 */       int i = 1 << (b2 >> 1) - 1;
/*   39 */       for (byte b = 0; b < i; b++, b1++)
/*   40 */         g_FastPos[b1] = (byte)b2; 
/*      */     } 
/*      */   }
/*      */   
/*      */   static int GetPosSlot(int paramInt) {
/*   45 */     if (paramInt < 2048) return g_FastPos[paramInt]; 
/*   46 */     if (paramInt < 2097152) return g_FastPos[paramInt >> 10] + 20; 
/*   47 */     return g_FastPos[paramInt >> 20] + 40;
/*      */   }
/*      */   
/*      */   static int GetPosSlot2(int paramInt) {
/*   51 */     if (paramInt < 131072) return g_FastPos[paramInt >> 6] + 12; 
/*   52 */     if (paramInt < 134217728) return g_FastPos[paramInt >> 16] + 32; 
/*   53 */     return g_FastPos[paramInt >> 26] + 52;
/*      */   }
/*      */   
/*   56 */   int _state = Base.StateInit();
/*      */   byte _previousByte;
/*   58 */   int[] _repDistances = new int[4]; static final int kDefaultDictionaryLogSize = 22; static final int kNumFastBytesDefault = 32; public static final int kNumLenSpecSymbols = 16; static final int kNumOpts = 4096;
/*      */   
/*      */   void BaseInit() {
/*   61 */     this._state = Base.StateInit();
/*   62 */     this._previousByte = 0;
/*   63 */     for (byte b = 0; b < 4; b++)
/*   64 */       this._repDistances[b] = 0; 
/*      */   }
/*      */   
/*      */   class LiteralEncoder { Encoder2[] m_Coders;
/*      */     int m_NumPrevBits;
/*      */     int m_NumPosBits;
/*      */     int m_PosMask;
/*      */     
/*   72 */     class Encoder2 { short[] m_Encoders = new short[768];
/*      */       
/*      */       public void Init() {
/*   75 */         com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this.m_Encoders);
/*      */       }
/*      */       
/*      */       public void Encode(com.badlogic.gdx.utils.compression.rangecoder.Encoder param2Encoder, byte param2Byte) {
/*   79 */         int i = 1;
/*   80 */         for (byte b = 7; b >= 0; b--) {
/*   81 */           int j = param2Byte >> b & 0x1;
/*   82 */           param2Encoder.Encode(this.m_Encoders, i, j);
/*   83 */           i = i << 1 | j;
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public void EncodeMatched(com.badlogic.gdx.utils.compression.rangecoder.Encoder param2Encoder, byte param2Byte1, byte param2Byte2) {
/*   89 */         int i = 1;
/*   90 */         int j = 1;
/*   91 */         for (byte b = 7; b >= 0; b--) {
/*   92 */           int k = param2Byte2 >> b & 0x1;
/*   93 */           int m = i;
/*   94 */           if (j) {
/*   95 */             j = param2Byte1 >> b & 0x1;
/*   96 */             m += j + 1 << 8;
/*   97 */             j = (j == k) ? 1 : 0;
/*      */           } 
/*   99 */           param2Encoder.Encode(this.m_Encoders, m, k);
/*  100 */           i = i << 1 | k;
/*      */         } 
/*      */       }
/*      */       
/*      */       public int GetPrice(boolean param2Boolean, byte param2Byte1, byte param2Byte2) {
/*  105 */         int i = 0;
/*  106 */         int j = 1;
/*  107 */         byte b = 7;
/*  108 */         if (param2Boolean) {
/*  109 */           for (; b >= 0; b--) {
/*  110 */             int k = param2Byte1 >> b & 0x1;
/*  111 */             int m = param2Byte2 >> b & 0x1;
/*  112 */             i += 
/*  113 */               com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice(this.m_Encoders[(k + 1 << 8) + j], m);
/*  114 */             j = j << 1 | m;
/*  115 */             if (k != m) {
/*  116 */               b--;
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/*  121 */         for (; b >= 0; b--) {
/*  122 */           int k = param2Byte2 >> b & 0x1;
/*  123 */           i += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice(this.m_Encoders[j], k);
/*  124 */           j = j << 1 | k;
/*      */         } 
/*  126 */         return i;
/*      */       } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void Create(int param1Int1, int param1Int2) {
/*  136 */       if (this.m_Coders != null && this.m_NumPrevBits == param1Int2 && this.m_NumPosBits == param1Int1)
/*  137 */         return;  this.m_NumPosBits = param1Int1;
/*  138 */       this.m_PosMask = (1 << param1Int1) - 1;
/*  139 */       this.m_NumPrevBits = param1Int2;
/*  140 */       param1Int1 = 1 << this.m_NumPrevBits + this.m_NumPosBits;
/*  141 */       this.m_Coders = new Encoder2[param1Int1];
/*  142 */       for (param1Int2 = 0; param1Int2 < param1Int1; param1Int2++)
/*  143 */         this.m_Coders[param1Int2] = new Encoder2(); 
/*      */     }
/*      */     
/*      */     public void Init() {
/*  147 */       int i = 1 << this.m_NumPrevBits + this.m_NumPosBits;
/*  148 */       for (byte b = 0; b < i; b++)
/*  149 */         this.m_Coders[b].Init(); 
/*      */     }
/*      */     
/*      */     public Encoder2 GetSubCoder(int param1Int, byte param1Byte) {
/*  153 */       return this.m_Coders[((param1Int & this.m_PosMask) << this.m_NumPrevBits) + ((param1Byte & 0xFF) >>> 8 - this.m_NumPrevBits)];
/*      */     } }
/*      */    class Encoder2 { short[] m_Encoders = new short[768]; public void Init() { com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this.m_Encoders); } public void Encode(com.badlogic.gdx.utils.compression.rangecoder.Encoder param1Encoder, byte param1Byte) { int i = 1; for (byte b = 7; b >= 0; b--) { int j = param1Byte >> b & 0x1; param1Encoder.Encode(this.m_Encoders, i, j); i = i << 1 | j; }  }
/*      */     public void EncodeMatched(com.badlogic.gdx.utils.compression.rangecoder.Encoder param1Encoder, byte param1Byte1, byte param1Byte2) { int i = 1; int j = 1; for (byte b = 7; b >= 0; b--) { int k = param1Byte2 >> b & 0x1; int m = i; if (j) { j = param1Byte1 >> b & 0x1; m += j + 1 << 8; j = (j == k) ? 1 : 0; }  param1Encoder.Encode(this.m_Encoders, m, k); i = i << 1 | k; }  }
/*      */     public int GetPrice(boolean param1Boolean, byte param1Byte1, byte param1Byte2) { int i = 0; int j = 1; byte b = 7; if (param1Boolean) for (; b >= 0; b--) { int k = param1Byte1 >> b & 0x1; int m = param1Byte2 >> b & 0x1; i += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice(this.m_Encoders[(k + 1 << 8) + j], m); j = j << 1 | m; if (k != m) { b--; break; }  }   for (; b >= 0; b--) { int k = param1Byte2 >> b & 0x1; i += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice(this.m_Encoders[j], k); j = j << 1 | k; }  return i; } }
/*  158 */   class LenEncoder { short[] _choice = new short[2];
/*  159 */     BitTreeEncoder[] _lowCoder = new BitTreeEncoder[16];
/*  160 */     BitTreeEncoder[] _midCoder = new BitTreeEncoder[16];
/*  161 */     BitTreeEncoder _highCoder = new BitTreeEncoder(8);
/*      */     
/*      */     public LenEncoder() {
/*  164 */       for (byte b = 0; b < 16; b++) {
/*  165 */         this._lowCoder[b] = new BitTreeEncoder(3);
/*  166 */         this._midCoder[b] = new BitTreeEncoder(3);
/*      */       } 
/*      */     }
/*      */     
/*      */     public void Init(int param1Int) {
/*  171 */       com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._choice);
/*      */       
/*  173 */       for (byte b = 0; b < param1Int; b++) {
/*  174 */         this._lowCoder[b].Init();
/*  175 */         this._midCoder[b].Init();
/*      */       } 
/*  177 */       this._highCoder.Init();
/*      */     }
/*      */ 
/*      */     
/*      */     public void Encode(com.badlogic.gdx.utils.compression.rangecoder.Encoder param1Encoder, int param1Int1, int param1Int2) {
/*  182 */       if (param1Int1 < 8) {
/*  183 */         param1Encoder.Encode(this._choice, 0, 0);
/*  184 */         this._lowCoder[param1Int2].Encode(param1Encoder, param1Int1); return;
/*      */       } 
/*  186 */       param1Int1 -= 8;
/*  187 */       param1Encoder.Encode(this._choice, 0, 1);
/*  188 */       if (param1Int1 < 8) {
/*  189 */         param1Encoder.Encode(this._choice, 1, 0);
/*  190 */         this._midCoder[param1Int2].Encode(param1Encoder, param1Int1); return;
/*      */       } 
/*  192 */       param1Encoder.Encode(this._choice, 1, 1);
/*  193 */       this._highCoder.Encode(param1Encoder, param1Int1 - 8);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void SetPrices(int param1Int1, int param1Int2, int[] param1ArrayOfint, int param1Int3) {
/*  199 */       int i = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._choice[0]);
/*      */       
/*  201 */       int j, k = (j = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._choice[0])) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._choice[1]);
/*  202 */       j += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._choice[1]);
/*      */       byte b;
/*  204 */       for (b = 0; b < 8; b++) {
/*  205 */         if (b >= param1Int2)
/*  206 */           return;  param1ArrayOfint[param1Int3 + b] = i + this._lowCoder[param1Int1].GetPrice(b);
/*      */       } 
/*  208 */       for (; b < 16; b++) {
/*  209 */         if (b >= param1Int2)
/*  210 */           return;  param1ArrayOfint[param1Int3 + b] = k + this._midCoder[param1Int1].GetPrice(b - 8);
/*      */       } 
/*  212 */       for (; b < param1Int2; b++)
/*  213 */         param1ArrayOfint[param1Int3 + b] = j + this._highCoder.GetPrice(b - 8 - 8); 
/*      */     } }
/*      */   class LenPriceTableEncoder extends LenEncoder { int[] _prices;
/*      */     int _tableSize;
/*      */     int[] _counters;
/*      */     
/*      */     LenPriceTableEncoder() {
/*  220 */       this._prices = new int[4352];
/*      */       
/*  222 */       this._counters = new int[16];
/*      */     }
/*      */     public void SetTableSize(int param1Int) {
/*  225 */       this._tableSize = param1Int;
/*      */     }
/*      */     
/*      */     public int GetPrice(int param1Int1, int param1Int2) {
/*  229 */       return this._prices[param1Int2 * 272 + param1Int1];
/*      */     }
/*      */     
/*      */     void UpdateTable(int param1Int) {
/*  233 */       SetPrices(param1Int, this._tableSize, this._prices, param1Int * 272);
/*  234 */       this._counters[param1Int] = this._tableSize;
/*      */     }
/*      */     
/*      */     public void UpdateTables(int param1Int) {
/*  238 */       for (byte b = 0; b < param1Int; b++) {
/*  239 */         UpdateTable(b);
/*      */       }
/*      */     }
/*      */     
/*      */     public void Encode(com.badlogic.gdx.utils.compression.rangecoder.Encoder param1Encoder, int param1Int1, int param1Int2) {
/*  244 */       super.Encode(param1Encoder, param1Int1, param1Int2);
/*  245 */       this._counters[param1Int2] = this._counters[param1Int2] - 1; if (this._counters[param1Int2] - 1 == 0) UpdateTable(param1Int2);
/*      */     
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   class Optimal
/*      */   {
/*      */     public int State;
/*      */     
/*      */     public boolean Prev1IsChar;
/*      */     
/*      */     public boolean Prev2;
/*      */     
/*      */     public int PosPrev2;
/*      */     public int BackPrev2;
/*      */     public int Price;
/*      */     public int PosPrev;
/*      */     public int BackPrev;
/*      */     public int Backs0;
/*      */     public int Backs1;
/*      */     public int Backs2;
/*      */     public int Backs3;
/*      */     
/*      */     public void MakeAsChar() {
/*  270 */       this.BackPrev = -1;
/*  271 */       this.Prev1IsChar = false;
/*      */     }
/*      */     
/*      */     public void MakeAsShortRep() {
/*  275 */       this.BackPrev = 0;
/*      */       
/*  277 */       this.Prev1IsChar = false;
/*      */     }
/*      */     
/*      */     public boolean IsShortRep() {
/*  281 */       return (this.BackPrev == 0);
/*      */     }
/*      */   }
/*      */   
/*  285 */   Optimal[] _optimum = new Optimal[4096];
/*  286 */   BinTree _matchFinder = null;
/*  287 */   com.badlogic.gdx.utils.compression.rangecoder.Encoder _rangeEncoder = new com.badlogic.gdx.utils.compression.rangecoder.Encoder();
/*      */   
/*  289 */   short[] _isMatch = new short[192];
/*  290 */   short[] _isRep = new short[12];
/*  291 */   short[] _isRepG0 = new short[12];
/*  292 */   short[] _isRepG1 = new short[12];
/*  293 */   short[] _isRepG2 = new short[12];
/*  294 */   short[] _isRep0Long = new short[192];
/*      */   
/*  296 */   BitTreeEncoder[] _posSlotEncoder = new BitTreeEncoder[4];
/*      */   
/*  298 */   short[] _posEncoders = new short[114];
/*  299 */   BitTreeEncoder _posAlignEncoder = new BitTreeEncoder(4);
/*      */   
/*  301 */   LenPriceTableEncoder _lenEncoder = new LenPriceTableEncoder();
/*  302 */   LenPriceTableEncoder _repMatchLenEncoder = new LenPriceTableEncoder();
/*      */   
/*  304 */   LiteralEncoder _literalEncoder = new LiteralEncoder();
/*      */   
/*  306 */   int[] _matchDistances = new int[548];
/*      */   
/*  308 */   int _numFastBytes = 32;
/*      */   
/*      */   int _longestMatchLength;
/*      */   
/*      */   int _numDistancePairs;
/*      */   
/*      */   int _additionalOffset;
/*      */   
/*      */   int _optimumEndIndex;
/*      */   int _optimumCurrentIndex;
/*      */   boolean _longestMatchWasFound;
/*  319 */   int[] _posSlotPrices = new int[256];
/*  320 */   int[] _distancesPrices = new int[512];
/*  321 */   int[] _alignPrices = new int[16];
/*      */   
/*      */   int _alignPriceCount;
/*  324 */   int _distTableSize = 44;
/*      */   
/*  326 */   int _posStateBits = 2;
/*  327 */   int _posStateMask = 3;
/*  328 */   int _numLiteralPosStateBits = 0;
/*  329 */   int _numLiteralContextBits = 3;
/*      */   
/*  331 */   int _dictionarySize = 4194304;
/*  332 */   int _dictionarySizePrev = -1;
/*  333 */   int _numFastBytesPrev = -1;
/*      */   
/*      */   long nowPos64;
/*      */   
/*      */   boolean _finished;
/*      */   InputStream _inStream;
/*  339 */   int _matchFinderType = 1; boolean _writeEndMark = false; boolean _needReleaseMFStream = false; int[] reps; int[] repLens; int backRes; long[] processedInSize; long[] processedOutSize; boolean[] finished; public static final int kPropSize = 5;
/*      */   byte[] properties;
/*      */   int[] tempPrices;
/*      */   int _matchPriceCount;
/*      */   
/*      */   void Create() {
/*  345 */     if (this._matchFinder == null) {
/*  346 */       BinTree binTree = new BinTree();
/*  347 */       byte b = 4;
/*  348 */       if (this._matchFinderType == 0) b = 2; 
/*  349 */       binTree.SetType(b);
/*  350 */       this._matchFinder = binTree;
/*      */     } 
/*  352 */     this._literalEncoder.Create(this._numLiteralPosStateBits, this._numLiteralContextBits);
/*      */     
/*  354 */     if (this._dictionarySize == this._dictionarySizePrev && this._numFastBytesPrev == this._numFastBytes)
/*  355 */       return;  this._matchFinder.Create(this._dictionarySize, 4096, this._numFastBytes, 274);
/*  356 */     this._dictionarySizePrev = this._dictionarySize;
/*  357 */     this._numFastBytesPrev = this._numFastBytes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void SetWriteEndMarkerMode(boolean paramBoolean) {
/*  368 */     this._writeEndMark = paramBoolean;
/*      */   }
/*      */   
/*      */   void Init() {
/*  372 */     BaseInit();
/*  373 */     this._rangeEncoder.Init();
/*      */     
/*  375 */     com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isMatch);
/*  376 */     com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isRep0Long);
/*  377 */     com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isRep);
/*  378 */     com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isRepG0);
/*  379 */     com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isRepG1);
/*  380 */     com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isRepG2);
/*  381 */     com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._posEncoders);
/*      */     
/*  383 */     this._literalEncoder.Init();
/*  384 */     for (byte b = 0; b < 4; b++) {
/*  385 */       this._posSlotEncoder[b].Init();
/*      */     }
/*  387 */     this._lenEncoder.Init(1 << this._posStateBits);
/*  388 */     this._repMatchLenEncoder.Init(1 << this._posStateBits);
/*      */     
/*  390 */     this._posAlignEncoder.Init();
/*      */     
/*  392 */     this._longestMatchWasFound = false;
/*  393 */     this._optimumEndIndex = 0;
/*  394 */     this._optimumCurrentIndex = 0;
/*  395 */     this._additionalOffset = 0;
/*      */   }
/*      */   
/*      */   int ReadMatchDistances() {
/*  399 */     int i = 0;
/*  400 */     this._numDistancePairs = this._matchFinder.GetMatches(this._matchDistances);
/*  401 */     if (this._numDistancePairs > 0 && (
/*      */       
/*  403 */       i = this._matchDistances[this._numDistancePairs - 2]) == this._numFastBytes) i += this._matchFinder.GetMatchLen(i - 1, this._matchDistances[this._numDistancePairs - 1], 273 - i);
/*      */ 
/*      */     
/*  406 */     this._additionalOffset++;
/*  407 */     return i;
/*      */   }
/*      */   
/*      */   void MovePos(int paramInt) {
/*  411 */     if (paramInt > 0) {
/*  412 */       this._matchFinder.Skip(paramInt);
/*  413 */       this._additionalOffset += paramInt;
/*      */     } 
/*      */   }
/*      */   
/*      */   int GetRepLen1Price(int paramInt1, int paramInt2) {
/*  418 */     return com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRepG0[paramInt1]) + 
/*      */       
/*  420 */       com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRep0Long[(paramInt1 << 4) + paramInt2]);
/*      */   }
/*      */   
/*      */   int GetPureRepPrice(int paramInt1, int paramInt2, int paramInt3) {
/*      */     int i;
/*  425 */     if (paramInt1 == 0) {
/*      */ 
/*      */       
/*  428 */       i = (i = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRepG0[paramInt2])) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep0Long[(paramInt2 << 4) + paramInt3]);
/*      */     } else {
/*  430 */       i = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRepG0[paramInt2]);
/*  431 */       if (paramInt1 == 1) {
/*  432 */         i += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRepG1[paramInt2]);
/*      */       } else {
/*      */         
/*  435 */         i = (i = i + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRepG1[paramInt2])) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice(this._isRepG2[paramInt2], paramInt1 - 2);
/*      */       } 
/*      */     } 
/*  438 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   int GetRepPrice(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  443 */     return (paramInt2 = this._repMatchLenEncoder.GetPrice(paramInt2 - 2, paramInt4)) + GetPureRepPrice(paramInt1, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */   
/*      */   int GetPosLenPrice(int paramInt1, int paramInt2, int paramInt3) {
/*  448 */     int i = Base.GetLenToPosState(paramInt2);
/*  449 */     if (paramInt1 < 128) {
/*  450 */       paramInt1 = this._distancesPrices[(i << 7) + paramInt1];
/*      */     } else {
/*  452 */       paramInt1 = this._posSlotPrices[(i << 6) + GetPosSlot2(paramInt1)] + this._alignPrices[paramInt1 & 0xF];
/*  453 */     }  return paramInt1 + this._lenEncoder.GetPrice(paramInt2 - 2, paramInt3);
/*      */   }
/*      */   
/*      */   int Backward(int paramInt) {
/*  457 */     this._optimumEndIndex = paramInt;
/*  458 */     int i = (this._optimum[paramInt]).PosPrev;
/*  459 */     int j = (this._optimum[paramInt]).BackPrev;
/*      */     while (true) {
/*  461 */       if ((this._optimum[paramInt]).Prev1IsChar) {
/*  462 */         this._optimum[i].MakeAsChar();
/*  463 */         (this._optimum[i]).PosPrev = i - 1;
/*  464 */         if ((this._optimum[paramInt]).Prev2) {
/*  465 */           (this._optimum[i - 1]).Prev1IsChar = false;
/*  466 */           (this._optimum[i - 1]).PosPrev = (this._optimum[paramInt]).PosPrev2;
/*  467 */           (this._optimum[i - 1]).BackPrev = (this._optimum[paramInt]).BackPrev2;
/*      */         } 
/*      */       } 
/*  470 */       int k = i;
/*  471 */       int m = j;
/*      */       
/*  473 */       j = (this._optimum[k]).BackPrev;
/*  474 */       i = (this._optimum[k]).PosPrev;
/*      */       
/*  476 */       (this._optimum[k]).BackPrev = m;
/*  477 */       (this._optimum[k]).PosPrev = paramInt;
/*      */       
/*  479 */       if ((paramInt = k) <= 0) {
/*  480 */         this.backRes = (this._optimum[0]).BackPrev;
/*  481 */         this._optimumCurrentIndex = (this._optimum[0]).PosPrev;
/*  482 */         return this._optimumCurrentIndex;
/*      */       } 
/*      */     } 
/*  485 */   } public Encoder() { this.reps = new int[4];
/*  486 */     this.repLens = new int[4];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1117 */     this.processedInSize = new long[1];
/* 1118 */     this.processedOutSize = new long[1];
/* 1119 */     this.finished = new boolean[1];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1140 */     this.properties = new byte[5];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1149 */     this.tempPrices = new int[128]; byte b; for (b = 0; b < 'က'; b++) this._optimum[b] = new Optimal();  for (b = 0; b < 4; b++) this._posSlotEncoder[b] = new BitTreeEncoder(6);  }
/*      */   int GetOptimum(int paramInt) { int i; if (this._optimumEndIndex != this._optimumCurrentIndex) { i = (this._optimum[this._optimumCurrentIndex]).PosPrev - this._optimumCurrentIndex; this.backRes = (this._optimum[this._optimumCurrentIndex]).BackPrev; this._optimumCurrentIndex = (this._optimum[this._optimumCurrentIndex]).PosPrev; return i; }  this._optimumCurrentIndex = this._optimumEndIndex = 0; if (!this._longestMatchWasFound) { i = ReadMatchDistances(); } else { i = this._longestMatchLength; this._longestMatchWasFound = false; }  int j = this._numDistancePairs; int k; if ((k = this._matchFinder.GetNumAvailableBytes() + 1) < 2) { this.backRes = -1; return 1; }  k = 0; int m; for (m = 0; m < 4; m++) { this.reps[m] = this._repDistances[m]; this.repLens[m] = this._matchFinder.GetMatchLen(-1, this.reps[m], 273); if (this.repLens[m] > this.repLens[k]) k = m;  }  if (this.repLens[k] >= this._numFastBytes) { this.backRes = k; m = this.repLens[k]; MovePos(m - 1); return m; }  if (i >= this._numFastBytes) { this.backRes = this._matchDistances[j - 1] + 4; MovePos(i - 1); return i; }  m = this._matchFinder.GetIndexByte(-1); byte b = this._matchFinder.GetIndexByte(0 - this._repDistances[0] - 1 - 1); if (i < 2 && m != b && this.repLens[k] < 2) { this.backRes = -1; return 1; }  (this._optimum[0]).State = this._state; int i1 = paramInt & this._posStateMask; (this._optimum[1]).Price = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isMatch[(this._state << 4) + i1]) + this._literalEncoder.GetSubCoder(paramInt, this._previousByte).GetPrice(!Base.StateIsCharState(this._state), b, m); this._optimum[1].MakeAsChar(); int i2, i3 = (i2 = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isMatch[(this._state << 4) + i1])) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep[this._state]); int i4; if (b == m && (i4 = i3 + GetRepLen1Price(this._state, i1)) < (this._optimum[1]).Price) { (this._optimum[1]).Price = i4; this._optimum[1].MakeAsShortRep(); }  if ((i4 = (i >= this.repLens[k]) ? i : this.repLens[k]) < 2) { this.backRes = (this._optimum[1]).BackPrev; return 1; }  (this._optimum[1]).PosPrev = 0; (this._optimum[0]).Backs0 = this.reps[0]; (this._optimum[0]).Backs1 = this.reps[1]; (this._optimum[0]).Backs2 = this.reps[2]; (this._optimum[0]).Backs3 = this.reps[3]; k = i4; do { (this._optimum[k--]).Price = 268435455; } while (k >= 2); for (m = 0; m < 4; m++) { int i5; if ((i5 = this.repLens[m]) >= 2) { int i6 = i3 + GetPureRepPrice(m, this._state, i1); do { int i7 = i6 + this._repMatchLenEncoder.GetPrice(i5 - 2, i1); Optimal optimal = this._optimum[i5]; if (i7 >= optimal.Price) continue;  optimal.Price = i7; optimal.PosPrev = 0; optimal.BackPrev = m; optimal.Prev1IsChar = false; } while (--i5 >= 2); }  }  int n = i2 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRep[this._state]); if ((k = (this.repLens[0] >= 2) ? (this.repLens[0] + 1) : 2) <= i) { byte b2 = 0; while (k > this._matchDistances[b2]) b2 += true;  while (true) { int i5 = this._matchDistances[b2 + 1]; int i6 = n + GetPosLenPrice(i5, k, i1); Optimal optimal = this._optimum[k]; if (i6 < optimal.Price) { optimal.Price = i6; optimal.PosPrev = 0; optimal.BackPrev = i5 + 4; optimal.Prev1IsChar = false; }  b2 += 2; if (k != this._matchDistances[b2] || b2 != j) { k++; continue; }  break; }  }  byte b1 = 0; label231: while (true) { b1++; if (b1 == i4) return Backward(b1);  int i5 = ReadMatchDistances(); j = this._numDistancePairs; if (i5 >= this._numFastBytes) { this._longestMatchLength = i5; this._longestMatchWasFound = true; return Backward(b1); }  paramInt++; int i6 = (this._optimum[b1]).PosPrev; if ((this._optimum[b1]).Prev1IsChar) { i6--; if ((this._optimum[b1]).Prev2) { i = (this._optimum[(this._optimum[b1]).PosPrev2]).State; if ((this._optimum[b1]).BackPrev2 < 4) { i = Base.StateUpdateRep(i); } else { i = Base.StateUpdateMatch(i); }  } else { i = (this._optimum[i6]).State; }  i = Base.StateUpdateChar(i); } else { i = (this._optimum[i6]).State; }  if (i6 == b1 - 1) { if (this._optimum[b1].IsShortRep()) { i = Base.StateUpdateShortRep(i); } else { i = Base.StateUpdateChar(i); }  } else { if ((this._optimum[b1]).Prev1IsChar && (this._optimum[b1]).Prev2) { i6 = (this._optimum[b1]).PosPrev2; k = (this._optimum[b1]).BackPrev2; i = Base.StateUpdateRep(i); } else if ((k = (this._optimum[b1]).BackPrev) < 4) { i = Base.StateUpdateRep(i); } else { i = Base.StateUpdateMatch(i); }  Optimal optimal1 = this._optimum[i6]; if (k < 4) { if (k == 0) { this.reps[0] = optimal1.Backs0; this.reps[1] = optimal1.Backs1; this.reps[2] = optimal1.Backs2; this.reps[3] = optimal1.Backs3; } else if (k == 1) { this.reps[0] = optimal1.Backs1; this.reps[1] = optimal1.Backs0; this.reps[2] = optimal1.Backs2; this.reps[3] = optimal1.Backs3; } else if (k == 2) { this.reps[0] = optimal1.Backs2; this.reps[1] = optimal1.Backs0; this.reps[2] = optimal1.Backs1; this.reps[3] = optimal1.Backs3; } else { this.reps[0] = optimal1.Backs3; this.reps[1] = optimal1.Backs0; this.reps[2] = optimal1.Backs1; this.reps[3] = optimal1.Backs2; }  } else { this.reps[0] = k - 4; this.reps[1] = optimal1.Backs0; this.reps[2] = optimal1.Backs1; this.reps[3] = optimal1.Backs2; }  }  (this._optimum[b1]).State = i; (this._optimum[b1]).Backs0 = this.reps[0]; (this._optimum[b1]).Backs1 = this.reps[1]; (this._optimum[b1]).Backs2 = this.reps[2]; (this._optimum[b1]).Backs3 = this.reps[3]; k = (this._optimum[b1]).Price; m = this._matchFinder.GetIndexByte(-1); n = this._matchFinder.GetIndexByte(0 - this.reps[0] - 1 - 1); i1 = paramInt & this._posStateMask; i6 = k + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isMatch[(i << 4) + i1]) + this._literalEncoder.GetSubCoder(paramInt, this._matchFinder.GetIndexByte(-2)).GetPrice(!Base.StateIsCharState(i), n, m); Optimal optimal = this._optimum[b1 + 1]; int i7 = 0; if (i6 < optimal.Price) { optimal.Price = i6; optimal.PosPrev = b1; optimal.MakeAsChar(); i7 = 1; }  i3 = (i2 = k + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isMatch[(i << 4) + i1])) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep[i]); int i8; if (n == m && (optimal.PosPrev >= b1 || optimal.BackPrev != 0) && (i8 = i3 + GetRepLen1Price(i, i1)) <= optimal.Price) { optimal.Price = i8; optimal.PosPrev = b1; optimal.MakeAsShortRep(); i7 = 1; }  i8 = this._matchFinder.GetNumAvailableBytes() + 1; if ((k = i8 = Math.min(4095 - b1, i8)) >= 2) { if (k > this._numFastBytes) k = this._numFastBytes;  if (!i7 && n != m) { m = Math.min(i8 - 1, this._numFastBytes); int i9; if ((i9 = this._matchFinder.GetMatchLen(0, this.reps[0], m)) >= 2) { i7 = Base.StateUpdateChar(i); int i10 = paramInt + 1 & this._posStateMask; i6 = i6 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isMatch[(i7 << 4) + i10]) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep[i7]); int i11 = b1 + 1 + i9; while (i4 < i11) (this._optimum[++i4]).Price = 268435455;  int i12 = i6 + GetRepPrice(0, i9, i7, i10); Optimal optimal1 = this._optimum[i11]; if (i12 < optimal1.Price) { optimal1.Price = i12; optimal1.PosPrev = b1 + 1; optimal1.BackPrev = 0; optimal1.Prev1IsChar = true; optimal1.Prev2 = false; }  }  }  m = 2; byte b2; for (b2 = 0; b2 < 4; b2++) { if ((i7 = this._matchFinder.GetMatchLen(-1, this.reps[b2], k)) >= 2) { int i9 = i7; while (true) { while (i4 < b1 + i7) (this._optimum[++i4]).Price = 268435455;  i6 = i3 + GetRepPrice(b2, i7, i, i1); Optimal optimal1 = this._optimum[b1 + i7]; if (i6 < optimal1.Price) { optimal1.Price = i6; optimal1.PosPrev = b1; optimal1.BackPrev = b2; optimal1.Prev1IsChar = false; }  if (--i7 < 2) { i7 = i9; if (b2 == 0) m = i7 + 1;  i6 = Math.min(i8 - 1 - i7, this._numFastBytes); int i10; if (i7 < i8 && (i10 = this._matchFinder.GetMatchLen(i7, this.reps[b2], i6)) >= 2) { int i11 = Base.StateUpdateRep(i); int i12 = paramInt + i7 & this._posStateMask; int i13 = i3 + GetRepPrice(b2, i7, i, i1) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isMatch[(i11 << 4) + i12]) + this._literalEncoder.GetSubCoder(paramInt + i7, this._matchFinder.GetIndexByte(i7 - 1 - 1)).GetPrice(true, this._matchFinder.GetIndexByte(i7 - 1 - this.reps[b2] + 1), this._matchFinder.GetIndexByte(i7 - 1)); i11 = Base.StateUpdateChar(i11); i12 = paramInt + i7 + 1 & this._posStateMask; int i14; i6 = (i14 = i13 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isMatch[(i11 << 4) + i12])) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep[i11]); int i15 = i7 + 1 + i10; while (i4 < b1 + i15) (this._optimum[++i4]).Price = 268435455;  i6 += GetRepPrice(0, i10, i11, i12); Optimal optimal2 = this._optimum[b1 + i15]; if (i6 < optimal2.Price) { optimal2.Price = i6; optimal2.PosPrev = b1 + i7 + 1; optimal2.BackPrev = 0; optimal2.Prev1IsChar = true; optimal2.Prev2 = true; optimal2.PosPrev2 = b1; optimal2.BackPrev2 = b2; }  }  break; }  }  }  }  if (i5 > k) { i5 = k; for (j = 0; i5 > this._matchDistances[j]; j += 2); this._matchDistances[j] = i5; j += 2; }  if (i5 >= m) { n = i2 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRep[i]); while (i4 < b1 + i5) (this._optimum[++i4]).Price = 268435455;  b2 = 0; while (m > this._matchDistances[b2]) b2 += 2;  for (i7 = m;; i7++) { int i9 = this._matchDistances[b2 + 1]; i6 = n + GetPosLenPrice(i9, i7, i1); Optimal optimal1 = this._optimum[b1 + i7]; if (i6 < optimal1.Price) { optimal1.Price = i6; optimal1.PosPrev = b1; optimal1.BackPrev = i9 + 4; optimal1.Prev1IsChar = false; }  if (i7 == this._matchDistances[b2]) { int i10 = Math.min(i8 - 1 - i7, this._numFastBytes); int i11; if (i7 < i8 && (i11 = this._matchFinder.GetMatchLen(i7, i9, i10)) >= 2) { int i13 = Base.StateUpdateMatch(i); int i14 = paramInt + i7 & this._posStateMask; i6 = i6 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isMatch[(i13 << 4) + i14]) + this._literalEncoder.GetSubCoder(paramInt + i7, this._matchFinder.GetIndexByte(i7 - 1 - 1)).GetPrice(true, this._matchFinder.GetIndexByte(i7 - i9 + 1 - 1), this._matchFinder.GetIndexByte(i7 - 1)); i13 = Base.StateUpdateChar(i13); i14 = paramInt + i7 + 1 & this._posStateMask; int i15; i6 = (i15 = i6 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isMatch[(i13 << 4) + i14])) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep[i13]); int i12 = i7 + 1 + i11; while (i4 < b1 + i12) (this._optimum[++i4]).Price = 268435455;  i6 += GetRepPrice(0, i11, i13, i14); Optimal optimal2 = this._optimum[b1 + i12]; if (i6 < optimal2.Price) { optimal2.Price = i6; optimal2.PosPrev = b1 + i7 + 1; optimal2.BackPrev = 0; optimal2.Prev1IsChar = true; optimal2.Prev2 = true; optimal2.PosPrev2 = b1; optimal2.BackPrev2 = i9 + 4; }  }  b2 += 2; if (b2 != j) continue;  continue label231; }  continue; }  break; }  }  }  }
/*      */   boolean ChangePair(int paramInt1, int paramInt2) { return (paramInt1 < 33554432 && paramInt2 >= paramInt1 << 7); }
/*      */   void WriteEndMarker(int paramInt) { if (!this._writeEndMark) return;  this._rangeEncoder.Encode(this._isMatch, (this._state << 4) + paramInt, 1); this._rangeEncoder.Encode(this._isRep, this._state, 0); this._state = Base.StateUpdateMatch(this._state); this._lenEncoder.Encode(this._rangeEncoder, 0, paramInt); paramInt = Base.GetLenToPosState(2); this._posSlotEncoder[paramInt].Encode(this._rangeEncoder, 63); this._rangeEncoder.EncodeDirectBits(67108863, 26); this._posAlignEncoder.ReverseEncode(this._rangeEncoder, 15); }
/* 1153 */   void Flush(int paramInt) { ReleaseMFStream(); WriteEndMarker(paramInt & this._posStateMask); this._rangeEncoder.FlushData(); this._rangeEncoder.FlushStream(); } public void CodeOneBlock(long[] paramArrayOflong1, long[] paramArrayOflong2, boolean[] paramArrayOfboolean) { paramArrayOflong1[0] = 0L; paramArrayOflong2[0] = 0L; paramArrayOfboolean[0] = true; if (this._inStream != null) { this._matchFinder.SetStream(this._inStream); this._matchFinder.Init(); this._needReleaseMFStream = true; this._inStream = null; }  if (this._finished) return;  this._finished = true; long l = this.nowPos64; if (this.nowPos64 == 0L) { if (this._matchFinder.GetNumAvailableBytes() == 0) { Flush((int)this.nowPos64); return; }  ReadMatchDistances(); int i = (int)this.nowPos64 & this._posStateMask; this._rangeEncoder.Encode(this._isMatch, (this._state << 4) + i, 0); this._state = Base.StateUpdateChar(this._state); byte b = this._matchFinder.GetIndexByte(0 - this._additionalOffset); this._literalEncoder.GetSubCoder((int)this.nowPos64, this._previousByte).Encode(this._rangeEncoder, b); this._previousByte = b; this._additionalOffset--; this.nowPos64++; }  if (this._matchFinder.GetNumAvailableBytes() == 0) { Flush((int)this.nowPos64); return; }  while (true) { LiteralEncoder.Encoder2 encoder2; int i = GetOptimum((int)this.nowPos64); int j = this.backRes; int k = (int)this.nowPos64 & this._posStateMask; int m = (this._state << 4) + k; if (i == 1 && j == -1) { this._rangeEncoder.Encode(this._isMatch, m, 0); k = this._matchFinder.GetIndexByte(0 - this._additionalOffset); encoder2 = this._literalEncoder.GetSubCoder((int)this.nowPos64, this._previousByte); if (!Base.StateIsCharState(this._state)) { byte b = this._matchFinder.GetIndexByte(0 - this._repDistances[0] - 1 - this._additionalOffset); encoder2.EncodeMatched(this._rangeEncoder, b, k); } else { encoder2.Encode(this._rangeEncoder, k); }  this._previousByte = k; this._state = Base.StateUpdateChar(this._state); } else { this._rangeEncoder.Encode(this._isMatch, encoder2, 1); if (j < 4) { this._rangeEncoder.Encode(this._isRep, this._state, 1); if (j == 0) { this._rangeEncoder.Encode(this._isRepG0, this._state, 0); if (i == 1) { this._rangeEncoder.Encode(this._isRep0Long, encoder2, 0); } else { this._rangeEncoder.Encode(this._isRep0Long, encoder2, 1); }  } else { this._rangeEncoder.Encode(this._isRepG0, this._state, 1); if (j == 1) { this._rangeEncoder.Encode(this._isRepG1, this._state, 0); } else { this._rangeEncoder.Encode(this._isRepG1, this._state, 1); this._rangeEncoder.Encode(this._isRepG2, this._state, j - 2); }  }  if (i == 1) { this._state = Base.StateUpdateShortRep(this._state); } else { this._repMatchLenEncoder.Encode(this._rangeEncoder, i - 2, k); this._state = Base.StateUpdateRep(this._state); }  k = this._repDistances[j]; if (j != 0) { for (int n = j; n > 0; n--) this._repDistances[n] = this._repDistances[n - 1];  this._repDistances[0] = k; }  } else { this._rangeEncoder.Encode(this._isRep, this._state, 0); this._state = Base.StateUpdateMatch(this._state); this._lenEncoder.Encode(this._rangeEncoder, i - 2, k); j -= 4; k = GetPosSlot(j); int n = Base.GetLenToPosState(i); this._posSlotEncoder[n].Encode(this._rangeEncoder, k); if (k >= 4) { int i1 = (k >> 1) - 1; n = (0x2 | k & 0x1) << i1; int i2 = j - n; if (k < 14) { BitTreeEncoder.ReverseEncode(this._posEncoders, n - k - 1, this._rangeEncoder, i1, i2); } else { this._rangeEncoder.EncodeDirectBits(i2 >> 4, i1 - 4); this._posAlignEncoder.ReverseEncode(this._rangeEncoder, i2 & 0xF); this._alignPriceCount++; }  }  for (n = 3; n > 0; n--) this._repDistances[n] = this._repDistances[n - 1];  this._repDistances[0] = j; this._matchPriceCount++; }  this._previousByte = this._matchFinder.GetIndexByte(i - 1 - this._additionalOffset); }  this._additionalOffset -= i; this.nowPos64 += i; if (this._additionalOffset == 0) { if (this._matchPriceCount >= 128) FillDistancesPrices();  if (this._alignPriceCount >= 16) FillAlignPrices();  paramArrayOflong1[0] = this.nowPos64; paramArrayOflong2[0] = this._rangeEncoder.GetProcessedSizeAdd(); if (this._matchFinder.GetNumAvailableBytes() == 0) { Flush((int)this.nowPos64); return; }  if (this.nowPos64 - l >= 4096L) { this._finished = false; paramArrayOfboolean[0] = false; return; }  }  }  } void ReleaseMFStream() { if (this._matchFinder != null && this._needReleaseMFStream) { this._matchFinder.ReleaseStream(); this._needReleaseMFStream = false; }  } void FillDistancesPrices() { byte b; for (b = 4; b < ''; b++) {
/*      */       
/* 1155 */       int i, j = ((i = GetPosSlot(b)) >> 1) - 1;
/* 1156 */       int k = (0x2 | i & 0x1) << j;
/* 1157 */       this.tempPrices[b] = BitTreeEncoder.ReverseGetPrice(this._posEncoders, k - i - 1, j, b - k);
/*      */     } 
/*      */     
/* 1160 */     for (b = 0; b < 4; b++) {
/*      */       
/* 1162 */       BitTreeEncoder bitTreeEncoder = this._posSlotEncoder[b];
/*      */       
/* 1164 */       int j = b << 6; int i;
/* 1165 */       for (i = 0; i < this._distTableSize; i++)
/* 1166 */         this._posSlotPrices[j + i] = bitTreeEncoder.GetPrice(i); 
/* 1167 */       for (i = 14; i < this._distTableSize; i++) {
/* 1168 */         this._posSlotPrices[j + i] = this._posSlotPrices[j + i] + ((i >> 1) - 1 - 4 << 6);
/*      */       }
/*      */       
/* 1171 */       i = b << 7;
/*      */       byte b1;
/* 1173 */       for (b1 = 0; b1 < 4; b1++)
/* 1174 */         this._distancesPrices[i + b1] = this._posSlotPrices[j + b1]; 
/* 1175 */       for (; b1 < ''; b1++)
/* 1176 */         this._distancesPrices[i + b1] = this._posSlotPrices[j + GetPosSlot(b1)] + this.tempPrices[b1]; 
/*      */     } 
/* 1178 */     this._matchPriceCount = 0; }
/*      */   void SetOutStream(OutputStream paramOutputStream) { this._rangeEncoder.SetStream(paramOutputStream); }
/*      */   void ReleaseOutStream() { this._rangeEncoder.ReleaseStream(); }
/*      */   void ReleaseStreams() { ReleaseMFStream(); ReleaseOutStream(); }
/* 1182 */   void SetStreams(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2) { this._inStream = paramInputStream; this._finished = false; Create(); SetOutStream(paramOutputStream); Init(); FillDistancesPrices(); FillAlignPrices(); this._lenEncoder.SetTableSize(this._numFastBytes + 1 - 2); this._lenEncoder.UpdateTables(1 << this._posStateBits); this._repMatchLenEncoder.SetTableSize(this._numFastBytes + 1 - 2); this._repMatchLenEncoder.UpdateTables(1 << this._posStateBits); this.nowPos64 = 0L; } public void Code(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2, ICodeProgress paramICodeProgress) { this._needReleaseMFStream = false; try { SetStreams(paramInputStream, paramOutputStream, paramLong1, paramLong2); while (true) { CodeOneBlock(this.processedInSize, this.processedOutSize, this.finished); if (this.finished[0]) return;  if (paramICodeProgress != null) paramICodeProgress.SetProgress(this.processedInSize[0], this.processedOutSize[0]);  }  } finally { ReleaseStreams(); }  } public void WriteCoderProperties(OutputStream paramOutputStream) { this.properties[0] = (byte)((this._posStateBits * 5 + this._numLiteralPosStateBits) * 9 + this._numLiteralContextBits); for (byte b = 0; b < 4; b++) this.properties[b + 1] = (byte)(this._dictionarySize >> b * 8);  paramOutputStream.write(this.properties, 0, 5); } void FillAlignPrices() { for (byte b = 0; b < 16; b++)
/* 1183 */       this._alignPrices[b] = this._posAlignEncoder.ReverseGetPrice(b); 
/* 1184 */     this._alignPriceCount = 0; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean SetAlgorithm(int paramInt) {
/* 1191 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean SetDictionarySize(int paramInt) {
/* 1196 */     if (paramInt <= 0 || paramInt > 536870912) return false; 
/* 1197 */     this._dictionarySize = paramInt;
/*      */     byte b;
/* 1199 */     for (b = 0; paramInt > 1 << b; b++);
/*      */     
/* 1201 */     this._distTableSize = b << 1;
/* 1202 */     return true;
/*      */   }
/*      */   
/*      */   public boolean SetNumFastBytes(int paramInt) {
/* 1206 */     if (paramInt < 5 || paramInt > 273) return false; 
/* 1207 */     this._numFastBytes = paramInt;
/* 1208 */     return true;
/*      */   }
/*      */   
/*      */   public boolean SetMatchFinder(int paramInt) {
/* 1212 */     if (paramInt < 0 || paramInt > 2) return false; 
/* 1213 */     int i = this._matchFinderType;
/* 1214 */     this._matchFinderType = paramInt;
/* 1215 */     if (this._matchFinder != null && i != this._matchFinderType) {
/* 1216 */       this._dictionarySizePrev = -1;
/* 1217 */       this._matchFinder = null;
/*      */     } 
/* 1219 */     return true;
/*      */   }
/*      */   
/*      */   public boolean SetLcLpPb(int paramInt1, int paramInt2, int paramInt3) {
/* 1223 */     if (paramInt2 < 0 || paramInt2 > 4 || paramInt1 < 0 || paramInt1 > 8 || paramInt3 < 0 || paramInt3 > 4)
/* 1224 */       return false; 
/* 1225 */     this._numLiteralPosStateBits = paramInt2;
/* 1226 */     this._numLiteralContextBits = paramInt1;
/* 1227 */     this._posStateBits = paramInt3;
/* 1228 */     this._posStateMask = (1 << this._posStateBits) - 1;
/* 1229 */     return true;
/*      */   }
/*      */   
/*      */   public void SetEndMarkerMode(boolean paramBoolean) {
/* 1233 */     this._writeEndMark = paramBoolean;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\lzma\Encoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */