/*
	Name: 
	Username: 
*/

public class Hero {
	private String name;
	private String role;
	private int level;
	private int experience;
	private int MAX_LEVEL;
	private String[] ROLES = {"Warrior", "Priest", "Wizard", "Thief"};


	public Hero(String name){
		this.setName(name);
		this.role = "Unassigned";
		this.setLevel(1);
		this.setExperience(0);

	}

	public String getName() {
		return new String(this.name);
	}

	public void setName(String name) {
		this.name = new String(name);
	}

	public String getRole() {
		return new String(this.role);
	}

	public void setRole(String role) {
		for (int i = 0; i < this.ROLES.length; i++) {
			if (this.ROLES[i].compareToIgnoreCase(role) == 0) {
				this.role = new String(role);
				return;
			} else {
				this.role = new String("Unassigned");
			}

		};
		System.out.println("Invalid role");

//		this.role = new String(role);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMAX_LEVEL() {
		return MAX_LEVEL;
	}

	public void setMAX_LEVEL(int MAX_LEVEL) {
		this.MAX_LEVEL = MAX_LEVEL;
	}

	public String[] getROLES() {
		return ROLES.clone();
	}

	public void setROLES(String[] ROLES) {
		this.ROLES = ROLES.clone();
	}
	public int expToLevelUp() {
		return (int) Math.pow(this.getLevel(), 2);
	}
	public void gainExperience(int experience) {
		while (this.getLevel() <= this.MAX_LEVEL) {
			if (this.getExperience() >= this.expToLevelUp()) {
				this.setLevel(this.getLevel() + 1);
				this.setExperience(this.getExperience() - this.expToLevelUp());
			}
		}
	}

	@Override
	public String toString() {
		return "" +
				this.getName() +
				" the " + this.getRole() +
				" is level" + this.getLevel() +
				" with " + this.getExperience() +
				"experience.";
	}
}
