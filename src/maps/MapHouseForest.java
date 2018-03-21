package maps;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import view.local.Entity;

public class MapHouseForest extends AbstractGameMap
{
	@Override
	public void loadMap () throws SlickException
	{
		List<MapChange> mapChanges = new ArrayList<>();
		mapChanges.add( new MapChange( new Rectangle( 5, 350, 5, 250 ), new MapHouseOuter(), 821, -250 ) );

		List<Shape> wildernessAreas = new ArrayList<>();
		wildernessAreas.add( new Rectangle( 0, 0, 1000, 1000 ) );

		loadMap( new Image( Paths.get( "resources", "Graphics", "Play", "Environment", "Pokemon Floor 3.png" ).toString() ),
				new ArrayList<ImageObject>(), new ArrayList<Entity>(), mapChanges, wildernessAreas );

		add( makeTree( -64, 193 ) );
		add( makeTree( -64, 546 ) );

		add( makeTree( 140, 260 ) );
		add( makeTree( 270, 260 ) );
		add( makeTree( 210, 420 ) );

	}
}
