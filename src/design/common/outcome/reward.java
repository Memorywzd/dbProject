package design.common.outcome;

import java.sql.Date;

public class reward {

    private String rewardName;
    private String rewardLevel;
    private String rewardRanking;
    private Date rewardPublishTime;
    private String rewardAttachment;

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardLevel() {
        return rewardLevel;
    }

    public void setRewardLevel(String rewardLevel) {
        this.rewardLevel = rewardLevel;
    }

    public String getRewardRanking() {
        return rewardRanking;
    }

    public void setRewardRanking(String rewardRanking) {
        this.rewardRanking = rewardRanking;
    }

    public Date getRewardPublishTime() {
        return rewardPublishTime;
    }

    public void setRewardPublishTime(Date rewardPublishTime) {
        this.rewardPublishTime = rewardPublishTime;
    }

    public String getRewardAttachment() {
        return rewardAttachment;
    }

    public void setRewardAttachment(String rewardAttachment) {
        this.rewardAttachment = rewardAttachment;
    }


}
