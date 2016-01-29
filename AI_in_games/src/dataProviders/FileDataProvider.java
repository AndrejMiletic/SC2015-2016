package dataProviders;

import java.util.ArrayList;

import model.Game;

/**
 * @author Andrej Miletic
 */
public class FileDataProvider 
{	
	public static String fileName = "games.bin";
	
	public static ArrayList<Game> readGamesFromFile()
	{
		ArrayList<Game> games;
		
		games = new ArrayList<Game>();
		
		//dodati citanje iz fajla
		
		return games;
	}
	
	public static void writeGamesInFile(ArrayList<Game> games)
	{
		//dodati upisivanje u fajl
	}
	
	public static void emptyFile()
	{
		//dodati praznjenje datoteke
	}
}
