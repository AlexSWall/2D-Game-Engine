package controller;

import controller.local.LocalController;
import controller.mainmenu.MainMenuController;
import data.MasterData;
import view.MasterView;

public class MasterController
{
	private MasterData		masterData;
	private MasterView		masterView;

	private LocalController	localController;
	private MainMenuController	menuController;

	public MasterController( MasterData masterData, MasterView masterView )
	{
		this.masterData = masterData;
		this.masterView = masterView;

		localController = new LocalController( this );
		menuController = new MainMenuController( this );
	}

	public MasterData getMasterData ()
	{
		return masterData;
	}

	public MasterView getMasterView ()
	{
		return masterView;
	}

	public LocalController getLocalController ()
	{
		return localController;
	}

	public MainMenuController getMenuController ()
	{
		return menuController;
	}

}
