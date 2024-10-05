/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class FCNTL {
/*     */   public static final int O_ACCMODE = 3;
/*     */   public static final int O_RDONLY = 0;
/*     */   public static final int O_WRONLY = 1;
/*     */   public static final int O_RDWR = 2;
/*     */   public static final int O_APPEND = 1024;
/*     */   public static final int O_ASYNC = 8192;
/*     */   
/*     */   static {
/*  19 */     Library.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_CLOEXEC = 524288;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_CREAT = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_DIRECT = 16384;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_DIRECTORY = 65536;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_DSYNC = 4096;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_EXCL = 128;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_LARGEFILE = 32768;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_NOATIME = 262144;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_NOCTTY = 256;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_NOFOLLOW = 131072;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_NONBLOCK = 2048;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_NDELAY = 2048;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_PATH = 2097152;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_SYNC = 1052672;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_TMPFILE = 4259840;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int O_TRUNC = 512;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IFMT = 61440;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IFBLK = 24576;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IFCHR = 8192;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IFIFO = 4096;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IFREG = 32768;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IFDIR = 16384;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IFLNK = 40960;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IFSOCK = 49152;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IRWXU = 448;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IRUSR = 256;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IWUSR = 128;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IXUSR = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IRWXG = 56;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IRGRP = 32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IWGRP = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IXGRP = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IRWXO = 7;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IROTH = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IWOTH = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_IXOTH = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_ISUID = 2048;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_ISGID = 1024;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int S_ISVTX = 512;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_DUPFD = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GETFD = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SETFD = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GETFL = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SETFL = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GETLK = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SETLK = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SETLKW = 7;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SETOWN = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GETOWN = 9;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SETSIG = 10;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GETSIG = 11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SETOWN_EX = 15;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GETOWN_EX = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_OFD_GETLK = 36;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_OFD_SETLK = 37;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_OFD_SETLKW = 38;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SETLEASE = 1024;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GETLEASE = 1025;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_NOTIFY = 1026;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SETPIPE_SZ = 1031;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GETPIPE_SZ = 1032;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_ADD_SEALS = 1033;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GET_SEALS = 1034;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GET_RW_HINT = 1035;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SET_RW_HINT = 1036;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_GET_FILE_RW_HINT = 1037;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SET_FILE_RW_HINT = 1038;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_DUPFD_CLOEXEC = 1030;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FD_CLOEXEC = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_RDLCK = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_WRLCK = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_UNLCK = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_EXLCK = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SHLCK = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_OWNER_TID = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_OWNER_PID = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_OWNER_PGRP = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_SH = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_EX = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_NB = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_UN = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_MAND = 32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_READ = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_WRITE = 128;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_RW = 192;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DN_ACCESS = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DN_MODIFY = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DN_CREATE = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DN_DELETE = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DN_RENAME = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DN_ATTRIB = 32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DN_MULTISHOT = -2147483648;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SEAL_SEAL = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SEAL_SHRINK = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SEAL_GROW = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SEAL_WRITE = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int F_SEAL_FUTURE_WRITE = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RWH_WRITE_LIFE_NOT_SET = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RWH_WRITE_LIFE_NONE = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RWH_WRITE_LIFE_SHORT = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RWH_WRITE_LIFE_MEDIUM = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RWH_WRITE_LIFE_LONG = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RWH_WRITE_LIFE_EXTREME = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FCNTL() {
/* 676 */     throw new UnsupportedOperationException();
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
/*     */   public static int open(@NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt1, @NativeType("mode_t") int paramInt2) {
/* 695 */     if (Checks.CHECKS) {
/* 696 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 698 */     return nopen(MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2);
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
/*     */   public static int open(@NativeType("char const *") CharSequence paramCharSequence, int paramInt1, @NativeType("mode_t") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 712 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 714 */       memoryStack.nUTF8(paramCharSequence, true);
/*     */       long l;
/* 716 */       return nopen(l = memoryStack.getPointerAddress(), paramInt1, paramInt2);
/*     */     } finally {
/* 718 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static int openat(int paramInt1, @NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt2, @NativeType("mode_t") int paramInt3) {
/* 743 */     if (Checks.CHECKS) {
/* 744 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 746 */     return nopenat(paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3);
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
/*     */   public static int openat(int paramInt1, @NativeType("char const *") CharSequence paramCharSequence, int paramInt2, @NativeType("mode_t") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 765 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 767 */       memoryStack.nUTF8(paramCharSequence, true);
/* 768 */       long l = memoryStack.getPointerAddress();
/* 769 */       paramInt1 = nopenat(paramInt1, l, paramInt2, paramInt3); return paramInt1;
/*     */     } finally {
/* 771 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static int creat(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("mode_t") int paramInt) {
/* 786 */     if (Checks.CHECKS) {
/* 787 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 789 */     return ncreat(MemoryUtil.memAddress(paramByteBuffer), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int creat(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("mode_t") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 798 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 800 */       memoryStack.nUTF8(paramCharSequence, true);
/*     */       long l;
/* 802 */       return ncreat(l = memoryStack.getPointerAddress(), paramInt);
/*     */     } finally {
/* 804 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static int fcntli(int paramInt1, int paramInt2, int paramInt3) {
/* 838 */     return nfcntli(paramInt1, paramInt2, paramInt3);
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
/*     */   public static int fcntlp(int paramInt1, int paramInt2, @NativeType("void *") long paramLong) {
/* 852 */     if (Checks.CHECKS) {
/* 853 */       Checks.check(paramLong);
/*     */     }
/* 855 */     return nfcntlp(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static native int nopen(long paramLong, int paramInt1, int paramInt2);
/*     */   
/*     */   public static native int nopenat(int paramInt1, long paramLong, int paramInt2, int paramInt3);
/*     */   
/*     */   public static native int ncreat(long paramLong, int paramInt);
/*     */   
/*     */   public static native int fcntl(int paramInt1, int paramInt2);
/*     */   
/*     */   public static native int nfcntli(int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   public static native int nfcntlp(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\FCNTL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */