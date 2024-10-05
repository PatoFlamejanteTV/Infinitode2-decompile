/*     */ package com.prineside.tdi2.ui.actors;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.badlogic.gdx.utils.XmlReader;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Cell;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.ui.TextField;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.TextureRegionConfig;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class WebView extends Table implements Disposable {
/*  44 */   private static final TLog k = TLog.forClass(WebView.class);
/*     */   
/*     */   private Net.HttpRequest l;
/*     */   
/*  48 */   private final ObjectMap<String, String> n = new ObjectMap();
/*     */   
/*  50 */   private Array<WebViewListener> o = new Array(WebViewListener.class);
/*     */   public int pageWidth;
/*     */   public int pageHeight;
/*     */   
/*     */   public WebView() {
/*  55 */     this.n.put("tdi2-build", "207");
/*     */   }
/*     */   
/*     */   public void copyCookies(WebView paramWebView) {
/*  59 */     this.n.clear();
/*  60 */     this.n.putAll(paramWebView.n);
/*     */   }
/*     */   
/*     */   public void addListener(WebViewListener paramWebViewListener) {
/*  64 */     if (!this.o.contains(paramWebViewListener, true)) {
/*  65 */       this.o.add(paramWebViewListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeListener(WebViewListener paramWebViewListener) {
/*  70 */     this.o.removeValue(paramWebViewListener, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String a(Net.HttpRequest paramHttpRequest, String paramString) {
/*     */     StringBuilder stringBuilder;
/*  78 */     (stringBuilder = new StringBuilder()).append(paramHttpRequest.getUrl()).append(paramHttpRequest.getMethod()).append(paramHttpRequest.getContent()).append(paramString);
/*  79 */     return StringFormatter.md5Hash(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   private static Color a(String paramString) {
/*  83 */     Color color = Color.WHITE.cpy();
/*     */     try {
/*  85 */       if (paramString.startsWith("#")) {
/*  86 */         if (paramString.length() == 9) {
/*  87 */           Color.rgb888ToColor(color, Integer.parseInt(paramString.substring(1, 7), 16));
/*  88 */           color.a = Integer.parseInt(paramString.substring(7), 16) / 255.0F;
/*     */         } else {
/*  90 */           Color.rgb888ToColor(color, Integer.parseInt(paramString.substring(1), 16));
/*     */         } 
/*     */       } else {
/*  93 */         String[] arrayOfString; if (paramString.contains(":")) {
/*     */           
/*  95 */           arrayOfString = paramString.split(":");
/*  96 */           color.set(MaterialColor.allColors[MaterialColor.Colors.valueOf(arrayOfString[0]).ordinal()][MaterialColor.Variants.valueOf(arrayOfString[1]).ordinal()]);
/*     */         } else {
/*     */           
/*  99 */           color.set(MaterialColor.allColors[MaterialColor.Colors.valueOf((String)arrayOfString).ordinal()][MaterialColor.Variants.P500.ordinal()]);
/*     */         } 
/*     */       } 
/* 102 */     } catch (Exception exception) {
/* 103 */       k.e("Failed to read color", new Object[] { exception });
/*     */     } 
/*     */     
/* 106 */     return color;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Color a(XmlReader.Element paramElement) {
/*     */     String str;
/* 115 */     if ((str = paramElement.getAttribute("color", null)) != null) {
/* 116 */       return a(str);
/*     */     }
/*     */     
/* 119 */     return Color.WHITE.cpy();
/*     */   }
/*     */   
/*     */   private static String a(XmlReader.Element paramElement, String paramString1, String paramString2) {
/*     */     String str;
/* 124 */     if ((str = paramElement.getAttribute(paramString1, paramString2)).contains("&")) {
/* 125 */       return str.replaceAll("&amp;", "&").replaceAll("&quot;", "\"").replaceAll("&apos;", "'").replaceAll("&lt;", "<").replaceAll("&gt;", ">");
/*     */     }
/*     */     
/* 128 */     return str;
/*     */   }
/*     */   
/*     */   private static void a(Group paramGroup, XmlReader.Element paramElement, String paramString) {
/* 132 */     float f1 = paramElement.getFloatAttribute("size", 0.0F);
/* 133 */     float f2 = paramElement.getFloatAttribute("width", f1);
/* 134 */     paramElement.getFloatAttribute("height", f1);
/*     */     
/* 136 */     String[] arrayOfString = paramString.split(":"); try {
/*     */       Array array; byte b;
/* 138 */       switch (arrayOfString[0]) {
/*     */         
/*     */         case "player-level-badge":
/* 141 */           array = Game.i.authManager.getProfileLevelTextures(Integer.parseInt(arrayOfString[1]));
/* 142 */           for (b = 0; b < array.size; b++) {
/* 143 */             paramGroup.addActor((Actor)((TextureRegionConfig[])array.items)[b].createImage(0.0F, 0.0F, f2));
/*     */           }
/*     */           return;
/*     */       } 
/*     */ 
/*     */       
/* 149 */       k.e("div data not recognized (" + b + ")", new Object[0]);
/*     */       
/*     */       return;
/* 152 */     } catch (Exception exception) {
/* 153 */       k.e("failed to generate div data", new Object[] { exception });
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(Group paramGroup, XmlReader.Element paramElement, SharedStyle paramSharedStyle) {
/* 158 */     Table table = null;
/*     */     
/* 160 */     if (paramGroup instanceof Table) {
/* 161 */       table = (Table)paramGroup;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 166 */     paramSharedStyle = paramSharedStyle.cpy();
/* 167 */     if (paramElement.hasAttribute("font-size")) {
/*     */       try {
/* 169 */         paramSharedStyle.fontSize = Integer.parseInt(paramElement.getAttribute("font-size"));
/* 170 */       } catch (Exception exception) {
/* 171 */         k.e("failed to read font-size of body", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 176 */     for (byte b = 0; b < paramElement.getChildCount(); b++) {
/*     */       Label label1; Table table1; Group group1; SelectBox selectBox; TextFieldXPlatform textFieldXPlatform1; String str1; FancyButton fancyButton; float[] arrayOfFloat; QuadActor quadActor1; Image image; String str2; QuadActor quadActor2; byte b1; Label label2; Array array; int i; TextFieldXPlatform textFieldXPlatform2; Table table2; SelectBox.SelectBoxStyle selectBoxStyle; Group group2; SelectOption selectOption; byte b2;
/*     */       String str3;
/* 179 */       XmlReader.Element element = paramElement.getChild(b);
/* 180 */       Cell cell = null;
/* 181 */       JsonValue.JsonIterator<JsonValue> jsonIterator = null;
/*     */       
/* 183 */       switch (element.getName()) {
/*     */         case "br":
/* 185 */           if (table != null) {
/* 186 */             table.row();
/*     */           }
/*     */           break;
/*     */         case "label":
/* 190 */           i = paramSharedStyle.fontSize;
/*     */           
/*     */           try {
/* 193 */             if ((str2 = element.getAttribute("font-size", null)) != null) i = Integer.parseInt(str2); 
/* 194 */           } catch (Exception exception) {
/* 195 */             k.e("Failed to read font-size", new Object[] { exception });
/*     */           } 
/*     */           
/* 198 */           str2 = element.getText();
/* 199 */           if (element.hasAttribute("i18nf") && str2 != null) {
/*     */             
/*     */             try {
/* 202 */               JsonValue jsonValue = (new JsonReader()).parse(a(element, "i18nf", "[]"));
/* 203 */               byte b3 = 0;
/* 204 */               for (JsonValue.JsonIterator jsonIterator1 = jsonValue.iterator(); jsonIterator1.hasNext(); ) { jsonIterator1.next();
/* 205 */                 b3++; }
/*     */               
/* 207 */               Object[] arrayOfObject = new Object[b3];
/*     */               
/* 209 */               b3 = 0;
/* 210 */               for (jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) { jsonValue = jsonIterator.next();
/*     */                 try {
/* 212 */                   int j = jsonValue.asInt();
/* 213 */                   arrayOfObject[b3] = Integer.valueOf(j);
/* 214 */                 } catch (Exception exception) {
/*     */                   try {
/* 216 */                     float f = jsonValue.asFloat();
/* 217 */                     arrayOfObject[b3] = Float.valueOf(f);
/* 218 */                   } catch (Exception exception1) {
/* 219 */                     arrayOfObject[b3] = jsonValue.asString();
/*     */                   } 
/*     */                 } 
/* 222 */                 b3++; }
/*     */               
/* 224 */               str2 = Game.i.localeManager.i18n.formatStr(str2, arrayOfObject);
/* 225 */             } catch (Exception exception) {
/* 226 */               k.e("failed to parse i18nf", new Object[] { exception });
/*     */             } 
/*     */           }
/*     */           
/* 230 */           if (str2 != null) {
/* 231 */             str2 = Game.i.assetManager.replaceRegionAliasesWithChars(str2).toString();
/*     */           }
/*     */ 
/*     */           
/* 235 */           if (element.hasAttribute("label-max-width")) {
/* 236 */             int j = i;
/* 237 */             if (element.hasAttribute("font-min-size")) {
/* 238 */               j = Integer.parseInt(element.getAttribute("font-min-size"));
/*     */             }
/* 240 */             label2 = new LimitedWidthLabel(str2, i, j, Float.parseFloat(element.getAttribute("label-max-width")));
/*     */           } else {
/* 242 */             label2 = new Label(str2, Game.i.assetManager.getLabelStyle(i));
/*     */           } 
/* 244 */           if (!element.hasAttribute("nowrap")) {
/*     */             
/* 246 */             label2.setWrap(true);
/* 247 */             label2.invalidate();
/* 248 */             label2.pack();
/*     */           } 
/* 250 */           label1 = label2;
/*     */           
/* 252 */           if (element.hasAttribute("text-align")) {
/*     */             try {
/*     */               String str;
/* 255 */               switch (str = element.getAttribute("text-align")) { case "left":
/* 256 */                   label2.setAlignment(8); break;
/* 257 */                 case "center": label2.setAlignment(1); break;
/* 258 */                 case "right": label2.setAlignment(16); break;
/* 259 */                 case "top": label2.setAlignment(2); break;
/* 260 */                 case "bottom": label2.setAlignment(4); break;
/* 261 */                 case "topLeft": label2.setAlignment(10); break;
/* 262 */                 case "topRight": label2.setAlignment(18); break;
/* 263 */                 case "bottomLeft": label2.setAlignment(12); break;
/* 264 */                 case "bottomRight": label2.setAlignment(20); break; }
/*     */             
/* 266 */             } catch (Exception exception) {
/* 267 */               k.e("failed to read cell-align", new Object[] { exception });
/*     */             } 
/*     */           }
/*     */           
/* 271 */           if (table != null) {
/* 272 */             cell = table.add((Actor)label2); break;
/*     */           } 
/* 274 */           paramGroup.addActor((Actor)label2);
/*     */           break;
/*     */ 
/*     */         
/*     */         case "table":
/* 279 */           table2 = new Table();
/* 280 */           if (table != null) {
/* 281 */             cell = table.add((Actor)table2);
/*     */           } else {
/* 283 */             paramGroup.addActor((Actor)table2);
/*     */           } 
/* 285 */           a((Group)table2, element, paramSharedStyle);
/* 286 */           table1 = table2;
/*     */           break;
/*     */ 
/*     */         
/*     */         case "div":
/* 291 */           (group2 = new Group()).setTransform(false);
/* 292 */           if (table != null) {
/* 293 */             cell = table.add((Actor)group2);
/*     */           } else {
/* 295 */             paramGroup.addActor((Actor)group2);
/*     */           } 
/*     */           
/* 298 */           if (element.hasAttribute("data")) {
/* 299 */             String str = element.getAttribute("data");
/* 300 */             a(group2, element, str);
/*     */           } 
/*     */           
/* 303 */           a(group2, element, paramSharedStyle);
/* 304 */           group1 = group2;
/*     */           break;
/*     */         
/*     */         case "selectBox":
/* 308 */           selectBoxStyle = Game.i.assetManager.getSelectBoxStyle((BitmapFont)Game.i.assetManager.getFont(24), !element.hasAttribute("variantB"));
/*     */           
/* 310 */           selectBox = new SelectBox(selectBoxStyle);
/* 311 */           array = new Array();
/* 312 */           selectOption = null;
/* 313 */           for (b2 = 0; b2 < element.getChildCount(); b2++) {
/*     */             XmlReader.Element element1;
/* 315 */             if ((element1 = element.getChild(b2)).getName().equals("option")) {
/*     */               SelectOption selectOption1;
/* 317 */               (selectOption1 = new SelectOption((byte)0)).value = element1.getAttribute("value");
/* 318 */               selectOption1.text = element1.getText();
/* 319 */               if (selectOption1.text == null || selectOption1.text.length() == 0) {
/* 320 */                 selectOption1.text = selectOption1.value;
/*     */               } else {
/* 322 */                 selectOption1.text = Game.i.assetManager.replaceRegionAliasesWithChars(selectOption1.text).toString();
/*     */               } 
/* 324 */               if (element1.hasAttribute("selected")) {
/* 325 */                 selectOption = selectOption1;
/*     */               }
/* 327 */               array.add(selectOption1);
/*     */             } else {
/* 329 */               k.e("unknown tag <" + element1.getName() + "> inside of <selectBox>", new Object[0]);
/*     */             } 
/*     */           } 
/* 332 */           selectBox.setItems(array);
/* 333 */           if (selectOption != null) {
/* 334 */             selectBox.setSelected(selectOption);
/*     */           }
/*     */           
/* 337 */           if (table != null) {
/* 338 */             cell = table.add((Actor)selectBox);
/*     */           } else {
/* 340 */             paramGroup.addActor((Actor)selectBox);
/*     */           } 
/* 342 */           selectBox = selectBox;
/*     */           break;
/*     */ 
/*     */         
/*     */         case "textField":
/* 347 */           str3 = "";
/* 348 */           str2 = null;
/* 349 */           if (element.hasAttribute("value")) {
/* 350 */             str3 = element.getAttribute("value");
/*     */           }
/* 352 */           if (element.hasAttribute("placeholder")) {
/* 353 */             str2 = element.getAttribute("placeholder");
/*     */           }
/*     */           
/* 356 */           textFieldXPlatform2 = new TextFieldXPlatform(str3, Game.i.assetManager.getTextFieldStyleWithVariant(24, !element.hasAttribute("variantB")));
/* 357 */           if (str2 != null) {
/* 358 */             textFieldXPlatform2.setMessageText(str2);
/*     */           }
/* 360 */           if (table != null) {
/* 361 */             cell = table.add((Actor)textFieldXPlatform2);
/*     */           } else {
/* 363 */             paramGroup.addActor((Actor)textFieldXPlatform2);
/*     */           } 
/* 365 */           textFieldXPlatform1 = textFieldXPlatform2;
/*     */           break;
/*     */ 
/*     */         
/*     */         case "rectButton":
/* 370 */           str1 = element.hasAttribute("variantB") ? "regularButton.b" : "regularButton.a";
/*     */           
/* 372 */           fancyButton = (new FancyButton(str1, null)).withLabel(24, Game.i.assetManager.replaceRegionAliasesWithChars(element.getText()));
/* 373 */           if (table != null) {
/* 374 */             cell = table.add((Actor)fancyButton);
/*     */           } else {
/* 376 */             paramGroup.addActor((Actor)fancyButton);
/*     */           } 
/* 378 */           fancyButton = fancyButton;
/*     */           break;
/*     */ 
/*     */         
/*     */         case "quad":
/* 383 */           arrayOfFloat = new float[8];
/*     */           
/*     */           try {
/* 386 */             if ((str2 = element.getAttribute("positions", null)) != null) {
/*     */               String[] arrayOfString;
/* 388 */               if ((arrayOfString = str2.split(",")).length == 8) {
/* 389 */                 for (byte b3 = 0; b3 < 8; b3++) {
/* 390 */                   arrayOfFloat[b3] = Float.parseFloat(arrayOfString[b3]);
/*     */                 }
/*     */               } else {
/* 393 */                 throw new IllegalArgumentException("positions for quad must be defined as comma separated 8 floats");
/*     */               } 
/*     */             } 
/* 396 */           } catch (Exception exception) {
/* 397 */             k.e("Failed to read font-size", new Object[] { exception });
/*     */           } 
/*     */           
/* 400 */           quadActor2 = new QuadActor(Color.WHITE, arrayOfFloat);
/* 401 */           if (table != null) {
/* 402 */             cell = table.add((Actor)quadActor2);
/*     */           } else {
/* 404 */             paramGroup.addActor((Actor)quadActor2);
/*     */           } 
/* 406 */           quadActor1 = quadActor2;
/*     */           break;
/*     */         
/*     */         case "img":
/*     */           try {
/*     */             String str;
/* 412 */             if ((str = a(element, "src", (String)null)) != null) {
/* 413 */               Image image1 = new Image();
/*     */               
/* 415 */               if (str.startsWith("?")) {
/*     */                 
/* 417 */                 str = str.substring(1);
/*     */                 try {
/* 419 */                   Game.i.assetManager.getDrawable(str);
/* 420 */                 } catch (Exception exception) {
/*     */                   
/* 422 */                   str = "https://files.prineside.com/static/infinitode_website/optional/" + str + ".png";
/*     */                 } 
/*     */               } 
/* 425 */               if (str.startsWith("/"))
/*     */               {
/* 427 */                 str = Config.SITE_URL + str;
/*     */               }
/*     */               
/* 430 */               if (str.startsWith("http://") || str.startsWith("https://")) {
/*     */                 
/* 432 */                 image1.setDrawable((Drawable)new TextureRegionDrawable((TextureRegion)Game.i.assetManager.loadWebTexture(str)));
/*     */               } else {
/*     */                 TextureRegionDrawable textureRegionDrawable;
/* 435 */                 textFieldXPlatform2 = null;
/*     */                 try {
/* 437 */                   textureRegionDrawable = Game.i.assetManager.getDrawable(str);
/* 438 */                 } catch (Exception exception) {
/* 439 */                   k.e("drawable " + str + " not found", new Object[0]);
/*     */                 } 
/*     */                 
/* 442 */                 if (textureRegionDrawable != null) {
/* 443 */                   image1.setDrawable((Drawable)textureRegionDrawable);
/*     */                 }
/*     */               } 
/*     */               
/* 447 */               image = image1;
/* 448 */               if (table != null) {
/* 449 */                 cell = table.add((Actor)image1); break;
/*     */               } 
/* 451 */               paramGroup.addActor((Actor)image1);
/*     */               break;
/*     */             } 
/* 454 */             k.e("img has no src", new Object[0]);
/*     */           }
/* 456 */           catch (Exception exception) {
/* 457 */             k.e("failed to load img", new Object[] { exception });
/*     */           }  break;
/*     */         default:
/* 460 */           k.e("unknown tag type: " + element.getName(), new Object[0]);
/*     */           break;
/*     */       } 
/* 463 */       if (image != null) {
/* 464 */         if (element.hasAttribute("click")) {
/*     */           try {
/* 466 */             image.setTouchable(Touchable.enabled);
/* 467 */             String str4 = a(element, "click", "");
/*     */             
/* 469 */             String str5 = a(element, "target", "");
/*     */             
/* 471 */             Runnable runnable = () -> {
/*     */                 if (paramString1.startsWith("secretCode:")) {
/*     */                   Game.i.secretCodeManager.applyCode(paramString1.substring(11));
/*     */                   return;
/*     */                 } 
/*     */                 if (paramString1.startsWith("url:")) {
/*     */                   Gdx.net.openURI(paramString1.substring(4));
/*     */                   return;
/*     */                 } 
/*     */                 if (paramString1.startsWith("xdx:")) {
/*     */                   if (paramString2.equals("modal")) {
/*     */                     for (byte b = 0; b < this.o.size; b++)
/*     */                       ((WebViewListener)this.o.get(b)).modalLoadRequested(paramString1.substring(4)); 
/*     */                     return;
/*     */                   } 
/*     */                   loadUrl("GET", paramString1.substring(4), (Map<String, String>)null);
/*     */                   return;
/*     */                 } 
/*     */                 if (paramString1.startsWith("xdxFormSubmit:")) {
/*     */                   b(paramString1.substring(14));
/*     */                   return;
/*     */                 } 
/*     */                 k.e("unknown click attribute: " + paramString1, new Object[0]);
/*     */               };
/* 495 */             if (image instanceof TableButton) {
/*     */               TableButton tableButton;
/* 497 */               (tableButton = (TableButton)image).setClickHandler(runnable);
/*     */             } else {
/* 499 */               image.addListener((EventListener)new ClickListener(this, runnable)
/*     */                   {
/*     */                     public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 502 */                       this.a.run();
/*     */                     }
/*     */                   });
/*     */             } 
/* 506 */           } catch (Exception exception) {
/* 507 */             k.e("failed to read click", new Object[] { exception });
/*     */           } 
/*     */         }
/* 510 */         if (element.hasAttribute("width")) {
/*     */           try {
/* 512 */             image.setWidth(Float.parseFloat(element.getAttribute("width")));
/* 513 */           } catch (Exception exception) {
/* 514 */             k.e("failed to read width", new Object[] { exception });
/*     */           } 
/*     */         }
/* 517 */         if (element.hasAttribute("height")) {
/*     */           try {
/* 519 */             image.setHeight(Float.parseFloat(element.getAttribute("height")));
/* 520 */           } catch (Exception exception) {
/* 521 */             k.e("failed to read height", new Object[] { exception });
/*     */           } 
/*     */         }
/* 524 */         if (element.hasAttribute("size")) {
/*     */           try {
/* 526 */             float f = Float.parseFloat(element.getAttribute("size"));
/* 527 */             image.setSize(f, f);
/* 528 */           } catch (Exception exception) {
/* 529 */             k.e("failed to read size", new Object[] { exception });
/*     */           } 
/*     */         }
/* 532 */         Color color = a(element);
/* 533 */         image.setColor(color);
/* 534 */         if (element.hasAttribute("hover-color")) {
/*     */           try {
/* 536 */             Color color1 = a(element.getAttribute("hover-color"));
/* 537 */             Image image1 = image;
/* 538 */             image.addListener((EventListener)new InputListener(this, (Actor)image1, color1, color) {
/*     */                   public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 540 */                     this.a.setColor(this.b);
/*     */                   }
/*     */                   
/*     */                   public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 544 */                     this.a.setColor(this.c);
/*     */                   }
/*     */                 });
/* 547 */           } catch (Exception exception) {
/* 548 */             k.e("failed to read x", new Object[] { exception });
/*     */           } 
/*     */         }
/* 551 */         if (element.hasAttribute("x")) {
/*     */           try {
/* 553 */             float f = Float.parseFloat(element.getAttribute("x"));
/* 554 */             image.setX(f);
/* 555 */           } catch (Exception exception) {
/* 556 */             k.e("failed to read x", new Object[] { exception });
/*     */           } 
/*     */         }
/* 559 */         if (element.hasAttribute("y")) {
/*     */           try {
/* 561 */             float f = Float.parseFloat(element.getAttribute("y"));
/* 562 */             image.setY(f);
/* 563 */           } catch (Exception exception) {
/* 564 */             k.e("failed to read y", new Object[] { exception });
/*     */           } 
/*     */         }
/* 567 */         if (element.hasAttribute("untouchable")) {
/* 568 */           image.setTouchable(Touchable.disabled);
/*     */         }
/* 570 */         if (element.hasAttribute("debug")) {
/* 571 */           image.setDebug(true);
/*     */         }
/* 573 */         if (element.hasAttribute("id")) {
/* 574 */           image.setName(element.getAttribute("id"));
/*     */         }
/*     */ 
/*     */         
/* 578 */         if (element.getAttributes() != null) {
/* 579 */           ObjectMap objectMap = new ObjectMap();
/* 580 */           for (ObjectMap.Entries<ObjectMap.Entry> entries = element.getAttributes().iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 581 */             objectMap.put(entry.key, entry.value); }
/*     */           
/* 583 */           image.setUserObject(objectMap);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 588 */       if (cell != null && cell.hasActor()) {
/*     */         
/* 590 */         if (element.hasAttribute("fill-x")) {
/* 591 */           cell.fillX();
/*     */         }
/* 593 */         if (element.hasAttribute("fill-y")) {
/* 594 */           cell.fillY();
/*     */         }
/* 596 */         if (element.hasAttribute("expand-x")) {
/* 597 */           cell.expandX();
/*     */         }
/* 599 */         if (element.hasAttribute("expand-y")) {
/* 600 */           cell.expandY();
/*     */         }
/* 602 */         if (element.hasAttribute("grow-x")) {
/* 603 */           cell.growX();
/*     */         }
/* 605 */         if (element.hasAttribute("grow-y")) {
/* 606 */           cell.growY();
/*     */         }
/* 608 */         if (element.hasAttribute("pad-left")) {
/*     */           try {
/* 610 */             cell.padLeft(Float.parseFloat(element.getAttribute("pad-left")));
/* 611 */           } catch (Exception exception) {
/* 612 */             k.e("failed to read pad-left", new Object[] { exception });
/*     */           } 
/*     */         }
/* 615 */         if (element.hasAttribute("pad-right")) {
/*     */           try {
/* 617 */             cell.padRight(Float.parseFloat(element.getAttribute("pad-right")));
/* 618 */           } catch (Exception exception) {
/* 619 */             k.e("failed to read pad-right", new Object[] { exception });
/*     */           } 
/*     */         }
/* 622 */         if (element.hasAttribute("pad-top")) {
/*     */           try {
/* 624 */             cell.padTop(Float.parseFloat(element.getAttribute("pad-top")));
/* 625 */           } catch (Exception exception) {
/* 626 */             k.e("failed to read pad-top", new Object[] { exception });
/*     */           } 
/*     */         }
/* 629 */         if (element.hasAttribute("pad-bottom")) {
/*     */           try {
/* 631 */             cell.padBottom(Float.parseFloat(element.getAttribute("pad-bottom")));
/* 632 */           } catch (Exception exception) {
/* 633 */             k.e("failed to read pad-bottom", new Object[] { exception });
/*     */           } 
/*     */         }
/* 636 */         if (element.hasAttribute("width")) {
/*     */           try {
/* 638 */             cell.width(Float.parseFloat(element.getAttribute("width")));
/* 639 */           } catch (Exception exception) {
/* 640 */             k.e("failed to read width", new Object[] { exception });
/*     */           } 
/*     */         }
/* 643 */         if (element.hasAttribute("height")) {
/*     */           try {
/* 645 */             cell.height(Float.parseFloat(element.getAttribute("height")));
/* 646 */           } catch (Exception exception) {
/* 647 */             k.e("failed to read height", new Object[] { exception });
/*     */           } 
/*     */         }
/* 650 */         if (element.hasAttribute("size")) {
/*     */           try {
/* 652 */             cell.size(Float.parseFloat(element.getAttribute("size")));
/* 653 */           } catch (Exception exception) {
/* 654 */             k.e("failed to read size", new Object[] { exception });
/*     */           } 
/*     */         }
/* 657 */         cell.top().left();
/* 658 */         if (element.hasAttribute("align")) {
/*     */           try {
/*     */             String str;
/* 661 */             switch (str = element.getAttribute("align")) {
/*     */               case "left":
/* 663 */                 cell.left();
/*     */                 break;
/*     */               case "right":
/* 666 */                 cell.right();
/*     */                 break;
/*     */               case "center":
/* 669 */                 cell.center();
/*     */                 break;
/*     */             } 
/* 672 */           } catch (Exception exception) {
/* 673 */             k.e("failed to read cell-align", new Object[] { exception });
/*     */           } 
/*     */         }
/* 676 */         if (element.hasAttribute("colspan")) {
/*     */           try {
/* 678 */             int j = element.getIntAttribute("colspan");
/* 679 */             cell.colspan(j);
/* 680 */           } catch (Exception exception) {
/* 681 */             k.e("failed to read colspan", new Object[] { exception });
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 687 */         if (image instanceof Label && !element.hasAttribute("width")) {
/* 688 */           cell.fillX();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void stopCurrentRequest() {
/* 695 */     if (this.l != null) {
/* 696 */       Gdx.net.cancelHttpRequest(this.l);
/* 697 */       this.l = null;
/*     */     } 
/*     */   } private static void a(Actor paramActor, ObjectMap<String, String> paramObjectMap) {
/*     */     ObjectMap objectMap;
/*     */     String str;
/* 702 */     if (paramActor.getUserObject() instanceof ObjectMap && (
/*     */ 
/*     */       
/* 705 */       str = (String)(objectMap = (ObjectMap)paramActor.getUserObject()).get("form-name")) != null) {
/*     */       
/* 707 */       if (paramActor instanceof TextField) {
/* 708 */         paramObjectMap.put(str, ((TextField)paramActor).getText());
/*     */       }
/* 710 */       if (paramActor instanceof SelectBox) {
/* 711 */         paramObjectMap.put(str, ((SelectOption)((SelectBox)paramActor).getSelected()).value);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 719 */     if (paramActor instanceof Table) {
/* 720 */       for (Array.ArrayIterator<Cell> arrayIterator = ((Table)paramActor).getCells().iterator(); arrayIterator.hasNext();) {
/*     */         
/* 722 */         if ((paramActor = (cell = arrayIterator.next()).getActor()) != null)
/* 723 */           a(paramActor, paramObjectMap); 
/*     */       }  return;
/*     */     } 
/* 726 */     if (paramActor instanceof Group) {
/* 727 */       for (Array.ArrayIterator<Actor> arrayIterator = ((Group)paramActor).getChildren().iterator(); arrayIterator.hasNext();) {
/* 728 */         a(actor = arrayIterator.next(), paramObjectMap);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(String paramString) {
/* 734 */     k.i("submitForm " + paramString, new Object[0]);
/*     */     Actor actor;
/* 736 */     if ((actor = findActor(paramString)) == null) {
/* 737 */       k.e("submitForm failed - no form with id '" + paramString + "'", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 741 */     if (!(actor.getUserObject() instanceof ObjectMap)) {
/* 742 */       k.e("submitForm failed - form actor '" + paramString + "' has no ObjectMap with attributes", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     ObjectMap objectMap;
/* 748 */     String str2 = (String)(objectMap = (ObjectMap)actor.getUserObject()).get("form-method", "POST");
/*     */     String str3;
/* 750 */     if ((str3 = (String)objectMap.get("form-url", null)) == null) {
/* 751 */       k.e("submitForm failed - form-url not set", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 755 */     String str1 = (String)objectMap.get("form-target", "this");
/*     */     
/* 757 */     ObjectMap<String, String> objectMap1 = new ObjectMap();
/* 758 */     a(actor, objectMap1);
/* 759 */     k.i("form method: " + str2, new Object[0]);
/* 760 */     k.i("form url: " + str3, new Object[0]);
/* 761 */     k.i("form target: " + str1, new Object[0]);
/* 762 */     k.i("form fields: " + objectMap1.toString(","), new Object[0]);
/*     */     
/* 764 */     if (str3.startsWith("xdx:"))
/*     */     {
/* 766 */       if (!"modal".equals(str1)) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 771 */         HashMap<Object, Object> hashMap = new HashMap<>();
/* 772 */         for (ObjectMap.Entries<ObjectMap.Entry> entries = objectMap1.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 773 */           hashMap.put(entry.key, entry.value); }
/*     */         
/* 775 */         loadUrl(str2, str3.substring(4), (Map)hashMap);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadUrl(String paramString1, String paramString2, Map<String, String> paramMap) {
/* 784 */     stopCurrentRequest();
/*     */     
/* 786 */     if (Config.isModdingMode()) {
/*     */       return;
/*     */     }
/*     */     
/* 790 */     Net.HttpRequest httpRequest = new Net.HttpRequest(paramString1);
/* 791 */     if (paramString1.equals("GET") && paramMap != null)
/*     */     {
/* 793 */       if (paramString2.contains("?")) {
/* 794 */         int i = paramString2.indexOf('?');
/* 795 */         String str = paramString2.substring(i + 1);
/* 796 */         paramString2 = paramString2.substring(0, i);
/* 797 */         k.i("splitting get part: " + paramString2 + " | " + str, new Object[0]);
/*     */         String[] arrayOfString1, arrayOfString2;
/* 799 */         for (int j = (arrayOfString2 = arrayOfString1 = str.split("&")).length; i < j; i++) {
/* 800 */           String[] arrayOfString = (str = arrayOfString2[i]).split("=");
/* 801 */           paramMap.put(arrayOfString[0], arrayOfString[1]);
/*     */         } 
/*     */       } 
/*     */     }
/* 805 */     if (paramMap != null) {
/* 806 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(paramMap));
/*     */     }
/* 808 */     httpRequest.setUrl(paramString2);
/*     */     
/* 810 */     k.i("url: " + paramString2, new Object[0]);
/* 811 */     k.i("data: " + paramMap, new Object[0]);
/* 812 */     k.i("method: " + paramString1, new Object[0]);
/*     */ 
/*     */     
/* 815 */     synchronized (this.n) {
/* 816 */       this.n.put("tdi2-locale", Game.i.localeManager.getLocale());
/* 817 */       this.n.put("tdi2-platform", Gdx.app.getType().name());
/* 818 */       this.n.put("tdi2-build", "207");
/*     */ 
/*     */       
/* 821 */       if (Game.i.authManager.getSignInStatus() == AuthManager.SignInStatus.SIGNED_IN && Game.i.authManager.getSessionId() != null) {
/* 822 */         this.n.put("tdi2-session", Game.i.authManager.getSessionId());
/*     */       } else {
/* 824 */         this.n.remove("tdi2-session");
/*     */       } 
/*     */       
/* 827 */       StringBuilder stringBuilder = new StringBuilder();
/* 828 */       byte b1 = 0; ObjectMap.Entries<ObjectMap.Entry> entries;
/* 829 */       for (entries = this.n.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 830 */         stringBuilder.append((String)entry.key).append("=").append((String)entry.value);
/* 831 */         b1++;
/* 832 */         if (b1 != this.n.size) {
/* 833 */           stringBuilder.append("; ");
/*     */         } }
/*     */       
/* 836 */       k.i("cookie: " + stringBuilder, new Object[0]);
/* 837 */       for (entries = this.n.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 838 */         k.i("- c: " + (String)entry.key + " = " + (String)entry.value, new Object[0]); }
/*     */ 
/*     */       
/* 841 */       httpRequest.setHeader("Cookie", stringBuilder.toString());
/*     */     } 
/* 843 */     String str1 = a(httpRequest, Game.i.localeManager.getLocale());
/*     */     
/* 845 */     for (byte b = 0; b < this.o.size; b++) {
/* 846 */       ((WebViewListener[])this.o.items)[b].urlLoadStart(httpRequest);
/*     */     }
/*     */     
/* 849 */     String str2 = paramString2;
/* 850 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, str1, str2, paramString1)
/*     */         {
/*     */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/* 853 */             String str = param1HttpResponse.getResultAsString();
/*     */             Map<?, ?> map;
/* 855 */             for (Iterator<Map.Entry> iterator = (map = param1HttpResponse.getHeaders()).entrySet().iterator(); iterator.hasNext();) {
/* 856 */               if ((entry = iterator.next()).getKey() != null && ((String)entry.getKey()).equals("Set-Cookie")) {
/*     */                 
/* 858 */                 WebView.d().i("Set-Cookie received (" + ((List)entry.getValue()).size() + " entries)", new Object[0]);
/* 859 */                 synchronized (WebView.a(this.d)) {
/*     */                   List<?> list;
/* 861 */                   for (String str1 : list = (List)entry.getValue()) {
/* 862 */                     WebView.d().i("- " + str1, new Object[0]);
/*     */                     
/* 864 */                     String[] arrayOfString1, arrayOfString2 = (arrayOfString1 = str1.split("="))[1].split(";");
/* 865 */                     WebView.a(this.d).put(arrayOfString1[0], arrayOfString2[0]);
/* 866 */                     WebView.d().i("cookie set: " + arrayOfString1[0] + " " + arrayOfString2[0], new Object[0]);
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 873 */             if (WebView.b(this.d)) {
/*     */               try {
/* 875 */                 Gdx.files.local("cache/web/" + this.a + ".xml").writeString(str, false, "UTF-8");
/* 876 */               } catch (Exception exception) {}
/*     */             }
/*     */             
/* 879 */             Threads.i().runOnMainThread(() -> {
/*     */                   this.d.loadPage(param1String);
/*     */                   WebView.a(this.d, (Net.HttpRequest)null);
/*     */                   for (byte b = 0; b < (WebView.c(this.d)).size; b++) {
/*     */                     ((WebView.WebViewListener[])(WebView.c(this.d)).items)[b].urlLoadFinish(true, param1String, false);
/*     */                   }
/*     */                 });
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void failed(Throwable param1Throwable) {
/* 891 */             WebView.d().e("failed: " + this.b + " (" + this.c + ")", new Object[] { param1Throwable });
/* 892 */             WebView.a(this.d, (Net.HttpRequest)null);
/* 893 */             Threads.i().runOnMainThread(() -> {
/*     */                   boolean bool = false;
/*     */                   
/*     */                   try {
/*     */                     FileHandle fileHandle;
/*     */                     if ((fileHandle = Gdx.files.local("cache/web/" + param1String + ".xml")).exists()) {
/*     */                       String str = fileHandle.readString("UTF-8");
/*     */                       this.d.loadPage(str);
/*     */                       bool = true;
/*     */                       for (byte b = 0; b < (WebView.c(this.d)).size; b++) {
/*     */                         ((WebView.WebViewListener[])(WebView.c(this.d)).items)[b].urlLoadFinish(true, str, true);
/*     */                       }
/*     */                     } 
/* 906 */                   } catch (Exception exception) {}
/*     */                   if (!bool) {
/*     */                     for (byte b = 0; b < (WebView.c(this.d)).size; b++) {
/*     */                       ((WebView.WebViewListener[])(WebView.c(this.d)).items)[b].urlLoadFinish(false, null, false);
/*     */                     }
/*     */                   }
/*     */                 });
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void cancelled() {
/* 919 */             WebView.d().i("cancelled: " + this.b + " (" + this.c + ")", new Object[0]);
/* 920 */             WebView.a(this.d, (Net.HttpRequest)null);
/*     */             
/* 922 */             Threads.i().runOnMainThread(() -> {
/*     */                   for (byte b = 0; b < (WebView.c(this.d)).size; b++) {
/*     */                     ((WebView.WebViewListener[])(WebView.c(this.d)).items)[b].urlLoadFinish(false, null, false);
/*     */                   }
/*     */                 });
/*     */           }
/*     */         });
/* 929 */     this.l = httpRequest;
/*     */   }
/*     */   
/*     */   public void loadPage(String paramString) {
/* 933 */     Preconditions.checkNotNull(paramString, "xml is null");
/*     */     
/* 935 */     clear();
/*     */     
/* 937 */     if (Game.i.settingsManager.isInDebugDetailedMode()) {
/* 938 */       k.i(paramString, new Object[0]);
/*     */     }
/*     */     try {
/* 941 */       XmlReader.Element element = (new XmlReader()).parse(paramString);
/* 942 */       this.pageWidth = 0;
/* 943 */       this.pageHeight = 0;
/* 944 */       if (element.hasAttribute("width") && element.hasAttribute("height")) {
/*     */         try {
/* 946 */           this.pageWidth = Integer.parseInt(element.getAttribute("width"));
/* 947 */           this.pageHeight = Integer.parseInt(element.getAttribute("height"));
/* 948 */         } catch (Exception exception) {
/* 949 */           k.e("failed to size of body", new Object[] { exception });
/*     */         } 
/*     */       }
/*     */       
/* 953 */       a((Group)this, element, new SharedStyle((byte)0));
/*     */       
/* 955 */       row();
/* 956 */       add().expand().fill().row();
/*     */       
/*     */       return;
/* 959 */     } catch (Exception exception) {
/* 960 */       k.e("failed to load page", new Object[] { exception });
/* 961 */       k.e(paramString, new Object[0]);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 967 */     clear();
/*     */   }
/*     */   
/*     */   private class SharedStyle {
/* 971 */     public int fontSize = 24;
/*     */ 
/*     */     
/*     */     public SharedStyle cpy() {
/*     */       SharedStyle sharedStyle;
/* 976 */       (sharedStyle = new SharedStyle()).fontSize = this.fontSize;
/*     */       
/* 978 */       return sharedStyle;
/*     */     }
/*     */ 
/*     */     
/*     */     private SharedStyle(WebView this$0) {}
/*     */   }
/*     */ 
/*     */   
/*     */   private static class SelectOption
/*     */   {
/*     */     public String value;
/*     */     public String text;
/*     */     
/*     */     private SelectOption() {}
/*     */     
/*     */     public String toString() {
/* 994 */       return this.text;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface WebViewListener {
/*     */     void urlLoadStart(Net.HttpRequest param1HttpRequest);
/*     */     
/*     */     void urlLoadFinish(boolean param1Boolean1, String param1String, boolean param1Boolean2);
/*     */     
/*     */     void modalLoadRequested(String param1String);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\WebView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */