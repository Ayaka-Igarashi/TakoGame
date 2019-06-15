package main.phase;

import main.TWInfo;

public abstract class BattlePhase {
	protected abstract void first();
	public abstract void keyControl(TWInfo tInfo);
	public abstract void show();
}
