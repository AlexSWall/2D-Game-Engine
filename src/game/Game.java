package game;

import javax.swing.SwingUtilities;

import controller.MasterController;
import data.MasterData;
import view.MasterView;

/*
 * TODO: Make TODO list.
 *
 * Make nice Menu
 * Make nice Battle view
 * Create Battle system
 *
 */

public class Game
{
	public static final String	GAMENAME	= "2D Game";
	public static final String	VERSION		= "v1.1";
	public static final int		WIDTH		= 800;
	public static final int		HEIGHT		= 480;

	private MasterData			data;
	private MasterView			view;
	private MasterController	controller;

	public static void main ( String[] args )
	{
		new Game().startGame();
	}

	private void startGame ()
	{
		SwingUtilities.invokeLater( new Runnable()
		{
			@Override
			public void run ()
			{
				load();
			}
		} );
	}

	private void load ()
	{
		data = new MasterData( GAMENAME + " " + VERSION, WIDTH, HEIGHT );
		view = new MasterView( data );
		controller = new MasterController( data, view );
		view.getLocalView().setUpdateListener( controller.getLocalController() );
		view.getMenuView().setUpdateListener( controller.getMenuController() );

		view.start();
	}
}
