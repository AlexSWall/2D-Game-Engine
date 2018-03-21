package save.xml;

import java.util.LinkedHashMap;

import maps.AbstractGameMap;
import maps.MapHouseForest;
import maps.MapHouseInner;
import maps.MapHouseOuter;
import character.Direction;

/*
 * http://stackoverflow.com/a/736415/5233676
 */
public class Save
{
	public static final String						SAVE		= "save";
	public static final String						DATETIME	= "datetime";

	private LinkedHashMap<SaveAttribute, String>	xmlToData;

	public Save()
	{
		this.xmlToData = new LinkedHashMap<SaveAttribute, String>();
	}

	public Save( String name, String mapName, String x, String y, String direction, String data )
	{
		this.xmlToData = new LinkedHashMap<SaveAttribute, String>()
		{
			private static final long serialVersionUID = 7413871922939333215L;
			{
				put( SaveAttribute.NAME, name );
				put( SaveAttribute.MAP, mapName );
				put( SaveAttribute.X, x );
				put( SaveAttribute.Y, y );
				put( SaveAttribute.DIRECTION, direction );
				put( SaveAttribute.DATA, data );
			}
		};
	}

	public Save( String name, AbstractGameMap gameMap, int x, int y, Direction direction, String data )
	{
		this( name, gameMap.toXMLString(), Integer.toString( x ), Integer.toString( y ),
				( direction == null ? null : direction.toString() ), data );
	}

	protected LinkedHashMap<SaveAttribute, String> getXmlToData ()
	{
		return xmlToData;
	}

	public String getName ()
	{
		return xmlToData.get( SaveAttribute.NAME );
	}

	public AbstractGameMap getGameMap ()
	{
		return getGameMap( xmlToData.get( SaveAttribute.MAP ).toString() );
	}

	public int getX ()
	{
		return Integer.parseInt( xmlToData.get( SaveAttribute.X ) );
	}

	public int getY ()
	{
		return Integer.parseInt( xmlToData.get( SaveAttribute.Y ) );
	}

	public Direction getDirection ()
	{
		return Direction.valueOf( xmlToData.get( SaveAttribute.DIRECTION ) );
	}

	public String getData ()
	{
		return xmlToData.get( SaveAttribute.DATA );
	}

	public static AbstractGameMap getGameMap ( String mapName )
	{
		switch ( mapName )
		{
			case "HouseInner":
				return new MapHouseInner();
			case "HouseOuter":
				return new MapHouseOuter();
			case "HouseForest":
				return new MapHouseForest();
			default:
				return null;
		}
	}

	@Override
	public String toString ()
	{
		return xmlToData.toString();
	}

}
