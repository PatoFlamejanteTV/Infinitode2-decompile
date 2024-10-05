/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassInfoList
/*     */   extends MappableInfoList<ClassInfo>
/*     */ {
/*     */   private final transient Set<ClassInfo> directlyRelatedClasses;
/*     */   private final boolean sortByName;
/*     */   private static final long serialVersionUID = 1L;
/*     */   static final ClassInfoList EMPTY_LIST;
/*     */   
/*     */   static {
/*  76 */     (EMPTY_LIST = new ClassInfoList()).makeUnmodifiable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassInfoList emptyList() {
/*  85 */     return EMPTY_LIST;
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
/*     */   ClassInfoList(Set<ClassInfo> paramSet1, Set<ClassInfo> paramSet2, boolean paramBoolean) {
/* 101 */     super(paramSet1);
/* 102 */     this.sortByName = paramBoolean;
/* 103 */     if (paramBoolean)
/*     */     {
/*     */       
/* 106 */       CollectionUtils.sortIfNotEmpty(this);
/*     */     }
/*     */     
/* 109 */     this.directlyRelatedClasses = (paramSet2 == null) ? paramSet1 : paramSet2;
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
/*     */   ClassInfoList(ClassInfo.ReachableAndDirectlyRelatedClasses paramReachableAndDirectlyRelatedClasses, boolean paramBoolean) {
/* 122 */     this(paramReachableAndDirectlyRelatedClasses.reachableClasses, paramReachableAndDirectlyRelatedClasses.directlyRelatedClasses, paramBoolean);
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
/*     */   ClassInfoList(Set<ClassInfo> paramSet, boolean paramBoolean) {
/* 135 */     this(paramSet, (Set<ClassInfo>)null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList() {
/* 142 */     super(1);
/* 143 */     this.sortByName = false;
/* 144 */     this.directlyRelatedClasses = new HashSet<>(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList(int paramInt) {
/* 154 */     super(paramInt);
/* 155 */     this.sortByName = false;
/* 156 */     this.directlyRelatedClasses = new HashSet<>(2);
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
/*     */   public ClassInfoList(Collection<ClassInfo> paramCollection) {
/* 171 */     this((paramCollection instanceof Set) ? (Set<ClassInfo>)paramCollection : new HashSet<>(paramCollection), (Set<ClassInfo>)null, true);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> List<Class<T>> loadClasses(Class<T> paramClass, boolean paramBoolean) {
/* 206 */     if (isEmpty()) {
/* 207 */       return Collections.emptyList();
/*     */     }
/* 209 */     ArrayList<Class<T>> arrayList = new ArrayList();
/* 210 */     for (Iterator<ClassInfo> iterator = iterator(); iterator.hasNext();) {
/*     */       
/* 212 */       if ((clazz = (classInfo = iterator.next()).<T>loadClass(paramClass, paramBoolean)) != null) {
/* 213 */         arrayList.add(clazz);
/*     */       }
/*     */     } 
/* 216 */     return arrayList.isEmpty() ? Collections.emptyList() : arrayList;
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
/*     */   public <T> List<Class<T>> loadClasses(Class<T> paramClass) {
/* 239 */     return loadClasses(paramClass, false);
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
/*     */   public List<Class<?>> loadClasses(boolean paramBoolean) {
/* 257 */     if (isEmpty()) {
/* 258 */       return Collections.emptyList();
/*     */     }
/* 260 */     ArrayList<Class<?>> arrayList = new ArrayList();
/*     */     
/* 262 */     for (Iterator<ClassInfo> iterator = iterator(); iterator.hasNext();) {
/*     */       
/* 264 */       if ((clazz = (classInfo = iterator.next()).loadClass(paramBoolean)) != null) {
/* 265 */         arrayList.add(clazz);
/*     */       }
/*     */     } 
/* 268 */     return arrayList.isEmpty() ? Collections.emptyList() : arrayList;
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
/*     */   public List<Class<?>> loadClasses() {
/* 281 */     return loadClasses(false);
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
/*     */   public ClassInfoList directOnly() {
/* 294 */     return new ClassInfoList(this.directlyRelatedClasses, this.directlyRelatedClasses, this.sortByName);
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
/*     */   public ClassInfoList union(ClassInfoList... paramVarArgs) {
/* 307 */     LinkedHashSet<ClassInfo> linkedHashSet1 = new LinkedHashSet(this);
/* 308 */     LinkedHashSet<ClassInfo> linkedHashSet2 = new LinkedHashSet<>(this.directlyRelatedClasses); int i; byte b;
/* 309 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { ClassInfoList classInfoList = paramVarArgs[b];
/* 310 */       linkedHashSet1.addAll(classInfoList);
/* 311 */       linkedHashSet2.addAll(classInfoList.directlyRelatedClasses); b++; }
/*     */     
/* 313 */     return new ClassInfoList(linkedHashSet1, linkedHashSet2, this.sortByName);
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
/*     */   public ClassInfoList intersect(ClassInfoList... paramVarArgs) {
/*     */     ArrayDeque<ClassInfoList> arrayDeque;
/* 327 */     (arrayDeque = new ArrayDeque<>()).add(this);
/* 328 */     boolean bool = false; ClassInfoList[] arrayOfClassInfoList1; int j; byte b2;
/* 329 */     for (j = (arrayOfClassInfoList1 = paramVarArgs).length, b2 = 0; b2 < j; b2++) {
/* 330 */       ClassInfoList classInfoList1; if ((classInfoList1 = arrayOfClassInfoList1[b2]).sortByName) {
/* 331 */         arrayDeque.add(classInfoList1);
/* 332 */       } else if (!bool) {
/* 333 */         bool = true;
/* 334 */         arrayDeque.push(classInfoList1);
/*     */       } else {
/* 336 */         arrayDeque.add(classInfoList1);
/*     */       } 
/*     */     } 
/* 339 */     ClassInfoList classInfoList = arrayDeque.remove();
/* 340 */     LinkedHashSet<ClassInfo> linkedHashSet1 = new LinkedHashSet(classInfoList);
/* 341 */     while (!arrayDeque.isEmpty()) {
/* 342 */       linkedHashSet1.retainAll(arrayDeque.remove());
/*     */     }
/* 344 */     LinkedHashSet<ClassInfo> linkedHashSet2 = new LinkedHashSet<>(this.directlyRelatedClasses); int i; byte b1; ClassInfoList[] arrayOfClassInfoList2;
/* 345 */     for (i = (arrayOfClassInfoList2 = paramVarArgs).length, b1 = 0; b1 < i; ) { ClassInfoList classInfoList1 = arrayOfClassInfoList2[b1];
/* 346 */       linkedHashSet2.retainAll(classInfoList1.directlyRelatedClasses); b1++; }
/*     */     
/* 348 */     return new ClassInfoList(linkedHashSet1, linkedHashSet2, classInfoList.sortByName);
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
/*     */   public ClassInfoList exclude(ClassInfoList paramClassInfoList) {
/* 361 */     LinkedHashSet<ClassInfo> linkedHashSet1 = new LinkedHashSet(this);
/* 362 */     LinkedHashSet<ClassInfo> linkedHashSet2 = new LinkedHashSet<>(this.directlyRelatedClasses);
/* 363 */     linkedHashSet1.removeAll(paramClassInfoList);
/* 364 */     linkedHashSet2.removeAll(paramClassInfoList.directlyRelatedClasses);
/* 365 */     return new ClassInfoList(linkedHashSet1, linkedHashSet2, this.sortByName);
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
/*     */   public ClassInfoList filter(ClassInfoFilter paramClassInfoFilter) {
/* 395 */     LinkedHashSet<ClassInfo> linkedHashSet1 = new LinkedHashSet(size());
/* 396 */     LinkedHashSet<ClassInfo> linkedHashSet2 = new LinkedHashSet(this.directlyRelatedClasses.size());
/* 397 */     for (ClassInfo classInfo : this) {
/* 398 */       if (paramClassInfoFilter.accept(classInfo)) {
/* 399 */         linkedHashSet1.add(classInfo);
/* 400 */         if (this.directlyRelatedClasses.contains(classInfo)) {
/* 401 */           linkedHashSet2.add(classInfo);
/*     */         }
/*     */       } 
/*     */     } 
/* 405 */     return new ClassInfoList(linkedHashSet1, linkedHashSet2, this.sortByName);
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
/*     */   public ClassInfoList getStandardClasses() {
/* 417 */     return filter(new ClassInfoFilter()
/*     */         {
/*     */           public boolean accept(ClassInfo param1ClassInfo) {
/* 420 */             return param1ClassInfo.isStandardClass();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList getInterfaces() {
/* 432 */     return filter(new ClassInfoFilter()
/*     */         {
/*     */           public boolean accept(ClassInfo param1ClassInfo) {
/* 435 */             return param1ClassInfo.isInterface();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList getInterfacesAndAnnotations() {
/* 447 */     return filter(new ClassInfoFilter()
/*     */         {
/*     */           public boolean accept(ClassInfo param1ClassInfo) {
/* 450 */             return param1ClassInfo.isInterfaceOrAnnotation();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList getImplementedInterfaces() {
/* 462 */     return filter(new ClassInfoFilter()
/*     */         {
/*     */           public boolean accept(ClassInfo param1ClassInfo) {
/* 465 */             return param1ClassInfo.isImplementedInterface();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList getAnnotations() {
/* 476 */     return filter(new ClassInfoFilter()
/*     */         {
/*     */           public boolean accept(ClassInfo param1ClassInfo) {
/* 479 */             return param1ClassInfo.isAnnotation();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList getEnums() {
/* 490 */     return filter(new ClassInfoFilter()
/*     */         {
/*     */           public boolean accept(ClassInfo param1ClassInfo) {
/* 493 */             return param1ClassInfo.isEnum();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList getRecords() {
/* 504 */     return filter(new ClassInfoFilter()
/*     */         {
/*     */           public boolean accept(ClassInfo param1ClassInfo) {
/* 507 */             return param1ClassInfo.isRecord();
/*     */           }
/*     */         });
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
/*     */   public ClassInfoList getAssignableTo(ClassInfo paramClassInfo) {
/* 527 */     if (paramClassInfo == null) {
/* 528 */       throw new IllegalArgumentException("assignableToClass parameter cannot be null");
/*     */     }
/*     */     
/* 531 */     final HashSet<ClassInfo> allAssignableFromClasses = new HashSet();
/* 532 */     if (paramClassInfo.isStandardClass()) {
/* 533 */       hashSet.addAll(paramClassInfo.getSubclasses());
/* 534 */     } else if (paramClassInfo.isInterfaceOrAnnotation()) {
/* 535 */       hashSet.addAll(paramClassInfo.getClassesImplementing());
/*     */     } 
/*     */     
/* 538 */     hashSet.add(paramClassInfo);
/*     */     
/* 540 */     return filter(new ClassInfoFilter()
/*     */         {
/*     */           public boolean accept(ClassInfo param1ClassInfo) {
/* 543 */             return allAssignableFromClasses.contains(param1ClassInfo);
/*     */           }
/*     */         });
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
/*     */   public String generateGraphVizDotFileFromInterClassDependencies(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 570 */     if (isEmpty()) {
/* 571 */       throw new IllegalArgumentException("List is empty");
/*     */     }
/*     */     ScanSpec scanSpec;
/* 574 */     if (!(scanSpec = (get(0)).scanResult.scanSpec).enableInterClassDependencies) {
/* 575 */       throw new IllegalArgumentException("Please call ClassGraph#enableInterClassDependencies() before #scan()");
/*     */     }
/*     */     
/* 578 */     return GraphvizDotfileGenerator.generateGraphVizDotFileFromInterClassDependencies(this, paramFloat1, paramFloat2, paramBoolean);
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
/*     */   public String generateGraphVizDotFileFromInterClassDependencies(float paramFloat1, float paramFloat2) {
/* 603 */     if (isEmpty()) {
/* 604 */       throw new IllegalArgumentException("List is empty");
/*     */     }
/*     */     ScanSpec scanSpec;
/* 607 */     if (!(scanSpec = (get(0)).scanResult.scanSpec).enableInterClassDependencies) {
/* 608 */       throw new IllegalArgumentException("Please call ClassGraph#enableInterClassDependencies() before #scan()");
/*     */     }
/*     */     
/* 611 */     return GraphvizDotfileGenerator.generateGraphVizDotFileFromInterClassDependencies(this, paramFloat1, paramFloat2, scanSpec.enableExternalClasses);
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
/*     */   public String generateGraphVizDotFileFromInterClassDependencies() {
/* 632 */     if (isEmpty()) {
/* 633 */       throw new IllegalArgumentException("List is empty");
/*     */     }
/*     */     ScanSpec scanSpec;
/* 636 */     if (!(scanSpec = (get(0)).scanResult.scanSpec).enableInterClassDependencies) {
/* 637 */       throw new IllegalArgumentException("Please call ClassGraph#enableInterClassDependencies() before #scan()");
/*     */     }
/*     */     
/* 640 */     return GraphvizDotfileGenerator.generateGraphVizDotFileFromInterClassDependencies(this, 10.5F, 8.0F, scanSpec.enableExternalClasses);
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
/*     */   @Deprecated
/*     */   public String generateGraphVizDotFileFromClassDependencies() {
/* 655 */     return generateGraphVizDotFileFromInterClassDependencies();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String generateGraphVizDotFile(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 707 */     if (isEmpty()) {
/* 708 */       throw new IllegalArgumentException("List is empty");
/*     */     }
/*     */     ScanSpec scanSpec;
/* 711 */     if (!(scanSpec = (get(0)).scanResult.scanSpec).enableClassInfo) {
/* 712 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*     */     }
/* 714 */     return GraphvizDotfileGenerator.generateGraphVizDotFile(this, paramFloat1, paramFloat2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, scanSpec);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String generateGraphVizDotFile(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {
/* 766 */     return generateGraphVizDotFile(paramFloat1, paramFloat2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, true);
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
/*     */   public String generateGraphVizDotFile(float paramFloat1, float paramFloat2) {
/* 792 */     return generateGraphVizDotFile(paramFloat1, paramFloat2, true, true, true, true, true);
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
/*     */   public String generateGraphVizDotFile() {
/* 815 */     return generateGraphVizDotFile(10.5F, 8.0F, true, true, true, true, true);
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
/*     */   public void generateGraphVizDotFile(File paramFile) {
/* 842 */     PrintWriter printWriter = new PrintWriter(paramFile); Throwable throwable = null; 
/* 843 */     try { printWriter.print(generateGraphVizDotFile());
/* 844 */       if (throwable != null) try { return; } catch (Throwable throwable1) { return; }   return; } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; } finally { if (throwable != null) { try { printWriter.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*     */        }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 854 */     if (this == paramObject)
/* 855 */       return true; 
/* 856 */     if (!(paramObject instanceof ClassInfoList)) {
/* 857 */       return false;
/*     */     }
/* 859 */     paramObject = paramObject;
/* 860 */     if (((this.directlyRelatedClasses == null) ? true : false) != ((((ClassInfoList)paramObject).directlyRelatedClasses == null) ? true : false)) {
/* 861 */       return false;
/*     */     }
/* 863 */     if (this.directlyRelatedClasses == null) {
/* 864 */       return super.equals(paramObject);
/*     */     }
/* 866 */     return (super.equals(paramObject) && this.directlyRelatedClasses.equals(((ClassInfoList)paramObject).directlyRelatedClasses));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 874 */     return super.hashCode() ^ ((this.directlyRelatedClasses == null) ? 0 : this.directlyRelatedClasses.hashCode());
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface ClassInfoFilter {
/*     */     boolean accept(ClassInfo param1ClassInfo);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClassInfoList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */