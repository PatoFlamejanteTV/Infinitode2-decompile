/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
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
/*     */ public class MappableInfoList<T extends HasName>
/*     */   extends InfoList<T>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   MappableInfoList() {}
/*     */   
/*     */   MappableInfoList(int paramInt) {
/*  59 */     super(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   MappableInfoList(Collection<T> paramCollection) {
/*  69 */     super(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, T> asMap() {
/*  80 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  81 */     for (Iterator<HasName> iterator = iterator(); iterator.hasNext();) {
/*  82 */       if ((hasName = iterator.next()) != null) {
/*  83 */         hashMap.put(hasName.getName(), hasName);
/*     */       }
/*     */     } 
/*  86 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsName(String paramString) {
/*  97 */     for (Iterator<HasName> iterator = iterator(); iterator.hasNext();) {
/*  98 */       if ((hasName = iterator.next()) != null && hasName.getName().equals(paramString)) {
/*  99 */         return true;
/*     */       }
/*     */     } 
/* 102 */     return false;
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
/*     */   public T get(String paramString) {
/* 114 */     for (Iterator<HasName> iterator = iterator(); iterator.hasNext();) {
/* 115 */       if ((hasName = iterator.next()) != null && hasName.getName().equals(paramString)) {
/* 116 */         return (T)hasName;
/*     */       }
/*     */     } 
/* 119 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\MappableInfoList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */