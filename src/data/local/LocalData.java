package data.local;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.newdawn.slick.SlickException;

import data.MasterData;
import maps.AbstractGameMap;
import maps.ImageObject;
import maps.MapChange;
import maps.RenderableImage;

public class LocalData
{
	private MasterData					masterData;

	private Comparator<RenderableImage>	zComparator;

	private AbstractGameMap				map;

	private List<RenderableImage>		backgroundRenderableImages;
	private List<RenderableImage>		standardRenderableImages;
	private List<RenderableImage>		topRenderableImages;
	
	private boolean escMenu;

	public LocalData( MasterData masterData )
	{
		this.masterData = masterData;
		this.escMenu = false;

		zComparator = new Comparator<RenderableImage>()
		{
			@Override
			public int compare ( RenderableImage obj1, RenderableImage obj2 )
			{
				return Integer.signum( ( (int) obj1.getY() + obj1.getYRenderPos() ) - ( (int) obj2.getY() + obj2.getYRenderPos() ) );
			}
		};
	}
	
	

	public boolean isEscMenuVisible ()
	{
		return escMenu;
	}

	public void setEscMenu ( boolean escMenu )
	{
		this.escMenu = escMenu;
	}

	public MasterData getMasterData ()
	{
		return masterData;
	}

	public AbstractGameMap getMap ()
	{
		return map;
	}

	public Comparator<RenderableImage> getzComparator ()
	{
		return zComparator;
	}

	public void setzComparator ( Comparator<RenderableImage> zComparator )
	{
		this.zComparator = zComparator;
	}

	public List<RenderableImage> getBackgroundRenderableImages ()
	{
		return backgroundRenderableImages;
	}

	public List<RenderableImage> getStandardRenderableImages ()
	{
		return standardRenderableImages;
	}

	public List<RenderableImage> getTopRenderableImages ()
	{
		return topRenderableImages;
	}

	public void changeMap ( MapChange mapChange ) throws SlickException
	{
		setupRenderables( mapChange.getMapTo() );

		masterData.getCharacter().getCharacterPhysics().getPosition().translate( mapChange.getChangeInX(), mapChange.getChangeInY() );
	}

	public void setupRenderables ( AbstractGameMap newMap ) throws SlickException
	{
		map = newMap;
		map.loadMap();

		backgroundRenderableImages = new ArrayList<RenderableImage>();
		standardRenderableImages = new ArrayList<RenderableImage>();
		topRenderableImages = new ArrayList<RenderableImage>();

		for ( ImageObject imageObject : map.getImageObjects() )

			for ( RenderableImage renderableImage : imageObject.getRenderables() )

				switch ( renderableImage.getZType() )
				{
					case BACKGROUND:
						backgroundRenderableImages.add( renderableImage );
						break;

					case STANDARD:
						standardRenderableImages.add( renderableImage );
						break;

					case TOP:
						topRenderableImages.add( renderableImage );
						break;
				}

		Collections.sort( standardRenderableImages, zComparator );
	}
}
