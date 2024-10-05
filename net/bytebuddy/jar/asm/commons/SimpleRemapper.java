/*     */ package net.bytebuddy.jar.asm.commons;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleRemapper
/*     */   extends Remapper
/*     */ {
/*     */   private final Map<String, String> mapping;
/*     */   
/*     */   public SimpleRemapper(Map<String, String> paramMap) {
/*  61 */     this.mapping = paramMap;
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
/*     */   public SimpleRemapper(String paramString1, String paramString2) {
/*  73 */     this.mapping = Collections.singletonMap(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String mapMethodName(String paramString1, String paramString2, String paramString3) {
/*  79 */     return ((paramString1 = map(paramString1 + '.' + paramString2 + paramString3)) == null) ? paramString2 : paramString1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String mapInvokeDynamicMethodName(String paramString1, String paramString2) {
/*  85 */     return ((paramString2 = map("." + paramString1 + paramString2)) == null) ? paramString1 : paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String mapAnnotationAttributeName(String paramString1, String paramString2) {
/*  91 */     return ((paramString1 = map(paramString1 + '.' + paramString2)) == null) ? paramString2 : paramString1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String mapFieldName(String paramString1, String paramString2, String paramString3) {
/*  97 */     return ((paramString1 = map(paramString1 + '.' + paramString2)) == null) ? paramString2 : paramString1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String map(String paramString) {
/* 102 */     return this.mapping.get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\commons\SimpleRemapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */