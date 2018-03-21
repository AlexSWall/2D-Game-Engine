package maps;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import view.local.Entity;

public class MapHouseOuter extends AbstractGameMap
{
	@Override
	public void loadMap () throws SlickException
	{
		List<MapChange> mapChanges = new ArrayList<>();
		mapChanges.add( new MapChange( new Rectangle( 80, 160, 32, 5 ), new MapHouseInner(), -10, -30 ) );
		mapChanges.add( new MapChange( new Rectangle( 845, 100, 5, 250 ), new MapHouseForest(), -821, 250 ) );
		
		loadMap( new Image( Paths.get( "resources", "Graphics", "Play", "Maps", "Home", "Pokemon Floor 850x500.png" ).toString() ),
				new ArrayList<ImageObject>(), new ArrayList<Entity>(), mapChanges, new ArrayList<Shape>() );

		add( makeTree( 786, -57 ) );
		add( makeTree( 786, 296 ) );

		add( makeHouse( 10, 5 ) );
		add( makeTree( 360, 10 ) );
		add( makeTree( 260, 210 ) );
		add( makeTree( 460, 210 ) );

	}
}
