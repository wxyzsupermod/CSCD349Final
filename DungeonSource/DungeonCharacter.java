public abstract class DungeonCharacter extends DungeonEntity {
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin, damageMax;
	private Attack attackStrategy;

	public DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	{
		super (name);
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;

	}

	public void addHitPoints(int hitPoints) {
		if (hitPoints < 0) {
			throw new IllegalArgumentException("hitPoints is negative");
		} else {
			this.hitPoints += hitPoints;
		}
	}

	public void setAttackStrategy(Attack attackStrategy) {
		if (attackStrategy != null) {
			this.attackStrategy = attackStrategy;
		} else {
			throw new IllegalArgumentException("Cannot set attack strategy to null");
		}
	}
	

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public double getChanceToHit() {
		return chanceToHit;
	}

	public void setChanceToHit(double chanceToHit) {
		this.chanceToHit = chanceToHit;
	}

	public int getDamageMin() {
		return damageMin;
	}

	public void setDamageMin(int damageMin) {
		this.damageMin = damageMin;
	}

	public int getDamageMax() {
		return damageMax;
	}

	public void setDamageMax(int damageMax) {
		this.damageMax = damageMax;
	}
	
	public void subtractHitPoints(int hitPoints) {
		if (hitPoints < 0) {
			throw new IllegalArgumentException("hitPoints is negative");
		} else if (hitPoints >0) {
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0) {
				this.hitPoints = 0;
			}
			System.out.println(getName() + " was hit for " + hitPoints + " points of damage, having " + getHitPoints() + " hit points remaining.");
		}
		if (this.hitPoints == 0)
			System.out.println(getName() + " has been defeated!");
	}

    public boolean isAlive() {
    	return hitPoints > 0;
	}

    public int getRandomAttackDamage() {
    	return (int)(Math.random() * (damageMax - damageMin + 1)) + damageMin;
    }

    public void attack(DungeonCharacter opponent) {
		if (attackStrategy == null) {
			throw new IllegalStateException("This character cannot attack because it doesn't have an attackStrategy. Set it with DungeonCharacter.setAttackStrategy()");
		}
		if (Math.random() <= chanceToHit) {
			attackStrategy.attack(this, opponent);
		} else {
			System.out.println(getName() + " missed!");
		}
		System.out.println();
	}
}
