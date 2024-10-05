/*    */ package com.vladsch.flexmark.util.dependency;
/*    */ 
/*    */ import java.util.BitSet;
/*    */ 
/*    */ public class DependentItem<D> {
/*    */   public final int index;
/*    */   public final D dependent;
/*    */   public final Class<?> dependentClass;
/*    */   public final boolean isGlobalScope;
/*    */   BitSet dependencies;
/*    */   BitSet dependents;
/*    */   
/*    */   public DependentItem(int paramInt, D paramD, Class<?> paramClass, boolean paramBoolean) {
/* 14 */     this.index = paramInt;
/* 15 */     this.dependent = paramD;
/* 16 */     this.dependentClass = paramClass;
/* 17 */     this.isGlobalScope = paramBoolean;
/*    */   }
/*    */   
/*    */   public void addDependency(DependentItem<D> paramDependentItem) {
/* 21 */     if (this.dependencies == null) this.dependencies = new BitSet(); 
/* 22 */     this.dependencies.set(paramDependentItem.index);
/*    */   }
/*    */   
/*    */   public void addDependency(BitSet paramBitSet) {
/* 26 */     if (this.dependencies == null) this.dependencies = new BitSet(); 
/* 27 */     this.dependencies.or(paramBitSet);
/*    */   }
/*    */   
/*    */   public boolean removeDependency(DependentItem<D> paramDependentItem) {
/* 31 */     if (this.dependencies != null) {
/* 32 */       this.dependencies.clear(paramDependentItem.index);
/*    */     }
/* 34 */     return hasDependencies();
/*    */   }
/*    */   
/*    */   public boolean removeDependency(BitSet paramBitSet) {
/* 38 */     if (this.dependencies != null) {
/* 39 */       this.dependencies.andNot(paramBitSet);
/*    */     }
/* 41 */     return hasDependencies();
/*    */   }
/*    */   
/*    */   public void addDependent(DependentItem<D> paramDependentItem) {
/* 45 */     if (this.dependents == null) this.dependents = new BitSet(); 
/* 46 */     this.dependents.set(paramDependentItem.index);
/*    */   }
/*    */   
/*    */   public void addDependent(BitSet paramBitSet) {
/* 50 */     if (this.dependents == null) this.dependents = new BitSet(); 
/* 51 */     this.dependents.or(paramBitSet);
/*    */   }
/*    */   
/*    */   public void removeDependent(DependentItem<D> paramDependentItem) {
/* 55 */     if (this.dependents != null) {
/* 56 */       this.dependents.clear(paramDependentItem.index);
/*    */     }
/*    */   }
/*    */   
/*    */   public void removeDependent(BitSet paramBitSet) {
/* 61 */     if (this.dependents != null) {
/* 62 */       this.dependents.andNot(paramBitSet);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean hasDependencies() {
/* 67 */     return (this.dependencies != null && this.dependencies.nextSetBit(0) != -1);
/*    */   }
/*    */   
/*    */   public boolean hasDependents() {
/* 71 */     return (this.dependents != null && this.dependents.nextSetBit(0) != -1);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\dependency\DependentItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */