package org.tartea.note.dto;

/**
 * 腾讯云配置
 *
 * @Author: jiawenhao
 * @Date: 2022-06-21  22:18
 */
public class TencentCosConfig {

    private String accessKey;

    private String secretKey;

    /**
     * 存储区域
     */
    private String regionName;
    /**
     * 桶名称
     */
    private String bucketName;

    /**
     * 存储路径
     */
    private String savePath;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
