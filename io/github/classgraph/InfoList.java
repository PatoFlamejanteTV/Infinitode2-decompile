/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InfoList<T extends HasName>
/*     */   extends PotentiallyUnmodifiableList<T>
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   
/*     */   InfoList() {}
/*     */   
/*     */   InfoList(int paramInt) {
/*  60 */     super(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   InfoList(Collection<T> paramCollection) {
/*  70 */     super(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  76 */     return super.equals(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  82 */     return super.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getNames() {
/*  93 */     if (isEmpty()) {
/*  94 */       return Collections.emptyList();
/*     */     }
/*  96 */     ArrayList<String> arrayList = new ArrayList(size());
/*  97 */     for (Iterator<HasName> iterator = iterator(); iterator.hasNext();) {
/*  98 */       if ((hasName = iterator.next()) != null) {
/*  99 */         arrayList.add(hasName.getName());
/*     */       }
/*     */     } 
/* 102 */     return arrayList;
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
/*     */   public List<String> getAsStrings() {
/* 114 */     if (isEmpty()) {
/* 115 */       return Collections.emptyList();
/*     */     }
/* 117 */     ArrayList<String> arrayList = new ArrayList(size());
/* 118 */     for (HasName hasName : this) {
/* 119 */       arrayList.add((hasName == null) ? "null" : hasName.toString());
/*     */     }
/* 121 */     return arrayList;
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
/*     */   public List<String> getAsStringsWithSimpleNames() {
/* 137 */     if (isEmpty()) {
/* 138 */       return Collections.emptyList();
/*     */     }
/* 140 */     ArrayList<String> arrayList = new ArrayList(size());
/* 141 */     for (HasName hasName : this) {
/* 142 */       arrayList.add((hasName == null) ? "null" : ((hasName instanceof ScanResultObject) ? ((ScanResultObject)hasName)
/* 143 */           .toStringWithSimpleNames() : hasName
/* 144 */           .toString()));
/*     */     }
/* 146 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\InfoList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */