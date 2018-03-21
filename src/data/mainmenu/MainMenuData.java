package data.mainmenu;

import java.nio.file.Paths;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import data.MasterData;

public class MainMenuData
{
	private MasterData masterData;

	private Image	menuBackground;
	private Image	playNow;
	private Image	exitGame;
	private Image	rightArrow;

	private int	centreX;
	private int	centreY;

	private int[]	arrowYPositions;
	private int		arrowPositionPointer;

	int		buttonTimer	= 0;
	boolean	buttonHeldDown;

	public MainMenuData( MasterData masterData )
	{
		this.masterData = masterData;

		centreX = (int) ( 0.5 * masterData.WIDTH );
		centreY = (int) ( 0.5 * masterData.HEIGHT );

		arrowYPositions = new int[] { centreY + 30, centreY + 80 };
		arrowPositionPointer = 0;
	}

	public void init () throws SlickException
	{
		String path = Paths.get( "resources", "Graphics", "Menu" ).toString();
		menuBackground = new Image( Paths.get( path, "menuBackground.PNG" ).toString() );
		playNow = new Image( Paths.get( path, "playNow.PNG" ).toString() );
		exitGame = new Image( Paths.get( path, "exitGame.PNG" ).toString() );
		rightArrow = new Image( Paths.get( path, "rightArrow2.PNG" ).toString() );
	}

	public int getArrowYPos ()
	{
		return arrowYPositions[ arrowPositionPointer ];
	}

	public int getButtonTimer ()
	{
		return buttonTimer;
	}

	public void setArrowPositionPointer ( int pos )
	{
		arrowPositionPointer = pos % arrowYPositions.length;
	}

	public void increaseArrowPositionPointer ( int delta )
	{
		arrowPositionPointer = ( arrowPositionPointer + delta ) % arrowYPositions.length;
	}

	public void setButtonTimer ( int buttonTimer )
	{
		this.buttonTimer = buttonTimer;
	}

	public void increaseButtonTimer ( int delta )
	{
		this.buttonTimer += delta;
	}

	public boolean isButtonHeldDown ()
	{
		return buttonHeldDown;
	}

	public void setButtonHeldDown ( boolean buttonHeldDown )
	{
		this.buttonHeldDown = buttonHeldDown;
	}

	public int getArrowPositionPointer ()
	{
		return arrowPositionPointer;
	}

	public Image getMenuBackground ()
	{
		return menuBackground;
	}

	public Image getPlayNow ()
	{
		return playNow;
	}

	public Image getExitGame ()
	{
		return exitGame;
	}

	public Image getRightArrow ()
	{
		return rightArrow;
	}

	public int getCentreX ()
	{
		return centreX;
	}

	public int getCentreY ()
	{
		return centreY;
	}
}
