/*     */ package com.badlogic.gdx.ai.btree.utils;
/*     */ 
/*     */ import com.badlogic.gdx.ai.utils.random.ConstantDoubleDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.ConstantFloatDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.ConstantIntegerDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.ConstantLongDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.Distribution;
/*     */ import com.badlogic.gdx.ai.utils.random.DoubleDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.FloatDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.GaussianDoubleDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.GaussianFloatDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.IntegerDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.LongDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.TriangularDoubleDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.TriangularFloatDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.TriangularIntegerDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.TriangularLongDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.UniformDoubleDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.UniformFloatDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.UniformIntegerDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.UniformLongDistribution;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import java.util.StringTokenizer;
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
/*     */ public class DistributionAdapters
/*     */ {
/*     */   private static final ObjectMap<Class<?>, Adapter<?>> ADAPTERS;
/*     */   ObjectMap<Class<?>, Adapter<?>> map;
/*     */   ObjectMap<Class<?>, ObjectMap<String, Adapter<?>>> typeMap;
/*     */   
/*     */   public static class DistributionFormatException
/*     */     extends RuntimeException
/*     */   {
/*     */     public DistributionFormatException() {}
/*     */     
/*     */     public DistributionFormatException(String param1String) {
/*  61 */       super(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DistributionFormatException(String param1String, Throwable param1Throwable) {
/*  73 */       super(param1String, param1Throwable);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DistributionFormatException(Throwable param1Throwable) {
/*  83 */       super(param1Throwable);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class Adapter<D extends Distribution>
/*     */   {
/*     */     final String category;
/*     */     final Class<?> type;
/*     */     
/*     */     public Adapter(String param1String, Class<?> param1Class) {
/*  93 */       this.category = param1String;
/*  94 */       this.type = param1Class;
/*     */     }
/*     */     
/*     */     public abstract D toDistribution(String[] param1ArrayOfString);
/*     */     
/*     */     public abstract String[] toParameters(D param1D);
/*     */     
/*     */     public static double parseDouble(String param1String) {
/*     */       try {
/* 103 */         return Double.parseDouble(param1String);
/* 104 */       } catch (NumberFormatException numberFormatException) {
/* 105 */         throw new DistributionAdapters.DistributionFormatException("Not a double value: " + param1String, numberFormatException);
/*     */       } 
/*     */     }
/*     */     
/*     */     public static float parseFloat(String param1String) {
/*     */       try {
/* 111 */         return Float.parseFloat(param1String);
/* 112 */       } catch (NumberFormatException numberFormatException) {
/* 113 */         throw new DistributionAdapters.DistributionFormatException("Not a float value: " + param1String, numberFormatException);
/*     */       } 
/*     */     }
/*     */     
/*     */     public static int parseInteger(String param1String) {
/*     */       try {
/* 119 */         return Integer.parseInt(param1String);
/* 120 */       } catch (NumberFormatException numberFormatException) {
/* 121 */         throw new DistributionAdapters.DistributionFormatException("Not an int value: " + param1String, numberFormatException);
/*     */       } 
/*     */     }
/*     */     
/*     */     public static long parseLong(String param1String) {
/*     */       try {
/* 127 */         return Long.parseLong(param1String);
/* 128 */       } catch (NumberFormatException numberFormatException) {
/* 129 */         throw new DistributionAdapters.DistributionFormatException("Not a long value: " + param1String, numberFormatException);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class DoubleAdapter<D extends DoubleDistribution>
/*     */     extends Adapter<D> {
/*     */     public DoubleAdapter(String param1String) {
/* 137 */       super(param1String, DoubleDistribution.class);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class FloatAdapter<D extends FloatDistribution> extends Adapter<D> {
/*     */     public FloatAdapter(String param1String) {
/* 143 */       super(param1String, FloatDistribution.class);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class IntegerAdapter<D extends IntegerDistribution> extends Adapter<D> {
/*     */     public IntegerAdapter(String param1String) {
/* 149 */       super(param1String, IntegerDistribution.class);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class LongAdapter<D extends LongDistribution> extends Adapter<D> {
/*     */     public LongAdapter(String param1String) {
/* 155 */       super(param1String, LongDistribution.class);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 165 */     (ADAPTERS = new ObjectMap()).put(ConstantDoubleDistribution.class, new DoubleAdapter<ConstantDoubleDistribution>("constant")
/*     */         {
/*     */           public final ConstantDoubleDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 169 */             if (param1ArrayOfString.length != 1) throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1 }); 
/* 170 */             return new ConstantDoubleDistribution(parseDouble(param1ArrayOfString[0]));
/*     */           }
/*     */ 
/*     */           
/*     */           public final String[] toParameters(ConstantDoubleDistribution param1ConstantDoubleDistribution) {
/* 175 */             return new String[] { Double.toString(param1ConstantDoubleDistribution.getValue()) };
/*     */           }
/*     */         });
/*     */     
/* 179 */     ADAPTERS.put(ConstantFloatDistribution.class, new FloatAdapter<ConstantFloatDistribution>("constant")
/*     */         {
/*     */           public final ConstantFloatDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 183 */             if (param1ArrayOfString.length != 1) throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1 }); 
/* 184 */             return new ConstantFloatDistribution(parseFloat(param1ArrayOfString[0]));
/*     */           }
/*     */ 
/*     */           
/*     */           public final String[] toParameters(ConstantFloatDistribution param1ConstantFloatDistribution) {
/* 189 */             return new String[] { Float.toString(param1ConstantFloatDistribution.getValue()) };
/*     */           }
/*     */         });
/*     */     
/* 193 */     ADAPTERS.put(ConstantIntegerDistribution.class, new IntegerAdapter<ConstantIntegerDistribution>("constant")
/*     */         {
/*     */           public final ConstantIntegerDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 197 */             if (param1ArrayOfString.length != 1) throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1 }); 
/* 198 */             return new ConstantIntegerDistribution(parseInteger(param1ArrayOfString[0]));
/*     */           }
/*     */ 
/*     */           
/*     */           public final String[] toParameters(ConstantIntegerDistribution param1ConstantIntegerDistribution) {
/* 203 */             return new String[] { Integer.toString(param1ConstantIntegerDistribution.getValue()) };
/*     */           }
/*     */         });
/*     */     
/* 207 */     ADAPTERS.put(ConstantLongDistribution.class, new LongAdapter<ConstantLongDistribution>("constant")
/*     */         {
/*     */           public final ConstantLongDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 211 */             if (param1ArrayOfString.length != 1) throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1 }); 
/* 212 */             return new ConstantLongDistribution(parseLong(param1ArrayOfString[0]));
/*     */           }
/*     */ 
/*     */           
/*     */           public final String[] toParameters(ConstantLongDistribution param1ConstantLongDistribution) {
/* 217 */             return new String[] { Long.toString(param1ConstantLongDistribution.getValue()) };
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 225 */     ADAPTERS.put(GaussianDoubleDistribution.class, new DoubleAdapter<GaussianDoubleDistribution>("gaussian")
/*     */         {
/*     */           public final GaussianDoubleDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 229 */             if (param1ArrayOfString.length != 2) throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 2 }); 
/* 230 */             return new GaussianDoubleDistribution(parseDouble(param1ArrayOfString[0]), parseDouble(param1ArrayOfString[1]));
/*     */           }
/*     */ 
/*     */           
/*     */           public final String[] toParameters(GaussianDoubleDistribution param1GaussianDoubleDistribution) {
/* 235 */             return new String[] { Double.toString(param1GaussianDoubleDistribution.getMean()), Double.toString(param1GaussianDoubleDistribution.getStandardDeviation()) };
/*     */           }
/*     */         });
/*     */     
/* 239 */     ADAPTERS.put(GaussianFloatDistribution.class, new FloatAdapter<GaussianFloatDistribution>("gaussian")
/*     */         {
/*     */           public final GaussianFloatDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 243 */             if (param1ArrayOfString.length != 2) throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 2 }); 
/* 244 */             return new GaussianFloatDistribution(parseFloat(param1ArrayOfString[0]), parseFloat(param1ArrayOfString[1]));
/*     */           }
/*     */ 
/*     */           
/*     */           public final String[] toParameters(GaussianFloatDistribution param1GaussianFloatDistribution) {
/* 249 */             return new String[] { Float.toString(param1GaussianFloatDistribution.getMean()), Float.toString(param1GaussianFloatDistribution.getStandardDeviation()) };
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 257 */     ADAPTERS.put(TriangularDoubleDistribution.class, new DoubleAdapter<TriangularDoubleDistribution>("triangular")
/*     */         {
/*     */           public final TriangularDoubleDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 261 */             switch (param1ArrayOfString.length) {
/*     */               case 1:
/* 263 */                 return new TriangularDoubleDistribution(parseDouble(param1ArrayOfString[0]));
/*     */               case 2:
/* 265 */                 return new TriangularDoubleDistribution(parseDouble(param1ArrayOfString[0]), parseDouble(param1ArrayOfString[1]));
/*     */               case 3:
/* 267 */                 return new TriangularDoubleDistribution(parseDouble(param1ArrayOfString[0]), parseDouble(param1ArrayOfString[1]), parseDouble(param1ArrayOfString[2]));
/*     */             } 
/* 269 */             throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1, 2, 3 });
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final String[] toParameters(TriangularDoubleDistribution param1TriangularDoubleDistribution) {
/* 275 */             return new String[] { Double.toString(param1TriangularDoubleDistribution.getLow()), Double.toString(param1TriangularDoubleDistribution.getHigh()), 
/* 276 */                 Double.toString(param1TriangularDoubleDistribution.getMode()) };
/*     */           }
/*     */         });
/*     */     
/* 280 */     ADAPTERS.put(TriangularFloatDistribution.class, new FloatAdapter<TriangularFloatDistribution>("triangular")
/*     */         {
/*     */           public final TriangularFloatDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 284 */             switch (param1ArrayOfString.length) {
/*     */               case 1:
/* 286 */                 return new TriangularFloatDistribution(parseFloat(param1ArrayOfString[0]));
/*     */               case 2:
/* 288 */                 return new TriangularFloatDistribution(parseFloat(param1ArrayOfString[0]), parseFloat(param1ArrayOfString[1]));
/*     */               case 3:
/* 290 */                 return new TriangularFloatDistribution(parseFloat(param1ArrayOfString[0]), parseFloat(param1ArrayOfString[1]), parseFloat(param1ArrayOfString[2]));
/*     */             } 
/* 292 */             throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1, 2, 3 });
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final String[] toParameters(TriangularFloatDistribution param1TriangularFloatDistribution) {
/* 298 */             return new String[] { Float.toString(param1TriangularFloatDistribution.getLow()), Float.toString(param1TriangularFloatDistribution.getHigh()), 
/* 299 */                 Float.toString(param1TriangularFloatDistribution.getMode()) };
/*     */           }
/*     */         });
/*     */     
/* 303 */     ADAPTERS.put(TriangularIntegerDistribution.class, new IntegerAdapter<TriangularIntegerDistribution>("triangular")
/*     */         {
/*     */           public final TriangularIntegerDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 307 */             switch (param1ArrayOfString.length) {
/*     */               case 1:
/* 309 */                 return new TriangularIntegerDistribution(parseInteger(param1ArrayOfString[0]));
/*     */               case 2:
/* 311 */                 return new TriangularIntegerDistribution(parseInteger(param1ArrayOfString[0]), parseInteger(param1ArrayOfString[1]));
/*     */               case 3:
/* 313 */                 return new TriangularIntegerDistribution(parseInteger(param1ArrayOfString[0]), parseInteger(param1ArrayOfString[1]), Float.valueOf(param1ArrayOfString[2]).floatValue());
/*     */             } 
/* 315 */             throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1, 2, 3 });
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final String[] toParameters(TriangularIntegerDistribution param1TriangularIntegerDistribution) {
/* 321 */             return new String[] { Integer.toString(param1TriangularIntegerDistribution.getLow()), Integer.toString(param1TriangularIntegerDistribution.getHigh()), 
/* 322 */                 Float.toString(param1TriangularIntegerDistribution.getMode()) };
/*     */           }
/*     */         });
/*     */     
/* 326 */     ADAPTERS.put(TriangularLongDistribution.class, new LongAdapter<TriangularLongDistribution>("triangular")
/*     */         {
/*     */           public final TriangularLongDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 330 */             switch (param1ArrayOfString.length) {
/*     */               case 1:
/* 332 */                 return new TriangularLongDistribution(parseLong(param1ArrayOfString[0]));
/*     */               case 2:
/* 334 */                 return new TriangularLongDistribution(parseLong(param1ArrayOfString[0]), parseLong(param1ArrayOfString[1]));
/*     */               case 3:
/* 336 */                 return new TriangularLongDistribution(parseLong(param1ArrayOfString[0]), parseLong(param1ArrayOfString[1]), parseDouble(param1ArrayOfString[2]));
/*     */             } 
/* 338 */             throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1, 2, 3 });
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final String[] toParameters(TriangularLongDistribution param1TriangularLongDistribution) {
/* 344 */             return new String[] { Long.toString(param1TriangularLongDistribution.getLow()), Long.toString(param1TriangularLongDistribution.getHigh()), 
/* 345 */                 Double.toString(param1TriangularLongDistribution.getMode()) };
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 353 */     ADAPTERS.put(UniformDoubleDistribution.class, new DoubleAdapter<UniformDoubleDistribution>("uniform")
/*     */         {
/*     */           public final UniformDoubleDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 357 */             switch (param1ArrayOfString.length) {
/*     */               case 1:
/* 359 */                 return new UniformDoubleDistribution(parseDouble(param1ArrayOfString[0]));
/*     */               case 2:
/* 361 */                 return new UniformDoubleDistribution(parseDouble(param1ArrayOfString[0]), parseDouble(param1ArrayOfString[1]));
/*     */             } 
/* 363 */             throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1, 2 });
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final String[] toParameters(UniformDoubleDistribution param1UniformDoubleDistribution) {
/* 369 */             return new String[] { Double.toString(param1UniformDoubleDistribution.getLow()), Double.toString(param1UniformDoubleDistribution.getHigh()) };
/*     */           }
/*     */         });
/*     */     
/* 373 */     ADAPTERS.put(UniformFloatDistribution.class, new FloatAdapter<UniformFloatDistribution>("uniform")
/*     */         {
/*     */           public final UniformFloatDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 377 */             switch (param1ArrayOfString.length) {
/*     */               case 1:
/* 379 */                 return new UniformFloatDistribution(parseFloat(param1ArrayOfString[0]));
/*     */               case 2:
/* 381 */                 return new UniformFloatDistribution(parseFloat(param1ArrayOfString[0]), parseFloat(param1ArrayOfString[1]));
/*     */             } 
/* 383 */             throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1, 2 });
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final String[] toParameters(UniformFloatDistribution param1UniformFloatDistribution) {
/* 389 */             return new String[] { Float.toString(param1UniformFloatDistribution.getLow()), Float.toString(param1UniformFloatDistribution.getHigh()) };
/*     */           }
/*     */         });
/*     */     
/* 393 */     ADAPTERS.put(UniformIntegerDistribution.class, new IntegerAdapter<UniformIntegerDistribution>("uniform")
/*     */         {
/*     */           public final UniformIntegerDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 397 */             switch (param1ArrayOfString.length) {
/*     */               case 1:
/* 399 */                 return new UniformIntegerDistribution(parseInteger(param1ArrayOfString[0]));
/*     */               case 2:
/* 401 */                 return new UniformIntegerDistribution(parseInteger(param1ArrayOfString[0]), parseInteger(param1ArrayOfString[1]));
/*     */             } 
/* 403 */             throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1, 2 });
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final String[] toParameters(UniformIntegerDistribution param1UniformIntegerDistribution) {
/* 409 */             return new String[] { Integer.toString(param1UniformIntegerDistribution.getLow()), Integer.toString(param1UniformIntegerDistribution.getHigh()) };
/*     */           }
/*     */         });
/*     */     
/* 413 */     ADAPTERS.put(UniformLongDistribution.class, new LongAdapter<UniformLongDistribution>("uniform")
/*     */         {
/*     */           public final UniformLongDistribution toDistribution(String[] param1ArrayOfString)
/*     */           {
/* 417 */             switch (param1ArrayOfString.length) {
/*     */               case 1:
/* 419 */                 return new UniformLongDistribution(parseLong(param1ArrayOfString[0]));
/*     */               case 2:
/* 421 */                 return new UniformLongDistribution(parseLong(param1ArrayOfString[0]), parseLong(param1ArrayOfString[1]));
/*     */             } 
/* 423 */             throw DistributionAdapters.invalidNumberOfArgumentsException(param1ArrayOfString.length, new int[] { 1, 2 });
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public final String[] toParameters(UniformLongDistribution param1UniformLongDistribution) {
/* 429 */             return new String[] { Long.toString(param1UniformLongDistribution.getLow()), Long.toString(param1UniformLongDistribution.getHigh()) };
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DistributionAdapters() {
/* 438 */     this.map = new ObjectMap();
/* 439 */     this.typeMap = new ObjectMap();
/* 440 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = ADAPTERS.entries().iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 441 */       add((Class)entry.key, (Adapter)entry.value); }
/*     */   
/*     */   }
/*     */   public final void add(Class<?> paramClass, Adapter<?> paramAdapter) {
/* 445 */     this.map.put(paramClass, paramAdapter);
/*     */     
/*     */     ObjectMap objectMap;
/* 448 */     if ((objectMap = (ObjectMap)this.typeMap.get(paramAdapter.type)) == null) {
/* 449 */       objectMap = new ObjectMap();
/* 450 */       this.typeMap.put(paramAdapter.type, objectMap);
/*     */     } 
/* 452 */     objectMap.put(paramAdapter.category, paramAdapter);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends Distribution> T toDistribution(String paramString, Class<T> paramClass) {
/*     */     StringTokenizer stringTokenizer;
/* 458 */     if (!(stringTokenizer = new StringTokenizer(paramString, ", \t\f")).hasMoreTokens()) throw new DistributionFormatException("Missing ditribution type"); 
/* 459 */     String str = stringTokenizer.nextToken();
/*     */     ObjectMap objectMap;
/*     */     Adapter<T> adapter;
/* 462 */     if ((adapter = (Adapter)(objectMap = (ObjectMap)this.typeMap.get(paramClass)).get(str)) == null)
/* 463 */       throw new DistributionFormatException("Cannot create a '" + paramClass.getSimpleName() + "' of type '" + str + "'"); 
/* 464 */     String[] arrayOfString = new String[stringTokenizer.countTokens()];
/* 465 */     for (byte b = 0; b < arrayOfString.length; b++)
/* 466 */       arrayOfString[b] = stringTokenizer.nextToken(); 
/* 467 */     return adapter.toDistribution(arrayOfString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(Distribution paramDistribution) {
/*     */     Adapter<Distribution> adapter;
/* 473 */     String[] arrayOfString = (adapter = (Adapter<Distribution>)this.map.get(paramDistribution.getClass())).toParameters(paramDistribution);
/* 474 */     String str = adapter.category; int i; byte b;
/* 475 */     for (i = (arrayOfString = arrayOfString).length, b = 0; b < i; ) { String str1 = arrayOfString[b];
/* 476 */       str = str + "," + str1; b++; }
/* 477 */      return str;
/*     */   }
/*     */   
/*     */   private static DistributionFormatException invalidNumberOfArgumentsException(int paramInt, int... paramVarArgs) {
/* 481 */     String str = "Found " + paramInt + " arguments in triangular distribution; expected ";
/* 482 */     if (paramVarArgs.length < 2) {
/* 483 */       str = str + paramVarArgs.length;
/*     */     } else {
/* 485 */       String str1 = "";
/* 486 */       byte b = 0;
/* 487 */       while (b < paramVarArgs.length - 1) {
/* 488 */         str = str + str1 + paramVarArgs[b++];
/* 489 */         str1 = ", ";
/*     */       } 
/* 491 */       str = str + " or " + paramVarArgs[b];
/*     */     } 
/* 493 */     return new DistributionFormatException(str);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btre\\utils\DistributionAdapters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */