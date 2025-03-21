// 	i = 1
@i
M=1
// 	sum = 0
@sum
M=0
// loop
(LOOP)
//	if(i > R0) goto stop
@i
D=M
@R0
D=D-M
@STOP
D;JGT
//	sum = sum + R1
@R1
D=M
@sum
D=D+M
M=D
//	i = i+1
@i
M=M+1
//	goto loop
@LOOP
0;JMP
// stop
(STOP)
//	R2 = sum
@sum
D=M
@R2
M=D
(END)
@END
0;JMP
