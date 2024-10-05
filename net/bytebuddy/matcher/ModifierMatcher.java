/*     */ package net.bytebuddy.matcher;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.ModifierReviewable;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Enhance
/*     */ public class ModifierMatcher<T extends ModifierReviewable>
/*     */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*     */ {
/*     */   private final Mode mode;
/*     */   
/*     */   public static <T extends ModifierReviewable> ElementMatcher.Junction<T> of(Mode paramMode) {
/*  39 */     return (ElementMatcher.Junction)paramMode.getMatcher();
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
/*     */   public ModifierMatcher(Mode paramMode) {
/*  53 */     this.mode = paramMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean doMatch(T paramT) {
/*  60 */     return ((this.mode.getModifiers() & paramT.getModifiers()) != 0);
/*     */   } public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.mode.equals(((ModifierMatcher)paramObject).mode)))));
/*     */   }
/*     */   public String toString() {
/*  65 */     return this.mode.getDescription();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return super.hashCode() * 31 + this.mode.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public enum Mode
/*     */   {
/*  76 */     PUBLIC(1, "isPublic()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     PROTECTED(4, "isProtected()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     PRIVATE(2, "isPrivate()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     FINAL(16, "isFinal()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     STATIC(8, "isStatic()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     SYNCHRONIZED(32, "isSynchronized()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     NATIVE(256, "isNative()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     STRICT(2048, "isStrict()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 116 */     VAR_ARGS(128, "isVarArgs()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     SYNTHETIC(4096, "isSynthetic()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     BRIDGE(64, "isBridge()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 131 */     ABSTRACT(1024, "isAbstract()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     INTERFACE(512, "isInterface()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     ANNOTATION(8192, "isAnnotation()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     VOLATILE(64, "isVolatile()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     TRANSIENT(128, "isTransient()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 156 */     MANDATED(32768, "isMandated()"),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     ENUMERATION(16384, "isEnum()");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int modifiers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String description;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final ModifierMatcher<?> matcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Mode(int param1Int1, String param1String1) {
/* 185 */       this.modifiers = param1Int1;
/* 186 */       this.description = param1String1;
/* 187 */       this.matcher = new ModifierMatcher(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final String getDescription() {
/* 196 */       return this.description;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final int getModifiers() {
/* 205 */       return this.modifiers;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final ModifierMatcher<?> getMatcher() {
/* 214 */       return this.matcher;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\ModifierMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */