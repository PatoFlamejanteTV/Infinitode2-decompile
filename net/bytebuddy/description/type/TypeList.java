/*      */ package net.bytebuddy.description.type;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.GenericDeclaration;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Type;
/*      */ import java.lang.reflect.TypeVariable;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.List;
/*      */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*      */ import net.bytebuddy.description.ByteCodeElement;
/*      */ import net.bytebuddy.description.TypeVariableSource;
/*      */ import net.bytebuddy.description.annotation.AnnotationList;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.implementation.bytecode.StackSize;
/*      */ import net.bytebuddy.jar.asm.Type;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.FilterableList;
/*      */ import net.bytebuddy.utility.JavaConstant;
/*      */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface TypeList
/*      */   extends FilterableList<TypeDescription, TypeList>
/*      */ {
/*      */   @AlwaysNull
/*   51 */   public static final TypeList UNDEFINED = null;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @AlwaysNull
/*      */   @SuppressFBWarnings(value = {"MS_MUTABLE_ARRAY", "MS_OOI_PKGPROTECT"}, justification = "Null reference cannot be mutated.")
/*   58 */   public static final String[] NO_INTERFACES = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @MaybeNull
/*      */   String[] toInternalNames();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int getStackSize();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class AbstractBase
/*      */     extends FilterableList.AbstractBase<TypeDescription, TypeList>
/*      */     implements TypeList
/*      */   {
/*      */     protected TypeList wrap(List<TypeDescription> param1List) {
/*   82 */       return new TypeList.Explicit(param1List);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getStackSize() {
/*   89 */       return StackSize.of((Collection)this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public String[] toInternalNames() {
/*   97 */       String[] arrayOfString = new String[size()];
/*   98 */       byte b = 0;
/*   99 */       for (TypeDescription typeDescription : this) {
/*  100 */         arrayOfString[b++] = typeDescription.getInternalName();
/*      */       }
/*  102 */       return (arrayOfString.length == 0) ? NO_INTERFACES : arrayOfString;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForLoadedTypes
/*      */     extends AbstractBase
/*      */   {
/*      */     private final List<? extends Class<?>> types;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForLoadedTypes(Class<?>... param1VarArgs) {
/*  124 */       this(Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForLoadedTypes(List<? extends Class<?>> param1List) {
/*  133 */       this.types = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription get(int param1Int) {
/*  140 */       return TypeDescription.ForLoadedType.of(this.types.get(param1Int));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/*  147 */       return this.types.size();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public String[] toInternalNames() {
/*  155 */       String[] arrayOfString = new String[this.types.size()];
/*  156 */       byte b = 0;
/*  157 */       for (Class<?> clazz : this.types) {
/*  158 */         arrayOfString[b++] = Type.getInternalName(clazz);
/*      */       }
/*  160 */       return (arrayOfString.length == 0) ? NO_INTERFACES : arrayOfString;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Explicit
/*      */     extends AbstractBase
/*      */   {
/*      */     private final List<? extends TypeDescription> typeDescriptions;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Explicit(TypeDescription... param1VarArgs) {
/*  182 */       this(Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Explicit(List<? extends TypeDescription> param1List) {
/*  191 */       this.typeDescriptions = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static TypeList of(List<? extends JavaConstant> param1List) {
/*  201 */       ArrayList<TypeDescription> arrayList = new ArrayList(param1List.size());
/*  202 */       for (JavaConstant javaConstant : param1List) {
/*  203 */         arrayList.add(javaConstant.getTypeDescription());
/*      */       }
/*  205 */       return new Explicit(arrayList);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription get(int param1Int) {
/*  212 */       return this.typeDescriptions.get(param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/*  219 */       return this.typeDescriptions.size();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Empty
/*      */     extends FilterableList.Empty<TypeDescription, TypeList>
/*      */     implements TypeList
/*      */   {
/*      */     @SuppressFBWarnings(value = {"EI_EXPOSE_REP"}, justification = "Value is null")
/*      */     public String[] toInternalNames() {
/*  233 */       return NO_INTERFACES;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getStackSize() {
/*  240 */       return 0;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Generic
/*      */     extends FilterableList<TypeDescription.Generic, Generic>
/*      */   {
/*      */     TypeList asErasures();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Generic asRawTypes();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ByteCodeElement.Token.TokenList<TypeVariableToken> asTokenList(ElementMatcher<? super TypeDescription> param1ElementMatcher);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Generic accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param1Visitor);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int getStackSize();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static abstract class AbstractBase
/*      */       extends FilterableList.AbstractBase<TypeDescription.Generic, Generic>
/*      */       implements Generic
/*      */     {
/*      */       protected TypeList.Generic wrap(List<TypeDescription.Generic> param2List) {
/*  294 */         return new TypeList.Generic.Explicit((List)param2List);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList.Generic accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param2Visitor) {
/*  301 */         ArrayList<? extends TypeDefinition> arrayList = new ArrayList(size());
/*  302 */         for (TypeDescription.Generic generic : this) {
/*  303 */           arrayList.add(generic.accept(param2Visitor));
/*      */         }
/*  305 */         return new TypeList.Generic.Explicit(arrayList);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeElement.Token.TokenList<TypeVariableToken> asTokenList(ElementMatcher<? super TypeDescription> param2ElementMatcher) {
/*  312 */         ArrayList<TypeVariableToken> arrayList = new ArrayList(size());
/*  313 */         for (TypeDescription.Generic generic : this) {
/*  314 */           arrayList.add(TypeVariableToken.of(generic, param2ElementMatcher));
/*      */         }
/*  316 */         return new ByteCodeElement.Token.TokenList(arrayList);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getStackSize() {
/*  323 */         int i = 0;
/*  324 */         for (TypeDescription.Generic generic : this) {
/*  325 */           i += generic.getStackSize().getSize();
/*      */         }
/*  327 */         return i;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList asErasures() {
/*  334 */         ArrayList<TypeDescription> arrayList = new ArrayList(size());
/*  335 */         for (TypeDescription.Generic generic : this) {
/*  336 */           arrayList.add(generic.asErasure());
/*      */         }
/*  338 */         return new TypeList.Explicit(arrayList);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList.Generic asRawTypes() {
/*  345 */         ArrayList<TypeDescription.Generic> arrayList = new ArrayList(size());
/*  346 */         for (TypeDescription.Generic generic : this) {
/*  347 */           arrayList.add(generic.asRawType());
/*      */         }
/*  349 */         return new TypeList.Generic.Explicit((List)arrayList);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Explicit
/*      */       extends AbstractBase
/*      */     {
/*      */       private final List<? extends TypeDefinition> typeDefinitions;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Explicit(TypeDefinition... param2VarArgs) {
/*  369 */         this(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Explicit(List<? extends TypeDefinition> param2List) {
/*  378 */         this.typeDefinitions = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription.Generic get(int param2Int) {
/*  385 */         return ((TypeDefinition)this.typeDefinitions.get(param2Int)).asGenericType();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int size() {
/*  392 */         return this.typeDefinitions.size();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ForLoadedTypes
/*      */       extends AbstractBase
/*      */     {
/*      */       private final List<? extends Type> types;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ForLoadedTypes(Type... param2VarArgs) {
/*  412 */         this(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ForLoadedTypes(List<? extends Type> param2List) {
/*  421 */         this.types = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription.Generic get(int param2Int) {
/*  428 */         return TypeDefinition.Sort.describe(this.types.get(param2Int));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int size() {
/*  435 */         return this.types.size();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class OfTypeVariables
/*      */         extends TypeList.Generic.AbstractBase
/*      */       {
/*      */         private final List<TypeVariable<?>> typeVariables;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected OfTypeVariables(TypeVariable<?>... param3VarArgs) {
/*  454 */           this(Arrays.asList(param3VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected OfTypeVariables(List<TypeVariable<?>> param3List) {
/*  463 */           this.typeVariables = param3List;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static TypeList.Generic of(GenericDeclaration param3GenericDeclaration) {
/*  473 */           return new OfTypeVariables(param3GenericDeclaration.getTypeParameters());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic get(int param3Int) {
/*      */           TypeVariable<?> typeVariable;
/*  481 */           return TypeDefinition.Sort.describe(typeVariable = this.typeVariables.get(param3Int), new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedTypeVariable(typeVariable));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int size() {
/*  488 */           return this.typeVariables.size();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ForDetachedTypes
/*      */       extends AbstractBase
/*      */     {
/*      */       private final List<? extends TypeDescription.Generic> detachedTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ForDetachedTypes(List<? extends TypeDescription.Generic> param2List, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param2Visitor) {
/*  516 */         this.detachedTypes = param2List;
/*  517 */         this.visitor = param2Visitor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypeList.Generic attachVariables(TypeDescription param2TypeDescription, List<? extends TypeVariableToken> param2List) {
/*  528 */         return new OfTypeVariables(param2TypeDescription, param2List, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(param2TypeDescription));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypeList.Generic attach(FieldDescription param2FieldDescription, List<? extends TypeDescription.Generic> param2List) {
/*  539 */         return new ForDetachedTypes(param2List, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(param2FieldDescription));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypeList.Generic attach(MethodDescription param2MethodDescription, List<? extends TypeDescription.Generic> param2List) {
/*  550 */         return new ForDetachedTypes(param2List, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(param2MethodDescription));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypeList.Generic attachVariables(MethodDescription param2MethodDescription, List<? extends TypeVariableToken> param2List) {
/*  561 */         return new OfTypeVariables((TypeVariableSource)param2MethodDescription, param2List, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(param2MethodDescription));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static TypeList.Generic attach(ParameterDescription param2ParameterDescription, List<? extends TypeDescription.Generic> param2List) {
/*  572 */         return new ForDetachedTypes(param2List, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(param2ParameterDescription));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription.Generic get(int param2Int) {
/*  579 */         return ((TypeDescription.Generic)this.detachedTypes.get(param2Int)).<TypeDescription.Generic>accept((TypeDescription.Generic.Visitor)this.visitor);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int size() {
/*  586 */         return this.detachedTypes.size();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class WithResolvedErasure
/*      */         extends TypeList.Generic.AbstractBase
/*      */       {
/*      */         private final List<? extends TypeDescription.Generic> detachedTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public WithResolvedErasure(List<? extends TypeDescription.Generic> param3List, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param3Visitor) {
/*  613 */           this.detachedTypes = param3List;
/*  614 */           this.visitor = param3Visitor;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic get(int param3Int) {
/*  621 */           return new TypeDescription.Generic.LazyProjection.WithResolvedErasure(this.detachedTypes.get(param3Int), this.visitor);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int size() {
/*  628 */           return this.detachedTypes.size();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class OfTypeVariables
/*      */         extends TypeList.Generic.AbstractBase
/*      */       {
/*      */         private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final List<? extends TypeVariableToken> detachedTypeVariables;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public OfTypeVariables(TypeVariableSource param3TypeVariableSource, List<? extends TypeVariableToken> param3List, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param3Visitor) {
/*  662 */           this.typeVariableSource = param3TypeVariableSource;
/*  663 */           this.detachedTypeVariables = param3List;
/*  664 */           this.visitor = param3Visitor;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription.Generic get(int param3Int) {
/*  671 */           return new AttachedTypeVariable(this.typeVariableSource, this.detachedTypeVariables.get(param3Int), this.visitor);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int size() {
/*  678 */           return this.detachedTypeVariables.size();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class AttachedTypeVariable
/*      */           extends TypeDescription.Generic.OfTypeVariable
/*      */         {
/*      */           private final TypeVariableSource typeVariableSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeVariableToken typeVariableToken;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected AttachedTypeVariable(TypeVariableSource param4TypeVariableSource, TypeVariableToken param4TypeVariableToken, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param4Visitor) {
/*  711 */             this.typeVariableSource = param4TypeVariableSource;
/*  712 */             this.typeVariableToken = param4TypeVariableToken;
/*  713 */             this.visitor = param4Visitor;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeList.Generic getUpperBounds() {
/*  720 */             return this.typeVariableToken.getBounds().accept(this.visitor);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeVariableSource getTypeVariableSource() {
/*  727 */             return this.typeVariableSource;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getSymbol() {
/*  734 */             return this.typeVariableToken.getSymbol();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationList getDeclaredAnnotations() {
/*  741 */             return this.typeVariableToken.getAnnotations();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class OfLoadedInterfaceTypes
/*      */       extends AbstractBase
/*      */     {
/*      */       private final Class<?> type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public OfLoadedInterfaceTypes(Class<?> param2Class) {
/*  763 */         this.type = param2Class;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription.Generic get(int param2Int) {
/*  770 */         return new TypeProjection(this.type, param2Int, this.type.getInterfaces(), (byte)0);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int size() {
/*  777 */         return (this.type.getInterfaces()).length;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList asErasures() {
/*  784 */         return new TypeList.ForLoadedTypes(this.type.getInterfaces());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static class TypeProjection
/*      */         extends TypeDescription.Generic.LazyProjection.WithLazyNavigation.OfAnnotatedElement
/*      */       {
/*      */         private final Class<?> type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Class<?>[] erasure;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private TypeProjection(Class<?> param3Class, int param3Int, Class<?>[] param3ArrayOfClass) {
/*  815 */           this.type = param3Class;
/*  816 */           this.index = param3Int;
/*  817 */           this.erasure = param3ArrayOfClass;
/*      */         }
/*      */         
/*      */         @Enhance("resolved")
/*      */         protected TypeDescription.Generic resolve() {
/*      */           TypeDescription.Generic generic;
/*  823 */           Type[] arrayOfType = ((TypeProjection)(generic = this)).type.getGenericInterfaces();
/*  824 */           if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : ((((TypeProjection)generic).erasure.length == arrayOfType.length) ? 
/*  825 */             TypeDefinition.Sort.describe(arrayOfType[((TypeProjection)generic).index], generic.getAnnotationReader()) : generic
/*  826 */             .asRawType()))) == null) {
/*      */             generic = this.resolved;
/*      */           } else {
/*      */             this.resolved = generic;
/*      */           } 
/*      */           return generic;
/*      */         } public TypeDescription asErasure() {
/*  833 */           return TypeDescription.ForLoadedType.of(this.erasure[this.index]);
/*      */         }
/*      */ 
/*      */         
/*      */         protected TypeDescription.Generic.AnnotationReader getAnnotationReader() {
/*  838 */           return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedInterface(this.type, this.index);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class OfConstructorExceptionTypes
/*      */       extends AbstractBase
/*      */     {
/*      */       private final Constructor<?> constructor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public OfConstructorExceptionTypes(Constructor<?> param2Constructor) {
/*  859 */         this.constructor = param2Constructor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription.Generic get(int param2Int) {
/*  866 */         return new TypeProjection(this.constructor, param2Int, this.constructor.getExceptionTypes(), (byte)0);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int size() {
/*  873 */         return (this.constructor.getExceptionTypes()).length;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList asErasures() {
/*  880 */         return new TypeList.ForLoadedTypes(this.constructor.getExceptionTypes());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static class TypeProjection
/*      */         extends TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement
/*      */       {
/*      */         private final Constructor<?> constructor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Class<?>[] erasure;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private TypeProjection(Constructor<?> param3Constructor, int param3Int, Class<?>[] param3ArrayOfClass) {
/*  911 */           this.constructor = param3Constructor;
/*  912 */           this.index = param3Int;
/*  913 */           this.erasure = param3ArrayOfClass;
/*      */         }
/*      */         
/*      */         @Enhance("resolved")
/*      */         protected TypeDescription.Generic resolve() {
/*      */           TypeDescription.Generic generic;
/*  919 */           Type[] arrayOfType = ((TypeProjection)(generic = this)).constructor.getGenericExceptionTypes();
/*  920 */           if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : ((((TypeProjection)generic).erasure.length == arrayOfType.length) ? 
/*  921 */             TypeDefinition.Sort.describe(arrayOfType[((TypeProjection)generic).index], generic.getAnnotationReader()) : generic
/*  922 */             .asRawType()))) == null) {
/*      */             generic = this.resolved;
/*      */           } else {
/*      */             this.resolved = generic;
/*      */           } 
/*      */           return generic;
/*      */         } public TypeDescription asErasure() {
/*  929 */           return TypeDescription.ForLoadedType.of(this.erasure[this.index]);
/*      */         }
/*      */ 
/*      */         
/*      */         protected TypeDescription.Generic.AnnotationReader getAnnotationReader() {
/*  934 */           return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedExecutableExceptionType(this.constructor, this.index);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class OfMethodExceptionTypes
/*      */       extends AbstractBase
/*      */     {
/*      */       private final Method method;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public OfMethodExceptionTypes(Method param2Method) {
/*  955 */         this.method = param2Method;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeDescription.Generic get(int param2Int) {
/*  962 */         return new TypeProjection(this.method, param2Int, this.method.getExceptionTypes());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int size() {
/*  969 */         return (this.method.getExceptionTypes()).length;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList asErasures() {
/*  976 */         return new TypeList.ForLoadedTypes(this.method.getExceptionTypes());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static class TypeProjection
/*      */         extends TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement
/*      */       {
/*      */         private final Method method;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Class<?>[] erasure;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeProjection(Method param3Method, int param3Int, Class<?>[] param3ArrayOfClass) {
/* 1007 */           this.method = param3Method;
/* 1008 */           this.index = param3Int;
/* 1009 */           this.erasure = param3ArrayOfClass;
/*      */         }
/*      */         
/*      */         @Enhance("resolved")
/*      */         protected TypeDescription.Generic resolve() {
/*      */           TypeDescription.Generic generic;
/* 1015 */           Type[] arrayOfType = ((TypeProjection)(generic = this)).method.getGenericExceptionTypes();
/* 1016 */           if ((generic = (TypeDescription.Generic)(((generic = this.resolved) != null) ? null : ((((TypeProjection)generic).erasure.length == arrayOfType.length) ? 
/* 1017 */             TypeDefinition.Sort.describe(arrayOfType[((TypeProjection)generic).index], generic.getAnnotationReader()) : generic
/* 1018 */             .asRawType()))) == null) {
/*      */             generic = this.resolved;
/*      */           } else {
/*      */             this.resolved = generic;
/*      */           } 
/*      */           return generic;
/*      */         } public TypeDescription asErasure() {
/* 1025 */           return TypeDescription.ForLoadedType.of(this.erasure[this.index]);
/*      */         }
/*      */ 
/*      */         
/*      */         protected TypeDescription.Generic.AnnotationReader getAnnotationReader() {
/* 1030 */           return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedExecutableExceptionType(this.method, this.index);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Empty
/*      */       extends FilterableList.Empty<TypeDescription.Generic, Generic>
/*      */       implements Generic
/*      */     {
/*      */       public TypeList asErasures() {
/* 1044 */         return new TypeList.Empty();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList.Generic asRawTypes() {
/* 1051 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TypeList.Generic accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> param2Visitor) {
/* 1058 */         return new Empty();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeElement.Token.TokenList<TypeVariableToken> asTokenList(ElementMatcher<? super TypeDescription> param2ElementMatcher) {
/* 1065 */         return new ByteCodeElement.Token.TokenList((ByteCodeElement.Token[])new TypeVariableToken[0]);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getStackSize() {
/* 1072 */         return 0;
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\type\TypeList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */