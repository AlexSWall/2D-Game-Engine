package geometry;

public class Position
{
	private double	X;
	private double	Y;

	public Position()
	{
		X = 0;
		Y = 0;
	}

	public Position( double X, double Y )
	{
		this.X = X;
		this.Y = Y;
	}

	public double getX ()
	{
		return X;
	}

	public void setX ( double x )
	{
		X = x;
	}

	public double getY ()
	{
		return Y;
	}

	public void setY ( double y )
	{
		Y = y;
	}

	public void translate ( double deltaX, double deltaY )
	{
		X += deltaX;
		Y += deltaY;
	}
}
