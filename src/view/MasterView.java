package view;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import data.MasterData;
import view.battle.Battle;
import view.local.LocalView;
import view.mainmenu.MainMenuView;

public class MasterView extends StateBasedGame
{
	private MasterData		data;

	private LocalView		localView;
	private MainMenuView	menu;
	private Battle			battle;

	public MasterView( MasterData data )
	{
		super( data.GAMENAME );
		this.data = data;
		this.localView = new LocalView( this, data, StateEnum.PLAY.getValue() );
		this.menu = new MainMenuView( data.getMenuData(), StateEnum.MENU.getValue() );
		this.battle = new Battle( StateEnum.BATTLE.getValue() );

		this.addState( menu );
		this.addState( localView );
		this.addState( battle );
	}

	@Override
	public void initStatesList ( GameContainer gc ) throws SlickException
	{
		this.getState( StateEnum.MENU.getValue() ).init( gc, this );
		this.getState( StateEnum.PLAY.getValue() ).init( gc, this );
		this.getState( StateEnum.BATTLE.getValue() ).init( gc, this );

		this.enterState( StateEnum.MENU.getValue() );
	}

	public void start ()
	{
		AppGameContainer appGC;

		try
		{
			appGC = new AppGameContainer( this );
			appGC.setDisplayMode( data.WIDTH, data.HEIGHT, false );
			appGC.start();
		}
		catch ( SlickException e )
		{
			e.printStackTrace();
		}
	}

	public LocalView getLocalView ()
	{
		return localView;
	}

	public MainMenuView getMenuView ()
	{
		return menu;
	}

	public Battle getBattle ()
	{
		return battle;
	}
}
