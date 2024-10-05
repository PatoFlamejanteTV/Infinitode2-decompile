/*     */ package net.bytebuddy.dynamic;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeInitializer;
/*     */ import net.bytebuddy.implementation.LoadedTypeInitializer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface TypeResolutionStrategy
/*     */ {
/*     */   Resolved resolve();
/*     */   
/*     */   public static interface Resolved
/*     */   {
/*     */     TypeInitializer injectedInto(TypeInitializer param1TypeInitializer);
/*     */     
/*     */     <S extends ClassLoader> Map<TypeDescription, Class<?>> initialize(DynamicType param1DynamicType, @MaybeNull S param1S, ClassLoadingStrategy<? super S> param1ClassLoadingStrategy);
/*     */   }
/*     */   
/*     */   public enum Passive
/*     */     implements TypeResolutionStrategy, Resolved
/*     */   {
/*  79 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final TypeResolutionStrategy.Resolved resolve() {
/*  85 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final TypeInitializer injectedInto(TypeInitializer param1TypeInitializer) {
/*  92 */       return param1TypeInitializer;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final <S extends ClassLoader> Map<TypeDescription, Class<?>> initialize(DynamicType param1DynamicType, @MaybeNull S param1S, ClassLoadingStrategy<? super S> param1ClassLoadingStrategy) {
/* 101 */       Map<? extends TypeDescription, ? extends Class<?>> map = param1ClassLoadingStrategy.load((ClassLoader)param1S, param1DynamicType.getAllTypes());
/* 102 */       for (Iterator<Map.Entry> iterator = param1DynamicType.getLoadedTypeInitializers().entrySet().iterator(); iterator.hasNext();) {
/* 103 */         ((LoadedTypeInitializer)(entry = iterator.next()).getValue()).onLoad((Class)map.get(entry.getKey()));
/*     */       }
/* 105 */       return new HashMap<TypeDescription, Class<?>>(map);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Active
/*     */     implements TypeResolutionStrategy
/*     */   {
/*     */     private final NexusAccessor nexusAccessor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Active() {
/* 125 */       this(new NexusAccessor());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Active(NexusAccessor param1NexusAccessor) {
/* 134 */       this.nexusAccessor = param1NexusAccessor;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"DMI_RANDOM_USED_ONLY_ONCE"}, justification = "Avoids thread-contention.")
/*     */     public TypeResolutionStrategy.Resolved resolve() {
/* 142 */       return new Resolved(this.nexusAccessor, (new Random()).nextInt());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.nexusAccessor.equals(((Active)param1Object).nexusAccessor))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.nexusAccessor.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class Resolved
/*     */       implements TypeResolutionStrategy.Resolved
/*     */     {
/*     */       private final NexusAccessor nexusAccessor;
/*     */       
/*     */       private final int identification;
/*     */ 
/*     */       
/*     */       protected Resolved(NexusAccessor param2NexusAccessor, int param2Int) {
/* 168 */         this.nexusAccessor = param2NexusAccessor;
/* 169 */         this.identification = param2Int;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeInitializer injectedInto(TypeInitializer param2TypeInitializer) {
/* 176 */         return param2TypeInitializer.expandWith(new NexusAccessor.InitializationAppender(this.identification));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public <S extends ClassLoader> Map<TypeDescription, Class<?>> initialize(DynamicType param2DynamicType, @MaybeNull S param2S, ClassLoadingStrategy<? super S> param2ClassLoadingStrategy) {
/* 185 */         HashMap<TypeDescription, LoadedTypeInitializer> hashMap = new HashMap<TypeDescription, LoadedTypeInitializer>(param2DynamicType.getLoadedTypeInitializers());
/* 186 */         TypeDescription typeDescription = param2DynamicType.getTypeDescription();
/* 187 */         Map<TypeDescription, Class<?>> map = param2ClassLoadingStrategy.load((ClassLoader)param2S, param2DynamicType.getAllTypes());
/* 188 */         this.nexusAccessor.register(typeDescription.getName(), ((Class)map
/* 189 */             .get(typeDescription)).getClassLoader(), this.identification, hashMap
/*     */             
/* 191 */             .remove(typeDescription));
/* 192 */         for (Iterator<Map.Entry> iterator = hashMap.entrySet().iterator(); iterator.hasNext();) {
/* 193 */           ((LoadedTypeInitializer)(entry = iterator.next()).getValue()).onLoad((Class)map.get(entry.getKey()));
/*     */         }
/* 195 */         return map;
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.identification != ((Resolved)param2Object).identification) ? false : (!!this.nexusAccessor.equals(((Resolved)param2Object).nexusAccessor)))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.nexusAccessor.hashCode()) * 31 + this.identification;
/*     */       } }
/*     */   }
/*     */   
/*     */   public enum Lazy implements TypeResolutionStrategy, Resolved {
/* 208 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final TypeResolutionStrategy.Resolved resolve() {
/* 214 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final TypeInitializer injectedInto(TypeInitializer param1TypeInitializer) {
/* 221 */       return param1TypeInitializer;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final <S extends ClassLoader> Map<TypeDescription, Class<?>> initialize(DynamicType param1DynamicType, @MaybeNull S param1S, ClassLoadingStrategy<? super S> param1ClassLoadingStrategy) {
/* 230 */       return param1ClassLoadingStrategy.load((ClassLoader)param1S, param1DynamicType.getAllTypes());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Disabled
/*     */     implements TypeResolutionStrategy, Resolved
/*     */   {
/* 242 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final TypeResolutionStrategy.Resolved resolve() {
/* 248 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final TypeInitializer injectedInto(TypeInitializer param1TypeInitializer) {
/* 255 */       return param1TypeInitializer;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final <S extends ClassLoader> Map<TypeDescription, Class<?>> initialize(DynamicType param1DynamicType, @MaybeNull S param1S, ClassLoadingStrategy<? super S> param1ClassLoadingStrategy) {
/* 264 */       throw new IllegalStateException("Cannot initialize a dynamic type for a disabled type resolution strategy");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\TypeResolutionStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */