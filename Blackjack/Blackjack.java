// Coded by Akash Surti

public class Blackjack{        
    
  /********************************** INTRODUCTION *********************************************/
  
  public static String Intro(String n){
    System.out.println("We don't have much of a casino to offer to you " + n + ", but what we do have is hospitality. (Especially towards hopeful gamblers who are here to lose.)");
    System.out.println("Anyway enough of that, do you want to play some Blackjack " + n + "? (Yes or No)");
    return PlayBlackjack(StdIn.readString());
  }
  
  public static String PlayBlackjack(String n){
    if (!(n.equals("No")||n.equals("no")||n.equals("Yes")||n.equals("yes"))) {
      return "What on earth does that even mean? You know what, if you aren't interested just leave.";
    }
    else {
      if (n.equals("No")||n.equals("no")) 
        return "THEN WHY THE HELL ARE YOU HERE! GET OUT!";
      if (n.equals("Yes")||n.equals("yes"))
        return Rules(n);
    }
    return n;
  }
  
  public static String Rules(String n){
    System.out.println("You do know how to play Blackjack right? (Yes or No)");
    String m = StdIn.readString();
    
    // Rules: Invalid response
    if (!(m.equals("No")||m.equals("no")||m.equals("Yes")||m.equals("yes"))){ 
      System.out.println("What on earth does that even mean? Let's try this again.");
      return Rules(n);
    }
    else {
      if (m.equals("No")||m.equals("no")) {
      System.out.println("Such a shame! You want to play but you don't even know how to?");
      System.out.println("But don't worry don't worry, I'll help you out. (As long as you have money to lose)");
      System.out.println();
      System.out.println("Here are 6 simple rules you need to know:");
      System.out.println();
      System.out.println("1. You will initially be dealt two cards, from where you can either choose to recieve another card (hit) or stay where you are (stick).");
      System.out.println("2. Your objective is to get as close to a score of 21 as possible and basically beat the casino. If you exceed 21 you lose (BUSTED).");
      System.out.println("3. Numbered cards count as their natural value, but the King, Queen, and Jack, count as the value 10.");
      System.out.println("4. Aces can have a value of either 1 or 11 according to your choice.");
      System.out.println("5. If you win, the casino gives you the amount you bet for that round. So if you bet 5$ you get 5$, so basically your money is doubled.");
      System.out.println("6. If the first two cards you recieve happen to have the value of 21, you get a blackjack. So you get 1.5 times the money you bet on that round."); 
      System.out.println();
      System.out.println();
      return "So now let's finally play!";
      }
             
      if (m.equals("Yes")||m.equals("yes")) {
      return "Okay! Let's play!";
      }
    }
    return n;
  }
  /********************************** GAME TIME *********************************************/
  
  // Shuffle
  public static String[] Shuffle(String[] n){
    for(int i = 0; i < n.length; i++) { 
      int r = (int) (Math.random()*(n.length)); 
      
      String t = n[i];
      n[i] = n[r];
      n[r] = t;
    }
    return n;
  }
  
  // The Game 
  public static String GameTime(String[] deck){
    int PlayerScore = 0;
    System.out.println("The cards you have been dealt are:");
    System.out.println();
    System.out.println(deck[0] + " " + deck[1]);
    System.out.println();
    
    PlayerScore = DeckChange(deck[0]) + DeckChange(deck[1]);
    
    System.out.println("Your score is " + PlayerScore + ".");
    System.out.println();
    
    int CardCount = 1;
    System.out.println(WhatToDo(deck, PlayerScore, CardCount));
    System.out.println();
    System.out.println("Do you want to play again?(Yes or No)");
    String PlayAgain = StdIn.readString();
    if (PlayAgain.equals("Yes") || PlayAgain.equals("yes"))
      GameTime(Shuffle(deck));
    return "Thanks for playing!";
  }
  
  // Deck into Values
  public static int DeckChange(String deck){
    int n = 0;
    if (deck.equals("Ace")) n = 1;
    else if (deck.equals("2")) n = 2;
    else if (deck.equals("3")) n = 3;
    else if (deck.equals("4")) n = 4;
    else if (deck.equals("5")) n = 5;
    else if (deck.equals("6")) n = 6;
    else if (deck.equals("7")) n = 7;
    else if (deck.equals("8")) n = 8;
    else if (deck.equals("9")) n = 9;
    else if (deck.equals("10")) n = 10;
    else if (deck.equals("Jack")) n = 10;
    else if (deck.equals("Queen")) n = 10;
    else if (deck.equals("King")) n = 10;
    else n = 0;
    return AceCheck(n);
  }
  
  // AceCheck
  public static int AceCheck(int ace){
    if (ace == 1){
    System.out.println("You have be dealt an Ace. Would like the Ace to be of value 1 or 11?");
    int AceValue = StdIn.readInt();
    
    if (!(AceValue == 1 || AceValue == 11)) 
      return AceCheck(ace);
    else 
      return AceValue;
    }
    return ace;
  }
  
  public static String WhatToDo(String[] deck, int Score, int CardCount){
    while (Score < 21){
      System.out.println("I think the score is less than 21. You should hit.");
      System.out.println();
      System.out.println("Would you like to hit or stick?");
      int NewScore = StickOrHit(deck, StdIn.readString(), Score, CardCount);
      CardCount++;
      Score = NewScore;
    }
    if (Score > 21) {
      return "BUST A MOVE BUDDY, YOU JUST GOT BUSTED!";
    }
    else if (Score == 21) {
      return "WINNER WINNER CHICKEN DINNER!";
    }

      return "YOU STICK YOU LOSE!";
  }
  
  public static int StickOrHit(String[] deck,String response, int Score, int CardCount){
    int NewScore;
    if (response.equals("hit") || response.equals("Hit")){
      CardCount++;
      System.out.println("The card you have been dealt is " + deck[CardCount]);
      System.out.println();
      NewScore = Score + DeckChange(deck[CardCount]);
      System.out.println("Your score is " + NewScore);
      System.out.println();
      return NewScore;
     // WhatToDo(deck, NewScore, CardCount);
    }
    else {
      return Score;
    }
  }
  
  /********************************** MAIN *************************************************/
  
  public static void main(String[] args){
    
    // Introductory messages
    System.out.println("Welcome! Welcome stranger! Who might you be?");
    System.out.println (Intro(StdIn.readString()));
    
    int CardCounter = 2;
    
    // The deck
    String [] deck  = { "Ace", "Ace", "Ace", "Ace", "2", "2", "2", "2", "3", "3", "3", "3", "4", "4", "4", "4", "5", "5", "5", "5", "6", "6", "6", "6", "7", "7", "7", "7", "8", "8", "8", "8", "9", "9", "9", "9", "10", "10", "10", "10", "Jack", "Jack", "Jack", "Jack", "Queen", "Queen", "Queen", "Queen", "King", "King", "King", "King"};
    
    // Game Commences
    deck = Shuffle(deck);
    System.out.println(GameTime(deck));
  }
  
}