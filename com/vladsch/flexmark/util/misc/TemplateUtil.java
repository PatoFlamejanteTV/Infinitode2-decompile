/*    */ package com.vladsch.flexmark.util.misc;
/*    */ import java.util.Map;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class TemplateUtil {
/*    */   public static final Resolver NULL_RESOLVER = paramArrayOfString -> null;
/*    */   
/*    */   public static interface Resolver {
/*    */     String resolve(String[] param1ArrayOfString);
/*    */   }
/*    */   
/*    */   public static class MappedResolver implements Resolver {
/*    */     public MappedResolver(Map<String, String> param1Map) {
/* 15 */       this.resolved = param1Map;
/*    */     }
/*    */     protected final Map<String, String> resolved;
/*    */     public MappedResolver() {
/* 19 */       this(new HashMap<>());
/*    */     }
/*    */     
/*    */     public MappedResolver set(String param1String1, String param1String2) {
/* 23 */       this.resolved.put(param1String1, param1String2);
/* 24 */       return this;
/*    */     }
/*    */     
/*    */     public Map<String, String> getMMap() {
/* 28 */       return this.resolved;
/*    */     }
/*    */ 
/*    */     
/*    */     public String resolve(String[] param1ArrayOfString) {
/* 33 */       return (param1ArrayOfString.length > 2) ? null : this.resolved.get(param1ArrayOfString[1]);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String resolveRefs(CharSequence paramCharSequence, Pattern paramPattern, Resolver paramResolver) {
/* 42 */     if (paramCharSequence == null) return "";
/*    */     
/*    */     Matcher matcher;
/* 45 */     if ((matcher = paramPattern.matcher(paramCharSequence)).find()) {
/* 46 */       paramCharSequence = new StringBuffer();
/*    */       
/*    */       do {
/* 49 */         String[] arrayOfString = new String[matcher.groupCount() + 1];
/* 50 */         for (byte b = 0; b < arrayOfString.length; b++) {
/* 51 */           arrayOfString[b] = matcher.group(b);
/*    */         }
/*    */         
/* 54 */         String str = paramResolver.resolve(arrayOfString);
/*    */         
/* 56 */         matcher.appendReplacement((StringBuffer)paramCharSequence, (str == null) ? "" : str.replace("\\", "\\\\").replace("$", "\\$"));
/* 57 */       } while (matcher.find());
/*    */       
/* 59 */       matcher.appendTail((StringBuffer)paramCharSequence);
/* 60 */       return paramCharSequence.toString();
/*    */     } 
/* 62 */     return paramCharSequence.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\TemplateUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */