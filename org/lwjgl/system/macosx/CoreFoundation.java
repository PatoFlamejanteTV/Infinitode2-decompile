/*     */ package org.lwjgl.system.macosx;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class CoreFoundation
/*     */ {
/*     */   public static final byte TRUE = 1;
/*     */   public static final byte FALSE = 0;
/*     */   public static final int kCFStringEncodingMacRoman = 0;
/*     */   public static final int kCFStringEncodingWindowsLatin1 = 1280;
/*     */   
/*     */   static {
/*  18 */     Library.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int kCFStringEncodingISOLatin1 = 513;
/*     */   
/*     */   public static final int kCFStringEncodingNextStepLatin = 2817;
/*     */   
/*     */   public static final int kCFStringEncodingASCII = 1536;
/*     */   
/*     */   public static final int kCFStringEncodingUnicode = 256;
/*     */   
/*     */   public static final int kCFStringEncodingUTF8 = 134217984;
/*     */   
/*     */   public static final int kCFStringEncodingNonLossyASCII = 3071;
/*     */   
/*     */   public static final int kCFStringEncodingUTF16 = 256;
/*     */   
/*     */   public static final int kCFStringEncodingUTF16BE = 268435712;
/*     */   
/*     */   public static final int kCFStringEncodingUTF16LE = 335544576;
/*     */   
/*     */   public static final int kCFStringEncodingUTF32 = 201326848;
/*     */   
/*     */   public static final int kCFStringEncodingUTF32BE = 402653440;
/*     */   public static final int kCFStringEncodingUTF32LE = 469762304;
/*     */   public static final int kCFURLPOSIXPathStyle = 0;
/*     */   public static final int kCFURLHFSPathStyle = 1;
/*     */   public static final int kCFURLWindowsPathStyle = 2;
/*     */   
/*     */   protected CoreFoundation() {
/*  49 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   public static final long kCFAllocatorDefault = kCFAllocatorDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   public static final long kCFAllocatorSystemDefault = kCFAllocatorSystemDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   public static final long kCFAllocatorMalloc = kCFAllocatorMalloc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   public static final long kCFAllocatorMallocZone = kCFAllocatorMallocZone();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 100 */   public static final long kCFAllocatorNull = kCFAllocatorNull();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   public static final long kCFAllocatorUseContext = kCFAllocatorUseContext();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFTypeRef")
/*     */   public static long CFRetain(@NativeType("CFTypeRef") long paramLong) {
/* 125 */     if (Checks.CHECKS) {
/* 126 */       Checks.check(paramLong);
/*     */     }
/* 128 */     return nCFRetain(paramLong);
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
/*     */   public static void CFRelease(@NativeType("CFTypeRef") long paramLong) {
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.check(paramLong);
/*     */     }
/* 148 */     nCFRelease(paramLong);
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
/*     */   @NativeType("CFBundleRef")
/*     */   public static long CFBundleCreate(@NativeType("CFAllocatorRef") long paramLong1, @NativeType("CFURLRef") long paramLong2) {
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(paramLong2);
/*     */     }
/* 167 */     return nCFBundleCreate(paramLong1, paramLong2);
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
/*     */   @NativeType("CFBundleRef")
/*     */   public static long CFBundleGetBundleWithIdentifier(@NativeType("CFStringRef") long paramLong) {
/* 182 */     if (Checks.CHECKS) {
/* 183 */       Checks.check(paramLong);
/*     */     }
/* 185 */     return nCFBundleGetBundleWithIdentifier(paramLong);
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
/*     */   @NativeType("void *")
/*     */   public static long CFBundleGetFunctionPointerForName(@NativeType("CFBundleRef") long paramLong1, @NativeType("CFStringRef") long paramLong2) {
/* 201 */     if (Checks.CHECKS) {
/* 202 */       Checks.check(paramLong1);
/* 203 */       Checks.check(paramLong2);
/*     */     } 
/* 205 */     return nCFBundleGetFunctionPointerForName(paramLong1, paramLong2);
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
/*     */   @NativeType("CFStringRef")
/*     */   public static long CFStringCreateWithCString(@NativeType("CFAllocatorRef") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("CFStringEncoding") int paramInt) {
/* 222 */     return nCFStringCreateWithCString(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramInt);
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
/*     */   @NativeType("CFStringRef")
/*     */   public static long CFStringCreateWithCStringNoCopy(@NativeType("CFAllocatorRef") long paramLong1, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("CFStringEncoding") int paramInt, @NativeType("CFAllocatorRef") long paramLong2) {
/* 242 */     return nCFStringCreateWithCStringNoCopy(paramLong1, MemoryUtil.memAddress(paramByteBuffer), paramInt, paramLong2);
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
/*     */   @NativeType("CFURLRef")
/*     */   public static long CFURLCreateWithFileSystemPath(@NativeType("CFAllocatorRef") long paramLong1, @NativeType("CFStringRef") long paramLong2, @NativeType("CFURLPathStyle") long paramLong3, @NativeType("Boolean") boolean paramBoolean) {
/* 262 */     if (Checks.CHECKS) {
/* 263 */       Checks.check(paramLong2);
/*     */     }
/* 265 */     return nCFURLCreateWithFileSystemPath(paramLong1, paramLong2, paramLong3, paramBoolean);
/*     */   }
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorDefault();
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorSystemDefault();
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorMalloc();
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorMallocZone();
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorNull();
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorUseContext();
/*     */   
/*     */   public static native long nCFRetain(long paramLong);
/*     */   
/*     */   public static native void nCFRelease(long paramLong);
/*     */   
/*     */   public static native long nCFBundleCreate(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nCFBundleGetBundleWithIdentifier(long paramLong);
/*     */   
/*     */   public static native long nCFBundleGetFunctionPointerForName(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nCFStringCreateWithCString(long paramLong1, long paramLong2, int paramInt);
/*     */   
/*     */   public static native long nCFStringCreateWithCStringNoCopy(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*     */   
/*     */   public static native long nCFURLCreateWithFileSystemPath(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\CoreFoundation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */