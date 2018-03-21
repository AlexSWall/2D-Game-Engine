package maps;

import org.newdawn.slick.Renderable;

public class RenderableImage
{
	private Renderable	renderable;
	private ZType		zType;
	private int			yRenderPos;
	private float		X;
	private float		Y;

	public RenderableImage( Renderable image, float X, float Y, ZType zType, int yRenderPos )
	{
		super();
		this.renderable = image;
		this.zType = zType;
		this.yRenderPos = yRenderPos;
		this.X = X;
		this.Y = Y;
	}

	public Renderable getRenderable ()
	{
		return renderable;
	}

	public ZType getZType ()
	{
		return zType;
	}

	public int getYRenderPos ()
	{
		return yRenderPos;
	}

	public float getX ()
	{
		return X;
	}

	public float getY ()
	{
		return Y;
	}
}
