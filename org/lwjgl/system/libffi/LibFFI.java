/*     */ package org.lwjgl.system.libffi;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LibFFI
/*     */ {
/*     */   public static final short FFI_TYPE_VOID = 0;
/*     */   public static final short FFI_TYPE_INT = 1;
/*     */   public static final short FFI_TYPE_FLOAT = 2;
/*     */   public static final short FFI_TYPE_DOUBLE = 3;
/*     */   
/*     */   static {
/*  34 */     Library.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   public static final short FFI_TYPE_LONGDOUBLE = FFI_TYPE_DOUBLE();
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short FFI_TYPE_UINT8 = 5;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short FFI_TYPE_SINT8 = 6;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short FFI_TYPE_UINT16 = 7;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short FFI_TYPE_SINT16 = 8;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short FFI_TYPE_UINT32 = 9;
/*     */ 
/*     */   
/*     */   public static final short FFI_TYPE_SINT32 = 10;
/*     */ 
/*     */   
/*     */   public static final short FFI_TYPE_UINT64 = 11;
/*     */ 
/*     */   
/*     */   public static final short FFI_TYPE_SINT64 = 12;
/*     */ 
/*     */   
/*     */   public static final short FFI_TYPE_STRUCT = 13;
/*     */ 
/*     */   
/*     */   public static final short FFI_TYPE_POINTER = 14;
/*     */ 
/*     */   
/*  80 */   public static final int FFI_FIRST_ABI = FFI_FIRST_ABI();
/*  81 */   public static final int FFI_WIN64 = FFI_WIN64();
/*  82 */   public static final int FFI_GNUW64 = FFI_GNUW64();
/*  83 */   public static final int FFI_UNIX64 = FFI_UNIX64();
/*  84 */   public static final int FFI_EFI64 = FFI_EFI64();
/*  85 */   public static final int FFI_SYSV = FFI_SYSV();
/*  86 */   public static final int FFI_STDCALL = FFI_STDCALL();
/*  87 */   public static final int FFI_THISCALL = FFI_THISCALL();
/*  88 */   public static final int FFI_FASTCALL = FFI_FASTCALL();
/*  89 */   public static final int FFI_MS_CDECL = FFI_MS_CDECL();
/*  90 */   public static final int FFI_PASCAL = FFI_PASCAL();
/*  91 */   public static final int FFI_REGISTER = FFI_REGISTER();
/*  92 */   public static final int FFI_VFP = FFI_VFP();
/*  93 */   public static final int FFI_LAST_ABI = FFI_LAST_ABI();
/*  94 */   public static final int FFI_DEFAULT_ABI = FFI_DEFAULT_ABI();
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FFI_OK = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FFI_BAD_TYPEDEF = 1;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FFI_BAD_ABI = 2;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FFI_BAD_ARGTYPE = 3;
/*     */ 
/*     */ 
/*     */   
/*     */   protected LibFFI() {
/* 115 */     throw new UnsupportedOperationException();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_void() {
/*     */     long l;
/* 190 */     return FFIType.create(l = nffi_type_void());
/*     */   }
/*     */ 
/*     */   
/* 194 */   public static final FFIType ffi_type_void = ffi_type_void();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uint8() {
/*     */     long l;
/* 203 */     return FFIType.create(l = nffi_type_uint8());
/*     */   }
/*     */ 
/*     */   
/* 207 */   public static final FFIType ffi_type_uint8 = ffi_type_uint8();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sint8() {
/*     */     long l;
/* 216 */     return FFIType.create(l = nffi_type_sint8());
/*     */   }
/*     */ 
/*     */   
/* 220 */   public static final FFIType ffi_type_sint8 = ffi_type_sint8();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uint16() {
/*     */     long l;
/* 229 */     return FFIType.create(l = nffi_type_uint16());
/*     */   }
/*     */ 
/*     */   
/* 233 */   public static final FFIType ffi_type_uint16 = ffi_type_uint16();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sint16() {
/*     */     long l;
/* 242 */     return FFIType.create(l = nffi_type_sint16());
/*     */   }
/*     */ 
/*     */   
/* 246 */   public static final FFIType ffi_type_sint16 = ffi_type_sint16();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uint32() {
/*     */     long l;
/* 255 */     return FFIType.create(l = nffi_type_uint32());
/*     */   }
/*     */ 
/*     */   
/* 259 */   public static final FFIType ffi_type_uint32 = ffi_type_uint32();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sint32() {
/*     */     long l;
/* 268 */     return FFIType.create(l = nffi_type_sint32());
/*     */   }
/*     */ 
/*     */   
/* 272 */   public static final FFIType ffi_type_sint32 = ffi_type_sint32();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uint64() {
/*     */     long l;
/* 281 */     return FFIType.create(l = nffi_type_uint64());
/*     */   }
/*     */ 
/*     */   
/* 285 */   public static final FFIType ffi_type_uint64 = ffi_type_uint64();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sint64() {
/*     */     long l;
/* 294 */     return FFIType.create(l = nffi_type_sint64());
/*     */   }
/*     */ 
/*     */   
/* 298 */   public static final FFIType ffi_type_sint64 = ffi_type_sint64();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uchar() {
/*     */     long l;
/* 307 */     return FFIType.create(l = nffi_type_uchar());
/*     */   }
/*     */ 
/*     */   
/* 311 */   public static final FFIType ffi_type_uchar = ffi_type_uchar();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_schar() {
/*     */     long l;
/* 320 */     return FFIType.create(l = nffi_type_schar());
/*     */   }
/*     */ 
/*     */   
/* 324 */   public static final FFIType ffi_type_schar = ffi_type_schar();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_ushort() {
/*     */     long l;
/* 333 */     return FFIType.create(l = nffi_type_ushort());
/*     */   }
/*     */ 
/*     */   
/* 337 */   public static final FFIType ffi_type_ushort = ffi_type_ushort();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sshort() {
/*     */     long l;
/* 346 */     return FFIType.create(l = nffi_type_sshort());
/*     */   }
/*     */ 
/*     */   
/* 350 */   public static final FFIType ffi_type_sshort = ffi_type_sshort();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uint() {
/*     */     long l;
/* 359 */     return FFIType.create(l = nffi_type_uint());
/*     */   }
/*     */ 
/*     */   
/* 363 */   public static final FFIType ffi_type_uint = ffi_type_uint();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sint() {
/*     */     long l;
/* 372 */     return FFIType.create(l = nffi_type_sint());
/*     */   }
/*     */ 
/*     */   
/* 376 */   public static final FFIType ffi_type_sint = ffi_type_sint();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_ulong() {
/*     */     long l;
/* 385 */     return FFIType.create(l = nffi_type_ulong());
/*     */   }
/*     */ 
/*     */   
/* 389 */   public static final FFIType ffi_type_ulong = ffi_type_ulong();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_slong() {
/*     */     long l;
/* 398 */     return FFIType.create(l = nffi_type_slong());
/*     */   }
/*     */ 
/*     */   
/* 402 */   public static final FFIType ffi_type_slong = ffi_type_slong();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_float() {
/*     */     long l;
/* 411 */     return FFIType.create(l = nffi_type_float());
/*     */   }
/*     */ 
/*     */   
/* 415 */   public static final FFIType ffi_type_float = ffi_type_float();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_double() {
/*     */     long l;
/* 424 */     return FFIType.create(l = nffi_type_double());
/*     */   }
/*     */ 
/*     */   
/* 428 */   public static final FFIType ffi_type_double = ffi_type_double();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_longdouble() {
/*     */     long l;
/* 437 */     return FFIType.create(l = nffi_type_longdouble());
/*     */   }
/*     */ 
/*     */   
/* 441 */   public static final FFIType ffi_type_longdouble = ffi_type_longdouble();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_pointer() {
/*     */     long l;
/* 450 */     return FFIType.create(l = nffi_type_pointer());
/*     */   }
/*     */ 
/*     */   
/* 454 */   public static final FFIType ffi_type_pointer = ffi_type_pointer();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_status")
/*     */   public static int ffi_prep_cif(@NativeType("ffi_cif *") FFICIF paramFFICIF, @NativeType("ffi_abi") int paramInt, @NativeType("ffi_type *") FFIType paramFFIType, @NativeType("ffi_type **") PointerBuffer paramPointerBuffer) {
/* 483 */     return nffi_prep_cif(paramFFICIF.address(), paramInt, Checks.remainingSafe((CustomBuffer)paramPointerBuffer), paramFFIType.address(), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer));
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
/*     */   @NativeType("ffi_status")
/*     */   public static int ffi_prep_cif_var(@NativeType("ffi_cif *") FFICIF paramFFICIF, @NativeType("ffi_abi") int paramInt1, @NativeType("unsigned int") int paramInt2, @NativeType("ffi_type *") FFIType paramFFIType, @NativeType("ffi_type **") PointerBuffer paramPointerBuffer) {
/* 517 */     return nffi_prep_cif_var(paramFFICIF.address(), paramInt1, paramInt2, paramPointerBuffer.remaining(), paramFFIType.address(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
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
/*     */   public static void ffi_call(@NativeType("ffi_cif *") FFICIF paramFFICIF, @NativeType("FFI_FN_TYPE") long paramLong, @NativeType("void *") ByteBuffer paramByteBuffer, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 552 */     if (Checks.CHECKS) {
/* 553 */       Checks.check(paramLong);
/*     */     }
/* 555 */     nffi_call(paramFFICIF.address(), paramLong, MemoryUtil.memAddressSafe(paramByteBuffer), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer));
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
/*     */   @NativeType("ffi_status")
/*     */   public static int ffi_get_struct_offsets(@NativeType("ffi_abi") int paramInt, @NativeType("ffi_type *") FFIType paramFFIType, @NativeType("size_t *") PointerBuffer paramPointerBuffer) {
/* 576 */     return nffi_get_struct_offsets(paramInt, paramFFIType.address(), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer));
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
/*     */   @NativeType("ffi_closure *")
/*     */   public static FFIClosure ffi_closure_alloc(@NativeType("size_t") long paramLong, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 597 */     if (Checks.CHECKS) {
/* 598 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     }
/*     */     long l;
/* 601 */     return FFIClosure.createSafe(l = nffi_closure_alloc(paramLong, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer)));
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
/*     */   public static void ffi_closure_free(@NativeType("ffi_closure *") FFIClosure paramFFIClosure) {
/* 615 */     nffi_closure_free(paramFFIClosure.address());
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
/*     */   @NativeType("ffi_status")
/*     */   public static int ffi_prep_closure_loc(@NativeType("ffi_closure *") FFIClosure paramFFIClosure, @NativeType("ffi_cif *") FFICIF paramFFICIF, @NativeType("FFI_CLOSURE_FUN") long paramLong1, @NativeType("void *") long paramLong2, @NativeType("void *") long paramLong3) {
/* 652 */     if (Checks.CHECKS) {
/* 653 */       Checks.check(paramLong1);
/* 654 */       Checks.check(paramLong3);
/*     */     } 
/* 656 */     return nffi_prep_closure_loc(paramFFIClosure.address(), paramFFICIF.address(), paramLong1, paramLong2, paramLong3);
/*     */   }
/*     */   
/*     */   private static native short FFI_TYPE_DOUBLE();
/*     */   
/*     */   private static native int FFI_WIN64();
/*     */   
/*     */   private static native int FFI_GNUW64();
/*     */   
/*     */   private static native int FFI_UNIX64();
/*     */   
/*     */   private static native int FFI_EFI64();
/*     */   
/*     */   private static native int FFI_SYSV();
/*     */   
/*     */   private static native int FFI_STDCALL();
/*     */   
/*     */   private static native int FFI_THISCALL();
/*     */   
/*     */   private static native int FFI_FASTCALL();
/*     */   
/*     */   private static native int FFI_MS_CDECL();
/*     */   
/*     */   private static native int FFI_PASCAL();
/*     */   
/*     */   private static native int FFI_REGISTER();
/*     */   
/*     */   private static native int FFI_VFP();
/*     */   
/*     */   private static native int FFI_FIRST_ABI();
/*     */   
/*     */   private static native int FFI_LAST_ABI();
/*     */   
/*     */   private static native int FFI_DEFAULT_ABI();
/*     */   
/*     */   private static native long nffi_type_void();
/*     */   
/*     */   private static native long nffi_type_uint8();
/*     */   
/*     */   private static native long nffi_type_sint8();
/*     */   
/*     */   private static native long nffi_type_uint16();
/*     */   
/*     */   private static native long nffi_type_sint16();
/*     */   
/*     */   private static native long nffi_type_uint32();
/*     */   
/*     */   private static native long nffi_type_sint32();
/*     */   
/*     */   private static native long nffi_type_uint64();
/*     */   
/*     */   private static native long nffi_type_sint64();
/*     */   
/*     */   private static native long nffi_type_uchar();
/*     */   
/*     */   private static native long nffi_type_schar();
/*     */   
/*     */   private static native long nffi_type_ushort();
/*     */   
/*     */   private static native long nffi_type_sshort();
/*     */   
/*     */   private static native long nffi_type_uint();
/*     */   
/*     */   private static native long nffi_type_sint();
/*     */   
/*     */   private static native long nffi_type_ulong();
/*     */   
/*     */   private static native long nffi_type_slong();
/*     */   
/*     */   private static native long nffi_type_float();
/*     */   
/*     */   private static native long nffi_type_double();
/*     */   
/*     */   private static native long nffi_type_longdouble();
/*     */   
/*     */   private static native long nffi_type_pointer();
/*     */   
/*     */   public static native int nffi_prep_cif(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nffi_prep_cif_var(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nffi_call(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nffi_get_struct_offsets(int paramInt, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nffi_closure_alloc(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nffi_closure_free(long paramLong);
/*     */   
/*     */   public static native int nffi_prep_closure_loc(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\libffi\LibFFI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */