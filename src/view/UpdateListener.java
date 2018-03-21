package view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public interface UpdateListener
{
	public void update ( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException;
}
