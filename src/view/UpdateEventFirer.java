package view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public interface UpdateEventFirer
{	
	public void setUpdateListener ( UpdateListener updateListener );

	public void update ( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException;
}
