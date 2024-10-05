/*     */ package net.bytebuddy.implementation.auxiliary;
/*     */ 
/*     */ import java.lang.reflect.Type;
/*     */ import java.security.PrivilegedExceptionAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import net.bytebuddy.ByteBuddy;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.modifier.ModifierContributor;
/*     */ import net.bytebuddy.description.modifier.Visibility;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*     */ import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
/*     */ import net.bytebuddy.implementation.FieldAccessor;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.MethodAccessorFactory;
/*     */ import net.bytebuddy.implementation.MethodCall;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.CompoundList;
/*     */ import net.bytebuddy.utility.RandomString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum PrivilegedMemberLookupAction
/*     */   implements AuxiliaryType
/*     */ {
/*  50 */   FOR_PUBLIC_METHOD("getMethod", "name", String.class, "parameters", Class[].class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   FOR_DECLARED_METHOD("getDeclaredMethod", "name", String.class, "parameters", Class[].class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   FOR_PUBLIC_CONSTRUCTOR("getConstructor", "parameters", Class[].class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   FOR_DECLARED_CONSTRUCTOR("getDeclaredConstructor", "parameters", Class[].class);
/*     */   
/*     */   private static final String TYPE_FIELD = "type";
/*     */   
/*     */   private static final MethodDescription.InDefinedShape DEFAULT_CONSTRUCTOR;
/*     */   
/*     */   private final MethodDescription.InDefinedShape methodDescription;
/*     */   
/*     */   private final Map<String, Class<?>> fields;
/*     */ 
/*     */   
/*     */   static {
/*  77 */     DEFAULT_CONSTRUCTOR = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly();
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
/*     */   PrivilegedMemberLookupAction(String paramString1, String paramString2, Class<?> paramClass) {
/*     */     try {
/*  98 */       this.methodDescription = (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Class.class.getMethod(paramString1, new Class[] { paramClass }));
/*  99 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 100 */       throw new IllegalStateException("Could not locate method: " + paramString1, noSuchMethodException);
/*     */     } 
/* 102 */     this.fields = Collections.singletonMap(paramString2, paramClass);
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
/*     */   PrivilegedMemberLookupAction(String paramString1, String paramString2, Class<?> paramClass1, String paramString3, Class<?> paramClass2) {
/*     */     try {
/* 116 */       this.methodDescription = (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Class.class.getMethod(paramString1, new Class[] { paramClass1, paramClass2 }));
/* 117 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 118 */       throw new IllegalStateException("Could not locate method: " + paramString1, noSuchMethodException);
/*     */     } 
/* 120 */     this.fields = new LinkedHashMap<String, Class<?>>();
/* 121 */     this.fields.put(paramString2, paramClass1);
/* 122 */     this.fields.put(paramString3, paramClass2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AuxiliaryType of(MethodDescription paramMethodDescription) {
/* 132 */     if (paramMethodDescription.isConstructor()) {
/* 133 */       return paramMethodDescription.isPublic() ? FOR_PUBLIC_CONSTRUCTOR : FOR_DECLARED_CONSTRUCTOR;
/*     */     }
/*     */     
/* 136 */     if (paramMethodDescription.isMethod()) {
/* 137 */       return paramMethodDescription.isPublic() ? FOR_PUBLIC_METHOD : FOR_DECLARED_METHOD;
/*     */     }
/*     */ 
/*     */     
/* 141 */     throw new IllegalStateException("Cannot load constant for type initializer: " + paramMethodDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getSuffix() {
/* 149 */     return RandomString.hashOf(name().hashCode());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final DynamicType make(String paramString, ClassFileVersion paramClassFileVersion, MethodAccessorFactory paramMethodAccessorFactory) {
/* 158 */     Implementation.Composable composable = MethodCall.invoke((MethodDescription)DEFAULT_CONSTRUCTOR).andThen(FieldAccessor.ofField("type").setsArgumentAt(0));
/* 159 */     byte b = 1;
/* 160 */     for (String str : this.fields.keySet()) {
/* 161 */       composable = composable.andThen(FieldAccessor.ofField(str).setsArgumentAt(b++));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 175 */     DynamicType.Builder.FieldDefinition.Optional.Valuable valuable = (new ByteBuddy(paramClassFileVersion)).with(TypeValidation.DISABLED).subclass(PrivilegedExceptionAction.class, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS).name(paramString).modifiers(DEFAULT_TYPE_MODIFIER).defineConstructor(new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters(CompoundList.of(Class.class, new ArrayList(this.fields.values()))).intercept((Implementation)composable).method((ElementMatcher)ElementMatchers.named("run")).intercept((Implementation)MethodCall.invoke((MethodDescription)this.methodDescription).onField("type").withField((String[])this.fields.keySet().toArray((Object[])new String[0]))).defineField("type", Class.class, new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PRIVATE });
/* 176 */     for (Map.Entry<String, Class<?>> entry : this.fields.entrySet()) {
/* 177 */       valuable = valuable.defineField((String)entry.getKey(), (Type)entry.getValue(), new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PRIVATE });
/*     */     } 
/* 179 */     return (DynamicType)valuable.make();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\auxiliary\PrivilegedMemberLookupAction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */