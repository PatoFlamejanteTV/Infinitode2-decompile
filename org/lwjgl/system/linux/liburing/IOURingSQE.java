/*      */ package org.lwjgl.system.linux.liburing;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.BufferUtils;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeResource;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Struct;
/*      */ import org.lwjgl.system.StructBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @NativeType("struct io_uring_sqe")
/*      */ public class IOURingSQE
/*      */   extends Struct<IOURingSQE>
/*      */   implements NativeResource
/*      */ {
/*      */   public static final int SIZEOF;
/*      */   public static final int ALIGNOF;
/*      */   public static final int OPCODE;
/*      */   public static final int FLAGS;
/*      */   public static final int IOPRIO;
/*      */   public static final int FD;
/*      */   public static final int OFF;
/*      */   public static final int ADDR2;
/*      */   public static final int CMD_OP;
/*      */   public static final int __PAD1;
/*      */   public static final int ADDR;
/*      */   public static final int SPLICE_OFF_IN;
/*      */   public static final int LEN;
/*      */   public static final int RW_FLAGS;
/*      */   public static final int FSYNC_FLAGS;
/*      */   public static final int POLL_EVENTS;
/*      */   public static final int POLL32_EVENTS;
/*      */   public static final int SYNC_RANGE_FLAGS;
/*      */   public static final int MSG_FLAGS;
/*      */   public static final int TIMEOUT_FLAGS;
/*      */   public static final int ACCEPT_FLAGS;
/*      */   public static final int CANCEL_FLAGS;
/*      */   public static final int OPEN_FLAGS;
/*      */   public static final int STATX_FLAGS;
/*      */   public static final int FADVISE_ADVICE;
/*      */   public static final int SPLICE_FLAGS;
/*      */   public static final int RENAME_FLAGS;
/*      */   public static final int UNLINK_FLAGS;
/*      */   public static final int HARDLINK_FLAGS;
/*      */   public static final int XATTR_FLAGS;
/*      */   public static final int MSG_RING_FLAGS;
/*      */   public static final int URING_CMD_FLAGS;
/*      */   public static final int USER_DATA;
/*      */   public static final int BUF_INDEX;
/*      */   public static final int BUF_GROUP;
/*      */   public static final int PERSONALITY;
/*      */   public static final int SPLICE_FD_IN;
/*      */   public static final int FILE_INDEX;
/*      */   public static final int ADDR_LEN;
/*      */   public static final int __PAD3;
/*      */   public static final int ADDR3;
/*      */   public static final int __PAD2;
/*      */   public static final int CMD;
/*      */   
/*      */   static {
/*      */     Struct.Layout layout;
/*  206 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(1), __member(1), __member(2), __member(4), (Struct.Member)__union(new Struct.Member[] { __member(8), __member(8), (Struct.Member)__struct(new Struct.Member[] { __member(4), __member(4) }) }), (Struct.Member)__union(new Struct.Member[] { __member(8), __member(8) }), __member(4), (Struct.Member)__union(new Struct.Member[] { __member(4), __member(4), __member(2), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4) }), __member(8), (Struct.Member)__union(new Struct.Member[] { __member(2), __member(2) }), __member(2), (Struct.Member)__union(new Struct.Member[] { __member(4), __member(4), (Struct.Member)__struct(new Struct.Member[] { __member(2), __array(2, 1) }) }), (Struct.Member)__union(new Struct.Member[] { (Struct.Member)__struct(new Struct.Member[] { __member(8), __array(8, 1) }), __array(1, 0) }) })).getSize();
/*  207 */     ALIGNOF = layout.getAlignment();
/*      */     
/*  209 */     OPCODE = layout.offsetof(0);
/*  210 */     FLAGS = layout.offsetof(1);
/*  211 */     IOPRIO = layout.offsetof(2);
/*  212 */     FD = layout.offsetof(3);
/*  213 */     OFF = layout.offsetof(5);
/*  214 */     ADDR2 = layout.offsetof(6);
/*  215 */     CMD_OP = layout.offsetof(8);
/*  216 */     __PAD1 = layout.offsetof(9);
/*  217 */     ADDR = layout.offsetof(11);
/*  218 */     SPLICE_OFF_IN = layout.offsetof(12);
/*  219 */     LEN = layout.offsetof(13);
/*  220 */     RW_FLAGS = layout.offsetof(15);
/*  221 */     FSYNC_FLAGS = layout.offsetof(16);
/*  222 */     POLL_EVENTS = layout.offsetof(17);
/*  223 */     POLL32_EVENTS = layout.offsetof(18);
/*  224 */     SYNC_RANGE_FLAGS = layout.offsetof(19);
/*  225 */     MSG_FLAGS = layout.offsetof(20);
/*  226 */     TIMEOUT_FLAGS = layout.offsetof(21);
/*  227 */     ACCEPT_FLAGS = layout.offsetof(22);
/*  228 */     CANCEL_FLAGS = layout.offsetof(23);
/*  229 */     OPEN_FLAGS = layout.offsetof(24);
/*  230 */     STATX_FLAGS = layout.offsetof(25);
/*  231 */     FADVISE_ADVICE = layout.offsetof(26);
/*  232 */     SPLICE_FLAGS = layout.offsetof(27);
/*  233 */     RENAME_FLAGS = layout.offsetof(28);
/*  234 */     UNLINK_FLAGS = layout.offsetof(29);
/*  235 */     HARDLINK_FLAGS = layout.offsetof(30);
/*  236 */     XATTR_FLAGS = layout.offsetof(31);
/*  237 */     MSG_RING_FLAGS = layout.offsetof(32);
/*  238 */     URING_CMD_FLAGS = layout.offsetof(33);
/*  239 */     USER_DATA = layout.offsetof(34);
/*  240 */     BUF_INDEX = layout.offsetof(36);
/*  241 */     BUF_GROUP = layout.offsetof(37);
/*  242 */     PERSONALITY = layout.offsetof(38);
/*  243 */     SPLICE_FD_IN = layout.offsetof(40);
/*  244 */     FILE_INDEX = layout.offsetof(41);
/*  245 */     ADDR_LEN = layout.offsetof(43);
/*  246 */     __PAD3 = layout.offsetof(44);
/*  247 */     ADDR3 = layout.offsetof(47);
/*  248 */     __PAD2 = layout.offsetof(48);
/*  249 */     CMD = layout.offsetof(49);
/*      */   }
/*      */   
/*      */   protected IOURingSQE(long paramLong, ByteBuffer paramByteBuffer) {
/*  253 */     super(paramLong, paramByteBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   protected IOURingSQE create(long paramLong, ByteBuffer paramByteBuffer) {
/*  258 */     return new IOURingSQE(paramLong, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IOURingSQE(ByteBuffer paramByteBuffer) {
/*  268 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*      */   }
/*      */   
/*      */   public int sizeof() {
/*  272 */     return SIZEOF;
/*      */   }
/*      */   @NativeType("__u8")
/*      */   public byte opcode() {
/*  276 */     return nopcode(address());
/*      */   } @NativeType("__u8")
/*      */   public byte flags() {
/*  279 */     return nflags(address());
/*      */   } @NativeType("__u16")
/*      */   public short ioprio() {
/*  282 */     return nioprio(address());
/*      */   } @NativeType("__s32")
/*      */   public int fd() {
/*  285 */     return nfd(address());
/*      */   } @NativeType("__u64")
/*      */   public long off() {
/*  288 */     return noff(address());
/*      */   } @NativeType("__u64")
/*      */   public long addr2() {
/*  291 */     return naddr2(address());
/*      */   } @NativeType("__u32")
/*      */   public int cmd_op() {
/*  294 */     return ncmd_op(address());
/*      */   } @NativeType("__u32")
/*      */   public int __pad1() {
/*  297 */     return n__pad1(address());
/*      */   } @NativeType("__u64")
/*      */   public long addr() {
/*  300 */     return naddr(address());
/*      */   } @NativeType("__u64")
/*      */   public long splice_off_in() {
/*  303 */     return nsplice_off_in(address());
/*      */   } @NativeType("__u32")
/*      */   public int len() {
/*  306 */     return nlen(address());
/*      */   } @NativeType("__kernel_rwf_t")
/*      */   public int rw_flags() {
/*  309 */     return nrw_flags(address());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("__u32")
/*      */   public int fsync_flags() {
/*  316 */     return nfsync_flags(address());
/*      */   } @NativeType("__u16")
/*      */   public short poll_events() {
/*  319 */     return npoll_events(address());
/*      */   } @NativeType("__u32")
/*      */   public int poll32_events() {
/*  322 */     return npoll32_events(address());
/*      */   } @NativeType("__u32")
/*      */   public int sync_range_flags() {
/*  325 */     return nsync_range_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int msg_flags() {
/*  328 */     return nmsg_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int timeout_flags() {
/*  331 */     return ntimeout_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int accept_flags() {
/*  334 */     return naccept_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int cancel_flags() {
/*  337 */     return ncancel_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int open_flags() {
/*  340 */     return nopen_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int statx_flags() {
/*  343 */     return nstatx_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int fadvise_advice() {
/*  346 */     return nfadvise_advice(address());
/*      */   } @NativeType("__u32")
/*      */   public int splice_flags() {
/*  349 */     return nsplice_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int rename_flags() {
/*  352 */     return nrename_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int unlink_flags() {
/*  355 */     return nunlink_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int hardlink_flags() {
/*  358 */     return nhardlink_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int xattr_flags() {
/*  361 */     return nxattr_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int msg_ring_flags() {
/*  364 */     return nmsg_ring_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int uring_cmd_flags() {
/*  367 */     return nuring_cmd_flags(address());
/*      */   } @NativeType("__u64")
/*      */   public long user_data() {
/*  370 */     return nuser_data(address());
/*      */   } @NativeType("__u16")
/*      */   public short buf_index() {
/*  373 */     return nbuf_index(address());
/*      */   } @NativeType("__u16")
/*      */   public short buf_group() {
/*  376 */     return nbuf_group(address());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("__u16")
/*      */   public short personality() {
/*  383 */     return npersonality(address());
/*      */   } @NativeType("__s32")
/*      */   public int splice_fd_in() {
/*  386 */     return nsplice_fd_in(address());
/*      */   } @NativeType("__u32")
/*      */   public int file_index() {
/*  389 */     return nfile_index(address());
/*      */   } @NativeType("__u16")
/*      */   public short addr_len() {
/*  392 */     return naddr_len(address());
/*      */   } @NativeType("__u16[1]")
/*      */   public ShortBuffer __pad3() {
/*  395 */     return n__pad3(address());
/*      */   } @NativeType("__u16")
/*      */   public short __pad3(int paramInt) {
/*  398 */     return n__pad3(address(), paramInt);
/*      */   } @NativeType("__u64")
/*      */   public long addr3() {
/*  401 */     return naddr3(address());
/*      */   } @NativeType("__u64[1]")
/*      */   public LongBuffer __pad2() {
/*  404 */     return n__pad2(address());
/*      */   } @NativeType("__u64")
/*      */   public long __pad2(int paramInt) {
/*  407 */     return n__pad2(address(), paramInt);
/*      */   } @NativeType("__u8[0]")
/*      */   public ByteBuffer cmd() {
/*  410 */     return ncmd(address());
/*      */   } @NativeType("__u8")
/*      */   public byte cmd(int paramInt) {
/*  413 */     return ncmd(address(), paramInt);
/*      */   }
/*      */   public IOURingSQE opcode(@NativeType("__u8") byte paramByte) {
/*  416 */     nopcode(address(), paramByte); return this;
/*      */   } public IOURingSQE flags(@NativeType("__u8") byte paramByte) {
/*  418 */     nflags(address(), paramByte); return this;
/*      */   } public IOURingSQE ioprio(@NativeType("__u16") short paramShort) {
/*  420 */     nioprio(address(), paramShort); return this;
/*      */   } public IOURingSQE fd(@NativeType("__s32") int paramInt) {
/*  422 */     nfd(address(), paramInt); return this;
/*      */   } public IOURingSQE off(@NativeType("__u64") long paramLong) {
/*  424 */     noff(address(), paramLong); return this;
/*      */   } public IOURingSQE addr2(@NativeType("__u64") long paramLong) {
/*  426 */     naddr2(address(), paramLong); return this;
/*      */   } public IOURingSQE cmd_op(@NativeType("__u32") int paramInt) {
/*  428 */     ncmd_op(address(), paramInt); return this;
/*      */   } public IOURingSQE __pad1(@NativeType("__u32") int paramInt) {
/*  430 */     n__pad1(address(), paramInt); return this;
/*      */   } public IOURingSQE addr(@NativeType("__u64") long paramLong) {
/*  432 */     naddr(address(), paramLong); return this;
/*      */   } public IOURingSQE splice_off_in(@NativeType("__u64") long paramLong) {
/*  434 */     nsplice_off_in(address(), paramLong); return this;
/*      */   } public IOURingSQE len(@NativeType("__u32") int paramInt) {
/*  436 */     nlen(address(), paramInt); return this;
/*      */   } public IOURingSQE rw_flags(@NativeType("__kernel_rwf_t") int paramInt) {
/*  438 */     nrw_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE fsync_flags(@NativeType("__u32") int paramInt) {
/*  440 */     nfsync_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE poll_events(@NativeType("__u16") short paramShort) {
/*  442 */     npoll_events(address(), paramShort); return this;
/*      */   } public IOURingSQE poll32_events(@NativeType("__u32") int paramInt) {
/*  444 */     npoll32_events(address(), paramInt); return this;
/*      */   } public IOURingSQE sync_range_flags(@NativeType("__u32") int paramInt) {
/*  446 */     nsync_range_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE msg_flags(@NativeType("__u32") int paramInt) {
/*  448 */     nmsg_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE timeout_flags(@NativeType("__u32") int paramInt) {
/*  450 */     ntimeout_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE accept_flags(@NativeType("__u32") int paramInt) {
/*  452 */     naccept_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE cancel_flags(@NativeType("__u32") int paramInt) {
/*  454 */     ncancel_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE open_flags(@NativeType("__u32") int paramInt) {
/*  456 */     nopen_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE statx_flags(@NativeType("__u32") int paramInt) {
/*  458 */     nstatx_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE fadvise_advice(@NativeType("__u32") int paramInt) {
/*  460 */     nfadvise_advice(address(), paramInt); return this;
/*      */   } public IOURingSQE splice_flags(@NativeType("__u32") int paramInt) {
/*  462 */     nsplice_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE rename_flags(@NativeType("__u32") int paramInt) {
/*  464 */     nrename_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE unlink_flags(@NativeType("__u32") int paramInt) {
/*  466 */     nunlink_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE hardlink_flags(@NativeType("__u32") int paramInt) {
/*  468 */     nhardlink_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE xattr_flags(@NativeType("__u32") int paramInt) {
/*  470 */     nxattr_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE msg_ring_flags(@NativeType("__u32") int paramInt) {
/*  472 */     nmsg_ring_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE uring_cmd_flags(@NativeType("__u32") int paramInt) {
/*  474 */     nuring_cmd_flags(address(), paramInt); return this;
/*      */   } public IOURingSQE user_data(@NativeType("__u64") long paramLong) {
/*  476 */     nuser_data(address(), paramLong); return this;
/*      */   } public IOURingSQE buf_index(@NativeType("__u16") short paramShort) {
/*  478 */     nbuf_index(address(), paramShort); return this;
/*      */   } public IOURingSQE buf_group(@NativeType("__u16") short paramShort) {
/*  480 */     nbuf_group(address(), paramShort); return this;
/*      */   } public IOURingSQE personality(@NativeType("__u16") short paramShort) {
/*  482 */     npersonality(address(), paramShort); return this;
/*      */   } public IOURingSQE splice_fd_in(@NativeType("__s32") int paramInt) {
/*  484 */     nsplice_fd_in(address(), paramInt); return this;
/*      */   } public IOURingSQE file_index(@NativeType("__u32") int paramInt) {
/*  486 */     nfile_index(address(), paramInt); return this;
/*      */   } public IOURingSQE addr_len(@NativeType("__u16") short paramShort) {
/*  488 */     naddr_len(address(), paramShort); return this;
/*      */   } public IOURingSQE __pad3(@NativeType("__u16[1]") ShortBuffer paramShortBuffer) {
/*  490 */     n__pad3(address(), paramShortBuffer); return this;
/*      */   } public IOURingSQE __pad3(int paramInt, @NativeType("__u16") short paramShort) {
/*  492 */     n__pad3(address(), paramInt, paramShort); return this;
/*      */   } public IOURingSQE addr3(@NativeType("__u64") long paramLong) {
/*  494 */     naddr3(address(), paramLong); return this;
/*      */   } public IOURingSQE __pad2(@NativeType("__u64[1]") LongBuffer paramLongBuffer) {
/*  496 */     n__pad2(address(), paramLongBuffer); return this;
/*      */   } public IOURingSQE __pad2(int paramInt, @NativeType("__u64") long paramLong) {
/*  498 */     n__pad2(address(), paramInt, paramLong); return this;
/*      */   } public IOURingSQE cmd(@NativeType("__u8[0]") ByteBuffer paramByteBuffer) {
/*  500 */     ncmd(address(), paramByteBuffer); return this;
/*      */   } public IOURingSQE cmd(int paramInt, @NativeType("__u8") byte paramByte) {
/*  502 */     ncmd(address(), paramInt, paramByte); return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IOURingSQE set(IOURingSQE paramIOURingSQE) {
/*  512 */     MemoryUtil.memCopy(paramIOURingSQE.address(), address(), SIZEOF);
/*  513 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IOURingSQE malloc() {
/*  520 */     return new IOURingSQE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*      */   }
/*      */ 
/*      */   
/*      */   public static IOURingSQE calloc() {
/*  525 */     return new IOURingSQE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*      */   }
/*      */ 
/*      */   
/*      */   public static IOURingSQE create() {
/*  530 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/*  531 */     return new IOURingSQE(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static IOURingSQE create(long paramLong) {
/*  536 */     return new IOURingSQE(paramLong, null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static IOURingSQE createSafe(long paramLong) {
/*  542 */     return (paramLong == 0L) ? null : new IOURingSQE(paramLong, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer malloc(int paramInt) {
/*  551 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer calloc(int paramInt) {
/*  560 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer create(int paramInt) {
/*  569 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/*  570 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer create(long paramLong, int paramInt) {
/*  580 */     return new Buffer(paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer createSafe(long paramLong, int paramInt) {
/*  586 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IOURingSQE malloc(MemoryStack paramMemoryStack) {
/*  595 */     return new IOURingSQE(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IOURingSQE calloc(MemoryStack paramMemoryStack) {
/*  604 */     return new IOURingSQE(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/*  614 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/*  624 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte nopcode(long paramLong) {
/*  630 */     return UNSAFE.getByte(null, paramLong + OPCODE);
/*      */   } public static byte nflags(long paramLong) {
/*  632 */     return UNSAFE.getByte(null, paramLong + FLAGS);
/*      */   } public static short nioprio(long paramLong) {
/*  634 */     return UNSAFE.getShort(null, paramLong + IOPRIO);
/*      */   } public static int nfd(long paramLong) {
/*  636 */     return UNSAFE.getInt(null, paramLong + FD);
/*      */   } public static long noff(long paramLong) {
/*  638 */     return UNSAFE.getLong(null, paramLong + OFF);
/*      */   } public static long naddr2(long paramLong) {
/*  640 */     return UNSAFE.getLong(null, paramLong + ADDR2);
/*      */   }
/*  642 */   public static int ncmd_op(long paramLong) { return UNSAFE.getInt(null, paramLong + CMD_OP); } public static int n__pad1(long paramLong) {
/*  643 */     return UNSAFE.getInt(null, paramLong + __PAD1);
/*      */   } public static long naddr(long paramLong) {
/*  645 */     return UNSAFE.getLong(null, paramLong + ADDR);
/*      */   } public static long nsplice_off_in(long paramLong) {
/*  647 */     return UNSAFE.getLong(null, paramLong + SPLICE_OFF_IN);
/*      */   } public static int nlen(long paramLong) {
/*  649 */     return UNSAFE.getInt(null, paramLong + LEN);
/*      */   } public static int nrw_flags(long paramLong) {
/*  651 */     return UNSAFE.getInt(null, paramLong + RW_FLAGS);
/*      */   } public static int nfsync_flags(long paramLong) {
/*  653 */     return UNSAFE.getInt(null, paramLong + FSYNC_FLAGS);
/*      */   } public static short npoll_events(long paramLong) {
/*  655 */     return UNSAFE.getShort(null, paramLong + POLL_EVENTS);
/*      */   } public static int npoll32_events(long paramLong) {
/*  657 */     return UNSAFE.getInt(null, paramLong + POLL32_EVENTS);
/*      */   } public static int nsync_range_flags(long paramLong) {
/*  659 */     return UNSAFE.getInt(null, paramLong + SYNC_RANGE_FLAGS);
/*      */   } public static int nmsg_flags(long paramLong) {
/*  661 */     return UNSAFE.getInt(null, paramLong + MSG_FLAGS);
/*      */   } public static int ntimeout_flags(long paramLong) {
/*  663 */     return UNSAFE.getInt(null, paramLong + TIMEOUT_FLAGS);
/*      */   } public static int naccept_flags(long paramLong) {
/*  665 */     return UNSAFE.getInt(null, paramLong + ACCEPT_FLAGS);
/*      */   } public static int ncancel_flags(long paramLong) {
/*  667 */     return UNSAFE.getInt(null, paramLong + CANCEL_FLAGS);
/*      */   } public static int nopen_flags(long paramLong) {
/*  669 */     return UNSAFE.getInt(null, paramLong + OPEN_FLAGS);
/*      */   } public static int nstatx_flags(long paramLong) {
/*  671 */     return UNSAFE.getInt(null, paramLong + STATX_FLAGS);
/*      */   } public static int nfadvise_advice(long paramLong) {
/*  673 */     return UNSAFE.getInt(null, paramLong + FADVISE_ADVICE);
/*      */   } public static int nsplice_flags(long paramLong) {
/*  675 */     return UNSAFE.getInt(null, paramLong + SPLICE_FLAGS);
/*      */   } public static int nrename_flags(long paramLong) {
/*  677 */     return UNSAFE.getInt(null, paramLong + RENAME_FLAGS);
/*      */   } public static int nunlink_flags(long paramLong) {
/*  679 */     return UNSAFE.getInt(null, paramLong + UNLINK_FLAGS);
/*      */   } public static int nhardlink_flags(long paramLong) {
/*  681 */     return UNSAFE.getInt(null, paramLong + HARDLINK_FLAGS);
/*      */   } public static int nxattr_flags(long paramLong) {
/*  683 */     return UNSAFE.getInt(null, paramLong + XATTR_FLAGS);
/*      */   } public static int nmsg_ring_flags(long paramLong) {
/*  685 */     return UNSAFE.getInt(null, paramLong + MSG_RING_FLAGS);
/*      */   } public static int nuring_cmd_flags(long paramLong) {
/*  687 */     return UNSAFE.getInt(null, paramLong + URING_CMD_FLAGS);
/*      */   } public static long nuser_data(long paramLong) {
/*  689 */     return UNSAFE.getLong(null, paramLong + USER_DATA);
/*      */   } public static short nbuf_index(long paramLong) {
/*  691 */     return UNSAFE.getShort(null, paramLong + BUF_INDEX);
/*      */   } public static short nbuf_group(long paramLong) {
/*  693 */     return UNSAFE.getShort(null, paramLong + BUF_GROUP);
/*      */   } public static short npersonality(long paramLong) {
/*  695 */     return UNSAFE.getShort(null, paramLong + PERSONALITY);
/*      */   } public static int nsplice_fd_in(long paramLong) {
/*  697 */     return UNSAFE.getInt(null, paramLong + SPLICE_FD_IN);
/*      */   } public static int nfile_index(long paramLong) {
/*  699 */     return UNSAFE.getInt(null, paramLong + FILE_INDEX);
/*      */   }
/*  701 */   public static short naddr_len(long paramLong) { return UNSAFE.getShort(null, paramLong + ADDR_LEN); } public static ShortBuffer n__pad3(long paramLong) {
/*  702 */     return MemoryUtil.memShortBuffer(paramLong + __PAD3, 1);
/*      */   } public static short n__pad3(long paramLong, int paramInt) {
/*  704 */     return UNSAFE.getShort(null, paramLong + __PAD3 + (Checks.check(paramInt, 1) << 1L));
/*      */   }
/*      */   
/*  707 */   public static long naddr3(long paramLong) { return UNSAFE.getLong(null, paramLong + ADDR3); } public static LongBuffer n__pad2(long paramLong) {
/*  708 */     return MemoryUtil.memLongBuffer(paramLong + __PAD2, 1);
/*      */   } public static long n__pad2(long paramLong, int paramInt) {
/*  710 */     return UNSAFE.getLong(null, paramLong + __PAD2 + (Checks.check(paramInt, 1) << 3L));
/*      */   }
/*      */   public static ByteBuffer ncmd(long paramLong) {
/*  713 */     return MemoryUtil.memByteBuffer(paramLong + CMD, 0);
/*      */   }
/*      */   public static byte ncmd(long paramLong, int paramInt) {
/*  716 */     return UNSAFE.getByte(null, paramLong + CMD + Checks.check(paramInt, 0));
/*      */   }
/*      */   
/*      */   public static void nopcode(long paramLong, byte paramByte) {
/*  720 */     UNSAFE.putByte(null, paramLong + OPCODE, paramByte);
/*      */   } public static void nflags(long paramLong, byte paramByte) {
/*  722 */     UNSAFE.putByte(null, paramLong + FLAGS, paramByte);
/*      */   } public static void nioprio(long paramLong, short paramShort) {
/*  724 */     UNSAFE.putShort(null, paramLong + IOPRIO, paramShort);
/*      */   } public static void nfd(long paramLong, int paramInt) {
/*  726 */     UNSAFE.putInt(null, paramLong + FD, paramInt);
/*      */   } public static void noff(long paramLong1, long paramLong2) {
/*  728 */     UNSAFE.putLong(null, paramLong1 + OFF, paramLong2);
/*      */   } public static void naddr2(long paramLong1, long paramLong2) {
/*  730 */     UNSAFE.putLong(null, paramLong1 + ADDR2, paramLong2);
/*      */   }
/*  732 */   public static void ncmd_op(long paramLong, int paramInt) { UNSAFE.putInt(null, paramLong + CMD_OP, paramInt); } public static void n__pad1(long paramLong, int paramInt) {
/*  733 */     UNSAFE.putInt(null, paramLong + __PAD1, paramInt);
/*      */   } public static void naddr(long paramLong1, long paramLong2) {
/*  735 */     UNSAFE.putLong(null, paramLong1 + ADDR, paramLong2);
/*      */   } public static void nsplice_off_in(long paramLong1, long paramLong2) {
/*  737 */     UNSAFE.putLong(null, paramLong1 + SPLICE_OFF_IN, paramLong2);
/*      */   } public static void nlen(long paramLong, int paramInt) {
/*  739 */     UNSAFE.putInt(null, paramLong + LEN, paramInt);
/*      */   } public static void nrw_flags(long paramLong, int paramInt) {
/*  741 */     UNSAFE.putInt(null, paramLong + RW_FLAGS, paramInt);
/*      */   } public static void nfsync_flags(long paramLong, int paramInt) {
/*  743 */     UNSAFE.putInt(null, paramLong + FSYNC_FLAGS, paramInt);
/*      */   } public static void npoll_events(long paramLong, short paramShort) {
/*  745 */     UNSAFE.putShort(null, paramLong + POLL_EVENTS, paramShort);
/*      */   } public static void npoll32_events(long paramLong, int paramInt) {
/*  747 */     UNSAFE.putInt(null, paramLong + POLL32_EVENTS, paramInt);
/*      */   } public static void nsync_range_flags(long paramLong, int paramInt) {
/*  749 */     UNSAFE.putInt(null, paramLong + SYNC_RANGE_FLAGS, paramInt);
/*      */   } public static void nmsg_flags(long paramLong, int paramInt) {
/*  751 */     UNSAFE.putInt(null, paramLong + MSG_FLAGS, paramInt);
/*      */   } public static void ntimeout_flags(long paramLong, int paramInt) {
/*  753 */     UNSAFE.putInt(null, paramLong + TIMEOUT_FLAGS, paramInt);
/*      */   } public static void naccept_flags(long paramLong, int paramInt) {
/*  755 */     UNSAFE.putInt(null, paramLong + ACCEPT_FLAGS, paramInt);
/*      */   } public static void ncancel_flags(long paramLong, int paramInt) {
/*  757 */     UNSAFE.putInt(null, paramLong + CANCEL_FLAGS, paramInt);
/*      */   } public static void nopen_flags(long paramLong, int paramInt) {
/*  759 */     UNSAFE.putInt(null, paramLong + OPEN_FLAGS, paramInt);
/*      */   } public static void nstatx_flags(long paramLong, int paramInt) {
/*  761 */     UNSAFE.putInt(null, paramLong + STATX_FLAGS, paramInt);
/*      */   } public static void nfadvise_advice(long paramLong, int paramInt) {
/*  763 */     UNSAFE.putInt(null, paramLong + FADVISE_ADVICE, paramInt);
/*      */   } public static void nsplice_flags(long paramLong, int paramInt) {
/*  765 */     UNSAFE.putInt(null, paramLong + SPLICE_FLAGS, paramInt);
/*      */   } public static void nrename_flags(long paramLong, int paramInt) {
/*  767 */     UNSAFE.putInt(null, paramLong + RENAME_FLAGS, paramInt);
/*      */   } public static void nunlink_flags(long paramLong, int paramInt) {
/*  769 */     UNSAFE.putInt(null, paramLong + UNLINK_FLAGS, paramInt);
/*      */   } public static void nhardlink_flags(long paramLong, int paramInt) {
/*  771 */     UNSAFE.putInt(null, paramLong + HARDLINK_FLAGS, paramInt);
/*      */   } public static void nxattr_flags(long paramLong, int paramInt) {
/*  773 */     UNSAFE.putInt(null, paramLong + XATTR_FLAGS, paramInt);
/*      */   } public static void nmsg_ring_flags(long paramLong, int paramInt) {
/*  775 */     UNSAFE.putInt(null, paramLong + MSG_RING_FLAGS, paramInt);
/*      */   } public static void nuring_cmd_flags(long paramLong, int paramInt) {
/*  777 */     UNSAFE.putInt(null, paramLong + URING_CMD_FLAGS, paramInt);
/*      */   } public static void nuser_data(long paramLong1, long paramLong2) {
/*  779 */     UNSAFE.putLong(null, paramLong1 + USER_DATA, paramLong2);
/*      */   } public static void nbuf_index(long paramLong, short paramShort) {
/*  781 */     UNSAFE.putShort(null, paramLong + BUF_INDEX, paramShort);
/*      */   } public static void nbuf_group(long paramLong, short paramShort) {
/*  783 */     UNSAFE.putShort(null, paramLong + BUF_GROUP, paramShort);
/*      */   } public static void npersonality(long paramLong, short paramShort) {
/*  785 */     UNSAFE.putShort(null, paramLong + PERSONALITY, paramShort);
/*      */   } public static void nsplice_fd_in(long paramLong, int paramInt) {
/*  787 */     UNSAFE.putInt(null, paramLong + SPLICE_FD_IN, paramInt);
/*      */   } public static void nfile_index(long paramLong, int paramInt) {
/*  789 */     UNSAFE.putInt(null, paramLong + FILE_INDEX, paramInt);
/*      */   } public static void naddr_len(long paramLong, short paramShort) {
/*  791 */     UNSAFE.putShort(null, paramLong + ADDR_LEN, paramShort);
/*      */   } public static void n__pad3(long paramLong, ShortBuffer paramShortBuffer) {
/*  793 */     if (Checks.CHECKS) Checks.checkGT(paramShortBuffer, 1); 
/*  794 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramShortBuffer), paramLong + __PAD3, (paramShortBuffer.remaining() << 1));
/*      */   }
/*      */   public static void n__pad3(long paramLong, int paramInt, short paramShort) {
/*  797 */     UNSAFE.putShort(null, paramLong + __PAD3 + (Checks.check(paramInt, 1) << 1L), paramShort);
/*      */   }
/*      */   public static void naddr3(long paramLong1, long paramLong2) {
/*  800 */     UNSAFE.putLong(null, paramLong1 + ADDR3, paramLong2);
/*      */   } public static void n__pad2(long paramLong, LongBuffer paramLongBuffer) {
/*  802 */     if (Checks.CHECKS) Checks.checkGT(paramLongBuffer, 1); 
/*  803 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramLongBuffer), paramLong + __PAD2, (paramLongBuffer.remaining() << 3));
/*      */   }
/*      */   public static void n__pad2(long paramLong1, int paramInt, long paramLong2) {
/*  806 */     UNSAFE.putLong(null, paramLong1 + __PAD2 + (Checks.check(paramInt, 1) << 3L), paramLong2);
/*      */   }
/*      */   
/*      */   public static void ncmd(long paramLong, ByteBuffer paramByteBuffer) {
/*  810 */     if (Checks.CHECKS) Checks.checkGT(paramByteBuffer, 0); 
/*  811 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramByteBuffer), paramLong + CMD, paramByteBuffer.remaining());
/*      */   }
/*      */   
/*      */   public static void ncmd(long paramLong, int paramInt, byte paramByte) {
/*  815 */     UNSAFE.putByte(null, paramLong + CMD + Checks.check(paramInt, 0), paramByte);
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Buffer
/*      */     extends StructBuffer<IOURingSQE, Buffer>
/*      */     implements NativeResource
/*      */   {
/*  823 */     private static final IOURingSQE ELEMENT_FACTORY = IOURingSQE.create(-1L);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Buffer(ByteBuffer param1ByteBuffer) {
/*  835 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingSQE.SIZEOF);
/*      */     }
/*      */     
/*      */     public Buffer(long param1Long, int param1Int) {
/*  839 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*      */     }
/*      */     
/*      */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  843 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*      */     }
/*      */ 
/*      */     
/*      */     protected Buffer self() {
/*  848 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     protected IOURingSQE getElementFactory() {
/*  853 */       return ELEMENT_FACTORY;
/*      */     }
/*      */     
/*      */     @NativeType("__u8")
/*      */     public byte opcode() {
/*  858 */       return IOURingSQE.nopcode(address());
/*      */     } @NativeType("__u8")
/*      */     public byte flags() {
/*  861 */       return IOURingSQE.nflags(address());
/*      */     } @NativeType("__u16")
/*      */     public short ioprio() {
/*  864 */       return IOURingSQE.nioprio(address());
/*      */     } @NativeType("__s32")
/*      */     public int fd() {
/*  867 */       return IOURingSQE.nfd(address());
/*      */     } @NativeType("__u64")
/*      */     public long off() {
/*  870 */       return IOURingSQE.noff(address());
/*      */     } @NativeType("__u64")
/*      */     public long addr2() {
/*  873 */       return IOURingSQE.naddr2(address());
/*      */     } @NativeType("__u32")
/*      */     public int cmd_op() {
/*  876 */       return IOURingSQE.ncmd_op(address());
/*      */     } @NativeType("__u32")
/*      */     public int __pad1() {
/*  879 */       return IOURingSQE.n__pad1(address());
/*      */     } @NativeType("__u64")
/*      */     public long addr() {
/*  882 */       return IOURingSQE.naddr(address());
/*      */     } @NativeType("__u64")
/*      */     public long splice_off_in() {
/*  885 */       return IOURingSQE.nsplice_off_in(address());
/*      */     } @NativeType("__u32")
/*      */     public int len() {
/*  888 */       return IOURingSQE.nlen(address());
/*      */     } @NativeType("__kernel_rwf_t")
/*      */     public int rw_flags() {
/*  891 */       return IOURingSQE.nrw_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int fsync_flags() {
/*  894 */       return IOURingSQE.nfsync_flags(address());
/*      */     } @NativeType("__u16")
/*      */     public short poll_events() {
/*  897 */       return IOURingSQE.npoll_events(address());
/*      */     } @NativeType("__u32")
/*      */     public int poll32_events() {
/*  900 */       return IOURingSQE.npoll32_events(address());
/*      */     } @NativeType("__u32")
/*      */     public int sync_range_flags() {
/*  903 */       return IOURingSQE.nsync_range_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int msg_flags() {
/*  906 */       return IOURingSQE.nmsg_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int timeout_flags() {
/*  909 */       return IOURingSQE.ntimeout_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int accept_flags() {
/*  912 */       return IOURingSQE.naccept_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int cancel_flags() {
/*  915 */       return IOURingSQE.ncancel_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int open_flags() {
/*  918 */       return IOURingSQE.nopen_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int statx_flags() {
/*  921 */       return IOURingSQE.nstatx_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int fadvise_advice() {
/*  924 */       return IOURingSQE.nfadvise_advice(address());
/*      */     } @NativeType("__u32")
/*      */     public int splice_flags() {
/*  927 */       return IOURingSQE.nsplice_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int rename_flags() {
/*  930 */       return IOURingSQE.nrename_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int unlink_flags() {
/*  933 */       return IOURingSQE.nunlink_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int hardlink_flags() {
/*  936 */       return IOURingSQE.nhardlink_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int xattr_flags() {
/*  939 */       return IOURingSQE.nxattr_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int msg_ring_flags() {
/*  942 */       return IOURingSQE.nmsg_ring_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int uring_cmd_flags() {
/*  945 */       return IOURingSQE.nuring_cmd_flags(address());
/*      */     } @NativeType("__u64")
/*      */     public long user_data() {
/*  948 */       return IOURingSQE.nuser_data(address());
/*      */     } @NativeType("__u16")
/*      */     public short buf_index() {
/*  951 */       return IOURingSQE.nbuf_index(address());
/*      */     } @NativeType("__u16")
/*      */     public short buf_group() {
/*  954 */       return IOURingSQE.nbuf_group(address());
/*      */     } @NativeType("__u16")
/*      */     public short personality() {
/*  957 */       return IOURingSQE.npersonality(address());
/*      */     } @NativeType("__s32")
/*      */     public int splice_fd_in() {
/*  960 */       return IOURingSQE.nsplice_fd_in(address());
/*      */     } @NativeType("__u32")
/*      */     public int file_index() {
/*  963 */       return IOURingSQE.nfile_index(address());
/*      */     } @NativeType("__u16")
/*      */     public short addr_len() {
/*  966 */       return IOURingSQE.naddr_len(address());
/*      */     } @NativeType("__u16[1]")
/*      */     public ShortBuffer __pad3() {
/*  969 */       return IOURingSQE.n__pad3(address());
/*      */     } @NativeType("__u16")
/*      */     public short __pad3(int param1Int) {
/*  972 */       return IOURingSQE.n__pad3(address(), param1Int);
/*      */     } @NativeType("__u64")
/*      */     public long addr3() {
/*  975 */       return IOURingSQE.naddr3(address());
/*      */     } @NativeType("__u64[1]")
/*      */     public LongBuffer __pad2() {
/*  978 */       return IOURingSQE.n__pad2(address());
/*      */     } @NativeType("__u64")
/*      */     public long __pad2(int param1Int) {
/*  981 */       return IOURingSQE.n__pad2(address(), param1Int);
/*      */     } @NativeType("__u8[0]")
/*      */     public ByteBuffer cmd() {
/*  984 */       return IOURingSQE.ncmd(address());
/*      */     } @NativeType("__u8")
/*      */     public byte cmd(int param1Int) {
/*  987 */       return IOURingSQE.ncmd(address(), param1Int);
/*      */     }
/*      */     public Buffer opcode(@NativeType("__u8") byte param1Byte) {
/*  990 */       IOURingSQE.nopcode(address(), param1Byte); return this;
/*      */     } public Buffer flags(@NativeType("__u8") byte param1Byte) {
/*  992 */       IOURingSQE.nflags(address(), param1Byte); return this;
/*      */     } public Buffer ioprio(@NativeType("__u16") short param1Short) {
/*  994 */       IOURingSQE.nioprio(address(), param1Short); return this;
/*      */     } public Buffer fd(@NativeType("__s32") int param1Int) {
/*  996 */       IOURingSQE.nfd(address(), param1Int); return this;
/*      */     } public Buffer off(@NativeType("__u64") long param1Long) {
/*  998 */       IOURingSQE.noff(address(), param1Long); return this;
/*      */     } public Buffer addr2(@NativeType("__u64") long param1Long) {
/* 1000 */       IOURingSQE.naddr2(address(), param1Long); return this;
/*      */     } public Buffer cmd_op(@NativeType("__u32") int param1Int) {
/* 1002 */       IOURingSQE.ncmd_op(address(), param1Int); return this;
/*      */     } public Buffer __pad1(@NativeType("__u32") int param1Int) {
/* 1004 */       IOURingSQE.n__pad1(address(), param1Int); return this;
/*      */     } public Buffer addr(@NativeType("__u64") long param1Long) {
/* 1006 */       IOURingSQE.naddr(address(), param1Long); return this;
/*      */     } public Buffer splice_off_in(@NativeType("__u64") long param1Long) {
/* 1008 */       IOURingSQE.nsplice_off_in(address(), param1Long); return this;
/*      */     } public Buffer len(@NativeType("__u32") int param1Int) {
/* 1010 */       IOURingSQE.nlen(address(), param1Int); return this;
/*      */     } public Buffer rw_flags(@NativeType("__kernel_rwf_t") int param1Int) {
/* 1012 */       IOURingSQE.nrw_flags(address(), param1Int); return this;
/*      */     } public Buffer fsync_flags(@NativeType("__u32") int param1Int) {
/* 1014 */       IOURingSQE.nfsync_flags(address(), param1Int); return this;
/*      */     } public Buffer poll_events(@NativeType("__u16") short param1Short) {
/* 1016 */       IOURingSQE.npoll_events(address(), param1Short); return this;
/*      */     } public Buffer poll32_events(@NativeType("__u32") int param1Int) {
/* 1018 */       IOURingSQE.npoll32_events(address(), param1Int); return this;
/*      */     } public Buffer sync_range_flags(@NativeType("__u32") int param1Int) {
/* 1020 */       IOURingSQE.nsync_range_flags(address(), param1Int); return this;
/*      */     } public Buffer msg_flags(@NativeType("__u32") int param1Int) {
/* 1022 */       IOURingSQE.nmsg_flags(address(), param1Int); return this;
/*      */     } public Buffer timeout_flags(@NativeType("__u32") int param1Int) {
/* 1024 */       IOURingSQE.ntimeout_flags(address(), param1Int); return this;
/*      */     } public Buffer accept_flags(@NativeType("__u32") int param1Int) {
/* 1026 */       IOURingSQE.naccept_flags(address(), param1Int); return this;
/*      */     } public Buffer cancel_flags(@NativeType("__u32") int param1Int) {
/* 1028 */       IOURingSQE.ncancel_flags(address(), param1Int); return this;
/*      */     } public Buffer open_flags(@NativeType("__u32") int param1Int) {
/* 1030 */       IOURingSQE.nopen_flags(address(), param1Int); return this;
/*      */     } public Buffer statx_flags(@NativeType("__u32") int param1Int) {
/* 1032 */       IOURingSQE.nstatx_flags(address(), param1Int); return this;
/*      */     } public Buffer fadvise_advice(@NativeType("__u32") int param1Int) {
/* 1034 */       IOURingSQE.nfadvise_advice(address(), param1Int); return this;
/*      */     } public Buffer splice_flags(@NativeType("__u32") int param1Int) {
/* 1036 */       IOURingSQE.nsplice_flags(address(), param1Int); return this;
/*      */     } public Buffer rename_flags(@NativeType("__u32") int param1Int) {
/* 1038 */       IOURingSQE.nrename_flags(address(), param1Int); return this;
/*      */     } public Buffer unlink_flags(@NativeType("__u32") int param1Int) {
/* 1040 */       IOURingSQE.nunlink_flags(address(), param1Int); return this;
/*      */     } public Buffer hardlink_flags(@NativeType("__u32") int param1Int) {
/* 1042 */       IOURingSQE.nhardlink_flags(address(), param1Int); return this;
/*      */     } public Buffer xattr_flags(@NativeType("__u32") int param1Int) {
/* 1044 */       IOURingSQE.nxattr_flags(address(), param1Int); return this;
/*      */     } public Buffer msg_ring_flags(@NativeType("__u32") int param1Int) {
/* 1046 */       IOURingSQE.nmsg_ring_flags(address(), param1Int); return this;
/*      */     } public Buffer uring_cmd_flags(@NativeType("__u32") int param1Int) {
/* 1048 */       IOURingSQE.nuring_cmd_flags(address(), param1Int); return this;
/*      */     } public Buffer user_data(@NativeType("__u64") long param1Long) {
/* 1050 */       IOURingSQE.nuser_data(address(), param1Long); return this;
/*      */     } public Buffer buf_index(@NativeType("__u16") short param1Short) {
/* 1052 */       IOURingSQE.nbuf_index(address(), param1Short); return this;
/*      */     } public Buffer buf_group(@NativeType("__u16") short param1Short) {
/* 1054 */       IOURingSQE.nbuf_group(address(), param1Short); return this;
/*      */     } public Buffer personality(@NativeType("__u16") short param1Short) {
/* 1056 */       IOURingSQE.npersonality(address(), param1Short); return this;
/*      */     } public Buffer splice_fd_in(@NativeType("__s32") int param1Int) {
/* 1058 */       IOURingSQE.nsplice_fd_in(address(), param1Int); return this;
/*      */     } public Buffer file_index(@NativeType("__u32") int param1Int) {
/* 1060 */       IOURingSQE.nfile_index(address(), param1Int); return this;
/*      */     } public Buffer addr_len(@NativeType("__u16") short param1Short) {
/* 1062 */       IOURingSQE.naddr_len(address(), param1Short); return this;
/*      */     } public Buffer __pad3(@NativeType("__u16[1]") ShortBuffer param1ShortBuffer) {
/* 1064 */       IOURingSQE.n__pad3(address(), param1ShortBuffer); return this;
/*      */     } public Buffer __pad3(int param1Int, @NativeType("__u16") short param1Short) {
/* 1066 */       IOURingSQE.n__pad3(address(), param1Int, param1Short); return this;
/*      */     } public Buffer addr3(@NativeType("__u64") long param1Long) {
/* 1068 */       IOURingSQE.naddr3(address(), param1Long); return this;
/*      */     } public Buffer __pad2(@NativeType("__u64[1]") LongBuffer param1LongBuffer) {
/* 1070 */       IOURingSQE.n__pad2(address(), param1LongBuffer); return this;
/*      */     } public Buffer __pad2(int param1Int, @NativeType("__u64") long param1Long) {
/* 1072 */       IOURingSQE.n__pad2(address(), param1Int, param1Long); return this;
/*      */     } public Buffer cmd(@NativeType("__u8[0]") ByteBuffer param1ByteBuffer) {
/* 1074 */       IOURingSQE.ncmd(address(), param1ByteBuffer); return this;
/*      */     } public Buffer cmd(int param1Int, @NativeType("__u8") byte param1Byte) {
/* 1076 */       IOURingSQE.ncmd(address(), param1Int, param1Byte); return this;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingSQE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */