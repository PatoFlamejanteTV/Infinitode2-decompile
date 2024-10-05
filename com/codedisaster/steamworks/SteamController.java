/*     */ package com.codedisaster.steamworks;public class SteamController extends SteamInterface { public static final int STEAM_CONTROLLER_MAX_COUNT = 16; public static final int STEAM_CONTROLLER_MAX_ANALOG_ACTIONS = 16; public static final int STEAM_CONTROLLER_MAX_DIGITAL_ACTIONS = 128;
/*     */   public static final int STEAM_CONTROLLER_MAX_ORIGINS = 8;
/*     */   public static final long STEAM_CONTROLLER_HANDLE_ALL_CONTROLLERS = -1L;
/*     */   public static final float STEAM_CONTROLLER_MIN_ANALOG_ACTION_DATA = -1.0F;
/*     */   public static final float STEAM_CONTROLLER_MAX_ANALOG_ACTION_DATA = 1.0F;
/*     */   
/*   7 */   public enum Pad { Left,
/*   8 */     Right; }
/*     */ 
/*     */   
/*     */   public enum Source {
/*  12 */     None,
/*  13 */     LeftTrackpad,
/*  14 */     RightTrackpad,
/*  15 */     Joystick,
/*  16 */     ABXY,
/*  17 */     Switch,
/*  18 */     LeftTrigger,
/*  19 */     RightTrigger,
/*  20 */     LeftBumper,
/*  21 */     RightBumper,
/*  22 */     Gyro,
/*  23 */     CenterTrackpad,
/*  24 */     RightJoystick,
/*  25 */     DPad,
/*  26 */     Key,
/*  27 */     Mouse,
/*  28 */     LeftGyro;
/*     */   }
/*     */   
/*     */   public enum SourceMode {
/*  32 */     None,
/*  33 */     Dpad,
/*  34 */     Buttons,
/*  35 */     FourButtons,
/*  36 */     AbsoluteMouse,
/*  37 */     RelativeMouse,
/*  38 */     JoystickMove,
/*  39 */     JoystickMouse,
/*  40 */     JoystickCamera,
/*  41 */     ScrollWheel,
/*  42 */     Trigger,
/*  43 */     TouchMenu,
/*  44 */     MouseJoystick,
/*  45 */     MouseRegion,
/*  46 */     RadialMenu,
/*  47 */     SingleButton,
/*  48 */     Switches;
/*     */     
/*  50 */     private static final SourceMode[] values = values(); static {
/*     */     
/*     */     } static SourceMode byOrdinal(int param1Int) {
/*  53 */       return values[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   public enum ActionOrigin {
/*  58 */     None,
/*  59 */     A,
/*  60 */     B,
/*  61 */     X,
/*  62 */     Y,
/*  63 */     LeftBumper,
/*  64 */     RightBumper,
/*  65 */     LeftGrip,
/*  66 */     RightGrip,
/*  67 */     Start,
/*  68 */     Back,
/*  69 */     LeftPad_Touch,
/*  70 */     LeftPad_Swipe,
/*  71 */     LeftPad_Click,
/*  72 */     LeftPad_DPadNorth,
/*  73 */     LeftPad_DPadSouth,
/*  74 */     LeftPad_DPadWest,
/*  75 */     LeftPad_DPadEast,
/*  76 */     RightPad_Touch,
/*  77 */     RightPad_Swipe,
/*  78 */     RightPad_Click,
/*  79 */     RightPad_DPadNorth,
/*  80 */     RightPad_DPadSouth,
/*  81 */     RightPad_DPadWest,
/*  82 */     RightPad_DPadEast,
/*  83 */     LeftTrigger_Pull,
/*  84 */     LeftTrigger_Click,
/*  85 */     RightTrigger_Pull,
/*  86 */     RightTrigger_Click,
/*  87 */     LeftStick_Move,
/*  88 */     LeftStick_Click,
/*  89 */     LeftStick_DPadNorth,
/*  90 */     LeftStick_DPadSouth,
/*  91 */     LeftStick_DPadWest,
/*  92 */     LeftStick_DPadEast,
/*  93 */     Gyro_Move,
/*  94 */     Gyro_Pitch,
/*  95 */     Gyro_Yaw,
/*  96 */     Gyro_Roll,
/*     */     
/*  98 */     PS4_X,
/*  99 */     PS4_Circle,
/* 100 */     PS4_Triangle,
/* 101 */     PS4_Square,
/* 102 */     PS4_LeftBumper,
/* 103 */     PS4_RightBumper,
/* 104 */     PS4_Options,
/* 105 */     PS4_Share,
/* 106 */     PS4_LeftPad_Touch,
/* 107 */     PS4_LeftPad_Swipe,
/* 108 */     PS4_LeftPad_Click,
/* 109 */     PS4_LeftPad_DPadNorth,
/* 110 */     PS4_LeftPad_DPadSouth,
/* 111 */     PS4_LeftPad_DPadWest,
/* 112 */     PS4_LeftPad_DPadEast,
/* 113 */     PS4_RightPad_Touch,
/* 114 */     PS4_RightPad_Swipe,
/* 115 */     PS4_RightPad_Click,
/* 116 */     PS4_RightPad_DPadNorth,
/* 117 */     PS4_RightPad_DPadSouth,
/* 118 */     PS4_RightPad_DPadWest,
/* 119 */     PS4_RightPad_DPadEast,
/* 120 */     PS4_CenterPad_Touch,
/* 121 */     PS4_CenterPad_Swipe,
/* 122 */     PS4_CenterPad_Click,
/* 123 */     PS4_CenterPad_DPadNorth,
/* 124 */     PS4_CenterPad_DPadSouth,
/* 125 */     PS4_CenterPad_DPadWest,
/* 126 */     PS4_CenterPad_DPadEast,
/* 127 */     PS4_LeftTrigger_Pull,
/* 128 */     PS4_LeftTrigger_Click,
/* 129 */     PS4_RightTrigger_Pull,
/* 130 */     PS4_RightTrigger_Click,
/* 131 */     PS4_LeftStick_Move,
/* 132 */     PS4_LeftStick_Click,
/* 133 */     PS4_LeftStick_DPadNorth,
/* 134 */     PS4_LeftStick_DPadSouth,
/* 135 */     PS4_LeftStick_DPadWest,
/* 136 */     PS4_LeftStick_DPadEast,
/* 137 */     PS4_RightStick_Move,
/* 138 */     PS4_RightStick_Click,
/* 139 */     PS4_RightStick_DPadNorth,
/* 140 */     PS4_RightStick_DPadSouth,
/* 141 */     PS4_RightStick_DPadWest,
/* 142 */     PS4_RightStick_DPadEast,
/* 143 */     PS4_DPad_North,
/* 144 */     PS4_DPad_South,
/* 145 */     PS4_DPad_West,
/* 146 */     PS4_DPad_East,
/* 147 */     PS4_Gyro_Move,
/* 148 */     PS4_Gyro_Pitch,
/* 149 */     PS4_Gyro_Yaw,
/* 150 */     PS4_Gyro_Roll,
/*     */     
/* 152 */     XBoxOne_A,
/* 153 */     XBoxOne_B,
/* 154 */     XBoxOne_X,
/* 155 */     XBoxOne_Y,
/* 156 */     XBoxOne_LeftBumper,
/* 157 */     XBoxOne_RightBumper,
/* 158 */     XBoxOne_Menu,
/* 159 */     XBoxOne_View,
/* 160 */     XBoxOne_LeftTrigger_Pull,
/* 161 */     XBoxOne_LeftTrigger_Click,
/* 162 */     XBoxOne_RightTrigger_Pull,
/* 163 */     XBoxOne_RightTrigger_Click,
/* 164 */     XBoxOne_LeftStick_Move,
/* 165 */     XBoxOne_LeftStick_Click,
/* 166 */     XBoxOne_LeftStick_DPadNorth,
/* 167 */     XBoxOne_LeftStick_DPadSouth,
/* 168 */     XBoxOne_LeftStick_DPadWest,
/* 169 */     XBoxOne_LeftStick_DPadEast,
/* 170 */     XBoxOne_RightStick_Move,
/* 171 */     XBoxOne_RightStick_Click,
/* 172 */     XBoxOne_RightStick_DPadNorth,
/* 173 */     XBoxOne_RightStick_DPadSouth,
/* 174 */     XBoxOne_RightStick_DPadWest,
/* 175 */     XBoxOne_RightStick_DPadEast,
/* 176 */     XBoxOne_DPad_North,
/* 177 */     XBoxOne_DPad_South,
/* 178 */     XBoxOne_DPad_West,
/* 179 */     XBoxOne_DPad_East,
/*     */     
/* 181 */     XBox360_A,
/* 182 */     XBox360_B,
/* 183 */     XBox360_X,
/* 184 */     XBox360_Y,
/* 185 */     XBox360_LeftBumper,
/* 186 */     XBox360_RightBumper,
/* 187 */     XBox360_Start,
/* 188 */     XBox360_Back,
/* 189 */     XBox360_LeftTrigger_Pull,
/* 190 */     XBox360_LeftTrigger_Click,
/* 191 */     XBox360_RightTrigger_Pull,
/* 192 */     XBox360_RightTrigger_Click,
/* 193 */     XBox360_LeftStick_Move,
/* 194 */     XBox360_LeftStick_Click,
/* 195 */     XBox360_LeftStick_DPadNorth,
/* 196 */     XBox360_LeftStick_DPadSouth,
/* 197 */     XBox360_LeftStick_DPadWest,
/* 198 */     XBox360_LeftStick_DPadEast,
/* 199 */     XBox360_RightStick_Move,
/* 200 */     XBox360_RightStick_Click,
/* 201 */     XBox360_RightStick_DPadNorth,
/* 202 */     XBox360_RightStick_DPadSouth,
/* 203 */     XBox360_RightStick_DPadWest,
/* 204 */     XBox360_RightStick_DPadEast,
/* 205 */     XBox360_DPad_North,
/* 206 */     XBox360_DPad_South,
/* 207 */     XBox360_DPad_West,
/* 208 */     XBox360_DPad_East,
/*     */     
/* 210 */     SteamV2_A,
/* 211 */     SteamV2_B,
/* 212 */     SteamV2_X,
/* 213 */     SteamV2_Y,
/* 214 */     SteamV2_LeftBumper,
/* 215 */     SteamV2_RightBumper,
/* 216 */     SteamV2_LeftGrip_Lower,
/* 217 */     SteamV2_LeftGrip_Upper,
/* 218 */     SteamV2_RightGrip_Lower,
/* 219 */     SteamV2_RightGrip_Upper,
/* 220 */     SteamV2_LeftBumper_Pressure,
/* 221 */     SteamV2_RightBumper_Pressure,
/* 222 */     SteamV2_LeftGrip_Pressure,
/* 223 */     SteamV2_RightGrip_Pressure,
/* 224 */     SteamV2_LeftGrip_Upper_Pressure,
/* 225 */     SteamV2_RightGrip_Upper_Pressure,
/* 226 */     SteamV2_Start,
/* 227 */     SteamV2_Back,
/* 228 */     SteamV2_LeftPad_Touch,
/* 229 */     SteamV2_LeftPad_Swipe,
/* 230 */     SteamV2_LeftPad_Click,
/* 231 */     SteamV2_LeftPad_Pressure,
/* 232 */     SteamV2_LeftPad_DPadNorth,
/* 233 */     SteamV2_LeftPad_DPadSouth,
/* 234 */     SteamV2_LeftPad_DPadWest,
/* 235 */     SteamV2_LeftPad_DPadEast,
/* 236 */     SteamV2_RightPad_Touch,
/* 237 */     SteamV2_RightPad_Swipe,
/* 238 */     SteamV2_RightPad_Click,
/* 239 */     SteamV2_RightPad_Pressure,
/* 240 */     SteamV2_RightPad_DPadNorth,
/* 241 */     SteamV2_RightPad_DPadSouth,
/* 242 */     SteamV2_RightPad_DPadWest,
/* 243 */     SteamV2_RightPad_DPadEast,
/* 244 */     SteamV2_LeftTrigger_Pull,
/* 245 */     SteamV2_LeftTrigger_Click,
/* 246 */     SteamV2_RightTrigger_Pull,
/* 247 */     SteamV2_RightTrigger_Click,
/* 248 */     SteamV2_LeftStick_Move,
/* 249 */     SteamV2_LeftStick_Click,
/* 250 */     SteamV2_LeftStick_DPadNorth,
/* 251 */     SteamV2_LeftStick_DPadSouth,
/* 252 */     SteamV2_LeftStick_DPadWest,
/* 253 */     SteamV2_LeftStick_DPadEast,
/* 254 */     SteamV2_Gyro_Move,
/* 255 */     SteamV2_Gyro_Pitch,
/* 256 */     SteamV2_Gyro_Yaw,
/* 257 */     SteamV2_Gyro_Roll,
/*     */     
/* 259 */     Switch_A,
/* 260 */     Switch_B,
/* 261 */     Switch_X,
/* 262 */     Switch_Y,
/* 263 */     Switch_LeftBumper,
/* 264 */     Switch_RightBumper,
/* 265 */     Switch_Plus,
/* 266 */     Switch_Minus,
/* 267 */     Switch_Capture,
/* 268 */     Switch_LeftTrigger_Pull,
/* 269 */     Switch_LeftTrigger_Click,
/* 270 */     Switch_RightTrigger_Pull,
/* 271 */     Switch_RightTrigger_Click,
/* 272 */     Switch_LeftStick_Move,
/* 273 */     Switch_LeftStick_Click,
/* 274 */     Switch_LeftStick_DPadNorth,
/* 275 */     Switch_LeftStick_DPadSouth,
/* 276 */     Switch_LeftStick_DPadWest,
/* 277 */     Switch_LeftStick_DPadEast,
/* 278 */     Switch_RightStick_Move,
/* 279 */     Switch_RightStick_Click,
/* 280 */     Switch_RightStick_DPadNorth,
/* 281 */     Switch_RightStick_DPadSouth,
/* 282 */     Switch_RightStick_DPadWest,
/* 283 */     Switch_RightStick_DPadEast,
/* 284 */     Switch_DPad_North,
/* 285 */     Switch_DPad_South,
/* 286 */     Switch_DPad_West,
/* 287 */     Switch_DPad_East,
/* 288 */     Switch_ProGyro_Move,
/* 289 */     Switch_ProGyro_Pitch,
/* 290 */     Switch_ProGyro_Yaw,
/* 291 */     Switch_ProGyro_Roll,
/* 292 */     Switch_RightGyro_Move,
/* 293 */     Switch_RightGyro_Pitch,
/* 294 */     Switch_RightGyro_Yaw,
/* 295 */     Switch_RightGyro_Roll,
/* 296 */     Switch_LeftGyro_Move,
/* 297 */     Switch_LeftGyro_Pitch,
/* 298 */     Switch_LeftGyro_Yaw,
/* 299 */     Switch_LeftGyro_Roll,
/* 300 */     Switch_LeftGrip_Lower,
/* 301 */     Switch_LeftGrip_Upper,
/* 302 */     Switch_RightGrip_Lower,
/* 303 */     Switch_RightGrip_Upper,
/*     */     
/* 305 */     PS4_DPad_Move,
/* 306 */     XBoxOne_DPad_Move,
/* 307 */     XBox360_DPad_Move,
/* 308 */     Switch_DPad_Move,
/*     */     
/* 310 */     PS5_X,
/* 311 */     PS5_Circle,
/* 312 */     PS5_Triangle,
/* 313 */     PS5_Square,
/* 314 */     PS5_LeftBumper,
/* 315 */     PS5_RightBumper,
/* 316 */     PS5_Option,
/* 317 */     PS5_Create,
/* 318 */     PS5_Mute,
/* 319 */     PS5_LeftPad_Touch,
/* 320 */     PS5_LeftPad_Swipe,
/* 321 */     PS5_LeftPad_Click,
/* 322 */     PS5_LeftPad_DPadNorth,
/* 323 */     PS5_LeftPad_DPadSouth,
/* 324 */     PS5_LeftPad_DPadWest,
/* 325 */     PS5_LeftPad_DPadEast,
/* 326 */     PS5_RightPad_Touch,
/* 327 */     PS5_RightPad_Swipe,
/* 328 */     PS5_RightPad_Click,
/* 329 */     PS5_RightPad_DPadNorth,
/* 330 */     PS5_RightPad_DPadSouth,
/* 331 */     PS5_RightPad_DPadWest,
/* 332 */     PS5_RightPad_DPadEast,
/* 333 */     PS5_CenterPad_Touch,
/* 334 */     PS5_CenterPad_Swipe,
/* 335 */     PS5_CenterPad_Click,
/* 336 */     PS5_CenterPad_DPadNorth,
/* 337 */     PS5_CenterPad_DPadSouth,
/* 338 */     PS5_CenterPad_DPadWest,
/* 339 */     PS5_CenterPad_DPadEast,
/* 340 */     PS5_LeftTrigger_Pull,
/* 341 */     PS5_LeftTrigger_Click,
/* 342 */     PS5_RightTrigger_Pull,
/* 343 */     PS5_RightTrigger_Click,
/* 344 */     PS5_LeftStick_Move,
/* 345 */     PS5_LeftStick_Click,
/* 346 */     PS5_LeftStick_DPadNorth,
/* 347 */     PS5_LeftStick_DPadSouth,
/* 348 */     PS5_LeftStick_DPadWest,
/* 349 */     PS5_LeftStick_DPadEast,
/* 350 */     PS5_RightStick_Move,
/* 351 */     PS5_RightStick_Click,
/* 352 */     PS5_RightStick_DPadNorth,
/* 353 */     PS5_RightStick_DPadSouth,
/* 354 */     PS5_RightStick_DPadWest,
/* 355 */     PS5_RightStick_DPadEast,
/* 356 */     PS5_DPad_Move,
/* 357 */     PS5_DPad_North,
/* 358 */     PS5_DPad_South,
/* 359 */     PS5_DPad_West,
/* 360 */     PS5_DPad_East,
/* 361 */     PS5_Gyro_Move,
/* 362 */     PS5_Gyro_Pitch,
/* 363 */     PS5_Gyro_Yaw,
/* 364 */     PS5_Gyro_Roll,
/*     */     
/* 366 */     XBoxOne_LeftGrip_Lower,
/* 367 */     XBoxOne_LeftGrip_Upper,
/* 368 */     XBoxOne_RightGrip_Lower,
/* 369 */     XBoxOne_RightGrip_Upper,
/* 370 */     XBoxOne_Share,
/*     */     
/* 372 */     SteamDeck_A,
/* 373 */     SteamDeck_B,
/* 374 */     SteamDeck_X,
/* 375 */     SteamDeck_Y,
/* 376 */     SteamDeck_L1,
/* 377 */     SteamDeck_R1,
/* 378 */     SteamDeck_Menu,
/* 379 */     SteamDeck_View,
/* 380 */     SteamDeck_LeftPad_Touch,
/* 381 */     SteamDeck_LeftPad_Swipe,
/* 382 */     SteamDeck_LeftPad_Click,
/* 383 */     SteamDeck_LeftPad_DPadNorth,
/* 384 */     SteamDeck_LeftPad_DPadSouth,
/* 385 */     SteamDeck_LeftPad_DPadWest,
/* 386 */     SteamDeck_LeftPad_DPadEast,
/* 387 */     SteamDeck_RightPad_Touch,
/* 388 */     SteamDeck_RightPad_Swipe,
/* 389 */     SteamDeck_RightPad_Click,
/* 390 */     SteamDeck_RightPad_DPadNorth,
/* 391 */     SteamDeck_RightPad_DPadSouth,
/* 392 */     SteamDeck_RightPad_DPadWest,
/* 393 */     SteamDeck_RightPad_DPadEast,
/* 394 */     SteamDeck_L2_SoftPull,
/* 395 */     SteamDeck_L2,
/* 396 */     SteamDeck_R2_SoftPull,
/* 397 */     SteamDeck_R2,
/* 398 */     SteamDeck_LeftStick_Move,
/* 399 */     SteamDeck_L3,
/* 400 */     SteamDeck_LeftStick_DPadNorth,
/* 401 */     SteamDeck_LeftStick_DPadSouth,
/* 402 */     SteamDeck_LeftStick_DPadWest,
/* 403 */     SteamDeck_LeftStick_DPadEast,
/* 404 */     SteamDeck_LeftStick_Touch,
/* 405 */     SteamDeck_RightStick_Move,
/* 406 */     SteamDeck_R3,
/* 407 */     SteamDeck_RightStick_DPadNorth,
/* 408 */     SteamDeck_RightStick_DPadSouth,
/* 409 */     SteamDeck_RightStick_DPadWest,
/* 410 */     SteamDeck_RightStick_DPadEast,
/* 411 */     SteamDeck_RightStick_Touch,
/* 412 */     SteamDeck_L4,
/* 413 */     SteamDeck_R4,
/* 414 */     SteamDeck_L5,
/* 415 */     SteamDeck_R5,
/* 416 */     SteamDeck_DPad_Move,
/* 417 */     SteamDeck_DPad_North,
/* 418 */     SteamDeck_DPad_South,
/* 419 */     SteamDeck_DPad_West,
/* 420 */     SteamDeck_DPad_East,
/* 421 */     SteamDeck_Gyro_Move,
/* 422 */     SteamDeck_Gyro_Pitch,
/* 423 */     SteamDeck_Gyro_Yaw,
/* 424 */     SteamDeck_Gyro_Roll,
/* 425 */     SteamDeck_Reserved1,
/* 426 */     SteamDeck_Reserved2,
/* 427 */     SteamDeck_Reserved3,
/* 428 */     SteamDeck_Reserved4,
/* 429 */     SteamDeck_Reserved5,
/* 430 */     SteamDeck_Reserved6,
/* 431 */     SteamDeck_Reserved7,
/* 432 */     SteamDeck_Reserved8,
/* 433 */     SteamDeck_Reserved9,
/* 434 */     SteamDeck_Reserved10,
/* 435 */     SteamDeck_Reserved11,
/* 436 */     SteamDeck_Reserved12,
/* 437 */     SteamDeck_Reserved13,
/* 438 */     SteamDeck_Reserved14,
/* 439 */     SteamDeck_Reserved15,
/* 440 */     SteamDeck_Reserved16,
/* 441 */     SteamDeck_Reserved17,
/* 442 */     SteamDeck_Reserved18,
/* 443 */     SteamDeck_Reserved19,
/* 444 */     SteamDeck_Reserved20;
/*     */     
/* 446 */     private static final ActionOrigin[] values = values(); static {
/*     */     
/*     */     } static ActionOrigin byOrdinal(int param1Int) {
/* 449 */       return values[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   public enum XboxOrigin {
/* 454 */     A,
/* 455 */     B,
/* 456 */     X,
/* 457 */     Y,
/* 458 */     LeftBumper,
/* 459 */     RightBumper,
/* 460 */     Menu,
/* 461 */     View,
/* 462 */     LeftTrigger_Pull,
/* 463 */     LeftTrigger_Click,
/* 464 */     RightTrigger_Pull,
/* 465 */     RightTrigger_Click,
/* 466 */     LeftStick_Move,
/* 467 */     LeftStick_Click,
/* 468 */     LeftStick_DPadNorth,
/* 469 */     LeftStick_DPadSouth,
/* 470 */     LeftStick_DPadWest,
/* 471 */     LeftStick_DPadEast,
/* 472 */     RightStick_Move,
/* 473 */     RightStick_Click,
/* 474 */     RightStick_DPadNorth,
/* 475 */     RightStick_DPadSouth,
/* 476 */     RightStick_DPadWest,
/* 477 */     RightStick_DPadEast,
/* 478 */     DPad_North,
/* 479 */     DPad_South,
/* 480 */     DPad_West,
/* 481 */     DPad_East;
/*     */   }
/*     */   
/*     */   public enum InputType {
/* 485 */     Unknown,
/* 486 */     SteamController,
/* 487 */     XBox360Controller,
/* 488 */     XBoxOneController,
/* 489 */     GenericGamepad,
/* 490 */     PS4Controller,
/* 491 */     AppleMFiController,
/* 492 */     AndroidController,
/* 493 */     SwitchJoyConPair,
/* 494 */     SwitchJoyConSingle,
/* 495 */     SwitchProController,
/* 496 */     MobileTouch,
/* 497 */     PS3Controller,
/* 498 */     PS5Controller;
/*     */     
/* 500 */     private static final InputType[] values = values(); static {
/*     */     
/*     */     } static InputType byOrdinal(int param1Int) {
/* 503 */       return values[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   public enum LEDFlag {
/* 508 */     SetColor,
/* 509 */     RestoreUserDefault;
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
/* 522 */   private final long[] controllerHandles = new long[16];
/* 523 */   private final int[] actionOrigins = new int[8];
/*     */   
/*     */   public SteamController() {
/* 526 */     super(-1L);
/*     */   }
/*     */   
/*     */   public boolean init() {
/* 530 */     return SteamControllerNative.init();
/*     */   }
/*     */   
/*     */   public boolean shutdown() {
/* 534 */     return SteamControllerNative.shutdown();
/*     */   }
/*     */   
/*     */   public void runFrame() {
/* 538 */     SteamControllerNative.runFrame();
/*     */   }
/*     */   
/*     */   public int getConnectedControllers(SteamControllerHandle[] paramArrayOfSteamControllerHandle) {
/* 542 */     if (paramArrayOfSteamControllerHandle.length < 16) {
/* 543 */       throw new IllegalArgumentException("Array size must be at least STEAM_CONTROLLER_MAX_COUNT");
/*     */     }
/*     */     
/* 546 */     int i = SteamControllerNative.getConnectedControllers(this.controllerHandles);
/*     */     
/* 548 */     for (byte b = 0; b < i; b++) {
/* 549 */       paramArrayOfSteamControllerHandle[b] = new SteamControllerHandle(this.controllerHandles[b]);
/*     */     }
/*     */     
/* 552 */     return i;
/*     */   }
/*     */   
/*     */   public boolean showBindingPanel(SteamControllerHandle paramSteamControllerHandle) {
/* 556 */     return SteamControllerNative.showBindingPanel(paramSteamControllerHandle.handle);
/*     */   }
/*     */   
/*     */   public SteamControllerActionSetHandle getActionSetHandle(String paramString) {
/* 560 */     return new SteamControllerActionSetHandle(SteamControllerNative.getActionSetHandle(paramString));
/*     */   }
/*     */   
/*     */   public void activateActionSet(SteamControllerHandle paramSteamControllerHandle, SteamControllerActionSetHandle paramSteamControllerActionSetHandle) {
/* 564 */     SteamControllerNative.activateActionSet(paramSteamControllerHandle.handle, paramSteamControllerActionSetHandle.handle);
/*     */   }
/*     */   
/*     */   public SteamControllerActionSetHandle getCurrentActionSet(SteamControllerHandle paramSteamControllerHandle) {
/* 568 */     return new SteamControllerActionSetHandle(SteamControllerNative.getCurrentActionSet(paramSteamControllerHandle.handle));
/*     */   }
/*     */   
/*     */   public SteamControllerDigitalActionHandle getDigitalActionHandle(String paramString) {
/* 572 */     return new SteamControllerDigitalActionHandle(SteamControllerNative.getDigitalActionHandle(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getDigitalActionData(SteamControllerHandle paramSteamControllerHandle, SteamControllerDigitalActionHandle paramSteamControllerDigitalActionHandle, SteamControllerDigitalActionData paramSteamControllerDigitalActionData) {
/* 579 */     SteamControllerNative.getDigitalActionData(paramSteamControllerHandle.handle, paramSteamControllerDigitalActionHandle.handle, paramSteamControllerDigitalActionData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDigitalActionOrigins(SteamControllerHandle paramSteamControllerHandle, SteamControllerActionSetHandle paramSteamControllerActionSetHandle, SteamControllerDigitalActionHandle paramSteamControllerDigitalActionHandle, ActionOrigin[] paramArrayOfActionOrigin) {
/* 587 */     if (paramArrayOfActionOrigin.length < 8) {
/* 588 */       throw new IllegalArgumentException("Array size must be at least STEAM_CONTROLLER_MAX_ORIGINS");
/*     */     }
/*     */     
/* 591 */     int i = SteamControllerNative.getDigitalActionOrigins(paramSteamControllerHandle.handle, paramSteamControllerActionSetHandle.handle, paramSteamControllerDigitalActionHandle.handle, this.actionOrigins);
/*     */ 
/*     */     
/* 594 */     for (byte b = 0; b < i; b++) {
/* 595 */       paramArrayOfActionOrigin[b] = ActionOrigin.byOrdinal(this.actionOrigins[b]);
/*     */     }
/*     */     
/* 598 */     return i;
/*     */   }
/*     */   
/*     */   public SteamControllerAnalogActionHandle getAnalogActionHandle(String paramString) {
/* 602 */     return new SteamControllerAnalogActionHandle(SteamControllerNative.getAnalogActionHandle(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getAnalogActionData(SteamControllerHandle paramSteamControllerHandle, SteamControllerAnalogActionHandle paramSteamControllerAnalogActionHandle, SteamControllerAnalogActionData paramSteamControllerAnalogActionData) {
/* 609 */     SteamControllerNative.getAnalogActionData(paramSteamControllerHandle.handle, paramSteamControllerAnalogActionHandle.handle, paramSteamControllerAnalogActionData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnalogActionOrigins(SteamControllerHandle paramSteamControllerHandle, SteamControllerActionSetHandle paramSteamControllerActionSetHandle, SteamControllerAnalogActionHandle paramSteamControllerAnalogActionHandle, ActionOrigin[] paramArrayOfActionOrigin) {
/* 617 */     if (paramArrayOfActionOrigin.length < 8) {
/* 618 */       throw new IllegalArgumentException("Array size must be at least STEAM_CONTROLLER_MAX_ORIGINS");
/*     */     }
/*     */     
/* 621 */     int i = SteamControllerNative.getAnalogActionOrigins(paramSteamControllerHandle.handle, paramSteamControllerActionSetHandle.handle, paramSteamControllerAnalogActionHandle.handle, this.actionOrigins);
/*     */ 
/*     */     
/* 624 */     for (byte b = 0; b < i; b++) {
/* 625 */       paramArrayOfActionOrigin[b] = ActionOrigin.byOrdinal(this.actionOrigins[b]);
/*     */     }
/*     */     
/* 628 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void stopAnalogActionMomentum(SteamControllerHandle paramSteamControllerHandle, SteamControllerAnalogActionHandle paramSteamControllerAnalogActionHandle) {
/* 634 */     SteamControllerNative.stopAnalogActionMomentum(paramSteamControllerHandle.handle, paramSteamControllerAnalogActionHandle.handle);
/*     */   }
/*     */   
/*     */   public void triggerHapticPulse(SteamControllerHandle paramSteamControllerHandle, Pad paramPad, int paramInt) {
/* 638 */     SteamControllerNative.triggerHapticPulse(paramSteamControllerHandle.handle, paramPad.ordinal(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void triggerRepeatedHapticPulse(SteamControllerHandle paramSteamControllerHandle, Pad paramPad, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 644 */     SteamControllerNative.triggerRepeatedHapticPulse(paramSteamControllerHandle.handle, paramPad.ordinal(), paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void triggerVibration(SteamControllerHandle paramSteamControllerHandle, short paramShort1, short paramShort2) {
/* 649 */     SteamControllerNative.triggerVibration(paramSteamControllerHandle.handle, paramShort1, paramShort2);
/*     */   }
/*     */   
/*     */   public void setLEDColor(SteamControllerHandle paramSteamControllerHandle, int paramInt1, int paramInt2, int paramInt3, LEDFlag paramLEDFlag) {
/* 653 */     SteamControllerNative.setLEDColor(paramSteamControllerHandle.handle, (byte)paramInt1, (byte)paramInt2, (byte)paramInt3, paramLEDFlag
/* 654 */         .ordinal());
/*     */   }
/*     */   
/*     */   public int getGamepadIndexForController(SteamControllerHandle paramSteamControllerHandle) {
/* 658 */     return SteamControllerNative.getGamepadIndexForController(paramSteamControllerHandle.handle);
/*     */   }
/*     */   
/*     */   public SteamControllerHandle getControllerForGamepadIndex(int paramInt) {
/* 662 */     return new SteamControllerHandle(SteamControllerNative.getControllerForGamepadIndex(paramInt));
/*     */   }
/*     */   
/*     */   public void getMotionData(SteamControllerHandle paramSteamControllerHandle, SteamControllerMotionData paramSteamControllerMotionData) {
/* 666 */     SteamControllerNative.getMotionData(paramSteamControllerHandle.handle, paramSteamControllerMotionData.data);
/*     */   }
/*     */   
/*     */   public String getStringForActionOrigin(ActionOrigin paramActionOrigin) {
/* 670 */     return SteamControllerNative.getStringForActionOrigin(paramActionOrigin.ordinal());
/*     */   }
/*     */   
/*     */   public String getGlyphForActionOrigin(ActionOrigin paramActionOrigin) {
/* 674 */     return SteamControllerNative.getGlyphForActionOrigin(paramActionOrigin.ordinal());
/*     */   }
/*     */   
/*     */   public InputType getInputTypeForHandle(SteamControllerHandle paramSteamControllerHandle) {
/* 678 */     return InputType.byOrdinal(SteamControllerNative.getInputTypeForHandle(paramSteamControllerHandle.handle));
/*     */   } }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */