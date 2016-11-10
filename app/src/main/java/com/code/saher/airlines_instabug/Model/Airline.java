
package com.code.saher.airlines_instabug.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Airline implements Serializable {

    @SerializedName("__clazz")
    @Expose
    private String clazz;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("defaultName")
    @Expose
    private String defaultName;
    @SerializedName("logoURL")
    @Expose
    private String logoURL;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("usName")
    @Expose
    private String usName;

    /**
     * 
     * @return
     *     The clazz
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * 
     * @param clazz
     *     The __clazz
     */
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The defaultName
     */
    public String getDefaultName() {
        return defaultName;
    }

    /**
     * 
     * @param defaultName
     *     The defaultName
     */
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    /**
     * 
     * @return
     *     The logoURL
     */
    public String getLogoURL() {
        return logoURL;
    }

    /**
     * 
     * @param logoURL
     *     The logoURL
     */
    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The site
     */
    public String getSite() {
        return site;
    }

    /**
     * 
     * @param site
     *     The site
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * 
     * @return
     *     The usName
     */
    public String getUsName() {
        return usName;
    }

    /**
     * 
     * @param usName
     *     The usName
     */
    public void setUsName(String usName) {
        this.usName = usName;
    }

}
