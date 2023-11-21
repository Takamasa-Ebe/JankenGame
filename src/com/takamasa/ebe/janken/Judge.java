package com.takamasa.ebe.janken;

public class Judge {
	//じゃんけんの結果のテキストを取得するメソッド
    static String getResultText(int playerHand, int computerHand) {
    	//じゃんけんの結果のテキストを代入する変数を初期化する
    	String resultText ="";
    	//じゃんけんの結果を出すための計算式
    	int result = (playerHand - computerHand +3)%3;
    	//あいこの条件
    	if(result==0) {
    		resultText = "あいこです";
    	}
    	//プレイヤーが負けの条件
    	else if (result ==1) {
    		resultText ="コンピュータの勝ちです";
    	}//プレイヤーが勝ちの条件
    	else if (result ==2) {
    		resultText ="あなたの勝ちです！";
    	}
    	//じゃんけんの結果のテキストを返す
    	return resultText;
    }
}
