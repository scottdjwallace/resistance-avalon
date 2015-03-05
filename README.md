# resistance-avalon
Android implementation of <em>The Resistance: Avalon - Pass &amp; Play</em> game.

![Game Logo](https://github.com/scottdjwallace/resistance-avalon/blob/master/img/mainlogo.png)

### Team Members

Manager: [Laura Brooks] (https://github.com/lauramb)

Designer: [Christina Chan] (https://github.com/cchawn)

Programmer: [Scott Wallace] (https://github.com/scottdjwallace)

Tester: [Brad Guner] (https://github.com/bradguner)

### To-Do
* Fix RevealRoundActivity ActionBar Title
1. NewQuestActivity -- Quest # + Button to begin, GameState -- should help maintain quest #
2. PickQuestActivity -- Person who is choosing quest, picks players
3. VoteActivity -- public vote on quest, goes forth or doesn't
4. Vote fails -- pick new leader, go to step 2
5. Vote goes forth, step 6
6. QuestVoteActivity -- members of quest vote on quest. needs to be a secret vote
7. RoundSummary -- reveals vote, and score, go to NewQuestActivity

### Progress
- [x] Landing Activity
- [x] Rough How to Play Activity
- [x] Pick How many players activity
- [x] Dynamically display EditText fields to input names based on number of players selected
- [x] Save names into GameState and decide whether the player created is good or bad
- [x] Reveal Stage -- we tell players if they are good or bad, and also who else is bad with them if they're bad
- [ ] Design and Flow of Rounds 1 - 5 
- [ ] Implementing the design for the game being played
- [ ] Adding Design Stage & Making things look nice
- [ ] Optimization
