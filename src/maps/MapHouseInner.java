package maps;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import view.local.Entity;

public class MapHouseInner extends AbstractGameMap
{
	@Override
	public void loadMap () throws SlickException
	{
		List<MapChange> mapChanges = new ArrayList<>();
		mapChanges.add( new MapChange( new Rectangle( 90, 155, 32, 5 ), new MapHouseOuter(), 10, 30 ) );

		float[] outline = { 127, 156, 179, 156, 188, 147, 188, 37, 183, 32, 8, 32, 3, 37, 3, 147, 12, 156, 64, 156, 64, 148, 79, 148, 79,
				154, 82, 158, 109, 158, 112, 154, 112, 148, 127, 148 };
		ImageObject outlineObj = new ImageObject( 0f, 0f, new ArrayList<Shape>( Arrays.asList( new Polygon( outline ) ) ), 0, false );

		loadMap( new Image( Paths.get( "resources", "Graphics", "Areas", "Home - Inside", "interior_floor.png" ).toString() ),
				new ArrayList<>( Arrays.asList( outlineObj ) ), new ArrayList<Entity>(), mapChanges, new ArrayList<Shape>() );

	}
}
