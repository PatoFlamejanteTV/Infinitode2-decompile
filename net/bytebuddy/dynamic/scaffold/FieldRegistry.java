/*     */ package net.bytebuddy.dynamic.scaffold;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.Transformer;
/*     */ import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
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
/*     */ public interface FieldRegistry
/*     */ {
/*     */   FieldRegistry prepend(LatentMatcher<? super FieldDescription> paramLatentMatcher, FieldAttributeAppender.Factory paramFactory, @MaybeNull Object paramObject, Transformer<FieldDescription> paramTransformer);
/*     */   
/*     */   Compiled compile(TypeDescription paramTypeDescription);
/*     */   
/*     */   public static interface Compiled
/*     */     extends TypeWriter.FieldPool
/*     */   {
/*     */     public enum NoOp
/*     */       implements Compiled
/*     */     {
/*  76 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final TypeWriter.FieldPool.Record target(FieldDescription param2FieldDescription) {
/*  82 */         return new TypeWriter.FieldPool.Record.ForImplicitField(param2FieldDescription);
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
/*     */     implements FieldRegistry
/*     */   {
/*     */     private final List<Entry> entries;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Default() {
/* 102 */       this(Collections.emptyList());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Default(List<Entry> param1List) {
/* 111 */       this.entries = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldRegistry prepend(LatentMatcher<? super FieldDescription> param1LatentMatcher, FieldAttributeAppender.Factory param1Factory, @MaybeNull Object param1Object, Transformer<FieldDescription> param1Transformer) {
/*     */       ArrayList<Entry> arrayList;
/* 122 */       (arrayList = new ArrayList<Entry>(this.entries.size() + 1)).add(new Entry(param1LatentMatcher, param1Factory, param1Object, param1Transformer));
/* 123 */       arrayList.addAll(this.entries);
/* 124 */       return new Default(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldRegistry.Compiled compile(TypeDescription param1TypeDescription) {
/* 131 */       ArrayList<Compiled.Entry> arrayList = new ArrayList(this.entries.size());
/* 132 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 133 */       for (Entry entry : this.entries) {
/*     */         FieldAttributeAppender fieldAttributeAppender;
/* 135 */         if ((fieldAttributeAppender = (FieldAttributeAppender)hashMap.get(entry.getFieldAttributeAppenderFactory())) == null) {
/* 136 */           fieldAttributeAppender = entry.getFieldAttributeAppenderFactory().make(param1TypeDescription);
/* 137 */           hashMap.put(entry.getFieldAttributeAppenderFactory(), fieldAttributeAppender);
/*     */         } 
/* 139 */         arrayList.add(new Compiled.Entry(entry.resolve(param1TypeDescription), fieldAttributeAppender, entry.getDefaultValue(), entry.getTransformer()));
/*     */       } 
/* 141 */       return new Compiled(param1TypeDescription, arrayList);
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
/*     */     
/*     */     @Enhance
/*     */     protected static class Entry
/*     */       implements LatentMatcher<FieldDescription>
/*     */     {
/*     */       private final LatentMatcher<? super FieldDescription> matcher;
/*     */ 
/*     */ 
/*     */       
/*     */       private final FieldAttributeAppender.Factory fieldAttributeAppenderFactory;
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */       private final Object defaultValue;
/*     */ 
/*     */ 
/*     */       
/*     */       private final Transformer<FieldDescription> transformer;
/*     */ 
/*     */ 
/*     */       
/*     */       protected Entry(LatentMatcher<? super FieldDescription> param2LatentMatcher, FieldAttributeAppender.Factory param2Factory, @MaybeNull Object param2Object, Transformer<FieldDescription> param2Transformer) {
/* 184 */         this.matcher = param2LatentMatcher;
/* 185 */         this.fieldAttributeAppenderFactory = param2Factory;
/* 186 */         this.defaultValue = param2Object;
/* 187 */         this.transformer = param2Transformer;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected FieldAttributeAppender.Factory getFieldAttributeAppenderFactory() {
/* 196 */         return this.fieldAttributeAppenderFactory;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       protected Object getDefaultValue() {
/* 206 */         return this.defaultValue;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Transformer<FieldDescription> getTransformer() {
/* 215 */         return this.transformer;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ElementMatcher<? super FieldDescription> resolve(TypeDescription param2TypeDescription) {
/* 222 */         return this.matcher.resolve(param2TypeDescription);
/*     */       } public boolean equals(@MaybeNull Object param2Object) { Object object2;
/*     */         if (this == param2Object)
/*     */           return true; 
/*     */         if (param2Object == null)
/*     */           return false; 
/*     */         if (getClass() != param2Object.getClass())
/*     */           return false; 
/*     */         if (!this.matcher.equals(((Entry)param2Object).matcher))
/*     */           return false; 
/*     */         if (!this.fieldAttributeAppenderFactory.equals(((Entry)param2Object).fieldAttributeAppenderFactory))
/*     */           return false; 
/*     */         Object object1 = ((Entry)param2Object).defaultValue;
/*     */         if (object1 != null) {
/*     */           if ((object2 = this.defaultValue) != null) {
/*     */             if (!object2.equals(object1))
/*     */               return false; 
/*     */           } else {
/*     */             return false;
/*     */           } 
/*     */         } else if ((object2 = this.defaultValue) != null) {
/*     */           return false;
/*     */         } 
/*     */         return !!this.transformer.equals(((Entry)param2Object).transformer); } public int hashCode() { Object object;
/*     */         if ((object = this.defaultValue) != null);
/*     */         return (((getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.fieldAttributeAppenderFactory.hashCode()) * 31 + object.hashCode()) * 31 + this.transformer.hashCode(); } } @Enhance
/*     */     protected static class Compiled implements FieldRegistry.Compiled { private final TypeDescription instrumentedType; private final List<Entry> entries;
/* 249 */       protected Compiled(TypeDescription param2TypeDescription, List<Entry> param2List) { this.instrumentedType = param2TypeDescription;
/* 250 */         this.entries = param2List; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeWriter.FieldPool.Record target(FieldDescription param2FieldDescription) {
/* 257 */         for (Iterator<Entry> iterator = this.entries.iterator(); iterator.hasNext();) {
/* 258 */           if ((entry = iterator.next()).matches(param2FieldDescription)) {
/* 259 */             return entry.bind(this.instrumentedType, param2FieldDescription);
/*     */           }
/*     */         } 
/* 262 */         return new TypeWriter.FieldPool.Record.ForImplicitField(param2FieldDescription);
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
/*     */       
/*     */       @Enhance
/*     */       protected static class Entry
/*     */         implements ElementMatcher<FieldDescription>
/*     */       {
/*     */         private final ElementMatcher<? super FieldDescription> matcher;
/*     */ 
/*     */ 
/*     */         
/*     */         private final FieldAttributeAppender fieldAttributeAppender;
/*     */ 
/*     */ 
/*     */         
/*     */         @MaybeNull
/*     */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */         private final Object defaultValue;
/*     */ 
/*     */ 
/*     */         
/*     */         private final Transformer<FieldDescription> transformer;
/*     */ 
/*     */ 
/*     */         
/*     */         protected Entry(ElementMatcher<? super FieldDescription> param3ElementMatcher, FieldAttributeAppender param3FieldAttributeAppender, @MaybeNull Object param3Object, Transformer<FieldDescription> param3Transformer) {
/* 305 */           this.matcher = param3ElementMatcher;
/* 306 */           this.fieldAttributeAppender = param3FieldAttributeAppender;
/* 307 */           this.defaultValue = param3Object;
/* 308 */           this.transformer = param3Transformer;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected TypeWriter.FieldPool.Record bind(TypeDescription param3TypeDescription, FieldDescription param3FieldDescription) {
/* 319 */           return new TypeWriter.FieldPool.Record.ForExplicitField(this.fieldAttributeAppender, this.defaultValue, (FieldDescription)this.transformer.transform(param3TypeDescription, param3FieldDescription));
/*     */         } public boolean equals(@MaybeNull Object param3Object) { Object object2; if (this == param3Object)
/*     */             return true;  if (param3Object == null)
/*     */             return false;  if (getClass() != param3Object.getClass())
/*     */             return false;  if (!this.matcher.equals(((Entry)param3Object).matcher))
/*     */             return false;  if (!this.fieldAttributeAppender.equals(((Entry)param3Object).fieldAttributeAppender))
/*     */             return false;  Object object1 = ((Entry)param3Object).defaultValue; if (object1 != null) { if ((object2 = this.defaultValue) != null) { if (!object2.equals(object1))
/* 326 */                 return false;  } else { return false; }  } else if ((object2 = this.defaultValue) != null) { return false; }  return !!this.transformer.equals(((Entry)param3Object).transformer); } public boolean matches(@MaybeNull FieldDescription param3FieldDescription) { return this.matcher.matches(param3FieldDescription); } public int hashCode() { Object object; if ((object = this.defaultValue) != null); return (((getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.fieldAttributeAppender.hashCode()) * 31 + object.hashCode()) * 31 + this.transformer.hashCode(); } } } @Enhance protected static class Entry implements ElementMatcher<FieldDescription> { public boolean matches(@MaybeNull FieldDescription param2FieldDescription) { return this.matcher.matches(param2FieldDescription); }
/*     */ 
/*     */       
/*     */       private final ElementMatcher<? super FieldDescription> matcher;
/*     */       private final FieldAttributeAppender fieldAttributeAppender;
/*     */       @MaybeNull
/*     */       @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */       private final Object defaultValue;
/*     */       private final Transformer<FieldDescription> transformer;
/*     */       
/*     */       protected Entry(ElementMatcher<? super FieldDescription> param2ElementMatcher, FieldAttributeAppender param2FieldAttributeAppender, @MaybeNull Object param2Object, Transformer<FieldDescription> param2Transformer) {
/*     */         this.matcher = param2ElementMatcher;
/*     */         this.fieldAttributeAppender = param2FieldAttributeAppender;
/*     */         this.defaultValue = param2Object;
/*     */         this.transformer = param2Transformer;
/*     */       }
/*     */       
/*     */       protected TypeWriter.FieldPool.Record bind(TypeDescription param2TypeDescription, FieldDescription param2FieldDescription) {
/*     */         return new TypeWriter.FieldPool.Record.ForExplicitField(this.fieldAttributeAppender, this.defaultValue, (FieldDescription)this.transformer.transform(param2TypeDescription, param2FieldDescription));
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         Object object2;
/*     */         if (this == param2Object)
/*     */           return true; 
/*     */         if (param2Object == null)
/*     */           return false; 
/*     */         if (getClass() != param2Object.getClass())
/*     */           return false; 
/*     */         if (!this.matcher.equals(((Entry)param2Object).matcher))
/*     */           return false; 
/*     */         if (!this.fieldAttributeAppender.equals(((Entry)param2Object).fieldAttributeAppender))
/*     */           return false; 
/*     */         Object object1 = ((Entry)param2Object).defaultValue;
/*     */         if (object1 != null) {
/*     */           if ((object2 = this.defaultValue) != null) {
/*     */             if (!object2.equals(object1))
/*     */               return false; 
/*     */           } else {
/*     */             return false;
/*     */           } 
/*     */         } else if ((object2 = this.defaultValue) != null) {
/*     */           return false;
/*     */         } 
/*     */         return !!this.transformer.equals(((Entry)param2Object).transformer);
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         Object object;
/*     */         if ((object = this.defaultValue) != null);
/*     */         return (((getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.fieldAttributeAppender.hashCode()) * 31 + object.hashCode()) * 31 + this.transformer.hashCode();
/*     */       } }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\FieldRegistry.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */