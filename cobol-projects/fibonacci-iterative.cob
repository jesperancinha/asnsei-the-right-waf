IDENTIFICATION DIVISION.
PROGRAM-ID. Fibonacci.
DATA DIVISION.
WORKING-STORAGE SECTION.
01  F1                   PIC 9(21)V9(1) VALUE 0.0.
01  F2                   PIC 9(21)V9(1) VALUE 1.0.
01  FIB                  PIC 9(21)V9(1).
01  N                    PIC 9(5) VALUE 100.
01  I                    PIC 9(5) VALUE 3.

PROCEDURE DIVISION.
MAIN-LOGIC.
   PERFORM VARYING I FROM 2 BY 1 UNTIL I > N
       COMPUTE FIB = F1 + F2
       COMPUTE F1 = F2
       COMPUTE F2 = FIB
   END-PERFORM.
   DISPLAY FIB.
   STOP RUN.
