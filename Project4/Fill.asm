// Code assumes R0 is loaded with 8192
// filler = 0
@filler
M=0
// loop
(LOOP)
//	if(key pressed)
@KBD
D=M
@DARKFILL
D;JNE
@WHITEFILL
D;JEQ
//	 filler = -1
(DARKFILL)
@filler
M=-1
@FILLSCREEN
0;JMP
//	 filler = 0
(WHITEFILL)
@filler
M=0
//	Fill the screen
(FILLSCREEN)
// i = 0
@i
M=0
(SCREENLOOP)
//	if(i == 8192) goto stop
@i
D=M
@R0
D=D-M
@STOP
D;JEQ
//	 R[Screen + i] = filler
@SCREEN
D=A
@pixelAddress
M=D
@i
D=M
@pixelAddress
M=D+M
@filler
D=M
@pixelAddress
A=M
M=D
//	 i=i+1
@i
M=M+1
@SCREENLOOP
0;JMP
// stop
(STOP)
// goto loop
@LOOP
0;JMP
