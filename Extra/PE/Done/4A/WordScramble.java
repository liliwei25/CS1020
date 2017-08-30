import java.util.*;

public class WordScramble 
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    WordScramble ws = new WordScramble();
    ws.play(sc);
  }
  public void play(Scanner sc) 
  {
    int part = Integer.parseInt(sc.nextLine());
    char[] array = sc.next().toCharArray();
    
    if (part == 1) {
      char[] word = sc.next().toCharArray();
      findWordInArray(array, word, part);
    } else if (part == 2) {
      int numberOfWords = sc.nextInt();
      for (int i =0;i < numberOfWords; i++) {
        char[] word = sc.next().toCharArray();
        findWordInArray(array, word, part);
      }
    }
  }
  private void findWordInArray(char[] array, char[] word, int part)
  {
    if(part == 2)
    {
      int result = findWord(array.clone(), word, 0, array.length);
      if(result == -1) System.out.println("Not found");
      else System.out.println("Found at position "+ result);
    }
    else if(part == 1)
    {
      int result = findFull(array.clone(), word, 0);
      if(result == -1) System.out.println("Not found");
      else System.out.println("Found at position "+ result);
    }
  }
  private int findFull(char[] array, char[] word, int index)
  {
    if(index >= array.length) return -1;
    else
    {
      if(word[0] == array[index])
      {
        if(same(Arrays.copyOfRange(array, index, index + word.length), word))
          return index;
        else
          return findFull(array, word, index+1);
      }
      else
      {
        return findFull(array, word, index + 1);
      }
    }
  }
  private boolean same(char[] array, char[] word)
  {
    for(int i = 0; i < word.length; i++)
    {
      if(array[i] != word[i]) return false;
    }
    return true;
  }
  private int findWord(char[] array, char[] word, int index, int result)
  {
    if(word.length == 0) return result;
    if(index >= array.length) return -1;
    else
    {
      if(word[0] == array[index])
      {
        result = Math.min(index, result);
        return findWord(array, Arrays.copyOfRange(word, 1, word.length), index + 1, result);
      }
      else
      {
        return findWord(array, word, index+1, result);
      }
    }
  }
}
