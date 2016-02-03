package dataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import algorithm.NGramAlgorithm;
import gui.MainFrame;
import model.Game;

/**
 * @author Andrej Miletic
 */
public class FileDataProvider 
{	
	public static String fileName = "games.bin";
	/**
	 * Promenljiva koja oznacava da li je fajl u kom 
	 * se cuvaju igre ispraznjen
	 */
	private static boolean fileEmptied = false; 
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Game> readGamesFromFile()
	{
		ArrayList<Game> games;
		
		games = new ArrayList<Game>();
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(
			        new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (objectInputStream != null){
			try {
				games = (ArrayList<Game>)objectInputStream.readObject();
				objectInputStream.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return games;
	}
	
	public static void writeGamesInFile(ArrayList<Game> games)
	{
		if (!fileEmptied){
			ObjectOutputStream objectOutputStream = null;
			try {
				objectOutputStream = new ObjectOutputStream(
				        new FileOutputStream(fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (objectOutputStream != null){
				try {
					objectOutputStream.writeObject(games);
					objectOutputStream.flush();
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void emptyFile()
	{
		writeGamesInFile(new ArrayList<Game>());
		fileEmptied = true;
		MainFrame.getInstance().getGameManager().setPreviousGames(new ArrayList<Game>());
		NGramAlgorithm.Initialize();
	}
}
