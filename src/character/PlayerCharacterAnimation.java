package character;

import java.nio.file.Paths;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class PlayerCharacterAnimation
{
	private SpriteSheet		characterSprite;
	private Animation		characterAnimation;
	protected Animation		movingUp, movingUpRight, movingRight, movingDownRight, movingDown, movingDownLeft, movingLeft, movingUpLeft;
	protected Animation		movingUpSprint, movingUpRightSprint, movingRightSprint, movingDownRightSprint, movingDownSprint,
			movingDownLeftSprint, movingLeftSprint, movingUpLeftSprint;
	protected Animation		lookingUp, lookingUpRight, lookingRight, lookingDownRight, lookingDown, lookingDownLeft, lookingLeft,
			lookingUpLeft;
	private boolean			movedLastLoop;
	private Direction		lookDirection;

	private final double	characterSpeed;
	private final double	sprintModifier;

	public PlayerCharacterAnimation( Direction lookDirection, double characterSpeed, double sprintModifier )
	{
		this.lookDirection = lookDirection;
		this.characterAnimation = lookingDown;
		this.characterSpeed = characterSpeed;
		this.sprintModifier = sprintModifier;
	}

	public Animation getCharacterAnimation ()
	{
		return characterAnimation;
	}

	public void setCharacterAnimation ( Animation characterAnimation )
	{
		this.characterAnimation = characterAnimation;
	}

	public Direction getLookDirection ()
	{
		return lookDirection;
	}

	public void setLookDirection ( Direction lookDirection )
	{
		this.lookDirection = lookDirection;
	}

	public void loadLookDirection ( Direction lookDirection )
	{
		setDirectionAndAnimation( lookDirection, false );
		stopCharacterAnimation();
	}

	public void createCharacterAnimation () throws SlickException
	{
		characterSprite = new SpriteSheet( Paths.get( "resources", "Graphics", "Play", "Character", "CharacterSprite2.png" ).toString(), 32,
				32 );
		int animationSpeed = (int) ( 50 / characterSpeed );

		Image[] moveUpFrames = { characterSprite.getSprite( 0, 3 ), characterSprite.getSprite( 1, 3 ), characterSprite.getSprite( 2, 3 ),
				characterSprite.getSprite( 1, 3 ) };
		movingUp = new Animation( moveUpFrames, animationSpeed );

		Image[] moveUpRightFrames = { characterSprite.getSprite( 3, 3 ), characterSprite.getSprite( 4, 3 ),
				characterSprite.getSprite( 5, 3 ), characterSprite.getSprite( 4, 3 ) };
		movingUpRight = new Animation( moveUpRightFrames, animationSpeed );

		Image[] moveRightFrames = { characterSprite.getSprite( 0, 2 ), characterSprite.getSprite( 1, 2 ), characterSprite.getSprite( 2, 2 ),
				characterSprite.getSprite( 1, 2 ) };
		movingRight = new Animation( moveRightFrames, animationSpeed );

		Image[] moveDownRightFrames = { characterSprite.getSprite( 3, 2 ), characterSprite.getSprite( 4, 2 ),
				characterSprite.getSprite( 5, 2 ), characterSprite.getSprite( 4, 2 ) };
		movingDownRight = new Animation( moveDownRightFrames, animationSpeed );

		Image[] moveDownFrames = { characterSprite.getSprite( 0, 0 ), characterSprite.getSprite( 1, 0 ), characterSprite.getSprite( 2, 0 ),
				characterSprite.getSprite( 1, 0 ) };
		movingDown = new Animation( moveDownFrames, animationSpeed );

		Image[] moveDownLeftFrames = { characterSprite.getSprite( 3, 0 ), characterSprite.getSprite( 4, 0 ),
				characterSprite.getSprite( 5, 0 ), characterSprite.getSprite( 4, 0 ) };
		movingDownLeft = new Animation( moveDownLeftFrames, animationSpeed );

		Image[] moveLeftFrames = { characterSprite.getSprite( 0, 1 ), characterSprite.getSprite( 1, 1 ), characterSprite.getSprite( 2, 1 ),
				characterSprite.getSprite( 1, 1 ) };
		movingLeft = new Animation( moveLeftFrames, animationSpeed );

		Image[] moveUpLeftFrames = { characterSprite.getSprite( 3, 1 ), characterSprite.getSprite( 4, 1 ),
				characterSprite.getSprite( 5, 1 ), characterSprite.getSprite( 4, 1 ) };
		movingUpLeft = new Animation( moveUpLeftFrames, animationSpeed );

		Image[] lookUpFrames = { characterSprite.getSprite( 1, 3 ) };
		lookingUp = new Animation( lookUpFrames, 100000 );

		Image[] lookUpRightFrames = { characterSprite.getSprite( 4, 3 ) };
		lookingUpRight = new Animation( lookUpRightFrames, 100000 );

		Image[] lookRightFrames = { characterSprite.getSprite( 1, 2 ) };
		lookingRight = new Animation( lookRightFrames, 100000 );

		Image[] lookDownRightFrames = { characterSprite.getSprite( 4, 2 ) };
		lookingDownRight = new Animation( lookDownRightFrames, 100000 );

		Image[] lookDownFrames = { characterSprite.getSprite( 1, 0 ) };
		lookingDown = new Animation( lookDownFrames, 100000 );

		Image[] lookDownLeftFrames = { characterSprite.getSprite( 4, 0 ) };
		lookingDownLeft = new Animation( lookDownLeftFrames, 100000 );

		Image[] lookLeftFrames = { characterSprite.getSprite( 1, 1 ) };
		lookingLeft = new Animation( lookLeftFrames, 100000 );

		Image[] lookUpLeftFrames = { characterSprite.getSprite( 4, 1 ) };
		lookingUpLeft = new Animation( lookUpLeftFrames, 100000 );

		Image[] moveUpSprintFrames = { characterSprite.getSprite( 1, 3 ), characterSprite.getSprite( 0, 3 ),
				characterSprite.getSprite( 1, 3 ), characterSprite.getSprite( 2, 3 ) };
		movingUpSprint = new Animation( moveUpSprintFrames, (int) ( sprintModifier * animationSpeed ) );

		Image[] moveUpRightSprintFrames = { characterSprite.getSprite( 4, 3 ), characterSprite.getSprite( 3, 3 ),
				characterSprite.getSprite( 4, 3 ), characterSprite.getSprite( 5, 3 ) };
		movingUpRightSprint = new Animation( moveUpRightSprintFrames, (int) ( sprintModifier * animationSpeed ) );

		Image[] moveRightSprintFrames = { characterSprite.getSprite( 1, 2 ), characterSprite.getSprite( 0, 2 ),
				characterSprite.getSprite( 1, 2 ), characterSprite.getSprite( 2, 2 ) };
		movingRightSprint = new Animation( moveRightSprintFrames, (int) ( sprintModifier * animationSpeed ) );

		Image[] moveDownRightSprintFrames = { characterSprite.getSprite( 4, 2 ), characterSprite.getSprite( 3, 2 ),
				characterSprite.getSprite( 4, 2 ), characterSprite.getSprite( 5, 2 ) };
		movingDownRightSprint = new Animation( moveDownRightSprintFrames, (int) ( sprintModifier * animationSpeed ) );

		Image[] moveDownSprintFrames = { characterSprite.getSprite( 1, 0 ), characterSprite.getSprite( 0, 0 ),
				characterSprite.getSprite( 1, 0 ), characterSprite.getSprite( 2, 0 ) };
		movingDownSprint = new Animation( moveDownSprintFrames, (int) ( sprintModifier * animationSpeed ) );

		Image[] moveDownLeftSprintFrames = { characterSprite.getSprite( 4, 0 ), characterSprite.getSprite( 3, 0 ),
				characterSprite.getSprite( 4, 0 ), characterSprite.getSprite( 5, 0 ) };
		movingDownLeftSprint = new Animation( moveDownLeftSprintFrames, (int) ( sprintModifier * animationSpeed ) );

		Image[] moveLeftSprintFrames = { characterSprite.getSprite( 1, 1 ), characterSprite.getSprite( 0, 1 ),
				characterSprite.getSprite( 1, 1 ), characterSprite.getSprite( 2, 1 ) };
		movingLeftSprint = new Animation( moveLeftSprintFrames, (int) ( sprintModifier * animationSpeed ) );

		Image[] moveUpLeftSprintFrames = { characterSprite.getSprite( 4, 1 ), characterSprite.getSprite( 3, 1 ),
				characterSprite.getSprite( 4, 1 ), characterSprite.getSprite( 5, 1 ) };
		movingUpLeftSprint = new Animation( moveUpLeftSprintFrames, (int) ( sprintModifier * animationSpeed ) );
	}

	public void moveCharacter ( int delta, double relX, double relY, boolean shiftDown )
	{
		update( delta );

		if ( Math.abs( relX ) == 1 && Math.abs( relY ) == 1 )
		{
			if ( relX == 1 )
			{
				if ( relY == 1 )
				{
					setDirectionAndAnimation( Direction.UP_RIGHT, shiftDown );
				}
				else
				{
					setDirectionAndAnimation( Direction.DOWN_RIGHT, shiftDown );
				}
			}
			else
			{
				if ( relY == 1 )
				{
					setDirectionAndAnimation( Direction.UP_LEFT, shiftDown );
				}
				else
				{
					setDirectionAndAnimation( Direction.DOWN_LFFT, shiftDown );
				}
			}
		}
		else if ( relY == 1 )
		{
			setDirectionAndAnimation( Direction.UP, shiftDown );
		}
		else if ( relX == 1 )
		{
			setDirectionAndAnimation( Direction.RIGHT, shiftDown );
		}
		else if ( relY == -1 )
		{
			setDirectionAndAnimation( Direction.DOWN, shiftDown );
		}
		else if ( relX == -1 )
		{
			setDirectionAndAnimation( Direction.LEFT, shiftDown );
		}
		else if ( movedLastLoop )
		{
			stopCharacterAnimation();
			movedLastLoop = false;
			return;
		}
		movedLastLoop = true;
	}

	private void setDirectionAndAnimation ( Direction direction, boolean shiftDown )
	{
		setLookDirection( direction );

		switch ( direction )
		{
			case DOWN:
				if ( shiftDown )
					setCharacterAnimation( movingDownSprint );
				else
					setCharacterAnimation( movingDown );
				break;

			case DOWN_LFFT:
				if ( shiftDown )
					setCharacterAnimation( movingDownLeftSprint );
				else
					setCharacterAnimation( movingDownLeft );
				break;

			case DOWN_RIGHT:
				if ( shiftDown )
					setCharacterAnimation( movingDownRightSprint );
				else
					setCharacterAnimation( movingDownRight );
				break;

			case LEFT:
				if ( shiftDown )
					setCharacterAnimation( movingLeftSprint );
				else
					setCharacterAnimation( movingLeft );
				break;

			case RIGHT:
				if ( shiftDown )
					setCharacterAnimation( movingRightSprint );
				else
					setCharacterAnimation( movingRight );
				break;

			case UP:
				if ( shiftDown )
					setCharacterAnimation( movingUpSprint );
				else
					setCharacterAnimation( movingUp );
				break;

			case UP_LEFT:
				if ( shiftDown )
					setCharacterAnimation( movingUpLeftSprint );
				else
					setCharacterAnimation( movingUpLeft );
				break;

			case UP_RIGHT:
				if ( shiftDown )
					setCharacterAnimation( movingUpRightSprint );
				else
					setCharacterAnimation( movingUpRight );
				break;
		}
	}

	public void stopCharacterAnimation ()
	{
		if ( characterAnimation.equals( movingUp ) || characterAnimation.equals( movingUpSprint ) )
			setCharacterAnimation( lookingUp );
		else if ( characterAnimation.equals( movingUpRight ) || characterAnimation.equals( movingUpRightSprint ) )
			setCharacterAnimation( lookingUpRight );
		else if ( characterAnimation.equals( movingRight ) || characterAnimation.equals( movingRightSprint ) )
			setCharacterAnimation( lookingRight );
		else if ( characterAnimation.equals( movingDownRight ) || characterAnimation.equals( movingDownRightSprint ) )
			setCharacterAnimation( lookingDownRight );
		else if ( characterAnimation.equals( movingDown ) || characterAnimation.equals( movingDownSprint ) )
			setCharacterAnimation( lookingDown );
		else if ( characterAnimation.equals( movingDownLeft ) || characterAnimation.equals( movingDownLeftSprint ) )
			setCharacterAnimation( lookingDownLeft );
		else if ( characterAnimation.equals( movingLeft ) || characterAnimation.equals( movingLeftSprint ) )
			setCharacterAnimation( lookingLeft );
		else if ( characterAnimation.equals( movingUpLeft ) || characterAnimation.equals( movingUpLeftSprint ) )
			setCharacterAnimation( lookingUpLeft );
	}

	public void update ( int delta )
	{
		movingUp.update( delta );
		movingUpSprint.update( delta );
		movingUpRight.update( delta );
		movingUpRightSprint.update( delta );
		movingRight.update( delta );
		movingRightSprint.update( delta );
		movingDownRight.update( delta );
		movingDownRightSprint.update( delta );
		movingDown.update( delta );
		movingDownSprint.update( delta );
		movingDownLeft.update( delta );
		movingDownLeftSprint.update( delta );
		movingLeft.update( delta );
		movingLeftSprint.update( delta );
		movingUpLeft.update( delta );
		movingUpLeftSprint.update( delta );
	}
}
