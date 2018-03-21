package maps;

import org.newdawn.slick.geom.Shape;

public class MapChange
{
	private Shape			mapChangeArea;

	private AbstractGameMap	mapTo;

	private int				changeInX;
	private int				changeInY;

	public MapChange( Shape mapChangeArea, AbstractGameMap mapTo, int changeInX, int changeInY )
	{
		super();
		this.mapChangeArea = mapChangeArea;
		this.mapTo = mapTo;
		this.changeInX = changeInX;
		this.changeInY = changeInY;
	}

	public Shape getMapChangeArea ()
	{
		return mapChangeArea;
	}

	public AbstractGameMap getMapTo ()
	{
		return mapTo;
	}

	public int getChangeInX ()
	{
		return changeInX;
	}

	public int getChangeInY ()
	{
		return changeInY;
	}
}
