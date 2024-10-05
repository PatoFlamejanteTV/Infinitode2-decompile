/*     */ package com.badlogic.gdx.utils.compression.lzma;
/*     */ 
/*     */ import com.badlogic.gdx.utils.compression.lz.OutWindow;
/*     */ import com.badlogic.gdx.utils.compression.rangecoder.BitTreeDecoder;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
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
/*     */ public class Decoder
/*     */ {
/*     */   class LenDecoder
/*     */   {
/*  26 */     short[] m_Choice = new short[2];
/*  27 */     BitTreeDecoder[] m_LowCoder = new BitTreeDecoder[16];
/*  28 */     BitTreeDecoder[] m_MidCoder = new BitTreeDecoder[16];
/*  29 */     BitTreeDecoder m_HighCoder = new BitTreeDecoder(8);
/*  30 */     int m_NumPosStates = 0;
/*     */     
/*     */     public void Create(int param1Int) {
/*  33 */       for (; this.m_NumPosStates < param1Int; this.m_NumPosStates++) {
/*  34 */         this.m_LowCoder[this.m_NumPosStates] = new BitTreeDecoder(3);
/*  35 */         this.m_MidCoder[this.m_NumPosStates] = new BitTreeDecoder(3);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void Init() {
/*  40 */       com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_Choice);
/*  41 */       for (byte b = 0; b < this.m_NumPosStates; b++) {
/*  42 */         this.m_LowCoder[b].Init();
/*  43 */         this.m_MidCoder[b].Init();
/*     */       } 
/*  45 */       this.m_HighCoder.Init();
/*     */     }
/*     */     public int Decode(com.badlogic.gdx.utils.compression.rangecoder.Decoder param1Decoder, int param1Int) {
/*     */       int i;
/*  49 */       if (param1Decoder.DecodeBit(this.m_Choice, 0) == 0) return this.m_LowCoder[param1Int].Decode(param1Decoder);
/*     */       
/*  51 */       if (param1Decoder.DecodeBit(this.m_Choice, 1) == 0) {
/*  52 */         i = 8 + this.m_MidCoder[param1Int].Decode(param1Decoder);
/*     */       } else {
/*  54 */         i = 8 + 8 + this.m_HighCoder.Decode(i);
/*  55 */       }  return i;
/*     */     } }
/*     */   class LiteralDecoder { Decoder2[] m_Coders; int m_NumPrevBits; int m_NumPosBits; int m_PosMask;
/*     */     class Decoder2 { short[] m_Decoders;
/*     */       
/*     */       Decoder2() {
/*  61 */         this.m_Decoders = new short[768];
/*     */       }
/*     */       public void Init() {
/*  64 */         com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_Decoders);
/*     */       }
/*     */       
/*     */       public byte DecodeNormal(com.badlogic.gdx.utils.compression.rangecoder.Decoder param2Decoder) {
/*  68 */         int i = 1;
/*     */         do {
/*     */         
/*  71 */         } while ((i = i << 1 | param2Decoder.DecodeBit(this.m_Decoders, i)) < 256);
/*  72 */         return (byte)i;
/*     */       }
/*     */ 
/*     */       
/*     */       public byte DecodeWithMatchByte(com.badlogic.gdx.utils.compression.rangecoder.Decoder param2Decoder, byte param2Byte) {
/*  77 */         int i = 1;
/*     */         do {
/*  79 */           int j = param2Byte >> 7 & 0x1;
/*  80 */           param2Byte = (byte)(param2Byte << 1);
/*  81 */           int k = param2Decoder.DecodeBit(this.m_Decoders, (j + 1 << 8) + i);
/*  82 */           i = i << 1 | k;
/*  83 */           if (j != k) {
/*  84 */             while (i < 256)
/*  85 */               i = i << 1 | param2Decoder.DecodeBit(this.m_Decoders, i); 
/*     */             break;
/*     */           } 
/*  88 */         } while (i < 256);
/*  89 */         return (byte)i;
/*     */       } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void Create(int param1Int1, int param1Int2) {
/*  99 */       if (this.m_Coders != null && this.m_NumPrevBits == param1Int2 && this.m_NumPosBits == param1Int1)
/* 100 */         return;  this.m_NumPosBits = param1Int1;
/* 101 */       this.m_PosMask = (1 << param1Int1) - 1;
/* 102 */       this.m_NumPrevBits = param1Int2;
/* 103 */       param1Int1 = 1 << this.m_NumPrevBits + this.m_NumPosBits;
/* 104 */       this.m_Coders = new Decoder2[param1Int1];
/* 105 */       for (param1Int2 = 0; param1Int2 < param1Int1; param1Int2++)
/* 106 */         this.m_Coders[param1Int2] = new Decoder2(); 
/*     */     }
/*     */     
/*     */     public void Init() {
/* 110 */       int i = 1 << this.m_NumPrevBits + this.m_NumPosBits;
/* 111 */       for (byte b = 0; b < i; b++)
/* 112 */         this.m_Coders[b].Init(); 
/*     */     }
/*     */     
/*     */     Decoder2 GetDecoder(int param1Int, byte param1Byte) {
/* 116 */       return this.m_Coders[((param1Int & this.m_PosMask) << this.m_NumPrevBits) + ((param1Byte & 0xFF) >>> 8 - this.m_NumPrevBits)];
/*     */     } }
/*     */ 
/*     */   
/* 120 */   OutWindow m_OutWindow = new OutWindow(); class Decoder2 {
/* 121 */     short[] m_Decoders = new short[768]; public void Init() { com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_Decoders); } public byte DecodeNormal(com.badlogic.gdx.utils.compression.rangecoder.Decoder param1Decoder) { int i = 1; do {  } while ((i = i << 1 | param1Decoder.DecodeBit(this.m_Decoders, i)) < 256); return (byte)i; } public byte DecodeWithMatchByte(com.badlogic.gdx.utils.compression.rangecoder.Decoder param1Decoder, byte param1Byte) { int i = 1; do { int j = param1Byte >> 7 & 0x1; param1Byte = (byte)(param1Byte << 1); int k = param1Decoder.DecodeBit(this.m_Decoders, (j + 1 << 8) + i); i = i << 1 | k; if (j != k) { while (i < 256) i = i << 1 | param1Decoder.DecodeBit(this.m_Decoders, i);  break; }  } while (i < 256); return (byte)i; } } com.badlogic.gdx.utils.compression.rangecoder.Decoder m_RangeDecoder = new com.badlogic.gdx.utils.compression.rangecoder.Decoder();
/*     */   
/* 123 */   short[] m_IsMatchDecoders = new short[192];
/* 124 */   short[] m_IsRepDecoders = new short[12];
/* 125 */   short[] m_IsRepG0Decoders = new short[12];
/* 126 */   short[] m_IsRepG1Decoders = new short[12];
/* 127 */   short[] m_IsRepG2Decoders = new short[12];
/* 128 */   short[] m_IsRep0LongDecoders = new short[192];
/*     */   
/* 130 */   BitTreeDecoder[] m_PosSlotDecoder = new BitTreeDecoder[4];
/* 131 */   short[] m_PosDecoders = new short[114];
/*     */   
/* 133 */   BitTreeDecoder m_PosAlignDecoder = new BitTreeDecoder(4);
/*     */   
/* 135 */   LenDecoder m_LenDecoder = new LenDecoder();
/* 136 */   LenDecoder m_RepLenDecoder = new LenDecoder();
/*     */   
/* 138 */   LiteralDecoder m_LiteralDecoder = new LiteralDecoder();
/*     */   
/* 140 */   int m_DictionarySize = -1;
/* 141 */   int m_DictionarySizeCheck = -1;
/*     */   
/*     */   int m_PosStateMask;
/*     */   
/*     */   public Decoder() {
/* 146 */     for (byte b = 0; b < 4; b++)
/* 147 */       this.m_PosSlotDecoder[b] = new BitTreeDecoder(6); 
/*     */   }
/*     */   
/*     */   boolean SetDictionarySize(int paramInt) {
/* 151 */     if (paramInt < 0) return false; 
/* 152 */     if (this.m_DictionarySize != paramInt) {
/* 153 */       this.m_DictionarySize = paramInt;
/* 154 */       this.m_DictionarySizeCheck = Math.max(this.m_DictionarySize, 1);
/* 155 */       this.m_OutWindow.Create(Math.max(this.m_DictionarySizeCheck, 4096));
/*     */     } 
/* 157 */     return true;
/*     */   }
/*     */   
/*     */   boolean SetLcLpPb(int paramInt1, int paramInt2, int paramInt3) {
/* 161 */     if (paramInt1 > 8 || paramInt2 > 4 || paramInt3 > 4) return false; 
/* 162 */     this.m_LiteralDecoder.Create(paramInt2, paramInt1);
/* 163 */     paramInt1 = 1 << paramInt3;
/* 164 */     this.m_LenDecoder.Create(paramInt1);
/* 165 */     this.m_RepLenDecoder.Create(paramInt1);
/* 166 */     this.m_PosStateMask = paramInt1 - 1;
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   void Init() {
/* 171 */     this.m_OutWindow.Init(false);
/*     */     
/* 173 */     com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsMatchDecoders);
/* 174 */     com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRep0LongDecoders);
/* 175 */     com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepDecoders);
/* 176 */     com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepG0Decoders);
/* 177 */     com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepG1Decoders);
/* 178 */     com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepG2Decoders);
/* 179 */     com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_PosDecoders);
/*     */     
/* 181 */     this.m_LiteralDecoder.Init();
/*     */     
/* 183 */     for (byte b = 0; b < 4; b++)
/* 184 */       this.m_PosSlotDecoder[b].Init(); 
/* 185 */     this.m_LenDecoder.Init();
/* 186 */     this.m_RepLenDecoder.Init();
/* 187 */     this.m_PosAlignDecoder.Init();
/* 188 */     this.m_RangeDecoder.Init();
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
/*     */   public boolean Code(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   4: aload_1
/*     */     //   5: invokevirtual SetStream : (Ljava/io/InputStream;)V
/*     */     //   8: aload_0
/*     */     //   9: getfield m_OutWindow : Lcom/badlogic/gdx/utils/compression/lz/OutWindow;
/*     */     //   12: aload_2
/*     */     //   13: invokevirtual SetStream : (Ljava/io/OutputStream;)V
/*     */     //   16: aload_0
/*     */     //   17: invokevirtual Init : ()V
/*     */     //   20: invokestatic StateInit : ()I
/*     */     //   23: istore_1
/*     */     //   24: iconst_0
/*     */     //   25: istore_2
/*     */     //   26: iconst_0
/*     */     //   27: istore #5
/*     */     //   29: iconst_0
/*     */     //   30: istore #6
/*     */     //   32: iconst_0
/*     */     //   33: istore #7
/*     */     //   35: lconst_0
/*     */     //   36: lstore #10
/*     */     //   38: iconst_0
/*     */     //   39: istore #8
/*     */     //   41: lload_3
/*     */     //   42: lconst_0
/*     */     //   43: lcmp
/*     */     //   44: iflt -> 54
/*     */     //   47: lload #10
/*     */     //   49: lload_3
/*     */     //   50: lcmp
/*     */     //   51: ifge -> 521
/*     */     //   54: lload #10
/*     */     //   56: l2i
/*     */     //   57: aload_0
/*     */     //   58: getfield m_PosStateMask : I
/*     */     //   61: iand
/*     */     //   62: istore #9
/*     */     //   64: aload_0
/*     */     //   65: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   68: aload_0
/*     */     //   69: getfield m_IsMatchDecoders : [S
/*     */     //   72: iload_1
/*     */     //   73: iconst_4
/*     */     //   74: ishl
/*     */     //   75: iload #9
/*     */     //   77: iadd
/*     */     //   78: invokevirtual DecodeBit : ([SI)I
/*     */     //   81: ifne -> 161
/*     */     //   84: aload_0
/*     */     //   85: getfield m_LiteralDecoder : Lcom/badlogic/gdx/utils/compression/lzma/Decoder$LiteralDecoder;
/*     */     //   88: lload #10
/*     */     //   90: l2i
/*     */     //   91: iload #8
/*     */     //   93: invokevirtual GetDecoder : (IB)Lcom/badlogic/gdx/utils/compression/lzma/Decoder$LiteralDecoder$Decoder2;
/*     */     //   96: astore #8
/*     */     //   98: iload_1
/*     */     //   99: invokestatic StateIsCharState : (I)Z
/*     */     //   102: ifne -> 127
/*     */     //   105: aload #8
/*     */     //   107: aload_0
/*     */     //   108: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   111: aload_0
/*     */     //   112: getfield m_OutWindow : Lcom/badlogic/gdx/utils/compression/lz/OutWindow;
/*     */     //   115: iload_2
/*     */     //   116: invokevirtual GetByte : (I)B
/*     */     //   119: invokevirtual DecodeWithMatchByte : (Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;B)B
/*     */     //   122: istore #8
/*     */     //   124: goto -> 138
/*     */     //   127: aload #8
/*     */     //   129: aload_0
/*     */     //   130: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   133: invokevirtual DecodeNormal : (Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;)B
/*     */     //   136: istore #8
/*     */     //   138: aload_0
/*     */     //   139: getfield m_OutWindow : Lcom/badlogic/gdx/utils/compression/lz/OutWindow;
/*     */     //   142: iload #8
/*     */     //   144: invokevirtual PutByte : (B)V
/*     */     //   147: iload_1
/*     */     //   148: invokestatic StateUpdateChar : (I)I
/*     */     //   151: istore_1
/*     */     //   152: lload #10
/*     */     //   154: lconst_1
/*     */     //   155: ladd
/*     */     //   156: lstore #10
/*     */     //   158: goto -> 41
/*     */     //   161: aload_0
/*     */     //   162: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   165: aload_0
/*     */     //   166: getfield m_IsRepDecoders : [S
/*     */     //   169: iload_1
/*     */     //   170: invokevirtual DecodeBit : ([SI)I
/*     */     //   173: iconst_1
/*     */     //   174: if_icmpne -> 318
/*     */     //   177: iconst_0
/*     */     //   178: istore #8
/*     */     //   180: aload_0
/*     */     //   181: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   184: aload_0
/*     */     //   185: getfield m_IsRepG0Decoders : [S
/*     */     //   188: iload_1
/*     */     //   189: invokevirtual DecodeBit : ([SI)I
/*     */     //   192: ifne -> 226
/*     */     //   195: aload_0
/*     */     //   196: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   199: aload_0
/*     */     //   200: getfield m_IsRep0LongDecoders : [S
/*     */     //   203: iload_1
/*     */     //   204: iconst_4
/*     */     //   205: ishl
/*     */     //   206: iload #9
/*     */     //   208: iadd
/*     */     //   209: invokevirtual DecodeBit : ([SI)I
/*     */     //   212: ifne -> 288
/*     */     //   215: iload_1
/*     */     //   216: invokestatic StateUpdateShortRep : (I)I
/*     */     //   219: istore_1
/*     */     //   220: iconst_1
/*     */     //   221: istore #8
/*     */     //   223: goto -> 288
/*     */     //   226: aload_0
/*     */     //   227: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   230: aload_0
/*     */     //   231: getfield m_IsRepG1Decoders : [S
/*     */     //   234: iload_1
/*     */     //   235: invokevirtual DecodeBit : ([SI)I
/*     */     //   238: ifne -> 248
/*     */     //   241: iload #5
/*     */     //   243: istore #12
/*     */     //   245: goto -> 282
/*     */     //   248: aload_0
/*     */     //   249: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   252: aload_0
/*     */     //   253: getfield m_IsRepG2Decoders : [S
/*     */     //   256: iload_1
/*     */     //   257: invokevirtual DecodeBit : ([SI)I
/*     */     //   260: ifne -> 270
/*     */     //   263: iload #6
/*     */     //   265: istore #12
/*     */     //   267: goto -> 278
/*     */     //   270: iload #7
/*     */     //   272: istore #12
/*     */     //   274: iload #6
/*     */     //   276: istore #7
/*     */     //   278: iload #5
/*     */     //   280: istore #6
/*     */     //   282: iload_2
/*     */     //   283: istore #5
/*     */     //   285: iload #12
/*     */     //   287: istore_2
/*     */     //   288: iload #8
/*     */     //   290: ifne -> 472
/*     */     //   293: aload_0
/*     */     //   294: getfield m_RepLenDecoder : Lcom/badlogic/gdx/utils/compression/lzma/Decoder$LenDecoder;
/*     */     //   297: aload_0
/*     */     //   298: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   301: iload #9
/*     */     //   303: invokevirtual Decode : (Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;I)I
/*     */     //   306: iconst_2
/*     */     //   307: iadd
/*     */     //   308: istore #8
/*     */     //   310: iload_1
/*     */     //   311: invokestatic StateUpdateRep : (I)I
/*     */     //   314: istore_1
/*     */     //   315: goto -> 472
/*     */     //   318: iload #6
/*     */     //   320: istore #7
/*     */     //   322: iload #5
/*     */     //   324: istore #6
/*     */     //   326: iload_2
/*     */     //   327: istore #5
/*     */     //   329: iconst_2
/*     */     //   330: aload_0
/*     */     //   331: getfield m_LenDecoder : Lcom/badlogic/gdx/utils/compression/lzma/Decoder$LenDecoder;
/*     */     //   334: aload_0
/*     */     //   335: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   338: iload #9
/*     */     //   340: invokevirtual Decode : (Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;I)I
/*     */     //   343: iadd
/*     */     //   344: istore #8
/*     */     //   346: iload_1
/*     */     //   347: invokestatic StateUpdateMatch : (I)I
/*     */     //   350: istore_1
/*     */     //   351: aload_0
/*     */     //   352: getfield m_PosSlotDecoder : [Lcom/badlogic/gdx/utils/compression/rangecoder/BitTreeDecoder;
/*     */     //   355: iload #8
/*     */     //   357: invokestatic GetLenToPosState : (I)I
/*     */     //   360: aaload
/*     */     //   361: aload_0
/*     */     //   362: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   365: invokevirtual Decode : (Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;)I
/*     */     //   368: dup
/*     */     //   369: istore #12
/*     */     //   371: iconst_4
/*     */     //   372: if_icmplt -> 469
/*     */     //   375: iload #12
/*     */     //   377: iconst_1
/*     */     //   378: ishr
/*     */     //   379: iconst_1
/*     */     //   380: isub
/*     */     //   381: istore #9
/*     */     //   383: iconst_2
/*     */     //   384: iload #12
/*     */     //   386: iconst_1
/*     */     //   387: iand
/*     */     //   388: ior
/*     */     //   389: iload #9
/*     */     //   391: ishl
/*     */     //   392: istore_2
/*     */     //   393: iload #12
/*     */     //   395: bipush #14
/*     */     //   397: if_icmpge -> 425
/*     */     //   400: iload_2
/*     */     //   401: aload_0
/*     */     //   402: getfield m_PosDecoders : [S
/*     */     //   405: iload_2
/*     */     //   406: iload #12
/*     */     //   408: isub
/*     */     //   409: iconst_1
/*     */     //   410: isub
/*     */     //   411: aload_0
/*     */     //   412: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   415: iload #9
/*     */     //   417: invokestatic ReverseDecode : ([SILcom/badlogic/gdx/utils/compression/rangecoder/Decoder;I)I
/*     */     //   420: iadd
/*     */     //   421: istore_2
/*     */     //   422: goto -> 472
/*     */     //   425: iload_2
/*     */     //   426: aload_0
/*     */     //   427: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   430: iload #9
/*     */     //   432: iconst_4
/*     */     //   433: isub
/*     */     //   434: invokevirtual DecodeDirectBits : (I)I
/*     */     //   437: iconst_4
/*     */     //   438: ishl
/*     */     //   439: iadd
/*     */     //   440: dup
/*     */     //   441: istore_2
/*     */     //   442: aload_0
/*     */     //   443: getfield m_PosAlignDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/BitTreeDecoder;
/*     */     //   446: aload_0
/*     */     //   447: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   450: invokevirtual ReverseDecode : (Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;)I
/*     */     //   453: iadd
/*     */     //   454: dup
/*     */     //   455: istore_2
/*     */     //   456: ifge -> 466
/*     */     //   459: iload_2
/*     */     //   460: iconst_m1
/*     */     //   461: if_icmpeq -> 521
/*     */     //   464: iconst_0
/*     */     //   465: ireturn
/*     */     //   466: goto -> 472
/*     */     //   469: iload #12
/*     */     //   471: istore_2
/*     */     //   472: iload_2
/*     */     //   473: i2l
/*     */     //   474: lload #10
/*     */     //   476: lcmp
/*     */     //   477: ifge -> 488
/*     */     //   480: iload_2
/*     */     //   481: aload_0
/*     */     //   482: getfield m_DictionarySizeCheck : I
/*     */     //   485: if_icmplt -> 490
/*     */     //   488: iconst_0
/*     */     //   489: ireturn
/*     */     //   490: aload_0
/*     */     //   491: getfield m_OutWindow : Lcom/badlogic/gdx/utils/compression/lz/OutWindow;
/*     */     //   494: iload_2
/*     */     //   495: iload #8
/*     */     //   497: invokevirtual CopyBlock : (II)V
/*     */     //   500: lload #10
/*     */     //   502: iload #8
/*     */     //   504: i2l
/*     */     //   505: ladd
/*     */     //   506: lstore #10
/*     */     //   508: aload_0
/*     */     //   509: getfield m_OutWindow : Lcom/badlogic/gdx/utils/compression/lz/OutWindow;
/*     */     //   512: iconst_0
/*     */     //   513: invokevirtual GetByte : (I)B
/*     */     //   516: istore #8
/*     */     //   518: goto -> 41
/*     */     //   521: aload_0
/*     */     //   522: getfield m_OutWindow : Lcom/badlogic/gdx/utils/compression/lz/OutWindow;
/*     */     //   525: invokevirtual Flush : ()V
/*     */     //   528: aload_0
/*     */     //   529: getfield m_OutWindow : Lcom/badlogic/gdx/utils/compression/lz/OutWindow;
/*     */     //   532: invokevirtual ReleaseStream : ()V
/*     */     //   535: aload_0
/*     */     //   536: getfield m_RangeDecoder : Lcom/badlogic/gdx/utils/compression/rangecoder/Decoder;
/*     */     //   539: invokevirtual ReleaseStream : ()V
/*     */     //   542: iconst_1
/*     */     //   543: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #192	-> 0
/*     */     //   #193	-> 8
/*     */     //   #194	-> 16
/*     */     //   #196	-> 20
/*     */     //   #197	-> 24
/*     */     //   #199	-> 35
/*     */     //   #200	-> 38
/*     */     //   #201	-> 41
/*     */     //   #202	-> 54
/*     */     //   #203	-> 64
/*     */     //   #204	-> 84
/*     */     //   #205	-> 98
/*     */     //   #206	-> 105
/*     */     //   #208	-> 127
/*     */     //   #209	-> 138
/*     */     //   #210	-> 147
/*     */     //   #211	-> 152
/*     */     //   #212	-> 158
/*     */     //   #214	-> 161
/*     */     //   #215	-> 177
/*     */     //   #216	-> 180
/*     */     //   #217	-> 195
/*     */     //   #218	-> 215
/*     */     //   #219	-> 220
/*     */     //   #223	-> 226
/*     */     //   #224	-> 241
/*     */     //   #226	-> 248
/*     */     //   #227	-> 263
/*     */     //   #229	-> 270
/*     */     //   #230	-> 274
/*     */     //   #232	-> 278
/*     */     //   #234	-> 282
/*     */     //   #235	-> 285
/*     */     //   #237	-> 288
/*     */     //   #238	-> 293
/*     */     //   #239	-> 310
/*     */     //   #242	-> 318
/*     */     //   #243	-> 322
/*     */     //   #244	-> 326
/*     */     //   #245	-> 329
/*     */     //   #246	-> 346
/*     */     //   #247	-> 351
/*     */     //   #248	-> 369
/*     */     //   #249	-> 375
/*     */     //   #250	-> 383
/*     */     //   #251	-> 393
/*     */     //   #252	-> 400
/*     */     //   #254	-> 425
/*     */     //   #255	-> 441
/*     */     //   #256	-> 455
/*     */     //   #257	-> 459
/*     */     //   #258	-> 464
/*     */     //   #261	-> 466
/*     */     //   #262	-> 469
/*     */     //   #264	-> 472
/*     */     //   #266	-> 488
/*     */     //   #268	-> 490
/*     */     //   #269	-> 500
/*     */     //   #270	-> 508
/*     */     //   #272	-> 518
/*     */     //   #273	-> 521
/*     */     //   #274	-> 528
/*     */     //   #275	-> 535
/*     */     //   #276	-> 542
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
/*     */   public boolean SetDecoderProperties(byte[] paramArrayOfbyte) {
/* 280 */     if (paramArrayOfbyte.length < 5) return false;
/*     */     
/* 282 */     int i, j = (i = paramArrayOfbyte[0] & 0xFF) % 9;
/*     */     
/* 284 */     int k = (i = i / 9) % 5;
/* 285 */     i /= 5;
/* 286 */     int m = 0;
/* 287 */     for (byte b = 0; b < 4; b++)
/* 288 */       m += (paramArrayOfbyte[b + 1] & 0xFF) << b << 3; 
/* 289 */     if (!SetLcLpPb(j, k, i)) return false; 
/* 290 */     return SetDictionarySize(m);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\lzma\Decoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */