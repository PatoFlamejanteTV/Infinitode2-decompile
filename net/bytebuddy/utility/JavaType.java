/*     */ package net.bytebuddy.utility;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.GenericDeclaration;
/*     */ import java.lang.reflect.Member;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
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
/*     */ public enum JavaType
/*     */ {
/*  38 */   CONSTABLE("java.lang.constant.Constable", 1537, (TypeDefinition)TypeDescription.UNDEFINED, new TypeDefinition[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   TYPE_DESCRIPTOR("java.lang.invoke.TypeDescriptor", 1537, (TypeDefinition)TypeDescription.UNDEFINED, new TypeDefinition[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   TYPE_DESCRIPTOR_OF_FIELD("java.lang.invoke.TypeDescriptor$OfField", 1537, (TypeDefinition)TypeDescription.UNDEFINED, new TypeDefinition[] { (TypeDefinition)TYPE_DESCRIPTOR
/*     */ 
/*     */       
/*  51 */       .getTypeStub()
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/*  56 */   TYPE_DESCRIPTOR_OF_METHOD("java.lang.invoke.TypeDescriptor$OfMethod", 1537, (TypeDefinition)TypeDescription.UNDEFINED, new TypeDefinition[] { (TypeDefinition)TYPE_DESCRIPTOR
/*     */ 
/*     */       
/*  59 */       .getTypeStub()
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/*  64 */   CONSTANT_DESCRIPTION("java.lang.constant.ConstantDesc", 1537, (TypeDefinition)TypeDescription.UNDEFINED, new TypeDefinition[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   DYNAMIC_CONSTANT_DESCRIPTION("java.lang.constant.DynamicConstantDesc", 1025, 
/*     */     
/*  71 */     (TypeDefinition)TypeDescription.ForLoadedType.of(Object.class), new TypeDefinition[] { (TypeDefinition)CONSTANT_DESCRIPTION
/*  72 */       .getTypeStub()
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/*  77 */   CLASS_DESCRIPTION("java.lang.constant.ClassDesc", 1537, (TypeDefinition)TypeDescription.UNDEFINED, new TypeDefinition[] { (TypeDefinition)CONSTANT_DESCRIPTION
/*     */ 
/*     */       
/*  80 */       .getTypeStub(), (TypeDefinition)TYPE_DESCRIPTOR_OF_FIELD
/*  81 */       .getTypeStub()
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/*  86 */   METHOD_TYPE_DESCRIPTION("java.lang.constant.MethodTypeDesc", 1537, (TypeDefinition)TypeDescription.UNDEFINED, new TypeDefinition[] { (TypeDefinition)CONSTANT_DESCRIPTION
/*     */ 
/*     */       
/*  89 */       .getTypeStub(), (TypeDefinition)TYPE_DESCRIPTOR_OF_METHOD
/*  90 */       .getTypeStub()
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/*  95 */   METHOD_HANDLE_DESCRIPTION("java.lang.constant.MethodHandleDesc", 1537, (TypeDefinition)TypeDescription.UNDEFINED, new TypeDefinition[] { (TypeDefinition)CONSTANT_DESCRIPTION
/*     */ 
/*     */       
/*  98 */       .getTypeStub()
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/* 103 */   DIRECT_METHOD_HANDLE_DESCRIPTION("java.lang.constant.DirectMethodHandleDesc", 1537, (TypeDefinition)TypeDescription.UNDEFINED, new TypeDefinition[] { (TypeDefinition)METHOD_HANDLE_DESCRIPTION
/*     */ 
/*     */       
/* 106 */       .getTypeStub()
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/* 111 */   METHOD_HANDLE("java.lang.invoke.MethodHandle", 1025, (TypeDefinition)TypeDescription.ForLoadedType.of(Object.class), new TypeDefinition[] { (TypeDefinition)CONSTABLE.getTypeStub()
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/* 116 */   METHOD_HANDLES("java.lang.invoke.MethodHandles", 1, Object.class, new Type[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   METHOD_TYPE("java.lang.invoke.MethodType", 17, 
/*     */     
/* 123 */     (TypeDefinition)TypeDescription.ForLoadedType.of(Object.class), new TypeDefinition[] { (TypeDefinition)CONSTABLE
/* 124 */       .getTypeStub(), (TypeDefinition)TYPE_DESCRIPTOR_OF_METHOD
/* 125 */       .getTypeStub(), 
/* 126 */       (TypeDefinition)TypeDescription.ForLoadedType.of(Serializable.class)
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/* 131 */   METHOD_HANDLES_LOOKUP("java.lang.invoke.MethodHandles$Lookup", 25, Object.class, new Type[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   CALL_SITE("java.lang.invoke.CallSite", 1025, Object.class, new Type[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   VAR_HANDLE("java.lang.invoke.VarHandle", 1025, (TypeDefinition)TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), new TypeDefinition[] { (TypeDefinition)CONSTABLE.getTypeStub()
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/* 146 */   PARAMETER("java.lang.reflect.Parameter", 17, Object.class, new Type[] { AnnotatedElement.class
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/* 151 */   EXECUTABLE("java.lang.reflect.Executable", 1025, AccessibleObject.class, new Type[] { Member.class, GenericDeclaration.class
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/* 156 */   MODULE("java.lang.Module", 17, Object.class, new Type[] { AnnotatedElement.class
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/* 161 */   CONSTANT_BOOTSTRAPS("java.lang.invoke.ConstantBootstraps", 17, Object.class, new Type[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 166 */   RECORD("java.lang.Record", 1025, Object.class, new Type[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 171 */   OBJECT_METHODS("java.lang.runtime.ObjectMethods", 1, Object.class, new Type[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 176 */   ACCESS_CONTROL_CONTEXT("java.security.AccessControlContext", 17, (TypeDefinition)TypeDescription.UNDEFINED, new TypeDefinition[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TypeDescription typeDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   JavaType(@MaybeNull String paramString1, int paramInt1, TypeDescription.Generic paramGeneric, TypeList.Generic paramGeneric1) {
/* 220 */     this.typeDescription = (TypeDescription)new LatentTypeWithSimpleName(paramString1, paramInt1, paramGeneric, (List<? extends TypeDescription.Generic>)paramGeneric1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TypeDescription getTypeStub() {
/* 230 */     return this.typeDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance("loaded")
/*     */   public final Class<?> load() {
/*     */     Class clazz1;
/*     */     JavaType javaType;
/*     */     Class<?> clazz;
/* 241 */     if ((clazz = (Class<?>)(((clazz1 = this.loaded) != null) ? null : Class.forName((javaType = this).typeDescription.getName(), false, ClassLoadingStrategy.BOOTSTRAP_LOADER))) == null) { clazz = this.loaded; } else { this.loaded = clazz; }  return clazz;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TypeDescription loadAsDescription() {
/* 251 */     return TypeDescription.ForLoadedType.of(load());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isAvailable() {
/* 260 */     return doIsAvailable().booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance("available")
/*     */   private Boolean doIsAvailable() {
/* 272 */     JavaType javaType = this; try { javaType.load(); }
/*     */     
/* 274 */     catch (ClassNotFoundException classNotFoundException) {} Boolean bool1, bool2;
/* 275 */     if ((bool1 = (Boolean)(((bool2 = this.available) != null) ? null : Boolean.FALSE)) == null) { bool1 = this.available; } else { this.available = bool1; }  return bool1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isInstance(Object paramObject) {
/* 286 */     if (!isAvailable()) {
/* 287 */       return false;
/*     */     }
/*     */     try {
/* 290 */       return load().isInstance(paramObject);
/* 291 */     } catch (ClassNotFoundException classNotFoundException) {
/* 292 */       return false;
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
/*     */   protected static class LatentTypeWithSimpleName
/*     */     extends TypeDescription.Latent
/*     */   {
/*     */     protected LatentTypeWithSimpleName(String param1String, int param1Int, @MaybeNull TypeDescription.Generic param1Generic, List<? extends TypeDescription.Generic> param1List) {
/* 311 */       super(param1String, param1Int, param1Generic, param1List);
/*     */     }
/*     */ 
/*     */     
/*     */     public String getSimpleName() {
/*     */       String str;
/*     */       int i;
/* 318 */       return ((i = Math.max((str = getName()).lastIndexOf('$'), str.lastIndexOf('.'))) == -1) ? str : str.substring(i + 1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\JavaType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */