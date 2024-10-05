/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MethodInfoList
/*     */   extends InfoList<MethodInfo>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   static final MethodInfoList EMPTY_LIST;
/*     */   
/*     */   static {
/*  46 */     (EMPTY_LIST = new MethodInfoList()).makeUnmodifiable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MethodInfoList emptyList() {
/*  55 */     return EMPTY_LIST;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MethodInfoList() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MethodInfoList(int paramInt) {
/*  70 */     super(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MethodInfoList(Collection<MethodInfo> paramCollection) {
/*  81 */     super(paramCollection);
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
/*     */   protected void findReferencedClassInfo(Map<String, ClassInfo> paramMap, Set<ClassInfo> paramSet, LogNode paramLogNode) {
/*  98 */     for (Iterator<MethodInfo> iterator = iterator(); iterator.hasNext();) {
/*  99 */       (methodInfo = iterator.next()).findReferencedClassInfo(paramMap, paramSet, paramLogNode);
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
/*     */   public Map<String, MethodInfoList> asMap() {
/* 116 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 117 */     for (Iterator<MethodInfo> iterator = iterator(); iterator.hasNext(); ) {
/* 118 */       MethodInfo methodInfo; String str = (methodInfo = iterator.next()).getName();
/*     */       MethodInfoList methodInfoList;
/* 120 */       if ((methodInfoList = (MethodInfoList)hashMap.get(str)) == null) {
/* 121 */         methodInfoList = new MethodInfoList(1);
/* 122 */         hashMap.put(str, methodInfoList);
/*     */       } 
/* 124 */       methodInfoList.add(methodInfo);
/*     */     } 
/* 126 */     return (Map)hashMap;
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
/*     */   public boolean containsName(String paramString) {
/* 139 */     for (Iterator<MethodInfo> iterator = iterator(); iterator.hasNext();) {
/* 140 */       if ((methodInfo = iterator.next()).getName().equals(paramString)) {
/* 141 */         return true;
/*     */       }
/*     */     } 
/* 144 */     return false;
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
/*     */   public MethodInfoList get(String paramString) {
/* 159 */     boolean bool = false;
/* 160 */     for (Iterator<MethodInfo> iterator1 = iterator(); iterator1.hasNext();) {
/* 161 */       if ((methodInfo = iterator1.next()).getName().equals(paramString)) {
/* 162 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 166 */     if (!bool) {
/* 167 */       return EMPTY_LIST;
/*     */     }
/* 169 */     MethodInfoList methodInfoList = new MethodInfoList(2);
/* 170 */     for (Iterator<MethodInfo> iterator2 = iterator(); iterator2.hasNext();) {
/* 171 */       if ((methodInfo = iterator2.next()).getName().equals(paramString)) {
/* 172 */         methodInfoList.add(methodInfo);
/*     */       }
/*     */     } 
/* 175 */     return methodInfoList;
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
/*     */   public MethodInfo getSingleMethod(String paramString) {
/* 191 */     byte b = 0;
/* 192 */     MethodInfo methodInfo = null;
/* 193 */     for (Iterator<MethodInfo> iterator = iterator(); iterator.hasNext();) {
/* 194 */       if ((methodInfo1 = iterator.next()).getName().equals(paramString)) {
/* 195 */         b++;
/* 196 */         methodInfo = methodInfo1;
/*     */       } 
/*     */     } 
/* 199 */     if (b == 0)
/* 200 */       return null; 
/* 201 */     if (b == 1) {
/* 202 */       return methodInfo;
/*     */     }
/* 204 */     throw new IllegalArgumentException("There are multiple methods named \"" + paramString + "\" in class " + ((MethodInfo)
/* 205 */         iterator().next()).getClassInfo().getName());
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
/*     */   public MethodInfoList filter(MethodInfoFilter paramMethodInfoFilter) {
/* 237 */     MethodInfoList methodInfoList = new MethodInfoList();
/* 238 */     for (MethodInfo methodInfo : this) {
/* 239 */       if (paramMethodInfoFilter.accept(methodInfo)) {
/* 240 */         methodInfoList.add(methodInfo);
/*     */       }
/*     */     } 
/* 243 */     return methodInfoList;
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface MethodInfoFilter {
/*     */     boolean accept(MethodInfo param1MethodInfo);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\MethodInfoList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */