/*     */ package com.prineside.tdi2.desktop.luadef;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.utils.ReflectionUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class LuaDefUtils {
/*     */   public static final ObjectSet<String> LUA_KEYWORDS;
/*     */   public static final ObjectMap<Class<?>, String> DEFAULT_LUA_CLASS_NAMES;
/*     */   public static final ObjectMap<Class<?>, String> DEFAULT_LUA_CLASS_NAMES_WITH_CLASS;
/*     */   public static final ObjectMap<Class<?>, String> LUA_PRIMITIVE_TYPE_EXTRA_INFO;
/*     */   private static final HashMap<String, String> a;
/*     */   
/*  25 */   static { (LUA_KEYWORDS = new ObjectSet()).addAll((Object[])new String[] { "and", "break", "do", "else", "elseif", "end", "false", "for", "function", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  34 */     (DEFAULT_LUA_CLASS_NAMES = new ObjectMap()).put(double.class, "number");
/*  35 */     DEFAULT_LUA_CLASS_NAMES.put(float.class, "number");
/*  36 */     DEFAULT_LUA_CLASS_NAMES.put(long.class, "number");
/*  37 */     DEFAULT_LUA_CLASS_NAMES.put(boolean.class, "boolean");
/*  38 */     DEFAULT_LUA_CLASS_NAMES.put(int.class, "number");
/*  39 */     DEFAULT_LUA_CLASS_NAMES.put(short.class, "number");
/*  40 */     DEFAULT_LUA_CLASS_NAMES.put(void.class, "nil");
/*  41 */     DEFAULT_LUA_CLASS_NAMES.put(char.class, "number");
/*  42 */     DEFAULT_LUA_CLASS_NAMES.put(byte.class, "number");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  47 */     (DEFAULT_LUA_CLASS_NAMES_WITH_CLASS = new ObjectMap()).put(double.class, "number");
/*  48 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(Double.class, "number");
/*  49 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(float.class, "number");
/*  50 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(Float.class, "number");
/*  51 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(long.class, "number");
/*  52 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(Long.class, "number");
/*  53 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(boolean.class, "boolean");
/*  54 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(Boolean.class, "boolean");
/*  55 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(String.class, "string");
/*  56 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(int.class, "number");
/*  57 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(Integer.class, "number");
/*  58 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(short.class, "number");
/*  59 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(Short.class, "number");
/*  60 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(void.class, "nil");
/*  61 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(Void.class, "nil");
/*  62 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(char.class, "number");
/*  63 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(Character.class, "number");
/*  64 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(byte.class, "number");
/*  65 */     DEFAULT_LUA_CLASS_NAMES_WITH_CLASS.put(Byte.class, "number");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     (LUA_PRIMITIVE_TYPE_EXTRA_INFO = new ObjectMap()).put(double.class, "double");
/*  71 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(Double.class, "double");
/*  72 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(float.class, "float");
/*  73 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(Float.class, "float");
/*  74 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(long.class, "long");
/*  75 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(Long.class, "long");
/*  76 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(short.class, "short");
/*  77 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(Short.class, "short");
/*  78 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(int.class, "int");
/*  79 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(Integer.class, "int");
/*  80 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(char.class, "char");
/*  81 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(Character.class, "char");
/*  82 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(byte.class, "byte");
/*  83 */     LUA_PRIMITIVE_TYPE_EXTRA_INFO.put(Byte.class, "byte");
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
/* 124 */     (a = new HashMap<>()).put("00", "><(((('>");
/* 125 */     a.put("10", "(-(-_(-_-)_-)-)");
/* 126 */     a.put("20", "@( * O * )@");
/* 127 */     a.put("30", "@('_')@");
/* 128 */     a.put("40", "°º¤ø,¸¸,ø¤º°`°º¤ø,¸,ø¤°º¤ø,¸¸,ø¤º°`°º¤ø,¸");
/* 129 */     a.put("50", "--------{---(@");
/* 130 */     a.put("60", "<*_*>");
/* 131 */     a.put("70", "(-.-)Zzz...");
/* 132 */     a.put("80", "[{-_-}] ZZZzz zz z...");
/* 133 */     a.put("90", ",.-~*´¨¯¨`*·~-.¸-(_FixIt_)-,.-~*´¨¯¨`*·~-.¸");
/* 134 */     a.put("a0", ")xxxxx[;;;;;;;;;>");
/* 135 */     a.put("b0", "c[_]");
/* 136 */     a.put("c0", "d[ o_0 ]b");
/* 137 */     a.put("d0", "^(*(oo)*)^");
/* 138 */     a.put("e0", "=^..^=");
/* 139 */     a.put("f0", "¸.·´¯`·.´¯`·.¸¸.·´¯`·.¸><(((º>");
/* 140 */     a.put("01", "(===||:::::::::::::::>");
/* 141 */     a.put("02", "\\,,/(^_^)\\,,/");
/* 142 */     a.put("03", "'''⌐(ಠ۾ಠ)¬'''");
/* 143 */     a.put("04", " ‛¯¯٭٭¯¯(▫▫)¯¯٭٭¯¯’");
/* 144 */     a.put("05", "|[●▪▪●]|");
/* 145 */     a.put("06", "∙،°.  ˘Ô≈ôﺣ   » » »");
/* 146 */     a.put("07", " c[○┬●]כ ");
/* 147 */     a.put("08", "(♥_♥)");
/* 148 */     a.put("09", "龴ↀ◡ↀ龴");
/* 149 */     a.put("0a", "☁ ▅▒░☼‿☼░▒▅ ☁");
/* 150 */     a.put("0b", "^⨀ᴥ⨀^");
/* 151 */     a.put("0c", "|'L'|");
/* 152 */     a.put("0d", "<|º감º|>");
/* 153 */     a.put("0e", "⎦˚◡˚⎣");
/* 154 */     a.put("0f", "<:3 )~~~");
/* 155 */     a.put("11", "¸¸♬·¯·♩¸¸♪·¯·♫¸¸♬·¯·♩¸¸♪·¯·♫¸¸");
/* 156 */     a.put("12", "¯\\_(ツ)_/¯ ");
/* 157 */     a.put("13", "(╯°□°）╯︵ ┻━┻");
/* 158 */     a.put("14", ":Q___");
/* 159 */     a.put("15", "~(‾▿‾)~");
/* 160 */     a.put("16", "(òÓ,)_\\,,/");
/* 161 */     a.put("17", "༼☉ɷ⊙༽");
/* 162 */     a.put("18", "(<(<>(<>.(<>..<>).<>)<>)>)");
/* 163 */     a.put("19", "( (8 ())");
/* 164 */     a.put("1a", "~~(__^·>");
/* 165 */     a.put("1b", "c====(=#O| ) ~~ ♬·¯·♩¸¸♪·¯·♫¸ ");
/* 166 */     a.put("1c", "<(''<)  <( ' ' )>  (> '')>");
/* 167 */     a.put("1d", "∙∙∙∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ☼)===>");
/* 168 */     a.put("1e", "‹’’›(Ͼ.Ͽ)‹’’›   ");
/* 169 */     a.put("1f", "(⌒▽⌒)");
/* 170 */     a.put("21", "|-o-| (-o-) |-o-|");
/* 171 */     a.put("22", "(¯`·._.··¸.-~*´¨¯¨`*·~-.,-(_ignore this_)-,.-~*´¨¯¨`*·~-.¸··._.·´¯)");
/* 172 */     a.put("23", "°j°m");
/* 173 */     a.put("24", "(/.__.)/   \\(.__.\\)");
/* 174 */     a.put("25", "(>'-')> <('_'<) ^('_')\\- \\m/(-_-)\\m/ <( '-')> \\_( .\")> <( ._.)-`");
/* 175 */     a.put("26", "@_'-'");
/* 176 */     a.put("27", "@}~}~~~");
/* 177 */     a.put("28", "d[-_-]b");
/* 178 */     a.put("29", "'(◣_◢)'");
/* 179 */     a.put("2a", "^(;,;)^");
/* 180 */     a.put("2b", "◖(◣☩◢)◗");
/* 181 */     a.put("2c", " ლ(ಠ益ಠ)ლ");
/* 182 */     a.put("2d", "/)^3^(\\");
/* 183 */     a.put("2e", "(\\/)(Ö,,,,Ö)(\\/)");
/* 184 */     a.put("2f", "✈");
/* 185 */     a.put("31", "ε(๏_๏)з】");
/* 186 */     a.put("32", "-_-");
/* 187 */     a.put("33", "(ಠ_ಠ)");
/* 188 */     a.put("34", "d(^o^)b");
/* 189 */     a.put("35", "\\(^-^)/");
/* 190 */     a.put("36", "(ノಠ益ಠ)ノ彡");
/* 191 */     a.put("37", "┏(-_-)┛┗(-_-)┓┗(-_-)┛┏(-_-)┓");
/* 192 */     a.put("38", "-^^,--,~");
/* 193 */     a.put("39", "(,,,)=(^.^)=(,,,)");
/* 194 */     a.put("3a", "♡");
/* 195 */     a.put("3b", "O=('-'Q)");
/* 196 */     a.put("3c", "d(^o^)b¸¸♬·¯·♩¸¸♪·¯·♫¸¸");
/* 197 */     a.put("3d", "~~~~~~~~*\\o/~~~~~/\\*~~~~~~~");
/* 198 */     a.put("3e", "ˁ(⦿ᴥ⦿)ˀ");
/* 199 */     a.put("3f", "( •_•)O*¯`·.¸.·´¯`°Q(•_• )");
/* 200 */     a.put("41", "┻━┻︵  \\(°□°)/ ︵ ┻━┻ ");
/* 201 */     a.put("42", "/X\\('-')/X\\");
/* 202 */     a.put("43", "[::]");
/* 203 */     a.put("44", "[===]-'");
/* 204 */     a.put("45", "༼ つ ◕_◕ ༽つ ");
/* 205 */     a.put("46", "-=iii=<()");
/* 206 */     a.put("47", "(,(,(,(,(,(,(,(, \")");
/* 207 */     a.put("48", "┏━┓ ︵  /(^.^/)");
/* 208 */     a.put("49", "/-.-\\");
/* 209 */     a.put("4a", "┬┴┬┴┤･ω･)ﾉ├┬┴┬┴");
/* 210 */     a.put("4b", "(\\_/) ");
/* 211 */     a.put("4c", "\\m/_(>_<)_\\m/");
/* 212 */     a.put("4d", "(ಠ_x) ༼☉");
/* 213 */     a.put("4e", "ᒡ◯ᵔ◯ᒢ");
/* 214 */     a.put("4f", "≧◔◡◔≦");
/* 215 */     a.put("51", "xP");
/* 216 */     a.put("52", "Made in Zeraco's basement");
/* 217 */     a.put("53", "Don't fuck with the server");
/* 218 */     a.put("54", "A great explanation of class: https://www.youtube.com/watch?v=dQw4w9WgXcQ"); }
/*     */    public static String getLuaPrimitiveType(Class<?> paramClass) {
/*     */     String str;
/*     */     if ((str = (String)LUA_PRIMITIVE_TYPE_EXTRA_INFO.get(paramClass)) == null)
/*     */       return ""; 
/*     */     return " (" + str + ")";
/*     */   }
/*     */   public static void appendArt(String paramString, StringBuilder paramStringBuilder) { char c;
/* 226 */     if (((c = paramString.charAt(5)) == 'a' || c == '7' || c == '0' || c == 'd') && (
/*     */       
/* 228 */       paramString = a.get(paramString.substring(0, 2).toLowerCase(Locale.US))) != null)
/* 229 */       paramStringBuilder.append("\n").append("-- ").append(paramString).append("\n");  }
/*     */   public static void createDirs(String paramString) { String[] arrayOfString = paramString.split("/"); for (byte b = 1; b < arrayOfString.length; b++) {
/*     */       Array array = new Array(true, b, String.class); for (byte b1 = 0; b1 < b; b1++)
/*     */         array.add(arrayOfString[b1]);  try {
/*     */         (new File(array.toString("/"))).mkdir();
/*     */       } catch (Exception exception) {}
/* 235 */     }  } private static final Map<Class<?>, Array<Field>> b = Collections.synchronizedMap(new HashMap<>());
/* 236 */   public static void writeFile(String paramString1, String paramString2) { createDirs(paramString1); try { PrintStream printStream = new PrintStream(new FileOutputStream(paramString1), false, "UTF-8"); try { printStream.print(paramString2); printStream.flush(); printStream.close(); } catch (Throwable throwable) { try { printStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (Exception exception) { throw new IllegalStateException("Failed to write file " + paramString1, exception); }  } private static final Map<Class<?>, Array<Constructor<?>>> c = Collections.synchronizedMap(new HashMap<>());
/* 237 */   private static final Map<Class<?>, Array<Method>> d = Collections.synchronizedMap(new HashMap<>());
/*     */   
/*     */   public static Array<Field> gatherFieldsCached(Class<?> paramClass) {
/*     */     Array<Field> array;
/* 241 */     if ((array = b.get(paramClass)) != null) {
/* 242 */       return array;
/*     */     }
/* 244 */     array = ReflectionUtils.LuaRelated.gatherFields(paramClass);
/* 245 */     b.put(paramClass, array);
/* 246 */     return array;
/*     */   }
/*     */   
/*     */   public static Array<Constructor<?>> gatherConstructorsCached(Class<?> paramClass) {
/*     */     Array<Constructor<?>> array;
/* 251 */     if ((array = c.get(paramClass)) != null) {
/* 252 */       return array;
/*     */     }
/* 254 */     array = ReflectionUtils.LuaRelated.gatherConstructors(paramClass);
/* 255 */     c.put(paramClass, array);
/* 256 */     return array;
/*     */   }
/*     */   
/*     */   public static Array<Method> gatherMethodsCached(Class<?> paramClass) {
/*     */     Array<Method> array;
/* 261 */     if ((array = d.get(paramClass)) != null) {
/* 262 */       return array;
/*     */     }
/* 264 */     array = ReflectionUtils.LuaRelated.gatherMethods(paramClass);
/* 265 */     d.put(paramClass, array);
/* 266 */     return array;
/*     */   }
/*     */   
/*     */   public static void fancyWarning(String paramString1, String paramString2, Throwable paramThrowable) {
/* 270 */     paramString2 = "\033[33m/!\\ " + paramString2 + "\033[0m";
/* 271 */     if (paramThrowable == null) {
/* 272 */       TLog.forTag(paramString1).i(paramString1, new Object[] { paramString2 }); return;
/*     */     } 
/* 274 */     TLog.forTag(paramString1).i(paramString1, new Object[] { paramString2, paramThrowable });
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\luadef\LuaDefUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */