package check;

import constants.Constants;

public class Main {
	public String fName = "健太";
	public String lName = "鈴木";
	

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Main main = new Main();
		Myname myname = new Myname(main.fName, main.lName);
		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
		RobotPet robotPet = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
		
		myname.introduce();
		pet.introduce();
		robotPet.introduce();
	}

}
