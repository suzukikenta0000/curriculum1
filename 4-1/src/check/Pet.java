package check;

public class Pet {
	private String name;
	private String masterName;
	
	public Pet(String name, String masterName) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.name = name;
		this.masterName = masterName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getmasterName() {
		return masterName;
	}
	
	public void introduce() {
		System.out.println("僕の名前は" + name + "です");
		System.out.println("ご主人様は" + masterName + "です");		
	}
}

class RobotPet extends Pet{

	public RobotPet(String name, String masterName) {
		super(name, masterName);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void introduce() {
		System.out.println("私はロボット。名前は" + getName());
		System.out.println("ご主人様は" + getmasterName() + "です。");
	}
}

class Myname extends Pet {

	public Myname(String name, String masterName) {
		super(name, masterName);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void introduce() {
		System.out.println("printNameメソッド　→　" + getName() + " "+ getmasterName());
	}
}