using System;

namespace hangman
{
    class Program
    {
        static void Main(string[] args)
        {
            
            play(1);
        }

        static void play(int level){
            string[] wordArr = 
            {
                "printed","angle","planning","hidden","pain","today",
                "away","stood","tried","hello","yet","week",
                "settle","swung","southern","memory","basic","post",
                "news","comfortable","fish","steep","terrible","heat",
                "certain","article","pattern","character","floating","government",
                "process","push","stuck","feed","noted","wild",
                "deal","equal","due","wear","gather","sea"
            };

            string[] secondLevel =
            {
                "orange","stove","topic","repeat","dried","press","expect","from","herd","live",
                "plane","possible","thrown","southern","return","mass","tea","feed","ability","direction",
                "various","gulf","should","able","about","special","understanding","yesterday","mood","moving",
                "been","affect","wish","steady","driving","snake","bare","trail","property","kitchen",
                "musical","master","guess","living","length","they","it","then","combine","putting",
                "said","certain","tube","generally","behavior","willing","result","outside","wind","army",
                "writing","relationship","outline","level","push","must","due","rule","was","darkness",
                "according","take","route","silent","world","expression","stand","fellow","complex","too",
                "congress","angle","welcome","finish","whom","seldom","grow","steady","stiff","driver",
                "stranger","putting","cry","modern","eat","blanket","member","fun","movement","beyond",
                "purple","particular","slip","glass","wrong","hat","favorite","hide","observe","captured"
            };

            Random random = new Random();
            string word = "";
            if(level == 1)
            {
                Console.WriteLine("Playing Level 1!");
                word = wordArr[random.Next(0, wordArr.Length)];
            }
            else if(level == 2)
            {
                Console.WriteLine("Playing Level 2!");
                word = secondLevel[random.Next(0, wordArr.Length)];
            }
            
            // Console.WriteLine(word);
            guessWord(word);
        }

        static void guessWord(string word)
        {
            char[] correct = new char[word.Length];
            string incorrect = "";
            int g = -1;
            int count = 0;
            bool result = false;
            for(int i = 0; i < word.Length; i++)
            {
                Console.Write("_ ");
                correct[i] = '_';             
            }
            Console.WriteLine();
            // Console.WriteLine($"Guess A Letter! You have {7-g} incorrect guesses left!");

            while(g < 7)
            {
                char guess = Console.ReadKey().KeyChar;
                System.Console.WriteLine();
                
                if(!word.Contains(guess))
                {
                    g++;
                    System.Console.WriteLine($"Incorrect Guess! You have {7-g} trials left");
                    incorrect += guess;
                    System.Console.WriteLine("Incorrect Guesses: "+ incorrect);
                    if(g == 0)
                    {
                        System.Console.WriteLine("______________");
                        System.Console.WriteLine("|           |");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                            
                    } else if(g == 1)
                    {
                        System.Console.WriteLine("______________");
                        System.Console.WriteLine("|           |");
                        System.Console.WriteLine("|           O");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                            
                    } else if(g == 2)
                    {
                        System.Console.WriteLine("______________");
                        System.Console.WriteLine("|           |");
                        System.Console.WriteLine("|           O");
                        System.Console.WriteLine("|           |");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                            
                    } else if(g == 3)
                    {
                        System.Console.WriteLine("______________");
                        System.Console.WriteLine("|           |");
                        System.Console.WriteLine("|           O");
                        System.Console.WriteLine("|          /|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                            
                    }  else if(g == 4)
                    {
                        System.Console.WriteLine("______________");
                        System.Console.WriteLine("|           |");
                        System.Console.WriteLine("|           O");
                        System.Console.WriteLine("|          /|\\");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                            
                    }   else if(g == 5)
                    {
                        System.Console.WriteLine("______________");
                        System.Console.WriteLine("|           |");
                        System.Console.WriteLine("|           O");
                        System.Console.WriteLine("|          /|\\");
                        System.Console.WriteLine("|          /");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                            
                    }  else if(g == 6)
                    {
                        System.Console.WriteLine("______________");
                        System.Console.WriteLine("|           |");
                        System.Console.WriteLine("|           O");
                        System.Console.WriteLine("|          /|\\");
                        System.Console.WriteLine("|          / \\");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        System.Console.WriteLine("|");
                        break;
                    }
                } 
                

                
                for(int i = 0; i < word.Length; i++)
                {
                    if(guess == word[i] && correct[i] == '_'){
                        correct[i] = guess;
                        count++;
                    } 
                }
                if(count == word.Length)
                {
                    result =  true;
                    System.Console.WriteLine(word);
                    break;
                }


                // Console.WriteLine("Correct Guesses: ");
                foreach(char c in correct)
                {
                    Console.Write(c+ " ");
                }
                Console.WriteLine();
                
            }
            if(result == true)
            {
                System.Console.WriteLine("You Win!");
                System.Console.WriteLine();
                System.Console.WriteLine("Do you wan play again? Yes | No");
                string answer = Console.ReadLine();
                if(answer.ToLower() == "yes"){
                    play(2);
                }
            } else{
                System.Console.WriteLine("You Lost!");
                System.Console.WriteLine("The word was "+word);
                System.Console.WriteLine();
                System.Console.WriteLine("Do you wan play again? Yes | No");
                string answer = Console.ReadLine();
                if(answer.ToLower() == "yes"){
                    play(1);
                }
            }
        }
    }
}
