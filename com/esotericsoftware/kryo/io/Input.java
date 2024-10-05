/*      */ package com.esotericsoftware.kryo.io;
/*      */ 
/*      */ import com.esotericsoftware.kryo.KryoException;
/*      */ import com.esotericsoftware.kryo.util.Pool;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Input
/*      */   extends InputStream
/*      */   implements Pool.Poolable
/*      */ {
/*      */   protected byte[] buffer;
/*      */   protected int position;
/*      */   protected int capacity;
/*      */   protected int limit;
/*      */   protected long total;
/*   39 */   protected char[] chars = new char[32];
/*      */ 
/*      */   
/*      */   protected InputStream inputStream;
/*      */   
/*      */   protected boolean varEncoding = true;
/*      */ 
/*      */   
/*      */   public Input() {}
/*      */ 
/*      */   
/*      */   public Input(int paramInt) {
/*   51 */     this.capacity = paramInt;
/*   52 */     this.buffer = new byte[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Input(byte[] paramArrayOfbyte) {
/*   59 */     setBuffer(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Input(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*   66 */     setBuffer(paramArrayOfbyte, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public Input(InputStream paramInputStream) {
/*   71 */     this(4096);
/*   72 */     if (paramInputStream == null) throw new IllegalArgumentException("inputStream cannot be null."); 
/*   73 */     this.inputStream = paramInputStream;
/*      */   }
/*      */ 
/*      */   
/*      */   public Input(InputStream paramInputStream, int paramInt) {
/*   78 */     this(paramInt);
/*   79 */     if (paramInputStream == null) throw new IllegalArgumentException("inputStream cannot be null."); 
/*   80 */     this.inputStream = paramInputStream;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBuffer(byte[] paramArrayOfbyte) {
/*   86 */     setBuffer(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBuffer(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*   92 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/*   93 */     this.buffer = paramArrayOfbyte;
/*   94 */     this.position = paramInt1;
/*   95 */     this.limit = paramInt1 + paramInt2;
/*   96 */     this.capacity = paramArrayOfbyte.length;
/*   97 */     this.total = 0L;
/*   98 */     this.inputStream = null;
/*      */   }
/*      */ 
/*      */   
/*      */   public byte[] getBuffer() {
/*  103 */     return this.buffer;
/*      */   }
/*      */   
/*      */   public InputStream getInputStream() {
/*  107 */     return this.inputStream;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInputStream(InputStream paramInputStream) {
/*  114 */     this.inputStream = paramInputStream;
/*  115 */     this.limit = 0;
/*  116 */     reset();
/*      */   }
/*      */   
/*      */   public boolean getVariableLengthEncoding() {
/*  120 */     return this.varEncoding;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVariableLengthEncoding(boolean paramBoolean) {
/*  126 */     this.varEncoding = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public long total() {
/*  131 */     return this.total + this.position;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTotal(long paramLong) {
/*  136 */     this.total = paramLong;
/*      */   }
/*      */ 
/*      */   
/*      */   public int position() {
/*  141 */     return this.position;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPosition(int paramInt) {
/*  146 */     this.position = paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public int limit() {
/*  151 */     return this.limit;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLimit(int paramInt) {
/*  156 */     this.limit = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void reset() {
/*  162 */     this.position = 0;
/*  163 */     this.total = 0L;
/*      */   }
/*      */ 
/*      */   
/*      */   public void skip(int paramInt) {
/*  168 */     int i = Math.min(this.limit - this.position, paramInt);
/*      */     
/*  170 */     this.position += i;
/*      */     
/*  172 */     while ((paramInt = paramInt - i) != 0) {
/*  173 */       i = Math.min(paramInt, this.capacity);
/*  174 */       require(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int fill(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  182 */     if (this.inputStream == null) return -1; 
/*      */     try {
/*  184 */       return this.inputStream.read(paramArrayOfbyte, paramInt1, paramInt2);
/*  185 */     } catch (IOException iOException) {
/*  186 */       throw new KryoException(iOException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int require(int paramInt) {
/*      */     int j, i;
/*  197 */     if ((i = this.limit - this.position) >= paramInt) return i; 
/*  198 */     if (paramInt > this.capacity) throw new KryoException("Buffer too small: capacity: " + this.capacity + ", required: " + paramInt);
/*      */ 
/*      */ 
/*      */     
/*  202 */     if (i > 0) {
/*      */       
/*  204 */       if ((j = fill(this.buffer, this.limit, this.capacity - this.limit)) == -1) throw new KryoBufferUnderflowException("Buffer underflow.");
/*      */       
/*  206 */       if ((i = i + j) >= paramInt) {
/*  207 */         this.limit += j;
/*  208 */         return i;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  213 */     System.arraycopy(this.buffer, this.position, this.buffer, 0, i);
/*  214 */     this.total += this.position;
/*  215 */     this.position = 0;
/*      */ 
/*      */     
/*      */     do {
/*  219 */       if ((j = fill(this.buffer, i, this.capacity - i)) == -1) {
/*  220 */         if (i < paramInt)
/*  221 */           throw new KryoBufferUnderflowException("Buffer underflow."); 
/*      */         break;
/*      */       } 
/*  224 */     } while ((i = i + j) < paramInt);
/*      */ 
/*      */     
/*  227 */     this.limit = i;
/*  228 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int optional(int paramInt) {
/*      */     int i;
/*  237 */     if ((i = this.limit - this.position) >= paramInt) return paramInt; 
/*  238 */     paramInt = Math.min(paramInt, this.capacity);
/*      */ 
/*      */     
/*      */     int j;
/*      */ 
/*      */     
/*  244 */     if ((j = fill(this.buffer, this.limit, this.capacity - this.limit)) == -1) return (i == 0) ? -1 : Math.min(i, paramInt);
/*      */     
/*  246 */     if ((i = i + j) >= paramInt) {
/*  247 */       this.limit += j;
/*  248 */       return paramInt;
/*      */     } 
/*      */ 
/*      */     
/*  252 */     System.arraycopy(this.buffer, this.position, this.buffer, 0, i);
/*  253 */     this.total += this.position;
/*  254 */     this.position = 0;
/*      */     
/*      */     do {
/*      */     
/*  258 */     } while ((j = fill(this.buffer, i, this.capacity - i)) != -1 && (
/*      */       
/*  260 */       i = i + j) < paramInt);
/*      */ 
/*      */     
/*  263 */     this.limit = i;
/*  264 */     return (i == 0) ? -1 : Math.min(i, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean end() {
/*  270 */     return (optional(1) <= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int available() {
/*  276 */     return this.limit - this.position + ((this.inputStream != null) ? this.inputStream.available() : 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public int read() {
/*  281 */     if (optional(1) <= 0) return -1; 
/*  282 */     return this.buffer[this.position++] & 0xFF;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int read(byte[] paramArrayOfbyte) {
/*  288 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  294 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/*  295 */     int i = paramInt2;
/*  296 */     int j = Math.min(this.limit - this.position, paramInt2);
/*      */     
/*  298 */     System.arraycopy(this.buffer, this.position, paramArrayOfbyte, paramInt1, j);
/*  299 */     this.position += j;
/*      */     
/*  301 */     while ((paramInt2 = paramInt2 - j) != 0) {
/*  302 */       paramInt1 += j;
/*      */       
/*  304 */       if ((j = optional(paramInt2)) == -1) {
/*      */         
/*  306 */         if (i == paramInt2) return -1; 
/*      */         break;
/*      */       } 
/*  309 */       if (this.position == this.limit)
/*      */         break; 
/*  311 */     }  return i - paramInt2;
/*      */   }
/*      */ 
/*      */   
/*      */   public long skip(long paramLong) {
/*  316 */     long l = paramLong;
/*  317 */     while (l > 0L) {
/*  318 */       int i = (int)Math.min(2147483639L, l);
/*  319 */       skip(i);
/*  320 */       l -= i;
/*      */     } 
/*  322 */     return paramLong;
/*      */   }
/*      */ 
/*      */   
/*      */   public void close() {
/*  327 */     if (this.inputStream != null) {
/*      */       try {
/*  329 */         this.inputStream.close(); return;
/*  330 */       } catch (IOException iOException) {}
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte readByte() {
/*  339 */     if (this.position == this.limit) require(1); 
/*  340 */     return this.buffer[this.position++];
/*      */   }
/*      */ 
/*      */   
/*      */   public int readByteUnsigned() {
/*  345 */     if (this.position == this.limit) require(1); 
/*  346 */     return this.buffer[this.position++] & 0xFF;
/*      */   }
/*      */ 
/*      */   
/*      */   public byte[] readBytes(int paramInt) {
/*  351 */     byte[] arrayOfByte = new byte[paramInt];
/*  352 */     readBytes(arrayOfByte, 0, paramInt);
/*  353 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */   
/*      */   public void readBytes(byte[] paramArrayOfbyte) {
/*  358 */     readBytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */   
/*      */   public void readBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  363 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/*  364 */     int i = Math.min(this.limit - this.position, paramInt2);
/*      */     
/*  366 */     System.arraycopy(this.buffer, this.position, paramArrayOfbyte, paramInt1, i);
/*  367 */     this.position += i;
/*      */     
/*  369 */     while ((paramInt2 = paramInt2 - i) != 0) {
/*  370 */       paramInt1 += i;
/*  371 */       i = Math.min(paramInt2, this.capacity);
/*  372 */       require(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int readInt() {
/*  380 */     require(4);
/*  381 */     byte[] arrayOfByte = this.buffer;
/*  382 */     int i = this.position;
/*  383 */     this.position = i + 4;
/*  384 */     return arrayOfByte[i] & 0xFF | (arrayOfByte[i + 1] & 0xFF) << 8 | (arrayOfByte[i + 2] & 0xFF) << 16 | (arrayOfByte[i + 3] & 0xFF) << 24;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int readInt(boolean paramBoolean) {
/*  395 */     if (this.varEncoding) return readVarInt(paramBoolean); 
/*  396 */     return readInt();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canReadInt() {
/*  401 */     if (this.varEncoding) return canReadVarInt(); 
/*  402 */     if (this.limit - this.position >= 4) return true; 
/*  403 */     return (optional(4) == 4);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int readVarInt(boolean paramBoolean) {
/*  409 */     if (require(1) < 5) return readVarInt_slow(paramBoolean); 
/*      */     byte b;
/*  411 */     int i = (b = this.buffer[this.position++]) & Byte.MAX_VALUE;
/*  412 */     if ((b & 0x80) != 0) {
/*  413 */       byte[] arrayOfByte = this.buffer;
/*  414 */       int j = this.position;
/*  415 */       b = arrayOfByte[j++];
/*  416 */       i |= (b & Byte.MAX_VALUE) << 7;
/*  417 */       if ((b & 0x80) != 0) {
/*  418 */         b = arrayOfByte[j++];
/*  419 */         i |= (b & Byte.MAX_VALUE) << 14;
/*  420 */         if ((b & 0x80) != 0) {
/*  421 */           b = arrayOfByte[j++];
/*  422 */           i |= (b & Byte.MAX_VALUE) << 21;
/*  423 */           if ((b & 0x80) != 0) {
/*  424 */             b = arrayOfByte[j++];
/*  425 */             i |= (b & Byte.MAX_VALUE) << 28;
/*      */           } 
/*      */         } 
/*      */       } 
/*  429 */       this.position = j;
/*      */     } 
/*  431 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*      */   }
/*      */ 
/*      */   
/*      */   private int readVarInt_slow(boolean paramBoolean) {
/*      */     byte b;
/*  437 */     int i = (b = this.buffer[this.position++]) & Byte.MAX_VALUE;
/*  438 */     if ((b & 0x80) != 0) {
/*  439 */       if (this.position == this.limit) require(1); 
/*      */       byte[] arrayOfByte;
/*  441 */       b = (arrayOfByte = this.buffer)[this.position++];
/*  442 */       i |= (b & Byte.MAX_VALUE) << 7;
/*  443 */       if ((b & 0x80) != 0) {
/*  444 */         if (this.position == this.limit) require(1); 
/*  445 */         b = arrayOfByte[this.position++];
/*  446 */         i |= (b & Byte.MAX_VALUE) << 14;
/*  447 */         if ((b & 0x80) != 0) {
/*  448 */           if (this.position == this.limit) require(1); 
/*  449 */           b = arrayOfByte[this.position++];
/*  450 */           i |= (b & Byte.MAX_VALUE) << 21;
/*  451 */           if ((b & 0x80) != 0) {
/*  452 */             if (this.position == this.limit) require(1); 
/*  453 */             b = arrayOfByte[this.position++];
/*  454 */             i |= (b & Byte.MAX_VALUE) << 28;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  459 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canReadVarInt() {
/*  464 */     if (this.limit - this.position >= 5) return true; 
/*  465 */     if (optional(5) <= 0) return false; 
/*  466 */     int i = this.position, j = this.limit;
/*      */     byte[] arrayOfByte;
/*  468 */     if (((arrayOfByte = this.buffer)[i++] & 0x80) == 0) return true; 
/*  469 */     if (i == j) return false; 
/*  470 */     if ((arrayOfByte[i++] & 0x80) == 0) return true; 
/*  471 */     if (i == j) return false; 
/*  472 */     if ((arrayOfByte[i++] & 0x80) == 0) return true; 
/*  473 */     if (i == j) return false; 
/*  474 */     if ((arrayOfByte[i++] & 0x80) == 0) return true; 
/*  475 */     if (i == j) return false; 
/*  476 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean readVarIntFlag() {
/*  482 */     if (this.position == this.limit) require(1); 
/*  483 */     return ((this.buffer[this.position] & 0x80) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int readVarIntFlag(boolean paramBoolean) {
/*  489 */     if (require(1) < 5) return readVarIntFlag_slow(paramBoolean); 
/*      */     byte b;
/*  491 */     int i = (b = this.buffer[this.position++]) & 0x3F;
/*  492 */     if ((b & 0x40) != 0) {
/*  493 */       byte[] arrayOfByte = this.buffer;
/*  494 */       int j = this.position;
/*  495 */       b = arrayOfByte[j++];
/*  496 */       i |= (b & Byte.MAX_VALUE) << 6;
/*  497 */       if ((b & 0x80) != 0) {
/*  498 */         b = arrayOfByte[j++];
/*  499 */         i |= (b & Byte.MAX_VALUE) << 13;
/*  500 */         if ((b & 0x80) != 0) {
/*  501 */           b = arrayOfByte[j++];
/*  502 */           i |= (b & Byte.MAX_VALUE) << 20;
/*  503 */           if ((b & 0x80) != 0) {
/*  504 */             b = arrayOfByte[j++];
/*  505 */             i |= (b & Byte.MAX_VALUE) << 27;
/*      */           } 
/*      */         } 
/*      */       } 
/*  509 */       this.position = j;
/*      */     } 
/*  511 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*      */   }
/*      */ 
/*      */   
/*      */   private int readVarIntFlag_slow(boolean paramBoolean) {
/*      */     byte b;
/*  517 */     int i = (b = this.buffer[this.position++]) & 0x3F;
/*  518 */     if ((b & 0x40) != 0) {
/*  519 */       if (this.position == this.limit) require(1); 
/*      */       byte[] arrayOfByte;
/*  521 */       b = (arrayOfByte = this.buffer)[this.position++];
/*  522 */       i |= (b & Byte.MAX_VALUE) << 6;
/*  523 */       if ((b & 0x80) != 0) {
/*  524 */         if (this.position == this.limit) require(1); 
/*  525 */         b = arrayOfByte[this.position++];
/*  526 */         i |= (b & Byte.MAX_VALUE) << 13;
/*  527 */         if ((b & 0x80) != 0) {
/*  528 */           if (this.position == this.limit) require(1); 
/*  529 */           b = arrayOfByte[this.position++];
/*  530 */           i |= (b & Byte.MAX_VALUE) << 20;
/*  531 */           if ((b & 0x80) != 0) {
/*  532 */             if (this.position == this.limit) require(1); 
/*  533 */             b = arrayOfByte[this.position++];
/*  534 */             i |= (b & Byte.MAX_VALUE) << 27;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  539 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long readLong() {
/*  546 */     require(8);
/*  547 */     byte[] arrayOfByte = this.buffer;
/*  548 */     int i = this.position;
/*  549 */     this.position = i + 8;
/*  550 */     return (arrayOfByte[i] & 0xFF | (arrayOfByte[i + 1] & 0xFF) << 8 | (arrayOfByte[i + 2] & 0xFF) << 16) | (arrayOfByte[i + 3] & 0xFF) << 24L | (arrayOfByte[i + 4] & 0xFF) << 32L | (arrayOfByte[i + 5] & 0xFF) << 40L | (arrayOfByte[i + 6] & 0xFF) << 48L | arrayOfByte[i + 7] << 56L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long readLong(boolean paramBoolean) {
/*  565 */     if (this.varEncoding) return readVarLong(paramBoolean); 
/*  566 */     return readLong();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public long readVarLong(boolean paramBoolean) {
/*  572 */     if (require(1) < 9) return readVarLong_slow(paramBoolean); 
/*  573 */     int i = this.position;
/*      */     byte b;
/*  575 */     long l = ((b = this.buffer[i++]) & Byte.MAX_VALUE);
/*  576 */     if ((b & 0x80) != 0) {
/*      */       byte[] arrayOfByte;
/*  578 */       b = (arrayOfByte = this.buffer)[i++];
/*  579 */       l |= ((b & Byte.MAX_VALUE) << 7);
/*  580 */       if ((b & 0x80) != 0) {
/*  581 */         b = arrayOfByte[i++];
/*  582 */         l |= ((b & Byte.MAX_VALUE) << 14);
/*  583 */         if ((b & 0x80) != 0) {
/*  584 */           b = arrayOfByte[i++];
/*  585 */           l |= ((b & Byte.MAX_VALUE) << 21);
/*  586 */           if ((b & 0x80) != 0) {
/*  587 */             b = arrayOfByte[i++];
/*  588 */             l |= (b & Byte.MAX_VALUE) << 28L;
/*  589 */             if ((b & 0x80) != 0) {
/*  590 */               b = arrayOfByte[i++];
/*  591 */               l |= (b & Byte.MAX_VALUE) << 35L;
/*  592 */               if ((b & 0x80) != 0) {
/*  593 */                 b = arrayOfByte[i++];
/*  594 */                 l |= (b & Byte.MAX_VALUE) << 42L;
/*  595 */                 if ((b & 0x80) != 0) {
/*  596 */                   b = arrayOfByte[i++];
/*  597 */                   l |= (b & Byte.MAX_VALUE) << 49L;
/*  598 */                   if ((b & 0x80) != 0) {
/*  599 */                     b = arrayOfByte[i++];
/*  600 */                     l |= b << 56L;
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  609 */     this.position = i;
/*  610 */     return paramBoolean ? l : (l >>> 1L ^ -(l & 0x1L));
/*      */   }
/*      */ 
/*      */   
/*      */   private long readVarLong_slow(boolean paramBoolean) {
/*      */     byte b;
/*  616 */     long l = ((b = this.buffer[this.position++]) & Byte.MAX_VALUE);
/*  617 */     if ((b & 0x80) != 0) {
/*  618 */       if (this.position == this.limit) require(1); 
/*      */       byte[] arrayOfByte;
/*  620 */       b = (arrayOfByte = this.buffer)[this.position++];
/*  621 */       l |= ((b & Byte.MAX_VALUE) << 7);
/*  622 */       if ((b & 0x80) != 0) {
/*  623 */         if (this.position == this.limit) require(1); 
/*  624 */         b = arrayOfByte[this.position++];
/*  625 */         l |= ((b & Byte.MAX_VALUE) << 14);
/*  626 */         if ((b & 0x80) != 0) {
/*  627 */           if (this.position == this.limit) require(1); 
/*  628 */           b = arrayOfByte[this.position++];
/*  629 */           l |= ((b & Byte.MAX_VALUE) << 21);
/*  630 */           if ((b & 0x80) != 0) {
/*  631 */             if (this.position == this.limit) require(1); 
/*  632 */             b = arrayOfByte[this.position++];
/*  633 */             l |= (b & Byte.MAX_VALUE) << 28L;
/*  634 */             if ((b & 0x80) != 0) {
/*  635 */               if (this.position == this.limit) require(1); 
/*  636 */               b = arrayOfByte[this.position++];
/*  637 */               l |= (b & Byte.MAX_VALUE) << 35L;
/*  638 */               if ((b & 0x80) != 0) {
/*  639 */                 if (this.position == this.limit) require(1); 
/*  640 */                 b = arrayOfByte[this.position++];
/*  641 */                 l |= (b & Byte.MAX_VALUE) << 42L;
/*  642 */                 if ((b & 0x80) != 0) {
/*  643 */                   if (this.position == this.limit) require(1); 
/*  644 */                   b = arrayOfByte[this.position++];
/*  645 */                   l |= (b & Byte.MAX_VALUE) << 49L;
/*  646 */                   if ((b & 0x80) != 0) {
/*  647 */                     if (this.position == this.limit) require(1); 
/*  648 */                     b = arrayOfByte[this.position++];
/*  649 */                     l |= b << 56L;
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  658 */     return paramBoolean ? l : (l >>> 1L ^ -(l & 0x1L));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canReadLong() {
/*  663 */     if (this.varEncoding) return canReadVarLong(); 
/*  664 */     if (this.limit - this.position >= 8) return true; 
/*  665 */     return (optional(8) == 8);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canReadVarLong() {
/*  670 */     if (this.limit - this.position >= 9) return true; 
/*  671 */     if (optional(5) <= 0) return false; 
/*  672 */     int i = this.position, j = this.limit;
/*      */     byte[] arrayOfByte;
/*  674 */     if (((arrayOfByte = this.buffer)[i++] & 0x80) == 0) return true; 
/*  675 */     if (i == j) return false; 
/*  676 */     if ((arrayOfByte[i++] & 0x80) == 0) return true; 
/*  677 */     if (i == j) return false; 
/*  678 */     if ((arrayOfByte[i++] & 0x80) == 0) return true; 
/*  679 */     if (i == j) return false; 
/*  680 */     if ((arrayOfByte[i++] & 0x80) == 0) return true; 
/*  681 */     if (i == j) return false; 
/*  682 */     if ((arrayOfByte[i++] & 0x80) == 0) return true; 
/*  683 */     if (i == j) return false; 
/*  684 */     if ((arrayOfByte[i++] & 0x80) == 0) return true; 
/*  685 */     if (i == j) return false; 
/*  686 */     if ((arrayOfByte[i++] & 0x80) == 0) return true; 
/*  687 */     if (i == j) return false; 
/*  688 */     if ((arrayOfByte[i++] & 0x80) == 0) return true; 
/*  689 */     if (i == j) return false; 
/*  690 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float readFloat() {
/*  697 */     require(4);
/*  698 */     byte[] arrayOfByte = this.buffer;
/*  699 */     int i = this.position;
/*  700 */     this.position = i + 4;
/*  701 */     return Float.intBitsToFloat(arrayOfByte[i] & 0xFF | (arrayOfByte[i + 1] & 0xFF) << 8 | (arrayOfByte[i + 2] & 0xFF) << 16 | (arrayOfByte[i + 3] & 0xFF) << 24);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float readVarFloat(float paramFloat, boolean paramBoolean) {
/*  709 */     return readVarInt(paramBoolean) / paramFloat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double readDouble() {
/*  716 */     require(8);
/*  717 */     byte[] arrayOfByte = this.buffer;
/*  718 */     int i = this.position;
/*  719 */     this.position = i + 8;
/*  720 */     return Double.longBitsToDouble((arrayOfByte[i] & 0xFF | (arrayOfByte[i + 1] & 0xFF) << 8 | (arrayOfByte[i + 2] & 0xFF) << 16) | (arrayOfByte[i + 3] & 0xFF) << 24L | (arrayOfByte[i + 4] & 0xFF) << 32L | (arrayOfByte[i + 5] & 0xFF) << 40L | (arrayOfByte[i + 6] & 0xFF) << 48L | arrayOfByte[i + 7] << 56L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double readVarDouble(double paramDouble, boolean paramBoolean) {
/*  732 */     return readVarLong(paramBoolean) / paramDouble;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short readShort() {
/*  739 */     require(2);
/*  740 */     int i = this.position;
/*  741 */     this.position = i + 2;
/*  742 */     return (short)(this.buffer[i] & 0xFF | (this.buffer[i + 1] & 0xFF) << 8);
/*      */   }
/*      */ 
/*      */   
/*      */   public int readShortUnsigned() {
/*  747 */     require(2);
/*  748 */     int i = this.position;
/*  749 */     this.position = i + 2;
/*  750 */     return this.buffer[i] & 0xFF | (this.buffer[i + 1] & 0xFF) << 8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char readChar() {
/*  757 */     require(2);
/*  758 */     int i = this.position;
/*  759 */     this.position = i + 2;
/*  760 */     return (char)(this.buffer[i] & 0xFF | (this.buffer[i + 1] & 0xFF) << 8);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean readBoolean() {
/*  767 */     if (this.position == this.limit) require(1); 
/*  768 */     return (this.buffer[this.position++] == 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String readString() {
/*  777 */     if (!readVarIntFlag()) return readAsciiString();
/*      */     
/*      */     int i;
/*  780 */     switch (i = readVarIntFlag(true)) {
/*      */       case 0:
/*  782 */         return null;
/*      */       case 1:
/*  784 */         return "";
/*      */     } 
/*  786 */     i--;
/*  787 */     readUtf8Chars(i);
/*  788 */     return new String(this.chars, 0, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder readStringBuilder() {
/*  796 */     if (!readVarIntFlag()) return new StringBuilder(readAsciiString());
/*      */     
/*      */     int i;
/*  799 */     switch (i = readVarIntFlag(true)) {
/*      */       case 0:
/*  801 */         return null;
/*      */       case 1:
/*  803 */         return new StringBuilder(0);
/*      */     } 
/*  805 */     i--;
/*  806 */     readUtf8Chars(i);
/*      */     StringBuilder stringBuilder;
/*  808 */     (stringBuilder = new StringBuilder(i)).append(this.chars, 0, i);
/*  809 */     return stringBuilder;
/*      */   }
/*      */   
/*      */   private void readUtf8Chars(int paramInt) {
/*  813 */     if (this.chars.length < paramInt) this.chars = new char[paramInt]; 
/*  814 */     byte[] arrayOfByte = this.buffer;
/*  815 */     char[] arrayOfChar = this.chars;
/*      */     
/*  817 */     byte b = 0;
/*  818 */     int i = Math.min(require(1), paramInt);
/*  819 */     int j = this.position;
/*  820 */     while (b < i) {
/*      */       byte b1;
/*  822 */       if ((b1 = arrayOfByte[j++]) < 0) {
/*  823 */         j--;
/*      */         break;
/*      */       } 
/*  826 */       arrayOfChar[b++] = (char)b1;
/*      */     } 
/*  828 */     this.position = j;
/*      */     
/*  830 */     if (b < paramInt) readUtf8Chars_slow(paramInt, b); 
/*      */   }
/*      */   
/*      */   private void readUtf8Chars_slow(int paramInt1, int paramInt2) {
/*  834 */     char[] arrayOfChar = this.chars;
/*  835 */     byte[] arrayOfByte = this.buffer;
/*  836 */     while (paramInt2 < paramInt1) {
/*  837 */       int j; if (this.position == this.limit) require(1); 
/*      */       int i;
/*  839 */       switch ((i = arrayOfByte[this.position++] & 0xFF) >> 4) {
/*      */         case 0:
/*      */         case 1:
/*      */         case 2:
/*      */         case 3:
/*      */         case 4:
/*      */         case 5:
/*      */         case 6:
/*      */         case 7:
/*  848 */           arrayOfChar[paramInt2] = (char)i;
/*      */           break;
/*      */         case 12:
/*      */         case 13:
/*  852 */           if (this.position == this.limit) require(1); 
/*  853 */           arrayOfChar[paramInt2] = (char)((i & 0x1F) << 6 | arrayOfByte[this.position++] & 0x3F);
/*      */           break;
/*      */         case 14:
/*  856 */           require(2);
/*  857 */           j = this.position;
/*  858 */           this.position = j + 2;
/*  859 */           arrayOfChar[paramInt2] = (char)((i & 0xF) << 12 | (arrayOfByte[j] & 0x3F) << 6 | arrayOfByte[j + 1] & 0x3F);
/*      */           break;
/*      */       } 
/*  862 */       paramInt2++;
/*      */     } 
/*      */   }
/*      */   
/*      */   private String readAsciiString() {
/*  867 */     char[] arrayOfChar = this.chars;
/*  868 */     byte[] arrayOfByte = this.buffer;
/*  869 */     int i = this.position;
/*  870 */     byte b = 0;
/*  871 */     for (int j = Math.min(arrayOfChar.length, this.limit - this.position); b < j; b++, i++) {
/*      */       byte b1;
/*  873 */       if (((b1 = arrayOfByte[i]) & 0x80) == 128) {
/*  874 */         this.position = i + 1;
/*  875 */         arrayOfChar[b] = (char)(b1 & Byte.MAX_VALUE);
/*  876 */         return new String(arrayOfChar, 0, b + 1);
/*      */       } 
/*  878 */       arrayOfChar[b] = (char)b1;
/*      */     } 
/*  880 */     this.position = i;
/*  881 */     return readAscii_slow(b);
/*      */   }
/*      */   
/*      */   private String readAscii_slow(int paramInt) {
/*  885 */     char[] arrayOfChar = this.chars;
/*  886 */     byte[] arrayOfByte = this.buffer;
/*      */     while (true) {
/*  888 */       if (this.position == this.limit) require(1); 
/*  889 */       byte b = arrayOfByte[this.position++];
/*  890 */       if (paramInt == arrayOfChar.length) {
/*  891 */         char[] arrayOfChar1 = new char[paramInt << 1];
/*  892 */         System.arraycopy(arrayOfChar, 0, arrayOfChar1, 0, paramInt);
/*  893 */         arrayOfChar = arrayOfChar1;
/*  894 */         this.chars = arrayOfChar1;
/*      */       } 
/*  896 */       if ((b & 0x80) == 128) {
/*  897 */         arrayOfChar[paramInt] = (char)(b & Byte.MAX_VALUE);
/*  898 */         return new String(arrayOfChar, 0, paramInt + 1);
/*      */       } 
/*  900 */       arrayOfChar[paramInt++] = (char)b;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] readInts(int paramInt) {
/*  908 */     int[] arrayOfInt = new int[paramInt];
/*  909 */     if (optional(paramInt << 2) == paramInt << 2) {
/*  910 */       byte[] arrayOfByte = this.buffer;
/*  911 */       int i = this.position;
/*  912 */       for (byte b = 0; b < paramInt; b++, i += 4) {
/*  913 */         arrayOfInt[b] = arrayOfByte[i] & 0xFF | (arrayOfByte[i + 1] & 0xFF) << 8 | (arrayOfByte[i + 2] & 0xFF) << 16 | (arrayOfByte[i + 3] & 0xFF) << 24;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  918 */       this.position = i;
/*      */     } else {
/*  920 */       for (byte b = 0; b < paramInt; b++)
/*  921 */         arrayOfInt[b] = readInt(); 
/*      */     } 
/*  923 */     return arrayOfInt;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] readInts(int paramInt, boolean paramBoolean) {
/*  929 */     if (this.varEncoding) {
/*  930 */       int[] arrayOfInt = new int[paramInt];
/*  931 */       for (byte b = 0; b < paramInt; b++)
/*  932 */         arrayOfInt[b] = readVarInt(paramBoolean); 
/*  933 */       return arrayOfInt;
/*      */     } 
/*  935 */     return readInts(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public long[] readLongs(int paramInt) {
/*  940 */     long[] arrayOfLong = new long[paramInt];
/*  941 */     if (optional(paramInt << 3) == paramInt << 3) {
/*  942 */       byte[] arrayOfByte = this.buffer;
/*  943 */       int i = this.position;
/*  944 */       for (byte b = 0; b < paramInt; b++, i += 8) {
/*  945 */         arrayOfLong[b] = (arrayOfByte[i] & 0xFF | (arrayOfByte[i + 1] & 0xFF) << 8 | (arrayOfByte[i + 2] & 0xFF) << 16) | (arrayOfByte[i + 3] & 0xFF) << 24L | (arrayOfByte[i + 4] & 0xFF) << 32L | (arrayOfByte[i + 5] & 0xFF) << 40L | (arrayOfByte[i + 6] & 0xFF) << 48L | arrayOfByte[i + 7] << 56L;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  954 */       this.position = i;
/*      */     } else {
/*  956 */       for (byte b = 0; b < paramInt; b++)
/*  957 */         arrayOfLong[b] = readLong(); 
/*      */     } 
/*  959 */     return arrayOfLong;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public long[] readLongs(int paramInt, boolean paramBoolean) {
/*  965 */     if (this.varEncoding) {
/*  966 */       long[] arrayOfLong = new long[paramInt];
/*  967 */       for (byte b = 0; b < paramInt; b++)
/*  968 */         arrayOfLong[b] = readVarLong(paramBoolean); 
/*  969 */       return arrayOfLong;
/*      */     } 
/*  971 */     return readLongs(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public float[] readFloats(int paramInt) {
/*  976 */     float[] arrayOfFloat = new float[paramInt];
/*  977 */     if (optional(paramInt << 2) == paramInt << 2) {
/*  978 */       byte[] arrayOfByte = this.buffer;
/*  979 */       int i = this.position;
/*  980 */       for (byte b = 0; b < paramInt; b++, i += 4) {
/*  981 */         arrayOfFloat[b] = Float.intBitsToFloat(arrayOfByte[i] & 0xFF | (arrayOfByte[i + 1] & 0xFF) << 8 | (arrayOfByte[i + 2] & 0xFF) << 16 | (arrayOfByte[i + 3] & 0xFF) << 24);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  986 */       this.position = i;
/*      */     } else {
/*  988 */       for (byte b = 0; b < paramInt; b++)
/*  989 */         arrayOfFloat[b] = readFloat(); 
/*      */     } 
/*  991 */     return arrayOfFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public double[] readDoubles(int paramInt) {
/*  996 */     double[] arrayOfDouble = new double[paramInt];
/*  997 */     if (optional(paramInt << 3) == paramInt << 3) {
/*  998 */       byte[] arrayOfByte = this.buffer;
/*  999 */       int i = this.position;
/* 1000 */       for (byte b = 0; b < paramInt; b++, i += 8) {
/* 1001 */         arrayOfDouble[b] = Double.longBitsToDouble((arrayOfByte[i] & 0xFF | (arrayOfByte[i + 1] & 0xFF) << 8 | (arrayOfByte[i + 2] & 0xFF) << 16) | (arrayOfByte[i + 3] & 0xFF) << 24L | (arrayOfByte[i + 4] & 0xFF) << 32L | (arrayOfByte[i + 5] & 0xFF) << 40L | (arrayOfByte[i + 6] & 0xFF) << 48L | arrayOfByte[i + 7] << 56L);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1010 */       this.position = i;
/*      */     } else {
/* 1012 */       for (byte b = 0; b < paramInt; b++)
/* 1013 */         arrayOfDouble[b] = readDouble(); 
/*      */     } 
/* 1015 */     return arrayOfDouble;
/*      */   }
/*      */ 
/*      */   
/*      */   public short[] readShorts(int paramInt) {
/* 1020 */     short[] arrayOfShort = new short[paramInt];
/* 1021 */     if (optional(paramInt << 1) == paramInt << 1) {
/* 1022 */       byte[] arrayOfByte = this.buffer;
/* 1023 */       int i = this.position;
/* 1024 */       for (byte b = 0; b < paramInt; b++, i += 2)
/* 1025 */         arrayOfShort[b] = (short)(arrayOfByte[i] & 0xFF | (arrayOfByte[i + 1] & 0xFF) << 8); 
/* 1026 */       this.position = i;
/*      */     } else {
/* 1028 */       for (byte b = 0; b < paramInt; b++)
/* 1029 */         arrayOfShort[b] = readShort(); 
/*      */     } 
/* 1031 */     return arrayOfShort;
/*      */   }
/*      */ 
/*      */   
/*      */   public char[] readChars(int paramInt) {
/* 1036 */     char[] arrayOfChar = new char[paramInt];
/* 1037 */     if (optional(paramInt << 1) == paramInt << 1) {
/* 1038 */       byte[] arrayOfByte = this.buffer;
/* 1039 */       int i = this.position;
/* 1040 */       for (byte b = 0; b < paramInt; b++, i += 2)
/* 1041 */         arrayOfChar[b] = (char)(arrayOfByte[i] & 0xFF | (arrayOfByte[i + 1] & 0xFF) << 8); 
/* 1042 */       this.position = i;
/*      */     } else {
/* 1044 */       for (byte b = 0; b < paramInt; b++)
/* 1045 */         arrayOfChar[b] = readChar(); 
/*      */     } 
/* 1047 */     return arrayOfChar;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean[] readBooleans(int paramInt) {
/* 1052 */     boolean[] arrayOfBoolean = new boolean[paramInt];
/* 1053 */     if (optional(paramInt) == paramInt) {
/* 1054 */       byte[] arrayOfByte = this.buffer;
/* 1055 */       int i = this.position;
/* 1056 */       for (byte b = 0; b < paramInt; b++, i++)
/* 1057 */         arrayOfBoolean[b] = (arrayOfByte[i] != 0); 
/* 1058 */       this.position = i;
/*      */     } else {
/* 1060 */       for (byte b = 0; b < paramInt; b++)
/* 1061 */         arrayOfBoolean[b] = readBoolean(); 
/*      */     } 
/* 1063 */     return arrayOfBoolean;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\Input.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */