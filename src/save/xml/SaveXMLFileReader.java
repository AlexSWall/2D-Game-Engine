package save.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.TreeMap;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class SaveXMLFileReader
{
	private String file;

	public SaveXMLFileReader( String file )
	{
		this.file = file;
	}

	public TreeMap<String, Save> readConfig ()
	{
		TreeMap<String, Save> items = new TreeMap<String, Save>();
		try
		{
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream( file );
			XMLEventReader eventReader = inputFactory.createXMLEventReader( in );
			// read the XML document
			String datetime = null;
			Save save = null;

			while ( eventReader.hasNext() )
			{
				XMLEvent event = eventReader.nextEvent();

				if ( event.isStartElement() )
				{
					StartElement startElement = event.asStartElement();

					if ( startElement.getName().getLocalPart().equals( Save.SAVE ) )
					{
						save = new Save();
						/*
						 * We read the attributes from this
						 * tag and add the date attribute to
						 * our object
						 */
						@SuppressWarnings ( "unchecked" )
						Iterator<Attribute> attributes = startElement.getAttributes();
						while ( attributes.hasNext() )
						{
							Attribute attribute = attributes.next();
							if ( attribute.getName().toString().equals( Save.DATETIME ) )
							{
								datetime = attribute.getValue();
							}
						}
						continue;
					}

					try
					{
						SaveAttribute saveAttribute = SaveAttribute
								.valueOf( event.asStartElement().getName().getLocalPart().toUpperCase() );
						event = eventReader.nextEvent();
						save.getXmlToData().put( saveAttribute, event.asCharacters().getData() );
						continue;
					}
					catch ( IllegalArgumentException e )
					{

					}
				}

				// If we reach the end of an item element,
				// we add it to the list
				if ( event.isEndElement() )
				{
					EndElement endElement = event.asEndElement();
					if ( endElement.getName().getLocalPart() == ( Save.SAVE ) )
					{
						items.put( datetime, save );
					}
				}
			}
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch ( XMLStreamException e )
		{
			e.printStackTrace();
		}
		return items;
	}

}
