package view.mainmenu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import data.mainmenu.MainMenuData;
import view.UpdateEventFirer;
import view.UpdateListener;

public class MainMenuView extends BasicGameState implements UpdateEventFirer
{
	final private int	state;

	private MainMenuData	menuData;
	
	private UpdateListener updateListener;

	public MainMenuView( MainMenuData menuData, int state )
	{
		this.menuData = menuData;
		this.state = state;
	}

	@Override
	public int getID ()
	{
		return state;
	}

	@Override
	public void init ( GameContainer gc, StateBasedGame sbg ) throws SlickException
	{
		menuData.init();
	}

	@Override
	public void render ( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException
	{
		menuData.getMenuBackground().draw( 0, 0 );
		menuData.getPlayNow().draw( menuData.getCentreX(), menuData.getCentreY() + 30 );
		menuData.getExitGame().draw( menuData.getCentreX(), menuData.getCentreY() + 80 );
		menuData.getRightArrow().draw( menuData.getCentreX() - 120, menuData.getArrowYPos() );
	}

	@Override
	public void update ( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException
	{
		updateListener.update( gc, sbg, delta );
	}

	@Override
	public void setUpdateListener ( UpdateListener updateListener )
	{
		this.updateListener = updateListener;
	}
}
