/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
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
/*     */ public class UBJsonReader
/*     */   implements BaseJsonReader
/*     */ {
/*     */   public boolean oldFormat = true;
/*     */   
/*     */   public JsonValue parse(InputStream paramInputStream) {
/*  36 */     DataInputStream dataInputStream = null;
/*     */     try {
/*  38 */       dataInputStream = new DataInputStream(paramInputStream);
/*  39 */       return parse(dataInputStream);
/*  40 */     } catch (IOException iOException) {
/*  41 */       throw new SerializationException(iOException);
/*     */     } finally {
/*  43 */       StreamUtils.closeQuietly(dataInputStream);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonValue parse(FileHandle paramFileHandle) {
/*     */     try {
/*  50 */       return parse(paramFileHandle.read(8192));
/*  51 */     } catch (Exception exception) {
/*  52 */       throw new SerializationException("Error parsing file: " + paramFileHandle, exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public JsonValue parse(DataInputStream paramDataInputStream) {
/*     */     try {
/*  58 */       return parse(paramDataInputStream, paramDataInputStream.readByte());
/*     */     } finally {
/*  60 */       StreamUtils.closeQuietly(paramDataInputStream);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected JsonValue parse(DataInputStream paramDataInputStream, byte paramByte) {
/*  65 */     if (paramByte == 91)
/*  66 */       return parseArray(paramDataInputStream); 
/*  67 */     if (paramByte == 123)
/*  68 */       return parseObject(paramDataInputStream); 
/*  69 */     if (paramByte == 90)
/*  70 */       return new JsonValue(JsonValue.ValueType.nullValue); 
/*  71 */     if (paramByte == 84)
/*  72 */       return new JsonValue(true); 
/*  73 */     if (paramByte == 70)
/*  74 */       return new JsonValue(false); 
/*  75 */     if (paramByte == 66)
/*  76 */       return new JsonValue(readUChar(paramDataInputStream)); 
/*  77 */     if (paramByte == 85)
/*  78 */       return new JsonValue(readUChar(paramDataInputStream)); 
/*  79 */     if (paramByte == 105)
/*  80 */       return new JsonValue(this.oldFormat ? paramDataInputStream.readShort() : paramDataInputStream.readByte()); 
/*  81 */     if (paramByte == 73)
/*  82 */       return new JsonValue(this.oldFormat ? paramDataInputStream.readInt() : paramDataInputStream.readShort()); 
/*  83 */     if (paramByte == 108)
/*  84 */       return new JsonValue(paramDataInputStream.readInt()); 
/*  85 */     if (paramByte == 76)
/*  86 */       return new JsonValue(paramDataInputStream.readLong()); 
/*  87 */     if (paramByte == 100)
/*  88 */       return new JsonValue(paramDataInputStream.readFloat()); 
/*  89 */     if (paramByte == 68)
/*  90 */       return new JsonValue(paramDataInputStream.readDouble()); 
/*  91 */     if (paramByte == 115 || paramByte == 83)
/*  92 */       return new JsonValue(parseString(paramDataInputStream, paramByte)); 
/*  93 */     if (paramByte == 97 || paramByte == 65)
/*  94 */       return parseData(paramDataInputStream, paramByte); 
/*  95 */     if (paramByte == 67) {
/*  96 */       return new JsonValue(paramDataInputStream.readChar());
/*     */     }
/*  98 */     throw new GdxRuntimeException("Unrecognized data type");
/*     */   }
/*     */   
/*     */   protected JsonValue parseArray(DataInputStream paramDataInputStream) {
/* 102 */     JsonValue jsonValue1 = new JsonValue(JsonValue.ValueType.array);
/* 103 */     byte b = paramDataInputStream.readByte();
/* 104 */     byte b1 = 0;
/* 105 */     if (b == 36) {
/* 106 */       b1 = paramDataInputStream.readByte();
/* 107 */       b = paramDataInputStream.readByte();
/*     */     } 
/* 109 */     long l1 = -1L;
/* 110 */     if (b == 35) {
/*     */       
/* 112 */       if ((l1 = parseSize(paramDataInputStream, false, -1L)) < 0L) throw new GdxRuntimeException("Unrecognized data type"); 
/* 113 */       if (l1 == 0L) return jsonValue1; 
/* 114 */       b = (b1 == 0) ? paramDataInputStream.readByte() : b1;
/*     */     } 
/* 116 */     JsonValue jsonValue2 = null;
/* 117 */     long l2 = 0L;
/* 118 */     while (paramDataInputStream.available() > 0 && b != 93) {
/*     */       JsonValue jsonValue;
/* 120 */       (jsonValue = parse(paramDataInputStream, b)).parent = jsonValue1;
/* 121 */       if (jsonValue2 != null) {
/* 122 */         jsonValue.prev = jsonValue2;
/* 123 */         jsonValue2.next = jsonValue;
/* 124 */         jsonValue1.size++;
/*     */       } else {
/* 126 */         jsonValue1.child = jsonValue;
/* 127 */         jsonValue1.size = 1;
/*     */       } 
/* 129 */       jsonValue2 = jsonValue;
/* 130 */       if (l1 <= 0L || ++l2 < l1)
/* 131 */         boolean bool = (b1 == 0) ? paramDataInputStream.readByte() : b1; 
/*     */     } 
/* 133 */     return jsonValue1;
/*     */   }
/*     */   
/*     */   protected JsonValue parseObject(DataInputStream paramDataInputStream) {
/* 137 */     JsonValue jsonValue1 = new JsonValue(JsonValue.ValueType.object);
/* 138 */     byte b = paramDataInputStream.readByte();
/* 139 */     byte b1 = 0;
/* 140 */     if (b == 36) {
/* 141 */       b1 = paramDataInputStream.readByte();
/* 142 */       b = paramDataInputStream.readByte();
/*     */     } 
/* 144 */     long l1 = -1L;
/* 145 */     if (b == 35) {
/*     */       
/* 147 */       if ((l1 = parseSize(paramDataInputStream, false, -1L)) < 0L) throw new GdxRuntimeException("Unrecognized data type"); 
/* 148 */       if (l1 == 0L) return jsonValue1; 
/* 149 */       b = paramDataInputStream.readByte();
/*     */     } 
/* 151 */     JsonValue jsonValue2 = null;
/* 152 */     long l2 = 0L;
/* 153 */     while (paramDataInputStream.available() > 0 && b != 125) {
/* 154 */       String str = parseString(paramDataInputStream, true, b);
/*     */       JsonValue jsonValue;
/* 156 */       (jsonValue = parse(paramDataInputStream, (b1 == 0) ? paramDataInputStream.readByte() : b1)).setName(str);
/* 157 */       jsonValue.parent = jsonValue1;
/* 158 */       if (jsonValue2 != null) {
/* 159 */         jsonValue.prev = jsonValue2;
/* 160 */         jsonValue2.next = jsonValue;
/* 161 */         jsonValue1.size++;
/*     */       } else {
/* 163 */         jsonValue1.child = jsonValue;
/* 164 */         jsonValue1.size = 1;
/*     */       } 
/* 166 */       jsonValue2 = jsonValue;
/* 167 */       if (l1 <= 0L || ++l2 < l1)
/* 168 */         byte b2 = paramDataInputStream.readByte(); 
/*     */     } 
/* 170 */     return jsonValue1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected JsonValue parseData(DataInputStream paramDataInputStream, byte paramByte) {
/* 176 */     byte b = paramDataInputStream.readByte();
/* 177 */     long l1 = (paramByte == 65) ? readUInt(paramDataInputStream) : readUChar(paramDataInputStream);
/* 178 */     JsonValue jsonValue1 = new JsonValue(JsonValue.ValueType.array);
/* 179 */     JsonValue jsonValue2 = null; long l2;
/* 180 */     for (l2 = 0L; l2 < l1; l2++) {
/*     */       JsonValue jsonValue;
/* 182 */       (jsonValue = parse(paramDataInputStream, b)).parent = jsonValue1;
/* 183 */       if (jsonValue2 != null) {
/* 184 */         jsonValue2.next = jsonValue;
/* 185 */         jsonValue1.size++;
/*     */       } else {
/* 187 */         jsonValue1.child = jsonValue;
/* 188 */         jsonValue1.size = 1;
/*     */       } 
/* 190 */       jsonValue2 = jsonValue;
/*     */     } 
/* 192 */     return jsonValue1;
/*     */   }
/*     */   
/*     */   protected String parseString(DataInputStream paramDataInputStream, byte paramByte) {
/* 196 */     return parseString(paramDataInputStream, false, paramByte);
/*     */   }
/*     */   
/*     */   protected String parseString(DataInputStream paramDataInputStream, boolean paramBoolean, byte paramByte) {
/* 200 */     long l = -1L;
/* 201 */     if (paramByte == 83)
/* 202 */     { l = parseSize(paramDataInputStream, true, -1L); }
/* 203 */     else if (paramByte == 115)
/* 204 */     { l = readUChar(paramDataInputStream); }
/* 205 */     else if (paramBoolean) { l = parseSize(paramDataInputStream, paramByte, false, -1L); }
/* 206 */      if (l < 0L) throw new GdxRuntimeException("Unrecognized data type, string expected"); 
/* 207 */     return (l > 0L) ? readString(paramDataInputStream, l) : "";
/*     */   }
/*     */   
/*     */   protected long parseSize(DataInputStream paramDataInputStream, boolean paramBoolean, long paramLong) {
/* 211 */     return parseSize(paramDataInputStream, paramDataInputStream.readByte(), paramBoolean, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   protected long parseSize(DataInputStream paramDataInputStream, byte paramByte, boolean paramBoolean, long paramLong) {
/* 216 */     if (paramByte == 105) return readUChar(paramDataInputStream); 
/* 217 */     if (paramByte == 73) return readUShort(paramDataInputStream); 
/* 218 */     if (paramByte == 108) return readUInt(paramDataInputStream); 
/* 219 */     if (paramByte == 76) return paramDataInputStream.readLong(); 
/* 220 */     if (paramBoolean) {
/*     */       long l;
/*     */ 
/*     */ 
/*     */       
/* 225 */       return l = (l = (l = (l = ((short)paramByte & 0xFF) << 24L) | ((short)paramDataInputStream.readByte() & 0xFF) << 16L) | ((short)paramDataInputStream.readByte() & 0xFF) << 8L) | ((short)paramDataInputStream.readByte() & 0xFF);
/*     */     } 
/* 227 */     return paramLong;
/*     */   }
/*     */   
/*     */   protected short readUChar(DataInputStream paramDataInputStream) {
/* 231 */     return (short)((short)paramDataInputStream.readByte() & 0xFF);
/*     */   }
/*     */   
/*     */   protected int readUShort(DataInputStream paramDataInputStream) {
/* 235 */     return paramDataInputStream.readShort() & 0xFFFF;
/*     */   }
/*     */   
/*     */   protected long readUInt(DataInputStream paramDataInputStream) {
/* 239 */     return paramDataInputStream.readInt();
/*     */   }
/*     */   
/*     */   protected String readString(DataInputStream paramDataInputStream, long paramLong) {
/* 243 */     byte[] arrayOfByte = new byte[(int)paramLong];
/* 244 */     paramDataInputStream.readFully(arrayOfByte);
/* 245 */     return new String(arrayOfByte, "UTF-8");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\UBJsonReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */