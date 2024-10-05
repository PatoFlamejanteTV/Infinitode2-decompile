/*     */ package com.badlogic.gdx.utils.compression.lz;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BinTree
/*     */   extends InWindow
/*     */ {
/*     */   int _cyclicBufferPos;
/*   9 */   int _cyclicBufferSize = 0;
/*     */   
/*     */   int _matchMaxLen;
/*     */   
/*     */   int[] _son;
/*     */   int[] _hash;
/*  15 */   int _cutValue = 255;
/*     */   int _hashMask;
/*  17 */   int _hashSizeSum = 0;
/*     */   
/*     */   boolean HASH_ARRAY = true;
/*     */   
/*     */   static final int kHash2Size = 1024;
/*     */   
/*     */   static final int kHash3Size = 65536;
/*     */   static final int kBT2HashSize = 65536;
/*     */   static final int kStartMaxLen = 1;
/*     */   static final int kHash3Offset = 1024;
/*     */   static final int kEmptyHashValue = 0;
/*     */   static final int kMaxValForNormalize = 1073741823;
/*  29 */   int kNumHashDirectBytes = 0;
/*  30 */   int kMinMatchCheck = 4;
/*  31 */   int kFixHashSize = 66560;
/*     */   
/*     */   public void SetType(int paramInt) {
/*  34 */     this.HASH_ARRAY = (paramInt > 2);
/*  35 */     if (this.HASH_ARRAY) {
/*  36 */       this.kNumHashDirectBytes = 0;
/*  37 */       this.kMinMatchCheck = 4;
/*  38 */       this.kFixHashSize = 66560; return;
/*     */     } 
/*  40 */     this.kNumHashDirectBytes = 2;
/*  41 */     this.kMinMatchCheck = 3;
/*  42 */     this.kFixHashSize = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void Init() {
/*  47 */     super.Init();
/*  48 */     for (byte b = 0; b < this._hashSizeSum; b++)
/*  49 */       this._hash[b] = 0; 
/*  50 */     this._cyclicBufferPos = 0;
/*  51 */     ReduceOffsets(-1);
/*     */   }
/*     */   
/*     */   public void MovePos() {
/*  55 */     if (++this._cyclicBufferPos >= this._cyclicBufferSize) this._cyclicBufferPos = 0; 
/*  56 */     super.MovePos();
/*  57 */     if (this._pos == 1073741823) Normalize(); 
/*     */   }
/*     */   
/*     */   public boolean Create(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  61 */     if (paramInt1 > 1073741567) return false; 
/*  62 */     this._cutValue = 16 + (paramInt3 >> 1);
/*     */     
/*  64 */     int i = (paramInt1 + paramInt2 + paramInt3 + paramInt4) / 2 + 256;
/*     */     
/*  66 */     Create(paramInt1 + paramInt2, paramInt3 + paramInt4, i);
/*     */     
/*  68 */     this._matchMaxLen = paramInt3;
/*     */     
/*  70 */     paramInt2 = paramInt1 + 1;
/*  71 */     if (this._cyclicBufferSize != paramInt2) this._son = new int[(this._cyclicBufferSize = paramInt2) << 1];
/*     */     
/*  73 */     paramInt2 = 65536;
/*     */     
/*  75 */     if (this.HASH_ARRAY) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  83 */       if ((paramInt2 = (paramInt2 = (paramInt2 = (paramInt2 = (paramInt2 = (paramInt2 = (paramInt2 = paramInt1 - 1) | paramInt2 >> 1) | paramInt2 >> 2) | paramInt2 >> 4) | paramInt2 >> 8) >> 1) | 0xFFFF) > 16777216) paramInt2 >>= 1; 
/*  84 */       this._hashMask = paramInt2;
/*  85 */       paramInt2++;
/*  86 */       paramInt2 += this.kFixHashSize;
/*     */     } 
/*  88 */     if (paramInt2 != this._hashSizeSum) this._hash = new int[this._hashSizeSum = paramInt2]; 
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   public int GetMatches(int[] paramArrayOfint) {
/*     */     int i;
/*  94 */     if (this._pos + this._matchMaxLen <= this._streamPos) {
/*  95 */       i = this._matchMaxLen;
/*     */     
/*     */     }
/*  98 */     else if ((i = this._streamPos - this._pos) < this.kMinMatchCheck) {
/*  99 */       MovePos();
/* 100 */       return 0;
/*     */     } 
/*     */ 
/*     */     
/* 104 */     byte b1 = 0;
/* 105 */     byte b2 = (this._pos > this._cyclicBufferSize) ? (this._pos - this._cyclicBufferSize) : 0;
/* 106 */     int j = this._bufferOffset + this._pos;
/* 107 */     int k = 1;
/* 108 */     int n = 0, i1 = 0;
/*     */     
/* 110 */     if (this.HASH_ARRAY) {
/*     */       int i5;
/* 112 */       n = (i5 = CrcTable[this._bufferBase[j] & 0xFF] ^ this._bufferBase[j + 1] & 0xFF) & 0x3FF;
/*     */       
/* 114 */       i1 = (i5 = i5 ^ (this._bufferBase[j + 2] & 0xFF) << 8) & 0xFFFF;
/* 115 */       m = (i5 ^ CrcTable[this._bufferBase[j + 3] & 0xFF] << 5) & this._hashMask;
/*     */     } else {
/* 117 */       m = this._bufferBase[j] & 0xFF ^ (this._bufferBase[j + 1] & 0xFF) << 8;
/*     */     } 
/* 119 */     int i2 = this._hash[this.kFixHashSize + m];
/* 120 */     if (this.HASH_ARRAY) {
/* 121 */       int i5 = this._hash[n];
/* 122 */       int i6 = this._hash[i1 + 1024];
/* 123 */       this._hash[n] = this._pos;
/* 124 */       this._hash[i1 + 1024] = this._pos;
/* 125 */       if (i5 > b2 && this._bufferBase[this._bufferOffset + i5] == this._bufferBase[j]) {
/* 126 */         b1++; paramArrayOfint[0] = k = 2;
/* 127 */         b1++; paramArrayOfint[1] = this._pos - i5 - 1;
/*     */       } 
/* 129 */       if (i6 > b2 && this._bufferBase[this._bufferOffset + i6] == this._bufferBase[j]) {
/* 130 */         if (i6 == i5) b1 -= 2; 
/* 131 */         paramArrayOfint[b1++] = k = 3;
/* 132 */         paramArrayOfint[b1++] = this._pos - i6 - 1;
/* 133 */         i5 = i6;
/*     */       } 
/* 135 */       if (b1 != 0 && i5 == i2) {
/* 136 */         b1 -= 2;
/* 137 */         k = 1;
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     this._hash[this.kFixHashSize + m] = this._pos;
/*     */     
/* 143 */     int i3 = (this._cyclicBufferPos << 1) + 1;
/* 144 */     int i4 = this._cyclicBufferPos << 1;
/*     */ 
/*     */     
/* 147 */     int m = n = this.kNumHashDirectBytes;
/*     */     
/* 149 */     if (this.kNumHashDirectBytes != 0 && 
/* 150 */       i2 > b2 && 
/* 151 */       this._bufferBase[this._bufferOffset + i2 + this.kNumHashDirectBytes] != this._bufferBase[j + this.kNumHashDirectBytes]) {
/* 152 */       paramArrayOfint[b1++] = k = this.kNumHashDirectBytes;
/* 153 */       paramArrayOfint[b1++] = this._pos - i2 - 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 158 */     i1 = this._cutValue;
/*     */     
/*     */     while (true) {
/* 161 */       if (i2 <= b2 || i1-- == 0) {
/* 162 */         this._son[i4] = 0; this._son[i3] = 0;
/*     */         
/*     */         break;
/*     */       } 
/*     */       
/* 167 */       int i5, i6 = (((i5 = this._pos - i2) <= this._cyclicBufferPos) ? (this._cyclicBufferPos - i5) : (this._cyclicBufferPos - i5 + this._cyclicBufferSize)) << 1;
/*     */       
/* 169 */       int i7 = this._bufferOffset + i2;
/* 170 */       int i8 = Math.min(m, n);
/* 171 */       if (this._bufferBase[i7 + i8] == this._bufferBase[j + i8]) { do {  }
/* 172 */         while (++i8 != i && 
/* 173 */           this._bufferBase[i7 + i8] == this._bufferBase[j + i8]);
/* 174 */         if (k < i8) {
/* 175 */           paramArrayOfint[b1++] = k = i8;
/* 176 */           paramArrayOfint[b1++] = i5 - 1;
/* 177 */           if (i8 == i) {
/* 178 */             this._son[i4] = this._son[i6];
/* 179 */             this._son[i3] = this._son[i6 + 1];
/*     */             break;
/*     */           } 
/*     */         }  }
/*     */       
/* 184 */       if ((this._bufferBase[i7 + i8] & 0xFF) < (this._bufferBase[j + i8] & 0xFF)) {
/* 185 */         this._son[i4] = i2;
/* 186 */         i4 = i6 + 1;
/* 187 */         i2 = this._son[i4];
/* 188 */         n = i8; continue;
/*     */       } 
/* 190 */       this._son[i3] = i2;
/* 191 */       i3 = i6;
/* 192 */       i2 = this._son[i3];
/* 193 */       m = i8;
/*     */     } 
/*     */     
/* 196 */     MovePos();
/* 197 */     return b1;
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
/*     */   public void Skip(int paramInt) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield _pos : I
/*     */     //   4: aload_0
/*     */     //   5: getfield _matchMaxLen : I
/*     */     //   8: iadd
/*     */     //   9: aload_0
/*     */     //   10: getfield _streamPos : I
/*     */     //   13: if_icmpgt -> 24
/*     */     //   16: aload_0
/*     */     //   17: getfield _matchMaxLen : I
/*     */     //   20: istore_2
/*     */     //   21: goto -> 42
/*     */     //   24: aload_0
/*     */     //   25: getfield _streamPos : I
/*     */     //   28: aload_0
/*     */     //   29: getfield _pos : I
/*     */     //   32: isub
/*     */     //   33: dup
/*     */     //   34: istore_2
/*     */     //   35: aload_0
/*     */     //   36: getfield kMinMatchCheck : I
/*     */     //   39: if_icmplt -> 571
/*     */     //   42: aload_0
/*     */     //   43: getfield _pos : I
/*     */     //   46: aload_0
/*     */     //   47: getfield _cyclicBufferSize : I
/*     */     //   50: if_icmple -> 65
/*     */     //   53: aload_0
/*     */     //   54: getfield _pos : I
/*     */     //   57: aload_0
/*     */     //   58: getfield _cyclicBufferSize : I
/*     */     //   61: isub
/*     */     //   62: goto -> 66
/*     */     //   65: iconst_0
/*     */     //   66: istore_3
/*     */     //   67: aload_0
/*     */     //   68: getfield _bufferOffset : I
/*     */     //   71: aload_0
/*     */     //   72: getfield _pos : I
/*     */     //   75: iadd
/*     */     //   76: istore #4
/*     */     //   78: aload_0
/*     */     //   79: getfield HASH_ARRAY : Z
/*     */     //   82: ifeq -> 208
/*     */     //   85: getstatic com/badlogic/gdx/utils/compression/lz/BinTree.CrcTable : [I
/*     */     //   88: aload_0
/*     */     //   89: getfield _bufferBase : [B
/*     */     //   92: iload #4
/*     */     //   94: baload
/*     */     //   95: sipush #255
/*     */     //   98: iand
/*     */     //   99: iaload
/*     */     //   100: aload_0
/*     */     //   101: getfield _bufferBase : [B
/*     */     //   104: iload #4
/*     */     //   106: iconst_1
/*     */     //   107: iadd
/*     */     //   108: baload
/*     */     //   109: sipush #255
/*     */     //   112: iand
/*     */     //   113: ixor
/*     */     //   114: dup
/*     */     //   115: istore #6
/*     */     //   117: sipush #1023
/*     */     //   120: iand
/*     */     //   121: istore #5
/*     */     //   123: aload_0
/*     */     //   124: getfield _hash : [I
/*     */     //   127: iload #5
/*     */     //   129: aload_0
/*     */     //   130: getfield _pos : I
/*     */     //   133: iastore
/*     */     //   134: iload #6
/*     */     //   136: aload_0
/*     */     //   137: getfield _bufferBase : [B
/*     */     //   140: iload #4
/*     */     //   142: iconst_2
/*     */     //   143: iadd
/*     */     //   144: baload
/*     */     //   145: sipush #255
/*     */     //   148: iand
/*     */     //   149: bipush #8
/*     */     //   151: ishl
/*     */     //   152: ixor
/*     */     //   153: dup
/*     */     //   154: istore #6
/*     */     //   156: ldc 65535
/*     */     //   158: iand
/*     */     //   159: istore #7
/*     */     //   161: aload_0
/*     */     //   162: getfield _hash : [I
/*     */     //   165: iload #7
/*     */     //   167: sipush #1024
/*     */     //   170: iadd
/*     */     //   171: aload_0
/*     */     //   172: getfield _pos : I
/*     */     //   175: iastore
/*     */     //   176: iload #6
/*     */     //   178: getstatic com/badlogic/gdx/utils/compression/lz/BinTree.CrcTable : [I
/*     */     //   181: aload_0
/*     */     //   182: getfield _bufferBase : [B
/*     */     //   185: iload #4
/*     */     //   187: iconst_3
/*     */     //   188: iadd
/*     */     //   189: baload
/*     */     //   190: sipush #255
/*     */     //   193: iand
/*     */     //   194: iaload
/*     */     //   195: iconst_5
/*     */     //   196: ishl
/*     */     //   197: ixor
/*     */     //   198: aload_0
/*     */     //   199: getfield _hashMask : I
/*     */     //   202: iand
/*     */     //   203: istore #5
/*     */     //   205: goto -> 238
/*     */     //   208: aload_0
/*     */     //   209: getfield _bufferBase : [B
/*     */     //   212: iload #4
/*     */     //   214: baload
/*     */     //   215: sipush #255
/*     */     //   218: iand
/*     */     //   219: aload_0
/*     */     //   220: getfield _bufferBase : [B
/*     */     //   223: iload #4
/*     */     //   225: iconst_1
/*     */     //   226: iadd
/*     */     //   227: baload
/*     */     //   228: sipush #255
/*     */     //   231: iand
/*     */     //   232: bipush #8
/*     */     //   234: ishl
/*     */     //   235: ixor
/*     */     //   236: istore #5
/*     */     //   238: aload_0
/*     */     //   239: getfield _hash : [I
/*     */     //   242: aload_0
/*     */     //   243: getfield kFixHashSize : I
/*     */     //   246: iload #5
/*     */     //   248: iadd
/*     */     //   249: iaload
/*     */     //   250: istore #6
/*     */     //   252: aload_0
/*     */     //   253: getfield _hash : [I
/*     */     //   256: aload_0
/*     */     //   257: getfield kFixHashSize : I
/*     */     //   260: iload #5
/*     */     //   262: iadd
/*     */     //   263: aload_0
/*     */     //   264: getfield _pos : I
/*     */     //   267: iastore
/*     */     //   268: aload_0
/*     */     //   269: getfield _cyclicBufferPos : I
/*     */     //   272: iconst_1
/*     */     //   273: ishl
/*     */     //   274: iconst_1
/*     */     //   275: iadd
/*     */     //   276: istore #5
/*     */     //   278: aload_0
/*     */     //   279: getfield _cyclicBufferPos : I
/*     */     //   282: iconst_1
/*     */     //   283: ishl
/*     */     //   284: istore #7
/*     */     //   286: aload_0
/*     */     //   287: getfield kNumHashDirectBytes : I
/*     */     //   290: dup
/*     */     //   291: istore #9
/*     */     //   293: istore #8
/*     */     //   295: aload_0
/*     */     //   296: getfield _cutValue : I
/*     */     //   299: istore #10
/*     */     //   301: iload #6
/*     */     //   303: iload_3
/*     */     //   304: if_icmple -> 315
/*     */     //   307: iload #10
/*     */     //   309: iinc #10, -1
/*     */     //   312: ifne -> 331
/*     */     //   315: iload #5
/*     */     //   317: aload_0
/*     */     //   318: getfield _son : [I
/*     */     //   321: dup_x1
/*     */     //   322: iload #7
/*     */     //   324: iconst_0
/*     */     //   325: dup_x2
/*     */     //   326: iastore
/*     */     //   327: iastore
/*     */     //   328: goto -> 571
/*     */     //   331: aload_0
/*     */     //   332: getfield _pos : I
/*     */     //   335: iload #6
/*     */     //   337: isub
/*     */     //   338: dup
/*     */     //   339: istore #11
/*     */     //   341: aload_0
/*     */     //   342: getfield _cyclicBufferPos : I
/*     */     //   345: if_icmpgt -> 358
/*     */     //   348: aload_0
/*     */     //   349: getfield _cyclicBufferPos : I
/*     */     //   352: iload #11
/*     */     //   354: isub
/*     */     //   355: goto -> 370
/*     */     //   358: aload_0
/*     */     //   359: getfield _cyclicBufferPos : I
/*     */     //   362: iload #11
/*     */     //   364: isub
/*     */     //   365: aload_0
/*     */     //   366: getfield _cyclicBufferSize : I
/*     */     //   369: iadd
/*     */     //   370: iconst_1
/*     */     //   371: ishl
/*     */     //   372: istore #11
/*     */     //   374: aload_0
/*     */     //   375: getfield _bufferOffset : I
/*     */     //   378: iload #6
/*     */     //   380: iadd
/*     */     //   381: istore #12
/*     */     //   383: iload #8
/*     */     //   385: iload #9
/*     */     //   387: invokestatic min : (II)I
/*     */     //   390: istore #13
/*     */     //   392: aload_0
/*     */     //   393: getfield _bufferBase : [B
/*     */     //   396: iload #12
/*     */     //   398: iload #13
/*     */     //   400: iadd
/*     */     //   401: baload
/*     */     //   402: aload_0
/*     */     //   403: getfield _bufferBase : [B
/*     */     //   406: iload #4
/*     */     //   408: iload #13
/*     */     //   410: iadd
/*     */     //   411: baload
/*     */     //   412: if_icmpne -> 480
/*     */     //   415: iinc #13, 1
/*     */     //   418: iload #13
/*     */     //   420: iload_2
/*     */     //   421: if_icmpeq -> 447
/*     */     //   424: aload_0
/*     */     //   425: getfield _bufferBase : [B
/*     */     //   428: iload #12
/*     */     //   430: iload #13
/*     */     //   432: iadd
/*     */     //   433: baload
/*     */     //   434: aload_0
/*     */     //   435: getfield _bufferBase : [B
/*     */     //   438: iload #4
/*     */     //   440: iload #13
/*     */     //   442: iadd
/*     */     //   443: baload
/*     */     //   444: if_icmpeq -> 415
/*     */     //   447: iload #13
/*     */     //   449: iload_2
/*     */     //   450: if_icmpne -> 480
/*     */     //   453: iload #7
/*     */     //   455: aload_0
/*     */     //   456: getfield _son : [I
/*     */     //   459: dup_x1
/*     */     //   460: iload #11
/*     */     //   462: iaload
/*     */     //   463: iastore
/*     */     //   464: iload #5
/*     */     //   466: aload_0
/*     */     //   467: getfield _son : [I
/*     */     //   470: dup_x1
/*     */     //   471: iload #11
/*     */     //   473: iconst_1
/*     */     //   474: iadd
/*     */     //   475: iaload
/*     */     //   476: iastore
/*     */     //   477: goto -> 571
/*     */     //   480: aload_0
/*     */     //   481: getfield _bufferBase : [B
/*     */     //   484: iload #12
/*     */     //   486: iload #13
/*     */     //   488: iadd
/*     */     //   489: baload
/*     */     //   490: sipush #255
/*     */     //   493: iand
/*     */     //   494: aload_0
/*     */     //   495: getfield _bufferBase : [B
/*     */     //   498: iload #4
/*     */     //   500: iload #13
/*     */     //   502: iadd
/*     */     //   503: baload
/*     */     //   504: sipush #255
/*     */     //   507: iand
/*     */     //   508: if_icmpge -> 542
/*     */     //   511: aload_0
/*     */     //   512: getfield _son : [I
/*     */     //   515: iload #7
/*     */     //   517: iload #6
/*     */     //   519: iastore
/*     */     //   520: iload #11
/*     */     //   522: iconst_1
/*     */     //   523: iadd
/*     */     //   524: istore #7
/*     */     //   526: aload_0
/*     */     //   527: getfield _son : [I
/*     */     //   530: iload #7
/*     */     //   532: iaload
/*     */     //   533: istore #6
/*     */     //   535: iload #13
/*     */     //   537: istore #9
/*     */     //   539: goto -> 301
/*     */     //   542: aload_0
/*     */     //   543: getfield _son : [I
/*     */     //   546: iload #5
/*     */     //   548: iload #6
/*     */     //   550: iastore
/*     */     //   551: iload #11
/*     */     //   553: istore #5
/*     */     //   555: aload_0
/*     */     //   556: getfield _son : [I
/*     */     //   559: iload #5
/*     */     //   561: iaload
/*     */     //   562: istore #6
/*     */     //   564: iload #13
/*     */     //   566: istore #8
/*     */     //   568: goto -> 301
/*     */     //   571: aload_0
/*     */     //   572: invokevirtual MovePos : ()V
/*     */     //   575: iinc #1, -1
/*     */     //   578: iload_1
/*     */     //   579: ifne -> 0
/*     */     //   582: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #203	-> 0
/*     */     //   #204	-> 16
/*     */     //   #206	-> 24
/*     */     //   #207	-> 34
/*     */     //   #213	-> 42
/*     */     //   #214	-> 67
/*     */     //   #218	-> 78
/*     */     //   #219	-> 85
/*     */     //   #220	-> 115
/*     */     //   #221	-> 123
/*     */     //   #222	-> 134
/*     */     //   #223	-> 154
/*     */     //   #224	-> 161
/*     */     //   #225	-> 176
/*     */     //   #226	-> 205
/*     */     //   #227	-> 208
/*     */     //   #229	-> 238
/*     */     //   #230	-> 252
/*     */     //   #232	-> 268
/*     */     //   #233	-> 278
/*     */     //   #236	-> 286
/*     */     //   #238	-> 295
/*     */     //   #240	-> 301
/*     */     //   #241	-> 315
/*     */     //   #242	-> 328
/*     */     //   #245	-> 331
/*     */     //   #246	-> 339
/*     */     //   #247	-> 358
/*     */     //   #249	-> 374
/*     */     //   #250	-> 383
/*     */     //   #251	-> 392
/*     */     //   #252	-> 415
/*     */     //   #253	-> 424
/*     */     //   #254	-> 447
/*     */     //   #255	-> 453
/*     */     //   #256	-> 464
/*     */     //   #257	-> 477
/*     */     //   #260	-> 480
/*     */     //   #261	-> 511
/*     */     //   #262	-> 520
/*     */     //   #263	-> 526
/*     */     //   #264	-> 535
/*     */     //   #266	-> 542
/*     */     //   #267	-> 551
/*     */     //   #268	-> 555
/*     */     //   #269	-> 564
/*     */     //   #271	-> 568
/*     */     //   #272	-> 571
/*     */     //   #273	-> 575
/*     */     //   #274	-> 582
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
/*     */   void NormalizeLinks(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 277 */     for (byte b = 0; b < paramInt1; b++) {
/*     */       int i;
/* 279 */       if ((i = paramArrayOfint[b]) <= paramInt2) {
/* 280 */         i = 0;
/*     */       } else {
/* 282 */         i -= paramInt2;
/* 283 */       }  paramArrayOfint[b] = i;
/*     */     } 
/*     */   }
/*     */   
/*     */   void Normalize() {
/* 288 */     int i = this._pos - this._cyclicBufferSize;
/* 289 */     NormalizeLinks(this._son, this._cyclicBufferSize << 1, i);
/* 290 */     NormalizeLinks(this._hash, this._hashSizeSum, i);
/* 291 */     ReduceOffsets(i);
/*     */   }
/*     */   
/*     */   public void SetCutValue(int paramInt) {
/* 295 */     this._cutValue = paramInt;
/*     */   }
/*     */   
/* 298 */   private static final int[] CrcTable = new int[256];
/*     */   
/*     */   static {
/* 301 */     for (byte b = 0; b < 'Ā'; b++) {
/* 302 */       int i = b;
/* 303 */       for (byte b1 = 0; b1 < 8; b1++) {
/* 304 */         if ((i & 0x1) != 0)
/* 305 */         { i = i >>> 1 ^ 0xEDB88320; }
/*     */         else
/* 307 */         { i >>>= 1; } 
/* 308 */       }  CrcTable[b] = i;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\lz\BinTree.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */