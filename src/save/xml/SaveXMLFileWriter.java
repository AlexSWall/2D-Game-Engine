package save.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class SaveXMLFileWriter
{
	static final String		SAVES			= "saves";

	static XMLEventFactory	eventFactory	= XMLEventFactory.newInstance();
	static final XMLEvent	end				= eventFactory.createDTD( "\n" );
	static final XMLEvent	tab				= eventFactory.createDTD( "\t" );

	private String			file;

	SaveXMLFileWriter( String file )
	{
		this.file = file;
	}

	public void writeSaves ( Map<String, Save> saves ) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError
	{
		XMLEventWriter eventWriter = ( XMLOutputFactory.newInstance() ).createXMLEventWriter( new FileOutputStream( file ), "UTF-8" );

		eventWriter.add( eventFactory.createStartDocument() );
		eventWriter.add( end );
		eventWriter.add( eventFactory.createStartElement( "", "", SAVES ) );
		eventWriter.add( end );

		for (String saveDatetime : saves.keySet())
		{
			addSave( eventWriter, saveDatetime, saves.get( saveDatetime ) );
		}

		eventWriter.add( eventFactory.createEndElement( "", "", SAVES ) );
		eventWriter.add( end );
		eventWriter.add( eventFactory.createEndDocument() );
		eventWriter.close();
	}

	private void addSave ( XMLEventWriter eventWriter, String saveDatetime, Save save ) throws XMLStreamException
	{

		eventWriter.add( tab );
		eventWriter.add( eventFactory.createStartElement( "", "", Save.SAVE ) );
		eventWriter.add( eventFactory.createAttribute( Save.DATETIME, saveDatetime ) );
		eventWriter.add( end );

		for (SaveAttribute saveAttribute : SaveAttribute.values())
		{
			createNode( eventWriter, saveAttribute.toString(), save.getXmlToData().get( saveAttribute ) );
		}

		eventWriter.add( tab );
		eventWriter.add( eventFactory.createEndElement( "", "", Save.SAVE ) );
		eventWriter.add( end );
	}

	private void createNode ( XMLEventWriter eventWriter, String name, String value ) throws XMLStreamException
	{
		eventWriter.add( tab );
		eventWriter.add( tab );
		eventWriter.add( eventFactory.createStartElement( "", "", name ) );

		if ( value != null )
		{
			eventWriter.add( eventFactory.createCharacters( value ) );
		}
		else
		{
			eventWriter.add( eventFactory.createCharacters( "null" ) );
		}

		eventWriter.add( eventFactory.createEndElement( "", "", name ) );
		eventWriter.add( end );
	}

}
