/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.Collection;
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
/*     */ public class FieldInfoList
/*     */   extends MappableInfoList<FieldInfo>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   static final FieldInfoList EMPTY_LIST;
/*     */   
/*     */   static {
/*  45 */     (EMPTY_LIST = new FieldInfoList()).makeUnmodifiable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FieldInfoList emptyList() {
/*  54 */     return EMPTY_LIST;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldInfoList() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldInfoList(int paramInt) {
/*  71 */     super(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldInfoList(Collection<FieldInfo> paramCollection) {
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
/*  98 */     for (Iterator<FieldInfo> iterator = iterator(); iterator.hasNext();) {
/*  99 */       (fieldInfo = iterator.next()).findReferencedClassInfo(paramMap, paramSet, paramLogNode);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldInfoList filter(FieldInfoFilter paramFieldInfoFilter) {
/* 131 */     FieldInfoList fieldInfoList = new FieldInfoList();
/* 132 */     for (FieldInfo fieldInfo : this) {
/* 133 */       if (paramFieldInfoFilter.accept(fieldInfo)) {
/* 134 */         fieldInfoList.add(fieldInfo);
/*     */       }
/*     */     } 
/* 137 */     return fieldInfoList;
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface FieldInfoFilter {
/*     */     boolean accept(FieldInfo param1FieldInfo);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\FieldInfoList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */