package maps;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;

import view.local.Entity;

public abstract class AbstractGameMap
{
	private Image				background;
	private List<ImageObject>	imageObjects;
	private List<Entity>		entities;
	private List<MapChange>		mapChanges;
	private List<Shape>			wildernessAreas;
	private Random				rand;
	private int					millisecondsSinceBattle;

	public AbstractGameMap()
	{
		this.imageObjects = new ArrayList<>();
	}

	protected void loadMap ( Image background, List<ImageObject> imageObjects, List<Entity> entities, List<MapChange> mapChanges,
			List<Shape> wildernessAreas ) throws SlickException
	{
		this.background = background;
		this.imageObjects = imageObjects;
		this.imageObjects.add(
				new ImageObject( new ArrayList<RenderableImage>(), 0, 0, 0, 0, background.getWidth(), background.getHeight(), false ) );
		this.entities = entities;
		this.mapChanges = mapChanges;
		this.wildernessAreas = wildernessAreas;
		this.rand = new Random();
	}

	public abstract void loadMap () throws SlickException;

	public Image getBackground ()
	{
		return background;
	}

	public List<MapChange> getMapChanges ()
	{
		return mapChanges;
	}

	public List<ImageObject> getImageObjects ()
	{
		return imageObjects;
	}

	public List<Entity> getEntities ()
	{
		return entities;
	}

	public void add ( ImageObject imObj )
	{
		imageObjects.add( imObj );
	}

	public void add ( Entity entity )
	{
		entities.add( entity );
	}

	public List<MapChange> getMapChangeAreas ()
	{
		return mapChanges;
	}

	public List<Shape> getWildernessAreas ()
	{
		return wildernessAreas;
	}

	public boolean startBattle ( double x, double y, int delta )
	{
		millisecondsSinceBattle += delta;

		if ( millisecondsSinceBattle < 1000 )
		{
			return false;
		}

		for ( Shape shape : wildernessAreas )
		{
			if ( shape.contains( (float) x, (float) y ) )
			{
				if ( rand.nextInt( 10000 ) < 3 )
				{
					millisecondsSinceBattle = 0;
					return true;
				}
				else
				{
					return false;
				}
			}
		}

		return false;
	}

	public ImageObject makeRebeccaTree ( int x, int y ) throws SlickException
	{
		List<Shape> treeCollShapes = new ArrayList<>();

		List<RenderableImage> list = new ArrayList<>();
		list.add(
				new RenderableImage( new Image( Paths.get( "resources", "Graphics", "Play", "Environment", "RebeccaTree.png" ).toString() ),
						x, y, ZType.STANDARD, 106 ) );

		return new ImageObject( list, x, y, treeCollShapes, false );
	}

	public ImageObject makeTree ( int x, int y ) throws SlickException
	{

		List<Shape> treeCollShapes = new ArrayList<>();

		float[] floatArr = { 68, 157, 73, 150, 73, 143, 79, 134, 85, 134, 99, 143, 106, 143, 111, 139, 111, 136, 105, 127, 105, 115, 109,
				111, 116, 111, 119, 108, 119, 103, 116, 100, 109, 100, 105, 96, 105, 84, 111, 75, 111, 72, 106, 68, 99, 68, 85, 77, 79, 77,
				73, 68, 73, 61, 68, 54, 59, 54, 54, 61, 54, 68, 48, 77, 42, 77, 28, 68, 21, 68, 16, 72, 16, 75, 22, 84, 22, 96, 18, 100, 11,
				100, 8, 103, 8, 108, 11, 111, 18, 111, 22, 115, 22, 127, 16, 136, 16, 139, 21, 143, 28, 143, 42, 134, 48, 134, 54, 143, 54,
				150, 59, 157 };

		Shape collisionArea = new Polygon( floatArr );
		treeCollShapes.add( collisionArea );

		List<RenderableImage> list = new ArrayList<>();
		String path = Paths.get( "resources", "Graphics", "Play", "Environment" ).toString();
		list.add( new RenderableImage( new Image( Paths.get( path, "Green Tree 32T Trunk.png" ).toString() ), x, y, ZType.STANDARD, 106 ) );
		list.add( new RenderableImage( new Image( Paths.get( path, "Green Tree 32T Leaves.png" ).toString() ), x, y, ZType.TOP, 106 ) );
		list.add(
				new RenderableImage( new Image( Paths.get( path, "Green Tree 32T Floor.png" ).toString() ), x, y, ZType.BACKGROUND, 106 ) );

		return new ImageObject( list, x, y, treeCollShapes, false );
	}

	public ImageObject makeHouse ( int x, int y ) throws SlickException
	{
		List<Shape> houseCollShapes = new ArrayList<>();
		float[] outline = { 0, 150, 10, 160, 181, 160, 191, 150, 191, 45, 181, 35, 10, 35, 0, 45 };
		houseCollShapes.add( new Polygon( outline ) );
		float[] leftPillar = { 64, 160, 64, 165, 66, 167, 77, 167, 79, 165, 79, 160 };
		houseCollShapes.add( new Polygon( leftPillar ) );
		float[] rightPillar = { 112, 160, 112, 165, 114, 167, 125, 167, 127, 165, 127, 160 };
		houseCollShapes.add( new Polygon( rightPillar ) );

		return new ImageObject( new Image( Paths.get( "resources", "Graphics", "Play", "Maps", "Home", "House 32.png" ).toString() ), x, y,
				houseCollShapes, 85, false );
	}

	public String toXMLString ()
	{
		return getClass().getSimpleName().substring( 3 );
	}
}
