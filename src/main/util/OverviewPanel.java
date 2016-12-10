package main.util;

import main.overviewone.OneViewItem;

import javax.swing.*;
import java.util.ArrayList;

abstract public class OverviewPanel extends JPanel{
	
	public OverviewPanel(){
		this.setBackground(ColorUtil.BACKGROUND);
	}
	
	abstract public void displayResultsOne(ArrayList<OneViewItem> results, JEditorPane ta, Object item, JLabel l);
	/*abstract public void displayResultsTwo(ArrayList<TwoViewItem> results, JTextArea ta, Object item);
	abstract public void displayResultsThree(ArrayList<ThreeViewItem> results, JTextArea ta, Object item);
	abstract public void displayResultsFour(ArrayList<FourViewItem> results, JTextArea ta, Object item);
	abstract public void displayResultsFive(ArrayList<FiveViewItem> results, JTextArea ta, Object item);
	abstract public void displayResultsSix(ArrayList<SixViewItem> results, JTextArea ta, Object item);*/
}
