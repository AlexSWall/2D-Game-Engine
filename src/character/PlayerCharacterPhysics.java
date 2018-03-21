package character;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import geometry.Position;
import maps.AbstractGameMap;
import maps.ImageObject;

public class PlayerCharacterPhysics
{
	private Position			position;
	private final static double	BASESPEED					= 0.15;
	private double				speed;

	private final int			collBoxXOffset				= 16;
	private final int			collBoxYOffset				= 26;
	private int					zOrder;

	private Vector2f			directionLastMoved			= new Vector2f( 0, 0 );
	private Vector2f			directionSecondLastMoved	= new Vector2f( 0, 0 );

	private Shape				collisionBox;

	public PlayerCharacterPhysics()
	{
		this.collisionBox = new Ellipse( collBoxXOffset, collBoxYOffset, 8, 8, 16 );
		this.speed = BASESPEED;
	}

	public double getSpeed ()
	{
		return speed;
	}

	protected void setSpeed ( double speed )
	{
		this.speed = speed;
	}

	public int getzOrder ()
	{
		return zOrder;
	}

	public Position getPosition ()
	{
		return position;
	}

	public void setPosition ( Position position )
	{
		this.position = position;
	}

	public void setPosition ( double x, double y )
	{
		position = new Position( x, y );
	}

	public Shape getCollisionBox ()
	{
		return collisionBox;
	}

	public int getCollBoxXOffset ()
	{
		return collBoxXOffset;
	}

	public int getCollBoxYOffset ()
	{
		return collBoxYOffset;
	}

	public boolean moveCharacter ( AbstractGameMap map, int delta, int relX, int relY, boolean shiftDown )
	{
		if ( shiftDown )
			setSpeed( BASESPEED * 1.75 );
		else
			setSpeed( BASESPEED );

		if ( Math.abs( relX ) == 1 && Math.abs( relY ) == 1 )
		{
			return moveXY( relX * getSpeed() * 0.71, -relY * getSpeed() * 0.71, delta, map );
		}
		else
		{
			return moveXY( relX * getSpeed(), -relY * getSpeed(), delta, map );
		}

	}

	/**
	 * Moves this character by a vector 'v = delta *
	 * (xChange, yChange)' by repeatedly calling
	 * moveXYAttempts per pixel, with the values xChange and
	 * yChange representing the movement in pixels per
	 * millisecond.
	 *
	 * @param xChange
	 *            - Change in x-coordinate per millisecond.
	 * @param yChange
	 *            - Change in y-coordinate per millisecond.
	 * @param delta
	 *            - Time in milliseconds since last frame.
	 * @param map
	 *            - The map to move within.
	 */
	public boolean moveXY ( double xChange, double yChange, int delta, AbstractGameMap map )
	{
		if ( xChange == 0 && yChange == 0 )
		{
			return false;
		}
		for ( int i = 0; i < delta; i++ )
		{
			if ( !moveXYAttempts( xChange, yChange, map, false, false ) )
			{
				if ( i == 0 )
				{
					return false;
				}
				break;
			}
		}

		return true;
	}

