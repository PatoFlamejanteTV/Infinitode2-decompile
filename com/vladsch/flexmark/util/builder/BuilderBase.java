/*     */ package com.vladsch.flexmark.util.builder;
/*     */ 
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSet;
/*     */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*     */ import com.vladsch.flexmark.util.data.SharedDataKeys;
/*     */ import com.vladsch.flexmark.util.misc.Extension;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ public abstract class BuilderBase<T extends BuilderBase<T>>
/*     */   extends MutableDataSet {
/*  18 */   private final HashSet<Class<?>> loadedExtensions = new HashSet<>();
/*     */ 
/*     */   
/*  21 */   private final HashMap<Class<?>, HashSet<Object>> extensionApiPoints = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Extension currentExtension;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T extensions(Collection<? extends Extension> paramCollection) {
/*  51 */     ArrayList<Extension> arrayList = new ArrayList(((Collection)SharedDataKeys.EXTENSIONS.get((DataHolder)this)).size() + paramCollection.size());
/*     */ 
/*     */     
/*  54 */     for (Extension extension : paramCollection) {
/*  55 */       this.currentExtension = extension;
/*  56 */       if (!this.loadedExtensions.contains(extension.getClass())) {
/*  57 */         preloadExtension(extension);
/*  58 */         arrayList.add(extension);
/*     */       } 
/*  60 */       this.currentExtension = null;
/*     */     } 
/*     */     
/*  63 */     for (Extension extension : paramCollection) {
/*  64 */       this.currentExtension = extension;
/*  65 */       Class<?> clazz = extension.getClass();
/*  66 */       if (!this.loadedExtensions.contains(clazz) && 
/*  67 */         loadExtension(extension)) {
/*  68 */         this.loadedExtensions.add(clazz);
/*  69 */         arrayList.add(extension);
/*     */       } 
/*     */       
/*  72 */       this.currentExtension = null;
/*     */     } 
/*     */     
/*  75 */     if (!arrayList.isEmpty()) {
/*     */       
/*  77 */       arrayList.addAll(0, (Collection<? extends Extension>)SharedDataKeys.EXTENSIONS.get((DataHolder)this));
/*  78 */       set(SharedDataKeys.EXTENSIONS, arrayList);
/*     */     } 
/*     */ 
/*     */     
/*  82 */     return (T)this;
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
/*     */   protected void addExtensionApiPoint(Object paramObject) {
/*     */     Extension extension;
/*  99 */     if ((extension = this.currentExtension) != null) {
/* 100 */       Class<?> clazz = extension.getClass();
/*     */       HashSet<Object> hashSet;
/* 102 */       (hashSet = this.extensionApiPoints.computeIfAbsent(clazz, paramClass -> new HashSet())).add(paramObject);
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
/*     */   public <V> MutableDataSet set(DataKey<V> paramDataKey, V paramV) {
/* 116 */     addExtensionApiPoint(paramDataKey);
/* 117 */     return super.set(paramDataKey, paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <V> MutableDataSet set(NullableDataKey<V> paramNullableDataKey, V paramV) {
/* 123 */     addExtensionApiPoint(paramNullableDataKey);
/* 124 */     return super.set(paramNullableDataKey, paramV);
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
/*     */   @Deprecated
/*     */   public <V> V get(DataKey<V> paramDataKey) {
/* 138 */     return (V)paramDataKey.get((DataHolder)this);
/*     */   }
/*     */   
/*     */   protected BuilderBase(DataHolder paramDataHolder) {
/* 142 */     super(paramDataHolder);
/*     */   }
/*     */   
/*     */   protected void loadExtensions() {
/* 146 */     if (contains((DataKeyBase)SharedDataKeys.EXTENSIONS)) {
/* 147 */       extensions((Collection<? extends Extension>)SharedDataKeys.EXTENSIONS.get((DataHolder)this));
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
/*     */   public static DataHolder removeExtensions(DataHolder paramDataHolder, Collection<Class<? extends Extension>> paramCollection) {
/*     */     boolean bool;
/*     */     ArrayList<?> arrayList;
/* 163 */     if (paramDataHolder.contains((DataKeyBase)SharedDataKeys.EXTENSIONS) && (
/*     */ 
/*     */       
/* 166 */       bool = (arrayList = new ArrayList((Collection)SharedDataKeys.EXTENSIONS.get(paramDataHolder))).removeIf(paramExtension -> paramCollection.contains(paramExtension.getClass())))) {
/* 167 */       if (paramDataHolder instanceof MutableDataHolder) {
/* 168 */         return (DataHolder)((MutableDataHolder)paramDataHolder).set(SharedDataKeys.EXTENSIONS, arrayList);
/*     */       }
/* 170 */       return paramDataHolder.toMutable().set(SharedDataKeys.EXTENSIONS, arrayList).toImmutable();
/*     */     } 
/*     */ 
/*     */     
/* 174 */     return paramDataHolder;
/*     */   }
/*     */   
/*     */   protected abstract void removeApiPoint(Object paramObject);
/*     */   
/*     */   protected abstract void preloadExtension(Extension paramExtension);
/*     */   
/*     */   protected abstract boolean loadExtension(Extension paramExtension);
/*     */   
/*     */   public abstract Object build();
/*     */   
/*     */   protected BuilderBase() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\builder\BuilderBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */