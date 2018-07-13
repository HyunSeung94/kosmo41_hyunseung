package com.study.pattern04.factory_method1.Unit;

enum UnitType {
	Marine,
	Firebat
	
}

// <summary>
// The 'product'  abstract class
// </summary>
public abstract class Unit {
	protected UnitType type;
	protected String name;
	protected int hp;
	protected int exp;
	public abstract void attack();

}
