/*     */ package com.prineside.tdi2.managers.preferences;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Base64Coder;
/*     */ import com.badlogic.gdx.utils.ByteArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.kryo.FixedInput;
/*     */ import com.prineside.kryo.FixedOutput;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.zip.DataFormatException;
/*     */ import java.util.zip.Deflater;
/*     */ import java.util.zip.Inflater;
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
/*     */ public final class RegularPrefMap
/*     */   implements PrefMap
/*     */ {
/*     */   public static final int BYTE_FORMAT_HEADER = 1988092089;
/*     */   public static final byte TYPE_PROGRESS = 1;
/*     */   public static final byte TYPE_SETTINGS = 2;
/*     */   public static final byte CURRENT_VERSION = 1;
/*  42 */   private final ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*     */   private final byte b;
/*     */   
/*  47 */   private final Deflater c = new Deflater(1, true);
/*  48 */   private final Inflater d = new Inflater(true);
/*  49 */   private final ByteArrayOutputStream e = new ByteArrayOutputStream();
/*  50 */   private final byte[] f = new byte[2048];
/*  51 */   private final FixedInput g = new FixedInput();
/*  52 */   private final FixedOutput h = new FixedOutput(1024, -1);
/*  53 */   private byte[] i = new byte[8];
/*  54 */   private final ByteArray j = new ByteArray(8);
/*     */   
/*     */   public RegularPrefMap(byte paramByte) {
/*  57 */     if (paramByte != 1 && paramByte != 2) {
/*  58 */       throw new IllegalArgumentException("Invalid type: " + paramByte);
/*     */     }
/*  60 */     this.b = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String get(String paramString1, String paramString2) {
/*  66 */     if ((paramString1 = this.a.get(paramString1)) == null) {
/*  67 */       return paramString2;
/*     */     }
/*  69 */     return paramString1;
/*     */   }
/*     */   @Null
/*     */   public final String get(String paramString) {
/*  73 */     return this.a.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void set(String paramString1, String paramString2) {
/*  78 */     if (paramString2 == null) {
/*  79 */       this.a.remove(paramString1); return;
/*     */     } 
/*  81 */     this.a.put(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void clear() {
/*  86 */     this.a.clear();
/*     */   }
/*     */   
/*     */   public final ConcurrentHashMap<String, String> getMap() {
/*  90 */     return this.a;
/*     */   }
/*     */   
/*     */   public final ObjectPair<String, String>[] toOrderedKeyValuePairs() {
/*  94 */     Array array = new Array(true, this.a.size(), ObjectPair.class);
/*  95 */     for (Map.Entry<String, String> entry : this.a.entrySet()) {
/*  96 */       array.add(new ObjectPair(entry.getKey(), entry.getValue()));
/*     */     }
/*  98 */     array.sort((paramObjectPair1, paramObjectPair2) -> ((String)paramObjectPair1.first).compareTo((String)paramObjectPair2.first));
/*  99 */     return (ObjectPair<String, String>[])array.toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static BinarySaveInfo getBinarySaveInfo(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 105 */     BinarySaveInfo binarySaveInfo = new BinarySaveInfo();
/*     */     
/* 107 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 108 */     Inflater inflater = new Inflater(true);
/* 109 */     byte[] arrayOfByte = new byte[64];
/* 110 */     FixedInput fixedInput = new FixedInput();
/*     */     try {
/* 112 */       int k = 0;
/* 113 */       byteArrayOutputStream.reset();
/* 114 */       inflater.setInput(paramArrayOfbyte, paramInt1, paramInt2); int j;
/* 115 */       while (!inflater.finished() && (
/*     */         
/* 117 */         j = inflater.inflate(arrayOfByte)) != 0) {
/*     */         
/* 119 */         byteArrayOutputStream.write(arrayOfByte, 0, j);
/*     */         
/* 121 */         if ((k = k + j) < 64);
/*     */       } 
/*     */ 
/*     */       
/* 125 */       fixedInput.setBuffer(byteArrayOutputStream.toByteArray());
/* 126 */     } catch (DataFormatException dataFormatException) {
/* 127 */       binarySaveInfo.valid = false;
/* 128 */       binarySaveInfo.canBeInflated = false;
/* 129 */       return binarySaveInfo;
/*     */     } 
/* 131 */     binarySaveInfo.canBeInflated = true;
/*     */     
/*     */     int i;
/* 134 */     if ((i = fixedInput.readInt()) == 1988092089) {
/* 135 */       binarySaveInfo.version = fixedInput.readByte();
/* 136 */       if (binarySaveInfo.version >= 0 && binarySaveInfo.version <= 1) {
/* 137 */         binarySaveInfo.type = fixedInput.readByte();
/* 138 */         if (binarySaveInfo.type == 1 || binarySaveInfo.type == 2) {
/* 139 */           binarySaveInfo.saveTimestamp = fixedInput.readLong();
/* 140 */           binarySaveInfo.valid = (binarySaveInfo.saveTimestamp > 0L);
/*     */         } else {
/* 142 */           binarySaveInfo.type = -1;
/*     */         } 
/*     */       } else {
/* 145 */         binarySaveInfo.version = -1;
/*     */       } 
/*     */     } else {
/* 148 */       binarySaveInfo.valid = false;
/*     */     } 
/*     */     
/* 151 */     return binarySaveInfo;
/*     */   }
/*     */   
/*     */   public final void fromBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     try {
/* 156 */       this.e.reset();
/* 157 */       this.d.setInput(paramArrayOfbyte, paramInt1, paramInt2); int j;
/* 158 */       while (!this.d.finished() && (
/*     */         
/* 160 */         j = this.d.inflate(this.f)) != 0)
/*     */       {
/* 162 */         this.e.write(this.f, 0, j);
/*     */       }
/* 164 */       this.d.reset();
/* 165 */       this.g.setBuffer(this.e.toByteArray());
/* 166 */     } catch (DataFormatException dataFormatException) {
/* 167 */       throw new IllegalArgumentException("Failed to read deflated bytes", dataFormatException);
/*     */     } 
/*     */     
/*     */     int i;
/* 171 */     if ((i = this.g.readInt()) == 1988092089) {
/* 172 */       this.g.readByte();
/*     */       
/* 174 */       if ((i = this.g.readByte()) != this.b) {
/* 175 */         throw new IllegalArgumentException("Invalid type of preferences: " + i + ", expecting " + this.b);
/*     */       }
/* 177 */       this.g.readLong();
/*     */       
/* 179 */       i = this.g.readInt();
/* 180 */       for (paramInt1 = 0; paramInt1 < i; paramInt1++) {
/* 181 */         String str1 = this.g.readString();
/* 182 */         String str2 = this.g.readString();
/* 183 */         set(str1, str2);
/*     */       }  return;
/*     */     } 
/* 186 */     throw new IllegalArgumentException("Unrecognized header: " + Integer.toHexString(i));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fromBase64(String paramString) {
/* 191 */     byte[] arrayOfByte = Base64Coder.decode(paramString);
/* 192 */     fromBytes(arrayOfByte, 0, arrayOfByte.length);
/*     */   }
/*     */   
/*     */   public final ByteArray toBytes() {
/* 196 */     this.h.clear();
/* 197 */     this.h.writeInt(1988092089);
/* 198 */     this.h.writeByte(1);
/* 199 */     this.h.writeByte(this.b);
/* 200 */     this.h.writeLong(Game.getTimestampMillis());
/*     */     
/* 202 */     this.h.writeInt(this.a.size());
/* 203 */     for (Map.Entry<String, String> entry : this.a.entrySet()) {
/* 204 */       this.h.writeString((String)entry.getKey());
/* 205 */       this.h.writeString((String)entry.getValue());
/*     */     } 
/*     */ 
/*     */     
/* 209 */     if (this.i.length < this.h.position()) {
/* 210 */       this.i = new byte[MathUtils.nextPowerOfTwo(this.h.position())];
/*     */     }
/*     */     
/* 213 */     this.c.setInput(this.h.getBuffer(), 0, this.h.position());
/* 214 */     this.c.finish();
/* 215 */     int i = this.c.deflate(this.i);
/* 216 */     this.c.reset();
/*     */     
/* 218 */     this.j.clear();
/* 219 */     this.j.addAll(this.i, 0, i);
/* 220 */     return this.j;
/*     */   }
/*     */   
/*     */   public final String toBase64() {
/* 224 */     ByteArray byteArray = toBytes();
/* 225 */     return new String(Base64Coder.encode(byteArray.items, byteArray.size));
/*     */   }
/*     */   
/*     */   public static final class BinarySaveInfo
/*     */   {
/*     */     public boolean valid;
/*     */     public boolean canBeInflated;
/* 232 */     public byte type = -1;
/* 233 */     public byte version = -1;
/* 234 */     public long saveTimestamp = -1L;
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 238 */       return "BinarySaveInfo (valid: " + this.valid + ", canBeInflated: " + this.canBeInflated + ", type: " + this.type + ", version: " + this.version + ", save timestamp: " + this.saveTimestamp + ")";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\RegularPrefMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */