package xyz.noedl.survivalStats.utils;

public class PlayerData {

    private int daysSurvived;
    private int deathCount;

    public PlayerData() {
        this.daysSurvived = 0;
        this.deathCount = 0;
    }

    public PlayerData(int daysSurvived, int deathCount) {
        this.daysSurvived = daysSurvived;
        this.deathCount = deathCount;
    }

    public int getDaysSurvived() {
        return daysSurvived;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void incrementDeathCount() {
        this.deathCount++;
    }

    public void incrementDaysSurvived() {
        this.daysSurvived++;
    }

    public void resetDaysSurvived() {
        this.daysSurvived = 0;
    }
}