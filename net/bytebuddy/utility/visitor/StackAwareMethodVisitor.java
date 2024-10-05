/*     */ package net.bytebuddy.utility.visitor;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.jar.asm.Handle;
/*     */ import net.bytebuddy.jar.asm.Label;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.Opcodes;
/*     */ import net.bytebuddy.jar.asm.Type;
/*     */ import net.bytebuddy.utility.CompoundList;
/*     */ import net.bytebuddy.utility.OpenedClassReader;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StackAwareMethodVisitor
/*     */   extends MethodVisitor
/*     */ {
/*     */   public static final String UNADJUSTED_PROPERTY = "net.bytebuddy.unadjusted";
/*     */   public static final boolean UNADJUSTED;
/*     */   private List<StackSize> current;
/*     */   private final Map<Label, List<StackSize>> sizes;
/*     */   private int freeIndex;
/*  84 */   private static final int[] SIZE_CHANGE = new int[202]; private static final boolean ACCESS_CONTROLLER; static {
/*  85 */     String str = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEEEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE";
/*     */ 
/*     */ 
/*     */     
/*  89 */     for (byte b = 0; b < SIZE_CHANGE.length; b++)
/*  90 */       SIZE_CHANGE[b] = str.charAt(b) - 69;  } static { boolean bool;
/*     */     
/*  92 */     try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*     */     
/*     */     try {
/*     */       bool = Boolean.parseBoolean(doPrivileged((PrivilegedAction<String>)new GetSystemPropertyAction("net.bytebuddy.unadjusted")));
/*     */     } catch (Exception exception) {
/*     */       bool = false;
/*     */     } 
/*     */     UNADJUSTED = bool; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected StackAwareMethodVisitor(MethodVisitor paramMethodVisitor, MethodDescription paramMethodDescription) {
/* 117 */     super(OpenedClassReader.ASM_API, paramMethodVisitor);
/* 118 */     this.current = new ArrayList<StackSize>();
/* 119 */     this.sizes = new HashMap<Label, List<StackSize>>();
/* 120 */     this.freeIndex = paramMethodDescription.getStackSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MethodVisitor of(MethodVisitor paramMethodVisitor, MethodDescription paramMethodDescription) {
/* 131 */     return UNADJUSTED ? paramMethodVisitor : new StackAwareMethodVisitor(paramMethodVisitor, paramMethodDescription);
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
/*     */   @Enhance
/*     */   private static <T> T doPrivileged(PrivilegedAction<T> paramPrivilegedAction) {
/* 145 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void adjustStack(int paramInt) {
/* 154 */     adjustStack(paramInt, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void adjustStack(int paramInt1, int paramInt2) {
/* 165 */     if (paramInt1 > 2)
/* 166 */       throw new IllegalStateException("Cannot push multiple values onto the operand stack: " + paramInt1); 
/* 167 */     if (paramInt1 > 0) {
/* 168 */       int i = this.current.size();
/*     */       
/* 170 */       while (paramInt2 > 0 && i > 0) {
/* 171 */         paramInt2 -= ((StackSize)this.current.get(--i)).getSize();
/*     */       }
/* 173 */       if (paramInt2 < 0) {
/* 174 */         throw new IllegalStateException("Unexpected offset underflow: " + paramInt2);
/*     */       }
/* 176 */       this.current.add(i, StackSize.of(paramInt1)); return;
/* 177 */     }  if (paramInt2 != 0) {
/* 178 */       throw new IllegalStateException("Cannot specify non-zero offset " + paramInt2 + " for non-incrementing value: " + paramInt1);
/*     */     }
/* 180 */     while (paramInt1 < 0) {
/*     */       
/* 182 */       if (this.current.isEmpty()) {
/*     */         return;
/*     */       }
/* 185 */       paramInt1 += ((StackSize)this.current.remove(this.current.size() - 1)).getSize();
/*     */     } 
/* 187 */     if (paramInt1 == 1) {
/* 188 */       this.current.add(StackSize.SINGLE); return;
/* 189 */     }  if (paramInt1 != 0) {
/* 190 */       throw new IllegalStateException("Unexpected remainder on the operand stack: " + paramInt1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drainStack() {
/* 199 */     doDrain(this.current);
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
/*     */   public int drainStack(int paramInt1, int paramInt2, StackSize paramStackSize) {
/* 213 */     if (this.current.isEmpty()) {
/* 214 */       return 0;
/*     */     }
/* 216 */     int i = ((StackSize)this.current.get(this.current.size() - 1)).getSize() - paramStackSize.getSize();
/* 217 */     if (this.current.size() == 1 && i == 0) {
/* 218 */       return 0;
/*     */     }
/* 220 */     super.visitVarInsn(paramInt1, this.freeIndex);
/* 221 */     if (i == 1) {
/* 222 */       super.visitInsn(87);
/* 223 */     } else if (i != 0) {
/* 224 */       throw new IllegalStateException("Unexpected remainder on the operand stack: " + i);
/*     */     } 
/* 226 */     doDrain(this.current.subList(0, this.current.size() - 1));
/* 227 */     super.visitVarInsn(paramInt2, this.freeIndex);
/* 228 */     return this.freeIndex + paramStackSize.getSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doDrain(List<StackSize> paramList) {
/* 238 */     ListIterator<StackSize> listIterator = paramList.listIterator(paramList.size());
/* 239 */     while (listIterator.hasPrevious()) {
/* 240 */       StackSize stackSize = listIterator.previous();
/* 241 */       switch (null.a[stackSize.ordinal()]) {
/*     */         case 1:
/* 243 */           super.visitInsn(87);
/*     */           continue;
/*     */         case 2:
/* 246 */           super.visitInsn(88);
/*     */           continue;
/*     */       } 
/* 249 */       throw new IllegalStateException("Unexpected stack size: " + stackSize);
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
/*     */   public void register(Label paramLabel, List<StackSize> paramList) {
/* 261 */     this.sizes.put(paramLabel, paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitInsn(int paramInt) {
/* 266 */     switch (paramInt) {
/*     */       case 172:
/*     */       case 173:
/*     */       case 174:
/*     */       case 175:
/*     */       case 176:
/*     */       case 177:
/*     */       case 191:
/* 274 */         this.current.clear();
/*     */         break;
/*     */       case 90:
/*     */       case 93:
/* 278 */         adjustStack(SIZE_CHANGE[paramInt], SIZE_CHANGE[paramInt] + 1);
/*     */         break;
/*     */       case 91:
/*     */       case 94:
/* 282 */         adjustStack(SIZE_CHANGE[paramInt], SIZE_CHANGE[paramInt] + 2);
/*     */         break;
/*     */       case 136:
/*     */       case 137:
/*     */       case 142:
/*     */       case 144:
/* 288 */         adjustStack(-2);
/* 289 */         adjustStack(1);
/*     */         break;
/*     */       case 133:
/*     */       case 135:
/*     */       case 140:
/*     */       case 141:
/* 295 */         adjustStack(-1);
/* 296 */         adjustStack(2);
/*     */         break;
/*     */       case 47:
/*     */       case 49:
/* 300 */         adjustStack(-2);
/* 301 */         adjustStack(2);
/*     */         break;
/*     */       default:
/* 304 */         adjustStack(SIZE_CHANGE[paramInt]); break;
/*     */     } 
/* 306 */     super.visitInsn(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitIntInsn(int paramInt1, int paramInt2) {
/* 311 */     adjustStack(SIZE_CHANGE[paramInt1]);
/* 312 */     super.visitIntInsn(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   @SuppressFBWarnings(value = {"SF_SWITCH_NO_DEFAULT"}, justification = "No action required on default option.")
/*     */   public void visitVarInsn(int paramInt1, int paramInt2) {
/* 318 */     switch (paramInt1) {
/*     */       case 54:
/*     */       case 56:
/*     */       case 58:
/* 322 */         this.freeIndex = Math.max(this.freeIndex, paramInt2 + 1);
/*     */         break;
/*     */       case 55:
/*     */       case 57:
/* 326 */         this.freeIndex = Math.max(this.freeIndex, paramInt2 + 2);
/*     */         break;
/*     */       case 169:
/* 329 */         this.current.clear();
/*     */         break;
/*     */     } 
/* 332 */     adjustStack(SIZE_CHANGE[paramInt1]);
/* 333 */     super.visitVarInsn(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitTypeInsn(int paramInt, String paramString) {
/* 338 */     adjustStack(SIZE_CHANGE[paramInt]);
/* 339 */     super.visitTypeInsn(paramInt, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 344 */     int i = Type.getType(paramString3).getSize();
/* 345 */     switch (paramInt) {
/*     */       case 180:
/* 347 */         adjustStack(-1);
/* 348 */         adjustStack(i);
/*     */         break;
/*     */       case 178:
/* 351 */         adjustStack(i);
/*     */         break;
/*     */       case 181:
/* 354 */         adjustStack(-i - 1);
/*     */         break;
/*     */       case 179:
/* 357 */         adjustStack(-i);
/*     */         break;
/*     */       default:
/* 360 */         throw new IllegalStateException("Unexpected opcode: " + paramInt);
/*     */     } 
/* 362 */     super.visitFieldInsn(paramInt, paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/* 367 */     int i = Type.getArgumentsAndReturnSizes(paramString3);
/* 368 */     adjustStack(-(i >> 2) + ((paramInt == 184) ? 1 : 0));
/* 369 */     adjustStack(i & 0x3);
/* 370 */     super.visitMethodInsn(paramInt, paramString1, paramString2, paramString3, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitInvokeDynamicInsn(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/* 375 */     int i = Type.getArgumentsAndReturnSizes(paramString2);
/* 376 */     adjustStack(-(i >> 2) + 1);
/* 377 */     adjustStack(i & 0x3);
/* 378 */     super.visitInvokeDynamicInsn(paramString1, paramString2, paramHandle, paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitLdcInsn(Object paramObject) {
/* 383 */     adjustStack((paramObject instanceof Long || paramObject instanceof Double) ? 2 : 1);
/* 384 */     super.visitLdcInsn(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitMultiANewArrayInsn(String paramString, int paramInt) {
/* 389 */     adjustStack(1 - paramInt);
/* 390 */     super.visitMultiANewArrayInsn(paramString, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitJumpInsn(int paramInt, Label paramLabel) {
/* 395 */     adjustStack(SIZE_CHANGE[paramInt]);
/* 396 */     this.sizes.put(paramLabel, new ArrayList<StackSize>((paramInt == 168) ? 
/* 397 */           CompoundList.of(this.current, StackSize.SINGLE) : this.current));
/*     */     
/* 399 */     if (paramInt == 167) {
/* 400 */       this.current.clear();
/*     */     }
/* 402 */     super.visitJumpInsn(paramInt, paramLabel);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitLabel(Label paramLabel) {
/*     */     List<? extends StackSize> list;
/* 408 */     if ((list = this.sizes.get(paramLabel)) != null) {
/* 409 */       this.current = new ArrayList<StackSize>(list);
/*     */     }
/* 411 */     super.visitLabel(paramLabel);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitLineNumber(int paramInt, Label paramLabel) {
/* 416 */     super.visitLineNumber(paramInt, paramLabel);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitTableSwitchInsn(int paramInt1, int paramInt2, Label paramLabel, Label... paramVarArgs) {
/* 421 */     adjustStack(-1);
/* 422 */     ArrayList<StackSize> arrayList = new ArrayList<StackSize>(this.current);
/* 423 */     this.sizes.put(paramLabel, arrayList); Label[] arrayOfLabel; int i; byte b;
/* 424 */     for (i = (arrayOfLabel = paramVarArgs).length, b = 0; b < i; ) { Label label = arrayOfLabel[b];
/* 425 */       this.sizes.put(label, arrayList); b++; }
/*     */     
/* 427 */     super.visitTableSwitchInsn(paramInt1, paramInt2, paramLabel, paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitLookupSwitchInsn(Label paramLabel, int[] paramArrayOfint, Label[] paramArrayOfLabel) {
/* 432 */     adjustStack(-1);
/* 433 */     ArrayList<StackSize> arrayList = new ArrayList<StackSize>(this.current);
/* 434 */     this.sizes.put(paramLabel, arrayList); Label[] arrayOfLabel; int i; byte b;
/* 435 */     for (i = (arrayOfLabel = paramArrayOfLabel).length, b = 0; b < i; ) { Label label = arrayOfLabel[b];
/* 436 */       this.sizes.put(label, arrayList); b++; }
/*     */     
/* 438 */     super.visitLookupSwitchInsn(paramLabel, paramArrayOfint, paramArrayOfLabel);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitTryCatchBlock(Label paramLabel1, Label paramLabel2, Label paramLabel3, @MaybeNull String paramString) {
/* 443 */     this.sizes.put(paramLabel3, Collections.singletonList(StackSize.SINGLE));
/* 444 */     super.visitTryCatchBlock(paramLabel1, paramLabel2, paramLabel3, paramString);
/*     */   }
/*     */   
/*     */   @SuppressFBWarnings(value = {"RC_REF_COMPARISON_BAD_PRACTICE"}, justification = "ASM models frames by reference identity.")
/*     */   public void visitFrame(int paramInt1, int paramInt2, @MaybeNull Object[] paramArrayOfObject1, int paramInt3, @MaybeNull Object[] paramArrayOfObject2) {
/*     */     byte b;
/* 450 */     switch (paramInt1) {
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/* 454 */         this.current.clear();
/*     */         break;
/*     */       case 4:
/* 457 */         this.current.clear();
/* 458 */         if (paramArrayOfObject2[0] == Opcodes.LONG || paramArrayOfObject2[0] == Opcodes.DOUBLE) {
/* 459 */           this.current.add(StackSize.DOUBLE); break;
/*     */         } 
/* 461 */         this.current.add(StackSize.SINGLE);
/*     */         break;
/*     */       
/*     */       case -1:
/*     */       case 0:
/* 466 */         this.current.clear();
/* 467 */         for (b = 0; b < paramInt3; b++) {
/* 468 */           if (paramArrayOfObject2[b] == Opcodes.LONG || paramArrayOfObject2[b] == Opcodes.DOUBLE) {
/* 469 */             this.current.add(StackSize.DOUBLE);
/*     */           } else {
/* 471 */             this.current.add(StackSize.SINGLE);
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       default:
/* 476 */         throw new IllegalStateException("Unknown frame type: " + paramInt1);
/*     */     } 
/* 478 */     super.visitFrame(paramInt1, paramInt2, paramArrayOfObject1, paramInt3, paramArrayOfObject2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\visitor\StackAwareMethodVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */