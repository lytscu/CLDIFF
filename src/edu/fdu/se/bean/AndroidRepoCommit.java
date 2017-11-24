package edu.fdu.se.bean;

public class AndroidRepoCommit {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column android_repo_commit.id
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column android_repo_commit.commit_id
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    private String commitId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column android_repo_commit.branch_id
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    private Integer branchId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column android_repo_commit.branch_name
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    private String branchName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column android_repo_commit.tag_name
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    private String tagName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column android_repo_commit.commit_log
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    private String commitLog;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table android_repo_commit
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public AndroidRepoCommit(Integer id, String commitId, Integer branchId, String branchName, String tagName, String commitLog) {
        this.id = id;
        this.commitId = commitId;
        this.branchId = branchId;
        this.branchName = branchName;
        this.tagName = tagName;
        this.commitLog = commitLog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table android_repo_commit
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public AndroidRepoCommit() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column android_repo_commit.id
     *
     * @return the value of android_repo_commit.id
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column android_repo_commit.id
     *
     * @param id the value for android_repo_commit.id
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column android_repo_commit.commit_id
     *
     * @return the value of android_repo_commit.commit_id
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public String getCommitId() {
        return commitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column android_repo_commit.commit_id
     *
     * @param commitId the value for android_repo_commit.commit_id
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public void setCommitId(String commitId) {
        this.commitId = commitId == null ? null : commitId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column android_repo_commit.branch_id
     *
     * @return the value of android_repo_commit.branch_id
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public Integer getBranchId() {
        return branchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column android_repo_commit.branch_id
     *
     * @param branchId the value for android_repo_commit.branch_id
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column android_repo_commit.branch_name
     *
     * @return the value of android_repo_commit.branch_name
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column android_repo_commit.branch_name
     *
     * @param branchName the value for android_repo_commit.branch_name
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column android_repo_commit.tag_name
     *
     * @return the value of android_repo_commit.tag_name
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column android_repo_commit.tag_name
     *
     * @param tagName the value for android_repo_commit.tag_name
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column android_repo_commit.commit_log
     *
     * @return the value of android_repo_commit.commit_log
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public String getCommitLog() {
        return commitLog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column android_repo_commit.commit_log
     *
     * @param commitLog the value for android_repo_commit.commit_log
     *
     * @mbg.generated Fri Nov 24 14:31:43 CST 2017
     */
    public void setCommitLog(String commitLog) {
        this.commitLog = commitLog == null ? null : commitLog.trim();
    }
}