	/**
	 * Attempts to move this character by xChange pixels
	 * right and yChange pixels down.
	 *
	 * @param xChange
	 *            - Change in x-coordinate.
	 * @param yChange
	 *            - Change in y-coordinate.
	 * @param map
	 *            - The map to attempt to move within.
	 * @param tryAgain
	 *            - Is this a second attempt?
	 * @param secondTryAgain
	 *            - Is this a third attempt?
	 * @return Has this character successfully moved.
	 */
	public boolean moveXYAttempts ( double xChange, double yChange, AbstractGameMap map, boolean tryAgain, boolean secondTryAgain )
	{
		/*
		 * Creates a normal (i.e. length 1) vector of the
		 * movement being attempted.
		 */
		Vector2f movementVectorNormalised = ( new Vector2f( (float) xChange, (float) yChange ) ).normalise();

		/*
		 * Moves this character's collision box to where
		 * it'll move, to check for a collision.
		 */
		collisionBox.setX( (float) ( position.getX() + xChange + 8 ) );
		collisionBox.setY( (float) ( position.getY() + yChange + 22 ) );

		/*
		 * A list of vectors which represent the resultant
		 * movement after collision with map objects.
		 */

		List<Vector2f> listOfVectors = new ArrayList<Vector2f>();

		/*
		 * For each collision box of each image object in
		 * the map, if this character would collide, add
		 * such resultant movement vectors to listOfVectors.
		 */
		for ( ImageObject imageObj : map.getImageObjects() )
		{
			for ( Shape imageObjCollShape : imageObj.getCollisionBoxes() )
			{
				if ( imageObjCollShape.intersects( collisionBox ) )
				{
					listOfVectors.addAll( getIntersectionMovementVector( imageObjCollShape, collisionBox, xChange, yChange ) );
				}
			}
		}

		/*
		 * If there are no collisions, this character can
		 * move.
		 */

		if ( listOfVectors.size() == 0 )
		{
			position.translate( xChange, yChange );
			directionLastMoved = new Vector2f( (float) xChange, (float) yChange );
			return true;
		}

		double rightDirAngle = 0;
		double leftDirAngle = 0;
		boolean willMove = true;
		Vector2f rightVectorChange = new Vector2f( 0, 0 );
		Vector2f leftVectorChange = new Vector2f( 0, 0 );

		for ( Vector2f vector : listOfVectors )
		{
			if ( vector.length() < 0.001 && vector.getTheta() == 0 )
			{
				willMove = false;
			}

			/*
			 * If the character is attempting to move into a
			 * wall which is parallel to their line of
			 * travel, the code enters a special case where
			 * it checks to see if we can move slightly
			 * right of course or slightly left of course
			 * successfully.
			 */
			if ( vector.getX() == 1000 && vector.getY() == 1000 )
			{

				Vector2f rightVector = new Vector2f( (float) xChange, (float) yChange ),
						leftVector = new Vector2f( (float) xChange, (float) yChange );
				rightVector.setTheta( rightVector.getTheta() + 10 );
				leftVector.setTheta( leftVector.getTheta() - 10 );

				/* TODO: What's happening here? This can break. */
				if ( !moveXYAttempts( rightVector.getX(), rightVector.getY(), map, true, true ) )
				{
					if ( !moveXYAttempts( leftVector.getX(), leftVector.getY(), map, true, true ) )
					{
						return false;
					}
				}
				return true;
			}
			double theta = vector.getTheta() - movementVectorNormalised.getTheta();

			if ( theta > 180 )
				theta = theta - 360;
			if ( theta < -180 )
				theta = theta + 360;

			if ( theta == 180 || theta == -180 )
			{
				return false;
			}

			if ( theta > rightDirAngle )
			{
				rightDirAngle = theta;
				rightVectorChange = vector;
			}
			else if ( theta < leftDirAngle )
			{
				leftDirAngle = theta;
				leftVectorChange = vector;
			}
		}

		if ( !willMove )
		{
			return false;
		}

		if ( rightDirAngle == 0 )
		{
			this.position.translate( leftVectorChange.getX(), leftVectorChange.getY() );
			this.collisionBox.setLocation( (float) ( position.getX() + xChange + collBoxXOffset ),
					(float) ( position.getY() + yChange + collBoxYOffset ) );
			this.directionSecondLastMoved = directionLastMoved;
			this.directionLastMoved = new Vector2f( leftVectorChange.getX(), leftVectorChange.getY() );
			return true;
		}
		else if ( leftDirAngle == 0 )
		{
			this.position.translate( rightVectorChange.getX(), rightVectorChange.getY() );
			this.collisionBox.setLocation( (float) ( position.getX() + xChange + collBoxXOffset ),
					(float) ( position.getY() + yChange + collBoxYOffset ) );
			this.directionSecondLastMoved = directionLastMoved;
			this.directionLastMoved = new Vector2f( rightVectorChange.getX(), rightVectorChange.getY() );
			return true;
		}
		else if ( secondTryAgain )
		{
			return false;
		}
		else if ( tryAgain )
		{
			return moveXYAttempts( directionSecondLastMoved.getX(), directionSecondLastMoved.getY(), map, true, true );
		}
		else
		{
			return moveXYAttempts( directionLastMoved.getX(), directionLastMoved.getY(), map, true, false );
		}
	}

	/**
	 * @param imageObjCollShape
	 * @param collisionBox
	 * @param xChange
	 * @param yChange
	 * @return
	 */
	public List<Vector2f> getIntersectionMovementVector ( Shape imageObjCollShape, Shape collisionBox, double xChange, double yChange )
	{
		Vector2f movementVector;
		Vector2f newMotionVector;
		Line line;
		List<Vector2f> list = new ArrayList<Vector2f>();

		for ( int i = 0; i < imageObjCollShape.getPointCount(); i++ )
		{
			movementVector = new Vector2f( (float) xChange, (float) yChange );

			float[] point1 = imageObjCollShape.getPoint( i );
			float[] point2 = imageObjCollShape.getPoint( ( i + 1 ) % imageObjCollShape.getPointCount() );

			line = new Line( point1[0], point1[1], point2[0], point2[1] );

			if ( ( line ).intersects( collisionBox ) )
			{
				// Gets normal vector out of wall.
				Vector2f normVector = new Vector2f( point1[0] - point2[0], point1[1] - point2[1] ).getPerpendicular().normalise();

				newMotionVector = new Vector2f();

				// Vector pushing character out of wall.
				Vector2f vector1 = normVector.scale( normVector.dot( movementVector ) ).negate();

				if ( vector1.length() < 0.0001 )
				{
					list.add( new Vector2f( 1000, 1000 ) );
					continue;
				}

				// Original movement vector + vector pushing
				// out of wall.
				newMotionVector.add( movementVector.add( vector1 ) );

				list.add( newMotionVector );
			}
		}
		return list;
	}
}
