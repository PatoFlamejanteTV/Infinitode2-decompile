/*    */ package com.vladsch.flexmark.util.html;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.Immutable;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public interface Attribute
/*    */   extends Immutable<Attribute, MutableAttribute>
/*    */ {
/*    */   public static final String CLASS_ATTR = "class";
/*    */   public static final String ID_ATTR = "id";
/*    */   public static final String LINK_STATUS_ATTR = "Link Status";
/*    */   public static final String NAME_ATTR = "name";
/*    */   public static final String STYLE_ATTR = "style";
/*    */   public static final String TITLE_ATTR = "title";
/*    */   public static final String TARGET_ATTR = "target";
/* 18 */   public static final Attribute NO_FOLLOW = AttributeImpl.of("rel", "nofollow");
/* 19 */   public static final Set<String> NON_RENDERING_WHEN_EMPTY = new HashSet<>(Arrays.asList(new String[] { "class", "id", "name", "style" }));
/*    */   @Deprecated
/*    */   public static final char NUL = '\000';
/*    */   
/*    */   String getName();
/*    */   
/*    */   String getValue();
/*    */   
/*    */   char getValueListDelimiter();
/*    */   
/*    */   char getValueNameDelimiter();
/*    */   
/*    */   boolean isNonRendering();
/*    */   
/*    */   boolean containsValue(CharSequence paramCharSequence);
/*    */   
/*    */   Attribute replaceValue(CharSequence paramCharSequence);
/*    */   
/*    */   Attribute setValue(CharSequence paramCharSequence);
/*    */   
/*    */   Attribute removeValue(CharSequence paramCharSequence);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\html\Attribute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */