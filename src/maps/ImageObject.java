package maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.Renderable;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class ImageObject
{
	private List<RenderableImage>	renderables;
	private float					X;
	private float					Y;
	private final boolean			isMainCharacter;

	private List<Shape>				collisionBoxes;

	private int						lowestCollBoxYCoordOffset;

	/**
	 *
	 * @param renderable
	 * @param X
	 * @param Y
	 * @param collBoxXOffset
	 * @param collBoxYOffset
	 * @param width
	 * @param height
	 * @param isMainCharacter
	 */
	public ImageObject( float X, float Y, int collBoxXOffset, int collBoxYOffset, int width, int height, boolean isMainCharacter )
	{
		this( new ArrayList<RenderableImage>(), X, Y,
				new ArrayList<Shape>( Arrays.asList( new Rectangle( X + collBoxXOffset, Y + collBoxYOffset, width, height ) ) ),
				isMainCharacter );
	}

	/**
	 *
	 * @param renderable
	 * @param X
	 * @param Y
	 * @param collisionBoxes
	 * @param yRenderPos
	 * @param isMainCharacter
	 */
	public ImageObject( float X, float Y, List<Shape> collisionBoxes, int yRenderPos, boolean isMainCharacter )
	{
		this( new ArrayList<RenderableImage>(), X, Y, collisionBoxes, isMainCharacter );
	}

	/**
	 *
	 * @param renderable
	 * @param X
	 * @param Y
	 * @param collBoxXOffset
	 * @param collBoxYOffset
	 * @param width
	 * @param height
	 * @param isMainCharacter
	 */
	public ImageObject( Renderable renderable, float X, float Y, int collBoxXOffset, int collBoxYOffset, int width, int height,
			boolean isMainCharacter )
	{
		this( new ArrayList<RenderableImage>(
				Arrays.asList( new RenderableImage( renderable, X, Y, ZType.STANDARD, (int) ( Y + collBoxYOffset + ( height >> 1 ) ) ) ) ),
				X, Y, new ArrayList<Shape>( Arrays.asList( new Rectangle( X + collBoxXOffset, Y + collBoxYOffset, width, height ) ) ),
				isMainCharacter );
	}

	/**
	 *
	 * @param renderable
	 * @param X
	 * @param Y
	 * @param collisionBoxes
	 * @param yRenderPos
	 * @param isMainCharacter
	 */
	public ImageObject( Renderable renderable, float X, float Y, List<Shape> collisionBoxes, int yRenderPos, boolean isMainCharacter )
	{
		this( new ArrayList<RenderableImage>( Arrays.asList( new RenderableImage( renderable, X, Y, ZType.STANDARD, yRenderPos ) ) ), X, Y,
				collisionBoxes, isMainCharacter );
	}

	/**
	 *
	 * @param renderables
	 * @param X
	 * @param Y
	 * @param collBoxXOffset
	 * @param collBoxYOffset
	 * @param width
	 * @param height
	 * @param isMainCharacter
	 */
	public ImageObject( List<RenderableImage> renderables, float X, float Y, int collBoxXOffset, int collBoxYOffset, int width, int height,
			boolean isMainCharacter )
	{
		this( renderables, X, Y,
				new ArrayList<Shape>( Arrays.asList( new Rectangle( X + collBoxXOffset, Y + collBoxYOffset, width, height ) ) ),
				isMainCharacter );
	}

	/**
	 *
	 * @param renderables
	 * @param X
	 * @param Y
	 * @param collisionBoxes
	 * @param isMainCharacter
	 */
	public ImageObject( List<RenderableImage> renderables, float X, float Y, List<Shape> collisionBoxes, boolean isMainCharacter )
	{
		this.renderables = renderables;
		this.X = X;
		this.Y = Y;
		this.isMainCharacter = isMainCharacter;

		this.collisionBoxes = collisionBoxes;

		this.lowestCollBoxYCoordOffset = Integer.MIN_VALUE;

		for (Shape collBox : collisionBoxes)
		{
			collBox.setCenterX( collBox.getCenterX() + X );
			collBox.setCenterY( collBox.getCenterY() + Y );
			if ( collBox.getMinY() > lowestCollBoxYCoordOffset )
				lowestCollBoxYCoordOffset = (int) collBox.getCenterY();
		}
	}

	public void setX ( int X )
	{
		this.X = X;
	}

	public void setY ( int Y )
	{
		this.Y = Y;
	}

	public List<RenderableImage> getRenderables ()
	{
		return renderables;
	}

	public float getX ()
	{
		return X;
	}

	public float getY ()
	{
		return Y;
	}

	public List<Shape> getCollisionBoxes ()
	{
		return collisionBoxes;
	}

	public boolean isMainCharacter ()
	{
		return isMainCharacter;
	}

	public int getLowestCollBoxYCoordOffset ()
	{
		return lowestCollBoxYCoordOffset;
	}

}
