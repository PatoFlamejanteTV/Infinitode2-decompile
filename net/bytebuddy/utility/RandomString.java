/*     */ package net.bytebuddy.utility;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.util.Random;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RandomString
/*     */ {
/*     */   public static final int DEFAULT_LENGTH = 8;
/*     */   private static final char[] SYMBOL;
/*     */   private static final int KEY_BITS;
/*     */   private final Random random;
/*     */   private final int length;
/*     */   
/*     */   static {
/*  47 */     StringBuilder stringBuilder = new StringBuilder(); int i;
/*  48 */     for (i = 48; i <= 57; i = (char)(i + 1)) {
/*  49 */       stringBuilder.append(i);
/*     */     }
/*  51 */     for (i = 97; i <= 122; i = (char)(i + 1)) {
/*  52 */       stringBuilder.append(i);
/*     */     }
/*  54 */     for (i = 65; i <= 90; i = (char)(i + 1)) {
/*  55 */       stringBuilder.append(i);
/*     */     }
/*  57 */     SYMBOL = stringBuilder.toString().toCharArray();
/*     */     
/*  59 */     KEY_BITS = (i = 32 - Integer.numberOfLeadingZeros(SYMBOL.length)) - ((Integer.bitCount(SYMBOL.length) == i) ? 0 : 1);
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
/*     */   public RandomString() {
/*  77 */     this(8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RandomString(int paramInt) {
/*  86 */     this(paramInt, new Random());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RandomString(int paramInt, Random paramRandom) {
/*  96 */     if (paramInt <= 0) {
/*  97 */       throw new IllegalArgumentException("A random string's length cannot be zero or negative");
/*     */     }
/*  99 */     this.length = paramInt;
/* 100 */     this.random = paramRandom;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String make() {
/* 109 */     return make(8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String make(int paramInt) {
/* 119 */     return (new RandomString(paramInt)).nextString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String hashOf(@MaybeNull Object paramObject) {
/* 130 */     return hashOf((paramObject == null) ? 0 : (paramObject
/*     */         
/* 132 */         .getClass().hashCode() ^ System.identityHashCode(paramObject)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String hashOf(int paramInt) {
/* 143 */     char[] arrayOfChar = new char[32 / KEY_BITS + ((32 % KEY_BITS == 0) ? 0 : 1)];
/* 144 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 145 */       arrayOfChar[b] = SYMBOL[paramInt >>> b * KEY_BITS & -1 >>> 32 - KEY_BITS];
/*     */     }
/* 147 */     return new String(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressFBWarnings(value = {"DMI_RANDOM_USED_ONLY_ONCE"}, justification = "Random value is used on each invocation.")
/*     */   public String nextString() {
/* 157 */     char[] arrayOfChar = new char[this.length];
/* 158 */     for (byte b = 0; b < this.length; b++) {
/* 159 */       arrayOfChar[b] = SYMBOL[this.random.nextInt(SYMBOL.length)];
/*     */     }
/* 161 */     return new String(arrayOfChar);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\RandomString.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */