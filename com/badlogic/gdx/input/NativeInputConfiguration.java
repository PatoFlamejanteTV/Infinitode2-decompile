/*     */ package com.badlogic.gdx.input;
/*     */ 
/*     */ import com.badlogic.gdx.Input;
/*     */ 
/*     */ 
/*     */ public class NativeInputConfiguration
/*     */ {
/*   8 */   private Input.OnscreenKeyboardType type = Input.OnscreenKeyboardType.Default;
/*     */   
/*     */   private boolean preventCorrection = false;
/*     */   private TextInputWrapper textInputWrapper;
/*     */   private boolean isMultiLine = false;
/*     */   private Integer maxLength;
/*     */   private Input.InputStringValidator validator;
/*  15 */   private String placeholder = "";
/*     */   private boolean showPasswordButton = false;
/*  17 */   private String[] autoComplete = null;
/*     */   
/*     */   public Input.OnscreenKeyboardType getType() {
/*  20 */     return this.type;
/*     */   }
/*     */ 
/*     */   
/*     */   public NativeInputConfiguration setType(Input.OnscreenKeyboardType paramOnscreenKeyboardType) {
/*  25 */     this.type = paramOnscreenKeyboardType;
/*  26 */     return this;
/*     */   }
/*     */   
/*     */   public boolean isPreventCorrection() {
/*  30 */     return this.preventCorrection;
/*     */   }
/*     */ 
/*     */   
/*     */   public NativeInputConfiguration setPreventCorrection(boolean paramBoolean) {
/*  35 */     this.preventCorrection = paramBoolean;
/*  36 */     return this;
/*     */   }
/*     */   
/*     */   public TextInputWrapper getTextInputWrapper() {
/*  40 */     return this.textInputWrapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public NativeInputConfiguration setTextInputWrapper(TextInputWrapper paramTextInputWrapper) {
/*  45 */     this.textInputWrapper = paramTextInputWrapper;
/*  46 */     return this;
/*     */   }
/*     */   
/*     */   public boolean isMultiLine() {
/*  50 */     return this.isMultiLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public NativeInputConfiguration setMultiLine(boolean paramBoolean) {
/*  55 */     this.isMultiLine = paramBoolean;
/*  56 */     return this;
/*     */   }
/*     */   
/*     */   public Integer getMaxLength() {
/*  60 */     return this.maxLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public NativeInputConfiguration setMaxLength(Integer paramInteger) {
/*  65 */     this.maxLength = paramInteger;
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public Input.InputStringValidator getValidator() {
/*  70 */     return this.validator;
/*     */   }
/*     */ 
/*     */   
/*     */   public NativeInputConfiguration setValidator(Input.InputStringValidator paramInputStringValidator) {
/*  75 */     this.validator = paramInputStringValidator;
/*  76 */     return this;
/*     */   }
/*     */   
/*     */   public String getPlaceholder() {
/*  80 */     return this.placeholder;
/*     */   }
/*     */ 
/*     */   
/*     */   public NativeInputConfiguration setPlaceholder(String paramString) {
/*  85 */     this.placeholder = paramString;
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   public boolean isShowPasswordButton() {
/*  90 */     return this.showPasswordButton;
/*     */   }
/*     */ 
/*     */   
/*     */   public NativeInputConfiguration setShowPasswordButton(boolean paramBoolean) {
/*  95 */     this.showPasswordButton = paramBoolean;
/*  96 */     return this;
/*     */   }
/*     */   
/*     */   public String[] getAutoComplete() {
/* 100 */     return this.autoComplete;
/*     */   }
/*     */   
/*     */   public NativeInputConfiguration setAutoComplete(String[] paramArrayOfString) {
/* 104 */     this.autoComplete = paramArrayOfString;
/* 105 */     return this;
/*     */   }
/*     */   
/*     */   public void validate() {
/* 109 */     String str = null;
/* 110 */     if (this.type == null) str = "OnscreenKeyboardType needs to be non null"; 
/* 111 */     if (this.textInputWrapper == null) str = "TextInputWrapper needs to be non null"; 
/* 112 */     if (this.showPasswordButton && this.type != Input.OnscreenKeyboardType.Password)
/* 113 */       str = "ShowPasswordButton only works with OnscreenKeyboardType.Password"; 
/* 114 */     if (this.placeholder == null) str = "Placeholder needs to be non null"; 
/* 115 */     if (this.autoComplete != null && this.type != Input.OnscreenKeyboardType.Default)
/* 116 */       str = "AutoComplete should only be used with OnscreenKeyboardType.Default"; 
/* 117 */     if (this.autoComplete != null && this.isMultiLine) str = "AutoComplete shouldn't be used with multiline";
/*     */     
/* 119 */     if (str != null)
/* 120 */       throw new IllegalArgumentException("NativeInputConfiguration validation failed: " + str); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\input\NativeInputConfiguration.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */