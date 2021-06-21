package com.gvdroid.simple.demo1;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class DownloadRecord {
    public static final int STATUS_ERROR = 0;
    public static final int STATUS_SUCCESS = 1;
    private String uid;
    private String ip;
    private int port;
    private String ua;
    private String fileName;
    private String filePath;
    private long length;
    private int status;
    private Timestamp startTime;
    private Timestamp endTime;

    public DownloadRecord() {
    }

    public DownloadRecord(String fileName, String filePath,
                          HttpServletRequest request) {
        this.uid = UUID.randomUUID().toString().replace("-","");
        this.fileName = fileName;
        this.filePath = filePath;
        this.ip = request.getRemoteAddr();
        this.port = request.getRemotePort();
        this.ua = request.getHeader("user-agent");
        this.startTime = new Timestamp(System.currentTimeMillis());
    }


}
