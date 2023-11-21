package com.takamasa.ebe.janken;

//java.utilパッケージのRandomクラスを取り込む
import java.util.Random;

//コンピュータの手をランダムに決定するクラスComputerHandを定義する
public class ComputerHand {
	
	//コンピュータの手を取得するためのメソッド
    static int getComputerHand() {
    	
    	//Randomクラスをインスタンス化する
    	Random random = new Random();
    	
    	//int型の変数handに0～2の数値のいずれかをランダムに代入する
    	int hand = random.nextInt(3);
    	
    	//数値を代入した変数handを返す
    	return hand;
    }
}
