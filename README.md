Just a small challenge I set myself so that I could refresh my knowledge of decision-making algorithms. The one used
in this project is the Minimax algorithm. Assuming I have implemented it correctly, you should have a really hard time
trying to win =].

The game is terminal based, but the rules are simple. After you start the program you will be prompted to select the
piece you wish to play as, X or O. 

NOTE: X always goes first. 

You will be shown a list of available moves before each of your turns. If you make an invalid move (one that doesn't 
exist or one that is already taken) you will be prompted to make a valid move.

All available moves/positions that you can enter as input:
- tl = Places your piece at the top left of the board
- ct = Places your piece at the centre top of the board
- tr = Places your piece at the top right of the board
- cl = Places your piece at the centre left of the board
- c = Places your piece at the centre of the board
- cr = Places your piece at the centre right of the board
- bl = Places your piece at the bottom left of the board
- cb = Places your piece at the centre bottom of the board
- br = Places your piece at the bottom right of the board

The game ends when either you or the machine gets 3 pieces in a row. If the board is full such that there are no more 
available moves and neither player has 3 in a row, the game will end in a tie.