/*    */ package com.vladsch.flexmark.util.data;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.Extension;
/*    */ import java.util.Collection;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SharedDataKeys
/*    */ {
/* 10 */   public static final DataKey<Collection<Extension>> EXTENSIONS = new DataKey<>("EXTENSIONS", Extension.EMPTY_LIST);
/*    */ 
/*    */   
/* 13 */   public static final DataKey<Boolean> HEADING_NO_ATX_SPACE = new DataKey<>("HEADING_NO_ATX_SPACE", Boolean.FALSE);
/*    */   
/* 15 */   public static final DataKey<Boolean> ESCAPE_HEADING_NO_ATX_SPACE = new DataKey<>("ESCAPE_HEADING_NO_ATX_SPACE", Boolean.FALSE, HEADING_NO_ATX_SPACE::get);
/* 16 */   public static final DataKey<Boolean> HTML_FOR_TRANSLATOR = new DataKey<>("HTML_FOR_TRANSLATOR", Boolean.FALSE);
/* 17 */   public static final DataKey<Boolean> INTELLIJ_DUMMY_IDENTIFIER = new DataKey<>("INTELLIJ_DUMMY_IDENTIFIER", Boolean.FALSE);
/* 18 */   public static final DataKey<Boolean> PARSE_INNER_HTML_COMMENTS = new DataKey<>("PARSE_INNER_HTML_COMMENTS", Boolean.FALSE);
/* 19 */   public static final DataKey<Boolean> BLANK_LINES_IN_AST = new DataKey<>("BLANK_LINES_IN_AST", Boolean.FALSE);
/* 20 */   public static final DataKey<String> TRANSLATION_HTML_BLOCK_TAG_PATTERN = new DataKey<>("TRANSLATION_HTML_BLOCK_TAG_PATTERN", "___(?:\\d+)_");
/* 21 */   public static final DataKey<String> TRANSLATION_HTML_INLINE_TAG_PATTERN = new DataKey<>("TRANSLATION_HTML_INLINE_TAG_PATTERN", "__(?:\\d+)_");
/* 22 */   public static final DataKey<String> TRANSLATION_AUTOLINK_TAG_PATTERN = new DataKey<>("TRANSLATION_AUTOLINK_TAG_PATTERN", "____(?:\\d+)_");
/*    */   
/* 24 */   public static final DataKey<Integer> RENDERER_MAX_TRAILING_BLANK_LINES = new DataKey<>("RENDERER_MAX_TRAILING_BLANK_LINES", Integer.valueOf(1));
/* 25 */   public static final DataKey<Integer> RENDERER_MAX_BLANK_LINES = new DataKey<>("RENDERER_MAX_BLANK_LINES", Integer.valueOf(1));
/* 26 */   public static final DataKey<Integer> INDENT_SIZE = new DataKey<>("INDENT_SIZE", Integer.valueOf(0));
/* 27 */   public static final DataKey<Boolean> PERCENT_ENCODE_URLS = new DataKey<>("PERCENT_ENCODE_URLS", Boolean.FALSE);
/* 28 */   public static final DataKey<Boolean> HEADER_ID_GENERATOR_RESOLVE_DUPES = new DataKey<>("HEADER_ID_GENERATOR_RESOLVE_DUPES", Boolean.TRUE);
/* 29 */   public static final DataKey<String> HEADER_ID_GENERATOR_TO_DASH_CHARS = new DataKey<>("HEADER_ID_GENERATOR_TO_DASH_CHARS", " -_");
/* 30 */   public static final DataKey<String> HEADER_ID_GENERATOR_NON_DASH_CHARS = new DataKey<>("HEADER_ID_GENERATOR_NON_DASH_CHARS", "");
/* 31 */   public static final DataKey<Boolean> HEADER_ID_GENERATOR_NO_DUPED_DASHES = new DataKey<>("HEADER_ID_GENERATOR_NO_DUPED_DASHES", Boolean.FALSE);
/* 32 */   public static final DataKey<Boolean> HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE = new DataKey<>("HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE", Boolean.TRUE);
/* 33 */   public static final DataKey<Boolean> HEADER_ID_REF_TEXT_TRIM_LEADING_SPACES = new DataKey<>("HEADER_ID_REF_TEXT_TRIM_LEADING_SPACES", Boolean.TRUE);
/* 34 */   public static final DataKey<Boolean> HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES = new DataKey<>("HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES", Boolean.TRUE);
/* 35 */   public static final DataKey<Boolean> HEADER_ID_ADD_EMOJI_SHORTCUT = new DataKey<>("HEADER_ID_ADD_EMOJI_SHORTCUT", Boolean.FALSE);
/* 36 */   public static final DataKey<Boolean> RENDER_HEADER_ID = new DataKey<>("RENDER_HEADER_ID", Boolean.FALSE);
/* 37 */   public static final DataKey<Boolean> GENERATE_HEADER_ID = new DataKey<>("GENERATE_HEADER_ID", Boolean.TRUE);
/* 38 */   public static final DataKey<Boolean> DO_NOT_RENDER_LINKS = new DataKey<>("DO_NOT_RENDER_LINKS", Boolean.FALSE);
/*    */ 
/*    */   
/* 41 */   public static final DataKey<Integer> FORMATTER_MAX_BLANK_LINES = new DataKey<>("FORMATTER_MAX_BLANK_LINES", Integer.valueOf(2));
/* 42 */   public static final DataKey<Integer> FORMATTER_MAX_TRAILING_BLANK_LINES = new DataKey<>("FORMATTER_MAX_TRAILING_BLANK_LINES", Integer.valueOf(1));
/* 43 */   public static final DataKey<Boolean> BLOCK_QUOTE_BLANK_LINES = new DataKey<>("BLOCK_QUOTE_BLANK_LINES", Boolean.TRUE);
/*    */   
/* 45 */   public static final DataKey<Boolean> APPLY_SPECIAL_LEAD_IN_HANDLERS = new DataKey<>("APPLY_SPECIAL_LEAD_IN_HANDLERS", Boolean.TRUE);
/* 46 */   public static final DataKey<Boolean> ESCAPE_SPECIAL_CHARS = new DataKey<>("ESCAPE_SPECIAL_CHARS", Boolean.TRUE, APPLY_SPECIAL_LEAD_IN_HANDLERS::get);
/* 47 */   public static final DataKey<Boolean> ESCAPE_NUMBERED_LEAD_IN = new DataKey<>("ESCAPE_NUMBERED_LEAD_IN", Boolean.TRUE, APPLY_SPECIAL_LEAD_IN_HANDLERS::get);
/* 48 */   public static final DataKey<Boolean> UNESCAPE_SPECIAL_CHARS = new DataKey<>("UNESCAPE_SPECIAL_CHARS", Boolean.TRUE, APPLY_SPECIAL_LEAD_IN_HANDLERS::get);
/* 49 */   public static final DataKey<Boolean> RUNNING_TESTS = new DataKey<>("RUNNING_TESTS", Boolean.FALSE);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\SharedDataKeys.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */