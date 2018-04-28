
import java.util.Scanner;
import java.util.Random;
public class Hangman {
	
	String[] words={"program","java","csc111","hello"};
    char[] hiddenWord;
    char[] guessedWord;
    
    public Scanner s=new Scanner(System.in);
    
    public Hangman() {}
    
    private int indexOf(char c) {
    	for(int i=0 ; i<hiddenWord.length ; i++)
    		if(hiddenWord[i]==c)
    			return i;
    	
    	return -1;
    }
    
    private void setCharAt(int i,char c, char[] arr) {
    	arr[i]=c;
    }
    
    private String pickWord() {
    	Random rand=new Random();
    	int n=rand.nextInt((words.length));
    	return words[n];    	
    }
    
    private void printWord() {
    	for(int i=0 ; i<guessedWord.length ; i++)
    		System.out.print(guessedWord[i]);
    }
    
    private boolean isComplete() {
    for(int i=0 ; i<guessedWord.length ; i++)
    	if(guessedWord[i]=='*')
    		return false;
    		
    return true;
    
    
    }
    
    private void playOneRound() {
    	String temp=pickWord();   boolean done =false; int numMisses=0;
    	copyStringToArray(temp);
    	guessedWord=new char[temp.length()];
    	for(int i=0 ; i<temp.length(); i++)
    		guessedWord[i]='*';
    	
    	while(true) {
    		if(isComplete()) {
		system.out.println("Congrats you guessed the word!!!");	
    		System.out.print("The word is "); printWord(); System.out.println(". You Missed "+numMisses+" time(s)");
    		break;
    		}
    		System.out.print("(Guess) Enter a letter in word "); printWord();System.out.print(" > ");
    		 char temp1=s.next().charAt(0);
    		 
    		
    		       if( indexOf(temp1) ==-1)
    		           {System.out.println(temp1+" is not in the word");numMisses++;}
    		       else {
    		    	   for(int i=0 ; i<hiddenWord.length ; i++)
    		    		   if(hiddenWord[i]==temp1) {
    		    			   setCharAt(i,temp1,guessedWord); setCharAt(i,'$',hiddenWord);
    		    		   }
    		       }
    	}
    }

	public void play() {
		System.out.println("Welcome to Hangman game. Are you ready? OK, let us start:");
		
		String Done;		                  boolean done=false;
		while(!done) {
			playOneRound();
			System.out.print("Do you want to guess another word? Enter y or n> ");
			done=true; Done=s.next();
			if(Done.equalsIgnoreCase("y"))
				done=false; if(Done.equalsIgnoreCase("n"))
					                   done=true;
		}
		System.out.println("Goodbye!");
	}
	
	public String[] getWords() {
		return words;
	}
	
	public char[] getHiddenWord() {
		return hiddenWord;
	}
	
    
    
    
    
    private void copyStringToArray(String word) {
		hiddenWord=word.toCharArray();
		
		
    } 
}
