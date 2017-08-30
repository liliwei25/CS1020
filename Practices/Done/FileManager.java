/*
Name: Li Liwei
Matric Number: A0155991R
*/

import java.util.*;

public class FileManager 
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);

		int queries = scn.nextInt();
		String input;
		Folder[] listOfFolders = new Folder[queries];
		Vector<File> listOfFiles = new Vector<File>();
		int numOfFolders = 0;
		int numofFiles = 0;

		for(int i = 0; i < queries; i++)
		{
			input = scn.next();
			switch(input)
			{
				case "Createfile": 
					listOfFiles.add(new File(scn.next(), scn.nextInt()));
					createFile(listOfFiles.lastElement(), scn.next(), listOfFolders, numOfFolders);
					break;
				case "Createfolder":
					listOfFolders[numOfFolders++] = new Folder(scn.next());
					break;
				case "Deletefile":
					deleteFile(scn.next(), listOfFiles, listOfFolders, numOfFolders);
					break;
				case "Count":
					input = scn.next();
					for(int n = 0; n < numOfFolders; n++)
					{
						if(input.equals(listOfFolders[n].getName()))
							System.out.println(listOfFolders[n].getSize());
					}
					break;
				case "Movefile":
					moveFile(scn.next(), scn.next(), listOfFiles, listOfFolders, numOfFolders);
					break;
				case "Findlargest":
					largestFolder(listOfFolders, numOfFolders);
					break;
			}
		}
	}
	public static void moveFile(String fileName, String folderName, Vector<File> listOfFiles, Folder[] listOfFolders, int numOfF)
	{
		for(int i = 0; i< listOfFiles.size(); i++)
		{
			if(fileName.equals(listOfFiles.elementAt(i).getName()))
			{
				for(int n = 0; n < numOfF; n++)
				{
					if(listOfFolders[n].checkFile(listOfFiles.elementAt(i)))
						listOfFolders[n].removeFile(listOfFiles.elementAt(i));
				}
				for(int n = 0; n < numOfF; n++)
					if(listOfFolders[n].getName().equals(folderName))
						listOfFolders[n].addFile(listOfFiles.elementAt(i));
				break;
			}
		}
	}
	public static void largestFolder(Folder[] list, int size)
	{
		int maxSize = -1;
		String maxName = "";
		
		for(int i = 0; i < size; i++)
		{
			if(list[i].getSize() > maxSize)
			{
				maxSize = list[i].getSize();
				maxName = list[i].getName();
			}
		}
		System.out.println(maxName);
	}
	public static void createFile(File file, String folderName, Folder[] listOfFolders, int numOfF)
	{
		for(int i = 0; i < numOfF; i++)
			if(folderName.equals(listOfFolders[i].getName()))
				listOfFolders[i].addFile(file);
	}
	public static void deleteFile(String fileName, Vector<File> listOfFiles, Folder[] listOfFolders, int numOfF)
	{
		for(int i = 0; i < listOfFiles.size(); i++)
		{
			if(((listOfFiles.elementAt(i)).getName()).equals(fileName))
			{
				for(int n = 0; n < numOfF; n++)
				{
					if(listOfFolders[n].checkFile(listOfFiles.elementAt(i)))
						listOfFolders[n].removeFile(listOfFiles.elementAt(i));
				}
				listOfFiles.remove(i);
			}
		}
	}
}

class File 
{
	//define the appropriate attributes and constructor
	private String name;
	private int size;
	//private String folder;

	public File(String name, int size)
	{
		this.name = name;
		this.size = size;
	}
	public int getSize()
	{
		return size;
	}
	public String getName()
	{
		return name;
	}
}

class Folder 
{
	//define the appropriate attributes and constructor
	private String name;
	private int size = 0;
	private Vector<File> listOfFiles = new Vector<File>();

	public Folder(String name)
	{
		this.name = name;
	}
	public void addFile(File file)
	{
		listOfFiles.add(file);
		size+=file.getSize();
	}
	public void removeFile(File file)
	{
		listOfFiles.remove(file);
		size-=file.getSize();
	}
	public boolean checkFile(File file)
	{
		return listOfFiles.contains(file);
	}
	/*
	public boolean checkFile(String file)
	{
		for(int i = 0; i < listOfFiles.size(); i++)
		{
			if(file.equals(listOfFiles.elementAt(i)))
				return true;
		}
		return false;
	}
	*/
	public String getName()
	{
		return name;
	}
	public int getSize()
	{
		return size;
	}
}
