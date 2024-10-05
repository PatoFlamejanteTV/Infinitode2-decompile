/*     */ package net.bytebuddy.dynamic.scaffold;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.RecordComponentDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.Transformer;
/*     */ import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.LatentMatcher;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface RecordComponentRegistry
/*     */ {
/*     */   RecordComponentRegistry prepend(LatentMatcher<? super RecordComponentDescription> paramLatentMatcher, RecordComponentAttributeAppender.Factory paramFactory, Transformer<RecordComponentDescription> paramTransformer);
/*     */   
/*     */   Compiled compile(TypeDescription paramTypeDescription);
/*     */   
/*     */   public static interface Compiled
/*     */     extends TypeWriter.RecordComponentPool
/*     */   {
/*     */     public enum NoOp
/*     */       implements Compiled
/*     */     {
/*  74 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final TypeWriter.RecordComponentPool.Record target(RecordComponentDescription param2RecordComponentDescription) {
/*  80 */         return new TypeWriter.RecordComponentPool.Record.ForImplicitRecordComponent(param2RecordComponentDescription);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Default
/*     */     implements RecordComponentRegistry
/*     */   {
/*     */     private final List<Entry> entries;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Default() {
/* 100 */       this(Collections.emptyList());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Default(List<Entry> param1List) {
/* 109 */       this.entries = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RecordComponentRegistry prepend(LatentMatcher<? super RecordComponentDescription> param1LatentMatcher, RecordComponentAttributeAppender.Factory param1Factory, Transformer<RecordComponentDescription> param1Transformer) {
/*     */       ArrayList<Entry> arrayList;
/* 119 */       (arrayList = new ArrayList<Entry>(this.entries.size() + 1)).add(new Entry(param1LatentMatcher, param1Factory, param1Transformer));
/* 120 */       arrayList.addAll(this.entries);
/* 121 */       return new Default(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RecordComponentRegistry.Compiled compile(TypeDescription param1TypeDescription) {
/* 128 */       ArrayList<Compiled.Entry> arrayList = new ArrayList(this.entries.size());
/* 129 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 130 */       for (Entry entry : this.entries) {
/*     */         RecordComponentAttributeAppender recordComponentAttributeAppender;
/* 132 */         if ((recordComponentAttributeAppender = (RecordComponentAttributeAppender)hashMap.get(entry.getRecordComponentAttributeAppender())) == null) {
/* 133 */           recordComponentAttributeAppender = entry.getRecordComponentAttributeAppender().make(param1TypeDescription);
/* 134 */           hashMap.put(entry.getRecordComponentAttributeAppender(), recordComponentAttributeAppender);
/*     */         } 
/* 136 */         arrayList.add(new Compiled.Entry(entry.resolve(param1TypeDescription), recordComponentAttributeAppender, entry.getTransformer()));
/*     */       } 
/* 138 */       return new Compiled(param1TypeDescription, arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.entries.equals(((Default)param1Object).entries))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.entries.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class Entry
/*     */       implements LatentMatcher<RecordComponentDescription>
/*     */     {
/*     */       private final LatentMatcher<? super RecordComponentDescription> matcher;
/*     */ 
/*     */       
/*     */       private final RecordComponentAttributeAppender.Factory recordComponentAttributeAppender;
/*     */ 
/*     */       
/*     */       private final Transformer<RecordComponentDescription> transformer;
/*     */ 
/*     */ 
/*     */       
/*     */       protected Entry(LatentMatcher<? super RecordComponentDescription> param2LatentMatcher, RecordComponentAttributeAppender.Factory param2Factory, Transformer<RecordComponentDescription> param2Transformer) {
/* 172 */         this.matcher = param2LatentMatcher;
/* 173 */         this.recordComponentAttributeAppender = param2Factory;
/* 174 */         this.transformer = param2Transformer;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected RecordComponentAttributeAppender.Factory getRecordComponentAttributeAppender() {
/* 183 */         return this.recordComponentAttributeAppender;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Transformer<RecordComponentDescription> getTransformer() {
/* 192 */         return this.transformer;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ElementMatcher<? super RecordComponentDescription> resolve(TypeDescription param2TypeDescription) {
/* 199 */         return this.matcher.resolve(param2TypeDescription);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.matcher.equals(((Entry)param2Object).matcher) ? false : (!this.recordComponentAttributeAppender.equals(((Entry)param2Object).recordComponentAttributeAppender) ? false : (!!this.transformer.equals(((Entry)param2Object).transformer))))));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return ((getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.recordComponentAttributeAppender.hashCode()) * 31 + this.transformer.hashCode();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class Compiled
/*     */       implements RecordComponentRegistry.Compiled
/*     */     {
/*     */       private final TypeDescription instrumentedType;
/*     */       
/*     */       private final List<Entry> entries;
/*     */ 
/*     */       
/*     */       protected Compiled(TypeDescription param2TypeDescription, List<Entry> param2List) {
/* 226 */         this.instrumentedType = param2TypeDescription;
/* 227 */         this.entries = param2List;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeWriter.RecordComponentPool.Record target(RecordComponentDescription param2RecordComponentDescription) {
/* 234 */         for (Iterator<Entry> iterator = this.entries.iterator(); iterator.hasNext();) {
/* 235 */           if ((entry = iterator.next()).matches(param2RecordComponentDescription)) {
/* 236 */             return entry.bind(this.instrumentedType, param2RecordComponentDescription);
/*     */           }
/*     */         } 
/* 239 */         return new TypeWriter.RecordComponentPool.Record.ForImplicitRecordComponent(param2RecordComponentDescription);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.instrumentedType.equals(((Compiled)param2Object).instrumentedType) ? false : (!!this.entries.equals(((Compiled)param2Object).entries)))));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.entries.hashCode();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       protected static class Entry
/*     */         implements ElementMatcher<RecordComponentDescription>
/*     */       {
/*     */         private final ElementMatcher<? super RecordComponentDescription> matcher;
/*     */ 
/*     */         
/*     */         private final RecordComponentAttributeAppender recordComponentAttributeAppender;
/*     */ 
/*     */         
/*     */         private final Transformer<RecordComponentDescription> transformer;
/*     */ 
/*     */ 
/*     */         
/*     */         protected Entry(ElementMatcher<? super RecordComponentDescription> param3ElementMatcher, RecordComponentAttributeAppender param3RecordComponentAttributeAppender, Transformer<RecordComponentDescription> param3Transformer) {
/* 273 */           this.matcher = param3ElementMatcher;
/* 274 */           this.recordComponentAttributeAppender = param3RecordComponentAttributeAppender;
/* 275 */           this.transformer = param3Transformer;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected TypeWriter.RecordComponentPool.Record bind(TypeDescription param3TypeDescription, RecordComponentDescription param3RecordComponentDescription) {
/* 286 */           return new TypeWriter.RecordComponentPool.Record.ForExplicitRecordComponent(this.recordComponentAttributeAppender, (RecordComponentDescription)this.transformer.transform(param3TypeDescription, param3RecordComponentDescription));
/*     */         }
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.matcher.equals(((Entry)param3Object).matcher) ? false : (!this.recordComponentAttributeAppender.equals(((Entry)param3Object).recordComponentAttributeAppender) ? false : (!!this.transformer.equals(((Entry)param3Object).transformer))))));
/*     */         } public int hashCode() {
/*     */           return ((getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.recordComponentAttributeAppender.hashCode()) * 31 + this.transformer.hashCode();
/*     */         }
/* 293 */         public boolean matches(@MaybeNull RecordComponentDescription param3RecordComponentDescription) { return this.matcher.matches(param3RecordComponentDescription); } } } @Enhance protected static class Entry implements ElementMatcher<RecordComponentDescription> { public boolean matches(@MaybeNull RecordComponentDescription param2RecordComponentDescription) { return this.matcher.matches(param2RecordComponentDescription); }
/*     */ 
/*     */       
/*     */       private final ElementMatcher<? super RecordComponentDescription> matcher;
/*     */       private final RecordComponentAttributeAppender recordComponentAttributeAppender;
/*     */       private final Transformer<RecordComponentDescription> transformer;
/*     */       
/*     */       protected Entry(ElementMatcher<? super RecordComponentDescription> param2ElementMatcher, RecordComponentAttributeAppender param2RecordComponentAttributeAppender, Transformer<RecordComponentDescription> param2Transformer) {
/*     */         this.matcher = param2ElementMatcher;
/*     */         this.recordComponentAttributeAppender = param2RecordComponentAttributeAppender;
/*     */         this.transformer = param2Transformer;
/*     */       }
/*     */       
/*     */       protected TypeWriter.RecordComponentPool.Record bind(TypeDescription param2TypeDescription, RecordComponentDescription param2RecordComponentDescription) {
/*     */         return new TypeWriter.RecordComponentPool.Record.ForExplicitRecordComponent(this.recordComponentAttributeAppender, (RecordComponentDescription)this.transformer.transform(param2TypeDescription, param2RecordComponentDescription));
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.matcher.equals(((Entry)param2Object).matcher) ? false : (!this.recordComponentAttributeAppender.equals(((Entry)param2Object).recordComponentAttributeAppender) ? false : (!!this.transformer.equals(((Entry)param2Object).transformer))))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return ((getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.recordComponentAttributeAppender.hashCode()) * 31 + this.transformer.hashCode();
/*     */       } }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\RecordComponentRegistry.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */