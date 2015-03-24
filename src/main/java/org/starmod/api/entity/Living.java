package org.starmod.api.entity;

/**
 * Represents a living entity on the server.
 */
public interface Living extends Entity {

	/**
	 * Removes health by a given amount.
	 *
	 * @param amount of health to subtract
	 */
	void damage(float amount);

	/**
	 * Returns the amount of health.
	 *
	 * @return current health amount
	 */
	float getHealth();

	/**
	 * Sets the amount of health.
	 *
	 * @param health amount of health
	 */
	void setHealth(float health);

	/**
	 * Returns the maximum amount of health.
	 *
	 * @return the maximum amount of health
	 */
	float getMaxHealth();

	/**
	 * Sets the maximum amount of health.
	 *
	 * @param maxHealth maximum amount of health
	 */
	void setMaxHealth(float maxHealth);

	/**
	 * Returns the last amount of damage dealt.
	 *
	 * @return last amount of damage dealt
	 */
	float getLastDamage();

	/**
	 * Sets the last amount of damage dealt.
	 *
	 * @param lastDamage last damage dealt
	 */
	void setLastDamage(float lastDamage);

	/**
	 * Returns the living entity that last attacked this one.
	 *
	 * @return The last attacker of this entity
	 */
	Living getLastAttacker();

	/**
	 * Sets the last living entity that attacked this one.
	 *
	 * @param lastAttacker the last attacker of this entity
	 */
	void setLastAttacker(Living lastAttacker);

	/**
	 * Returns the total amount of kills since on the server.
	 *
	 * @return total number of kills
	 */
	int getKillCount();

	/**
	 * Sets the total amount of kills since on the server.
	 *
	 * @param kills total number of kills
	 */
	void setKillCount(int kills);

	/**
	 * Return the total amount of times this entity has died since joining the server.
	 *
	 * @return total amount of deaths
	 */
	int getDeathCount();

	/**
	 * Sets the total amount of times this entity has died since joining the server.
	 *
	 * @param deaths total amount of deaths
	 */
	void setDeathCount(int deaths);

}
