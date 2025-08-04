import javax.swing.JOptionPane;
public class TomlinsonProj4
{
    public static void main(String[] args)
    {
        boolean method1 = iCJava("javaxjxavaxyzjavajava");
        System.out.println("Method 1: " + method1 + "\n");
        
        boolean method2 = differentNeighbors("forest");
        System.out.println("Method 2: " + method2 + "\n");
        
        String method3a = reverse("abcd");
        System.out.println("Method 3a: " + method3a + "\n");
        
        String method3b = mirrorM("blahMboom"); 
        System.out.println("Method 3b: " + method3b + "\n");
               
        String method4 = mockMeme("Gravitational Acceleration!!”");
        System.out.println("Method 4: " + method4 + "\n");
        
        String method5a = getHint("HAPPY", "HEART");
        System.out.println("method5a: " + method5a + "\n");
        
        String hiddenWord = "TEST";
        System.out.println("Method5b:");
        playGuessingGame(hiddenWord);
        
        
        String method6 = theEvilestE("deEel");
        System.out.println("\nMethod 6: " + method6);
    }
    
    //Method 1 
    public static boolean iCJava(String str)
    {
        int counter = 0;
        for(int i = 0; i <= str.length()-4; i++) //I know we would usually do -1 of the word we are trying to find and subtract it from the lenght but since I have <=, it won't work that way
        {          
            String strCheck = str.substring(i,i+4);
            if(strCheck.equals("java"))         //Using the .equals method to compare to Object
                counter++;           
        }
        if(counter==0)                          //If counter is 0 return false since it means jaav isn't in the string at all
            return false;
        else if(counter%2==0)                   //Checking if counter is even since there needs to be an even amount of times java pops up
            return true;    
        return false;                           //Returning false since I need the return statement in general
    }
    
    //Method 2
    public static boolean differentNeighbors(String str)
    {
        if(str.length()<2)                      //If the length is less than 2, theres no need to check anything
            return true;
        if(str.charAt(0)==str.charAt(1))        //Doing this to check the first letter
            return false;                       //Automatically returning false since all the letters need to be different
        if(str.charAt(str.length()-1) == str.charAt(str.length()-2))//Doing this to check for the last character
            return false;
        for(int i = 1; i<str.length()-1; i++)   
        {
            if(str.charAt(i) == str.charAt(i-1) || str.charAt(i)== str.charAt(i+1)) //This checks the letter in general without worrying about if its first or not while also checking both sides
                return false;                   //If 2 letters are the same false gets returned
        }
        return true;
    }
    
    //Method 3a
    public static String reverse(String str)
    {
        String output = "";                     //Making an empty string to concatenate with the other letters
        for(int i = 0; i <str.length(); i++)
        {
            output+= str.charAt(str.length()-i-1); //Adding whatever letter is at i in the string minus one to get the last character to the front
        }
        return output;                          //Returning output
    }
    
    //Method 3b
    public static String mirrorM(String str)
    {
        int mLoc = str.indexOf("M");            //Assumed that M will always be there even though I don't think I should have but it's too late to change it now...
        int mBeg = Math.abs(mLoc-0);            //Finding the distance from the beginning of the string to where M is 
        int mEnd = Math.abs(mLoc-(str.length()-1)); //Same thing but for the end instead of beginning
        String sub1,sub2,sub3, sub1R, sub2R, sub3R; //Declaring Strings that I'll need later
        int sub1Len;                            //Delcaring this in advance since I know I'll need it later
        String newString = "";                  //Also making an empty String to return at the end
        if(mBeg>mEnd) //If M is closer to the end than the beginning
        {
            sub1 = str.substring(mLoc+1); //The letters which come after M
            sub1Len = sub1.length();
            sub2 = str.substring(sub1Len-1, mLoc); //The letters which come before M
            sub3 = str.substring(0,mLoc-sub1Len);  //The letters which are unaffected by the change
            sub1R = reverse(sub1);          //Using the method from before to make the changes needed
            sub2R = reverse(sub2);
            sub3R = reverse(sub3);
            newString = sub3 + sub1R + "M" + sub2R; //Concatenating the reversed chars with M
        }
        else if(mEnd>mBeg) //If M is closer to the beginning than the end
        {
            sub1 = str.substring(0,mLoc); //Letters which come before M
            sub1Len = sub1.length();
            sub2 = str.substring(mLoc+1,mLoc+sub1Len+1); //Letters which come after M
            sub3 = str.substring(mLoc+sub1Len+1);   //The letters which are unaffected by the change
            sub1R = reverse(sub1);                  //Using the method from before to make the changes needed
            sub2R = reverse(sub2);                 
            newString = sub2R + "M" + sub1R + sub3; //Concatenating the reversed chars with M
        }
        else if(mEnd == mBeg)
        {
            sub1 = str.substring(0,mLoc);       //Since the distances from M to the beginning and the end are the same I'm just making 2 substirngs and switching both
            sub2 = str.substring(mLoc+1);
            sub1R = reverse(sub1);              //Using the method from before to make the changes needed
            sub2R = reverse(sub2);
            newString = sub2R + "M" + sub1R;    //Concatenating the reversed chars with M
        }
        return newString;
    }
    
    
    //Method 4
    public static String mockMeme(String phrase)
    {      
        boolean upperCase = true;       
        String output = "";                             //Making a new string to save the chaged phrase
        for(int i=0; i<phrase.length(); i++)
        {
            char currentChar = phrase.charAt(i);        //Making a char to represent which letter of the phrase the code is checking
            if(Character.isLetter(currentChar))         //Checking if it's a letter 
            {
                if(upperCase)                           //Checking if the letter is uppercase
                    output += Character.toUpperCase(currentChar);   //Concatenating the char to the new String                              
                else                                    //If it's not uppercase then it gets changed
                    output += Character.toLowerCase(currentChar);                                
                upperCase = !upperCase;            
            }
            else if(currentChar == ' ')                 //Checks if its a space since spaces are allowed
                output+=' ';                            //Concatenates the space with the rest of the string
        }
        return output;                                  //Returning the new String
    }
    
    
    //Method 5a
    public static String getHint(String hiddenWord, String guess)
    {
        String hint = "";                               //Making an empty String to use later
        for(int i = 0; i<hiddenWord.length(); i++)  
        {
            char guessC = guess.charAt(i);              //Making a char to represent the chars in the guess made by the user
            if(guess.charAt(i) == hiddenWord.charAt(i)) //Comparing the chars both at i to see if they are the same
                hint += guess.charAt(i);                //If they are the same, the letter gets revealed
            else if(hiddenWord.indexOf(guessC) != -1)   //If the aren't but the letter is elsewhere in the string, a + gets placed in the index of i
                hint+= "+";
            else                                        //If not then the * gets placed instead
                hint += "*";
        }       
       return hint;                                     //Returning the string which was contactenated with either a letter, a + or, an *
    }
    
