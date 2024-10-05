/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import io.github.classgraph.ScanResult;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ClassFields
/*     */ {
/*  63 */   final List<FieldTypeInfo> fieldOrder = new ArrayList<>();
/*     */ 
/*     */   
/*  66 */   final Map<String, FieldTypeInfo> fieldNameToFieldTypeInfo = new HashMap<>();
/*     */ 
/*     */   
/*     */   Field idField;
/*     */ 
/*     */ 
/*     */   
/*  73 */   private static final Comparator<Field> FIELD_NAME_ORDER_COMPARATOR = new Comparator<Field>()
/*     */     {
/*     */       public final int compare(Field param1Field1, Field param1Field2)
/*     */       {
/*  77 */         return param1Field1.getName().compareTo(param1Field2.getName());
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   private static final Comparator<Field> SERIALIZATION_FORMAT_FIELD_NAME_ORDER_COMPARATOR = new Comparator<Field>()
/*     */     {
/*     */       public final int compare(Field param1Field1, Field param1Field2)
/*     */       {
/*  89 */         if (param1Field1.getName().equals("format")) return -1;  if (param1Field2
/*  90 */           .getName().equals("format")) return 1;  return param1Field1.getName().compareTo(param1Field2.getName());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  95 */   private static final String SERIALIZATION_FORMAT_CLASS_NAME = ScanResult.class.getName() + "$SerializationFormat";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassFields(Class<?> paramClass, boolean paramBoolean1, boolean paramBoolean2, ClassFieldCache paramClassFieldCache, ReflectionUtils paramReflectionUtils) {
/* 114 */     HashSet<String> hashSet = new HashSet();
/* 115 */     ArrayList<ArrayList<FieldTypeInfo>> arrayList = new ArrayList();
/* 116 */     TypeResolutions typeResolutions = null;
/* 117 */     for (Class<?> clazz = paramClass; clazz != Object.class && clazz != null; ) {
/*     */       ParameterizedType parameterizedType;
/*     */       Class clazz1;
/* 120 */       if (clazz instanceof ParameterizedType) {
/*     */         
/* 122 */         clazz1 = (Class)(parameterizedType = (ParameterizedType)clazz).getRawType();
/* 123 */       } else if (parameterizedType instanceof Class) {
/* 124 */         clazz1 = (Class)parameterizedType;
/*     */       } else {
/*     */         
/* 127 */         throw new IllegalArgumentException("Illegal class type: " + parameterizedType);
/*     */       } 
/*     */       
/*     */       Field[] arrayOfField;
/*     */       
/* 132 */       Arrays.sort(arrayOfField = clazz1.getDeclaredFields(), paramClass.getName().equals(SERIALIZATION_FORMAT_CLASS_NAME) ? SERIALIZATION_FORMAT_FIELD_NAME_ORDER_COMPARATOR : FIELD_NAME_ORDER_COMPARATOR);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       ArrayList<FieldTypeInfo> arrayList1 = new ArrayList(); int j; byte b;
/* 140 */       for (j = (arrayOfField = arrayOfField).length, b = 0; b < j; ) { Field field = arrayOfField[b];
/*     */         
/* 142 */         if (hashSet.add(field.getName())) {
/*     */           FieldTypeInfo fieldTypeInfo;
/*     */           boolean bool;
/* 145 */           if (bool = field.isAnnotationPresent((Class)Id.class)) {
/* 146 */             if (this.idField != null) {
/* 147 */               throw new IllegalArgumentException("More than one @Id annotation: " + this.idField
/* 148 */                   .getDeclaringClass() + "." + this.idField + " ; " + clazz1
/* 149 */                   .getName() + "." + field.getName());
/*     */             }
/* 151 */             this.idField = field;
/*     */           } 
/*     */           
/* 154 */           if (JSONUtils.fieldIsSerializable(field, paramBoolean2, paramReflectionUtils)) {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 159 */             Type type1 = field.getGenericType();
/*     */             
/* 161 */             type1 = (typeResolutions != null && paramBoolean1) ? typeResolutions.resolveTypeVariables(type1) : type1;
/*     */ 
/*     */ 
/*     */             
/* 165 */             fieldTypeInfo = new FieldTypeInfo(field, type1, paramClassFieldCache);
/*     */             
/* 167 */             this.fieldNameToFieldTypeInfo.put(field.getName(), fieldTypeInfo);
/* 168 */             arrayList1.add(fieldTypeInfo);
/*     */           }
/* 170 */           else if (fieldTypeInfo != null) {
/* 171 */             throw new IllegalArgumentException("@Id annotation field must be accessible, final, and non-transient: " + clazz1
/*     */                 
/* 173 */                 .getName() + "." + field.getName());
/*     */           } 
/*     */         } 
/*     */         b++; }
/*     */       
/* 178 */       arrayList.add(arrayList1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       Type type = clazz1.getGenericSuperclass();
/* 187 */       if (paramBoolean1) {
/* 188 */         if (type instanceof ParameterizedType) {
/*     */           Type type1;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 194 */           typeResolutions = (type1 = (typeResolutions == null) ? type : typeResolutions.resolveTypeVariables(type) instanceof ParameterizedType) ? new TypeResolutions((ParameterizedType)type1) : null;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 199 */           type = type1; continue;
/*     */         } 
/* 201 */         if (type instanceof Class) {
/*     */ 
/*     */           
/* 204 */           type = type;
/* 205 */           typeResolutions = null;
/*     */           continue;
/*     */         } 
/* 208 */         throw new IllegalArgumentException("Got unexpected supertype " + type);
/*     */       } 
/*     */ 
/*     */       
/* 212 */       type = type;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 217 */     for (int i = arrayList.size() - 1; i >= 0; i--) {
/* 218 */       List<? extends FieldTypeInfo> list = arrayList.get(i);
/* 219 */       this.fieldOrder.addAll(list);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\ClassFields.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */