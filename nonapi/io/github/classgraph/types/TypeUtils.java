/*     */ package nonapi.io.github.classgraph.types;
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
/*     */ 
/*     */ public final class TypeUtils
/*     */ {
/*     */   public static boolean getIdentifierToken(Parser paramParser, boolean paramBoolean) {
/*  57 */     boolean bool = false;
/*  58 */     while (paramParser.hasMore()) {
/*     */       char c;
/*  60 */       if ((c = paramParser.peek()) == '/') {
/*  61 */         paramParser.appendToToken('.');
/*  62 */         paramParser.next();
/*  63 */         bool = true; continue;
/*  64 */       }  if (c != ';' && c != '[' && c != '<' && c != '>' && c != ':' && (!paramBoolean || c != '$')) {
/*     */         
/*  66 */         paramParser.appendToToken(c);
/*  67 */         paramParser.next();
/*  68 */         bool = true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  73 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public enum ModifierType
/*     */   {
/*  79 */     CLASS,
/*     */     
/*  81 */     METHOD,
/*     */     
/*  83 */     FIELD;
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
/*     */   private static void appendModifierKeyword(StringBuilder paramStringBuilder, String paramString) {
/*  96 */     if (paramStringBuilder.length() > 0 && paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ') {
/*  97 */       paramStringBuilder.append(' ');
/*     */     }
/*  99 */     paramStringBuilder.append(paramString);
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
/*     */   public static void modifiersToString(int paramInt, ModifierType paramModifierType, boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 116 */     if ((paramInt & 0x1) != 0) {
/* 117 */       appendModifierKeyword(paramStringBuilder, "public");
/* 118 */     } else if ((paramInt & 0x2) != 0) {
/* 119 */       appendModifierKeyword(paramStringBuilder, "private");
/* 120 */     } else if ((paramInt & 0x4) != 0) {
/* 121 */       appendModifierKeyword(paramStringBuilder, "protected");
/*     */     } 
/* 123 */     if (paramModifierType != ModifierType.FIELD && (paramInt & 0x400) != 0) {
/* 124 */       appendModifierKeyword(paramStringBuilder, "abstract");
/*     */     }
/* 126 */     if ((paramInt & 0x8) != 0) {
/* 127 */       appendModifierKeyword(paramStringBuilder, "static");
/*     */     }
/* 129 */     if (paramModifierType == ModifierType.FIELD) {
/* 130 */       if ((paramInt & 0x40) != 0)
/*     */       {
/* 132 */         appendModifierKeyword(paramStringBuilder, "volatile");
/*     */       }
/* 134 */       if ((paramInt & 0x80) != 0) {
/* 135 */         appendModifierKeyword(paramStringBuilder, "transient");
/*     */       }
/*     */     } 
/* 138 */     if ((paramInt & 0x10) != 0) {
/* 139 */       appendModifierKeyword(paramStringBuilder, "final");
/*     */     }
/* 141 */     if (paramModifierType == ModifierType.METHOD) {
/* 142 */       if ((paramInt & 0x20) != 0) {
/* 143 */         appendModifierKeyword(paramStringBuilder, "synchronized");
/*     */       }
/* 145 */       if (paramBoolean) {
/* 146 */         appendModifierKeyword(paramStringBuilder, "default");
/*     */       }
/*     */     } 
/* 149 */     if ((paramInt & 0x1000) != 0) {
/* 150 */       appendModifierKeyword(paramStringBuilder, "synthetic");
/*     */     }
/* 152 */     if (paramModifierType != ModifierType.FIELD && (paramInt & 0x40) != 0)
/*     */     {
/* 154 */       appendModifierKeyword(paramStringBuilder, "bridge");
/*     */     }
/* 156 */     if (paramModifierType == ModifierType.METHOD && (paramInt & 0x100) != 0) {
/* 157 */       appendModifierKeyword(paramStringBuilder, "native");
/*     */     }
/* 159 */     if (paramModifierType != ModifierType.FIELD && (paramInt & 0x800) != 0)
/* 160 */       appendModifierKeyword(paramStringBuilder, "strictfp"); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\types\TypeUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */