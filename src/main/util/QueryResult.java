package main.util;

import main.overviewone.OneViewItem;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class QueryResult implements ItemListener{
	private JEditorPane ta;
	private JComboBox c;
	private String q;
	private OverviewPanel p;
	private Object item;
	private JLabel l;
	
	public QueryResult(JEditorPane ta, JComboBox c, OverviewPanel p, JLabel l) {
		this.ta = ta;
		this.c = c;
		this.p = p;
		this.l = l;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Object item = e.getItem();
			this.item = item;
			ArrayList<OneViewItem> results = new ArrayList<>();
			p.displayResultsOne(results, ta, item, l);
		}
	}
	
	
}
