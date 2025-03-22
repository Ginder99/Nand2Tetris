// Load R0 with 8192
@8192
D=A
@R0
M=D
//	filler = 0
@filler
M=0
//	while(true) {
(LOOP)
//		if(kbd != 0)
@KBD
D=M
//			newFiller = -1
@DARKFILL
D;JNE
//		else
//			newFiller = 0
@WHITEFILL
D;JEQ
(DARKFILL)
@newFiller
M=-1
@COMPARE
0;JMP
(WHITEFILL)
@newFiller
M=0
(COMPARE)
@newFiller
D=M
@filler
D=D-M
//		if(newFiller == filler) goto loop
@LOOP
D;JEQ
//		filler = newFiller
@newFiller
D=M
@filler
M=D
//		fillscreen()
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
