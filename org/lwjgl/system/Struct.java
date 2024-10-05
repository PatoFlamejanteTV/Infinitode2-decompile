/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Struct<SELF extends Struct<SELF>>
/*     */   extends Pointer.Default
/*     */ {
/*  19 */   protected static final int DEFAULT_PACK_ALIGNMENT = (Platform.get() == Platform.WINDOWS) ? 8 : 1073741824; protected static final int DEFAULT_ALIGN_AS = 0;
/*     */   protected ByteBuffer container;
/*     */   
/*     */   static {
/*  23 */     Library.initialize();
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
/*     */   protected Struct(long paramLong, ByteBuffer paramByteBuffer) {
/*  37 */     super(paramLong);
/*  38 */     this.container = paramByteBuffer;
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
/*     */   public void clear() {
/*  56 */     MemoryUtil.memSet(address(), 0, sizeof());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free() {
/*  65 */     MemoryUtil.nmemFree(address());
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
/*     */   public boolean isNull(int paramInt) {
/*  78 */     if (Checks.DEBUG) {
/*  79 */       checkMemberOffset(paramInt);
/*     */     }
/*  81 */     return (MemoryUtil.memGetAddress(address() + paramInt) == 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkMemberOffset(int paramInt) {
/*  87 */     if (paramInt < 0 || sizeof() - paramInt < POINTER_SIZE) {
/*  88 */       throw new IllegalArgumentException("Invalid member offset.");
/*     */     }
/*     */   }
/*     */   
/*     */   protected static ByteBuffer __checkContainer(ByteBuffer paramByteBuffer, int paramInt) {
/*  93 */     if (Checks.CHECKS) {
/*  94 */       Checks.check(paramByteBuffer, paramInt);
/*     */     }
/*  96 */     return paramByteBuffer;
/*     */   }
/*     */   
/*     */   private static long getBytes(int paramInt1, int paramInt2) {
/* 100 */     return (paramInt1 & 0xFFFFFFFFL) * paramInt2;
/*     */   }
/*     */   
/*     */   protected static long __checkMalloc(int paramInt1, int paramInt2) {
/* 104 */     long l = (paramInt1 & 0xFFFFFFFFL) * paramInt2;
/* 105 */     if (Checks.DEBUG) {
/* 106 */       if (paramInt1 < 0) {
/* 107 */         throw new IllegalArgumentException("Invalid number of elements");
/*     */       }
/* 109 */       if (BITS32 && 4294967295L < l) {
/* 110 */         throw new IllegalArgumentException("The request allocation is too large");
/*     */       }
/*     */     } 
/* 113 */     return l;
/*     */   }
/*     */   
/*     */   protected static ByteBuffer __create(int paramInt1, int paramInt2) {
/* 117 */     APIUtil.apiCheckAllocation(paramInt1, getBytes(paramInt1, paramInt2), 2147483647L);
/* 118 */     return ByteBuffer.allocateDirect(paramInt1 * paramInt2).order(ByteOrder.nativeOrder());
/*     */   }
/*     */ 
/*     */   
/*     */   protected static <T extends Struct<T>> ByteBuffer __getContainer(T paramT) {
/* 123 */     return ((Struct)paramT).container;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static ByteBuffer __getContainer(StructBuffer<?, ?> paramStructBuffer) {
/* 128 */     return paramStructBuffer.container;
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
/*     */   public static void validate(long paramLong, int paramInt1, int paramInt2, StructValidation paramStructValidation) {
/* 146 */     for (byte b = 0; b < paramInt1; b++)
/* 147 */       paramStructValidation.validate(paramLong + Integer.toUnsignedLong(b) * paramInt2); 
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface StructValidation {
/*     */     void validate(long param1Long); }
/*     */   
/*     */   protected static class Member {
/*     */     final int size;
/*     */     final int alignment;
/*     */     final boolean forcedAlignment;
/*     */     int offset;
/*     */     
/*     */     Member(int param1Int1, int param1Int2, boolean param1Boolean) {
/* 161 */       this.size = param1Int1;
/* 162 */       this.alignment = param1Int2;
/* 163 */       this.forcedAlignment = param1Boolean;
/*     */     }
/*     */     
/*     */     public int getSize() {
/* 167 */       return this.size;
/*     */     }
/*     */     
/*     */     public int getAlignment() {
/* 171 */       return this.alignment;
/*     */     }
/*     */     
/*     */     public int getAlignment(int param1Int) {
/* 175 */       return this.forcedAlignment ? this.alignment : Math.min(this.alignment, param1Int);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static class Layout extends Member {
/*     */     final Struct.Member[] members;
/*     */     
/*     */     Layout(int param1Int1, int param1Int2, boolean param1Boolean, Struct.Member[] param1ArrayOfMember) {
/* 183 */       super(param1Int1, param1Int2, param1Boolean);
/* 184 */       this.members = param1ArrayOfMember;
/*     */     }
/*     */     
/*     */     public int offsetof(int param1Int) {
/* 188 */       return (this.members[param1Int]).offset;
/*     */     }
/*     */   }
/*     */   
/*     */   protected static Member __padding(int paramInt, boolean paramBoolean) {
/* 193 */     return __padding(paramInt, 1, paramBoolean);
/*     */   }
/*     */   
/*     */   protected static Member __padding(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 197 */     return __member(paramBoolean ? (paramInt1 * paramInt2) : 0, paramInt2);
/*     */   }
/*     */   
/*     */   protected static Member __member(int paramInt) {
/* 201 */     return __member(paramInt, paramInt);
/*     */   }
/*     */   
/*     */   protected static Member __member(int paramInt1, int paramInt2) {
/* 205 */     return __member(paramInt1, paramInt2, false);
/*     */   }
/*     */   
/*     */   protected static Member __member(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 209 */     return new Member(paramInt1, paramInt2, paramBoolean);
/*     */   }
/*     */   
/*     */   protected static Member __array(int paramInt1, int paramInt2) {
/* 213 */     return __array(paramInt1, paramInt1, paramInt2);
/*     */   }
/*     */   protected static Member __array(int paramInt1, int paramInt2, int paramInt3) {
/* 216 */     return new Member(paramInt1 * paramInt3, paramInt2, false);
/*     */   }
/*     */   protected static Member __array(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
/* 219 */     return new Member(paramInt1 * paramInt3, paramInt2, paramBoolean);
/*     */   }
/*     */   protected static Layout __union(Member... paramVarArgs) {
/* 222 */     return __union(DEFAULT_PACK_ALIGNMENT, 0, paramVarArgs);
/*     */   } protected static Layout __union(int paramInt1, int paramInt2, Member... paramVarArgs) {
/* 224 */     ArrayList<Member> arrayList = new ArrayList(paramVarArgs.length);
/*     */     
/* 226 */     int i = 0;
/* 227 */     int j = paramInt2; int k; byte b;
/* 228 */     for (k = (paramVarArgs = paramVarArgs).length, b = 0; b < k; ) { Member member = paramVarArgs[b];
/* 229 */       i = Math.max(i, member.size);
/* 230 */       j = Math.max(j, member.getAlignment(paramInt1));
/*     */       
/* 232 */       member.offset = 0;
/* 233 */       arrayList.add(member);
/* 234 */       if (member instanceof Layout) {
/* 235 */         addNestedMembers(member, arrayList, 0);
/*     */       }
/*     */       b++; }
/*     */     
/* 239 */     return new Layout(i, j, (paramInt2 != 0), arrayList.<Member>toArray(new Member[0]));
/*     */   }
/*     */   protected static Layout __struct(Member... paramVarArgs) {
/* 242 */     return __struct(DEFAULT_PACK_ALIGNMENT, 0, paramVarArgs);
/*     */   } protected static Layout __struct(int paramInt1, int paramInt2, Member... paramVarArgs) {
/* 244 */     ArrayList<Member> arrayList = new ArrayList(paramVarArgs.length);
/*     */     
/* 246 */     int i = 0;
/* 247 */     int j = paramInt2; int k; byte b;
/* 248 */     for (k = (paramVarArgs = paramVarArgs).length, b = 0; b < k; b++) {
/* 249 */       Member member; int m = (member = paramVarArgs[b]).getAlignment(paramInt1);
/*     */       
/* 251 */       member.offset = align(i, m);
/*     */       
/* 253 */       i = member.offset + member.size;
/* 254 */       j = Math.max(j, m);
/*     */       
/* 256 */       arrayList.add(member);
/* 257 */       if (member instanceof Layout) {
/* 258 */         addNestedMembers(member, arrayList, member.offset);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 263 */     i = align(i, j);
/*     */     
/* 265 */     return new Layout(i, j, (paramInt2 != 0), arrayList.<Member>toArray(new Member[0]));
/*     */   }
/*     */   private static void addNestedMembers(Member paramMember, List<Member> paramList, int paramInt) {
/*     */     Member[] arrayOfMember;
/*     */     int i;
/*     */     byte b;
/* 271 */     for (i = (arrayOfMember = ((Layout)(paramMember = paramMember)).members).length, b = 0; b < i; b++) {
/* 272 */       Member member; (member = arrayOfMember[b]).offset += paramInt;
/* 273 */       paramList.add(member);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int align(int paramInt1, int paramInt2) {
/* 278 */     return (paramInt1 - 1 | paramInt2 - 1) + 1;
/*     */   }
/*     */   
/*     */   protected abstract SELF create(long paramLong, ByteBuffer paramByteBuffer);
/*     */   
/*     */   public abstract int sizeof();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\Struct.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */