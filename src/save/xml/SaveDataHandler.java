package save.xml;

import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

@SuppressWarnings ( "unused" )
public class SaveDataHandler
{
	private TreeMap<String, Save>	saveFiles;
	private SaveXMLFileReader		saveFileReader;
	private SaveXMLFileWriter		saveFileWriter;
	private DateTimeFormatter		isoFormatter;

	public SaveDataHandler()
	{
		String saveFileLocation = Paths.get( "resources", "Save Data", "XMLSaveFile.xml" ).toString();
		saveFileReader = new SaveXMLFileReader( saveFileLocation );
		saveFileWriter = new SaveXMLFileWriter( saveFileLocation );
		isoFormatter = DateTimeFormatter.ISO_DATE_TIME;
	}

	public TreeMap<String, Save> getSaveFiles ()
	{
		return saveFiles;
	}

	public void read ()
	{
		saveFiles = saveFileReader.readConfig();
	}

	public void write () throws Exception
	{
		saveFileWriter.writeSaves( saveFiles );
	}

	public void addSave ( String datetime, Save save )
	{
		saveFiles.put( datetime, save );
	}

	public Save deleteSave ( String datetime )
	{
		return saveFiles.remove( datetime );
	}

	public Save getSave ( String datetime )
	{
		return saveFiles.get( datetime );
	}

	public void printSaveFiles ()
	{
		for (String datetime : saveFiles.keySet())
		{
			System.out.printf( "%s: %s\n", datetime, saveFiles.get( datetime ) );
		}
	}

	public static void main ( String[] args ) throws Exception
	{
		SaveDataHandler handler = new SaveDataHandler();
		handler.run();
	}

	private void run () throws Exception
	{
		read();
		printSaveFiles();
		write();

	}
}
