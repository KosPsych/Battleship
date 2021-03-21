
 # Initialization rules :
 * The name of the txt you inserted must be in the PlayersFolder
 * No overlap between ships
 * ships must refrain for at least 1 cell.
 * a ship must not be out of bound.
 * Enemy's board is initialized randomly by selecting a file from EnemyFiles

# Game rules :
* The game has 40 rounds
* The game either ends when a player has defeated all enemy ships or 40 rounds have passed.
* First to move is chosen randomly.

# Features:
* You can create new txt initialization files and put the inside PlayerFiles or EnemyFiles.
*  You can view your hits on enemy board as well as your board with enemy hits
*  You can view points,accuracy and your last 5 shots for both your team and the computer's.
*  Smart Battleship Computer AI where computer : 
*  * hits nearby cells after first successful hit on a ship.
*  * After hitting a second one  knows the ship's direction and hits accordingly.
*  * While hitting in a direction computer remove's adjacent cells from future search space because he knows 2 ships must refrain at least 1 cell.



### NOTE
> Further expansion would be to create Easy computer AI logic(suppose the above is hard) where the computer would move based on first one or first 2 of the above bullets.The user should be able to choose between these 2 modes.

 