    //Method 5b
    public static void playGuessingGame(String hiddenWord)
    {
        int counter = 0;                    //Making a counter to keep track of the users tries
        boolean guess = false;              //Making a guess boolean to use later
        String hint = "";                   //Making hint empty so I can use it later
        String userResponse = "";           //Calling the varibale for the JOptionPane in advance so I don't deal with problems later
        for(int i =0; i<10; i++)            //Making a for loop which runs as along as the guesses of the person isn't more than 10
        {
            userResponse = JOptionPane.showInputDialog("Guess the word *in all caps*");
            counter++;      
            if(userResponse.equals(hiddenWord)) //If the user correctly guesses the word
            {
                System.out.println("Congrats you got the word and it only took you " + counter + " tries to do it"); //Concatenating counter to show how mnay tries it took
                return;                     //Putting this so the loop ends
            }
            else
            {
                hint = getHint(hiddenWord, userResponse);       //Caling the method from 5b to get the hints to give to the user and saving it in the empty hint string from earlier
                System.out.println("Hint:" + hint);             //Printing out the hint
            }
        }  
        if(counter==10)
            System.out.println("Sorry, you're out of tries.");  //The user failed to guess the word in the amount of tries given
    }
    
    
    //Method 6   
    public static String theEvilestE(String str)
    {
        int counter = 0;     
        for(int i = 0; i < str.length(); i++) //Using a for loop to count the number of times E is in the String
        {
            if (str.charAt(i) == 'E') 
            {
                counter++;
            }
        }
        if(counter%2 == 0)          //Checking if the number of E is even or not
            return str;             //If the number of E is even the string gets returned since there need to be an odd amount 
        int eCount = 0;             //Using another name to count the number of E so I don't confuse myself
        int midEIndex = 0;          //Declaring this as 0 in advance since it will get changed later
        for(int i = 0; i < str.length(); i++) 
        {
            if(str.charAt(i) == 'E') 
            {
                eCount++;
                if(eCount==(counter / 2)+1) //Finds the index of E by diving the counter but adding 1 since its dealing with odd numbers
                {
                    midEIndex = i;          //Assings the index to the int for the middle E
                }
            }
        }
        //Checking if the middle 'E' is surrounded by 'e' and making sure its not the first or last letter of the String
        if (midEIndex > 0 && midEIndex < str.length() - 1 && str.charAt(midEIndex - 1) == 'e' && str.charAt(midEIndex + 1) == 'e') 
        {
            String output = "";             //Making an empty String to use
            for (int i = 0; i < str.length(); i++) 
            {                               //Concatenating either a dash or E to the empty string based on whether or not i is the index of the middle E
                if (i == midEIndex)                 
                    output += "E";               
                else 
                    output += "-";                
            }
            return output;                  //Returning the String with the dashes along with the E
        }   
        return str;                         //Returning the original string if there wasn't an odd amount of E's and if it wasn't surrounded by 2 little e's
    }
}