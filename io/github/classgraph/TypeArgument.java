/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.types.ParseException;
/*     */ import nonapi.io.github.classgraph.types.Parser;
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
/*     */ public final class TypeArgument
/*     */   extends HierarchicalTypeSignature
/*     */ {
/*     */   private final Wildcard wildcard;
/*     */   private final ReferenceTypeSignature typeSignature;
/*     */   
/*     */   public enum Wildcard
/*     */   {
/*  46 */     NONE,
/*     */ 
/*     */     
/*  49 */     ANY,
/*     */ 
/*     */     
/*  52 */     EXTENDS,
/*     */ 
/*     */     
/*  55 */     SUPER;
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
/*     */   
/*     */   private TypeArgument(Wildcard paramWildcard, ReferenceTypeSignature paramReferenceTypeSignature) {
/*  76 */     this.wildcard = paramWildcard;
/*  77 */     this.typeSignature = paramReferenceTypeSignature;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Wildcard getWildcard() {
/*  88 */     return this.wildcard;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ReferenceTypeSignature getTypeSignature() {
/*  97 */     return this.typeSignature;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void addTypeAnnotation(List<Classfile.TypePathNode> paramList, AnnotationInfo paramAnnotationInfo) {
/* 102 */     if (paramList.size() == 0 && this.wildcard != Wildcard.NONE) {
/*     */       
/* 104 */       addTypeAnnotation(paramAnnotationInfo); return;
/* 105 */     }  if (paramList.size() > 0 && ((Classfile.TypePathNode)paramList.get(0)).typePathKind == 2) {
/*     */ 
/*     */       
/* 108 */       if (this.typeSignature != null) {
/* 109 */         this.typeSignature.addTypeAnnotation(paramList.subList(1, paramList.size()), paramAnnotationInfo);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/* 114 */     } else if (this.typeSignature != null) {
/* 115 */       this.typeSignature.addTypeAnnotation(paramList, paramAnnotationInfo);
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
/*     */ 
/*     */ 
/*     */   
/*     */   private static TypeArgument parse(Parser paramParser, String paramString) {
/*     */     char c;
/* 135 */     if ((c = paramParser.peek()) == '*') {
/* 136 */       paramParser.expect('*');
/* 137 */       return new TypeArgument(Wildcard.ANY, null);
/* 138 */     }  if (c == '+') {
/* 139 */       paramParser.expect('+');
/*     */ 
/*     */       
/* 142 */       if ((referenceTypeSignature = ReferenceTypeSignature.parseReferenceTypeSignature(paramParser, paramString)) == null) {
/* 143 */         throw new ParseException(paramParser, "Missing '+' type bound");
/*     */       }
/* 145 */       return new TypeArgument(Wildcard.EXTENDS, referenceTypeSignature);
/* 146 */     }  if (c == '-') {
/* 147 */       paramParser.expect('-');
/*     */ 
/*     */       
/* 150 */       if ((referenceTypeSignature = ReferenceTypeSignature.parseReferenceTypeSignature(paramParser, (String)referenceTypeSignature)) == null) {
/* 151 */         throw new ParseException(paramParser, "Missing '-' type bound");
/*     */       }
/* 153 */       return new TypeArgument(Wildcard.SUPER, referenceTypeSignature);
/*     */     } 
/*     */     
/*     */     ReferenceTypeSignature referenceTypeSignature;
/* 157 */     if ((referenceTypeSignature = ReferenceTypeSignature.parseReferenceTypeSignature(paramParser, (String)referenceTypeSignature)) == null) {
/* 158 */       throw new ParseException(paramParser, "Missing type bound");
/*     */     }
/* 160 */     return new TypeArgument(Wildcard.NONE, referenceTypeSignature);
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
/*     */   static List<TypeArgument> parseList(Parser paramParser, String paramString) {
/* 176 */     if (paramParser.peek() == '<') {
/* 177 */       paramParser.expect('<');
/* 178 */       ArrayList<TypeArgument> arrayList = new ArrayList(2);
/* 179 */       while (paramParser.peek() != '>') {
/* 180 */         if (!paramParser.hasMore()) {
/* 181 */           throw new ParseException(paramParser, "Missing '>'");
/*     */         }
/* 183 */         arrayList.add(parse(paramParser, paramString));
/*     */       } 
/* 185 */       paramParser.expect('>');
/* 186 */       return arrayList;
/*     */     } 
/* 188 */     return Collections.emptyList();
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
/*     */   protected final String getClassName() {
/* 200 */     throw new IllegalArgumentException("getClassName() cannot be called here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final ClassInfo getClassInfo() {
/* 208 */     throw new IllegalArgumentException("getClassInfo() cannot be called here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void setScanResult(ScanResult paramScanResult) {
/* 216 */     super.setScanResult(paramScanResult);
/* 217 */     if (this.typeSignature != null) {
/* 218 */       this.typeSignature.setScanResult(paramScanResult);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void findReferencedClassNames(Set<String> paramSet) {
/* 229 */     if (this.typeSignature != null) {
/* 230 */       this.typeSignature.findReferencedClassNames(paramSet);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 241 */     return ((this.typeSignature != null) ? this.typeSignature.hashCode() : 0) + 7 * this.wildcard.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 249 */     if (paramObject == this)
/* 250 */       return true; 
/* 251 */     if (!(paramObject instanceof TypeArgument)) {
/* 252 */       return false;
/*     */     }
/* 254 */     paramObject = paramObject;
/* 255 */     if (Objects.equals(this.typeAnnotationInfo, ((TypeArgument)paramObject).typeAnnotationInfo) && 
/* 256 */       Objects.equals(this.typeSignature, ((TypeArgument)paramObject).typeSignature) && ((TypeArgument)paramObject).wildcard
/* 257 */       .equals(this.wildcard)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void toStringInternal(boolean paramBoolean, AnnotationInfoList paramAnnotationInfoList, StringBuilder paramStringBuilder) {
/*     */     String str;
/* 265 */     if (this.typeAnnotationInfo != null) {
/* 266 */       for (AnnotationInfo annotationInfo : this.typeAnnotationInfo) {
/* 267 */         if (paramAnnotationInfoList == null || !paramAnnotationInfoList.contains(annotationInfo)) {
/* 268 */           annotationInfo.toString(paramBoolean, paramStringBuilder);
/* 269 */           paramStringBuilder.append(' ');
/*     */         } 
/*     */       } 
/*     */     }
/* 273 */     switch (this.wildcard) {
/*     */       case ANY:
/* 275 */         paramStringBuilder.append('?');
/*     */         return;
/*     */       case EXTENDS:
/* 278 */         str = this.typeSignature.toString(paramBoolean);
/* 279 */         paramStringBuilder.append(str.equals("java.lang.Object") ? "?" : ("? extends " + str));
/*     */         return;
/*     */       case SUPER:
/* 282 */         paramStringBuilder.append("? super ");
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 287 */     this.typeSignature.toString(paramBoolean, paramStringBuilder);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\TypeArgument.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */