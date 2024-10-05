/*      */ package net.bytebuddy.description.annotation;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.annotation.AnnotationTypeMismatchException;
/*      */ import java.lang.annotation.IncompleteAnnotationException;
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.Method;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*      */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface AnnotationValue<T, S>
/*      */ {
/*      */   @AlwaysNull
/*   55 */   public static final AnnotationValue<?, ?> UNDEFINED = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   State getState();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Sort getSort();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   AnnotationValue<T, S> filter(MethodDescription.InDefinedShape paramInDefinedShape);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   AnnotationValue<T, S> filter(MethodDescription.InDefinedShape paramInDefinedShape, TypeDefinition paramTypeDefinition);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   T resolve();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   <W> W resolve(Class<? extends W> paramClass);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Loaded<S> load(@MaybeNull ClassLoader paramClassLoader);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum RenderingDispatcher
/*      */   {
/*  120 */     LEGACY_VM('[', ']', true)
/*      */     {
/*      */       public final String toSourceString(char param2Char) {
/*  123 */         return Character.toString(param2Char);
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(long param2Long) {
/*  128 */         return Long.toString(param2Long);
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(float param2Float) {
/*  133 */         return Float.toString(param2Float);
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(double param2Double) {
/*  138 */         return Double.toString(param2Double);
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(String param2String) {
/*  143 */         return param2String;
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(TypeDescription param2TypeDescription) {
/*  148 */         return param2TypeDescription.toString();
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  155 */     JAVA_9_CAPABLE_VM('{', '}', true)
/*      */     {
/*      */       public final String toSourceString(char param2Char) {
/*  158 */         StringBuilder stringBuilder = new StringBuilder("'");
/*  159 */         if (param2Char == '\'') {
/*  160 */           stringBuilder.append("\\'");
/*      */         } else {
/*  162 */           stringBuilder.append(param2Char);
/*      */         } 
/*  164 */         return stringBuilder.append('\'').toString();
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(long param2Long) {
/*  169 */         if (Math.abs(param2Long) <= 2147483647L)
/*  170 */           return String.valueOf(param2Long);  return param2Long + "L";
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final String toSourceString(float param2Float) {
/*  176 */         if (Math.abs(param2Float) <= Float.MAX_VALUE) return param2Float + "f";
/*      */         
/*  178 */         if (Float.isInfinite(param2Float)) return (param2Float < 0.0F) ? "-1.0f/0.0f" : "1.0f/0.0f";  return "0.0f/0.0f";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(double param2Double) {
/*  183 */         if (Math.abs(param2Double) <= Double.MAX_VALUE)
/*  184 */           return Double.toString(param2Double); 
/*  185 */         if (Double.isInfinite(param2Double)) return (param2Double < 0.0D) ? "-1.0/0.0" : "1.0/0.0";  return "0.0/0.0";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(String param2String) {
/*  190 */         return "\"" + ((param2String.indexOf('"') == -1) ? param2String : param2String
/*      */           
/*  192 */           .replace("\"", "\\\"")) + "\"";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(TypeDescription param2TypeDescription) {
/*  197 */         return param2TypeDescription.getActualName() + ".class";
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  204 */     JAVA_14_CAPABLE_VM('{', '}', true)
/*      */     {
/*      */       public final String toSourceString(byte param2Byte) {
/*  207 */         return "(byte)0x" + Integer.toHexString(param2Byte & 0xFF);
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(char param2Char) {
/*  212 */         StringBuilder stringBuilder = new StringBuilder("'");
/*  213 */         if (param2Char == '\'') {
/*  214 */           stringBuilder.append("\\'");
/*      */         } else {
/*  216 */           stringBuilder.append(param2Char);
/*      */         } 
/*  218 */         return stringBuilder.append('\'').toString();
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(long param2Long) {
/*  223 */         return param2Long + "L";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(float param2Float) {
/*  228 */         if (Math.abs(param2Float) <= Float.MAX_VALUE) return param2Float + "f";
/*      */         
/*  230 */         if (Float.isInfinite(param2Float)) return (param2Float < 0.0F) ? "-1.0f/0.0f" : "1.0f/0.0f";  return "0.0f/0.0f";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(double param2Double) {
/*  235 */         if (Math.abs(param2Double) <= Double.MAX_VALUE)
/*  236 */           return Double.toString(param2Double); 
/*  237 */         if (Double.isInfinite(param2Double)) return (param2Double < 0.0D) ? "-1.0/0.0" : "1.0/0.0";  return "0.0/0.0";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(String param2String) {
/*  242 */         return "\"" + ((param2String.indexOf('"') == -1) ? param2String : param2String
/*      */           
/*  244 */           .replace("\"", "\\\"")) + "\"";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(TypeDescription param2TypeDescription) {
/*  249 */         return param2TypeDescription.getActualName() + ".class";
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  256 */     JAVA_17_CAPABLE_VM('{', '}', false)
/*      */     {
/*      */       public final String toSourceString(byte param2Byte) {
/*  259 */         return "(byte)0x" + Integer.toHexString(param2Byte & 0xFF);
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(char param2Char) {
/*  264 */         StringBuilder stringBuilder = new StringBuilder("'");
/*  265 */         if (param2Char == '\'') {
/*  266 */           stringBuilder.append("\\'");
/*      */         } else {
/*  268 */           stringBuilder.append(param2Char);
/*      */         } 
/*  270 */         return stringBuilder.append('\'').toString();
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(long param2Long) {
/*  275 */         return param2Long + "L";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(float param2Float) {
/*  280 */         if (Math.abs(param2Float) <= Float.MAX_VALUE) return param2Float + "f";
/*      */         
/*  282 */         if (Float.isInfinite(param2Float)) return (param2Float < 0.0F) ? "-1.0f/0.0f" : "1.0f/0.0f";  return "0.0f/0.0f";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(double param2Double) {
/*  287 */         if (Math.abs(param2Double) <= Double.MAX_VALUE)
/*  288 */           return Double.toString(param2Double); 
/*  289 */         if (Double.isInfinite(param2Double)) return (param2Double < 0.0D) ? "-1.0/0.0" : "1.0/0.0";  return "0.0/0.0";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(String param2String) {
/*  294 */         return "\"" + ((param2String.indexOf('"') == -1) ? param2String : param2String
/*      */           
/*  296 */           .replace("\"", "\\\"")) + "\"";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(TypeDescription param2TypeDescription) {
/*  301 */         return param2TypeDescription.getActualName() + ".class";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toTypeErrorString(Class<?> param2Class) {
/*  306 */         return param2Class.getName();
/*      */       }
/*      */     },
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  313 */     JAVA_19_CAPABLE_VM('{', '}', ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isLessThan(ClassFileVersion.JAVA_V17))
/*      */     {
/*      */       public final String toSourceString(byte param2Byte) {
/*  316 */         return "(byte)0x" + Integer.toHexString(param2Byte & 0xFF);
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(char param2Char) {
/*  321 */         StringBuilder stringBuilder = new StringBuilder("'");
/*  322 */         if (param2Char == '\'') {
/*  323 */           stringBuilder.append("\\'");
/*      */         } else {
/*  325 */           stringBuilder.append(param2Char);
/*      */         } 
/*  327 */         return stringBuilder.append('\'').toString();
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(long param2Long) {
/*  332 */         return param2Long + "L";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(float param2Float) {
/*  337 */         if (Math.abs(param2Float) <= Float.MAX_VALUE) return param2Float + "f";
/*      */         
/*  339 */         if (Float.isInfinite(param2Float)) return (param2Float < 0.0F) ? "-1.0f/0.0f" : "1.0f/0.0f";  return "0.0f/0.0f";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(double param2Double) {
/*  344 */         if (Math.abs(param2Double) <= Double.MAX_VALUE)
/*  345 */           return Double.toString(param2Double); 
/*  346 */         if (Double.isInfinite(param2Double)) return (param2Double < 0.0D) ? "-1.0/0.0" : "1.0/0.0";  return "0.0/0.0";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(String param2String) {
/*  351 */         return "\"" + ((param2String.indexOf('"') == -1) ? param2String : param2String
/*      */           
/*  353 */           .replace("\"", "\\\"")) + "\"";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toSourceString(TypeDescription param2TypeDescription) {
/*  358 */         return param2TypeDescription.getCanonicalName() + ".class";
/*      */       }
/*      */ 
/*      */       
/*      */       public final String toTypeErrorString(Class<?> param2Class) {
/*  363 */         return param2Class.getName();
/*      */       }
/*      */     };
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
/*      */     private static final String ARRAY_PREFIX = "Array with component tag: ";
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
/*  391 */     public static final RenderingDispatcher CURRENT = LEGACY_VM;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final char openingBrace;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final char closingBrace;
/*      */ 
/*      */ 
/*      */     
/*      */     private final boolean componentAsInteger;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static {
/*      */     
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     RenderingDispatcher(char param1Char1, char param1Char2, boolean param1Boolean) {
/*  418 */       this.openingBrace = param1Char1;
/*  419 */       this.closingBrace = param1Char2;
/*  420 */       this.componentAsInteger = param1Boolean;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toSourceString(boolean param1Boolean) {
/*  430 */       return Boolean.toString(param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toSourceString(byte param1Byte) {
/*  440 */       return Byte.toString(param1Byte);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toSourceString(short param1Short) {
/*  450 */       return Short.toString(param1Short);
/*      */     }
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
/*      */     public String toSourceString(int param1Int) {
/*  468 */       return Integer.toString(param1Int);
/*      */     }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toSourceString(List<?> param1List) {
/*  518 */       StringBuilder stringBuilder = (new StringBuilder()).append(this.openingBrace);
/*  519 */       boolean bool = true;
/*  520 */       for (Object object : param1List) {
/*  521 */         if (bool) {
/*  522 */           bool = false;
/*      */         } else {
/*  524 */           stringBuilder.append(", ");
/*      */         } 
/*  526 */         stringBuilder.append(object);
/*      */       } 
/*  528 */       return stringBuilder.append(this.closingBrace).toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toArrayErrorString(AnnotationValue.Sort param1Sort) {
/*  538 */       return "Array with component tag: " + ((this.componentAsInteger || !param1Sort.isDefined()) ? 
/*  539 */         Integer.toString(param1Sort.getTag()) : 
/*  540 */         Character.toString((char)param1Sort.getTag()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toTypeErrorString(Class<?> param1Class) {
/*  550 */       return param1Class.toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public abstract String toSourceString(char param1Char);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public abstract String toSourceString(long param1Long);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public abstract String toSourceString(float param1Float);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public abstract String toSourceString(double param1Double);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public abstract String toSourceString(String param1String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public abstract String toSourceString(TypeDescription param1TypeDescription);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Loaded<U>
/*      */   {
/*      */     AnnotationValue.State getState();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     U resolve();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     <V> V resolve(Class<? extends V> param1Class);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean represents(Object param1Object);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static abstract class AbstractBase<W>
/*      */       implements Loaded<W>
/*      */     {
/*      */       public <X> X resolve(Class<? extends X> param2Class) {
/*  621 */         return param2Class.cast(resolve());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static abstract class ForUnresolvedProperty<Z>
/*      */         extends AbstractBase<Z>
/*      */       {
/*      */         public AnnotationValue.State getState() {
/*  635 */           return AnnotationValue.State.UNRESOLVED;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean represents(Object param3Object) {
/*  642 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum State
/*      */   {
/*  657 */     UNDEFINED,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  663 */     UNRESOLVED,
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  668 */     RESOLVED;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean isDefined() {
/*  677 */       return (this != UNDEFINED);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean isResolved() {
/*  687 */       return (this == RESOLVED);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum Sort
/*      */   {
/*  699 */     BOOLEAN(90),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  704 */     BYTE(66),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  709 */     SHORT(83),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  714 */     CHARACTER(67),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  719 */     INTEGER(73),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  724 */     LONG(74),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  729 */     FLOAT(70),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  734 */     DOUBLE(68),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  739 */     STRING(115),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  744 */     TYPE(99),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  749 */     ENUMERATION(101),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  754 */     ANNOTATION(64),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  759 */     ARRAY(91),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  764 */     NONE(0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int tag;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Sort(int param1Int1) {
/*  777 */       this.tag = param1Int1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Sort of(TypeDefinition param1TypeDefinition) {
/*  787 */       if (param1TypeDefinition.represents(boolean.class))
/*  788 */         return BOOLEAN; 
/*  789 */       if (param1TypeDefinition.represents(byte.class))
/*  790 */         return BYTE; 
/*  791 */       if (param1TypeDefinition.represents(short.class))
/*  792 */         return SHORT; 
/*  793 */       if (param1TypeDefinition.represents(char.class))
/*  794 */         return CHARACTER; 
/*  795 */       if (param1TypeDefinition.represents(int.class))
/*  796 */         return INTEGER; 
/*  797 */       if (param1TypeDefinition.represents(long.class))
/*  798 */         return LONG; 
/*  799 */       if (param1TypeDefinition.represents(float.class))
/*  800 */         return FLOAT; 
/*  801 */       if (param1TypeDefinition.represents(double.class))
/*  802 */         return DOUBLE; 
/*  803 */       if (param1TypeDefinition.represents(String.class))
/*  804 */         return STRING; 
/*  805 */       if (param1TypeDefinition.represents(Class.class))
/*  806 */         return TYPE; 
/*  807 */       if (param1TypeDefinition.isEnum())
/*  808 */         return ENUMERATION; 
/*  809 */       if (param1TypeDefinition.isAnnotation())
/*  810 */         return ANNOTATION; 
/*  811 */       if (param1TypeDefinition.isArray()) {
/*  812 */         return ARRAY;
/*      */       }
/*  814 */       return NONE;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected final int getTag() {
/*  824 */       return this.tag;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean isDefined() {
/*  833 */       return (this != NONE);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class AbstractBase<U, V>
/*      */     implements AnnotationValue<U, V>
/*      */   {
/*      */     public <W> W resolve(Class<? extends W> param1Class) {
/*  849 */       return param1Class.cast(resolve());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape param1InDefinedShape) {
/*  856 */       return filter(param1InDefinedShape, (TypeDefinition)param1InDefinedShape.getReturnType());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForConstant<U>
/*      */     extends AbstractBase<U, U>
/*      */   {
/*      */     private final U value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final PropertyDelegate propertyDelegate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ForConstant(U param1U, PropertyDelegate param1PropertyDelegate) {
/*  884 */       this.value = param1U;
/*  885 */       this.propertyDelegate = param1PropertyDelegate;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<Boolean, Boolean> of(boolean param1Boolean) {
/*  895 */       return new ForConstant<Boolean>(Boolean.valueOf(param1Boolean), PropertyDelegate.ForNonArrayType.BOOLEAN);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<Byte, Byte> of(byte param1Byte) {
/*  905 */       return new ForConstant<Byte>(Byte.valueOf(param1Byte), PropertyDelegate.ForNonArrayType.BYTE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<Short, Short> of(short param1Short) {
/*  915 */       return new ForConstant<Short>(Short.valueOf(param1Short), PropertyDelegate.ForNonArrayType.SHORT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<Character, Character> of(char param1Char) {
/*  925 */       return new ForConstant<Character>(Character.valueOf(param1Char), PropertyDelegate.ForNonArrayType.CHARACTER);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<Integer, Integer> of(int param1Int) {
/*  935 */       return new ForConstant<Integer>(Integer.valueOf(param1Int), PropertyDelegate.ForNonArrayType.INTEGER);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<Long, Long> of(long param1Long) {
/*  945 */       return new ForConstant<Long>(Long.valueOf(param1Long), PropertyDelegate.ForNonArrayType.LONG);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<Float, Float> of(float param1Float) {
/*  955 */       return new ForConstant<Float>(Float.valueOf(param1Float), PropertyDelegate.ForNonArrayType.FLOAT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<Double, Double> of(double param1Double) {
/*  965 */       return new ForConstant<Double>(Double.valueOf(param1Double), PropertyDelegate.ForNonArrayType.DOUBLE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<String, String> of(String param1String) {
/*  975 */       return new ForConstant<String>(param1String, PropertyDelegate.ForNonArrayType.STRING);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<boolean[], boolean[]> of(boolean... param1VarArgs) {
/*  985 */       return (AnnotationValue)new ForConstant<boolean>(param1VarArgs, PropertyDelegate.ForArrayType.BOOLEAN);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<byte[], byte[]> of(byte... param1VarArgs) {
/*  995 */       return (AnnotationValue)new ForConstant<byte>(param1VarArgs, PropertyDelegate.ForArrayType.BYTE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<short[], short[]> of(short... param1VarArgs) {
/* 1005 */       return (AnnotationValue)new ForConstant<short>(param1VarArgs, PropertyDelegate.ForArrayType.SHORT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<char[], char[]> of(char... param1VarArgs) {
/* 1015 */       return (AnnotationValue)new ForConstant<char>(param1VarArgs, PropertyDelegate.ForArrayType.CHARACTER);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<int[], int[]> of(int... param1VarArgs) {
/* 1025 */       return (AnnotationValue)new ForConstant<int>(param1VarArgs, PropertyDelegate.ForArrayType.INTEGER);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<long[], long[]> of(long... param1VarArgs) {
/* 1035 */       return (AnnotationValue)new ForConstant<long>(param1VarArgs, PropertyDelegate.ForArrayType.LONG);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<float[], float[]> of(float... param1VarArgs) {
/* 1045 */       return (AnnotationValue)new ForConstant<float>(param1VarArgs, PropertyDelegate.ForArrayType.FLOAT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<double[], double[]> of(double... param1VarArgs) {
/* 1055 */       return (AnnotationValue)new ForConstant<double>(param1VarArgs, PropertyDelegate.ForArrayType.DOUBLE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<String[], String[]> of(String... param1VarArgs) {
/* 1065 */       return (AnnotationValue)new ForConstant<String>(param1VarArgs, PropertyDelegate.ForArrayType.STRING);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<?, ?> of(Object param1Object) {
/* 1077 */       if (param1Object instanceof Boolean)
/* 1078 */         return of(((Boolean)param1Object).booleanValue()); 
/* 1079 */       if (param1Object instanceof Byte)
/* 1080 */         return of(((Byte)param1Object).byteValue()); 
/* 1081 */       if (param1Object instanceof Short)
/* 1082 */         return of(((Short)param1Object).shortValue()); 
/* 1083 */       if (param1Object instanceof Character)
/* 1084 */         return of(((Character)param1Object).charValue()); 
/* 1085 */       if (param1Object instanceof Integer)
/* 1086 */         return of(((Integer)param1Object).intValue()); 
/* 1087 */       if (param1Object instanceof Long)
/* 1088 */         return of(((Long)param1Object).longValue()); 
/* 1089 */       if (param1Object instanceof Float)
/* 1090 */         return of(((Float)param1Object).floatValue()); 
/* 1091 */       if (param1Object instanceof Double)
/* 1092 */         return of(((Double)param1Object).doubleValue()); 
/* 1093 */       if (param1Object instanceof String)
/* 1094 */         return of((String)param1Object); 
/* 1095 */       if (param1Object instanceof boolean[])
/* 1096 */         return of((boolean[])param1Object); 
/* 1097 */       if (param1Object instanceof byte[])
/* 1098 */         return of((byte[])param1Object); 
/* 1099 */       if (param1Object instanceof short[])
/* 1100 */         return of((short[])param1Object); 
/* 1101 */       if (param1Object instanceof char[])
/* 1102 */         return of((char[])param1Object); 
/* 1103 */       if (param1Object instanceof int[])
/* 1104 */         return of((int[])param1Object); 
/* 1105 */       if (param1Object instanceof long[])
/* 1106 */         return of((long[])param1Object); 
/* 1107 */       if (param1Object instanceof float[])
/* 1108 */         return of((float[])param1Object); 
/* 1109 */       if (param1Object instanceof double[])
/* 1110 */         return of((double[])param1Object); 
/* 1111 */       if (param1Object instanceof String[]) {
/* 1112 */         return of((String[])param1Object);
/*      */       }
/* 1114 */       throw new IllegalArgumentException("Not a constant annotation value: " + param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.State getState() {
/* 1122 */       return AnnotationValue.State.RESOLVED;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Sort getSort() {
/* 1129 */       return AnnotationValue.Sort.of((TypeDefinition)TypeDescription.ForLoadedType.of(this.value.getClass()).asUnboxed());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<U, U> filter(MethodDescription.InDefinedShape param1InDefinedShape, TypeDefinition param1TypeDefinition) {
/* 1136 */       if (param1TypeDefinition.asErasure().asBoxed().represents(this.value.getClass()))
/* 1137 */         return this; 
/* 1138 */       if (this.value.getClass().isArray())
/* 1139 */         return new AnnotationValue.ForMismatchedType<U, U>(param1InDefinedShape, AnnotationValue.RenderingDispatcher.CURRENT.toArrayErrorString(AnnotationValue.Sort.of((TypeDefinition)TypeDescription.ForLoadedType.of(this.value.getClass().getComponentType())))); 
/* 1140 */       if (this.value instanceof Enum) {
/* 1141 */         return new AnnotationValue.ForMismatchedType<U, U>(param1InDefinedShape, this.value.getClass().getName() + '.' + ((Enum)this.value).name());
/*      */       }
/* 1143 */       return new AnnotationValue.ForMismatchedType<U, U>(param1InDefinedShape, AnnotationValue.RenderingDispatcher.CURRENT.toTypeErrorString(this.value.getClass()) + '[' + this.value + ']');
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public U resolve() {
/* 1151 */       return this.value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Loaded<U> load(@MaybeNull ClassLoader param1ClassLoader) {
/* 1158 */       return new Loaded<U>(this.value, this.propertyDelegate);
/*      */     } @Enhance("hashCode")
/*      */     public int hashCode() {
/*      */       ForConstant forConstant;
/*      */       int i;
/*      */       int j;
/* 1164 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (forConstant = this).propertyDelegate.hashCode(forConstant.value))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/* 1169 */       return (this == param1Object || (param1Object instanceof AnnotationValue && this.propertyDelegate.equals(this.value, ((AnnotationValue)param1Object).resolve())));
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1174 */       return this.propertyDelegate.toString(this.value);
/*      */     }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum ForNonArrayType
/*      */       implements PropertyDelegate
/*      */     {
/* 1224 */       BOOLEAN
/*      */       {
/*      */         public final String toString(Object param4Object) {
/* 1227 */           return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Boolean)param4Object).booleanValue());
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1234 */       BYTE
/*      */       {
/*      */         public final String toString(Object param4Object) {
/* 1237 */           return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Byte)param4Object).byteValue());
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1244 */       SHORT
/*      */       {
/*      */         public final String toString(Object param4Object) {
/* 1247 */           return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Short)param4Object).shortValue());
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1254 */       CHARACTER
/*      */       {
/*      */         public final String toString(Object param4Object) {
/* 1257 */           return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Character)param4Object).charValue());
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1264 */       INTEGER
/*      */       {
/*      */         public final String toString(Object param4Object) {
/* 1267 */           return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Integer)param4Object).intValue());
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1274 */       LONG
/*      */       {
/*      */         public final String toString(Object param4Object) {
/* 1277 */           return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Long)param4Object).longValue());
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1284 */       FLOAT
/*      */       {
/*      */         public final String toString(Object param4Object) {
/* 1287 */           return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Float)param4Object).floatValue());
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1294 */       DOUBLE
/*      */       {
/*      */         public final String toString(Object param4Object) {
/* 1297 */           return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Double)param4Object).doubleValue());
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1304 */       STRING
/*      */       {
/*      */         public final String toString(Object param4Object) {
/* 1307 */           return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString((String)param4Object);
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public <S> S copy(S param2S) {
/* 1315 */         return param2S;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode(Object param2Object) {
/* 1322 */         return param2Object.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(Object param2Object1, Object param2Object2)
/*      */       {
/* 1329 */         return param2Object1.equals(param2Object2); } } protected static interface PropertyDelegate { <S> S copy(S param2S); int hashCode(Object param2Object); boolean equals(Object param2Object1, Object param2Object2); String toString(Object param2Object); public enum ForNonArrayType implements PropertyDelegate { BOOLEAN { public final String toString(Object param4Object) { return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Boolean)param4Object).booleanValue()); } }, BYTE { public final String toString(Object param4Object) { return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Byte)param4Object).byteValue()); } }, SHORT { public final String toString(Object param4Object) { return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Short)param4Object).shortValue()); } }, CHARACTER { public final String toString(Object param4Object) { return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Character)param4Object).charValue()); } }, INTEGER { public final String toString(Object param4Object) { return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Integer)param4Object).intValue()); } }, LONG { public final String toString(Object param4Object) { return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Long)param4Object).longValue()); } }, FLOAT { public final String toString(Object param4Object) { return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Float)param4Object).floatValue()); } }, DOUBLE { public final String toString(Object param4Object) { return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(((Double)param4Object).doubleValue()); } }, STRING { public final String toString(Object param4Object) { return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString((String)param4Object); } }; public <S> S copy(S param3S) { return param3S; } public int hashCode(Object param3Object) { return param3Object.hashCode(); } public boolean equals(Object param3Object1, Object param3Object2) { return param3Object1.equals(param3Object2); }
/*      */          }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum ForArrayType
/*      */         implements PropertyDelegate
/*      */       {
/* 1341 */         BOOLEAN
/*      */         {
/*      */           protected final Object doCopy(Object param4Object) {
/* 1344 */             return ((boolean[])param4Object).clone();
/*      */           }
/*      */ 
/*      */           
/*      */           public final int hashCode(Object param4Object) {
/* 1349 */             return Arrays.hashCode((boolean[])param4Object);
/*      */           }
/*      */ 
/*      */           
/*      */           public final boolean equals(Object param4Object1, Object param4Object2) {
/* 1354 */             return (param4Object2 instanceof boolean[] && Arrays.equals((boolean[])param4Object1, (boolean[])param4Object2));
/*      */           }
/*      */ 
/*      */           
/*      */           protected final String toString(Object param4Object, int param4Int) {
/* 1359 */             return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.BOOLEAN.toString(Boolean.valueOf(Array.getBoolean(param4Object, param4Int)));
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1366 */         BYTE
/*      */         {
/*      */           protected final Object doCopy(Object param4Object) {
/* 1369 */             return ((byte[])param4Object).clone();
/*      */           }
/*      */ 
/*      */           
/*      */           public final int hashCode(Object param4Object) {
/* 1374 */             return Arrays.hashCode((byte[])param4Object);
/*      */           }
/*      */ 
/*      */           
/*      */           public final boolean equals(Object param4Object1, Object param4Object2) {
/* 1379 */             return (param4Object2 instanceof byte[] && Arrays.equals((byte[])param4Object1, (byte[])param4Object2));
/*      */           }
/*      */ 
/*      */           
/*      */           protected final String toString(Object param4Object, int param4Int) {
/* 1384 */             return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.BYTE.toString(Byte.valueOf(Array.getByte(param4Object, param4Int)));
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1391 */         SHORT
/*      */         {
/*      */           protected final Object doCopy(Object param4Object) {
/* 1394 */             return ((short[])param4Object).clone();
/*      */           }
/*      */ 
/*      */           
/*      */           public final int hashCode(Object param4Object) {
/* 1399 */             return Arrays.hashCode((short[])param4Object);
/*      */           }
/*      */ 
/*      */           
/*      */           public final boolean equals(Object param4Object1, Object param4Object2) {
/* 1404 */             return (param4Object2 instanceof short[] && Arrays.equals((short[])param4Object1, (short[])param4Object2));
/*      */           }
/*      */ 
/*      */           
/*      */           protected final String toString(Object param4Object, int param4Int) {
/* 1409 */             return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.SHORT.toString(Short.valueOf(Array.getShort(param4Object, param4Int)));
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1416 */         CHARACTER
/*      */         {
/*      */           protected final Object doCopy(Object param4Object) {
/* 1419 */             return ((char[])param4Object).clone();
/*      */           }
/*      */ 
/*      */           
/*      */           public final int hashCode(Object param4Object) {
/* 1424 */             return Arrays.hashCode((char[])param4Object);
/*      */           }
/*      */ 
/*      */           
/*      */           public final boolean equals(Object param4Object1, Object param4Object2) {
/* 1429 */             return (param4Object2 instanceof char[] && Arrays.equals((char[])param4Object1, (char[])param4Object2));
/*      */           }
/*      */ 
/*      */           
/*      */           protected final String toString(Object param4Object, int param4Int) {
/* 1434 */             return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.CHARACTER.toString(Character.valueOf(Array.getChar(param4Object, param4Int)));
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1441 */         INTEGER
/*      */         {
/*      */           protected final Object doCopy(Object param4Object) {
/* 1444 */             return ((int[])param4Object).clone();
/*      */           }
/*      */ 
/*      */           
/*      */           public final int hashCode(Object param4Object) {
/* 1449 */             return Arrays.hashCode((int[])param4Object);
/*      */           }
/*      */ 
/*      */           
/*      */           public final boolean equals(Object param4Object1, Object param4Object2) {
/* 1454 */             return (param4Object2 instanceof int[] && Arrays.equals((int[])param4Object1, (int[])param4Object2));
/*      */           }
/*      */ 
/*      */           
/*      */           protected final String toString(Object param4Object, int param4Int) {
/* 1459 */             return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.INTEGER.toString(Integer.valueOf(Array.getInt(param4Object, param4Int)));
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1466 */         LONG
/*      */         {
/*      */           protected final Object doCopy(Object param4Object) {
/* 1469 */             return ((long[])param4Object).clone();
/*      */           }
/*      */ 
/*      */           
/*      */           public final int hashCode(Object param4Object) {
/* 1474 */             return Arrays.hashCode((long[])param4Object);
/*      */           }
/*      */ 
/*      */           
/*      */           public final boolean equals(Object param4Object1, Object param4Object2) {
/* 1479 */             return (param4Object2 instanceof long[] && Arrays.equals((long[])param4Object1, (long[])param4Object2));
/*      */           }
/*      */ 
/*      */           
/*      */           protected final String toString(Object param4Object, int param4Int) {
/* 1484 */             return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.LONG.toString(Long.valueOf(Array.getLong(param4Object, param4Int)));
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1491 */         FLOAT
/*      */         {
/*      */           protected final Object doCopy(Object param4Object) {
/* 1494 */             return ((float[])param4Object).clone();
/*      */           }
/*      */ 
/*      */           
/*      */           public final int hashCode(Object param4Object) {
/* 1499 */             return Arrays.hashCode((float[])param4Object);
/*      */           }
/*      */ 
/*      */           
/*      */           public final boolean equals(Object param4Object1, Object param4Object2) {
/* 1504 */             return (param4Object2 instanceof float[] && Arrays.equals((float[])param4Object1, (float[])param4Object2));
/*      */           }
/*      */ 
/*      */           
/*      */           protected final String toString(Object param4Object, int param4Int) {
/* 1509 */             return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.FLOAT.toString(Float.valueOf(Array.getFloat(param4Object, param4Int)));
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1516 */         DOUBLE
/*      */         {
/*      */           protected final Object doCopy(Object param4Object) {
/* 1519 */             return ((double[])param4Object).clone();
/*      */           }
/*      */ 
/*      */           
/*      */           public final int hashCode(Object param4Object) {
/* 1524 */             return Arrays.hashCode((double[])param4Object);
/*      */           }
/*      */ 
/*      */           
/*      */           public final boolean equals(Object param4Object1, Object param4Object2) {
/* 1529 */             return (param4Object2 instanceof double[] && Arrays.equals((double[])param4Object1, (double[])param4Object2));
/*      */           }
/*      */ 
/*      */           
/*      */           protected final String toString(Object param4Object, int param4Int) {
/* 1534 */             return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.DOUBLE.toString(Double.valueOf(Array.getDouble(param4Object, param4Int)));
/*      */           }
/*      */         },
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1541 */         STRING
/*      */         {
/*      */           protected final Object doCopy(Object param4Object) {
/* 1544 */             return ((String[])param4Object).clone();
/*      */           }
/*      */ 
/*      */           
/*      */           public final int hashCode(Object param4Object) {
/* 1549 */             return Arrays.hashCode((Object[])param4Object);
/*      */           }
/*      */ 
/*      */           
/*      */           public final boolean equals(Object param4Object1, Object param4Object2) {
/* 1554 */             return (param4Object2 instanceof String[] && Arrays.equals((Object[])param4Object1, (Object[])param4Object2));
/*      */           }
/*      */ 
/*      */           
/*      */           protected final String toString(Object param4Object, int param4Int) {
/* 1559 */             return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.STRING.toString(Array.get(param4Object, param4Int));
/*      */           }
/*      */         };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public <S> S copy(S param3S) {
/* 1568 */           return (S)doCopy(param3S);
/*      */         }
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
/*      */         public String toString(Object param3Object)
/*      */         {
/* 1583 */           ArrayList<String> arrayList = new ArrayList(Array.getLength(param3Object));
/* 1584 */           for (byte b = 0; b < Array.getLength(param3Object); b++) {
/* 1585 */             arrayList.add(toString(param3Object, b));
/*      */           }
/* 1587 */           return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(arrayList); } protected abstract Object doCopy(Object param3Object); protected abstract String toString(Object param3Object, int param3Int); } } public enum ForArrayType implements PropertyDelegate { BOOLEAN { protected final Object doCopy(Object param4Object) { return ((boolean[])param4Object).clone(); } public final int hashCode(Object param4Object) { return Arrays.hashCode((boolean[])param4Object); } public final boolean equals(Object param4Object1, Object param4Object2) { return (param4Object2 instanceof boolean[] && Arrays.equals((boolean[])param4Object1, (boolean[])param4Object2)); } protected final String toString(Object param4Object, int param4Int) { return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.BOOLEAN.toString(Boolean.valueOf(Array.getBoolean(param4Object, param4Int))); } }, BYTE { protected final Object doCopy(Object param4Object) { return ((byte[])param4Object).clone(); } public final int hashCode(Object param4Object) { return Arrays.hashCode((byte[])param4Object); } public final boolean equals(Object param4Object1, Object param4Object2) { return (param4Object2 instanceof byte[] && Arrays.equals((byte[])param4Object1, (byte[])param4Object2)); } protected final String toString(Object param4Object, int param4Int) { return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.BYTE.toString(Byte.valueOf(Array.getByte(param4Object, param4Int))); } }, SHORT { protected final Object doCopy(Object param4Object) { return ((short[])param4Object).clone(); } public final int hashCode(Object param4Object) { return Arrays.hashCode((short[])param4Object); } public final boolean equals(Object param4Object1, Object param4Object2) { return (param4Object2 instanceof short[] && Arrays.equals((short[])param4Object1, (short[])param4Object2)); } protected final String toString(Object param4Object, int param4Int) { return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.SHORT.toString(Short.valueOf(Array.getShort(param4Object, param4Int))); } }, CHARACTER { protected final Object doCopy(Object param4Object) { return ((char[])param4Object).clone(); } public final int hashCode(Object param4Object) { return Arrays.hashCode((char[])param4Object); } public final boolean equals(Object param4Object1, Object param4Object2) { return (param4Object2 instanceof char[] && Arrays.equals((char[])param4Object1, (char[])param4Object2)); } protected final String toString(Object param4Object, int param4Int) { return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.CHARACTER.toString(Character.valueOf(Array.getChar(param4Object, param4Int))); } }, INTEGER { protected final Object doCopy(Object param4Object) { return ((int[])param4Object).clone(); } public final int hashCode(Object param4Object) { return Arrays.hashCode((int[])param4Object); } public final boolean equals(Object param4Object1, Object param4Object2) { return (param4Object2 instanceof int[] && Arrays.equals((int[])param4Object1, (int[])param4Object2)); } protected final String toString(Object param4Object, int param4Int) { return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.INTEGER.toString(Integer.valueOf(Array.getInt(param4Object, param4Int))); } }, LONG { protected final Object doCopy(Object param4Object) { return ((long[])param4Object).clone(); } public final int hashCode(Object param4Object) { return Arrays.hashCode((long[])param4Object); } public final boolean equals(Object param4Object1, Object param4Object2) { return (param4Object2 instanceof long[] && Arrays.equals((long[])param4Object1, (long[])param4Object2)); } protected final String toString(Object param4Object, int param4Int) { return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.LONG.toString(Long.valueOf(Array.getLong(param4Object, param4Int))); } }, FLOAT { protected final Object doCopy(Object param4Object) { return ((float[])param4Object).clone(); } public final int hashCode(Object param4Object) { return Arrays.hashCode((float[])param4Object); } public final boolean equals(Object param4Object1, Object param4Object2) { return (param4Object2 instanceof float[] && Arrays.equals((float[])param4Object1, (float[])param4Object2)); } protected final String toString(Object param4Object, int param4Int) { return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.FLOAT.toString(Float.valueOf(Array.getFloat(param4Object, param4Int))); } }, DOUBLE { protected final Object doCopy(Object param4Object) { return ((double[])param4Object).clone(); } public final int hashCode(Object param4Object) { return Arrays.hashCode((double[])param4Object); } public final boolean equals(Object param4Object1, Object param4Object2) { return (param4Object2 instanceof double[] && Arrays.equals((double[])param4Object1, (double[])param4Object2)); } protected final String toString(Object param4Object, int param4Int) { return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.DOUBLE.toString(Double.valueOf(Array.getDouble(param4Object, param4Int))); } }, STRING { protected final Object doCopy(Object param4Object) { return ((String[])param4Object).clone(); } public final int hashCode(Object param4Object) { return Arrays.hashCode((Object[])param4Object); } public final boolean equals(Object param4Object1, Object param4Object2) { return (param4Object2 instanceof String[] && Arrays.equals((Object[])param4Object1, (Object[])param4Object2)); } protected final String toString(Object param4Object, int param4Int) { return AnnotationValue.ForConstant.PropertyDelegate.ForNonArrayType.STRING.toString(Array.get(param4Object, param4Int)); } }; public <S> S copy(S param2S) { return (S)doCopy(param2S); } public String toString(Object param2Object) { ArrayList<String> arrayList = new ArrayList(Array.getLength(param2Object)); for (byte b = 0; b < Array.getLength(param2Object); b++) arrayList.add(toString(param2Object, b));  return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(arrayList); }
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
/*      */       protected abstract Object doCopy(Object param2Object);
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
/*      */       protected abstract String toString(Object param2Object, int param2Int); }
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
/*      */     protected static class Loaded<V>
/*      */       extends AnnotationValue.Loaded.AbstractBase<V>
/*      */     {
/*      */       protected Loaded(V param2V, AnnotationValue.ForConstant.PropertyDelegate param2PropertyDelegate) {
/* 1625 */         this.value = param2V;
/* 1626 */         this.propertyDelegate = param2PropertyDelegate;
/*      */       }
/*      */       
/*      */       private final V value;
/*      */       private final AnnotationValue.ForConstant.PropertyDelegate propertyDelegate;
/*      */       
/*      */       public AnnotationValue.State getState() {
/* 1633 */         return AnnotationValue.State.RESOLVED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public V resolve() {
/* 1640 */         return this.propertyDelegate.copy(this.value);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean represents(Object param2Object) {
/* 1647 */         return this.propertyDelegate.equals(this.value, param2Object);
/*      */       } @Enhance("hashCode")
/*      */       public int hashCode() {
/*      */         Loaded loaded;
/*      */         int j;
/*      */         int i;
/* 1653 */         if (!(i = ((j = this.hashCode) != 0) ? 0 : (loaded = this).propertyDelegate.hashCode(loaded.value))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/* 1658 */         if (this == param2Object)
/* 1659 */           return true; 
/* 1660 */         if (!(param2Object instanceof AnnotationValue.Loaded)) {
/* 1661 */           return false;
/*      */         }
/*      */         
/* 1664 */         if ((param2Object = param2Object).getState().isResolved() && this.propertyDelegate.equals(this.value, param2Object.resolve())) return true;  return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public String toString() {
/* 1669 */         return this.propertyDelegate.toString(this.value);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForAnnotationDescription<U extends Annotation>
/*      */     extends AbstractBase<AnnotationDescription, U>
/*      */   {
/*      */     private final AnnotationDescription annotationDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForAnnotationDescription(AnnotationDescription param1AnnotationDescription) {
/* 1692 */       this.annotationDescription = param1AnnotationDescription;
/*      */     }
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
/*      */     public static <V extends Annotation> AnnotationValue<AnnotationDescription, V> of(TypeDescription param1TypeDescription, Map<String, ? extends AnnotationValue<?, ?>> param1Map) {
/* 1705 */       return new ForAnnotationDescription<V>(new AnnotationDescription.Latent(param1TypeDescription, param1Map));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.State getState() {
/* 1712 */       return AnnotationValue.State.RESOLVED;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Sort getSort() {
/* 1719 */       return AnnotationValue.Sort.ANNOTATION;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<AnnotationDescription, U> filter(MethodDescription.InDefinedShape param1InDefinedShape, TypeDefinition param1TypeDefinition) {
/* 1726 */       return (AnnotationValue<AnnotationDescription, U>)(param1TypeDefinition.asErasure().equals(this.annotationDescription.getAnnotationType()) ? this : new AnnotationValue.ForMismatchedType<AnnotationDescription, U>(param1InDefinedShape, param1InDefinedShape.getReturnType().isArray() ? AnnotationValue.RenderingDispatcher.CURRENT
/* 1727 */           .toArrayErrorString(AnnotationValue.Sort.ANNOTATION) : this.annotationDescription
/* 1728 */           .toString()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationDescription resolve() {
/* 1735 */       return this.annotationDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Loaded<U> load(@MaybeNull ClassLoader param1ClassLoader) {
/*      */       try {
/* 1744 */         return new Loaded<U>(this.annotationDescription
/* 1745 */             .<U>prepare((Class)Class.forName(this.annotationDescription.getAnnotationType().getName(), false, param1ClassLoader))
/* 1746 */             .load());
/* 1747 */       } catch (ClassNotFoundException classNotFoundException) {
/* 1748 */         return new AnnotationValue.ForMissingType.Loaded<U>(this.annotationDescription.getAnnotationType().getName(), classNotFoundException);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1754 */       return this.annotationDescription.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/* 1759 */       return (this == param1Object || (param1Object instanceof AnnotationValue && this.annotationDescription.equals(((AnnotationValue)param1Object).resolve())));
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1764 */       return this.annotationDescription.toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Loaded<V extends Annotation>
/*      */       extends AnnotationValue.Loaded.AbstractBase<V>
/*      */     {
/*      */       private final V annotation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Loaded(V param2V) {
/* 1785 */         this.annotation = param2V;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationValue.State getState() {
/* 1792 */         return AnnotationValue.State.RESOLVED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public V resolve() {
/* 1799 */         return this.annotation;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean represents(Object param2Object) {
/* 1806 */         return this.annotation.equals(param2Object);
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/* 1811 */         return this.annotation.hashCode();
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/* 1816 */         if (this == param2Object)
/* 1817 */           return true; 
/* 1818 */         if (!(param2Object instanceof AnnotationValue.Loaded)) {
/* 1819 */           return false;
/*      */         }
/*      */         
/* 1822 */         if ((param2Object = param2Object).getState().isResolved() && this.annotation.equals(param2Object.resolve())) return true;  return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public String toString() {
/* 1827 */         return this.annotation.toString();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForEnumerationDescription<U extends Enum<U>>
/*      */     extends AbstractBase<EnumerationDescription, U>
/*      */   {
/*      */     private final EnumerationDescription enumerationDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForEnumerationDescription(EnumerationDescription param1EnumerationDescription) {
/* 1850 */       this.enumerationDescription = param1EnumerationDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static <V extends Enum<V>> AnnotationValue<EnumerationDescription, V> of(EnumerationDescription param1EnumerationDescription) {
/* 1861 */       return new ForEnumerationDescription<V>(param1EnumerationDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public EnumerationDescription resolve() {
/* 1868 */       return this.enumerationDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.State getState() {
/* 1875 */       return AnnotationValue.State.RESOLVED;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Sort getSort() {
/* 1882 */       return AnnotationValue.Sort.ENUMERATION;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<EnumerationDescription, U> filter(MethodDescription.InDefinedShape param1InDefinedShape, TypeDefinition param1TypeDefinition) {
/* 1889 */       return (AnnotationValue<EnumerationDescription, U>)(param1TypeDefinition.asErasure().equals(this.enumerationDescription.getEnumerationType()) ? this : new AnnotationValue.ForMismatchedType<EnumerationDescription, U>(param1InDefinedShape, param1InDefinedShape.getReturnType().isArray() ? AnnotationValue.RenderingDispatcher.CURRENT
/* 1890 */           .toArrayErrorString(AnnotationValue.Sort.ENUMERATION) : (this.enumerationDescription
/* 1891 */           .getEnumerationType().getName() + '.' + this.enumerationDescription.getValue())));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Loaded<U> load(@MaybeNull ClassLoader param1ClassLoader) {
/*      */       try {
/* 1900 */         return new Loaded<U>((U)this.enumerationDescription.load(Class.forName(this.enumerationDescription.getEnumerationType().getName(), false, param1ClassLoader)));
/* 1901 */       } catch (ClassNotFoundException classNotFoundException) {
/* 1902 */         return new AnnotationValue.ForMissingType.Loaded<U>(this.enumerationDescription.getEnumerationType().getName(), classNotFoundException);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1908 */       return this.enumerationDescription.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/* 1913 */       return (this == param1Object || (param1Object instanceof AnnotationValue && this.enumerationDescription.equals(((AnnotationValue)param1Object).resolve())));
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1918 */       return this.enumerationDescription.toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Loaded<V extends Enum<V>>
/*      */       extends AnnotationValue.Loaded.AbstractBase<V>
/*      */     {
/*      */       private final V enumeration;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Loaded(V param2V) {
/* 1939 */         this.enumeration = param2V;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationValue.State getState() {
/* 1946 */         return AnnotationValue.State.RESOLVED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public V resolve() {
/* 1953 */         return this.enumeration;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean represents(Object param2Object) {
/* 1960 */         return this.enumeration.equals(param2Object);
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/* 1965 */         return this.enumeration.hashCode();
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/* 1970 */         if (this == param2Object)
/* 1971 */           return true; 
/* 1972 */         if (!(param2Object instanceof AnnotationValue.Loaded)) {
/* 1973 */           return false;
/*      */         }
/*      */         
/* 1976 */         if ((param2Object = param2Object).getState().isResolved() && this.enumeration.equals(param2Object.resolve())) return true;  return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public String toString() {
/* 1981 */         return this.enumeration.toString();
/*      */       }
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
/*      */       public static class WithIncompatibleRuntimeType
/*      */         extends AnnotationValue.Loaded.AbstractBase<Enum<?>>
/*      */       {
/*      */         private final Class<?> type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public WithIncompatibleRuntimeType(Class<?> param3Class) {
/* 2007 */           this.type = param3Class;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public AnnotationValue.State getState() {
/* 2014 */           return AnnotationValue.State.UNRESOLVED;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Enum<?> resolve() {
/* 2021 */           throw new IncompatibleClassChangeError("Not an enumeration type: " + this.type.getName());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean represents(Object param3Object) {
/* 2028 */           return false;
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
/*      */     
/*      */     public static class WithUnknownConstant<U extends Enum<U>>
/*      */       extends AnnotationValue.AbstractBase<EnumerationDescription, U>
/*      */     {
/*      */       private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final String value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public WithUnknownConstant(TypeDescription param2TypeDescription, String param2String) {
/* 2059 */         this.typeDescription = param2TypeDescription;
/* 2060 */         this.value = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationValue.State getState() {
/* 2067 */         return AnnotationValue.State.UNRESOLVED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationValue.Sort getSort() {
/* 2074 */         return AnnotationValue.Sort.NONE;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationValue<EnumerationDescription, U> filter(MethodDescription.InDefinedShape param2InDefinedShape, TypeDefinition param2TypeDefinition) {
/* 2081 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public EnumerationDescription resolve() {
/* 2088 */         throw new IllegalStateException(this.typeDescription + " does not declare enumeration constant " + this.value);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationValue.Loaded<U> load(@MaybeNull ClassLoader param2ClassLoader) {
/*      */         try {
/* 2098 */           return new Loaded((Class)Class.forName(this.typeDescription.getName(), false, param2ClassLoader), this.value);
/* 2099 */         } catch (ClassNotFoundException classNotFoundException) {
/* 2100 */           return new AnnotationValue.ForMissingType.Loaded<U>(this.typeDescription.getName(), classNotFoundException);
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String toString() {
/* 2108 */         return this.value + " /* Warning: constant not present! */";
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class Loaded
/*      */         extends AnnotationValue.Loaded.AbstractBase.ForUnresolvedProperty<Enum<?>>
/*      */       {
/*      */         private final Class<? extends Enum<?>> enumType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final String value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Loaded(Class<? extends Enum<?>> param3Class, String param3String) {
/* 2133 */           this.enumType = param3Class;
/* 2134 */           this.value = param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Enum<?> resolve() {
/* 2141 */           throw new EnumConstantNotPresentException(this.enumType, this.value);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String toString() {
/* 2148 */           return this.value + " /* Warning: constant not present! */";
/*      */         }
/*      */       }
/*      */     }
/*      */   }
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
/*      */   public static class ForTypeDescription<U extends Class<U>>
/*      */     extends AbstractBase<TypeDescription, U>
/*      */   {
/*      */     private static final boolean NO_INITIALIZATION = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2175 */     private static final Map<TypeDescription, Class<?>> PRIMITIVE_TYPES = new HashMap<TypeDescription, Class<?>>(); private final TypeDescription typeDescription; static { Class[] arrayOfClass; byte b;
/* 2176 */       for (arrayOfClass = new Class[] { boolean.class, byte.class, short.class, char.class, int.class, long.class, float.class, double.class, void.class }, b = 0; b < 9; ) { Class<?> clazz = arrayOfClass[b];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2185 */         PRIMITIVE_TYPES.put(TypeDescription.ForLoadedType.of(clazz), clazz);
/*      */         b++; }
/*      */        }
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
/*      */     public ForTypeDescription(TypeDescription param1TypeDescription) {
/* 2200 */       this.typeDescription = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static <V extends Class<V>> AnnotationValue<TypeDescription, V> of(TypeDescription param1TypeDescription) {
/* 2211 */       return new ForTypeDescription<V>(param1TypeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.State getState() {
/* 2218 */       return AnnotationValue.State.RESOLVED;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Sort getSort() {
/* 2225 */       return AnnotationValue.Sort.TYPE;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<TypeDescription, U> filter(MethodDescription.InDefinedShape param1InDefinedShape, TypeDefinition param1TypeDefinition) {
/* 2232 */       return (AnnotationValue<TypeDescription, U>)(param1TypeDefinition.asErasure().represents(Class.class) ? this : new AnnotationValue.ForMismatchedType<TypeDescription, U>(param1InDefinedShape, param1InDefinedShape.getReturnType().isArray() ? AnnotationValue.RenderingDispatcher.CURRENT
/* 2233 */           .toArrayErrorString(AnnotationValue.Sort.TYPE) : (Class.class
/* 2234 */           .getName() + '[' + this.typeDescription.getName() + ']')));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription resolve() {
/* 2241 */       return this.typeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Loaded<U> load(@MaybeNull ClassLoader param1ClassLoader) {
/*      */       try {
/* 2250 */         return new Loaded<U>(this.typeDescription.isPrimitive() ? (U)PRIMITIVE_TYPES
/* 2251 */             .get(this.typeDescription) : 
/* 2252 */             (U)Class.forName(this.typeDescription.getName(), false, param1ClassLoader));
/* 2253 */       } catch (ClassNotFoundException classNotFoundException) {
/* 2254 */         return new AnnotationValue.ForMissingType.Loaded<U>(this.typeDescription.getName(), classNotFoundException);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 2260 */       return this.typeDescription.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/* 2265 */       return (this == param1Object || (param1Object instanceof AnnotationValue && this.typeDescription.equals(((AnnotationValue)param1Object).resolve())));
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 2270 */       return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class Loaded<U extends Class<U>>
/*      */       extends AnnotationValue.Loaded.AbstractBase<U>
/*      */     {
/*      */       private final U type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Loaded(U param2U) {
/* 2291 */         this.type = param2U;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationValue.State getState() {
/* 2298 */         return AnnotationValue.State.RESOLVED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public U resolve() {
/* 2305 */         return this.type;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean represents(Object param2Object) {
/* 2312 */         return this.type.equals(param2Object);
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/* 2317 */         return this.type.hashCode();
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/* 2322 */         if (this == param2Object)
/* 2323 */           return true; 
/* 2324 */         if (!(param2Object instanceof AnnotationValue.Loaded)) {
/* 2325 */           return false;
/*      */         }
/*      */         
/* 2328 */         if ((param2Object = param2Object).getState().isResolved() && this.type.equals(param2Object.resolve())) return true;  return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public String toString() {
/* 2333 */         return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(TypeDescription.ForLoadedType.of((Class)this.type));
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForDescriptionArray<U, V>
/*      */     extends AbstractBase<U, V>
/*      */   {
/*      */     private final Class<?> unloadedComponentType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription componentType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends AnnotationValue<?, ?>> values;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForDescriptionArray(Class<?> param1Class, TypeDescription param1TypeDescription, List<? extends AnnotationValue<?, ?>> param1List) {
/* 2373 */       this.unloadedComponentType = param1Class;
/* 2374 */       this.componentType = param1TypeDescription;
/* 2375 */       this.values = param1List;
/*      */     }
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
/*      */     public static <W extends Enum<W>> AnnotationValue<EnumerationDescription[], W[]> of(TypeDescription param1TypeDescription, EnumerationDescription[] param1ArrayOfEnumerationDescription) {
/* 2388 */       ArrayList<? extends AnnotationValue<?, ?>> arrayList = new ArrayList(param1ArrayOfEnumerationDescription.length); int i; byte b;
/* 2389 */       for (i = (param1ArrayOfEnumerationDescription = param1ArrayOfEnumerationDescription).length, b = 0; b < i; b++) {
/* 2390 */         EnumerationDescription enumerationDescription; if (!(enumerationDescription = param1ArrayOfEnumerationDescription[b]).getEnumerationType().equals(param1TypeDescription)) {
/* 2391 */           throw new IllegalArgumentException(enumerationDescription + " is not of " + param1TypeDescription);
/*      */         }
/* 2393 */         arrayList.add(AnnotationValue.ForEnumerationDescription.of(enumerationDescription));
/*      */       } 
/* 2395 */       return (AnnotationValue)new ForDescriptionArray<EnumerationDescription, W>(EnumerationDescription.class, param1TypeDescription, arrayList);
/*      */     }
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
/*      */     public static <W extends Annotation> AnnotationValue<AnnotationDescription[], W[]> of(TypeDescription param1TypeDescription, AnnotationDescription[] param1ArrayOfAnnotationDescription) {
/* 2408 */       ArrayList<? extends AnnotationValue<?, ?>> arrayList = new ArrayList(param1ArrayOfAnnotationDescription.length); int i; byte b;
/* 2409 */       for (i = (param1ArrayOfAnnotationDescription = param1ArrayOfAnnotationDescription).length, b = 0; b < i; b++) {
/* 2410 */         AnnotationDescription annotationDescription; if (!(annotationDescription = param1ArrayOfAnnotationDescription[b]).getAnnotationType().equals(param1TypeDescription)) {
/* 2411 */           throw new IllegalArgumentException(annotationDescription + " is not of " + param1TypeDescription);
/*      */         }
/* 2413 */         arrayList.add(new AnnotationValue.ForAnnotationDescription<Annotation>(annotationDescription));
/*      */       } 
/* 2415 */       return (AnnotationValue)new ForDescriptionArray<AnnotationDescription, W>(AnnotationDescription.class, param1TypeDescription, arrayList);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static AnnotationValue<TypeDescription[], Class<?>[]> of(TypeDescription[] param1ArrayOfTypeDescription) {
/* 2426 */       ArrayList<? extends AnnotationValue<?, ?>> arrayList = new ArrayList(param1ArrayOfTypeDescription.length); int i; byte b;
/* 2427 */       for (i = (param1ArrayOfTypeDescription = param1ArrayOfTypeDescription).length, b = 0; b < i; ) { TypeDescription typeDescription = param1ArrayOfTypeDescription[b];
/* 2428 */         arrayList.add(AnnotationValue.ForTypeDescription.of(typeDescription)); b++; }
/*      */       
/* 2430 */       return (AnnotationValue)new ForDescriptionArray<TypeDescription, Class<?>>(TypeDescription.class, TypeDescription.ForLoadedType.of(Class.class), arrayList);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.State getState() {
/* 2437 */       return AnnotationValue.State.RESOLVED;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Sort getSort() {
/* 2444 */       return AnnotationValue.Sort.ARRAY;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*      */     public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape param1InDefinedShape, TypeDefinition param1TypeDefinition) {
/* 2453 */       if (param1TypeDefinition.isArray() && param1TypeDefinition.getComponentType().asErasure().equals(this.componentType)) {
/* 2454 */         for (Iterator<? extends AnnotationValue<?, ?>> iterator = this.values.iterator(); iterator.hasNext();) {
/*      */           
/* 2456 */           if ((annotationValue = (annotationValue = iterator.next()).filter(param1InDefinedShape, param1TypeDefinition.getComponentType())).getState() != AnnotationValue.State.RESOLVED) {
/* 2457 */             return (AnnotationValue)annotationValue;
/*      */           }
/*      */         } 
/* 2460 */         return this;
/*      */       } 
/* 2462 */       return new AnnotationValue.ForMismatchedType<U, V>(param1InDefinedShape, AnnotationValue.RenderingDispatcher.CURRENT.toArrayErrorString(AnnotationValue.Sort.of((TypeDefinition)this.componentType)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public U resolve() {
/* 2471 */       Object object = Array.newInstance(this.unloadedComponentType, this.values.size());
/* 2472 */       byte b = 0;
/* 2473 */       for (AnnotationValue<?, ?> annotationValue : this.values) {
/* 2474 */         Array.set(object, b++, annotationValue.resolve());
/*      */       }
/* 2476 */       return (U)object;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Loaded<V> load(@MaybeNull ClassLoader param1ClassLoader) {
/* 2484 */       ArrayList<AnnotationValue.Loaded<?>> arrayList = new ArrayList(this.values.size());
/* 2485 */       for (AnnotationValue<?, ?> annotationValue : this.values) {
/* 2486 */         arrayList.add(annotationValue.load(param1ClassLoader));
/*      */       }
/*      */       try {
/* 2489 */         return new Loaded<V>((Class)Class.forName(this.componentType.getName(), false, param1ClassLoader), arrayList);
/* 2490 */       } catch (ClassNotFoundException classNotFoundException) {
/* 2491 */         return new AnnotationValue.ForMissingType.Loaded<V>(this.componentType.getName(), classNotFoundException);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     @Enhance("hashCode")
/*      */     public int hashCode() {
/* 2498 */       ForDescriptionArray forDescriptionArray = this; int k = 1;
/* 2499 */       for (AnnotationValue<?, ?> annotationValue : forDescriptionArray.values)
/* 2500 */         k = k * 31 + annotationValue.hashCode(); 
/*      */       int i, j;
/* 2502 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : k)) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/* 2507 */       if (this == param1Object)
/* 2508 */         return true; 
/* 2509 */       if (!(param1Object instanceof AnnotationValue)) {
/* 2510 */         return false;
/*      */       }
/*      */ 
/*      */       
/* 2514 */       if (!(param1Object = (param1Object = param1Object).resolve()).getClass().isArray()) {
/* 2515 */         return false;
/*      */       }
/* 2517 */       if (this.values.size() != Array.getLength(param1Object)) {
/* 2518 */         return false;
/*      */       }
/* 2520 */       Iterator<? extends AnnotationValue<?, ?>> iterator = this.values.iterator();
/* 2521 */       for (byte b = 0; b < this.values.size(); b++) {
/*      */         AnnotationValue<T, ?> annotationValue;
/* 2523 */         if (!(annotationValue = (AnnotationValue)iterator.next()).resolve().equals(Array.get(param1Object, b))) {
/* 2524 */           return false;
/*      */         }
/*      */       } 
/* 2527 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 2532 */       return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(this.values);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class Loaded<W>
/*      */       extends AnnotationValue.Loaded.AbstractBase<W>
/*      */     {
/*      */       private final Class<W> componentType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final List<AnnotationValue.Loaded<?>> values;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Loaded(Class<W> param2Class, List<AnnotationValue.Loaded<?>> param2List) {
/* 2559 */         this.componentType = param2Class;
/* 2560 */         this.values = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationValue.State getState() {
/* 2567 */         for (Iterator<AnnotationValue.Loaded<?>> iterator = this.values.iterator(); iterator.hasNext();) {
/* 2568 */           if (!(loaded = iterator.next()).getState().isResolved()) {
/* 2569 */             return AnnotationValue.State.UNRESOLVED;
/*      */           }
/*      */         } 
/* 2572 */         return AnnotationValue.State.RESOLVED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public W resolve() {
/* 2580 */         Object object = Array.newInstance(this.componentType, this.values.size());
/* 2581 */         byte b = 0;
/* 2582 */         for (AnnotationValue.Loaded<?> loaded : this.values) {
/* 2583 */           Array.set(object, b++, loaded.resolve());
/*      */         }
/* 2585 */         return (W)object;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean represents(Object param2Object) {
/* 2592 */         if (!(param2Object instanceof Object[])) return false; 
/* 2593 */         if (param2Object.getClass().getComponentType() != this.componentType) return false; 
/* 2594 */         param2Object = param2Object;
/* 2595 */         if (this.values.size() != param2Object.length) return false; 
/* 2596 */         Iterator<AnnotationValue.Loaded<?>> iterator = this.values.iterator(); int i; byte b;
/* 2597 */         for (i = (param2Object = param2Object).length, b = 0; b < i; ) { Object object = param2Object[b];
/*      */           AnnotationValue.Loaded<?> loaded;
/* 2599 */           if (!(loaded = iterator.next()).represents(object))
/* 2600 */             return false; 
/*      */           b++; }
/*      */         
/* 2603 */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance("hashCode")
/*      */       public int hashCode() {
/* 2609 */         Loaded loaded = this; int k = 1;
/* 2610 */         for (AnnotationValue.Loaded<?> loaded1 : loaded.values)
/* 2611 */           k = k * 31 + loaded1.hashCode(); 
/*      */         int j, i;
/* 2613 */         if (!(i = ((j = this.hashCode) != 0) ? 0 : k)) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/* 2618 */         if (this == param2Object)
/* 2619 */           return true; 
/* 2620 */         if (!(param2Object instanceof AnnotationValue.Loaded)) {
/* 2621 */           return false;
/*      */         }
/*      */         
/* 2624 */         if (!(param2Object = param2Object).getState().isResolved()) {
/* 2625 */           return false;
/*      */         }
/*      */         
/* 2628 */         if (!(param2Object = param2Object.resolve() instanceof Object[])) {
/* 2629 */           return false;
/*      */         }
/* 2631 */         param2Object = param2Object;
/* 2632 */         if (this.values.size() != param2Object.length) {
/* 2633 */           return false;
/*      */         }
/* 2635 */         Iterator<AnnotationValue.Loaded<?>> iterator = this.values.iterator(); int i; byte b;
/* 2636 */         for (i = (param2Object = param2Object).length, b = 0; b < i; ) { Object object = param2Object[b];
/*      */           AnnotationValue.Loaded<?> loaded;
/* 2638 */           if (!(loaded = iterator.next()).getState().isResolved() || !loaded.resolve().equals(object))
/* 2639 */             return false; 
/*      */           b++; }
/*      */         
/* 2642 */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       public String toString() {
/* 2647 */         return AnnotationValue.RenderingDispatcher.CURRENT.toSourceString(this.values);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForMissingType<U, V>
/*      */     extends AbstractBase<U, V>
/*      */   {
/*      */     private final String typeName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForMissingType(String param1String) {
/* 2671 */       this.typeName = param1String;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.State getState() {
/* 2678 */       return AnnotationValue.State.UNRESOLVED;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Sort getSort() {
/* 2685 */       return AnnotationValue.Sort.NONE;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape param1InDefinedShape, TypeDefinition param1TypeDefinition) {
/* 2692 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public U resolve() {
/* 2699 */       throw new IllegalStateException("Type not found: " + this.typeName);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Loaded<V> load(@MaybeNull ClassLoader param1ClassLoader) {
/* 2706 */       return new Loaded<V>(this.typeName, new ClassNotFoundException(this.typeName));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 2713 */       return this.typeName + ".class /* Warning: type not present! */";
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Loaded<U>
/*      */       extends AnnotationValue.Loaded.AbstractBase.ForUnresolvedProperty<U>
/*      */     {
/*      */       private final String typeName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final ClassNotFoundException exception;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Loaded(String param2String, ClassNotFoundException param2ClassNotFoundException) {
/* 2740 */         this.typeName = param2String;
/* 2741 */         this.exception = param2ClassNotFoundException;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public U resolve() {
/* 2748 */         throw new TypeNotPresentException(this.typeName, this.exception);
/*      */       }
/*      */ 
/*      */       
/*      */       public String toString() {
/* 2753 */         return this.typeName + ".class /* Warning: type not present! */";
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForMismatchedType<U, V>
/*      */     extends AbstractBase<U, V>
/*      */   {
/*      */     private final MethodDescription.InDefinedShape property;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final String value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForMismatchedType(MethodDescription.InDefinedShape param1InDefinedShape, String param1String) {
/* 2783 */       this.property = param1InDefinedShape;
/* 2784 */       this.value = param1String;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.State getState() {
/* 2791 */       return AnnotationValue.State.UNRESOLVED;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Sort getSort() {
/* 2798 */       return AnnotationValue.Sort.NONE;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape param1InDefinedShape, TypeDefinition param1TypeDefinition) {
/* 2805 */       return new ForMismatchedType(param1InDefinedShape, this.value);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public U resolve() {
/* 2812 */       throw new IllegalStateException(this.value + " cannot be used as value for " + this.property);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Loaded<V> load(@MaybeNull ClassLoader param1ClassLoader) {
/*      */       try {
/* 2820 */         Class<?> clazz = Class.forName(this.property.getDeclaringType().getName(), false, param1ClassLoader);
/*      */         try {
/* 2822 */           return new Loaded<V>(clazz.getMethod(this.property.getName(), new Class[0]), this.value);
/* 2823 */         } catch (NoSuchMethodException noSuchMethodException) {
/* 2824 */           return new AnnotationValue.ForIncompatibleType.Loaded<V>(clazz);
/*      */         } 
/* 2826 */       } catch (ClassNotFoundException classNotFoundException) {
/* 2827 */         return new AnnotationValue.ForMissingType.Loaded<V>(this.property.getDeclaringType().getName(), classNotFoundException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 2835 */       return "/* Warning type mismatch! \"" + this.value + "\" */";
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Loaded<W>
/*      */       extends AnnotationValue.Loaded.AbstractBase.ForUnresolvedProperty<W>
/*      */     {
/*      */       private final Method property;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final String value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Loaded(Method param2Method, String param2String) {
/* 2862 */         this.property = param2Method;
/* 2863 */         this.value = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public W resolve() {
/* 2870 */         throw new AnnotationTypeMismatchException(this.property, this.value);
/*      */       }
/*      */ 
/*      */       
/*      */       public String toString() {
/* 2875 */         return "/* Warning type mismatch! \"" + this.value + "\" */";
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForMissingValue<U, V>
/*      */     extends AbstractBase<U, V>
/*      */   {
/*      */     private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final String property;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForMissingValue(TypeDescription param1TypeDescription, String param1String) {
/* 2905 */       this.typeDescription = param1TypeDescription;
/* 2906 */       this.property = param1String;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.State getState() {
/* 2913 */       return AnnotationValue.State.UNDEFINED;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Sort getSort() {
/* 2920 */       return AnnotationValue.Sort.NONE;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape param1InDefinedShape, TypeDefinition param1TypeDefinition) {
/* 2927 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Loaded<V> load(@MaybeNull ClassLoader param1ClassLoader) {
/*      */       try {
/*      */         Class<?> clazz;
/* 2937 */         return (AnnotationValue.Loaded<V>)((clazz = Class.forName(this.typeDescription.getName(), false, param1ClassLoader)).isAnnotation() ? new Loaded<V>((Class)clazz, this.property) : new AnnotationValue.ForIncompatibleType.Loaded<V>(clazz));
/*      */       
/*      */       }
/* 2940 */       catch (ClassNotFoundException classNotFoundException) {
/* 2941 */         return new AnnotationValue.ForMissingType.Loaded<V>(this.typeDescription.getName(), classNotFoundException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public U resolve() {
/* 2949 */       throw new IllegalStateException(this.typeDescription + " does not define " + this.property);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Loaded<W>
/*      */       extends AnnotationValue.Loaded.AbstractBase<W>
/*      */     {
/*      */       private final Class<? extends Annotation> type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final String property;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Loaded(Class<? extends Annotation> param2Class, String param2String) {
/* 2978 */         this.type = param2Class;
/* 2979 */         this.property = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public AnnotationValue.State getState() {
/* 2986 */         return AnnotationValue.State.UNDEFINED;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public W resolve() {
/* 2993 */         throw new IncompleteAnnotationException(this.type, this.property);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean represents(Object param2Object) {
/* 3000 */         return false;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ForIncompatibleType<U, V>
/*      */     extends AbstractBase<U, V>
/*      */   {
/*      */     private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForIncompatibleType(TypeDescription param1TypeDescription) {
/* 3026 */       this.typeDescription = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.State getState() {
/* 3033 */       return AnnotationValue.State.UNRESOLVED;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Sort getSort() {
/* 3040 */       return AnnotationValue.Sort.NONE;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape param1InDefinedShape, TypeDefinition param1TypeDefinition) {
/* 3047 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public U resolve() {
/* 3054 */       throw new IllegalStateException("Property is defined with an incompatible runtime type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationValue.Loaded<V> load(@MaybeNull ClassLoader param1ClassLoader) {
/*      */       try {
/* 3062 */         return new Loaded<V>(Class.forName(this.typeDescription.getName(), false, param1ClassLoader));
/* 3063 */       } catch (ClassNotFoundException classNotFoundException) {
/* 3064 */         return new AnnotationValue.ForMissingType.Loaded<V>(this.typeDescription.getName(), classNotFoundException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 3072 */       return "/* Warning type incompatibility! \"" + this.typeDescription.getName() + "\" */";
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class Loaded<W>
/*      */       extends AnnotationValue.Loaded.AbstractBase.ForUnresolvedProperty<W>
/*      */     {
/*      */       private final Class<?> type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Loaded(Class<?> param2Class) {
/* 3093 */         this.type = param2Class;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public W resolve() {
/* 3100 */         throw new IncompatibleClassChangeError(this.type.toString());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String toString() {
/* 3107 */         return "/* Warning type incompatibility! \"" + this.type.getName() + "\" */";
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\annotation\AnnotationValue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */