/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" 
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/

/**
 * Represents a concert.
 */
public class Concert extends AbstractShow {
	private String aPerformer;

	public Concert(String pTitle, String pPerformer, int pTime) {
		super(pTitle, pTime);
		aPerformer = pPerformer;
	}

	public String performer() {
		return aPerformer;
	}

	@Override
	public String extra() {
		return "by " + aPerformer;
	}

	@Override
	public int time() {
		return time();
	}

	@Override
	public Concert clone() {
		Concert clone = (Concert) super.clone();
		return clone;
	}
}
