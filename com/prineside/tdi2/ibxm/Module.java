/*     */ package com.prineside.tdi2.ibxm;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ByteArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.Locale;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ 
/*     */ 
/*     */ public class Module
/*     */ {
/*  24 */   public String songName = "Blank";
/*  25 */   public int numChannels = 4, numInstruments = 1;
/*  26 */   public int numPatterns = 1, sequenceLength = 1, restartPos = 0;
/*  27 */   public int defaultGVol = 64; public int defaultSpeed = 6; public int defaultTempo = 125; public int c2Rate = 8287; public int gain = 64; public boolean linearPeriods = false;
/*     */   public boolean fastVolSlides = false;
/*  29 */   public int[] defaultPanning = new int[] { 51, 204, 204, 51 };
/*  30 */   public int[] sequence = new int[] { 0 };
/*  31 */   public Pattern[] patterns = new Pattern[] { new Pattern(4, 64) };
/*  32 */   public Instrument[] instruments = new Instrument[] { new Instrument(), new Instrument() };
/*  33 */   private String a = "mod";
/*     */   
/*  35 */   private Float b = null;
/*     */   
/*  37 */   private static final byte[] c = new byte[4096];
/*     */   
/*     */   public Module() {}
/*     */   
/*     */   public Module(Module paramModule) {
/*  42 */     this.songName = paramModule.songName;
/*  43 */     this.numChannels = paramModule.numChannels;
/*  44 */     this.numInstruments = paramModule.numInstruments;
/*  45 */     this.numPatterns = paramModule.numPatterns;
/*  46 */     this.sequenceLength = paramModule.sequenceLength;
/*  47 */     this.restartPos = paramModule.restartPos;
/*  48 */     this.defaultGVol = paramModule.defaultGVol;
/*  49 */     this.defaultSpeed = paramModule.defaultSpeed;
/*  50 */     this.defaultTempo = paramModule.defaultTempo;
/*  51 */     this.c2Rate = paramModule.c2Rate;
/*  52 */     this.gain = paramModule.gain;
/*  53 */     this.linearPeriods = paramModule.linearPeriods;
/*  54 */     this.fastVolSlides = paramModule.fastVolSlides;
/*  55 */     this.defaultPanning = new int[paramModule.defaultPanning.length];
/*  56 */     System.arraycopy(paramModule.defaultPanning, 0, this.defaultPanning, 0, this.defaultPanning.length);
/*  57 */     this.sequence = new int[paramModule.sequence.length];
/*  58 */     System.arraycopy(paramModule.sequence, 0, this.sequence, 0, this.sequence.length);
/*  59 */     this.patterns = new Pattern[paramModule.patterns.length]; byte b;
/*  60 */     for (b = 0; b < paramModule.patterns.length; b++) {
/*  61 */       this.patterns[b] = new Pattern(paramModule.patterns[b]);
/*     */     }
/*  63 */     this.instruments = new Instrument[paramModule.instruments.length];
/*  64 */     for (b = 0; b < paramModule.instruments.length; b++) {
/*  65 */       this.instruments[b] = new Instrument(paramModule.instruments[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int moduleHashCode() {
/*     */     int i;
/*  77 */     return i = (i = (i = (i = (i = 31 + this.songName.hashCode()) * 31 + this.numChannels) * 31 + this.numInstruments) * 31 + this.numPatterns) * 31 + this.sequenceLength;
/*     */   }
/*     */   
/*     */   public String getFileExtension() {
/*  81 */     return this.a;
/*     */   }
/*     */   public static Module fromZipInputStream(InputStream paramInputStream) {
/*     */     Module module;
/*  85 */     ByteArray byteArray = null;
/*     */     
/*     */     try {
/*     */       ZipEntry zipEntry;
/*  89 */       if ((zipEntry = (paramInputStream = new ZipInputStream(paramInputStream)).getNextEntry()) != null) {
/*     */         
/*  91 */         byteArray = new ByteArray();
/*     */         
/*  93 */         synchronized (c) {
/*  94 */           int i; while ((i = paramInputStream.read(c)) != -1) {
/*  95 */             byteArray.addAll(c, 0, i);
/*     */           }
/*     */         } 
/*  98 */         paramInputStream.closeEntry();
/*     */         
/* 100 */         module = new Module(byteArray.toArray());
/*     */       } 
/* 102 */       paramInputStream.close();
/* 103 */     } catch (Exception exception) {
/* 104 */       throw new IllegalArgumentException("failed to load module from zip input stream", exception);
/*     */     } 
/*     */     
/* 107 */     return module;
/*     */   }
/*     */   
/*     */   public Module(InputStream paramInputStream) {
/* 111 */     this(new Data(paramInputStream));
/*     */   }
/*     */   
/*     */   public Module(Data paramData) {
/* 115 */     if (paramData.strLatin1(0, 17).equals("Extended Module: ")) {
/* 116 */       c(paramData); return;
/* 117 */     }  if (paramData.strLatin1(44, 4).equals("SCRM")) {
/* 118 */       b(paramData); return;
/*     */     } 
/* 120 */     a(paramData);
/*     */   }
/*     */ 
/*     */   
/*     */   public Module(byte[] paramArrayOfbyte) {
/* 125 */     this(new Data(paramArrayOfbyte));
/*     */   }
/*     */   
/*     */   private void a(Data paramData) {
/* 129 */     this.a = "mod";
/* 130 */     this.songName = paramData.strLatin1(0, 20);
/* 131 */     this.sequenceLength = paramData.uByte(950) & 0x7F;
/* 132 */     this.restartPos = paramData.uByte(951) & 0x7F;
/* 133 */     if (this.restartPos >= this.sequenceLength) this.restartPos = 0; 
/* 134 */     this.sequence = new int[128]; int i;
/* 135 */     for (i = 0; i < 128; i++) {
/* 136 */       int j = paramData.uByte(i + 952) & 0x7F;
/* 137 */       this.sequence[i] = j;
/* 138 */       if (j >= this.numPatterns) this.numPatterns = j + 1; 
/*     */     } 
/* 140 */     switch (paramData.ubeShort(1082)) {
/*     */       case 19233:
/*     */       case 19246:
/*     */       case 21556:
/* 144 */         this.numChannels = 4;
/* 145 */         this.c2Rate = 8287;
/* 146 */         this.gain = 64;
/*     */         break;
/*     */       case 18510:
/* 149 */         this.numChannels = paramData.uByte(1080) - 48;
/* 150 */         this.c2Rate = 8363;
/* 151 */         this.gain = 32;
/*     */         break;
/*     */       case 17224:
/* 154 */         this.numChannels = (paramData.uByte(1080) - 48) * 10;
/* 155 */         this.numChannels += paramData.uByte(1081) - 48;
/* 156 */         this.c2Rate = 8363;
/* 157 */         this.gain = 32;
/*     */         break;
/*     */       default:
/* 160 */         throw new IllegalArgumentException("MOD Format not recognised!");
/*     */     } 
/* 162 */     this.defaultGVol = 64;
/* 163 */     this.defaultSpeed = 6;
/* 164 */     this.defaultTempo = 125;
/* 165 */     this.defaultPanning = new int[this.numChannels];
/* 166 */     for (i = 0; i < this.numChannels; i++) {
/* 167 */       this.defaultPanning[i] = 51;
/* 168 */       if ((i & 0x3) == 1 || (i & 0x3) == 2)
/* 169 */         this.defaultPanning[i] = 204; 
/*     */     } 
/* 171 */     i = 1084;
/* 172 */     this.patterns = new Pattern[this.numPatterns]; byte b;
/* 173 */     for (b = 0; b < this.numPatterns; b++) {
/* 174 */       Pattern pattern = this.patterns[b] = new Pattern(this.numChannels, 64);
/* 175 */       for (byte b1 = 0; b1 < pattern.data.length; b1 += 5) {
/*     */         int j;
/*     */         
/* 178 */         if ((j = ((j = (paramData.uByte(i) & 0xF) << 8) | paramData.uByte(i + 1)) << 2) >= 112 && j <= 6848) {
/*     */           
/* 180 */           int n = (n = -12 * Channel.log2((j << 15) / 29021)) + (n & 0x4000) >> 15;
/* 181 */           pattern.data[b1] = (byte)n;
/*     */         } 
/*     */         
/* 184 */         int k = (k = (paramData.uByte(i + 2) & 0xF0) >> 4) | paramData.uByte(i) & 0x10;
/* 185 */         pattern.data[b1 + 1] = (byte)k;
/* 186 */         k = paramData.uByte(i + 2) & 0xF;
/*     */         int m;
/* 188 */         if ((m = paramData.uByte(i + 3)) == 0 && (k < 3 || k == 10)) k = 0; 
/* 189 */         if (m == 0 && (k == 5 || k == 6)) k -= 2; 
/* 190 */         if (k == 8 && this.numChannels == 4) k = m = 0; 
/* 191 */         pattern.data[b1 + 3] = (byte)k;
/* 192 */         pattern.data[b1 + 4] = (byte)m;
/* 193 */         i += '\004';
/*     */       } 
/*     */     } 
/* 196 */     this.numInstruments = 31;
/* 197 */     this.instruments = new Instrument[this.numInstruments + 1];
/* 198 */     this.instruments[0] = new Instrument();
/* 199 */     for (b = 1; b <= this.numInstruments; b++) {
/* 200 */       this.instruments[b] = new Instrument(); Instrument instrument;
/* 201 */       Sample sample = (instrument = new Instrument()).samples[0];
/* 202 */       instrument.name = paramData.strLatin1(b * 30 - 10, 22);
/* 203 */       int k = paramData.ubeShort(b * 30 + 12) << 1;
/* 204 */       int m = (paramData.uByte(b * 30 + 14) & 0xF) << 4;
/* 205 */       sample.fineTune = (m < 128) ? m : (m - 256);
/* 206 */       m = paramData.uByte(b * 30 + 15) & 0x7F;
/* 207 */       sample.volume = (m <= 64) ? m : 64;
/* 208 */       sample.panning = -1;
/* 209 */       int n = paramData.ubeShort(b * 30 + 16) << 1;
/* 210 */       int j = paramData.ubeShort(b * 30 + 18) << 1;
/* 211 */       if (n + j > k) {
/* 212 */         if (n / 2 + j <= k) {
/*     */           
/* 214 */           n /= 2;
/*     */         } else {
/* 216 */           j = k - n;
/*     */         } 
/*     */       }
/* 219 */       if (j < 4) {
/* 220 */         n = k;
/* 221 */         j = 0;
/*     */       } 
/* 223 */       sample.setSampleData(paramData.samS8(i, k), n, j, false);
/* 224 */       i += k;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(Data paramData) {
/* 229 */     this.a = "s3m";
/* 230 */     this.songName = paramData.strCp850(0, 28);
/* 231 */     this.sequenceLength = paramData.uleShort(32);
/* 232 */     this.numInstruments = paramData.uleShort(34);
/* 233 */     this.numPatterns = paramData.uleShort(36);
/* 234 */     int i = paramData.uleShort(38);
/* 235 */     int j = paramData.uleShort(40);
/* 236 */     this.fastVolSlides = ((i & 0x40) == 64 || j == 4864);
/* 237 */     i = (paramData.uleShort(42) == 1) ? 1 : 0;
/* 238 */     if (paramData.uleInt(44) != 1297236819)
/* 239 */       throw new IllegalArgumentException("Not an S3M file!"); 
/* 240 */     this.defaultGVol = paramData.uByte(48);
/* 241 */     this.defaultSpeed = paramData.uByte(49);
/* 242 */     this.defaultTempo = paramData.uByte(50);
/* 243 */     this.c2Rate = 8363;
/* 244 */     this.gain = paramData.uByte(51) & 0x7F;
/* 245 */     j = ((paramData.uByte(51) & 0x80) == 128) ? 1 : 0;
/* 246 */     boolean bool = (paramData.uByte(53) == 252) ? true : false;
/* 247 */     this.numChannels = 0;
/* 248 */     int[] arrayOfInt = new int[32]; int k;
/* 249 */     for (k = 0; k < 32; k++) {
/* 250 */       arrayOfInt[k] = -1;
/* 251 */       if (paramData.uByte(k + 64) < 16)
/* 252 */         arrayOfInt[k] = this.numChannels++; 
/*     */     } 
/* 254 */     this.sequence = new int[this.sequenceLength];
/* 255 */     for (k = 0; k < this.sequenceLength; k++)
/* 256 */       this.sequence[k] = paramData.uByte(k + 96); 
/* 257 */     k = 96 + this.sequenceLength;
/* 258 */     this.instruments = new Instrument[this.numInstruments + 1];
/* 259 */     this.instruments[0] = new Instrument(); byte b;
/* 260 */     for (b = 1; b <= this.numInstruments; b++) {
/* 261 */       this.instruments[b] = new Instrument(); Instrument instrument;
/* 262 */       Sample sample = (instrument = new Instrument()).samples[0];
/* 263 */       int m = paramData.uleShort(k) << 4;
/* 264 */       k += 2;
/* 265 */       instrument.name = paramData.strCp850(m + 48, 28);
/* 266 */       if (paramData.uByte(m) == 1 && 
/* 267 */         paramData.uleShort(m + 76) == 17235) {
/*     */         
/* 269 */         int i1 = (i1 = paramData.uByte(m + 13) << 20) + (paramData.uleShort(m + 14) << 4);
/* 270 */         int i2 = paramData.uleInt(m + 16);
/* 271 */         int i3 = paramData.uleInt(m + 20);
/* 272 */         int i4 = paramData.uleInt(m + 24) - i3;
/* 273 */         sample.volume = paramData.uByte(m + 28);
/* 274 */         sample.panning = -1;
/* 275 */         boolean bool1 = (paramData.uByte(m + 30) != 0) ? true : false;
/* 276 */         boolean bool2 = ((paramData.uByte(m + 31) & 0x1) == 1) ? true : false;
/* 277 */         if (i3 + i4 > i2)
/* 278 */           i4 = i2 - i3; 
/* 279 */         if (i4 <= 0 || !bool2) {
/* 280 */           i3 = i2;
/* 281 */           i4 = 0;
/*     */         } 
/* 283 */         paramData.uByte(m + 31);
/* 284 */         boolean bool3 = ((paramData.uByte(m + 31) & 0x4) == 4) ? true : false;
/* 285 */         if (bool1) throw new IllegalArgumentException("Packed samples not supported!");
/*     */         
/* 287 */         int n = (Channel.log2(n = paramData.uleInt(m + 32)) - Channel.log2(this.c2Rate)) * 12;
/* 288 */         sample.relNote = n >> 15;
/* 289 */         sample.fineTune = (n & 0x7FFF) >> 8;
/* 290 */         if (bool3) {
/* 291 */           if (i != 0) {
/* 292 */             sample.setSampleData(paramData.samS16(i1, i2), i3, i4, false);
/*     */           } else {
/* 294 */             sample.setSampleData(paramData.samU16(i1, i2), i3, i4, false);
/*     */           }
/*     */         
/* 297 */         } else if (i != 0) {
/* 298 */           sample.setSampleData(paramData.samS8(i1, i2), i3, i4, false);
/*     */         } else {
/* 300 */           sample.setSampleData(paramData.samU8(i1, i2), i3, i4, false);
/*     */         } 
/*     */       } 
/*     */     } 
/* 304 */     this.patterns = new Pattern[this.numPatterns];
/* 305 */     for (b = 0; b < this.numPatterns; b++) {
/* 306 */       Pattern pattern = this.patterns[b] = new Pattern(this.numChannels, 64);
/* 307 */       int m = (paramData.uleShort(k) << 4) + 2;
/* 308 */       byte b1 = 0;
/* 309 */       while (b1 < 64) {
/*     */         int n;
/* 311 */         if ((n = paramData.uByte(m++)) == 0) {
/* 312 */           b1++;
/*     */           continue;
/*     */         } 
/* 315 */         int i1 = 0;
/* 316 */         int i2 = 0;
/* 317 */         if ((n & 0x20) == 32) {
/* 318 */           i1 = paramData.uByte(m++);
/* 319 */           i2 = paramData.uByte(m++);
/* 320 */           if (i1 < 254)
/* 321 */             i1 = (i1 >> 4) * 12 + (i1 & 0xF) + 1; 
/* 322 */           if (i1 == 255) i1 = 0; 
/*     */         } 
/* 324 */         int i3 = 0;
/* 325 */         if ((n & 0x40) == 64 && (
/*     */           
/* 327 */           i3 = (paramData.uByte(m++) & 0x7F) + 16) > 80) i3 = 0;
/*     */         
/* 329 */         int i4 = 0;
/* 330 */         int i5 = 0;
/* 331 */         if ((n & 0x80) == 128) {
/* 332 */           i4 = paramData.uByte(m++);
/* 333 */           i5 = paramData.uByte(m++);
/* 334 */           if (i4 <= 0 || i4 >= 64)
/* 335 */             i4 = i5 = 0; 
/* 336 */           if (i4 > 0) i4 += 128;
/*     */         
/*     */         } 
/* 339 */         if ((i = arrayOfInt[n & 0x1F]) >= 0) {
/* 340 */           int i6 = (b1 * this.numChannels + i) * 5;
/* 341 */           pattern.data[i6] = (byte)i1;
/* 342 */           pattern.data[i6 + 1] = (byte)i2;
/* 343 */           pattern.data[i6 + 2] = (byte)i3;
/* 344 */           pattern.data[i6 + 3] = (byte)i4;
/* 345 */           pattern.data[i6 + 4] = (byte)i5;
/*     */         } 
/*     */       } 
/* 348 */       k += 2;
/*     */     } 
/* 350 */     this.defaultPanning = new int[this.numChannels];
/* 351 */     for (b = 0; b < 32; b++) {
/* 352 */       if (arrayOfInt[b] >= 0) {
/* 353 */         int m = 7;
/* 354 */         if (j != 0) {
/* 355 */           m = 12;
/* 356 */           if (paramData.uByte(b + 64) < 8) m = 3; 
/*     */         }  int n;
/* 358 */         if (bool && ((
/*     */           
/* 360 */           n = paramData.uByte(k + b)) & 0x20) == 32) m = n & 0xF;
/*     */         
/* 362 */         this.defaultPanning[arrayOfInt[b]] = m * 17;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private void c(Data paramData) {
/* 367 */     this.a = "xm";
/* 368 */     if (paramData.uleShort(58) != 260)
/* 369 */       throw new IllegalArgumentException("XM format version must be 0x0104!"); 
/* 370 */     this.songName = paramData.strCp850(17, 20);
/* 371 */     boolean bool = paramData.strLatin1(38, 20).startsWith("DigiBooster Pro");
/* 372 */     int i = 60 + paramData.uleInt(60);
/* 373 */     this.sequenceLength = paramData.uleShort(64);
/* 374 */     this.restartPos = paramData.uleShort(66);
/* 375 */     this.numChannels = paramData.uleShort(68);
/* 376 */     this.numPatterns = paramData.uleShort(70);
/* 377 */     this.numInstruments = paramData.uleShort(72);
/* 378 */     this.linearPeriods = ((paramData.uleShort(74) & 0x1) > 0);
/* 379 */     this.defaultGVol = 64;
/* 380 */     this.defaultSpeed = paramData.uleShort(76);
/* 381 */     this.defaultTempo = paramData.uleShort(78);
/* 382 */     this.c2Rate = 8363;
/* 383 */     this.gain = 64;
/* 384 */     this.defaultPanning = new int[this.numChannels]; byte b;
/* 385 */     for (b = 0; b < this.numChannels; ) { this.defaultPanning[b] = 128; b++; }
/* 386 */      this.sequence = new int[this.sequenceLength];
/* 387 */     for (b = 0; b < this.sequenceLength; b++) {
/* 388 */       int j = paramData.uByte(b + 80);
/* 389 */       this.sequence[b] = (j < this.numPatterns) ? j : 0;
/*     */     } 
/* 391 */     this.patterns = new Pattern[this.numPatterns];
/* 392 */     for (b = 0; b < this.numPatterns; b++) {
/* 393 */       if (paramData.uByte(i + 4) != 0)
/* 394 */         throw new IllegalArgumentException("Unknown pattern packing type!"); 
/*     */       int j;
/* 396 */       if ((j = paramData.uleShort(i + 5)) <= 0) {
/* 397 */         j = 1;
/*     */       }
/* 399 */       int k = j * this.numChannels;
/* 400 */       Pattern pattern = this.patterns[b] = new Pattern(this.numChannels, j);
/* 401 */       int m = paramData.uleShort(i + 7);
/*     */       
/* 403 */       int n = (i = i + paramData.uleInt(i)) + m;
/* 404 */       if (m > 0) {
/* 405 */         byte b1 = 0;
/* 406 */         for (byte b2 = 0; b2 < k; b2++) {
/*     */           int i1;
/* 408 */           if (((i1 = paramData.uByte(i)) & 0x80) == 0) { i1 = 31; } else { i++; }
/* 409 */            boolean bool1 = ((i1 & 0x1) > 0) ? paramData.sByte(i++) : false;
/* 410 */           pattern.data[b1++] = bool1;
/* 411 */           boolean bool2 = ((i1 & 0x2) > 0) ? paramData.sByte(i++) : false;
/* 412 */           pattern.data[b1++] = bool2;
/* 413 */           boolean bool3 = ((i1 & 0x4) > 0) ? paramData.sByte(i++) : false;
/* 414 */           pattern.data[b1++] = bool3;
/* 415 */           j = ((i1 & 0x8) > 0) ? paramData.sByte(i++) : 0;
/* 416 */           m = ((i1 & 0x10) > 0) ? paramData.sByte(i++) : 0;
/* 417 */           if (j >= 64) j = m = 0; 
/* 418 */           pattern.data[b1++] = j;
/* 419 */           pattern.data[b1++] = m;
/*     */         } 
/*     */       } 
/* 422 */       i = n;
/*     */     } 
/* 424 */     this.instruments = new Instrument[this.numInstruments + 1];
/* 425 */     this.instruments[0] = new Instrument();
/* 426 */     for (b = 1; b <= this.numInstruments; b++) {
/* 427 */       this.instruments[b] = new Instrument(); Instrument instrument;
/* 428 */       (instrument = new Instrument()).name = paramData.strCp850(i + 4, 22);
/*     */       int j;
/* 430 */       if ((j = paramData.uleShort(i + 27)) > 0) {
/* 431 */         instrument.numSamples = j;
/* 432 */         instrument.samples = new Sample[j];
/* 433 */         for (byte b2 = 0; b2 < 96; b2++)
/* 434 */           instrument.keyToSample[b2 + 1] = paramData.uByte(i + 33 + b2); 
/*     */         Envelope envelope1;
/* 436 */         (envelope1 = instrument.volumeEnvelope = new Envelope()).pointsTick = new int[16];
/* 437 */         envelope1.pointsAmpl = new int[16];
/* 438 */         int m = 0;
/* 439 */         for (byte b3 = 0; b3 < 12; b3++) {
/* 440 */           int n = i + 129 + (b3 << 2);
/* 441 */           m = (bool ? m : 0) + paramData.uleShort(n);
/* 442 */           envelope1.pointsTick[b3] = m;
/* 443 */           envelope1.pointsAmpl[b3] = paramData.uleShort(n + 2);
/*     */         } 
/*     */         Envelope envelope2;
/* 446 */         (envelope2 = instrument.panningEnvelope = new Envelope()).pointsTick = new int[16];
/* 447 */         envelope2.pointsAmpl = new int[16];
/* 448 */         m = 0;
/* 449 */         for (byte b4 = 0; b4 < 12; b4++) {
/* 450 */           int n = i + 177 + (b4 << 2);
/* 451 */           m = (bool ? m : 0) + paramData.uleShort(n);
/* 452 */           envelope2.pointsTick[b4] = m;
/* 453 */           envelope2.pointsAmpl[b4] = paramData.uleShort(n + 2);
/*     */         } 
/* 455 */         envelope1.numPoints = paramData.uByte(i + 225);
/* 456 */         if (envelope1.numPoints > 12) envelope1.numPoints = 0; 
/* 457 */         envelope2.numPoints = paramData.uByte(i + 226);
/* 458 */         if (envelope2.numPoints > 12) envelope2.numPoints = 0; 
/* 459 */         envelope1.sustainTick = envelope1.pointsTick[paramData.uByte(i + 227) & 0xF];
/* 460 */         envelope1.loopStartTick = envelope1.pointsTick[paramData.uByte(i + 228) & 0xF];
/* 461 */         envelope1.loopEndTick = envelope1.pointsTick[paramData.uByte(i + 229) & 0xF];
/* 462 */         envelope2.sustainTick = envelope2.pointsTick[paramData.uByte(i + 230) & 0xF];
/* 463 */         envelope2.loopStartTick = envelope2.pointsTick[paramData.uByte(i + 231) & 0xF];
/* 464 */         envelope2.loopEndTick = envelope2.pointsTick[paramData.uByte(i + 232) & 0xF];
/* 465 */         envelope1.enabled = (envelope1.numPoints > 0 && (paramData.uByte(i + 233) & 0x1) > 0);
/* 466 */         envelope1.sustain = ((paramData.uByte(i + 233) & 0x2) > 0);
/* 467 */         envelope1.looped = ((paramData.uByte(i + 233) & 0x4) > 0);
/* 468 */         envelope2.enabled = (envelope2.numPoints > 0 && (paramData.uByte(i + 234) & 0x1) > 0);
/* 469 */         envelope2.sustain = ((paramData.uByte(i + 234) & 0x2) > 0);
/* 470 */         envelope2.looped = ((paramData.uByte(i + 234) & 0x4) > 0);
/* 471 */         instrument.vibratoType = paramData.uByte(i + 235);
/* 472 */         instrument.vibratoSweep = paramData.uByte(i + 236);
/* 473 */         instrument.vibratoDepth = paramData.uByte(i + 237);
/* 474 */         instrument.vibratoRate = paramData.uByte(i + 238);
/* 475 */         instrument.volumeFadeOut = paramData.uleShort(i + 239);
/*     */       } 
/*     */       
/* 478 */       int k = i = i + paramData.uleInt(i);
/* 479 */       i += j * 40;
/* 480 */       for (byte b1 = 0; b1 < j; b1++) {
/* 481 */         Sample sample = instrument.samples[b1] = new Sample();
/* 482 */         int m = paramData.uleInt(k);
/* 483 */         int n = paramData.uleInt(k + 4);
/* 484 */         int i1 = paramData.uleInt(k + 8);
/* 485 */         sample.volume = paramData.sByte(k + 12);
/* 486 */         sample.fineTune = paramData.sByte(k + 13);
/* 487 */         boolean bool1 = ((paramData.uByte(k + 14) & 0x3) > 0) ? true : false;
/* 488 */         boolean bool2 = ((paramData.uByte(k + 14) & 0x2) > 0) ? true : false;
/* 489 */         boolean bool3 = ((paramData.uByte(k + 14) & 0x10) > 0) ? true : false;
/* 490 */         sample.panning = paramData.uByte(k + 15);
/* 491 */         sample.relNote = paramData.sByte(k + 16);
/* 492 */         sample.name = paramData.strCp850(k + 18, 22);
/* 493 */         k += 40;
/* 494 */         if (!bool1 || n + i1 > m) {
/* 495 */           n = m;
/* 496 */           i1 = 0;
/*     */         } 
/* 498 */         if (bool3) {
/* 499 */           sample.setSampleData(paramData.samS16D(i, m >> 1), n >> 1, i1 >> 1, bool2);
/*     */         } else {
/* 501 */           sample.setSampleData(paramData.samS8D(i, m), n, i1, bool2);
/*     */         } 
/* 503 */         i += m;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void toStringBuffer(StringBuffer paramStringBuffer) {
/* 509 */     paramStringBuffer.append("Song Name: " + this.songName + '\n' + "Num Channels: " + this.numChannels + '\n' + "Num Instruments: " + this.numInstruments + '\n' + "Num Patterns: " + this.numPatterns + '\n' + "Sequence Length: " + this.sequenceLength + '\n' + "Restart Pos: " + this.restartPos + '\n' + "Default Speed: " + this.defaultSpeed + '\n' + "Default Tempo: " + this.defaultTempo + '\n' + "Linear Periods: " + this.linearPeriods + '\n');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 518 */     paramStringBuffer.append("Sequence: "); byte b;
/* 519 */     for (b = 0; b < this.sequence.length; b++)
/* 520 */       paramStringBuffer.append(this.sequence[b] + ", "); 
/* 521 */     paramStringBuffer.append('\n');
/* 522 */     for (b = 0; b < this.patterns.length; b++) {
/* 523 */       paramStringBuffer.append("Pattern " + b + ":\n");
/* 524 */       this.patterns[b].toStringBuffer(paramStringBuffer);
/*     */     } 
/* 526 */     for (b = 1; b < this.instruments.length; b++) {
/* 527 */       paramStringBuffer.append("Instrument " + b + ":\n");
/* 528 */       this.instruments[b].toStringBuffer(paramStringBuffer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public static String toZippedBase64(byte[] paramArrayOfbyte) {
/* 536 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 537 */     ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
/*     */     ZipEntry zipEntry;
/* 539 */     (zipEntry = new ZipEntry("module")).setSize(paramArrayOfbyte.length);
/* 540 */     zipOutputStream.putNextEntry(zipEntry);
/* 541 */     zipOutputStream.write(paramArrayOfbyte);
/* 542 */     zipOutputStream.close();
/* 543 */     byteArrayOutputStream.close();
/*     */ 
/*     */     
/* 546 */     String str = StringFormatter.toBase64(paramArrayOfbyte = byteArrayOutputStream.toByteArray(), 0, paramArrayOfbyte.length);
/* 547 */     Game.i.musicManager.getModule(str);
/* 548 */     return str;
/*     */   }
/*     */   
/*     */   public float getVolumeMultiplierFromInstrumentNames() {
/* 552 */     if (this.b == null) {
/* 553 */       this.b = Float.valueOf(1.0F); Instrument[] arrayOfInstrument; int i; byte b;
/* 554 */       for (i = (arrayOfInstrument = this.instruments).length, b = 0; b < i; ) {
/*     */         Instrument instrument; String str;
/* 556 */         if ((str = (instrument = arrayOfInstrument[b]).name.trim()).length() != 0 && 
/* 557 */           str.startsWith("[volume:") && str.endsWith("]")) {
/*     */           try {
/* 559 */             this.b = Float.valueOf(Integer.parseInt(str.substring(8, str.length() - 1)) * 0.01F);
/*     */             break;
/* 561 */           } catch (Exception exception) {}
/*     */         }
/*     */         b++;
/*     */       } 
/*     */     } 
/* 566 */     return this.b.floatValue();
/*     */   }
/*     */   
/*     */   public Array<TrackInfoEntry> getInfoFromInstrumentNames() {
/* 570 */     Array<TrackInfoEntry> array = new Array(true, 1, TrackInfoEntry.class);
/*     */ 
/*     */     
/* 573 */     boolean bool = false; Instrument[] arrayOfInstrument; int i; byte b;
/* 574 */     for (i = (arrayOfInstrument = this.instruments).length, b = 0; b < i; ) {
/*     */       Instrument instrument; String str;
/* 576 */       if ((str = (instrument = arrayOfInstrument[b]).name.trim()).length() != 0 && 
/* 577 */         str.startsWith("[") && str.endsWith("]")) {
/* 578 */         bool = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */       b++;
/*     */     } 
/* 584 */     if (bool) {
/* 585 */       TrackInfoEntry.EntryType entryType = TrackInfoEntry.EntryType.TEXT;
/* 586 */       StringBuilder stringBuilder = new StringBuilder(); Instrument[] arrayOfInstrument1; int j; byte b1;
/* 587 */       for (j = (arrayOfInstrument1 = this.instruments).length, b1 = 0; b1 < j; b1++) {
/*     */         Instrument instrument; String str;
/* 589 */         if ((str = (instrument = arrayOfInstrument1[b1]).name.trim()).length() != 0) {
/* 590 */           TrackInfoEntry.EntryType entryType1; if (str.startsWith("[") && str.endsWith("]")) {
/* 591 */             str = str.substring(1, str.length() - 1).toUpperCase(Locale.US);
/*     */ 
/*     */             
/*     */             try {
/* 595 */               entryType1 = TrackInfoEntry.EntryType.valueOf(str);
/* 596 */             } catch (Exception exception) {
/* 597 */               entryType1 = TrackInfoEntry.EntryType.TEXT;
/*     */             } 
/* 599 */             if (stringBuilder.length() != 0) {
/* 600 */               array.add(new TrackInfoEntry(entryType, stringBuilder.toString()));
/* 601 */               stringBuilder.setLength(0);
/*     */             } 
/* 603 */             entryType = entryType1;
/*     */           } else {
/* 605 */             stringBuilder.append((String)entryType1);
/*     */           } 
/*     */         } 
/*     */       } 
/* 609 */       if (stringBuilder.length() != 0) {
/* 610 */         array.add(new TrackInfoEntry(entryType, stringBuilder.toString()));
/*     */       }
/*     */     } else {
/*     */       
/* 614 */       for (i = (arrayOfInstrument = this.instruments).length, b = 0; b < i; b++) {
/*     */         Instrument instrument; String str;
/* 616 */         if ((str = (instrument = arrayOfInstrument[b]).name.trim()).length() != 0) {
/* 617 */           array.add(new TrackInfoEntry(TrackInfoEntry.EntryType.TEXT, str));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 622 */     return array;
/*     */   }
/*     */   @REGS
/*     */   public static final class TrackInfoEntry implements KryoSerializable { public EntryType type;
/*     */     public String value;
/*     */     
/*     */     @REGS
/* 629 */     public enum EntryType { TEXT,
/* 630 */       AUTHOR,
/* 631 */       GROUP,
/* 632 */       LINK;
/*     */       
/* 634 */       public static final EntryType[] values = values();
/*     */       
/*     */       static {
/*     */       
/*     */       } }
/*     */ 
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 642 */       param1Kryo.writeObject(param1Output, this.type);
/* 643 */       param1Kryo.writeObject(param1Output, this.value);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 648 */       this.type = (EntryType)param1Kryo.readObject(param1Input, EntryType.class);
/* 649 */       this.value = (String)param1Kryo.readObject(param1Input, String.class);
/*     */     }
/*     */     
/*     */     public TrackInfoEntry() {}
/*     */     
/*     */     public TrackInfoEntry(EntryType param1EntryType, String param1String) {
/* 655 */       Preconditions.checkNotNull(param1EntryType, "type");
/* 656 */       Preconditions.checkNotNull(param1String, "value");
/* 657 */       this.type = param1EntryType;
/* 658 */       this.value = param1String;
/*     */     }
/*     */     
/*     */     public final String getCompleteLink() {
/* 662 */       String str = "https://" + this.value;
/* 663 */       if (this.value.contains("?")) {
/* 664 */         str = str + "&";
/*     */       } else {
/* 666 */         str = str + "?";
/*     */       } 
/*     */       
/* 669 */       return str = str + "utm_source=Infinitode_2_game";
/*     */     } }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public enum EntryType {
/*     */     TEXT, AUTHOR, GROUP, LINK;
/*     */     public static final EntryType[] values = values();
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ibxm\Module.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */