package com.takamasa.ebe.janken;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TextMaker {
	//テキストを作るメソッド
		public static JLabel makeLabel(String str,Color color,int size) {
			JLabel label = new JLabel(str);
			label.setForeground(color);
			label.setFont(new Font("MSゴシック",Font.PLAIN,size));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			return label;
		}
}
