/*     */ package net.bytebuddy.matcher;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
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
/*     */ @Enhance
/*     */ public class StringMatcher
/*     */   extends ElementMatcher.Junction.ForNonNullValues<String>
/*     */ {
/*     */   private final String value;
/*     */   private final Mode mode;
/*     */   
/*     */   public StringMatcher(String paramString, Mode paramMode) {
/*  45 */     this.value = paramString;
/*  46 */     this.mode = paramMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean doMatch(String paramString) {
/*  53 */     return this.mode.matches(this.value, paramString);
/*     */   } public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.mode.equals(((StringMatcher)paramObject).mode) ? false : (!!this.value.equals(((StringMatcher)paramObject).value))))));
/*     */   }
/*     */   public String toString() {
/*  58 */     return this.mode.getDescription() + '(' + this.value + ')';
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return (super.hashCode() * 31 + this.value.hashCode()) * 31 + this.mode.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public enum Mode
/*     */   {
/*  69 */     EQUALS_FULLY("equals")
/*     */     {
/*     */       protected final boolean matches(String param2String1, String param2String2) {
/*  72 */         return param2String2.equals(param2String1);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     EQUALS_FULLY_IGNORE_CASE("equalsIgnoreCase")
/*     */     {
/*     */       protected final boolean matches(String param2String1, String param2String2) {
/*  82 */         return param2String2.equalsIgnoreCase(param2String1);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     STARTS_WITH("startsWith")
/*     */     {
/*     */       protected final boolean matches(String param2String1, String param2String2) {
/*  92 */         return param2String2.startsWith(param2String1);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     STARTS_WITH_IGNORE_CASE("startsWithIgnoreCase")
/*     */     {
/*     */       @SuppressFBWarnings(value = {"DM_CONVERT_CASE"}, justification = "Both strings are transformed by the default locale.")
/*     */       protected final boolean matches(String param2String1, String param2String2) {
/* 103 */         return param2String2.toLowerCase().startsWith(param2String1.toLowerCase());
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     ENDS_WITH("endsWith")
/*     */     {
/*     */       protected final boolean matches(String param2String1, String param2String2) {
/* 113 */         return param2String2.endsWith(param2String1);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     ENDS_WITH_IGNORE_CASE("endsWithIgnoreCase")
/*     */     {
/*     */       @SuppressFBWarnings(value = {"DM_CONVERT_CASE"}, justification = "Both strings are transformed by the default locale.")
/*     */       protected final boolean matches(String param2String1, String param2String2) {
/* 124 */         return param2String2.toLowerCase().endsWith(param2String1.toLowerCase());
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 131 */     CONTAINS("contains")
/*     */     {
/*     */       protected final boolean matches(String param2String1, String param2String2) {
/* 134 */         return param2String2.contains(param2String1);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     CONTAINS_IGNORE_CASE("containsIgnoreCase")
/*     */     {
/*     */       @SuppressFBWarnings(value = {"DM_CONVERT_CASE"}, justification = "Both strings are transformed by the default locale.")
/*     */       protected final boolean matches(String param2String1, String param2String2) {
/* 145 */         return param2String2.toLowerCase().contains(param2String1.toLowerCase());
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     MATCHES("matches")
/*     */     {
/*     */       protected final boolean matches(String param2String1, String param2String2) {
/* 155 */         return param2String2.matches(param2String1);
/*     */       }
/*     */     };
/*     */ 
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
/*     */ 
/*     */     
/*     */     Mode(String param1String1) {
/* 172 */       this.description = param1String1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected String getDescription() {
/* 181 */       return this.description;
/*     */     }
/*     */     
/*     */     protected abstract boolean matches(String param1String1, String param1String2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\StringMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */