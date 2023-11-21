package com.takamasa.ebe.janken;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelMaker {
	    //パネルを作るメソッド（パネルの幅と高さを指定する場合のメソッド）
		public static JPanel makePanel(Color color,int width,int height) {
			JPanel panel = new JPanel();
			panel.setBackground(color);
			panel.setPreferredSize(new Dimension(width,height));
			return panel;
		}
		
		//パネルを作るメソッド（パネルの幅と高さを指定しない場合のメソッド）
		public static JPanel makePanel(Color color) {
			JPanel panel = new JPanel();
			panel.setBackground(color);
			return panel;
		}
}
