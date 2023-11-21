package com.takamasa.ebe.janken;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//各クラスのインポート
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
    
	//じゃんけんの手をString[]型の配列に格納する(「static」で宣言するパラメータはメソッドの外に記述する)
    private static String[] hands = new String[]{"グー","チョキ","パー"};
    
    //じゃんけんの手の画像ファイルのアドレス（パス）をString[]型の配列に格納する
    private static String[] handsImage = new String[] {"./img/janken_gu.png","./img/janken_choki","./img/janken_pa.png"};
	
	//JLabel型の変数contentslabelを定義する(「static」で宣言するパラメータはメソッドの外に記述する)
	static JLabel contentsLabel;
	static JLabel headerLabel;
	
	public static void main(String[] args) {
		
		//JFrameクラスをインスタンス化
		JFrame frame = new JFrame("じゃんけんゲーム");
		//ウィンドウのサイズを指定
		frame.setSize(640,480);
		//ウィンドウの位置を、画面の中心へ
		frame.setLocationRelativeTo(null);
		//xでアプリが終了するようにする
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ウィンドウのサイズを変更できないようにする
		frame.setResizable(false);
		
		//makePanelメソッドを使用してJPanelクラスをインスタンス化し、背景色とパネルサイズを指定する
		//（ヘッダーパネル）
		JPanel headerPanel = PanelMaker.makePanel(Color.BLACK,640,50);
		//ヘッダーパネルに、レイアウトマネージャとしてBorderLayoutを指定する
		headerPanel.setLayout(new BorderLayout());
		//makeLabelメソッドを利用してヘッダーラベルを作成
		headerLabel = TextMaker.makeLabel("「じゃんけんで勝負！」",Color.WHITE,24);
		//ヘッダーパネルにテキストを追加
		headerPanel.add(headerLabel);
		//ウィンドウにヘッダーパネルを追加
		frame.add(headerPanel,BorderLayout.NORTH);
		
		//makePanelメソッドを使用してJPanelクラスをインスタンス化し、背景色とパネルサイズを指定する
		//（コンテンツパネル）
		JPanel contentsPanel = PanelMaker.makePanel(Color.WHITE);
		//コンテンツパネルに、レイアウトマネージャとしてBorderLayoutを指定する
		contentsPanel.setLayout(new BorderLayout());
		//makeLabelメソッドを利用してコンテンツラベルを作成
		contentsLabel = TextMaker.makeLabel("じゃんけん...",Color.BLACK,40);
		//ウィンドウにコンテンツパネルを追加
		frame.add(contentsPanel,BorderLayout.CENTER);
		//コンテンツパネルにコンテンツラベルを追加
		contentsPanel.add(contentsLabel);
		
		
		//makePanelメソッドを使用してJPanelクラスをインスタンス化し、背景色とパネルサイズを指定する
		//（フッターパネル）
		JPanel footerPanel = PanelMaker.makePanel(Color.BLACK,640,50);
		//フッターパネルのレイアウトマネージャーとして、「GridLayout」を指定する
		footerPanel.setLayout(new GridLayout());
		//じゃんけんの手をそれぞれボタンに表示して、フッターパネル上に横並びに配置する。(拡張for文で)
		for(String hand:hands) {
			JButton button = new JButton(hand);
			button.setFont(new Font("MSゴシック",Font.PLAIN,24));
			button.addActionListener(new ButtonActionListener());
			footerPanel.add(button);
		}
		//ウィンドウにフッターパネルを追加
		frame.add(footerPanel,BorderLayout.SOUTH);

		
		//ウィンドウを表示する
		frame.setVisible(true);
		
		
	}
	//ボタンが押された時のためのクラス(Mainクラスに属する「内部クラス」である為、必ず「static」で宣言する)
		static class ButtonActionListener implements ActionListener{
			//ボタンが押されたときに呼ばれるメソッド
			public void actionPerformed(ActionEvent e) {
				//コンピュータの手(数値)をランダムに取得
				int computerHandNum = ComputerHand.getComputerHand();
				//数値からコンピュータの手を取り出して代入する
				String computerHand = handsImage[computerHandNum];
				//computerHand内に格納された画像ファイルのパスを引数としてImageIcon型のインスタンス「icon」を生成する
				ImageIcon icon = new ImageIcon(computerHand);
				//コンテンツパネルにじゃんけんの手のアイコンを配置する
				contentsLabel.setIcon(icon);
				
				//コンテンツパネルのテキストにコンピュータの手を指定する
				contentsLabel.setText("          ");
				//プレイヤーが出した手に対応した数値を入れるための変数（初期化した）
				int playerHandNum = 0;
				//プレイヤーが出した手の数値を探してplayerHandNumに入れる
				for(int i = 0;i<hands.length;i++) {
					if(hands[i] == e.getActionCommand()) {
						playerHandNum = i;
						break;
					}
				}
				//プレイヤーとコンピュータの手を比べて、結果のセリフを取得する
				String serif = Judge.getResultText(playerHandNum,computerHandNum);
				//ヘッダーにセリフを表示
				headerLabel.setText(serif);
				}
		}
}


