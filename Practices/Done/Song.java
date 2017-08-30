import java.util.*;

class Animal
{
	public String name;
	public String sound;
}

public class Song 
{
	private Animal[] _animals;
	private static final int ANIMAL_COUNT = 5;

	public Song()
	{
		_animals = new Animal[ANIMAL_COUNT];
		_animals[0].name = "Dog";
		_animals[0].sound = "woof";
		_animals[1].name = "Cat";
		_animals[1].sound = "meow";
		_animals[2].name = "Bird";
		_animals[2].sound = "tweet";
		_animals[3].name = "Mouse";
		_animals[3].sound = "squeak";
		_animals[4].name = "Cow";
		_animals[4].sound = "moo";
	}
	public void display()
	{
		for(int i = 0; i < ANIMAL_COUNT; i++)
			System.out.println(_animals[i].name + " goes " +_animals[i].sound);
	}
	
	public static void main(String[] args)
	{
		(new Song()).display();
	}
}
