/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import java.util.function.Consumer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
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
/*     */ @NativeType("struct statx")
/*     */ public class Statx
/*     */   extends Struct<Statx>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int STX_MASK;
/*     */   public static final int STX_BLKSIZE;
/*     */   public static final int STX_ATTRIBUTES;
/*     */   public static final int STX_NLINK;
/*     */   public static final int STX_UID;
/*     */   public static final int STX_GID;
/*     */   public static final int STX_MODE;
/*     */   public static final int __SPARE0;
/*     */   public static final int STX_INO;
/*     */   public static final int STX_SIZE;
/*     */   public static final int STX_BLOCKS;
/*     */   public static final int STX_ATTRIBUTES_MASK;
/*     */   public static final int STX_ATIME;
/*     */   public static final int STX_BTIME;
/*     */   public static final int STX_CTIME;
/*     */   public static final int STX_MTIME;
/*     */   public static final int STX_RDEV_MAJOR;
/*     */   public static final int STX_RDEV_MINOR;
/*     */   public static final int STX_DEV_MAJOR;
/*     */   public static final int STX_DEV_MINOR;
/*     */   public static final int STX_MNT_ID;
/*     */   public static final int __SPARE2;
/*     */   public static final int __SPARE3;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/* 111 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(8), __member(4), __member(4), __member(4), __member(2), __array(2, 1), __member(8), __member(8), __member(8), __member(8), __member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), __member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), __member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), __member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), __member(4), __member(4), __member(4), __member(4), __member(8), __member(8), __array(8, 12) })).getSize();
/* 112 */     ALIGNOF = layout.getAlignment();
/*     */     
/* 114 */     STX_MASK = layout.offsetof(0);
/* 115 */     STX_BLKSIZE = layout.offsetof(1);
/* 116 */     STX_ATTRIBUTES = layout.offsetof(2);
/* 117 */     STX_NLINK = layout.offsetof(3);
/* 118 */     STX_UID = layout.offsetof(4);
/* 119 */     STX_GID = layout.offsetof(5);
/* 120 */     STX_MODE = layout.offsetof(6);
/* 121 */     __SPARE0 = layout.offsetof(7);
/* 122 */     STX_INO = layout.offsetof(8);
/* 123 */     STX_SIZE = layout.offsetof(9);
/* 124 */     STX_BLOCKS = layout.offsetof(10);
/* 125 */     STX_ATTRIBUTES_MASK = layout.offsetof(11);
/* 126 */     STX_ATIME = layout.offsetof(12);
/* 127 */     STX_BTIME = layout.offsetof(13);
/* 128 */     STX_CTIME = layout.offsetof(14);
/* 129 */     STX_MTIME = layout.offsetof(15);
/* 130 */     STX_RDEV_MAJOR = layout.offsetof(16);
/* 131 */     STX_RDEV_MINOR = layout.offsetof(17);
/* 132 */     STX_DEV_MAJOR = layout.offsetof(18);
/* 133 */     STX_DEV_MINOR = layout.offsetof(19);
/* 134 */     STX_MNT_ID = layout.offsetof(20);
/* 135 */     __SPARE2 = layout.offsetof(21);
/* 136 */     __SPARE3 = layout.offsetof(22);
/*     */   }
/*     */   
/*     */   protected Statx(long paramLong, ByteBuffer paramByteBuffer) {
/* 140 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Statx create(long paramLong, ByteBuffer paramByteBuffer) {
/* 145 */     return new Statx(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Statx(ByteBuffer paramByteBuffer) {
/* 155 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 159 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int stx_mask() {
/* 163 */     return nstx_mask(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_blksize() {
/* 166 */     return nstx_blksize(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_attributes() {
/* 169 */     return nstx_attributes(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_nlink() {
/* 172 */     return nstx_nlink(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_uid() {
/* 175 */     return nstx_uid(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_gid() {
/* 178 */     return nstx_gid(address());
/*     */   } @NativeType("__u16")
/*     */   public short stx_mode() {
/* 181 */     return nstx_mode(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_ino() {
/* 184 */     return nstx_ino(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_size() {
/* 187 */     return nstx_size(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_blocks() {
/* 190 */     return nstx_blocks(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_attributes_mask() {
/* 193 */     return nstx_attributes_mask(address());
/*     */   } @NativeType("struct statx_timestamp")
/*     */   public StatxTimestamp stx_atime() {
/* 196 */     return nstx_atime(address());
/*     */   } @NativeType("struct statx_timestamp")
/*     */   public StatxTimestamp stx_btime() {
/* 199 */     return nstx_btime(address());
/*     */   } @NativeType("struct statx_timestamp")
/*     */   public StatxTimestamp stx_ctime() {
/* 202 */     return nstx_ctime(address());
/*     */   } @NativeType("struct statx_timestamp")
/*     */   public StatxTimestamp stx_mtime() {
/* 205 */     return nstx_mtime(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_rdev_major() {
/* 208 */     return nstx_rdev_major(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_rdev_minor() {
/* 211 */     return nstx_rdev_minor(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_dev_major() {
/* 214 */     return nstx_dev_major(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_dev_minor() {
/* 217 */     return nstx_dev_minor(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_mnt_id() {
/* 220 */     return nstx_mnt_id(address());
/*     */   }
/*     */   public Statx stx_mask(@NativeType("__u32") int paramInt) {
/* 223 */     nstx_mask(address(), paramInt); return this;
/*     */   } public Statx stx_blksize(@NativeType("__u32") int paramInt) {
/* 225 */     nstx_blksize(address(), paramInt); return this;
/*     */   } public Statx stx_attributes(@NativeType("__u64") long paramLong) {
/* 227 */     nstx_attributes(address(), paramLong); return this;
/*     */   } public Statx stx_nlink(@NativeType("__u32") int paramInt) {
/* 229 */     nstx_nlink(address(), paramInt); return this;
/*     */   } public Statx stx_uid(@NativeType("__u32") int paramInt) {
/* 231 */     nstx_uid(address(), paramInt); return this;
/*     */   } public Statx stx_gid(@NativeType("__u32") int paramInt) {
/* 233 */     nstx_gid(address(), paramInt); return this;
/*     */   } public Statx stx_mode(@NativeType("__u16") short paramShort) {
/* 235 */     nstx_mode(address(), paramShort); return this;
/*     */   } public Statx stx_ino(@NativeType("__u64") long paramLong) {
/* 237 */     nstx_ino(address(), paramLong); return this;
/*     */   } public Statx stx_size(@NativeType("__u64") long paramLong) {
/* 239 */     nstx_size(address(), paramLong); return this;
/*     */   } public Statx stx_blocks(@NativeType("__u64") long paramLong) {
/* 241 */     nstx_blocks(address(), paramLong); return this;
/*     */   } public Statx stx_attributes_mask(@NativeType("__u64") long paramLong) {
/* 243 */     nstx_attributes_mask(address(), paramLong); return this;
/*     */   } public Statx stx_atime(@NativeType("struct statx_timestamp") StatxTimestamp paramStatxTimestamp) {
/* 245 */     nstx_atime(address(), paramStatxTimestamp); return this;
/*     */   } public Statx stx_atime(Consumer<StatxTimestamp> paramConsumer) {
/* 247 */     paramConsumer.accept(stx_atime()); return this;
/*     */   } public Statx stx_btime(@NativeType("struct statx_timestamp") StatxTimestamp paramStatxTimestamp) {
/* 249 */     nstx_btime(address(), paramStatxTimestamp); return this;
/*     */   } public Statx stx_btime(Consumer<StatxTimestamp> paramConsumer) {
/* 251 */     paramConsumer.accept(stx_btime()); return this;
/*     */   } public Statx stx_ctime(@NativeType("struct statx_timestamp") StatxTimestamp paramStatxTimestamp) {
/* 253 */     nstx_ctime(address(), paramStatxTimestamp); return this;
/*     */   } public Statx stx_ctime(Consumer<StatxTimestamp> paramConsumer) {
/* 255 */     paramConsumer.accept(stx_ctime()); return this;
/*     */   } public Statx stx_mtime(@NativeType("struct statx_timestamp") StatxTimestamp paramStatxTimestamp) {
/* 257 */     nstx_mtime(address(), paramStatxTimestamp); return this;
/*     */   } public Statx stx_mtime(Consumer<StatxTimestamp> paramConsumer) {
/* 259 */     paramConsumer.accept(stx_mtime()); return this;
/*     */   } public Statx stx_rdev_major(@NativeType("__u32") int paramInt) {
/* 261 */     nstx_rdev_major(address(), paramInt); return this;
/*     */   } public Statx stx_rdev_minor(@NativeType("__u32") int paramInt) {
/* 263 */     nstx_rdev_minor(address(), paramInt); return this;
/*     */   } public Statx stx_dev_major(@NativeType("__u32") int paramInt) {
/* 265 */     nstx_dev_major(address(), paramInt); return this;
/*     */   } public Statx stx_dev_minor(@NativeType("__u32") int paramInt) {
/* 267 */     nstx_dev_minor(address(), paramInt); return this;
/*     */   } public Statx stx_mnt_id(@NativeType("__u64") long paramLong) {
/* 269 */     nstx_mnt_id(address(), paramLong); return this;
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
/*     */   public Statx set(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, short paramShort, long paramLong2, long paramLong3, long paramLong4, long paramLong5, StatxTimestamp paramStatxTimestamp1, StatxTimestamp paramStatxTimestamp2, StatxTimestamp paramStatxTimestamp3, StatxTimestamp paramStatxTimestamp4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong6) {
/* 294 */     stx_mask(paramInt1);
/* 295 */     stx_blksize(paramInt2);
/* 296 */     stx_attributes(paramLong1);
/* 297 */     stx_nlink(paramInt3);
/* 298 */     stx_uid(paramInt4);
/* 299 */     stx_gid(paramInt5);
/* 300 */     stx_mode(paramShort);
/* 301 */     stx_ino(paramLong2);
/* 302 */     stx_size(paramLong3);
/* 303 */     stx_blocks(paramLong4);
/* 304 */     stx_attributes_mask(paramLong5);
/* 305 */     stx_atime(paramStatxTimestamp1);
/* 306 */     stx_btime(paramStatxTimestamp2);
/* 307 */     stx_ctime(paramStatxTimestamp3);
/* 308 */     stx_mtime(paramStatxTimestamp4);
/* 309 */     stx_rdev_major(paramInt6);
/* 310 */     stx_rdev_minor(paramInt7);
/* 311 */     stx_dev_major(paramInt8);
/* 312 */     stx_dev_minor(paramInt9);
/* 313 */     stx_mnt_id(paramLong6);
/*     */     
/* 315 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Statx set(Statx paramStatx) {
/* 326 */     MemoryUtil.memCopy(paramStatx.address(), address(), SIZEOF);
/* 327 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Statx malloc() {
/* 334 */     return new Statx(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Statx calloc() {
/* 339 */     return new Statx(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Statx create() {
/* 344 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 345 */     return new Statx(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Statx create(long paramLong) {
/* 350 */     return new Statx(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Statx createSafe(long paramLong) {
/* 356 */     return (paramLong == 0L) ? null : new Statx(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 365 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 374 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 383 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 384 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 394 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 400 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Statx malloc(MemoryStack paramMemoryStack) {
/* 409 */     return new Statx(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Statx calloc(MemoryStack paramMemoryStack) {
/* 418 */     return new Statx(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 428 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 438 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nstx_mask(long paramLong) {
/* 444 */     return UNSAFE.getInt(null, paramLong + STX_MASK);
/*     */   } public static int nstx_blksize(long paramLong) {
/* 446 */     return UNSAFE.getInt(null, paramLong + STX_BLKSIZE);
/*     */   } public static long nstx_attributes(long paramLong) {
/* 448 */     return UNSAFE.getLong(null, paramLong + STX_ATTRIBUTES);
/*     */   } public static int nstx_nlink(long paramLong) {
/* 450 */     return UNSAFE.getInt(null, paramLong + STX_NLINK);
/*     */   } public static int nstx_uid(long paramLong) {
/* 452 */     return UNSAFE.getInt(null, paramLong + STX_UID);
/*     */   } public static int nstx_gid(long paramLong) {
/* 454 */     return UNSAFE.getInt(null, paramLong + STX_GID);
/*     */   }
/* 456 */   public static short nstx_mode(long paramLong) { return UNSAFE.getShort(null, paramLong + STX_MODE); } public static ShortBuffer n__spare0(long paramLong) {
/* 457 */     return MemoryUtil.memShortBuffer(paramLong + __SPARE0, 1);
/*     */   } public static short n__spare0(long paramLong, int paramInt) {
/* 459 */     return UNSAFE.getShort(null, paramLong + __SPARE0 + (Checks.check(paramInt, 1) << 1L));
/*     */   }
/*     */   public static long nstx_ino(long paramLong) {
/* 462 */     return UNSAFE.getLong(null, paramLong + STX_INO);
/*     */   } public static long nstx_size(long paramLong) {
/* 464 */     return UNSAFE.getLong(null, paramLong + STX_SIZE);
/*     */   } public static long nstx_blocks(long paramLong) {
/* 466 */     return UNSAFE.getLong(null, paramLong + STX_BLOCKS);
/*     */   } public static long nstx_attributes_mask(long paramLong) {
/* 468 */     return UNSAFE.getLong(null, paramLong + STX_ATTRIBUTES_MASK);
/*     */   } public static StatxTimestamp nstx_atime(long paramLong) {
/* 470 */     return StatxTimestamp.create(paramLong + STX_ATIME);
/*     */   } public static StatxTimestamp nstx_btime(long paramLong) {
/* 472 */     return StatxTimestamp.create(paramLong + STX_BTIME);
/*     */   } public static StatxTimestamp nstx_ctime(long paramLong) {
/* 474 */     return StatxTimestamp.create(paramLong + STX_CTIME);
/*     */   } public static StatxTimestamp nstx_mtime(long paramLong) {
/* 476 */     return StatxTimestamp.create(paramLong + STX_MTIME);
/*     */   } public static int nstx_rdev_major(long paramLong) {
/* 478 */     return UNSAFE.getInt(null, paramLong + STX_RDEV_MAJOR);
/*     */   } public static int nstx_rdev_minor(long paramLong) {
/* 480 */     return UNSAFE.getInt(null, paramLong + STX_RDEV_MINOR);
/*     */   } public static int nstx_dev_major(long paramLong) {
/* 482 */     return UNSAFE.getInt(null, paramLong + STX_DEV_MAJOR);
/*     */   } public static int nstx_dev_minor(long paramLong) {
/* 484 */     return UNSAFE.getInt(null, paramLong + STX_DEV_MINOR);
/*     */   }
/* 486 */   public static long nstx_mnt_id(long paramLong) { return UNSAFE.getLong(null, paramLong + STX_MNT_ID); }
/* 487 */   public static long n__spare2(long paramLong) { return UNSAFE.getLong(null, paramLong + __SPARE2); } public static LongBuffer n__spare3(long paramLong) {
/* 488 */     return MemoryUtil.memLongBuffer(paramLong + __SPARE3, 12);
/*     */   } public static long n__spare3(long paramLong, int paramInt) {
/* 490 */     return UNSAFE.getLong(null, paramLong + __SPARE3 + (Checks.check(paramInt, 12) << 3L));
/*     */   }
/*     */   
/*     */   public static void nstx_mask(long paramLong, int paramInt) {
/* 494 */     UNSAFE.putInt(null, paramLong + STX_MASK, paramInt);
/*     */   } public static void nstx_blksize(long paramLong, int paramInt) {
/* 496 */     UNSAFE.putInt(null, paramLong + STX_BLKSIZE, paramInt);
/*     */   } public static void nstx_attributes(long paramLong1, long paramLong2) {
/* 498 */     UNSAFE.putLong(null, paramLong1 + STX_ATTRIBUTES, paramLong2);
/*     */   } public static void nstx_nlink(long paramLong, int paramInt) {
/* 500 */     UNSAFE.putInt(null, paramLong + STX_NLINK, paramInt);
/*     */   } public static void nstx_uid(long paramLong, int paramInt) {
/* 502 */     UNSAFE.putInt(null, paramLong + STX_UID, paramInt);
/*     */   } public static void nstx_gid(long paramLong, int paramInt) {
/* 504 */     UNSAFE.putInt(null, paramLong + STX_GID, paramInt);
/*     */   } public static void nstx_mode(long paramLong, short paramShort) {
/* 506 */     UNSAFE.putShort(null, paramLong + STX_MODE, paramShort);
/*     */   } public static void n__spare0(long paramLong, ShortBuffer paramShortBuffer) {
/* 508 */     if (Checks.CHECKS) Checks.checkGT(paramShortBuffer, 1); 
/* 509 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramShortBuffer), paramLong + __SPARE0, (paramShortBuffer.remaining() << 1));
/*     */   }
/*     */   public static void n__spare0(long paramLong, int paramInt, short paramShort) {
/* 512 */     UNSAFE.putShort(null, paramLong + __SPARE0 + (Checks.check(paramInt, 1) << 1L), paramShort);
/*     */   }
/*     */   public static void nstx_ino(long paramLong1, long paramLong2) {
/* 515 */     UNSAFE.putLong(null, paramLong1 + STX_INO, paramLong2);
/*     */   } public static void nstx_size(long paramLong1, long paramLong2) {
/* 517 */     UNSAFE.putLong(null, paramLong1 + STX_SIZE, paramLong2);
/*     */   } public static void nstx_blocks(long paramLong1, long paramLong2) {
/* 519 */     UNSAFE.putLong(null, paramLong1 + STX_BLOCKS, paramLong2);
/*     */   } public static void nstx_attributes_mask(long paramLong1, long paramLong2) {
/* 521 */     UNSAFE.putLong(null, paramLong1 + STX_ATTRIBUTES_MASK, paramLong2);
/*     */   } public static void nstx_atime(long paramLong, StatxTimestamp paramStatxTimestamp) {
/* 523 */     MemoryUtil.memCopy(paramStatxTimestamp.address(), paramLong + STX_ATIME, StatxTimestamp.SIZEOF);
/*     */   } public static void nstx_btime(long paramLong, StatxTimestamp paramStatxTimestamp) {
/* 525 */     MemoryUtil.memCopy(paramStatxTimestamp.address(), paramLong + STX_BTIME, StatxTimestamp.SIZEOF);
/*     */   } public static void nstx_ctime(long paramLong, StatxTimestamp paramStatxTimestamp) {
/* 527 */     MemoryUtil.memCopy(paramStatxTimestamp.address(), paramLong + STX_CTIME, StatxTimestamp.SIZEOF);
/*     */   } public static void nstx_mtime(long paramLong, StatxTimestamp paramStatxTimestamp) {
/* 529 */     MemoryUtil.memCopy(paramStatxTimestamp.address(), paramLong + STX_MTIME, StatxTimestamp.SIZEOF);
/*     */   } public static void nstx_rdev_major(long paramLong, int paramInt) {
/* 531 */     UNSAFE.putInt(null, paramLong + STX_RDEV_MAJOR, paramInt);
/*     */   } public static void nstx_rdev_minor(long paramLong, int paramInt) {
/* 533 */     UNSAFE.putInt(null, paramLong + STX_RDEV_MINOR, paramInt);
/*     */   } public static void nstx_dev_major(long paramLong, int paramInt) {
/* 535 */     UNSAFE.putInt(null, paramLong + STX_DEV_MAJOR, paramInt);
/*     */   } public static void nstx_dev_minor(long paramLong, int paramInt) {
/* 537 */     UNSAFE.putInt(null, paramLong + STX_DEV_MINOR, paramInt);
/*     */   }
/* 539 */   public static void nstx_mnt_id(long paramLong1, long paramLong2) { UNSAFE.putLong(null, paramLong1 + STX_MNT_ID, paramLong2); } public static void n__spare2(long paramLong1, long paramLong2) {
/* 540 */     UNSAFE.putLong(null, paramLong1 + __SPARE2, paramLong2);
/*     */   } public static void n__spare3(long paramLong, LongBuffer paramLongBuffer) {
/* 542 */     if (Checks.CHECKS) Checks.checkGT(paramLongBuffer, 12); 
/* 543 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramLongBuffer), paramLong + __SPARE3, (paramLongBuffer.remaining() << 3));
/*     */   }
/*     */   public static void n__spare3(long paramLong1, int paramInt, long paramLong2) {
/* 546 */     UNSAFE.putLong(null, paramLong1 + __SPARE3 + (Checks.check(paramInt, 12) << 3L), paramLong2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<Statx, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 554 */     private static final Statx ELEMENT_FACTORY = Statx.create(-1L);
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
/*     */     public Buffer(ByteBuffer param1ByteBuffer) {
/* 566 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / Statx.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 570 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 574 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 579 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Statx getElementFactory() {
/* 584 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int stx_mask() {
/* 589 */       return Statx.nstx_mask(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_blksize() {
/* 592 */       return Statx.nstx_blksize(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_attributes() {
/* 595 */       return Statx.nstx_attributes(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_nlink() {
/* 598 */       return Statx.nstx_nlink(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_uid() {
/* 601 */       return Statx.nstx_uid(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_gid() {
/* 604 */       return Statx.nstx_gid(address());
/*     */     } @NativeType("__u16")
/*     */     public short stx_mode() {
/* 607 */       return Statx.nstx_mode(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_ino() {
/* 610 */       return Statx.nstx_ino(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_size() {
/* 613 */       return Statx.nstx_size(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_blocks() {
/* 616 */       return Statx.nstx_blocks(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_attributes_mask() {
/* 619 */       return Statx.nstx_attributes_mask(address());
/*     */     } @NativeType("struct statx_timestamp")
/*     */     public StatxTimestamp stx_atime() {
/* 622 */       return Statx.nstx_atime(address());
/*     */     } @NativeType("struct statx_timestamp")
/*     */     public StatxTimestamp stx_btime() {
/* 625 */       return Statx.nstx_btime(address());
/*     */     } @NativeType("struct statx_timestamp")
/*     */     public StatxTimestamp stx_ctime() {
/* 628 */       return Statx.nstx_ctime(address());
/*     */     } @NativeType("struct statx_timestamp")
/*     */     public StatxTimestamp stx_mtime() {
/* 631 */       return Statx.nstx_mtime(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_rdev_major() {
/* 634 */       return Statx.nstx_rdev_major(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_rdev_minor() {
/* 637 */       return Statx.nstx_rdev_minor(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_dev_major() {
/* 640 */       return Statx.nstx_dev_major(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_dev_minor() {
/* 643 */       return Statx.nstx_dev_minor(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_mnt_id() {
/* 646 */       return Statx.nstx_mnt_id(address());
/*     */     }
/*     */     public Buffer stx_mask(@NativeType("__u32") int param1Int) {
/* 649 */       Statx.nstx_mask(address(), param1Int); return this;
/*     */     } public Buffer stx_blksize(@NativeType("__u32") int param1Int) {
/* 651 */       Statx.nstx_blksize(address(), param1Int); return this;
/*     */     } public Buffer stx_attributes(@NativeType("__u64") long param1Long) {
/* 653 */       Statx.nstx_attributes(address(), param1Long); return this;
/*     */     } public Buffer stx_nlink(@NativeType("__u32") int param1Int) {
/* 655 */       Statx.nstx_nlink(address(), param1Int); return this;
/*     */     } public Buffer stx_uid(@NativeType("__u32") int param1Int) {
/* 657 */       Statx.nstx_uid(address(), param1Int); return this;
/*     */     } public Buffer stx_gid(@NativeType("__u32") int param1Int) {
/* 659 */       Statx.nstx_gid(address(), param1Int); return this;
/*     */     } public Buffer stx_mode(@NativeType("__u16") short param1Short) {
/* 661 */       Statx.nstx_mode(address(), param1Short); return this;
/*     */     } public Buffer stx_ino(@NativeType("__u64") long param1Long) {
/* 663 */       Statx.nstx_ino(address(), param1Long); return this;
/*     */     } public Buffer stx_size(@NativeType("__u64") long param1Long) {
/* 665 */       Statx.nstx_size(address(), param1Long); return this;
/*     */     } public Buffer stx_blocks(@NativeType("__u64") long param1Long) {
/* 667 */       Statx.nstx_blocks(address(), param1Long); return this;
/*     */     } public Buffer stx_attributes_mask(@NativeType("__u64") long param1Long) {
/* 669 */       Statx.nstx_attributes_mask(address(), param1Long); return this;
/*     */     } public Buffer stx_atime(@NativeType("struct statx_timestamp") StatxTimestamp param1StatxTimestamp) {
/* 671 */       Statx.nstx_atime(address(), param1StatxTimestamp); return this;
/*     */     } public Buffer stx_atime(Consumer<StatxTimestamp> param1Consumer) {
/* 673 */       param1Consumer.accept(stx_atime()); return this;
/*     */     } public Buffer stx_btime(@NativeType("struct statx_timestamp") StatxTimestamp param1StatxTimestamp) {
/* 675 */       Statx.nstx_btime(address(), param1StatxTimestamp); return this;
/*     */     } public Buffer stx_btime(Consumer<StatxTimestamp> param1Consumer) {
/* 677 */       param1Consumer.accept(stx_btime()); return this;
/*     */     } public Buffer stx_ctime(@NativeType("struct statx_timestamp") StatxTimestamp param1StatxTimestamp) {
/* 679 */       Statx.nstx_ctime(address(), param1StatxTimestamp); return this;
/*     */     } public Buffer stx_ctime(Consumer<StatxTimestamp> param1Consumer) {
/* 681 */       param1Consumer.accept(stx_ctime()); return this;
/*     */     } public Buffer stx_mtime(@NativeType("struct statx_timestamp") StatxTimestamp param1StatxTimestamp) {
/* 683 */       Statx.nstx_mtime(address(), param1StatxTimestamp); return this;
/*     */     } public Buffer stx_mtime(Consumer<StatxTimestamp> param1Consumer) {
/* 685 */       param1Consumer.accept(stx_mtime()); return this;
/*     */     } public Buffer stx_rdev_major(@NativeType("__u32") int param1Int) {
/* 687 */       Statx.nstx_rdev_major(address(), param1Int); return this;
/*     */     } public Buffer stx_rdev_minor(@NativeType("__u32") int param1Int) {
/* 689 */       Statx.nstx_rdev_minor(address(), param1Int); return this;
/*     */     } public Buffer stx_dev_major(@NativeType("__u32") int param1Int) {
/* 691 */       Statx.nstx_dev_major(address(), param1Int); return this;
/*     */     } public Buffer stx_dev_minor(@NativeType("__u32") int param1Int) {
/* 693 */       Statx.nstx_dev_minor(address(), param1Int); return this;
/*     */     } public Buffer stx_mnt_id(@NativeType("__u64") long param1Long) {
/* 695 */       Statx.nstx_mnt_id(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\Statx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */