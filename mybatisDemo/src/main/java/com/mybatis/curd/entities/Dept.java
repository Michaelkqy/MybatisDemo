package com.mybatis.curd.entities;

import java.util.Date;

public class Dept {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept.did
     *
     * @mbg.generated
     */
    private Integer did;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept.dname
     *
     * @mbg.generated
     */
    private String dname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept.comments
     *
     * @mbg.generated
     */
    private String comments;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept.ts
     *
     * @mbg.generated
     */
    private Date ts;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept.did
     *
     * @return the value of dept.did
     *
     * @mbg.generated
     */
    public Integer getDid() {
        return did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept.did
     *
     * @param did the value for dept.did
     *
     * @mbg.generated
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept.dname
     *
     * @return the value of dept.dname
     *
     * @mbg.generated
     */
    public String getDname() {
        return dname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept.dname
     *
     * @param dname the value for dept.dname
     *
     * @mbg.generated
     */
    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept.comments
     *
     * @return the value of dept.comments
     *
     * @mbg.generated
     */
    public String getComments() {
        return comments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept.comments
     *
     * @param comments the value for dept.comments
     *
     * @mbg.generated
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept.ts
     *
     * @return the value of dept.ts
     *
     * @mbg.generated
     */
    public Date getTs() {
        return ts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept.ts
     *
     * @param ts the value for dept.ts
     *
     * @mbg.generated
     */
    public void setTs(Date ts) {
        this.ts = ts;
    }
}