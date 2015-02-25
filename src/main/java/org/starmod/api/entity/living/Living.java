package org.starmod.api.entity.living;

public interface Living {

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

}
