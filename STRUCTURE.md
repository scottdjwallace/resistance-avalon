# Architecture of App Implementation

Subpoints are the next activity launched from current point.

### Android Activities
* MainActivity (Launch Screen)
  * InstructionsActivity (How to Play Game / Rules)
  * GameSetupActivity (Choose # of Players)
    * EnterPlayerNames (Enter the player's names)
      * RevealPlayersActivity (Reveals the Player's motive)
  
### Just Java
* GameState (Singleton / Controls everything going on during the game)
* Player (Stores Player's name and motive)
