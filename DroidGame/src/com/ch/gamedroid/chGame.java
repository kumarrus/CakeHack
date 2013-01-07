package com.ch.gamedroid;

import com.ch.framework.Screen;
import com.ch.framework.impl.AndroidGame;
import com.ch.gamedroid.LoadingScreen;

public class chGame extends AndroidGame {
	
	@Override
    public Screen getStartScreen() {
        return new LoadingScreen(this); 
    }

}
