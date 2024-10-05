/*     */ package net.bytebuddy.implementation;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.Duplication;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*     */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
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
/*     */ @Enhance
/*     */ public class ToStringMethod
/*     */   implements Implementation
/*     */ {
/*  53 */   private static final MethodDescription.InDefinedShape STRING_BUILDER_CONSTRUCTOR = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(StringBuilder.class)
/*  54 */     .getDeclaredMethods()
/*  55 */     .filter((ElementMatcher)ElementMatchers.isConstructor().and((ElementMatcher)ElementMatchers.takesArguments(new Class[] { String.class
/*  56 */           })))).getOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   private static final MethodDescription.InDefinedShape TO_STRING = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(StringBuilder.class)
/*  62 */     .getDeclaredMethods()
/*  63 */     .filter((ElementMatcher)ElementMatchers.isToString()))
/*  64 */     .getOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final PrefixResolver prefixResolver;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String start;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String end;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String separator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String definer;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ToStringMethod(PrefixResolver paramPrefixResolver) {
/* 102 */     this(paramPrefixResolver, "{", "}", ", ", "=", ElementMatchers.none());
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
/*     */   private ToStringMethod(PrefixResolver paramPrefixResolver, String paramString1, String paramString2, String paramString3, String paramString4, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> paramJunction) {
/* 121 */     this.prefixResolver = paramPrefixResolver;
/* 122 */     this.start = paramString1;
/* 123 */     this.end = paramString2;
/* 124 */     this.separator = paramString3;
/* 125 */     this.definer = paramString4;
/* 126 */     this.ignored = paramJunction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ToStringMethod prefixedByFullyQualifiedClassName() {
/* 135 */     return prefixedBy(PrefixResolver.Default.FULLY_QUALIFIED_CLASS_NAME);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ToStringMethod prefixedByCanonicalClassName() {
/* 144 */     return prefixedBy(PrefixResolver.Default.CANONICAL_CLASS_NAME);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ToStringMethod prefixedBySimpleClassName() {
/* 153 */     return prefixedBy(PrefixResolver.Default.SIMPLE_CLASS_NAME);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ToStringMethod prefixedBy(String paramString) {
/* 163 */     if (paramString == null) {
/* 164 */       throw new IllegalArgumentException("Prefix cannot be null");
/*     */     }
/* 166 */     return prefixedBy(new PrefixResolver.ForFixedValue(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ToStringMethod prefixedBy(PrefixResolver paramPrefixResolver) {
/* 176 */     return new ToStringMethod(paramPrefixResolver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ToStringMethod withIgnoredFields(ElementMatcher<? super FieldDescription.InDefinedShape> paramElementMatcher) {
/* 187 */     return new ToStringMethod(this.prefixResolver, this.start, this.end, this.separator, this.definer, this.ignored.or(paramElementMatcher));
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
/*     */   public Implementation withTokens(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 200 */     if (paramString1 == null || paramString2 == null || paramString3 == null || paramString4 == null) {
/* 201 */       throw new IllegalArgumentException("Token values cannot be null");
/*     */     }
/* 203 */     return new ToStringMethod(this.prefixResolver, paramString1, paramString2, paramString3, paramString4, this.ignored);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InstrumentedType prepare(InstrumentedType paramInstrumentedType) {
/* 210 */     return paramInstrumentedType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Appender appender(Implementation.Target paramTarget) {
/* 217 */     if (paramTarget.getInstrumentedType().isInterface()) {
/* 218 */       throw new IllegalStateException("Cannot implement meaningful toString method for " + paramTarget.getInstrumentedType());
/*     */     }
/*     */     String str;
/* 221 */     if ((str = this.prefixResolver.resolve(paramTarget.getInstrumentedType())) == null) {
/* 222 */       throw new IllegalStateException("Prefix for toString method cannot be null");
/*     */     }
/* 224 */     return new Appender(str, this.start, this.end, this.separator, this.definer, (List<? extends FieldDescription.InDefinedShape>)paramTarget
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 229 */         .getInstrumentedType().getDeclaredFields().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isStatic().or((ElementMatcher)this.ignored))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.start.equals(((ToStringMethod)paramObject).start) ? false : (!this.end.equals(((ToStringMethod)paramObject).end) ? false : (!this.separator.equals(((ToStringMethod)paramObject).separator) ? false : (!this.definer.equals(((ToStringMethod)paramObject).definer) ? false : (!this.prefixResolver.equals(((ToStringMethod)paramObject).prefixResolver) ? false : (!!this.ignored.equals(((ToStringMethod)paramObject).ignored)))))))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return (((((getClass().hashCode() * 31 + this.prefixResolver.hashCode()) * 31 + this.start.hashCode()) * 31 + this.end.hashCode()) * 31 + this.separator.hashCode()) * 31 + this.definer.hashCode()) * 31 + this.ignored.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class Appender
/*     */     implements ByteCodeAppender
/*     */   {
/*     */     private final String prefix;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String start;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String end;
/*     */ 
/*     */ 
/*     */     
/*     */     private final String separator;
/*     */ 
/*     */ 
/*     */     
/*     */     private final String definer;
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<? extends FieldDescription.InDefinedShape> fieldDescriptions;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Appender(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, List<? extends FieldDescription.InDefinedShape> param1List) {
/* 284 */       this.prefix = param1String1;
/* 285 */       this.start = param1String2;
/* 286 */       this.end = param1String3;
/* 287 */       this.separator = param1String4;
/* 288 */       this.definer = param1String5;
/* 289 */       this.fieldDescriptions = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 296 */       if (param1MethodDescription.isStatic())
/* 297 */         throw new IllegalStateException("toString method must not be static: " + param1MethodDescription); 
/* 298 */       if (!param1MethodDescription.getReturnType().asErasure().isAssignableFrom(String.class)) {
/* 299 */         throw new IllegalStateException("toString method does not return String-compatible type: " + param1MethodDescription);
/*     */       }
/*     */       ArrayList<StackManipulation> arrayList;
/* 302 */       (arrayList = new ArrayList<StackManipulation>(Math.max(0, this.fieldDescriptions.size() * 7 - 2) + 10)).add(TypeCreation.of(TypeDescription.ForLoadedType.of(StringBuilder.class)));
/* 303 */       arrayList.add(Duplication.SINGLE);
/* 304 */       arrayList.add(new TextConstant(this.prefix));
/* 305 */       arrayList.add(MethodInvocation.invoke(ToStringMethod.a()));
/* 306 */       arrayList.add(new TextConstant(this.start));
/* 307 */       arrayList.add(ToStringMethod.ValueConsumer.STRING);
/* 308 */       boolean bool = true;
/* 309 */       for (FieldDescription.InDefinedShape inDefinedShape : this.fieldDescriptions) {
/* 310 */         if (bool) {
/* 311 */           bool = false;
/*     */         } else {
/* 313 */           arrayList.add(new TextConstant(this.separator));
/* 314 */           arrayList.add(ToStringMethod.ValueConsumer.STRING);
/*     */         } 
/* 316 */         arrayList.add(new TextConstant(inDefinedShape.getName() + this.definer));
/* 317 */         arrayList.add(ToStringMethod.ValueConsumer.STRING);
/* 318 */         arrayList.add(MethodVariableAccess.loadThis());
/* 319 */         arrayList.add(FieldAccess.forField(inDefinedShape).read());
/* 320 */         arrayList.add(ToStringMethod.ValueConsumer.of(inDefinedShape.getType().asErasure()));
/*     */       } 
/* 322 */       arrayList.add(new TextConstant(this.end));
/* 323 */       arrayList.add(ToStringMethod.ValueConsumer.STRING);
/* 324 */       arrayList.add(MethodInvocation.invoke(ToStringMethod.b()));
/* 325 */       arrayList.add(MethodReturn.REFERENCE);
/* 326 */       return new ByteCodeAppender.Size((new StackManipulation.Compound(arrayList)).apply(param1MethodVisitor, param1Context).getMaximalSize(), param1MethodDescription.getStackSize());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.prefix.equals(((Appender)param1Object).prefix) ? false : (!this.start.equals(((Appender)param1Object).start) ? false : (!this.end.equals(((Appender)param1Object).end) ? false : (!this.separator.equals(((Appender)param1Object).separator) ? false : (!this.definer.equals(((Appender)param1Object).definer) ? false : (!!this.fieldDescriptions.equals(((Appender)param1Object).fieldDescriptions)))))))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (((((getClass().hashCode() * 31 + this.prefix.hashCode()) * 31 + this.start.hashCode()) * 31 + this.end.hashCode()) * 31 + this.separator.hashCode()) * 31 + this.definer.hashCode()) * 31 + this.fieldDescriptions.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Default
/*     */     implements PrefixResolver
/*     */   {
/* 352 */     FULLY_QUALIFIED_CLASS_NAME
/*     */     {
/*     */       public final String resolve(TypeDescription param3TypeDescription) {
/* 355 */         return param3TypeDescription.getName();
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 362 */     CANONICAL_CLASS_NAME
/*     */     {
/*     */       @MaybeNull
/*     */       public final String resolve(TypeDescription param3TypeDescription) {
/* 366 */         return param3TypeDescription.getCanonicalName();
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 373 */     SIMPLE_CLASS_NAME
/*     */     {
/*     */       public final String resolve(TypeDescription param3TypeDescription) {
/* 376 */         return param3TypeDescription.getSimpleName(); } }; } public static interface PrefixResolver { @MaybeNull String resolve(TypeDescription param1TypeDescription); public enum Default implements PrefixResolver { FULLY_QUALIFIED_CLASS_NAME { public final String resolve(TypeDescription param3TypeDescription) { return param3TypeDescription.getName(); } }, CANONICAL_CLASS_NAME { public final String resolve(TypeDescription param3TypeDescription) { return param3TypeDescription.getSimpleName(); }
/*     */          }
/*     */       ,
/*     */       SIMPLE_CLASS_NAME
/*     */       {
/*     */         @MaybeNull
/*     */         public final String resolve(TypeDescription param3TypeDescription) {
/*     */           return param3TypeDescription.getCanonicalName();
/*     */         }
/*     */       }; }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class ForFixedValue
/*     */       implements PrefixResolver
/*     */     {
/*     */       private final String prefix;
/*     */ 
/*     */       
/*     */       protected ForFixedValue(String param2String) {
/* 398 */         this.prefix = param2String;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public String resolve(TypeDescription param2TypeDescription)
/*     */       {
/* 405 */         return this.prefix; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.prefix.equals(((ForFixedValue)param2Object).prefix)))); } public int hashCode() { return getClass().hashCode() * 31 + this.prefix.hashCode(); } } } @Enhance public static class ForFixedValue implements PrefixResolver { private final String prefix; public String resolve(TypeDescription param1TypeDescription) { return this.prefix; }
/*     */     
/*     */     protected ForFixedValue(String param1String) {
/*     */       this.prefix = param1String;
/*     */     }
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.prefix.equals(((ForFixedValue)param1Object).prefix))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.prefix.hashCode();
/*     */     } }
/*     */   
/* 418 */   protected enum ValueConsumer implements StackManipulation { BOOLEAN
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 421 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Z)Ljava/lang/StringBuilder;", false);
/* 422 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 429 */     CHARACTER
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 432 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(C)Ljava/lang/StringBuilder;", false);
/* 433 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 440 */     INTEGER
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 443 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false);
/* 444 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 451 */     LONG
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 454 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false);
/* 455 */         return new StackManipulation.Size(-1, 0);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 462 */     FLOAT
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 465 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(F)Ljava/lang/StringBuilder;", false);
/* 466 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 473 */     DOUBLE
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 476 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(D)Ljava/lang/StringBuilder;", false);
/* 477 */         return new StackManipulation.Size(-1, 0);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 484 */     STRING
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 487 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 488 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 496 */     CHARACTER_SEQUENCE
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 499 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", false);
/* 500 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 507 */     OBJECT
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 510 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);
/* 511 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 518 */     BOOLEAN_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 521 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "toString", "([Z)Ljava/lang/String;", false);
/* 522 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 523 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 530 */     BYTE_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 533 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "toString", "([B)Ljava/lang/String;", false);
/* 534 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 535 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 542 */     SHORT_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 545 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "toString", "([S)Ljava/lang/String;", false);
/* 546 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 547 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 554 */     CHARACTER_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 557 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "toString", "([C)Ljava/lang/String;", false);
/* 558 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 559 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 566 */     INTEGER_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 569 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "toString", "([I)Ljava/lang/String;", false);
/* 570 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 571 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 578 */     LONG_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 581 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "toString", "([J)Ljava/lang/String;", false);
/* 582 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 583 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 590 */     FLOAT_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 593 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "toString", "([F)Ljava/lang/String;", false);
/* 594 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 595 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 602 */     DOUBLE_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 605 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "toString", "([D)Ljava/lang/String;", false);
/* 606 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 607 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 614 */     REFERENCE_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 617 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "toString", "([Ljava/lang/Object;)Ljava/lang/String;", false);
/* 618 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 619 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 626 */     NESTED_ARRAY
/*     */     {
/*     */       public final StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 629 */         param2MethodVisitor.visitMethodInsn(184, "java/util/Arrays", "deepToString", "([Ljava/lang/Object;)Ljava/lang/String;", false);
/* 630 */         param2MethodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
/* 631 */         return StackManipulation.Size.ZERO;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*     */     protected static StackManipulation of(TypeDescription param1TypeDescription) {
/* 643 */       if (param1TypeDescription.represents(boolean.class))
/* 644 */         return BOOLEAN; 
/* 645 */       if (param1TypeDescription.represents(char.class))
/* 646 */         return CHARACTER; 
/* 647 */       if (param1TypeDescription.represents(byte.class) || param1TypeDescription
/* 648 */         .represents(short.class) || param1TypeDescription
/* 649 */         .represents(int.class))
/* 650 */         return INTEGER; 
/* 651 */       if (param1TypeDescription.represents(long.class))
/* 652 */         return LONG; 
/* 653 */       if (param1TypeDescription.represents(float.class))
/* 654 */         return FLOAT; 
/* 655 */       if (param1TypeDescription.represents(double.class))
/* 656 */         return DOUBLE; 
/* 657 */       if (param1TypeDescription.represents(String.class))
/* 658 */         return STRING; 
/* 659 */       if (param1TypeDescription.isAssignableTo(CharSequence.class))
/* 660 */         return CHARACTER_SEQUENCE; 
/* 661 */       if (param1TypeDescription.represents(boolean[].class))
/* 662 */         return BOOLEAN_ARRAY; 
/* 663 */       if (param1TypeDescription.represents(byte[].class))
/* 664 */         return BYTE_ARRAY; 
/* 665 */       if (param1TypeDescription.represents(short[].class))
/* 666 */         return SHORT_ARRAY; 
/* 667 */       if (param1TypeDescription.represents(char[].class))
/* 668 */         return CHARACTER_ARRAY; 
/* 669 */       if (param1TypeDescription.represents(int[].class))
/* 670 */         return INTEGER_ARRAY; 
/* 671 */       if (param1TypeDescription.represents(long[].class))
/* 672 */         return LONG_ARRAY; 
/* 673 */       if (param1TypeDescription.represents(float[].class))
/* 674 */         return FLOAT_ARRAY; 
/* 675 */       if (param1TypeDescription.represents(double[].class))
/* 676 */         return DOUBLE_ARRAY; 
/* 677 */       if (param1TypeDescription.isArray()) {
/* 678 */         return param1TypeDescription.getComponentType().isArray() ? NESTED_ARRAY : REFERENCE_ARRAY;
/*     */       }
/*     */ 
/*     */       
/* 682 */       return OBJECT;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 690 */       return true;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\ToStringMethod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */