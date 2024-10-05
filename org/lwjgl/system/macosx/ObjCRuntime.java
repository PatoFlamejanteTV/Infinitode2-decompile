/*      */ package org.lwjgl.system.macosx;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.FunctionProvider;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.libc.LibCStdlib;
/*      */ 
/*      */ public class ObjCRuntime {
/*      */   public static final long nil = 0L;
/*      */   public static final byte YES = 1;
/*      */   public static final byte NO = 0;
/*      */   public static final char _C_ID = '@';
/*      */   public static final char _C_CLASS = '#';
/*      */   public static final char _C_SEL = ':';
/*      */   public static final char _C_CHR = 'c';
/*      */   public static final char _C_UCHR = 'C';
/*      */   public static final char _C_SHT = 's';
/*      */   public static final char _C_USHT = 'S';
/*      */   public static final char _C_INT = 'i';
/*      */   public static final char _C_UINT = 'I';
/*      */   public static final char _C_LNG = 'l';
/*      */   public static final char _C_ULNG = 'L';
/*      */   public static final char _C_LNG_LNG = 'q';
/*      */   public static final char _C_ULNG_LNG = 'Q';
/*      */   public static final char _C_FLT = 'f';
/*      */   public static final char _C_DBL = 'd';
/*      */   public static final char _C_BFLD = 'b';
/*      */   public static final char _C_BOOL = 'B';
/*      */   public static final char _C_VOID = 'v';
/*      */   public static final char _C_UNDEF = '?';
/*      */   public static final char _C_PTR = '^';
/*      */   public static final char _C_CHARPTR = '*';
/*      */   public static final char _C_ATOM = '%';
/*      */   public static final char _C_ARY_B = '[';
/*      */   public static final char _C_ARY_E = ']';
/*      */   public static final char _C_UNION_B = '(';
/*      */   public static final char _C_UNION_E = ')';
/*      */   public static final char _C_STRUCT_B = '{';
/*      */   public static final char _C_STRUCT_E = '}';
/*      */   public static final char _C_VECTOR = '!';
/*      */   public static final char _C_CONST = 'r';
/*      */   public static final int OBJC_ASSOCIATION_ASSIGN = 0;
/*   50 */   private static final SharedLibrary OBJC = Library.loadNative(ObjCRuntime.class, "org.lwjgl", "objc");
/*      */   
/*      */   public static final int OBJC_ASSOCIATION_RETAIN_NONATOMIC = 1;
/*      */   public static final int OBJC_ASSOCIATION_COPY_NONATOMIC = 3;
/*      */   public static final int OBJC_ASSOCIATION_RETAIN = 1401;
/*      */   public static final int OBJC_ASSOCIATION_COPY = 1403;
/*      */   
/*      */   public static final class Functions
/*      */   {
/*   59 */     public static final long object_copy = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_copy");
/*   60 */     public static final long object_dispose = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_dispose");
/*   61 */     public static final long object_getClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_getClass");
/*   62 */     public static final long object_setClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_setClass");
/*   63 */     public static final long object_getClassName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_getClassName");
/*   64 */     public static final long object_getIndexedIvars = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_getIndexedIvars");
/*   65 */     public static final long object_getIvar = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_getIvar");
/*   66 */     public static final long object_setIvar = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_setIvar");
/*   67 */     public static final long object_setInstanceVariable = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_setInstanceVariable");
/*   68 */     public static final long object_getInstanceVariable = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_getInstanceVariable");
/*   69 */     public static final long objc_getClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getClass");
/*   70 */     public static final long objc_getMetaClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getMetaClass");
/*   71 */     public static final long objc_lookUpClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_lookUpClass");
/*   72 */     public static final long objc_getRequiredClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getRequiredClass");
/*   73 */     public static final long objc_getClassList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getClassList");
/*   74 */     public static final long objc_copyClassList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_copyClassList");
/*   75 */     public static final long class_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getName");
/*   76 */     public static final long class_isMetaClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_isMetaClass");
/*   77 */     public static final long class_getSuperclass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getSuperclass");
/*   78 */     public static final long class_getVersion = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getVersion");
/*   79 */     public static final long class_setVersion = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_setVersion");
/*   80 */     public static final long class_getInstanceSize = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getInstanceSize");
/*   81 */     public static final long class_getInstanceVariable = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getInstanceVariable");
/*   82 */     public static final long class_getClassVariable = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getClassVariable");
/*   83 */     public static final long class_copyIvarList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_copyIvarList");
/*   84 */     public static final long class_getInstanceMethod = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getInstanceMethod");
/*   85 */     public static final long class_getClassMethod = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getClassMethod");
/*   86 */     public static final long class_getMethodImplementation = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getMethodImplementation");
/*   87 */     public static final long class_respondsToSelector = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_respondsToSelector");
/*   88 */     public static final long class_copyMethodList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_copyMethodList");
/*   89 */     public static final long class_conformsToProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_conformsToProtocol");
/*   90 */     public static final long class_copyProtocolList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_copyProtocolList");
/*   91 */     public static final long class_getProperty = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getProperty");
/*   92 */     public static final long class_copyPropertyList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_copyPropertyList");
/*   93 */     public static final long class_getIvarLayout = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getIvarLayout");
/*   94 */     public static final long class_getWeakIvarLayout = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getWeakIvarLayout");
/*   95 */     public static final long class_addMethod = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_addMethod");
/*   96 */     public static final long class_replaceMethod = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_replaceMethod");
/*   97 */     public static final long class_addIvar = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_addIvar");
/*   98 */     public static final long class_addProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_addProtocol");
/*   99 */     public static final long class_addProperty = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_addProperty");
/*  100 */     public static final long class_replaceProperty = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_replaceProperty");
/*  101 */     public static final long class_setIvarLayout = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_setIvarLayout");
/*  102 */     public static final long class_setWeakIvarLayout = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_setWeakIvarLayout");
/*  103 */     public static final long class_createInstance = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_createInstance");
/*  104 */     public static final long objc_constructInstance = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_constructInstance");
/*  105 */     public static final long objc_destructInstance = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_destructInstance");
/*  106 */     public static final long objc_allocateClassPair = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_allocateClassPair");
/*  107 */     public static final long objc_registerClassPair = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_registerClassPair");
/*  108 */     public static final long objc_disposeClassPair = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_disposeClassPair");
/*  109 */     public static final long method_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getName");
/*  110 */     public static final long method_getImplementation = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getImplementation");
/*  111 */     public static final long method_getTypeEncoding = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getTypeEncoding");
/*  112 */     public static final long method_getNumberOfArguments = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getNumberOfArguments");
/*  113 */     public static final long method_copyReturnType = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_copyReturnType");
/*  114 */     public static final long method_copyArgumentType = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_copyArgumentType");
/*  115 */     public static final long method_getReturnType = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getReturnType");
/*  116 */     public static final long method_getArgumentType = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getArgumentType");
/*  117 */     public static final long method_setImplementation = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_setImplementation");
/*  118 */     public static final long method_exchangeImplementations = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_exchangeImplementations");
/*  119 */     public static final long ivar_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "ivar_getName");
/*  120 */     public static final long ivar_getTypeEncoding = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "ivar_getTypeEncoding");
/*  121 */     public static final long ivar_getOffset = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "ivar_getOffset");
/*  122 */     public static final long property_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "property_getName");
/*  123 */     public static final long property_getAttributes = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "property_getAttributes");
/*  124 */     public static final long property_copyAttributeList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "property_copyAttributeList");
/*  125 */     public static final long property_copyAttributeValue = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "property_copyAttributeValue");
/*  126 */     public static final long objc_getProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getProtocol");
/*  127 */     public static final long objc_copyProtocolList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_copyProtocolList");
/*  128 */     public static final long protocol_conformsToProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_conformsToProtocol");
/*  129 */     public static final long protocol_isEqual = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_isEqual");
/*  130 */     public static final long protocol_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_getName");
/*  131 */     public static final long protocol_getMethodDescription = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_getMethodDescription");
/*  132 */     public static final long protocol_copyMethodDescriptionList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_copyMethodDescriptionList");
/*  133 */     public static final long protocol_getProperty = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_getProperty");
/*  134 */     public static final long protocol_copyPropertyList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_copyPropertyList");
/*  135 */     public static final long protocol_copyProtocolList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_copyProtocolList");
/*  136 */     public static final long objc_allocateProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_allocateProtocol");
/*  137 */     public static final long objc_registerProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_registerProtocol");
/*  138 */     public static final long protocol_addMethodDescription = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_addMethodDescription");
/*  139 */     public static final long protocol_addProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_addProtocol");
/*  140 */     public static final long protocol_addProperty = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_addProperty");
/*  141 */     public static final long objc_copyImageNames = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_copyImageNames");
/*  142 */     public static final long class_getImageName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getImageName");
/*  143 */     public static final long objc_copyClassNamesForImage = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_copyClassNamesForImage");
/*  144 */     public static final long sel_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "sel_getName");
/*  145 */     public static final long sel_getUid = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "sel_getUid");
/*  146 */     public static final long sel_registerName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "sel_registerName");
/*  147 */     public static final long sel_isEqual = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "sel_isEqual");
/*  148 */     public static final long objc_enumerationMutation = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_enumerationMutation");
/*  149 */     public static final long objc_setEnumerationMutationHandler = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_setEnumerationMutationHandler");
/*  150 */     public static final long imp_implementationWithBlock = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "imp_implementationWithBlock");
/*  151 */     public static final long imp_getBlock = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "imp_getBlock");
/*  152 */     public static final long imp_removeBlock = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "imp_removeBlock");
/*  153 */     public static final long objc_loadWeak = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_loadWeak");
/*  154 */     public static final long objc_storeWeak = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_storeWeak");
/*  155 */     public static final long objc_setAssociatedObject = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_setAssociatedObject");
/*  156 */     public static final long objc_getAssociatedObject = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getAssociatedObject");
/*  157 */     public static final long objc_removeAssociatedObjects = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_removeAssociatedObjects");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static SharedLibrary getLibrary() {
/*  163 */     return OBJC;
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
/*      */   protected ObjCRuntime() {
/*  216 */     throw new UnsupportedOperationException();
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
/*      */   
/*      */   @NativeType("id")
/*      */   public static long object_copy(@NativeType("id") long paramLong1, @NativeType("size_t") long paramLong2) {
/*  231 */     long l = Functions.object_copy;
/*  232 */     if (Checks.CHECKS) {
/*  233 */       Checks.check(paramLong1);
/*      */     }
/*  235 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   @NativeType("id")
/*      */   public static long object_dispose(@NativeType("id") long paramLong) {
/*  249 */     long l = Functions.object_dispose;
/*  250 */     if (Checks.CHECKS) {
/*  251 */       Checks.check(paramLong);
/*      */     }
/*  253 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("Class")
/*      */   public static long object_getClass(@NativeType("id") long paramLong) {
/*  267 */     long l = Functions.object_getClass;
/*  268 */     return JNI.invokePP(paramLong, l);
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
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long object_setClass(@NativeType("id") long paramLong1, @NativeType("Class") long paramLong2) {
/*  283 */     long l = Functions.object_setClass;
/*  284 */     if (Checks.CHECKS) {
/*  285 */       Checks.check(paramLong2);
/*      */     }
/*  287 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobject_getClassName(long paramLong) {
/*  294 */     long l = Functions.object_getClassName;
/*  295 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char const *")
/*      */   public static String object_getClassName(@NativeType("id") long paramLong) {
/*      */     long l;
/*  309 */     return MemoryUtil.memUTF8Safe(l = nobject_getClassName(paramLong));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long object_getIndexedIvars(@NativeType("id") long paramLong) {
/*  330 */     long l = Functions.object_getIndexedIvars;
/*  331 */     if (Checks.CHECKS) {
/*  332 */       Checks.check(paramLong);
/*      */     }
/*  334 */     return JNI.invokePP(paramLong, l);
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
/*      */   
/*      */   @NativeType("id")
/*      */   public static long object_getIvar(@NativeType("id") long paramLong1, @NativeType("Ivar") long paramLong2) {
/*  349 */     long l = Functions.object_getIvar;
/*  350 */     if (Checks.CHECKS) {
/*  351 */       Checks.check(paramLong2);
/*      */     }
/*  353 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */ 
/*      */   
/*      */   public static void object_setIvar(@NativeType("id") long paramLong1, @NativeType("Ivar") long paramLong2, @NativeType("id") long paramLong3) {
/*  368 */     long l = Functions.object_setIvar;
/*  369 */     if (Checks.CHECKS) {
/*  370 */       Checks.check(paramLong1);
/*  371 */       Checks.check(paramLong2);
/*  372 */       Checks.check(paramLong3);
/*      */     } 
/*  374 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobject_setInstanceVariable(long paramLong1, long paramLong2, long paramLong3) {
/*  381 */     long l = Functions.object_setInstanceVariable;
/*  382 */     if (Checks.CHECKS) {
/*  383 */       Checks.check(paramLong1);
/*      */     }
/*  385 */     return JNI.invokePPPP(paramLong1, paramLong2, paramLong3, l);
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
/*      */   @NativeType("Ivar")
/*      */   public static long object_setInstanceVariable(@NativeType("id") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("void *") ByteBuffer paramByteBuffer2) {
/*  399 */     if (Checks.CHECKS) {
/*  400 */       Checks.checkNT1(paramByteBuffer1);
/*      */     }
/*  402 */     return nobject_setInstanceVariable(paramLong, MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2));
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
/*      */   @NativeType("Ivar")
/*      */   public static long object_setInstanceVariable(@NativeType("id") long paramLong, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*      */     MemoryStack memoryStack;
/*  416 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  418 */       memoryStack.nUTF8(paramCharSequence, true);
/*  419 */       long l = memoryStack.getPointerAddress();
/*  420 */       return nobject_setInstanceVariable(paramLong, l, MemoryUtil.memAddress(paramByteBuffer));
/*      */     } finally {
/*  422 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobject_getInstanceVariable(long paramLong1, long paramLong2, long paramLong3) {
/*  430 */     long l = Functions.object_getInstanceVariable;
/*  431 */     if (Checks.CHECKS) {
/*  432 */       Checks.check(paramLong1);
/*      */     }
/*  434 */     return JNI.invokePPPP(paramLong1, paramLong2, paramLong3, l);
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
/*      */   @NativeType("Ivar")
/*      */   public static long object_getInstanceVariable(@NativeType("id") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/*  448 */     if (Checks.CHECKS) {
/*  449 */       Checks.checkNT1(paramByteBuffer);
/*  450 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     } 
/*  452 */     return nobject_getInstanceVariable(paramLong, MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
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
/*      */   @NativeType("Ivar")
/*      */   public static long object_getInstanceVariable(@NativeType("id") long paramLong, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/*  466 */     if (Checks.CHECKS)
/*  467 */       Checks.check((CustomBuffer)paramPointerBuffer, 1); 
/*      */     MemoryStack memoryStack;
/*  469 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  471 */       memoryStack.nUTF8(paramCharSequence, true);
/*  472 */       long l = memoryStack.getPointerAddress();
/*  473 */       return nobject_getInstanceVariable(paramLong, l, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */     } finally {
/*  475 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_getClass(long paramLong) {
/*  483 */     long l = Functions.objc_getClass;
/*  484 */     return JNI.invokePP(paramLong, l);
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
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getClass(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/*  499 */     if (Checks.CHECKS) {
/*  500 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  502 */     return nobjc_getClass(MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   @NativeType("Class")
/*      */   public static long objc_getClass(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  517 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  519 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       long l;
/*  521 */       return nobjc_getClass(l = memoryStack.getPointerAddress());
/*      */     } finally {
/*  523 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_getMetaClass(long paramLong) {
/*  531 */     long l = Functions.objc_getMetaClass;
/*  532 */     return JNI.invokePP(paramLong, l);
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
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getMetaClass(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/*  548 */     if (Checks.CHECKS) {
/*  549 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  551 */     return nobjc_getMetaClass(MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getMetaClass(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  567 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  569 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       long l;
/*  571 */       return nobjc_getMetaClass(l = memoryStack.getPointerAddress());
/*      */     } finally {
/*  573 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_lookUpClass(long paramLong) {
/*  581 */     long l = Functions.objc_lookUpClass;
/*  582 */     return JNI.invokePP(paramLong, l);
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
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_lookUpClass(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/*  597 */     if (Checks.CHECKS) {
/*  598 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  600 */     return nobjc_lookUpClass(MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   @NativeType("Class")
/*      */   public static long objc_lookUpClass(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  615 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  617 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       long l;
/*  619 */       return nobjc_lookUpClass(l = memoryStack.getPointerAddress());
/*      */     } finally {
/*  621 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_getRequiredClass(long paramLong) {
/*  629 */     long l = Functions.objc_getRequiredClass;
/*  630 */     return JNI.invokePP(paramLong, l);
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
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getRequiredClass(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/*  646 */     if (Checks.CHECKS) {
/*  647 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  649 */     return nobjc_getRequiredClass(MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getRequiredClass(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  665 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  667 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       long l;
/*  669 */       return nobjc_getRequiredClass(l = memoryStack.getPointerAddress());
/*      */     } finally {
/*  671 */       memoryStack.setPointer(i);
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
/*      */   public static int nobjc_getClassList(long paramLong, int paramInt) {
/*  684 */     long l = Functions.objc_getClassList;
/*  685 */     return JNI.invokePI(paramLong, paramInt, l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int objc_getClassList(@NativeType("Class *") PointerBuffer paramPointerBuffer) {
/*  706 */     return nobjc_getClassList(MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), Checks.remainingSafe((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_copyClassList(long paramLong) {
/*  717 */     long l = Functions.objc_copyClassList;
/*  718 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Class *")
/*      */   public static PointerBuffer objc_copyClassList() {
/*      */     MemoryStack memoryStack;
/*  729 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*  730 */     null = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/*  733 */       return MemoryUtil.memPointerBufferSafe(l = nobjc_copyClassList(MemoryUtil.memAddress(null)), null.get(0));
/*      */     } finally {
/*  735 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getName(long paramLong) {
/*  743 */     long l = Functions.class_getName;
/*  744 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char const *")
/*      */   public static String class_getName(@NativeType("Class") long paramLong) {
/*      */     long l;
/*  758 */     return MemoryUtil.memUTF8Safe(l = nclass_getName(paramLong));
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_isMetaClass(@NativeType("Class") long paramLong) {
/*  772 */     long l = Functions.class_isMetaClass;
/*  773 */     return JNI.invokePZ(paramLong, l);
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
/*      */   @NativeType("Class")
/*      */   public static long class_getSuperclass(@NativeType("Class") long paramLong) {
/*  787 */     long l = Functions.class_getSuperclass;
/*  788 */     return JNI.invokePP(paramLong, l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int class_getVersion(@NativeType("Class") long paramLong) {
/*  808 */     long l = Functions.class_getVersion;
/*  809 */     if (Checks.CHECKS) {
/*  810 */       Checks.check(paramLong);
/*      */     }
/*  812 */     return JNI.invokePI(paramLong, l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void class_setVersion(@NativeType("Class") long paramLong, int paramInt) {
/*  831 */     long l = Functions.class_setVersion;
/*  832 */     if (Checks.CHECKS) {
/*  833 */       Checks.check(paramLong);
/*      */     }
/*  835 */     JNI.invokePV(paramLong, paramInt, l);
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
/*      */   @NativeType("size_t")
/*      */   public static long class_getInstanceSize(@NativeType("Class") long paramLong) {
/*  849 */     long l = Functions.class_getInstanceSize;
/*  850 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getInstanceVariable(long paramLong1, long paramLong2) {
/*  857 */     long l = Functions.class_getInstanceVariable;
/*  858 */     if (Checks.CHECKS) {
/*  859 */       Checks.check(paramLong1);
/*      */     }
/*  861 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   @NativeType("Ivar")
/*      */   public static long class_getInstanceVariable(@NativeType("Class") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/*  874 */     if (Checks.CHECKS) {
/*  875 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  877 */     return nclass_getInstanceVariable(paramLong, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Ivar")
/*      */   public static long class_getInstanceVariable(@NativeType("Class") long paramLong, @NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  890 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  892 */       memoryStack.nUTF8(paramCharSequence, true);
/*  893 */       long l = memoryStack.getPointerAddress();
/*  894 */       return nclass_getInstanceVariable(paramLong, l);
/*      */     } finally {
/*  896 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getClassVariable(long paramLong1, long paramLong2) {
/*  904 */     long l = Functions.class_getClassVariable;
/*  905 */     if (Checks.CHECKS) {
/*  906 */       Checks.check(paramLong1);
/*      */     }
/*  908 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   @NativeType("Ivar")
/*      */   public static long class_getClassVariable(@NativeType("Class") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/*  921 */     if (Checks.CHECKS) {
/*  922 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  924 */     return nclass_getClassVariable(paramLong, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Ivar")
/*      */   public static long class_getClassVariable(@NativeType("Class") long paramLong, @NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  937 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  939 */       memoryStack.nUTF8(paramCharSequence, true);
/*  940 */       long l = memoryStack.getPointerAddress();
/*  941 */       return nclass_getClassVariable(paramLong, l);
/*      */     } finally {
/*  943 */       memoryStack.setPointer(i);
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
/*      */   public static long nclass_copyIvarList(long paramLong1, long paramLong2) {
/*  955 */     long l = Functions.class_copyIvarList;
/*  956 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   
/*      */   @NativeType("Ivar *")
/*      */   public static PointerBuffer class_copyIvarList(@NativeType("Class") long paramLong) {
/*      */     MemoryStack memoryStack;
/*  972 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*  973 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/*  976 */       return MemoryUtil.memPointerBufferSafe(l = nclass_copyIvarList(paramLong, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/*  978 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Method")
/*      */   public static long class_getInstanceMethod(@NativeType("Class") long paramLong1, @NativeType("SEL") long paramLong2) {
/*  997 */     long l = Functions.class_getInstanceMethod;
/*  998 */     if (Checks.CHECKS) {
/*  999 */       Checks.check(paramLong1);
/* 1000 */       Checks.check(paramLong2);
/*      */     } 
/* 1002 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Method")
/*      */   public static long class_getClassMethod(@NativeType("Class") long paramLong1, @NativeType("SEL") long paramLong2) {
/* 1020 */     long l = Functions.class_getClassMethod;
/* 1021 */     if (Checks.CHECKS) {
/* 1022 */       Checks.check(paramLong1);
/* 1023 */       Checks.check(paramLong2);
/*      */     } 
/* 1025 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("IMP")
/*      */   public static long class_getMethodImplementation(@NativeType("Class") long paramLong1, @NativeType("SEL") long paramLong2) {
/* 1045 */     long l = Functions.class_getMethodImplementation;
/* 1046 */     if (Checks.CHECKS) {
/* 1047 */       Checks.check(paramLong2);
/*      */     }
/* 1049 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_respondsToSelector(@NativeType("Class") long paramLong1, @NativeType("SEL") long paramLong2) {
/* 1066 */     long l = Functions.class_respondsToSelector;
/* 1067 */     if (Checks.CHECKS) {
/* 1068 */       Checks.check(paramLong1);
/* 1069 */       Checks.check(paramLong2);
/*      */     } 
/* 1071 */     return JNI.invokePPZ(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_copyMethodList(long paramLong1, long paramLong2) {
/* 1082 */     long l = Functions.class_copyMethodList;
/* 1083 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   
/*      */   @NativeType("Method *")
/*      */   public static PointerBuffer class_copyMethodList(@NativeType("Class") long paramLong) {
/*      */     MemoryStack memoryStack;
/* 1099 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 1100 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 1103 */       return MemoryUtil.memPointerBufferSafe(l = nclass_copyMethodList(paramLong, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 1105 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_conformsToProtocol(@NativeType("Class") long paramLong1, @NativeType("Protocol *") long paramLong2) {
/* 1123 */     long l = Functions.class_conformsToProtocol;
/* 1124 */     if (Checks.CHECKS) {
/* 1125 */       Checks.check(paramLong1);
/* 1126 */       Checks.check(paramLong2);
/*      */     } 
/* 1128 */     return JNI.invokePPZ(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_copyProtocolList(long paramLong1, long paramLong2) {
/* 1139 */     long l = Functions.class_copyProtocolList;
/* 1140 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   
/*      */   @NativeType("Protocol **")
/*      */   public static PointerBuffer class_copyProtocolList(@NativeType("Class") long paramLong) {
/*      */     MemoryStack memoryStack;
/* 1156 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 1157 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 1160 */       return MemoryUtil.memPointerBufferSafe(l = nclass_copyProtocolList(paramLong, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 1162 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getProperty(long paramLong1, long paramLong2) {
/* 1170 */     long l = Functions.class_getProperty;
/* 1171 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   @NativeType("objc_property_t")
/*      */   public static long class_getProperty(@NativeType("Class") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 1185 */     if (Checks.CHECKS) {
/* 1186 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1188 */     return nclass_getProperty(paramLong, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   @NativeType("objc_property_t")
/*      */   public static long class_getProperty(@NativeType("Class") long paramLong, @NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1202 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1204 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1205 */       long l = memoryStack.getPointerAddress();
/* 1206 */       return nclass_getProperty(paramLong, l);
/*      */     } finally {
/* 1208 */       memoryStack.setPointer(i);
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
/*      */   public static long nclass_copyPropertyList(long paramLong1, long paramLong2) {
/* 1220 */     long l = Functions.class_copyPropertyList;
/* 1221 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   
/*      */   @NativeType("objc_property_t *")
/*      */   public static PointerBuffer class_copyPropertyList(@NativeType("Class") long paramLong) {
/*      */     MemoryStack memoryStack;
/* 1237 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 1238 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 1241 */       return MemoryUtil.memPointerBufferSafe(l = nclass_copyPropertyList(paramLong, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 1243 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getIvarLayout(long paramLong) {
/* 1251 */     long l = Functions.class_getIvarLayout;
/* 1252 */     if (Checks.CHECKS) {
/* 1253 */       Checks.check(paramLong);
/*      */     }
/* 1255 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("uint8_t const *")
/*      */   public static String class_getIvarLayout(@NativeType("Class") long paramLong) {
/*      */     long l;
/* 1269 */     return MemoryUtil.memASCIISafe(l = nclass_getIvarLayout(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getWeakIvarLayout(long paramLong) {
/* 1276 */     long l = Functions.class_getWeakIvarLayout;
/* 1277 */     if (Checks.CHECKS) {
/* 1278 */       Checks.check(paramLong);
/*      */     }
/* 1280 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("uint8_t const *")
/*      */   public static String class_getWeakIvarLayout(@NativeType("Class") long paramLong) {
/*      */     long l;
/* 1294 */     return MemoryUtil.memASCIISafe(l = nclass_getWeakIvarLayout(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean nclass_addMethod(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 1301 */     long l = Functions.class_addMethod;
/* 1302 */     if (Checks.CHECKS) {
/* 1303 */       Checks.check(paramLong1);
/* 1304 */       Checks.check(paramLong2);
/* 1305 */       Checks.check(paramLong3);
/*      */     } 
/* 1307 */     return JNI.invokePPPPZ(paramLong1, paramLong2, paramLong3, paramLong4, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addMethod(@NativeType("Class") long paramLong1, @NativeType("SEL") long paramLong2, @NativeType("IMP") long paramLong3, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 1343 */     if (Checks.CHECKS) {
/* 1344 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1346 */     return nclass_addMethod(paramLong1, paramLong2, paramLong3, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addMethod(@NativeType("Class") long paramLong1, @NativeType("SEL") long paramLong2, @NativeType("IMP") long paramLong3, @NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1382 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1384 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1385 */       long l = memoryStack.getPointerAddress();
/* 1386 */       return nclass_addMethod(paramLong1, paramLong2, paramLong3, l);
/*      */     } finally {
/* 1388 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_replaceMethod(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 1396 */     long l = Functions.class_replaceMethod;
/* 1397 */     if (Checks.CHECKS) {
/* 1398 */       Checks.check(paramLong1);
/* 1399 */       Checks.check(paramLong2);
/* 1400 */       Checks.check(paramLong3);
/*      */     } 
/* 1402 */     return JNI.invokePPPPP(paramLong1, paramLong2, paramLong3, paramLong4, l);
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
/*      */   @NativeType("IMP")
/*      */   public static long class_replaceMethod(@NativeType("Class") long paramLong1, @NativeType("SEL") long paramLong2, @NativeType("IMP") long paramLong3, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 1430 */     if (Checks.CHECKS) {
/* 1431 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1433 */     return nclass_replaceMethod(paramLong1, paramLong2, paramLong3, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   @NativeType("IMP")
/*      */   public static long class_replaceMethod(@NativeType("Class") long paramLong1, @NativeType("SEL") long paramLong2, @NativeType("IMP") long paramLong3, @NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1461 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1463 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1464 */       long l = memoryStack.getPointerAddress();
/* 1465 */       return nclass_replaceMethod(paramLong1, paramLong2, paramLong3, l);
/*      */     } finally {
/* 1467 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean nclass_addIvar(long paramLong1, long paramLong2, long paramLong3, byte paramByte, long paramLong4) {
/* 1475 */     long l = Functions.class_addIvar;
/* 1476 */     if (Checks.CHECKS) {
/* 1477 */       Checks.check(paramLong1);
/*      */     }
/* 1479 */     return JNI.invokePPPUPZ(paramLong1, paramLong2, paramLong3, paramByte, paramLong4, l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addIvar(@NativeType("Class") long paramLong1, @NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("size_t") long paramLong2, @NativeType("uint8_t") byte paramByte, @NativeType("char const *") ByteBuffer paramByteBuffer2) {
/* 1497 */     if (Checks.CHECKS) {
/* 1498 */       Checks.checkNT1(paramByteBuffer1);
/* 1499 */       Checks.checkNT1(paramByteBuffer2);
/*      */     } 
/* 1501 */     return nclass_addIvar(paramLong1, MemoryUtil.memAddress(paramByteBuffer1), paramLong2, paramByte, MemoryUtil.memAddress(paramByteBuffer2));
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
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addIvar(@NativeType("Class") long paramLong1, @NativeType("char const *") CharSequence paramCharSequence1, @NativeType("size_t") long paramLong2, @NativeType("uint8_t") byte paramByte, @NativeType("char const *") CharSequence paramCharSequence2) {
/*      */     MemoryStack memoryStack;
/* 1519 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1521 */       memoryStack.nUTF8(paramCharSequence1, true);
/* 1522 */       long l1 = memoryStack.getPointerAddress();
/* 1523 */       memoryStack.nUTF8(paramCharSequence2, true);
/* 1524 */       long l2 = memoryStack.getPointerAddress();
/* 1525 */       return nclass_addIvar(paramLong1, l1, paramLong2, paramByte, l2);
/*      */     } finally {
/* 1527 */       memoryStack.setPointer(i);
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
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addProtocol(@NativeType("Class") long paramLong1, @NativeType("Protocol *") long paramLong2) {
/* 1543 */     long l = Functions.class_addProtocol;
/* 1544 */     if (Checks.CHECKS) {
/* 1545 */       Checks.check(paramLong1);
/* 1546 */       Checks.check(paramLong2);
/*      */     } 
/* 1548 */     return JNI.invokePPZ(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean nclass_addProperty(long paramLong1, long paramLong2, long paramLong3, int paramInt) {
/* 1559 */     long l = Functions.class_addProperty;
/* 1560 */     if (Checks.CHECKS) {
/* 1561 */       Checks.check(paramLong1);
/* 1562 */       Struct.validate(paramLong3, paramInt, ObjCPropertyAttribute.SIZEOF, ObjCPropertyAttribute::validate);
/*      */     } 
/* 1564 */     return JNI.invokePPPZ(paramLong1, paramLong2, paramLong3, paramInt, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addProperty(@NativeType("Class") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer paramBuffer) {
/* 1578 */     if (Checks.CHECKS) {
/* 1579 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1581 */     return nclass_addProperty(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramBuffer.address(), paramBuffer.remaining());
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addProperty(@NativeType("Class") long paramLong, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer paramBuffer) {
/*      */     MemoryStack memoryStack;
/* 1595 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1597 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1598 */       long l = memoryStack.getPointerAddress();
/* 1599 */       return nclass_addProperty(paramLong, l, paramBuffer.address(), paramBuffer.remaining());
/*      */     } finally {
/* 1601 */       memoryStack.setPointer(i);
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
/*      */   public static void nclass_replaceProperty(long paramLong1, long paramLong2, long paramLong3, int paramInt) {
/* 1613 */     long l = Functions.class_replaceProperty;
/* 1614 */     if (Checks.CHECKS) {
/* 1615 */       Checks.check(paramLong1);
/* 1616 */       Struct.validate(paramLong3, paramInt, ObjCPropertyAttribute.SIZEOF, ObjCPropertyAttribute::validate);
/*      */     } 
/* 1618 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void class_replaceProperty(@NativeType("Class") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer paramBuffer) {
/* 1629 */     if (Checks.CHECKS) {
/* 1630 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1632 */     nclass_replaceProperty(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramBuffer.address(), paramBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void class_replaceProperty(@NativeType("Class") long paramLong, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer paramBuffer) {
/*      */     MemoryStack memoryStack;
/* 1643 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1645 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1646 */       long l = memoryStack.getPointerAddress();
/* 1647 */       nclass_replaceProperty(paramLong, l, paramBuffer.address(), paramBuffer.remaining()); return;
/*      */     } finally {
/* 1649 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nclass_setIvarLayout(long paramLong1, long paramLong2) {
/* 1657 */     long l = Functions.class_setIvarLayout;
/* 1658 */     if (Checks.CHECKS) {
/* 1659 */       Checks.check(paramLong1);
/*      */     }
/* 1661 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void class_setIvarLayout(@NativeType("Class") long paramLong, @NativeType("uint8_t const *") ByteBuffer paramByteBuffer) {
/* 1671 */     if (Checks.CHECKS) {
/* 1672 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1674 */     nclass_setIvarLayout(paramLong, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void class_setIvarLayout(@NativeType("Class") long paramLong, @NativeType("uint8_t const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1684 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1686 */       memoryStack.nASCII(paramCharSequence, true);
/* 1687 */       long l = memoryStack.getPointerAddress();
/* 1688 */       nclass_setIvarLayout(paramLong, l); return;
/*      */     } finally {
/* 1690 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nclass_setWeakIvarLayout(long paramLong1, long paramLong2) {
/* 1698 */     long l = Functions.class_setWeakIvarLayout;
/* 1699 */     if (Checks.CHECKS) {
/* 1700 */       Checks.check(paramLong1);
/*      */     }
/* 1702 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void class_setWeakIvarLayout(@NativeType("Class") long paramLong, @NativeType("uint8_t const *") ByteBuffer paramByteBuffer) {
/* 1712 */     if (Checks.CHECKS) {
/* 1713 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1715 */     nclass_setWeakIvarLayout(paramLong, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void class_setWeakIvarLayout(@NativeType("Class") long paramLong, @NativeType("uint8_t const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1725 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1727 */       memoryStack.nASCII(paramCharSequence, true);
/* 1728 */       long l = memoryStack.getPointerAddress();
/* 1729 */       nclass_setWeakIvarLayout(paramLong, l); return;
/*      */     } finally {
/* 1731 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */   
/*      */   @NativeType("id")
/*      */   public static long class_createInstance(@NativeType("Class") long paramLong1, @NativeType("size_t") long paramLong2) {
/* 1748 */     long l = Functions.class_createInstance;
/* 1749 */     if (Checks.CHECKS) {
/* 1750 */       Checks.check(paramLong1);
/*      */     }
/* 1752 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_constructInstance(long paramLong1, long paramLong2) {
/* 1759 */     long l = Functions.objc_constructInstance;
/* 1760 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   @NativeType("id")
/*      */   public static long objc_constructInstance(@NativeType("Class") long paramLong, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1774 */     if (Checks.CHECKS && 
/* 1775 */       Checks.DEBUG) {
/* 1776 */       Checks.checkSafe(paramByteBuffer, class_getInstanceSize(paramLong));
/*      */     }
/*      */     
/* 1779 */     return nobjc_constructInstance(paramLong, MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long objc_destructInstance(@NativeType("id") long paramLong) {
/* 1798 */     long l = Functions.objc_destructInstance;
/* 1799 */     if (Checks.CHECKS) {
/* 1800 */       Checks.check(paramLong);
/*      */     }
/* 1802 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_allocateClassPair(long paramLong1, long paramLong2, long paramLong3) {
/* 1809 */     long l = Functions.objc_allocateClassPair;
/* 1810 */     return JNI.invokePPPP(paramLong1, paramLong2, paramLong3, l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_allocateClassPair(@NativeType("Class") long paramLong1, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("size_t") long paramLong2) {
/* 1831 */     if (Checks.CHECKS) {
/* 1832 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1834 */     return nobjc_allocateClassPair(paramLong1, MemoryUtil.memAddress(paramByteBuffer), paramLong2);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_allocateClassPair(@NativeType("Class") long paramLong1, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("size_t") long paramLong2) {
/*      */     MemoryStack memoryStack;
/* 1855 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1857 */       memoryStack.nUTF8(paramCharSequence, true);
/* 1858 */       long l = memoryStack.getPointerAddress();
/* 1859 */       return nobjc_allocateClassPair(paramLong1, l, paramLong2);
/*      */     } finally {
/* 1861 */       memoryStack.setPointer(i);
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
/*      */   public static void objc_registerClassPair(@NativeType("Class") long paramLong) {
/* 1873 */     long l = Functions.objc_registerClassPair;
/* 1874 */     if (Checks.CHECKS) {
/* 1875 */       Checks.check(paramLong);
/*      */     }
/* 1877 */     JNI.invokePV(paramLong, l);
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
/*      */   public static void objc_disposeClassPair(@NativeType("Class") long paramLong) {
/* 1890 */     long l = Functions.objc_disposeClassPair;
/* 1891 */     if (Checks.CHECKS) {
/* 1892 */       Checks.check(paramLong);
/*      */     }
/* 1894 */     JNI.invokePV(paramLong, l);
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
/*      */ 
/*      */   
/*      */   @NativeType("SEL")
/*      */   public static long method_getName(@NativeType("Method") long paramLong) {
/* 1910 */     long l = Functions.method_getName;
/* 1911 */     if (Checks.CHECKS) {
/* 1912 */       Checks.check(paramLong);
/*      */     }
/* 1914 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("IMP")
/*      */   public static long method_getImplementation(@NativeType("Method") long paramLong) {
/* 1928 */     long l = Functions.method_getImplementation;
/* 1929 */     if (Checks.CHECKS) {
/* 1930 */       Checks.check(paramLong);
/*      */     }
/* 1932 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmethod_getTypeEncoding(long paramLong) {
/* 1939 */     long l = Functions.method_getTypeEncoding;
/* 1940 */     if (Checks.CHECKS) {
/* 1941 */       Checks.check(paramLong);
/*      */     }
/* 1943 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char const *")
/*      */   public static String method_getTypeEncoding(@NativeType("Method") long paramLong) {
/*      */     long l;
/* 1957 */     return MemoryUtil.memUTF8Safe(l = nmethod_getTypeEncoding(paramLong));
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
/*      */   @NativeType("unsigned int")
/*      */   public static int method_getNumberOfArguments(@NativeType("Method") long paramLong) {
/* 1971 */     long l = Functions.method_getNumberOfArguments;
/* 1972 */     if (Checks.CHECKS) {
/* 1973 */       Checks.check(paramLong);
/*      */     }
/* 1975 */     return JNI.invokePI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmethod_copyReturnType(long paramLong) {
/* 1982 */     long l = Functions.method_copyReturnType;
/* 1983 */     if (Checks.CHECKS) {
/* 1984 */       Checks.check(paramLong);
/*      */     }
/* 1986 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char *")
/*      */   public static String method_copyReturnType(@NativeType("Method") long paramLong) {
/*      */     long l;
/* 2000 */     return MemoryUtil.memUTF8Safe(l = nmethod_copyReturnType(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmethod_copyArgumentType(long paramLong, int paramInt) {
/* 2007 */     long l = Functions.method_copyArgumentType;
/* 2008 */     if (Checks.CHECKS) {
/* 2009 */       Checks.check(paramLong);
/*      */     }
/* 2011 */     return JNI.invokePP(paramLong, paramInt, l);
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
/*      */   
/*      */   @NativeType("char *")
/*      */   public static String method_copyArgumentType(@NativeType("Method") long paramLong, @NativeType("unsigned int") int paramInt) {
/* 2026 */     long l = 0L;
/*      */     
/*      */     try {
/* 2029 */       return MemoryUtil.memUTF8Safe(l = nmethod_copyArgumentType(paramLong, paramInt));
/*      */     } finally {
/* 2031 */       if (l != 0L) LibCStdlib.nfree(l);
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nmethod_getReturnType(long paramLong1, long paramLong2, long paramLong3) {
/* 2043 */     long l = Functions.method_getReturnType;
/* 2044 */     if (Checks.CHECKS) {
/* 2045 */       Checks.check(paramLong1);
/*      */     }
/* 2047 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
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
/*      */   public static void method_getReturnType(@NativeType("Method") long paramLong, @NativeType("char *") ByteBuffer paramByteBuffer) {
/* 2059 */     nmethod_getReturnType(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String method_getReturnType(@NativeType("Method") long paramLong1, @NativeType("size_t") long paramLong2) {
/*      */     MemoryStack memoryStack;
/* 2072 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2074 */       ByteBuffer byteBuffer = memoryStack.malloc((int)paramLong2);
/* 2075 */       nmethod_getReturnType(paramLong1, MemoryUtil.memAddress(byteBuffer), paramLong2);
/* 2076 */       return MemoryUtil.memUTF8(MemoryUtil.memByteBufferNT1(MemoryUtil.memAddress(byteBuffer), (int)paramLong2));
/*      */     } finally {
/* 2078 */       memoryStack.setPointer(i);
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
/*      */   public static void nmethod_getArgumentType(long paramLong1, int paramInt, long paramLong2, long paramLong3) {
/* 2090 */     long l = Functions.method_getArgumentType;
/* 2091 */     if (Checks.CHECKS) {
/* 2092 */       Checks.check(paramLong1);
/*      */     }
/* 2094 */     JNI.invokePPPV(paramLong1, paramInt, paramLong2, paramLong3, l);
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
/*      */   
/*      */   public static void method_getArgumentType(@NativeType("Method") long paramLong, @NativeType("unsigned int") int paramInt, @NativeType("char *") ByteBuffer paramByteBuffer) {
/* 2108 */     nmethod_getArgumentType(paramLong, paramInt, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining());
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
/*      */   @NativeType("void")
/*      */   public static String method_getArgumentType(@NativeType("Method") long paramLong1, @NativeType("unsigned int") int paramInt, @NativeType("size_t") long paramLong2) {
/*      */     MemoryStack memoryStack;
/* 2123 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2125 */       ByteBuffer byteBuffer = memoryStack.malloc((int)paramLong2);
/* 2126 */       nmethod_getArgumentType(paramLong1, paramInt, MemoryUtil.memAddress(byteBuffer), paramLong2);
/* 2127 */       return MemoryUtil.memUTF8(MemoryUtil.memByteBufferNT1(MemoryUtil.memAddress(byteBuffer), (int)paramLong2));
/*      */     } finally {
/* 2129 */       memoryStack.setPointer(i);
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
/*      */   
/*      */   @NativeType("IMP")
/*      */   public static long method_setImplementation(@NativeType("Method") long paramLong1, @NativeType("IMP") long paramLong2) {
/* 2145 */     long l = Functions.method_setImplementation;
/* 2146 */     if (Checks.CHECKS) {
/* 2147 */       Checks.check(paramLong1);
/* 2148 */       Checks.check(paramLong2);
/*      */     } 
/* 2150 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   public static void method_exchangeImplementations(@NativeType("Method") long paramLong1, @NativeType("Method") long paramLong2) {
/* 2162 */     long l = Functions.method_exchangeImplementations;
/* 2163 */     if (Checks.CHECKS) {
/* 2164 */       Checks.check(paramLong1);
/* 2165 */       Checks.check(paramLong2);
/*      */     } 
/* 2167 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nivar_getName(long paramLong) {
/* 2174 */     long l = Functions.ivar_getName;
/* 2175 */     if (Checks.CHECKS) {
/* 2176 */       Checks.check(paramLong);
/*      */     }
/* 2178 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char const *")
/*      */   public static String ivar_getName(@NativeType("Ivar") long paramLong) {
/*      */     long l;
/* 2192 */     return MemoryUtil.memUTF8Safe(l = nivar_getName(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nivar_getTypeEncoding(long paramLong) {
/* 2199 */     long l = Functions.ivar_getTypeEncoding;
/* 2200 */     if (Checks.CHECKS) {
/* 2201 */       Checks.check(paramLong);
/*      */     }
/* 2203 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char const *")
/*      */   public static String ivar_getTypeEncoding(@NativeType("Ivar") long paramLong) {
/*      */     long l;
/* 2217 */     return MemoryUtil.memUTF8Safe(l = nivar_getTypeEncoding(paramLong));
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
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ptrdiff_t")
/*      */   public static long ivar_getOffset(@NativeType("Ivar") long paramLong) {
/* 2234 */     long l = Functions.ivar_getOffset;
/* 2235 */     if (Checks.CHECKS) {
/* 2236 */       Checks.check(paramLong);
/*      */     }
/* 2238 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nproperty_getName(long paramLong) {
/* 2245 */     long l = Functions.property_getName;
/* 2246 */     if (Checks.CHECKS) {
/* 2247 */       Checks.check(paramLong);
/*      */     }
/* 2249 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char const *")
/*      */   public static String property_getName(@NativeType("objc_property_t") long paramLong) {
/*      */     long l;
/* 2263 */     return MemoryUtil.memUTF8Safe(l = nproperty_getName(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nproperty_getAttributes(long paramLong) {
/* 2270 */     long l = Functions.property_getAttributes;
/* 2271 */     if (Checks.CHECKS) {
/* 2272 */       Checks.check(paramLong);
/*      */     }
/* 2274 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char const *")
/*      */   public static String property_getAttributes(@NativeType("objc_property_t") long paramLong) {
/*      */     long l;
/* 2288 */     return MemoryUtil.memUTF8Safe(l = nproperty_getAttributes(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nproperty_copyAttributeList(long paramLong1, long paramLong2) {
/* 2299 */     long l = Functions.property_copyAttributeList;
/* 2300 */     if (Checks.CHECKS) {
/* 2301 */       Checks.check(paramLong1);
/*      */     }
/* 2303 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("objc_property_attribute_t *")
/*      */   public static ObjCPropertyAttribute.Buffer property_copyAttributeList(@NativeType("objc_property_t") long paramLong) {
/*      */     MemoryStack memoryStack;
/* 2316 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 2317 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 2320 */       return ObjCPropertyAttribute.createSafe(l = nproperty_copyAttributeList(paramLong, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 2322 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nproperty_copyAttributeValue(long paramLong1, long paramLong2) {
/* 2330 */     long l = Functions.property_copyAttributeValue;
/* 2331 */     if (Checks.CHECKS) {
/* 2332 */       Checks.check(paramLong1);
/*      */     }
/* 2334 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   
/*      */   @NativeType("char *")
/*      */   public static String property_copyAttributeValue(@NativeType("objc_property_t") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 2349 */     if (Checks.CHECKS) {
/* 2350 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 2352 */     long l = 0L;
/*      */     
/*      */     try {
/* 2355 */       return MemoryUtil.memUTF8Safe(l = nproperty_copyAttributeValue(paramLong, MemoryUtil.memAddress(paramByteBuffer)));
/*      */     } finally {
/* 2357 */       if (l != 0L) LibCStdlib.nfree(l);
/*      */     
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
/*      */   @NativeType("char *")
/*      */   public static String property_copyAttributeValue(@NativeType("objc_property_t") long paramLong, @NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 2373 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 2374 */     long l = 0L;
/*      */     try {
/* 2376 */       memoryStack.nUTF8(paramCharSequence, true);
/* 2377 */       long l1 = memoryStack.getPointerAddress();
/*      */       
/* 2379 */       return MemoryUtil.memUTF8Safe(l = nproperty_copyAttributeValue(paramLong, l1));
/*      */     } finally {
/* 2381 */       if (l != 0L) LibCStdlib.nfree(l); 
/* 2382 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_getProtocol(long paramLong) {
/* 2390 */     long l = Functions.objc_getProtocol;
/* 2391 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("Protocol *")
/*      */   public static long objc_getProtocol(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 2405 */     if (Checks.CHECKS) {
/* 2406 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 2408 */     return nobjc_getProtocol(MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   @NativeType("Protocol *")
/*      */   public static long objc_getProtocol(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 2422 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2424 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       long l;
/* 2426 */       return nobjc_getProtocol(l = memoryStack.getPointerAddress());
/*      */     } finally {
/* 2428 */       memoryStack.setPointer(i);
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
/*      */   public static long nobjc_copyProtocolList(long paramLong) {
/* 2440 */     long l = Functions.objc_copyProtocolList;
/* 2441 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Protocol **")
/*      */   public static PointerBuffer objc_copyProtocolList() {
/*      */     MemoryStack memoryStack;
/* 2453 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 2454 */     null = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 2457 */       return MemoryUtil.memPointerBufferSafe(l = nobjc_copyProtocolList(MemoryUtil.memAddress(null)), null.get(0));
/*      */     } finally {
/* 2459 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean protocol_conformsToProtocol(@NativeType("Protocol *") long paramLong1, @NativeType("Protocol *") long paramLong2) {
/* 2483 */     long l = Functions.protocol_conformsToProtocol;
/* 2484 */     if (Checks.CHECKS) {
/* 2485 */       Checks.check(paramLong1);
/* 2486 */       Checks.check(paramLong2);
/*      */     } 
/* 2488 */     return JNI.invokePPZ(paramLong1, paramLong2, l);
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
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean protocol_isEqual(@NativeType("Protocol *") long paramLong1, @NativeType("Protocol *") long paramLong2) {
/* 2503 */     long l = Functions.protocol_isEqual;
/* 2504 */     if (Checks.CHECKS) {
/* 2505 */       Checks.check(paramLong1);
/* 2506 */       Checks.check(paramLong2);
/*      */     } 
/* 2508 */     return JNI.invokePPZ(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nprotocol_getName(long paramLong) {
/* 2515 */     long l = Functions.protocol_getName;
/* 2516 */     if (Checks.CHECKS) {
/* 2517 */       Checks.check(paramLong);
/*      */     }
/* 2519 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char const *")
/*      */   public static String protocol_getName(@NativeType("Protocol *") long paramLong) {
/*      */     long l;
/* 2533 */     return MemoryUtil.memUTF8Safe(l = nprotocol_getName(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nprotocol_getMethodDescription(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, long paramLong3) {
/* 2543 */     long l = Functions.protocol_getMethodDescription;
/* 2544 */     if (Checks.CHECKS) {
/* 2545 */       Checks.check(paramLong1);
/* 2546 */       Checks.check(paramLong2);
/*      */     } 
/* 2548 */     nprotocol_getMethodDescription(paramLong1, paramLong2, paramBoolean1, paramBoolean2, l, paramLong3);
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
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct objc_method_description")
/*      */   public static ObjCMethodDescription protocol_getMethodDescription(@NativeType("Protocol *") long paramLong1, @NativeType("SEL") long paramLong2, @NativeType("BOOL") boolean paramBoolean1, @NativeType("BOOL") boolean paramBoolean2, @NativeType("struct objc_method_description") ObjCMethodDescription paramObjCMethodDescription) {
/* 2565 */     nprotocol_getMethodDescription(paramLong1, paramLong2, paramBoolean1, paramBoolean2, paramObjCMethodDescription.address());
/* 2566 */     return paramObjCMethodDescription;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nprotocol_copyMethodDescriptionList(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2) {
/* 2577 */     long l = Functions.protocol_copyMethodDescriptionList;
/* 2578 */     if (Checks.CHECKS) {
/* 2579 */       Checks.check(paramLong1);
/*      */     }
/* 2581 */     return JNI.invokePPP(paramLong1, paramBoolean1, paramBoolean2, paramLong2, l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct objc_method_description *")
/*      */   public static ObjCMethodDescription.Buffer protocol_copyMethodDescriptionList(@NativeType("Protocol *") long paramLong, @NativeType("BOOL") boolean paramBoolean1, @NativeType("BOOL") boolean paramBoolean2) {
/*      */     MemoryStack memoryStack;
/* 2601 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 2602 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 2605 */       return ObjCMethodDescription.createSafe(l = nprotocol_copyMethodDescriptionList(paramLong, paramBoolean1, paramBoolean2, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 2607 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nprotocol_getProperty(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {
/* 2615 */     long l = Functions.protocol_getProperty;
/* 2616 */     if (Checks.CHECKS) {
/* 2617 */       Checks.check(paramLong1);
/*      */     }
/* 2619 */     return JNI.invokePPP(paramLong1, paramLong2, paramBoolean1, paramBoolean2, l);
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
/*      */ 
/*      */   
/*      */   @NativeType("objc_property_t")
/*      */   public static long protocol_getProperty(@NativeType("Protocol *") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("BOOL") boolean paramBoolean1, @NativeType("BOOL") boolean paramBoolean2) {
/* 2635 */     if (Checks.CHECKS) {
/* 2636 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 2638 */     return nprotocol_getProperty(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramBoolean1, paramBoolean2);
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
/*      */   
/*      */   @NativeType("objc_property_t")
/*      */   public static long protocol_getProperty(@NativeType("Protocol *") long paramLong, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("BOOL") boolean paramBoolean1, @NativeType("BOOL") boolean paramBoolean2) {
/*      */     MemoryStack memoryStack;
/* 2654 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2656 */       memoryStack.nUTF8(paramCharSequence, true);
/* 2657 */       long l = memoryStack.getPointerAddress();
/* 2658 */       return nprotocol_getProperty(paramLong, l, paramBoolean1, paramBoolean2);
/*      */     } finally {
/* 2660 */       memoryStack.setPointer(i);
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
/*      */   public static long nprotocol_copyPropertyList(long paramLong1, long paramLong2) {
/* 2672 */     long l = Functions.protocol_copyPropertyList;
/* 2673 */     if (Checks.CHECKS) {
/* 2674 */       Checks.check(paramLong1);
/*      */     }
/* 2676 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   
/*      */   @NativeType("objc_property_t *")
/*      */   public static PointerBuffer protocol_copyPropertyList(@NativeType("Protocol *") long paramLong) {
/*      */     MemoryStack memoryStack;
/* 2692 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 2693 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 2696 */       return MemoryUtil.memPointerBufferSafe(l = nprotocol_copyPropertyList(paramLong, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 2698 */       memoryStack.setPointer(i);
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
/*      */   public static long nprotocol_copyProtocolList(long paramLong1, long paramLong2) {
/* 2710 */     long l = Functions.protocol_copyProtocolList;
/* 2711 */     if (Checks.CHECKS) {
/* 2712 */       Checks.check(paramLong1);
/*      */     }
/* 2714 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   
/*      */   @NativeType("Protocol **")
/*      */   public static PointerBuffer protocol_copyProtocolList(@NativeType("Protocol *") long paramLong) {
/*      */     MemoryStack memoryStack;
/* 2730 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 2731 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 2734 */       return MemoryUtil.memPointerBufferSafe(l = nprotocol_copyProtocolList(paramLong, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 2736 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_allocateProtocol(long paramLong) {
/* 2744 */     long l = Functions.objc_allocateProtocol;
/* 2745 */     return JNI.invokePP(paramLong, l);
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
/*      */ 
/*      */   
/*      */   @NativeType("Protocol *")
/*      */   public static long objc_allocateProtocol(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 2761 */     if (Checks.CHECKS) {
/* 2762 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 2764 */     return nobjc_allocateProtocol(MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   
/*      */   @NativeType("Protocol *")
/*      */   public static long objc_allocateProtocol(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 2780 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2782 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       long l;
/* 2784 */       return nobjc_allocateProtocol(l = memoryStack.getPointerAddress());
/*      */     } finally {
/* 2786 */       memoryStack.setPointer(i);
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
/*      */   
/*      */   public static void objc_registerProtocol(@NativeType("Protocol *") long paramLong) {
/* 2801 */     long l = Functions.objc_registerProtocol;
/* 2802 */     if (Checks.CHECKS) {
/* 2803 */       Checks.check(paramLong);
/*      */     }
/* 2805 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nprotocol_addMethodDescription(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean1, boolean paramBoolean2) {
/* 2812 */     long l = Functions.protocol_addMethodDescription;
/* 2813 */     if (Checks.CHECKS) {
/* 2814 */       Checks.check(paramLong1);
/* 2815 */       Checks.check(paramLong2);
/*      */     } 
/* 2817 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, paramBoolean1, paramBoolean2, l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void protocol_addMethodDescription(@NativeType("Protocol *") long paramLong1, @NativeType("SEL") long paramLong2, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("BOOL") boolean paramBoolean1, @NativeType("BOOL") boolean paramBoolean2) {
/* 2834 */     if (Checks.CHECKS) {
/* 2835 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 2837 */     nprotocol_addMethodDescription(paramLong1, paramLong2, MemoryUtil.memAddress(paramByteBuffer), paramBoolean1, paramBoolean2);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static void protocol_addMethodDescription(@NativeType("Protocol *") long paramLong1, @NativeType("SEL") long paramLong2, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("BOOL") boolean paramBoolean1, @NativeType("BOOL") boolean paramBoolean2) {
/*      */     MemoryStack memoryStack;
/* 2854 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2856 */       memoryStack.nUTF8(paramCharSequence, true);
/* 2857 */       long l = memoryStack.getPointerAddress();
/* 2858 */       nprotocol_addMethodDescription(paramLong1, paramLong2, l, paramBoolean1, paramBoolean2); return;
/*      */     } finally {
/* 2860 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */   
/*      */   public static void protocol_addProtocol(@NativeType("Protocol *") long paramLong1, @NativeType("Protocol *") long paramLong2) {
/* 2876 */     long l = Functions.protocol_addProtocol;
/* 2877 */     if (Checks.CHECKS) {
/* 2878 */       Checks.check(paramLong1);
/* 2879 */       Checks.check(paramLong2);
/*      */     } 
/* 2881 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nprotocol_addProperty(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 2892 */     long l = Functions.protocol_addProperty;
/* 2893 */     if (Checks.CHECKS) {
/* 2894 */       Checks.check(paramLong1);
/* 2895 */       Struct.validate(paramLong3, paramInt, ObjCPropertyAttribute.SIZEOF, ObjCPropertyAttribute::validate);
/*      */     } 
/* 2897 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, paramInt, paramBoolean1, paramBoolean2, l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void protocol_addProperty(@NativeType("Protocol *") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer paramBuffer, @NativeType("BOOL") boolean paramBoolean1, @NativeType("BOOL") boolean paramBoolean2) {
/* 2915 */     if (Checks.CHECKS) {
/* 2916 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 2918 */     nprotocol_addProperty(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramBuffer.address(), paramBuffer.remaining(), paramBoolean1, paramBoolean2);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void protocol_addProperty(@NativeType("Protocol *") long paramLong, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer paramBuffer, @NativeType("BOOL") boolean paramBoolean1, @NativeType("BOOL") boolean paramBoolean2) {
/*      */     MemoryStack memoryStack;
/* 2936 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2938 */       memoryStack.nUTF8(paramCharSequence, true);
/* 2939 */       long l = memoryStack.getPointerAddress();
/* 2940 */       nprotocol_addProperty(paramLong, l, paramBuffer.address(), paramBuffer.remaining(), paramBoolean1, paramBoolean2); return;
/*      */     } finally {
/* 2942 */       memoryStack.setPointer(i);
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
/*      */   public static long nobjc_copyImageNames(long paramLong) {
/* 2954 */     long l = Functions.objc_copyImageNames;
/* 2955 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("char const **")
/*      */   public static PointerBuffer objc_copyImageNames() {
/*      */     MemoryStack memoryStack;
/* 2966 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 2967 */     null = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 2970 */       return MemoryUtil.memPointerBufferSafe(l = nobjc_copyImageNames(MemoryUtil.memAddress(null)), null.get(0));
/*      */     } finally {
/* 2972 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getImageName(long paramLong) {
/* 2980 */     long l = Functions.class_getImageName;
/* 2981 */     if (Checks.CHECKS) {
/* 2982 */       Checks.check(paramLong);
/*      */     }
/* 2984 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char const *")
/*      */   public static String class_getImageName(@NativeType("Class") long paramLong) {
/*      */     long l;
/* 2998 */     return MemoryUtil.memUTF8Safe(l = nclass_getImageName(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_copyClassNamesForImage(long paramLong1, long paramLong2) {
/* 3009 */     long l = Functions.objc_copyClassNamesForImage;
/* 3010 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   @NativeType("char const **")
/*      */   public static PointerBuffer objc_copyClassNamesForImage(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 3023 */     if (Checks.CHECKS)
/* 3024 */       Checks.checkNT1(paramByteBuffer); 
/*      */     MemoryStack memoryStack;
/* 3026 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 3027 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */     try {
/*      */       long l;
/* 3030 */       return MemoryUtil.memPointerBufferSafe(l = nobjc_copyClassNamesForImage(MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 3032 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("char const **")
/*      */   public static PointerBuffer objc_copyClassNamesForImage(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 3046 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3048 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3049 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       
/*      */       long l1, l2;
/* 3052 */       return MemoryUtil.memPointerBufferSafe(l2 = nobjc_copyClassNamesForImage(l1 = memoryStack.getPointerAddress(), MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*      */     } finally {
/* 3054 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nsel_getName(long paramLong) {
/* 3062 */     long l = Functions.sel_getName;
/* 3063 */     if (Checks.CHECKS) {
/* 3064 */       Checks.check(paramLong);
/*      */     }
/* 3066 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("char const *")
/*      */   public static String sel_getName(@NativeType("SEL") long paramLong) {
/*      */     long l;
/* 3080 */     return MemoryUtil.memUTF8Safe(l = nsel_getName(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nsel_getUid(long paramLong) {
/* 3087 */     long l = Functions.sel_getUid;
/* 3088 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("SEL")
/*      */   public static long sel_getUid(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 3102 */     if (Checks.CHECKS) {
/* 3103 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 3105 */     return nsel_getUid(MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   @NativeType("SEL")
/*      */   public static long sel_getUid(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 3119 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3121 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       long l;
/* 3123 */       return nsel_getUid(l = memoryStack.getPointerAddress());
/*      */     } finally {
/* 3125 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nsel_registerName(long paramLong) {
/* 3133 */     long l = Functions.sel_registerName;
/* 3134 */     return JNI.invokePP(paramLong, l);
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
/*      */   
/*      */   @NativeType("SEL")
/*      */   public static long sel_registerName(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 3149 */     if (Checks.CHECKS) {
/* 3150 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 3152 */     return nsel_registerName(MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   @NativeType("SEL")
/*      */   public static long sel_registerName(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 3167 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3169 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       long l;
/* 3171 */       return nsel_registerName(l = memoryStack.getPointerAddress());
/*      */     } finally {
/* 3173 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean sel_isEqual(@NativeType("SEL") long paramLong1, @NativeType("SEL") long paramLong2) {
/* 3191 */     long l = Functions.sel_isEqual;
/* 3192 */     if (Checks.CHECKS) {
/* 3193 */       Checks.check(paramLong1);
/* 3194 */       Checks.check(paramLong2);
/*      */     } 
/* 3196 */     return JNI.invokePPZ(paramLong1, paramLong2, l);
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
/*      */ 
/*      */   
/*      */   public static void objc_enumerationMutation(@NativeType("id") long paramLong) {
/* 3211 */     long l = Functions.objc_enumerationMutation;
/* 3212 */     if (Checks.CHECKS) {
/* 3213 */       Checks.check(paramLong);
/*      */     }
/* 3215 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nobjc_setEnumerationMutationHandler(long paramLong) {
/* 3222 */     long l = Functions.objc_setEnumerationMutationHandler;
/* 3223 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void objc_setEnumerationMutationHandler(@NativeType("EnumerationMutationHandler") EnumerationMutationHandlerI paramEnumerationMutationHandlerI) {
/* 3232 */     nobjc_setEnumerationMutationHandler(paramEnumerationMutationHandlerI.address());
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
/*      */   
/*      */   @NativeType("IMP")
/*      */   public static long imp_implementationWithBlock(@NativeType("id") long paramLong) {
/* 3247 */     long l = Functions.imp_implementationWithBlock;
/* 3248 */     if (Checks.CHECKS) {
/* 3249 */       Checks.check(paramLong);
/*      */     }
/* 3251 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("id")
/*      */   public static long imp_getBlock(@NativeType("IMP") long paramLong) {
/* 3265 */     long l = Functions.imp_getBlock;
/* 3266 */     if (Checks.CHECKS) {
/* 3267 */       Checks.check(paramLong);
/*      */     }
/* 3269 */     return JNI.invokePP(paramLong, l);
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
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean imp_removeBlock(@NativeType("IMP") long paramLong) {
/* 3284 */     long l = Functions.imp_removeBlock;
/* 3285 */     if (Checks.CHECKS) {
/* 3286 */       Checks.check(paramLong);
/*      */     }
/* 3288 */     return JNI.invokePZ(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_loadWeak(long paramLong) {
/* 3295 */     long l = Functions.objc_loadWeak;
/* 3296 */     return JNI.invokePP(paramLong, l);
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
/*      */   
/*      */   @NativeType("id")
/*      */   public static long objc_loadWeak(@NativeType("id *") PointerBuffer paramPointerBuffer) {
/* 3311 */     if (Checks.CHECKS) {
/* 3312 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 3314 */     return nobjc_loadWeak(MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_storeWeak(long paramLong1, long paramLong2) {
/* 3321 */     long l = Functions.objc_storeWeak;
/* 3322 */     if (Checks.CHECKS) {
/* 3323 */       Checks.check(paramLong2);
/*      */     }
/* 3325 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   
/*      */   @NativeType("id")
/*      */   public static long objc_storeWeak(@NativeType("id *") PointerBuffer paramPointerBuffer, @NativeType("id") long paramLong) {
/* 3340 */     if (Checks.CHECKS) {
/* 3341 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 3343 */     return nobjc_storeWeak(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramLong);
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
/*      */   
/*      */   public static void objc_setAssociatedObject(@NativeType("id") long paramLong1, @NativeType("void const *") long paramLong2, @NativeType("id") long paramLong3, @NativeType("objc_AssociationPolicy") long paramLong4) {
/* 3357 */     long l = Functions.objc_setAssociatedObject;
/* 3358 */     if (Checks.CHECKS) {
/* 3359 */       Checks.check(paramLong1);
/* 3360 */       Checks.check(paramLong2);
/* 3361 */       Checks.check(paramLong3);
/*      */     } 
/* 3363 */     JNI.invokePPPPV(paramLong1, paramLong2, paramLong3, paramLong4, l);
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
/*      */   
/*      */   @NativeType("id")
/*      */   public static long objc_getAssociatedObject(@NativeType("id") long paramLong1, @NativeType("void const *") long paramLong2) {
/* 3378 */     long l = Functions.objc_getAssociatedObject;
/* 3379 */     if (Checks.CHECKS) {
/* 3380 */       Checks.check(paramLong1);
/* 3381 */       Checks.check(paramLong2);
/*      */     } 
/* 3383 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */ 
/*      */   
/*      */   public static void objc_removeAssociatedObjects(@NativeType("id") long paramLong) {
/* 3398 */     long l = Functions.objc_removeAssociatedObjects;
/* 3399 */     if (Checks.CHECKS) {
/* 3400 */       Checks.check(paramLong);
/*      */     }
/* 3402 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */   
/*      */   public static native void nprotocol_getMethodDescription(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, long paramLong3, long paramLong4);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\ObjCRuntime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */